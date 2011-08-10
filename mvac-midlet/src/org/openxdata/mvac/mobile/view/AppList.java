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
import org.openxdata.db.util.StorageListener;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.view.api.IView;
import org.openxdata.workflow.mobile.model.MQuestionMap;
import org.openxdata.workflow.mobile.model.MWorkItem;

/**
 *
 * @author soyfactor
 */
public class AppList extends  Form implements IView,StorageListener,ActionListener{
    private Appointment[] apps;
    private List list;
    private  TextField field = new TextField("Click here to search", 22);
    private Font lblFont = Font.getBitmapFont("mvaccalibri13");
    private Label searchlbl = new Label("Search:");
    private Vector mWorkItemsList = new Vector(0);
    private IView parent;
    private Command uploadselected;
    private Command uploadall;



    public AppList(String title) {
        super(title);
        initView();
    }

    public AppList(AppointmentWrapper wrapper,IView parent) {
        super(wrapper.getName());
        mWorkItemsList = wrapper.getWorkItems();
        this.parent=parent;
        initView();
    }

    private void initView() {
        initItems();
        uploadselected = new Command("upload selected", 1);
        uploadall = new Command("Upload All", 2);

        //addCommand(uploadselected);
        //addCommand(uploadselected);
        setCommandListener(this);
        

        
        AppListModel appListModel=new AppListModel(apps);
        final FilterProxyListModel proxyModel = new FilterProxyListModel(appListModel);
        list =  new List(proxyModel);
        AppRender appRender = null;
        list.setListCellRenderer(appRender = new AppRender()); 
        list.setFixedSelection(List.FIXED_NONE_CYCLIC);
        list.addActionListener(this);
        setLayout(new BorderLayout());

        field.setConstraint(TextField.ANY);
        searchlbl.getStyle().setFont(lblFont);
        field.setLabelForComponent(searchlbl);
        field.addDataChangeListener(new DataChangedListener() {

            public void dataChanged(int i, int i1) {
                proxyModel.filter(field.getText());
            }
        });

        addComponent(BorderLayout.NORTH, field);
        addComponent(BorderLayout.CENTER, list);

        addCommand(new Command("Back"){
            public void actionPerformed(ActionEvent ae){
                System.out.println("Back Command Pressed");
                parent.resume(null);
            }
        });
    }

    private int getAppSize() {
        return 5;
    }

    public Object getScreenObject() {
        return this;
    }

    public void resume(Hashtable args) {
        AppUtil.get().setView(this);
    }

    private void initItems() {
        //refreshList();
        apps = new Appointment[mWorkItemsList.size()];

        for(int i=0;i<mWorkItemsList.size();i++){
            Appointment app = new Appointment();
            
            MWorkItem wir = (MWorkItem)mWorkItemsList.elementAt(i);
            app.setRecord_id(wir.getRecordId());
System.out.println("MY WIR record ID => "+app.getRecord_id());
            
            Vector preFilledQns = wir.getPrefilledQns();
            for (int k = 0; k < preFilledQns.size(); k++) {
                MQuestionMap qnMap        = (MQuestionMap) preFilledQns.elementAt(k);
                String       questionName = qnMap.getQuestion();
System.out.println("Question Name :" + questionName);
                if(questionName.equals("vaccine_name")){
                    app.setVaccine_name(qnMap.getValue());

                }else if(questionName.equals("scheduled_date")){
                    app.setSchedule_date(qnMap.getValue());

                }else if(questionName.equals("dose_name")){
                    app.setDose(qnMap.getValue());

                }
            }
            apps[i]=app;


        }
        
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
System.out.println("@ Applist Selected this item=>"+list.getSelectedIndex());
        Object src =ae.getSource();
        if(src==list){
            int wirIndex = list.getSelectedIndex();
            MWorkItem slectedWir= (MWorkItem)mWorkItemsList.elementAt(wirIndex);
System.out.println("@ applist : action performed Selected this item=>"+slectedWir.getDescription() + " "+ slectedWir.getTaskName() + " " + slectedWir.getDisplayName() + " ");
            AppointmentForm appForm = new AppointmentForm(slectedWir, this);
            AppUtil.get().setView(appForm);
//            ((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).showform(slectedWir);
        }else{
            Command cmd = ae.getCommand();
            if (cmd==uploadselected) {
                System.out.println("uploading selected");
            }else if(cmd==uploadall){
                System.out.println("uploading all");
            }
        }
    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
    }






}
