/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openxdata.model.FormData;
import org.openxdata.model.FormDef;
import org.openxdata.model.QuestionData;
import org.openxdata.model.StudyData;
import org.openxdata.model.StudyDataList;
import org.openxdata.modules.workflows.model.shared.WorkItemQuestion;
import org.openxdata.modules.workflows.server.context.WFContext;
import org.openxdata.modules.workflows.server.service.MapService;
import org.openxdata.modules.workflows.server.service.WorkItemsService;
import org.openxdata.server.Context;
import org.openxdata.server.admin.model.FormDefVersion;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.serializer.KxmlSerializerUtil;
import org.openxdata.server.serializer.KxmlXformSerializer;
import org.openxdata.server.service.DataExportService;
import org.openxdata.server.service.FormDownloadService;
import org.openxdata.workflow.mobile.model.MWorkItemData;
import org.openxdata.workflow.mobile.model.MWorkItemDataList;
import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;

/**
 * Handles upload of workItemData and calling the yawl service to submit the
 * the completed workItems.Data is extracted from workItemData and
 * save locally.Then required data for a specific workItem is extracted and sent
 * to the YAWL engine
 * @author kay
 */
@SuppressWarnings("UseOfObsoleteCollectionType")
public class WIRUploadHandler implements RequestHandler
{

        private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());
        private FormDownloadService formDownloadService;
        private KxmlXformSerializer serialiser;
        private MapService mapService;
        private WorkItemsService wirService;
        private DataExportService exportService;
        private Map<Integer, String> xformMap;

        public WIRUploadHandler()
        {
                serialiser = new KxmlXformSerializer();
                mapService = WFContext.getSpecStudyService();
                formDownloadService = WFContext.getFormDownloadService();
                wirService = WFContext.getWorkItemsService();
                exportService = (DataExportService) Context.getBean("dataExportService");
                xformMap = formDownloadService.getFormsVersionXmlMap();
        }

        @Override
        public void handleRequest(User user, InputStream is, OutputStream os) throws IOException
        {
                try {
                        HandlerStreamUtil streamHelper = new HandlerStreamUtil(is, os);

                        MWorkItemDataList wirDataList = new MWorkItemDataList();
                        streamHelper.read(wirDataList);//read the mworktem datalist from the stream

                        processUpload(user, wirDataList);

                        streamHelper.writeSucess();
                        streamHelper.flush();
                } catch (Exception ex) {
                        Logger.getLogger(WIRUploadHandler.class.getName()).log(Level.SEVERE, null, ex);
                        throw new RuntimeException(ex);
                }
        }

        public void processUpload(User user, MWorkItemDataList wirDataList)
        {
                Vector dataList = wirDataList.getDataList();
                for (Object object : dataList) {
                        MWorkItemData wirDat = (MWorkItemData) object;
                        saveXFormData(user, wirDat);//extract xform data and save it locally
                        processWorkItemData(user, wirDat);//extract workItem data and send it to yawl
                }
        }

        /**
         * Extracts the xform data from the workItem data then calls saves the form
         * data locally
         * @param user user who has submitted the form data
         * @param wirDat workItemdata to submit
         */
        public void saveXFormData(User user, MWorkItemData wirDat)
        {
                List<String> xformModels = deserialise(wirDat.getFormData());
                for (String xformModel : xformModels) {
                        formDownloadService.saveFormData(xformModel, user, new Date());
                }
        }

        /**
         * Deserialises study data to an xform model.
         * @param data
         * @return
         */
        private List<String> deserialise(StudyDataList data)
        {
                List<String> xmlForms = new ArrayList<String>();
                try {
                        Vector<StudyData> studies = data.getStudies();
                        Method deserialiseMethod = KxmlXformSerializer.class.getDeclaredMethod("deSerialize", StudyData.class, List.class, Map.class);
                        deserialiseMethod.setAccessible(true);

                        for (StudyData studyData : studies) {
                                try {
                                        deserialiseMethod.invoke(serialiser, studyData, xmlForms, xformMap);
                                } catch (Exception x) {
                                       log.error("Error while deserialising study data id: "+studyData.getId(),x);
                                }
                        }
                } catch (Exception ex) {
                       log.error(ex);
                        throw new RuntimeException(ex);
                }
                return xmlForms;
        }

        /**
         * Extracts the question answers for output that were matched to output parameters
         * and submits them to the yawl engine.
         * @param user
         * @param wirDat
         */
        private void processWorkItemData(User user, MWorkItemData wirDat)
        {
                //Get the workItem associates with this workitem data so that you use it to
                //get the output parameters.Output parameter values are suppposed to be
                //submitted back to the Yawl engine
                WorkItemRecord workitem = wirService.getWorkitem(wirDat.getCaseId(), wirDat.getTaskId());
                //Get a  map of <ParameterName> - <QuestionVariableName>
                Map<String, String> paramQnMap = mapService.getOutPutParamQuestionMap(wirDat.getFormId(), workitem);

                //Get the form variable name for this data
                //We need this because it is used to extract specific question
                //answers from the formData i.e  a question variable is in the format
                // /<formvarname>/<questionvariable>
                String formVarName = getMatchingMobileFormDef(wirDat).getVariableName();



                //For each output parameter of the workitem we have to fing the correspoding
                //answer from formdata.The <param> - <questionvariable> map will help get
                //the exact answer for each parameter.
                List<WorkItemQuestion> qnList = new ArrayList<WorkItemQuestion>();
                for (Entry<String, String> paramQnEntry : paramQnMap.entrySet()) {
                        FormData mobileFormData = wirDat.getFormDataData();
                        QuestionData question = mobileFormData.getQuestion("/" + formVarName + "/" + paramQnEntry.getValue());
                        if(question == null) {
                                log.warn("ParamQuestion entry form ["+formVarName + "] workItem"
                                        + " ["+workitem.getID()
                                        + "] = "+paramQnEntry.toString()+" Has no corresponding quetsion");
                                continue;
                        }//To continue.. Wrong entry
                        WorkItemQuestion qn = new WorkItemQuestion(paramQnEntry.getKey(), question.getTextAnswer());
                        qnList.add(qn);
                }

                wirService.submitWorkItem(workitem, qnList);
        }
        private HashMap<Integer, FormDef> formDefVersionCache = new HashMap<Integer, FormDef>();

        private FormDef getMatchingMobileFormDef(MWorkItemData wirDat)
        {
                int formId = wirDat.getFormId();
                FormDef fDef = formDefVersionCache.get(formId);
                if (fDef == null) {
                        FormDefVersion formDefVersion = exportService.getFormDefVersion(formId);
                        fDef = KxmlSerializerUtil.fromXform2FormDef(new StringReader(formDefVersion.getXform()));
                        formDefVersionCache.put(formId, fDef);
                }
                return fDef;
        }
}
