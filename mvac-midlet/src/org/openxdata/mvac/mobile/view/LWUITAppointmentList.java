/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Form;
import com.sun.lwuit.List;
import com.sun.lwuit.TextField;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.midlet.MIDletStateChangeException;
import org.openxdata.db.util.StorageListener;
import org.openxdata.mvac.mobile.MvacMidlet;
import org.openxdata.mvac.mobile.db.WFStorage;

import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.Constants;
import org.openxdata.mvac.mobile.util.view.api.IView;

/**
 *
 * @author mutahi
 */
public class LWUITAppointmentList extends Form implements IView,StorageListener{
    private List appointmentList;
    private Container container;
    private TextField search;
    private Vector mWorkItemsList;



    //Test Data
    private String[] names = {"John" , "Mary" , "Mimano" , "Wesonga"};
    


    public LWUITAppointmentList() {
        super("Appointments");
        initAppointmentsList();


    }

    void initAppointmentsList(){
        setLayout(new BorderLayout());

        container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        search = new TextField();


        appointmentList = new List();
        initListModel();

        for(int i = 0 ; i < names.length ; i++){
            appointmentList.addItem(names[i]);
        }
        container.addComponent(appointmentList);

        this.addComponent(BorderLayout.NORTH , search);
        this.addComponent(BorderLayout.CENTER ,container);

        addCommand(new Command("Exit"){
            public void actionPerformed(ActionEvent ae){
     System.out.println("Exit Command");

                //Place Code here
     try {
                    ((MvacMidlet) AppUtil.get().getItem(Constants.MIDLET)).exitApp(true);
                } catch (MIDletStateChangeException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }



    public Object getScreenObject() {
        return this;
    }

    public void resume(Hashtable args) {
        AppUtil.get().setView(this);
    }

    public void errorOccured(String string, Exception e) {
        //display error mesage Here
        if (e != null) {
            e.printStackTrace();
        }
    }

    private void initListModel() {
        mWorkItemsList= WFStorage.getMWorkItemList(this);
        

    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
    }

}
