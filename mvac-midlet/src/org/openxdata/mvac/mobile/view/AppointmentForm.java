/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Button;
import com.sun.lwuit.ComboBox;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.TextField;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.events.DataChangedListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.DefaultListCellRenderer;
import com.sun.lwuit.plaf.Border;
import com.sun.lwuit.plaf.Style;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Display;
import org.openxdata.communication.TransportLayerListener;
import org.openxdata.db.util.Persistent;
import org.openxdata.db.util.StorageListener;
import org.openxdata.model.FormData;
import org.openxdata.model.FormDef;
import org.openxdata.model.PageData;
import org.openxdata.model.QuestionData;
import org.openxdata.model.UserListStudyDefList;
import org.openxdata.mvac.mobile.DownloadManager;
import org.openxdata.mvac.mobile.api.FormUtil;
import org.openxdata.mvac.mobile.api.MvacController;
import org.openxdata.mvac.mobile.db.WFStorage;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.Constants;
import org.openxdata.mvac.mobile.util.view.api.IView;
import org.openxdata.mvac.mobile.view.date.DateField;
import org.openxdata.mvac.mobile.view.widgets.CalendarCanvas;
import org.openxdata.mvac.mobile.view.widgets.LWUITCalendarForm;
import org.openxdata.workflow.mobile.model.MWorkItem;

/**
 *
 * @author soyfactor
 */
public class AppointmentForm extends  Form implements IView,StorageListener,ActionListener, TransportLayerListener{
    private QuestionListObj[] ques;
    
    private IView parent;
    private MWorkItem wir;
    private Vector dipslayedQues=new Vector(0);
    private DownloadManager dwnLdMgr;
    private FBProgressIndicator progress;
    private FormUtil formutil;
    private FormDef formDef;
    private FormData formData;
    private PageData currentPage;

    private String titleString = "Register Immunization";
    
    private Command doneCmd = new Command("Save", 1);
    private Command cancelCmd = new Command("Cancel", 2);
     private Command lotCmd = new Command("Refresh");
    
    //The containers
    Container mainCont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    Container notesCont  = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    Container dateCont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    Container statusCont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    Container lotContainer = new Container(new BorderLayout());
    //Container lotIntegrCont = new COntainer
    Container lotLeft = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    Container lotRight = new Container(new BorderLayout());
    Container reasonCont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    
    
    int notesContID = 3 ;
    int dateContID = 1 ;
    int statusContID = 2 ;
    int lotContID = 0 ;
    int reasonContID = 4 ;
    
    //The question widgets
    Label notesLabel = new Label("");
    Label datelabel = new Label("");
    Label statusLabel = new Label("");
    Label lotLabel = new Label("");
    Label resonLabel = new Label("");
    
    Button lotButton = new Button("Refresh");
    
    
    TextField notesField = new TextField("");
    //Status
    String[] comboOpts = {"Yes","No"};
    ComboBox statusCombo = new ComboBox(comboOpts);

    
    String[] reasonOpts = {"Refusal","Permanent contraindication"};
    ComboBox reasonCombo = new ComboBox(reasonOpts);
    
    //date stuff
    DateField appDate = new DateField(DateField.DDMMYYYY, '/');
    Button selectDate = null;
    Command selectDateCmd = new Command("Select Date");
    
    //lot opts
    String[] lotOpts = {"Lot1","Lot2"};
    ComboBox lotCombo = new ComboBox(lotOpts);


    
    private boolean isAdded = false ;
    private CalendarForm calendarForm = new CalendarForm();
    
    
    
    
    
    
    
    
    

    public AppointmentForm(String title) {
        super(title);
        formutil = new FormUtil();
        
        initView();
    }

    public AppointmentForm(MWorkItem wir,IView parent) {
        super("");
        formutil = new FormUtil();
        setTitle(titleString);
        this.parent=parent;
        this.wir = wir;
        
        initView();
    }



    private void initView() {
        try{
        initItems();
        }catch(Exception e){
            System.out.println("Exception ");
            e.getMessage();
            e.printStackTrace();
        }

        
        
    }

    private int getAppSize() {
        return 5;
    }

    public Object getScreenObject() {
        return this;
    }

    public void resume(Hashtable args) {
        if(args!=null){
            Date myDate = (Date)args.get("date");
            System.out.println("Selected Date ->"+myDate.toString());
            if(appDate!=null){
                appDate.setDate(myDate);
                
            }
            
        }
        //this.removeAll();
        //initView();
        AppUtil.get().setView(this);
    }

    private void initItems() throws Exception {
        //refreshList();
         System.out.println("@ Quest i 1");
        ;
         System.out.println("@ Questi 2");
//         Object myb =new Object();
//         while(((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).getDisplayQues()==null){
//             System.out.println("waiting..");
//             synchronized(myb){
//              this.wait(1000);
//             }
//
//         }
         if(((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).newsetWorkItem(this.wir,this)){
            ((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).afterSetWorkItems(this.wir,this);
             nowShow();
         }else{
             downloadForm();

         }
        
        
    }

    private void nowShow(){
        selectDate = new Button(selectDateCmd);
        selectDate.setSelectedStyle(new Style(0xffffff, 0x69b510, Font.getBitmapFont("NokiaSansWide14Bold"), (byte)255));
        selectDate.addActionListener(this);
        int size = ((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).getDisplayQues().size() ;
        ques = new QuestionListObj[size];
        System.out.println("@ QuestionList : initItems() : Size of question array :" + ques.length);



        this.dipslayedQues =((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).getDisplayQues();
        for(int i=0;i<this.dipslayedQues.size();i++){
            QuestionListObj que = new QuestionListObj();

            QuestionData qd = (QuestionData)dipslayedQues.elementAt(i);
            String question = qd.getText();
            que.setQuestion(question);

            if(question.equals("Lot Number")){
                que.setType("dropdown");
            }else if(question.equals("Date of Immunization")){
                que.setType("Date");
            }else if(question.equals("Status")){
                que.setType("Check box");
            }else if(question.equals("Notes")){
                que.setType("textarea");
            }

            //ihub
System.out.println("@ QuestionList :initItems : Text :" + qd.getText() + "  Text Answer :" + qd.getTextAnswer());
            que.setValue(qd.getTextAnswer());


            ques[i]=que;


        }
        
        
        for(int k =0 ; k<ques.length ; k++){
            if(ques[k].getType().equals("dropdown")){
                appendLotNumber(ques[k]);
                
            }else if(ques[k].getType().equals("Date")){
                appendDateofImmunization(ques[k]);
                
            }else if(ques[k].getType().equals("Check box")){
                appendStatus(ques[k]);
                
            }
            else if(ques[k].getType().equals("textarea")){
                appendNotes(ques[k]);


            }
        }

//        QuestionListModel queListModel=new QuestionListModel(ques);
//        final QuestionFilterProxyListModel proxyModel = new QuestionFilterProxyListModel(queListModel);
//        //list =  new List(proxyModel);
//        list = new List(queListModel);
//        //list.getRenderer().
//        list.setListCellRenderer(new QueRender());
//        list.setFixedSelection(List.FIXED_NONE_CYCLIC);
//        list.addActionListener(this);
//        setLayout(new BorderLayout());
//
//        field.setConstraint(TextField.ANY);
//        searchlbl.getStyle().setFont(lblFont);
//        field.setLabelForComponent(searchlbl);
//        field.addDataChangeListener(new DataChangedListener() {
//
//            public void dataChanged(int i, int i1) {
//                proxyModel.filter(field.getText());
//            }
//        });

        //addComponent(BorderLayout.NORTH, field);
        addCommandListener(this);
        //setCommandListener(this);
        setLayout(new BorderLayout());
        
        addComponent(BorderLayout.CENTER, mainCont);

        addCommand(cancelCmd);
        addCommand(doneCmd);

    }

        public void downloadForm(){
            dwnLdMgr=((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).getDM();
        progress = new FBProgressIndicator(this,"Downloading studies...");
        progress.showModeless();


        new BackgroundTask() {

            public void performTask() {
                
                dwnLdMgr.downloadStudies(AppointmentForm.this);

                //dwnLdMgr.uploadWorkItems(null);
            }

            public void taskStarted() {
                System.out.println("My task is started");
            }





        }.start();

    }

//    private void refreshList() {
//        Vector items = WFStorage.getMWorkItemList(this);
//        if(items!=null){
//            mWorkItemsList=items;
//        }else{
//            mWorkItemsList= new Vector(0);
//        }
//        System.out.println("Size of my objects =>"+items.size());
//    }

    public void errorOccured(String string, Exception excptn) {
    }

    public void actionPerformed(ActionEvent ae) {
        
        Object src =ae.getSource();
        System.out.println("Selected source=>"+src.getClass().toString());
        if (src==lotButton) {
            //refresh the Lot List
            refreshLot();
            
        }else if(src==doneCmd){
            //save items
            saveData();
            parent.resume(null);
            
        }else if(src==cancelCmd){
            parent.resume(null);
            
        }else if(src == statusCombo){
            String selection  = statusCombo.getSelectedItem().toString();
            System.out.println("Combo selected :" + selection);
            if(selection.equals("No")){
              enableResCont();
              isAdded = true ;

            }else if(selection.equals("Yes")){
                if(isAdded){
                    disableResCont();
                }
            }
        }else if(src == selectDateCmd){
            //Load Calendar here
            CalendarCanvas calfoForm = new CalendarCanvas(this);
            ((Display)AppUtil.get().getItem(Constants.MIDP_DISPLAY)).setCurrent(calfoForm);
            
            //calendarForm.setListener(this);
            //AppUtil.get().setView(calendarForm);
        }else if(src == calendarForm.okcmd){
            System.out.println("Selected Date :" +calendarForm.getDate());
            
        }else if(src == calendarForm.cmdBack){
            System.out.println("Back Command");
            AppUtil.get().setView(this);
        }else if (ae.getCommand() == progress.cancel) {
            //transportlayer.
            this.resume(null);

        }
        
    }
    
//    private void disableLotCont(){
//        mainCont.removeComponent(lotContainer);
////        lotLabel.setFocusable(false);
////        lotCombo.setFocusable(false);
////        lotButton.setFocusable(false);
////        lotContainer.setFocusable(false);
//    }
//
//    private void enableLotCont(){
//        mainCont.addComponent(lotContID ,lotContainer);
////        lotLabel.setFocusable(true);
////        lotCombo.setFocusable(true);
////        lotButton.setFocusable(true);
////        lotContainer.setFocusable(true);
//    }

    private void disableResCont(){
        mainCont.removeAll();
        mainCont.addComponent(lotContainer);
        mainCont.addComponent(dateCont);
        mainCont.addComponent(statusCont);
        mainCont.addComponent(notesCont);
    }

    private void enableResCont(){
        mainCont.removeAll();
        mainCont.addComponent(dateCont);
        mainCont.addComponent(statusCont);
        appendReason();
        mainCont.addComponent(notesCont);
    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
    }

    public void setTitleString(String titleString) {
        this.titleString = titleString;
    }

    public String getTitleString() {
        return titleString;
    }

    public void uploaded(Persistent prstnt, Persistent prstnt1) {
    }

    public void downloaded(Persistent dataOutParams, Persistent dataOut) {
        progress.dispose();
        if (dataOut instanceof UserListStudyDefList) {
        System.out.println("Saving the forms");
                    handleStudyAndUserDownloaded((UserListStudyDefList) dataOut);
                }else if(dataOut instanceof Object){
                    //do Lot number stuff here
                }
        
        nowShow();
    }
    
    private void handleStudyAndUserDownloaded(UserListStudyDefList userListStudyDefList) {
                WFStorage.saveUserListStudyDefList(userListStudyDefList);
    }

    public void cancelled() {
    }

    public void updateCommunicationParams() {
    }

    private void appendLotNumber(QuestionListObj obj) {
        lotLabel.setText(obj.getQuestion());
        lotLeft.addComponent(lotLabel);
        lotLeft.addComponent(lotCombo);
        lotButton.addActionListener(this);
        lotButton.setSelectedStyle(new Style(0xffffff, 0x69b510, Font.getBitmapFont("NokiaSansWide14Bold"), (byte)255));
        lotRight.addComponent(BorderLayout.CENTER, lotButton);
        lotContainer.addComponent(BorderLayout.WEST,lotLeft);
        lotContainer.addComponent(BorderLayout.EAST,lotRight);
        Border bd = Border.createLineBorder(1, 0x7799bb);
        lotContainer.getStyle().setBorder(bd, true);
        mainCont.addComponent(lotContainer);
        
    }

    private void appendDateofImmunization(QuestionListObj obj) {
        datelabel.setText(obj.getQuestion());
        dateCont.addComponent(datelabel);
//        appDate.addActionListener(this);
        dateCont.addComponent(appDate);
        dateCont.addComponent(selectDate);
        mainCont.addComponent(dateCont);
    }

    private void appendStatus(QuestionListObj obj) {
        statusLabel.setText(obj.getQuestion());
        statusCont.addComponent(statusLabel);
        statusCombo.getStyle().setFgColor(0Xff0001);
        DefaultListCellRenderer dlcr =
                (DefaultListCellRenderer)statusCombo.getRenderer();
        dlcr.getStyle().setFgColor(0x0000ff);
        statusCombo.addActionListener(this);
        statusCont.addComponent(statusCombo);
        mainCont.addComponent(statusCont);
    }

    private void appendNotes(QuestionListObj obj) {
        notesLabel.setText(obj.getQuestion());
        notesField.setText((obj.getValue() == null)?"":""+obj.getValue());
        notesCont.addComponent(notesLabel);
        notesCont.addComponent(notesField);
        mainCont.addComponent(notesCont);
    }

    private void appendReason() {
        if(!contains(reasonCombo)){
        resonLabel.setText("Reason");
        reasonCont.addComponent(resonLabel);
        reasonCombo.getStyle().setFgColor(0Xff0001);
        DefaultListCellRenderer dlcr =
                (DefaultListCellRenderer)reasonCombo.getRenderer();
        dlcr.getStyle().setFgColor(0x0000ff);
        reasonCont.addComponent(reasonCombo);
        mainCont.addComponent(reasonCont);
        }
    }


    private void saveData() {
        System.out.println("Question size:=>"+dipslayedQues.size());
        for(int i =0 ;i<dipslayedQues.size();i++){
            QuestionData qd = (QuestionData)dipslayedQues.elementAt(i);
            String question = qd.getText();
            //que.setQuestion(question);

            if(question.equals("Lot Number")){
                //que.setType("dropdown");
                qd.setTextAnswer((String)lotCombo.getSelectedItem());
            }else if(question.equals("Date of Immunization")){
                //que.setType("Date");
                qd.setTextAnswer(appDate.getText());
            }else if(question.equals("Status")){
                //que.setType("Check box");
                qd.setTextAnswer((String)statusCombo.getSelectedItem());
            }else if(question.equals("Notes")){
                //que.setType("textarea");
                qd.setTextAnswer(notesField.getText());
            }
            dipslayedQues.setElementAt(qd, i);
            
        }
        
        ((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).saveQtnDataFromForm(dipslayedQues,this.wir);
        
    }

    private void refreshLot() {
        //Load Refresh
        new BackgroundTask() {

            public void performTask() {
                progress = new FBProgressIndicator(AppointmentForm.this,"Refreshing Lot Information...");
                progress.showModeless();
                dwnLdMgr=((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).getDM();
                dwnLdMgr.downloadLotNames(AppointmentForm.this);
            }
        }.start();
    }
    
    
    



}
