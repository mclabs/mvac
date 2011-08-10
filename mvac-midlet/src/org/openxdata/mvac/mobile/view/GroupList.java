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
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.openxdata.db.util.StorageListener;
import org.openxdata.mvac.mobile.db.WFStorage;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.view.api.IView;
import org.openxdata.workflow.mobile.model.MQuestionMap;
import org.openxdata.workflow.mobile.model.MWorkItem;

/**
 *
 * @author soyfactor
 */
public class GroupList extends  Form implements IView,StorageListener,ActionListener{
    private AppointmentWrapper[] apps;
    private List list;
    private  TextField field = new TextField("Click here to search", 22);
    private Font lblFont = Font.getBitmapFont("mvaccalibri13");
    private Label searchlbl = new Label("Search:");
    private Vector mWorkItemsList = new Vector(0);
    private Hashtable appGroups = new Hashtable();
    private AppListModel appListModel;
    private GroupFilterProxyListModel proxyModel;
    private Command back;



    public GroupList(String title) {
        super("Children Due");
        initView();
    }

    private void initView() {
        initItems();
        back = new Command("Back", 1);
        addCommand(back);
        setCommandListener(this);
        appListModel=new AppListModel(apps);
        proxyModel = new GroupFilterProxyListModel(appListModel);
        list =  new List(proxyModel);
        list.addActionListener(this);
        list.setListCellRenderer(new AppGroupRender());
        list.setFixedSelection(List.FIXED_NONE_CYCLIC);
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
        refreshList();
        System.out.println("Almost looping work items");
        for(int i=0;i<mWorkItemsList.size();i++){
            System.out.println("looping work items");
            AppointmentWrapper appwr = new AppointmentWrapper();
            Appointment app =  new Appointment();
            String myChild_id="";

            MWorkItem wir = (MWorkItem)mWorkItemsList.elementAt(i);
            app.setRecord_id(wir.getDataRecId());


            Vector preFilledQns = wir.getPrefilledQns();
            for (int k = 0; k < preFilledQns.size(); k++) {
                MQuestionMap qnMap        = (MQuestionMap) preFilledQns.elementAt(k);
                String       questionName = qnMap.getQuestion();
                if (questionName.equals("child_name")) {
                    appwr.setName(qnMap.getValue());
                    app.setName(qnMap.getValue());

                }else if(questionName.equals("caretaker_name")){
                    appwr.setCaretaker(qnMap.getValue());
                    app.setCaretaker(qnMap.getValue());

                }else if(questionName.equals("child_iis_id")){
                    myChild_id=qnMap.getValue();
                    app.setChild_id(qnMap.getValue());
                }else if(questionName.equals("child_dob")){

                    String dob = qnMap.getValue();
                    dob = dob.substring(0, dob.indexOf("T"));


                    appwr.setChild_dob(dob);
                }else if(questionName.equals("caretaker_nid")){
                    appwr.setCaretaker_nid(qnMap.getValue());
                }
            }

            if(appGroups.containsKey(myChild_id)){
                ((AppointmentWrapper)appGroups.get(myChild_id)).addElement(app);
                ((AppointmentWrapper)appGroups.get(myChild_id)).addWorkItem(wir);
                System.out.println("Adding existing");


            }else{
                appwr.addElement(app);
                appGroups.put(myChild_id, appwr);
                ((AppointmentWrapper)appGroups.get(myChild_id)).addWorkItem(wir);
                System.out.println("Adding New");
            }

        }


        apps = new AppointmentWrapper[appGroups.size()];

        Enumeration e = appGroups.keys();
        int count=0;

        while(e.hasMoreElements()){
            String me= e.nextElement().toString();
            apps[count]=(AppointmentWrapper)appGroups.get(me);
            System.out.println("My KEY=>"+me);
            count++;

        }


    }

    private void refreshList() {
        //Vector items = new Vector(0);
        //items= WFStorage.getMWorkItemList(this);
        //System.out.println("after items"+items);
        System.out.println("Abt to check");
        if(WFStorage.getMWorkItemList(this)!=null){
            mWorkItemsList=WFStorage.getMWorkItemList(this);

        }else{
            mWorkItemsList= new Vector(0);
        }
        System.out.println("Size of my objects =>"+mWorkItemsList.size());
    }

    public void errorOccured(String string, Exception excptn) {
    }

    public void actionPerformed(ActionEvent ae) {
        Object src =ae.getSource();
        if(src==list){
            AppointmentWrapper apwr= (AppointmentWrapper)list.getSelectedItem();
System.out.println("Just selected=>"+apwr.getName());
            AppList myList = new AppList(apwr,this);
            AppUtil.get().setView(myList);
        }else{
            Command cmd = ae.getCommand();
            if (cmd==back) {
                LWUITMainMenu mainMenu = new LWUITMainMenu();
                AppUtil.get().setView(mainMenu);
            }
        }
    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
    }

    

}
