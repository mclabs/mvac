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
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
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
    //private Button btnRegister;
    //private Button btnUpload;
    private Command cmdDownload;
    private Command cmdAppointments;
    private Command cmdSearch;
    //private Command cmdRegister;
    //private Command cmdUpload;
    private MvacTransportLayer transportlayer;
    private FBProgressIndicator progress;
    private DownloadManager dwnLdMgr;
    private Command cmdLogout = null;

    private Image logo = null;
    private Label lblLogo = null;
    private AppointmentsDownloadDialog downloadDialog=null;
    

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
        //cmdRegister = new Command("Register Child/Caretaker");
        //cmdUpload = new Command("Upload Data");

        btnAppointments = new Button(cmdAppointments);
        btnAppointments.addActionListener(this);
        btnDownload = new Button(cmdDownload);
        btnDownload.addActionListener(this);
        btnSearch = new Button(cmdSearch);
        btnSearch.addActionListener(this);
        // btnRegister = new Button(cmdRegister);
        // btnRegister.addActionListener(this);
        // btnUpload = new Button(cmdUpload);
        // btnUpload.addActionListener(this);

        container.addComponent(btnDownload);
        container.addComponent(btnAppointments);
        container.addComponent(btnSearch);
        // container.addComponent(btnRegister);
        //container.addComponent(btnUpload);

        this.addComponent(BorderLayout.CENTER, container);

        this.cmdLogout = new Command("Logout");

        this.addCommand(cmdLogout);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getCommand() == cmdDownload) {

            /****
             * Show Alert before proceed to download
             * Task is Upload then Download
             */
            downloadDialog = new AppointmentsDownloadDialog(this);
            downloadDialog.show();



        } else if (ae.getCommand() == cmdAppointments) {
            System.out.println("Appointments");
            GroupList appList = new GroupList("Saved appointments");
            AppUtil.get().setView(appList);

        } else if (ae.getCommand() == cmdSearch) {
            System.out.println("Search");
            LWUITSearchForm sform = new LWUITSearchForm();
            AppUtil.get().setView(sform);

        } //        else if (ae.getCommand() == cmdRegister) {
        //            System.out.println("Register");
        //
        //
        //        }
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
        AppUtil.get().setView(this);
    }

    public void uploaded(Persistent prstnt, Persistent prstnt1) {
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
        if (yesNo) {
            download();
        }
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
