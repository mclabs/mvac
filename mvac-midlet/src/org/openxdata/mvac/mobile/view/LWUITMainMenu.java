/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.plaf.Style;
import java.util.Hashtable;
import java.util.Vector;
import org.openxdata.communication.TransportLayerListener;
import org.openxdata.db.util.Persistent;
import org.openxdata.db.util.StorageListener;
import org.openxdata.model.ResponseHeader;
import org.openxdata.model.UserListStudyDefList;
import org.openxdata.mvac.communication.MvacTransportLayer;
import org.openxdata.mvac.mobile.DownloadManager;
import org.openxdata.mvac.mobile.Factory;
import org.openxdata.mvac.mobile.api.FormUtil;
import org.openxdata.mvac.mobile.api.MvacController;
import org.openxdata.mvac.mobile.db.WFStorage;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.Constants;
import org.openxdata.mvac.mobile.util.NurseSettings;
import org.openxdata.mvac.mobile.util.view.api.IDialogListener;
import org.openxdata.mvac.mobile.util.view.api.IView;
import org.openxdata.workflow.mobile.model.MWorkItem;
import org.openxdata.workflow.mobile.model.MWorkItemList;

/**
 *
 * @author mutahi
 */
public class LWUITMainMenu extends Form implements ActionListener, IView, TransportLayerListener, StorageListener {

    private Container container;
    private Button btnDownload;
    private Button btnAppointments;
    private Button btnSearch;
    private Command cmdDownload;
    private Command cmdAppointments;
    private Command cmdSearch;
    private MvacTransportLayer transportlayer;
    private FBProgressIndicator progress;
    private DownloadManager dwnLdMgr;
    private Command cmdLogout = null;

    private Image logo = null;
    private Label lblLogo = null;
    private AppointmentsDownloadDialog downloadDialog=null;
    private Style selcStyle = new Style(0xffffff, 0x69b510, Font.getBitmapFont("NokiaSansWide14Bold"), (byte)255);
    
   

    public LWUITMainMenu() {
        super("Main Menu");
        transportlayer = new MvacTransportLayer();
        dwnLdMgr = new DownloadManager(transportlayer);
        progress = new FBProgressIndicator(this, "Downloading workitems..");
        this.addCommandListener(this);
        initMainMenu();

    }

    void initMainMenu() {
        setLayout(new BorderLayout());

        logo = Factory.getLogo();
        

        if(logo != null ){
System.out.println("Image not null");
            lblLogo = new Label(logo);
            this.addComponent(BorderLayout.CENTER, lblLogo);
           
        }

        container = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        cmdDownload = new Command("Plan Appointments");
        cmdAppointments = new Command("Open Appointments");
        cmdSearch = new Command("Search");

        btnAppointments = new Button(cmdAppointments);
        
//        Style selc = new Style(0xffffff, 0x69b510, Font.getBitmapFont("NokiaSansWide14Bold"), (byte)255);
        btnAppointments.setSelectedStyle(new Style(0xffffff, 0x69b510, Font.getBitmapFont("NokiaSansWide14Bold"), (byte)255));
        btnAppointments.addActionListener(this);
        btnDownload = new Button(cmdDownload);
        btnDownload.setSelectedStyle(new Style(0xffffff, 0x69b510, Font.getBitmapFont("NokiaSansWide14Bold"), (byte)255));
        btnDownload.addActionListener(this);
        
        btnSearch = new Button(cmdSearch);
        btnSearch.setSelectedStyle(new Style(0xffffff, 0x69b510, Font.getBitmapFont("NokiaSansWide14Bold"), (byte)255));
        btnSearch.addActionListener(this);
        

        container.addComponent(btnDownload);
        container.addComponent(btnAppointments);
        container.addComponent(btnSearch);

        this.addComponent(BorderLayout.CENTER, container);

        this.cmdLogout = new Command("Logout");

        this.addCommand(cmdLogout);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getCommand() == cmdDownload) {
            uploadCompletedItems();

            /****
             * Show Alert before proceed to download
             * Task is Upload then Download
             */
//            downloadDialog = new AppointmentsDownloadDialog(this);
//            downloadDialog.show();
            
//            Object object = AppUtil.get().getItem(Constants.CONTROLLER);
//            if(object != null && object instanceof MvacController){
//                MvacController controller = (MvacController) object;
//                AppUtil.get().putItem(Constants.DOWNLOAD_DATE, "No Date");
//                controller.uploadData(this);
//                
//                
//                
//            }
            
            



        } else if (ae.getCommand() == cmdAppointments) {
            System.out.println("Appointments");
            GroupList appList = new GroupList("Saved appointments");
            AppUtil.get().setView(appList);

        } else if (ae.getCommand() == cmdSearch) {
            System.out.println("Search");
            LWUITSearchForm sform = new LWUITSearchForm();
            AppUtil.get().setView(sform);

        }
        else if (ae.getCommand() == progress.cancel) {
            //transportlayer.
            this.resume(null);

        } else if (ae.getSource() == cmdLogout) {
            LWUITLoginForm loginForm = new LWUITLoginForm("User Login");
                AppUtil.get().setView(loginForm);
        }
//            else if(ae.getCommand()==cmdUpload){
//            ((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).uploadData(this);
//            //this.resume(null);
//
//        }
    }

    private void download() {
        progress.showModeless();
        System.out.println("My task is abt started");
        new BackgroundTask() {

            public void performTask() {
                dwnLdMgr.downloadWorkItems(LWUITMainMenu.this);
            }

            public void taskStarted() {
                System.out.println("My task is started");
            }
        }.start();


    }

    public Object getScreenObject() {
        return this;
    }

    public void resume(Hashtable args) {
        if(args!=null){
            String msg = (String)args.get("msg");
            if(msg.equals("success")){
                downloadDialog = new AppointmentsDownloadDialog(this);
                downloadDialog.show();
            }
                    
        }else{
            AppUtil.get().setView(this);
        }
        
    }

    public void uploaded(Persistent dataOutParams, Persistent dataOut) {
        System.out.println("@ uploaded");
        progress.dispose();
        
        if(dataOutParams!=null){
            ResponseHeader rh = (ResponseHeader) dataOutParams;
        System.out.println("In upload=>"+rh.isSuccess());
                if (rh.isSuccess()) {
                        WFStorage.deleteCompleteWorkItems(this, true);
                }
        }
            System.out.println("In upload=>returning to view");
            Hashtable args = new Hashtable();
            args.put("msg", "success");
            this.resume(args);

    }

    public void downloaded(Persistent dataOutParams, Persistent dataOut) {
        progress.dispose();
        System.out.println("inside downloaded");
        ResponseHeader rh = (ResponseHeader) dataOutParams;
        if (!rh.isSuccess()) {
            System.out.println("inside !issuccess");
            return;
        } else if (dataOut instanceof MWorkItemList) {
            System.out.println("inside instance of");
            saveAndDisplayWorkItems((MWorkItemList) dataOut);
        }else if (dataOut instanceof UserListStudyDefList) {
        System.out.println("Saving the forms");
                    handleStudyAndUserDownloaded((UserListStudyDefList) dataOut);
                    GroupList appList = new GroupList("Saved appointments");
                    AppUtil.get().setView(appList);
                }else{
            System.out.println("inside other else");
            
        }
    }

    private void saveAndDisplayWorkItems(MWorkItemList dataOut) {
        if (dataOut.getmWorkItems().isEmpty()) {
            //view.showMsg("No WorkItems Available");
            System.out.println("inside is empty");
            GroupList appList = new GroupList("Saved appointments");
            AppUtil.get().setView(appList);
        }
        WFStorage.saveMWorkItemList(dataOut, this);
        downloadAssociatedForm();
        
        

    }
    
    public void downloadAssociatedForm(){
        Vector mWorkItemsList = new Vector(0);
        System.out.println("Abt to check");
        if(WFStorage.getMWorkItemList(this)!=null){
            mWorkItemsList=WFStorage.getMWorkItemList(this);

        }else{
            mWorkItemsList= new Vector(0);
        }
        if(mWorkItemsList.size()>0){
            MWorkItem wir = (MWorkItem)mWorkItemsList.elementAt(0);
            FormUtil formutil = new FormUtil();
            if(formutil.getFormDef(wir)==null){
                System.out.println("@ MainMenu : about to download assoc forms");

                   downloadForm();

            //return;
            }else{
                GroupList appList = new GroupList("Saved appointments");
                AppUtil.get().setView(appList);
            }
            
        }
        
    }
    
    private void handleStudyAndUserDownloaded(UserListStudyDefList userListStudyDefList) {
                WFStorage.saveUserListStudyDefList(userListStudyDefList);
    }
    
    public void downloadForm(){
        progress = new FBProgressIndicator(this,"Downloading associated studies...");
        progress.showModeless();


        new BackgroundTask() {

            public void performTask() {
                
                dwnLdMgr.downloadStudies(LWUITMainMenu.this);
                
                //dwnLdMgr.uploadWorkItems(null);
            }

            public void taskStarted() {
                System.out.println("My task is started");
            }





        }.start();

    }

    public void errorOccured(String string, Exception excptn) {
    }

    public void cancelled() {
    }

    public void updateCommunicationParams() {
    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {

        AppUtil.get().setView(this);
        Object object = null;
        try{
            object = AppUtil.get().getItem(Constants.NURSENAME);
            if(object != null && object.toString().length()>0 && (!object.toString().equals(""))){
                if (yesNo) {
                    download();
                }
            }else{
                NurseSettings nurseSettings = new NurseSettings();
                AppUtil.get().setView(nurseSettings);
            }
        }catch(Exception e){
System.out.println("Exception thrown when fetching nurse name :" + e.getMessage());
            NurseSettings settings = new NurseSettings();
            AppUtil.get().setView(settings);
        }
        
        
        
        
        
    }
    
    public void uploadCompletedItems(){
        progress = new FBProgressIndicator(this,"Uploading Data...");
        progress.showModeless();
        
        new BackgroundTask() {

            public void performTask() {
                dwnLdMgr.uploadWorkItems(LWUITMainMenu.this);
                //dwnLdMgr.uploadWorkItems(null);
            }

            public void taskStarted() {
            }



        }.start();
    }



    
}
