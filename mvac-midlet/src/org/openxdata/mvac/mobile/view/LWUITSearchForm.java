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
import com.sun.lwuit.Display;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextField;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.plaf.Border;
import java.util.Date;
import java.util.Hashtable;
import org.openxdata.communication.TransportLayerListener;
import org.openxdata.db.util.Persistent;
import org.openxdata.db.util.StorageListener;
import org.openxdata.model.ResponseHeader;
import org.openxdata.mvac.communication.MvacTransportLayer;
import org.openxdata.mvac.mobile.DownloadManager;
import org.openxdata.mvac.mobile.db.WFStorage;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.view.api.IView;
import org.openxdata.workflow.mobile.model.MWorkItemList;

/**
 *
 * @author mutahi
 */
public class LWUITSearchForm extends Form implements IView, StorageListener, TransportLayerListener, ActionListener {

    private Container container;
    private Label lblbirthplace;
    private Label lblbirthdate;
    private Label lblfName;
    private Label lblLName;
    private Label lblNationalID;
    private Button btnFrom;
    private Button btnTo;
    private ComboBox cbPlaces;
    private Command cmdSearch;
    private Command cmdBack;
    private Command cmdFrom;
    private Command cmdTo;
    private TextField txt_birthplace = null;
    private TextField txt_fname = null;
    private TextField txt_lname = null;
    private TextField txt_nationalID = null;
    private CalendarForm calendarForm = null;
    private MvacTransportLayer transportlayer;
    private FBProgressIndicator progress;
    private DownloadManager dwnLdMgr;
    private Date fromDate = null;
    private Date toDate = null;
    private String fromdateLabel = "";
    private String todateLabel = "";


    //Test
    ValidSearchAlert alerts = new ValidSearchAlert(10);

    public LWUITSearchForm() {
        super("Search Child/Caretaker");
        initSearchForm();

        calendarForm = new CalendarForm();
    }

    private void initSearchForm() {
        setLayout(new BorderLayout());
        transportlayer = new MvacTransportLayer();
        dwnLdMgr = new DownloadManager(transportlayer);
        progress = new FBProgressIndicator(this, "Searching..");
        container = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        lblbirthdate = new Label("Date of Birth");
        lblbirthplace = new Label("Place of Birth");
        lblfName = new Label("First Name");
        lblLName = new Label("Last Name");
        lblNationalID = new Label("National ID");

        txt_birthplace = new TextField();
        txt_fname = new TextField();
        txt_lname = new TextField();
        txt_nationalID = new TextField();


        cmdFrom = new Command("From Date");
        cmdTo = new Command("To Date");

        btnFrom = new Button(cmdFrom);
        btnFrom.setAlignment(CENTER);
        btnFrom.getStyle().setFont(Font.getBitmapFont("mvaccalibri13"));
        btnFrom.getStyle().setBorder(Border.createBevelRaised());
        btnFrom.setWidth(20);
        btnTo = new Button(cmdTo);
        btnTo.setAlignment(CENTER);
        btnTo.getStyle().setFont(Font.getBitmapFont("mvaccalibri13"));
        btnTo.getStyle().setBorder(Border.createBevelRaised());
        btnTo.setWidth(20);

        cbPlaces = new ComboBox();
        //Test Data
        cbPlaces.addItem("Albania");

        container.addComponent(lblfName);
        container.addComponent(txt_fname);

        container.addComponent(lblLName);
        container.addComponent(txt_lname);

        container.addComponent(lblbirthdate);
        container.addComponent(btnFrom);
        //container.addComponent(txt_from);
        container.addComponent(btnTo);
        //container.addComponent(txt_to);

        container.addComponent(lblbirthplace);
        // container.addComponent(txt_birthplace);
        container.addComponent(cbPlaces);

        container.addComponent(lblNationalID);
        container.addComponent(txt_nationalID);

        this.addComponent(BorderLayout.CENTER, container);

        cmdSearch = new Command("Search", 1);
        cmdBack = new Command("Back", 2);

        addCommand(cmdSearch);
        addCommand(cmdBack);


        addCommandListener(this);

    }

    public Object getScreenObject() {
        return this;
    }

    public void resume(Hashtable args) {
        AppUtil.get().setView(this);
    }

   

   

    private void download() {
        progress.showModeless();
        System.out.println("My task is abt started");
        new BackgroundTask() {

            public void performTask() {
                dwnLdMgr.downloadWorkItems(LWUITSearchForm.this);
            }

            public void taskStarted() {
                System.out.println("My task is started");
            }
        }.start();


    }

    public void errorOccured(String string, Exception excptn) {
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
        GroupList appList = new GroupList("Saved appointments");
        AppUtil.get().setView(appList);

    }

    public void cancelled() {
    }

    public void updateCommunicationParams() {
    }

    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("@ ActionPerformed : Source" + actionEvent.getSource().getClass().toString());
        if (actionEvent.getSource() == cmdBack) {
            AppUtil.get().setView(new LWUITMainMenu());
        } else if (actionEvent.getSource() == cmdSearch) {
            System.out.println("Search");

            /***
             * Test
             */
            
            alerts.show();

            /***
             * Test
             */
        } else if (actionEvent.getSource() == cmdFrom) {
            calendarForm.setListener(this);
            calendarForm.setSourceText("From");
            AppUtil.get().setView(calendarForm);
        } else if (actionEvent.getSource() == cmdTo) {
            calendarForm.setListener(this);
            calendarForm.setSourceText("To");
            AppUtil.get().setView(calendarForm);
        } else if (actionEvent.getSource() == calendarForm.okcmd) {
            Date date = calendarForm.calendar.getDate();
            System.out.println("From calendar :" + calendarForm.calendar.getDate());
            if (calendarForm.getSourceText().equals("From")) {
                this.setFromDate(date);
                btnFrom.setText("From :" + getFromdateLabel());


            } else if (calendarForm.getSourceText().equals("To")) {
                this.setToDate(date);
                btnTo.setText("To :" + getTodateLabel());

            }
            AppUtil.get().setView(this);

        } else if (actionEvent.getSource() == calendarForm.cmdBack) {
            AppUtil.get().setView(this);
        }

    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
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

    private String getLabel(String date) {
        String day = date.substring(0, 3);
        String month = date.substring(4, 7);
        String d = date.substring(8, 10);
        String year = date.substring(24, date.length());
        String label = day.trim() + " " + month.trim() + " " + d.trim() + " " + year.trim();
        return label;
    }

    public void setToDate(Date toDate) {
        setTodateLabel(getLabel(toDate.toString()));
        this.toDate = toDate;
    }

    public void setFromDate(Date fromDate) {
        setFromdateLabel(getLabel(fromDate.toString()));
        this.fromDate = fromDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setFromdateLabel(String fromdateLabel) {
        this.fromdateLabel = fromdateLabel;
    }

    public String getFromdateLabel() {
        return fromdateLabel;
    }

    public void setTodateLabel(String todateLabel) {
        this.todateLabel = todateLabel;
    }

    public String getTodateLabel() {
        return todateLabel;
    }


    public String getLastname(){
        return txt_lname.getText();
    }

    public String getFirstname(){
        return txt_fname.getText();
    }

    public String getPlaceOfBirth(){
        return cbPlaces.getSelectedItem().toString();
    }

    public String getNationalID(){
        return txt_nationalID.getText();
    }
}
