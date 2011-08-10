/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Command;
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
import java.util.Hashtable;
import java.util.Vector;
import org.openxdata.communication.TransportLayerListener;
import org.openxdata.db.util.Persistent;
import org.openxdata.db.util.StorageListener;
import org.openxdata.model.QuestionData;
import org.openxdata.model.UserListStudyDefList;
import org.openxdata.mvac.mobile.DownloadManager;
import org.openxdata.mvac.mobile.api.MvacController;
import org.openxdata.mvac.mobile.db.WFStorage;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.Constants;
import org.openxdata.mvac.mobile.util.view.api.IView;
import org.openxdata.workflow.mobile.model.MWorkItem;

/**
 *
 * @author soyfactor
 */
public class QuestionsList extends  Form implements IView,StorageListener,ActionListener, TransportLayerListener{
    private QuestionListObj[] ques;
    private List list;
    private  TextField field = new TextField("", 20);
    //private Font lblFont = Font.getBitmapFont("mvaccalibri13");
    private Label searchlbl = new Label("Search:");
    private IView parent;
    private MWorkItem wir;
    private Vector dipslayedQues=new Vector(0);
    private DownloadManager dwnLdMgr;
    private FBProgressIndicator progress;

    private String titleString = "Register Immunization";

    public QuestionsList(String title) {
        super(title);
        initView();
    }

    public QuestionsList(MWorkItem wir,IView parent) {
        super("");
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
        this.removeAll();
        initView();
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

        QuestionListModel queListModel=new QuestionListModel(ques);
        final QuestionFilterProxyListModel proxyModel = new QuestionFilterProxyListModel(queListModel);
        //list =  new List(proxyModel);
        list = new List(queListModel);
        //list.getRenderer().
        list.setListCellRenderer(new QueRender());
        list.setFixedSelection(List.FIXED_NONE_CYCLIC);
        list.addActionListener(this);
        setLayout(new BorderLayout());

        field.setConstraint(TextField.ANY);
        //searchlbl.getStyle().setFont(lblFont);
        field.setLabelForComponent(searchlbl);
        field.addDataChangeListener(new DataChangedListener() {

            public void dataChanged(int i, int i1) {
                proxyModel.filter(field.getText());
            }
        });

        //addComponent(BorderLayout.NORTH, field);
        addComponent(BorderLayout.CENTER, list);

        addCommand(new Command("Back"){
            public void actionPerformed(ActionEvent ae){
                System.out.println("Back Command Pressed");
                parent.resume(null);
            }
        });

    }

        public void downloadForm(){
            dwnLdMgr=((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).getDM();
        progress = new FBProgressIndicator(this,"Downloading studies...");
        progress.showModeless();


        new BackgroundTask() {

            public void performTask() {
                
                dwnLdMgr.downloadStudies(QuestionsList.this);

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
        System.out.println("Selected this item=>"+list.getSelectedIndex());
        Object src =ae.getSource();
        if(src==list){
            int wirIndex = list.getSelectedIndex();
            ((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).selectNextQuestion(wirIndex);
        }else{
            Command cmd = ae.getCommand();
//            if (cmd==uploadselected) {
//                System.out.println("uploading selected");
//            }else if(cmd==uploadall){
//                System.out.println("uploading all");
//            }
        }
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





}
