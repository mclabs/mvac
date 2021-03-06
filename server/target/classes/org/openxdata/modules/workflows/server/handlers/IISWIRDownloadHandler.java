/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.handlers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jdom.Document;
import org.jdom.Element;
import org.openxdata.immunizations.server.util.Constants;
import org.openxdata.model.QuestionData;
import org.openxdata.modules.workflows.model.shared.WorkItemQuestion;
import org.openxdata.modules.workflows.server.YawlOXDCustomService;
import org.openxdata.server.Context;
import org.openxdata.server.admin.model.StudyDef;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.service.SettingService;
import org.openxdata.server.service.StudyManagerService;
import org.openxdata.workflow.mobile.model.MQuestionMap;
import org.openxdata.workflow.mobile.model.MWorkItem;
import org.yawlfoundation.yawl.util.JDOMUtil;


/**
 *
 * @author gmimano
 * @author kay
 */
public class IISWIRDownloadHandler implements RequestHandler {
    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());
    private SettingService settingService;
    private StudyManagerService studyService;
    private StudyDef iis_Study;
    private org.openxdata.server.admin.model.FormDef appointMentForm;

    public IISWIRDownloadHandler() {
        settingService = (SettingService) Context.getBean("settingService");
        studyService = (StudyManagerService) Context.getBean("studyManagerService");
        setIIS_STudyAndForm();
        
    }

    //Constructor.. simply to help me do some unit tests 
    public IISWIRDownloadHandler(boolean kk) {
    }

    @Override
    public void handleRequest(User user, InputStream is, OutputStream os, Hashtable args) throws IOException {
        try {
            //Get the appointments from IIS
        	String nurse = (String)args.get(Constants.NURSE_NAME);
        	String date = (String)args.get(Constants.DOWNLOAD_DATE);
            String appoint = getAppointMentXML(nurse, date);
            //Parse the apponintments XML and convert them to mWorkitems
            Vector<MWorkItem> workItems = toMWorkItems(appoint);

            log.debug("Downloading workitems for User: " + user.getName());
            HandlerStreamUtil streamHelper = new HandlerStreamUtil(is, os);
            streamHelper.writeSucess();
            streamHelper.writeSmallVector(new Vector(workItems));
            streamHelper.flush();
        } catch (URISyntaxException ex) {
            Logger.getLogger(WIRDownloadHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getAppointMentXML(String nurse, String date) throws URISyntaxException, IOException {
        URI uri = buildUrl(nurse, date);

        HttpClient client = new DefaultHttpClient();
        log.debug("Executing URL for Server...");
        HttpResponse response = client.execute(new HttpGet(uri));
       

        StatusLine statusLine = response.getStatusLine();
        if (statusLine.getStatusCode() != 200) {
            log.error("HTTP: Error Code: " + statusLine.getStatusCode() + " " + statusLine.getReasonPhrase());
            return null;
        }
        log.debug("Connected to IIS...");
        InputStream content = response.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(content));
        log.debug("Reading Response from IIS.....");
        String xmlResponse = IOUtils.toString(reader);
        log.debug("Received Reponse from IIS..."+xmlResponse.substring(0, 100));
        return xmlResponse;
    }

    public URI buildUrl(String nurse, String date) throws URISyntaxException {
        //http://158.38.65.147/iis.mobile/Appointment.ashx?username=Berdice&date=2011-07-01
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();
        qparams.add(new BasicNameValuePair("username", nurse));
        qparams.add(new BasicNameValuePair("date", date));
        URI uri = URIUtils.createURI("http", "158.38.65.147", 80, "/iis.mobile/Appointment.ashx",
                URLEncodedUtils.format(qparams, "UTF-8"), null);
        HttpGet httpget = new HttpGet(uri);
        log.debug(httpget.getURI());
        return uri;
    }

    public Vector<MWorkItem> toMWorkItems(String appoint) {
        Document document = JDOMUtil.stringToDocument(appoint);
        List<Element> children = document.getRootElement().getChildren("Appointments");

        Vector<MWorkItem> workItemList = new Vector<MWorkItem>();
        for (Element appintmentElemet : children) {
            MWorkItem wir = new MWorkItem();
            List<WorkItemQuestion> workItemQuestions = YawlOXDCustomService.createQuestionListFromXML(appintmentElemet);
            Vector<MQuestionMap> quenMaps = toQuestionMaps(workItemQuestions);
            wir.setPrefilledQns(quenMaps);
            workItemList.add(wir);

            setStudyAndCaseAttributes(wir);
        }
        return workItemList;
    }

    private Vector<MQuestionMap> toQuestionMaps(List<WorkItemQuestion> workItemQuestions) {
        Vector<MQuestionMap> quenMaps = new Vector<MQuestionMap>();
        for (WorkItemQuestion workItemQuestion : workItemQuestions) {
            MQuestionMap map = new MQuestionMap();

            map.setQuestion(workItemQuestion.getQuestion());
            map.setValue(workItemQuestion.getAnswer());
            map.setParameter(workItemQuestion.getQuestion());
            quenMaps.add(map);
        }
        return quenMaps;
    }

    private void setStudyAndCaseAttributes(MWorkItem wir) {
        wir.setStudyId(iis_Study != null ? iis_Study.getId() : 0);
        wir.setFormId(appointMentForm != null ? appointMentForm.getDefaultVersion().getId() : 0);
        //Here I set the case ID and taskiD with appoint_id and dose_id to enable uniquely identinfying the
        //MWorkitems uniquely.. Its hack but am sure u can find a way around  this
        //TODO: *Ha! need to fix the hack

		Vector prefilledQns = wir.getPrefilledQns();
		for (int i = 0; i < prefilledQns.size(); i++) {
			MQuestionMap qnMap = (MQuestionMap) prefilledQns.elementAt(i);
			String questionName = qnMap.getParameter();
			log.debug("PARAMETER Reponse from IIS..."+qnMap.getParameter());
			if (questionName!=null&&questionName.equals("appointment_id")) {
				wir.setCaseId(qnMap.getValue());
			}else if (questionName!=null&&questionName.equals("dose_id")) {
				wir.setTaskId(qnMap.getValue());
			}else if (questionName!=null&&questionName.equals("child_name")) {
				wir.setTaskName(questionName);
			}
			
		}
        //wir.setCaseId(wir.getParam("appointment_id").getValue());
        //wir.setTaskId(wir.getParam("dose_id").getValue());
    }

    /**
     * Initialises the study and formDef for this workItem
     */
    private void setIIS_STudyAndForm() {
        //Get the IIS studyName from the setting service
        String studName = settingService.getSetting("iis.study");
        System.out.println("Appointment Study:->"+studName);
        List<StudyDef> studies = studyService.getStudies();
        for (StudyDef studyDef : studies) {
        	System.out.println("STUDY NAME:->"+studyDef.getName());
            if (studyDef.getName().equals(studName)) {
                iis_Study = studyDef;
                break;
            }
        }
        //Get the Appoitment from from the setting Service
        String apptMentFormName = settingService.getSetting("appointment.form");
        System.out.println("Appointment Form:->"+apptMentFormName);
        if (iis_Study == null) {
            return;
        }
        List<org.openxdata.server.admin.model.FormDef> forms = iis_Study.getForms();
        for (org.openxdata.server.admin.model.FormDef formDef : forms) {
        	System.out.println("FORM NAME:->"+formDef.getName());
            if (formDef.getName().equals(apptMentFormName)) {
                appointMentForm = formDef;
                break;
            }
        }
    }
    
}
