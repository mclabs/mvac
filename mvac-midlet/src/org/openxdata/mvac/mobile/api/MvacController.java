/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.mvac.mobile.api;

import com.sun.lwuit.Display;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import java.util.Date;
import java.util.Vector;
import org.openxdata.communication.TransportLayerListener;
import org.openxdata.db.OpenXdataDataStorage;
import org.openxdata.db.util.Persistent;
import org.openxdata.db.util.StorageListener;
import org.openxdata.model.FormData;
import org.openxdata.model.FormDef;
import org.openxdata.model.OpenXdataConstants;
import org.openxdata.model.PageData;
import org.openxdata.model.QuestionData;
import org.openxdata.model.ResponseHeader;
import org.openxdata.model.SkipRule;
import org.openxdata.model.StudyDef;
import org.openxdata.model.StudyDefList;
import org.openxdata.model.UserListStudyDefList;
import org.openxdata.mvac.communication.MvacTransportLayer;
import org.openxdata.mvac.mobile.DownloadManager;
import org.openxdata.mvac.mobile.db.WFStorage;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.view.api.IView;
import org.openxdata.mvac.mobile.view.FBProgressIndicator;
import org.openxdata.workflow.mobile.model.MQuestionMap;
import org.openxdata.workflow.mobile.model.MWorkItem;

/**
 *
 * @author soyfactor
 */
public class MvacController implements TransportLayerListener,ActionListener,StorageListener{

    private ViewFactory viewFactory;
    private FormUtil formutil;
    private FormDef formDef;
    private FormData formData;
    private MWorkItem wir;
    private IView activatingView;
    
    FBProgressIndicator progress;
    private MvacTransportLayer transportlayer;
    private DownloadManager dwnLdMgr;
    private boolean isupload;

    private PageData currentPage; //TODO is this really necessary????

    //for managing state
    private int currentPageIndex = OpenXdataConstants.NO_SELECTION;
    private int currentQuestionIndex = OpenXdataConstants.NO_SELECTION;
    private QuestionData currentQuestion = null;
    
    /** Keeps a mapping of displayed questions (in a page) to their indices in the list control.
     *  We were originally using the questions collection of the page in formdata which
     *  did not work as their indices get out of sync with those of the List control
     *  because of invisible questions not being put in the list.
     */
    private Vector displayedQuestions;
    private Vector prefilledQuestions=new Vector(0);

    private IView parent;

    private boolean dirty = false;

    public MvacController() {
        System.out.println("init view fac");
        viewFactory = new ViewFactory();
        System.out.println("init form util");
        formutil = new FormUtil();
        transportlayer = new MvacTransportLayer();
        dwnLdMgr = new DownloadManager(transportlayer);

    }

    public DownloadManager getDM(){
            return dwnLdMgr;
        
    }

    public void initItems(FormData formData){
        currentPageIndex = 0;
        currentQuestionIndex = 0;
        currentQuestion = null;
        displayedQuestions = new Vector();
        dirty = false;

        Vector pages = formData.getPages();
        System.out.println("Size of pages=>"+pages.size());
        //we will always heave one page for this app.
        //makes my life simpler
        currentPage = (PageData)pages.elementAt(0);
        int numQuestions = currentPage.getNumberOfQuestions();

        System.out.println("Size of questions=>"+numQuestions);

        Vector qtns = currentPage.getQuestions();
        QuestionData qd;

        for (int i = 0; i < qtns.size(); i++) {
            qd=(QuestionData)qtns.elementAt(i);
            if(qd.getDef().isVisible()&&ifForDisplay(qd)){
                displayedQuestions.addElement(qd);

            }

        }
//        System.out.println("About to select Question");
//        if (displayedQuestions.size()>0) {
//            System.out.println("Selecting question");
//                selectNextQuestion(currentQuestionIndex);
//
//
//        }
        
    }

    public Vector getDisplayQues(){
        return displayedQuestions;
    }


    public void setWorkItem(MWorkItem wir,IView parent){
         this.wir=wir;
         this.parent = parent;
        //this.wir.setPrefilledQns(displayedQuestions)getStudyId();
        if(formutil.getFormDef(this.wir)==null){
    System.out.println("@ MvacController : setWorkItem : Null");

            downloadForm();

            return;
        }


        

    }


    public boolean newsetWorkItem(MWorkItem wir,IView parent){
         this.wir=wir;
         this.parent = parent;
        //this.wir.setPrefilledQns(displayedQuestions)getStudyId();
        if(formutil.getFormDef(this.wir)==null){
    System.out.println("@ MvacController : setWorkItem : Null");

            //downloadForm();

            return false;
        }else{
             return true;
        }




    }

    public void afterSetWorkItems(MWorkItem wir,IView parent){
        formDef = formutil.getFormDef(this.wir);
        formData = formutil.getFormData(formDef, this.wir);
        this.wir.setDataRecId(new Integer(formData.getRecordId()));
        formutil.saveMworkItem(this.wir);
        beforeFormDisplay(formData);
        initItems(formData);
    }

    public void lastScreen(){
        if(parent!=null){
                parent.resume(null);
            }else{
                //do nothing. never gon happen
            }
    }

    public void showform(MWorkItem wir) {


        this.wir=wir;
        //this.wir.setPrefilledQns(displayedQuestions)getStudyId();
        if(formutil.getFormDef(this.wir)==null){
            downloadForm();
            return;
        }
        formDef = formutil.getFormDef(this.wir);
        System.out.println("formdef=>"+formDef);
        System.out.println("wIR=>"+wir);
        System.out.println("wIR STUDY=>"+wir.getStudyId());
        formData = formutil.getFormData(formDef, this.wir);
        System.out.println("This is the form data RecordID-->"+formData.getRecordId());
        this.wir.setDataRecId(new Integer(formData.getRecordId()));
        formutil.saveMworkItem(this.wir);
        boolean displayForm = beforeFormDisplay(formData);
        if(displayForm){
            FireSkipRules(formData);
            showForm(formData);
            

        }
        
        //AppUtil.get().setView(viewFactory.getView(null, 1));
    }
    
    public void downloadForm(){
        progress = new FBProgressIndicator(this,"Downloading associated studies...");
        progress.show();


        new BackgroundTask() {

            public void performTask() {
                
                dwnLdMgr.downloadStudies(MvacController.this);
                
                //dwnLdMgr.uploadWorkItems(null);
            }

            public void taskStarted() {
                System.out.println("My task is started");
            }





        }.start();

    }

    


    public void uploadData(IView activatingView){
        this.activatingView = activatingView;
        this.isupload=true;
        progress = new FBProgressIndicator(this,"Uploading Data...");
        progress.showModeless();
        new BackgroundTask() {

            public void performTask() {
                dwnLdMgr.uploadWorkItems(MvacController.this);
                //dwnLdMgr.uploadWorkItems(null);
            }

            public void taskStarted() {
            }



        }.start();

    }


    /** Fires rules in the form. */
	private void FireSkipRules(FormData formData){
		Vector rules = formData.getDef().getSkipRules();
		if(rules != null && rules.size() > 0){
			for(int i=0; i<rules.size(); i++){
				//EpiHandySkipRule rule = (EpiHandySkipRule)rules.elementAt(i);
				SkipRule rule = (SkipRule)rules.elementAt(i);
				rule.fire(formData);
			}
		}
	}
    

    public boolean beforeFormDisplay(FormData frmData) {

        // Do form prefilling before the form is displayed
        String formName     = frmData.getDef().getVariableName();
        Vector prefilledQns = this.wir.getPrefilledQns();

        for (int i = 0; i < prefilledQns.size(); i++) {
            MQuestionMap qnMap        = (MQuestionMap) prefilledQns.elementAt(i);
            String       questionName = "/" + formName + "/" + qnMap.getQuestion();
            QuestionData qnData       = frmData.getQuestion(questionName);

            qnData.setTextAnswer(qnMap.getValue());

            if (qnMap.isOutput()) {
                qnData.getDef().setEnabled(true);
            } else {
                qnData.getDef().setEnabled(false);
            }
        }

        return true;
    }
    
    private void updateFormDataNew(){
        //FormData frmData=new FormData(this.formData);
        PageData mypage=null;

        Vector pages = formData.getPages();
        //System.out.println("Size of pages=>"+pages.size());
        //we will always heave one page for this app.
        //makes my life simpler
        mypage = (PageData)pages.elementAt(0);
        int numQuestions = mypage.getNumberOfQuestions();

        System.out.println("Size of questions=>"+numQuestions);

        Vector qtns = mypage.getQuestions();
        QuestionData qd;

        for(int w=0;w<displayedQuestions.size();w++){
            currentQuestion = (QuestionData)displayedQuestions.elementAt(w);
            for (int i = 0; i < qtns.size(); i++) {
            
            qd=(QuestionData)qtns.elementAt(i);
            System.out.println("Showing text=>"+qd.getText());
            System.out.println("Expected text=>"+currentQuestion.getText());
            if(qd.getId()==currentQuestion.getId()){
                System.out.println("Setting answer hurra!=>"+currentQuestion.getTextAnswer());
                QuestionData tmp = new QuestionData((QuestionData)qtns.elementAt(i));
                tmp.setTextAnswer(currentQuestion.getTextAnswer());

                qtns.setElementAt(tmp, i);
                System.out.println("Set answer hurra!=>"+(((QuestionData)qtns.elementAt(i)).getTextAnswer()));
                break;
            }
            

        }
        }
        
        mypage.setQuestions(qtns);
        pages.setElementAt(mypage, 0);
        formData.setPages(pages);

    }

    private void updateFormData(){
        //FormData frmData=new FormData(this.formData);
        PageData mypage=null;

        Vector pages = formData.getPages();
        //System.out.println("Size of pages=>"+pages.size());
        //we will always heave one page for this app.
        //makes my life simpler
        mypage = (PageData)pages.elementAt(0);
        int numQuestions = mypage.getNumberOfQuestions();

        System.out.println("Size of questions=>"+numQuestions);

        Vector qtns = mypage.getQuestions();
        QuestionData qd;

        for (int i = 0; i < qtns.size(); i++) {
            qd=(QuestionData)qtns.elementAt(i);
            System.out.println("Showing text=>"+qd.getText());
            System.out.println("Expected text=>"+currentQuestion.getText());
            if(qd.getId()==currentQuestion.getId()){
                System.out.println("Setting answer hurra!=>"+currentQuestion.getTextAnswer());
                QuestionData tmp = new QuestionData((QuestionData)qtns.elementAt(i));
                tmp.setTextAnswer(currentQuestion.getTextAnswer());

                qtns.setElementAt(tmp, i);
                System.out.println("Set answer hurra!=>"+(((QuestionData)qtns.elementAt(i)).getTextAnswer()));
                break;
            }
            

        }
        mypage.setQuestions(qtns);
        pages.setElementAt(mypage, 0);
        formData.setPages(pages);

    }

    private void updateFormDatab(){
        System.out.println("Variable Name:->"+currentQuestion.getDef().getVariableName());
        System.out.println("Text Answer:->"+currentQuestion.getTextAnswer());
        formData.setValue(currentQuestion.getDef().getVariableName(), currentQuestion.getTextAnswer());

    }
    
    private void updateWirNew(){
        // Do form prefilling before the form is displayed
        String formName     = formData.getDef().getVariableName();
        Vector prefilledQns = this.wir.getPrefilledQns();

        for(int w=0;w<displayedQuestions.size();w++){
            currentQuestion = (QuestionData)displayedQuestions.elementAt(w);
                for (int i = 0; i < prefilledQns.size(); i++) {
                MQuestionMap qnMap        = (MQuestionMap) prefilledQns.elementAt(i);
                String       questionName = "/" + formName + "/" + qnMap.getQuestion();
                QuestionData qnData       = formData.getQuestion(questionName);

                if(qnData.getId()==currentQuestion.getId()){
                    System.out.println("Updating wir hurra!=>"+currentQuestion.getTextAnswer());

                    qnMap.setValue(currentQuestion.getTextAnswer());
                    prefilledQns.setElementAt(qnMap, i);
                    System.out.println("Wir updated to-->"+ ((MQuestionMap) prefilledQns.elementAt(i)).getValue());
                    break;
                }

            }
            
        }
        
        this.wir.setPrefilledQns(prefilledQns);
        formutil.saveMworkItem(this.wir);

    }

    private void updateWir(){
        // Do form prefilling before the form is displayed
        String formName     = formData.getDef().getVariableName();
        Vector prefilledQns = this.wir.getPrefilledQns();

        for (int i = 0; i < prefilledQns.size(); i++) {
            MQuestionMap qnMap        = (MQuestionMap) prefilledQns.elementAt(i);
            String       questionName = "/" + formName + "/" + qnMap.getQuestion();
            QuestionData qnData       = formData.getQuestion(questionName);

            if(qnData.getId()==currentQuestion.getId()){
                System.out.println("Updating wir hurra!=>"+currentQuestion.getTextAnswer());

                qnMap.setValue(currentQuestion.getTextAnswer());
                prefilledQns.setElementAt(qnMap, i);
                System.out.println("Wir updated to-->"+ ((MQuestionMap) prefilledQns.elementAt(i)).getValue());
                break;
            }

        }
        this.wir.setPrefilledQns(prefilledQns);
        formutil.saveMworkItem(this.wir);

    }

    private void showSavedValues(){
        
    }

    

    /** Saves the current form data. */
	public void saveFormData(){
                System.out.println("Saving the form -->"+formData.getRecordId());
		formData.setDateValue("/"+this.formDef.getVariableName()+"/endtime", new Date());
                System.out.println("MY Study ID=>"+getStudyFromForm(this.formDef).getId());
		if (OpenXdataDataStorage.saveFormData(this.wir.getStudyId(),formData)) {
                    System.out.println("Saved the damn form data");

		}else{
                    System.out.println("Failed to save the damn form data");
                }
	}

        private StudyDef getStudyFromForm(FormDef formDef) {
		StudyDef returnStudy = null;
                StudyDefList studyDefList = OpenXdataDataStorage.getStudyList();
		if (formDef != null) {
			Vector studies = studyDefList.getStudies();
			for (byte i=0; i<studies.size(); i++) {
				StudyDef sd = (StudyDef)studies.elementAt(i);
				if (sd.getForm(formDef.getId()) != null) {
					returnStudy = sd;
					break;
				}
			}
		}
		if (returnStudy == null) {
			System.out.println("Could not find Study, so using first in the list");
			returnStudy = studyDefList.getFirstStudy();
		}
		return returnStudy;
	}

    public void saveQtnData(QuestionData qtnData) {
        //save the question data here
        currentQuestion=qtnData;
        displayedQuestions.setElementAt(currentQuestion, currentQuestionIndex);
        updateFormData();
        updateWirNew();
        saveFormData();

    }
    
    public void saveQtnDataFromForm(Vector displayedQues, MWorkItem wir) {
        //save the question data here
        this.wir=wir;
        formutil = new FormUtil();
        formDef = formutil.getFormDef(this.wir);
        formData = formutil.getFormData(formDef, this.wir);
                
                
        displayedQuestions = displayedQues;
        updateFormDataNew();
        updateWir();
        saveFormData();

    }

    public void nextQtn(QuestionData qdata) {
        //move to next
        saveQtnData(qdata);
        currentQuestionIndex++;
        if (currentQuestionIndex>=displayedQuestions.size()) {
            currentQuestionIndex=0;

        }
        selectNextQuestion(currentQuestionIndex);

    }

    public void prevQtn(QuestionData qdata) {
        //move to prev
        saveQtnData(qdata);
        currentQuestionIndex--;
        if(currentQuestionIndex<0){
            currentQuestionIndex=displayedQuestions.size()-1;

        }
        selectNextQuestion(currentQuestionIndex);
    }

    public void nextPage() {
        //move to next page
    }

    public void prevpage() {
        //move to prev page
    }

    private void showForm(FormData formData) {
        currentPageIndex = 0;
        currentQuestionIndex = 0;
        currentQuestion = null;
        displayedQuestions = new Vector();
        dirty = false;

        Vector pages = formData.getPages();
        System.out.println("Size of pages=>"+pages.size());
        //we will always heave one page for this app.
        //makes my life simpler
        currentPage = (PageData)pages.elementAt(0);
        int numQuestions = currentPage.getNumberOfQuestions();

        System.out.println("Size of questions=>"+numQuestions);
        
        Vector qtns = currentPage.getQuestions();
        QuestionData qd;

        for (int i = 0; i < qtns.size(); i++) {
            qd=(QuestionData)qtns.elementAt(i);
            if(qd.getDef().isVisible()&&ifForDisplay(qd)){
                displayedQuestions.addElement(qd);

            }

        }
        System.out.println("About to select Question");
        if (displayedQuestions.size()>0) {
            System.out.println("Selecting question");
                selectNextQuestion(currentQuestionIndex);


        }

        
    }

    public boolean ifForDisplay(QuestionData qd){
        String text =  qd.getText();
        ///*||text.equalsIgnoreCase("Reason for not Immunizing")*/
        if(text.equals("Lot Number")||text.equals("Date of Immunization") ||text.equals("Status")||text.equals("Notes")){
            return true;
        }else{
            return false;
        }

    }

    /**
	 * Selects the next question to edit.
	 *
	 * @param currentQuestionIndex - index of the current question to edit
	 */
	public void selectNextQuestion(int currentQuestionIndex){
            currentQuestion = (QuestionData)displayedQuestions.elementAt(currentQuestionIndex);
            getView(currentQuestion);
        }

        private void getView(QuestionData qtn){
            byte type =qtn.getDef().getType();
            IView qtnView = viewFactory.getView(qtn, type);
            AppUtil.get().setView(qtnView);


        }

    public void cancelled() {
    }

    public void downloaded(Persistent dataOutParams, Persistent dataOut)  {
System.out.println("@ downloaded");
        progress.dispose();
        
                ResponseHeader rh = (ResponseHeader) dataOutParams;
                if (!rh.isSuccess()) {
                    return;
                } else if (dataOut instanceof UserListStudyDefList) {
        System.out.println("Saving the forms");
                    handleStudyAndUserDownloaded((UserListStudyDefList) dataOut);
                }
                if(this.isupload){
                    WFStorage.deleteCompleteWorkItems(this, false);
                    if(activatingView!=null){
                        activatingView.resume(null);
                        this.isupload=false;
                    }
                }else{
                    /****
                     * Was showing immediately after download - This is a fix
                     */
                     //doafterSetWorkItems();
                    //showform(this.wir);
                    //lastScreen();
                }

        

    }

    public void errorOccured(String string, Exception excptn) {
    }

    public void updateCommunicationParams() {
    }

    public void uploaded(Persistent dataOutParams, Persistent dataOut) {
        ResponseHeader rh = (ResponseHeader) dataOutParams;
        System.out.println("In upload=>"+rh.isSuccess());
                if (rh.isSuccess()) {
                        WFStorage.deleteCompleteWorkItems(this, true);
                }
        if (activatingView!=null) {
            activatingView.resume(null);

        }
    }

    public void actionPerformed(ActionEvent ae) {
    }

    private void handleStudyAndUserDownloaded(UserListStudyDefList userListStudyDefList) {
                WFStorage.saveUserListStudyDefList(userListStudyDefList);
    }

    public abstract class BackgroundTask {
        /**
         * Start this task
         */
        public final void start() {
            if (Display.getInstance().isEdt()) {
                taskStarted();
            } else {
                Display.getInstance().callSeriallyAndWait(new Runnable() {

                    public void run() {
                        taskStarted();
                    }
                });
            }
            new Thread(new Runnable() {

                public void run() {
                    if (Display.getInstance().isEdt()) {
                        taskFinished();
                    } else {
                        performTask();
                        Display.getInstance().callSerially(this);
                    }
                }
            }).start();
        }

        /**
         * Invoked on the LWUIT EDT before spawning the background thread, this allows
         * the developer to perform initialization easily.
         */
        public void taskStarted() {

        }

        /**
         * Invoked on a separate thread in the background, this task should not alter
         * UI except to indicate progress.
         */
        public abstract void performTask();

        /**
         * Invoked on the LWUIT EDT after the background thread completed its
         * execution.
         */
        public void taskFinished() {
        }
    }

        
}
