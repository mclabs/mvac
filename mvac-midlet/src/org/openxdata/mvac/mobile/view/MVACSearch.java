
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package org.openxdata.mvac.mobile.view;

//~--- non-JDK imports --------------------------------------------------------

import org.openxdata.util.AlertMessageListener;

//~--- JDK imports ------------------------------------------------------------

import java.util.Date;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author mutahi
 */
public class MVACSearch implements AlertMessageListener {
    private DateField birthdate      = null;
    private Form      childSearch    = null;
    private Display   display        = null;
    private TextField txt_birthplace = null;
    private TextField txt_fname      = null;
    private TextField txt_lname      = null;
    private TextField txt_nationalID = null;

    public MVACSearch() {
        initForm();
    }

    public MVACSearch(Display display2) {
        this();
        this.display = display2;
    }

    void initForm() {
        childSearch    = new Form("Child Search Form");
        txt_nationalID = new TextField("National_ID", "", 20, TextField.ANY);
        txt_fname      = new TextField("FirstName", "", 30, TextField.INITIAL_CAPS_WORD);
        txt_lname      = new TextField("LastName", "", 30, TextField.ANY);
        txt_birthplace = new TextField("Birthplace", "", 30, TextField.ANY);
        birthdate      = new DateField("Bithdate", DateField.DATE);
        childSearch.append(txt_nationalID);
        childSearch.append(txt_fname);
        childSearch.append(txt_lname);
        childSearch.append(txt_birthplace);
        childSearch.append(birthdate);
    }

    public String getNationalID() {
        return txt_nationalID.getString();
    }

    public String getFName() {
        return txt_fname.getString();
    }

    public String getLName() {
        return txt_lname.getString();
    }

    public String getBirthPlace() {
        return txt_birthplace.getString();
    }

    public Date getbirthDate() {
        return birthdate.getDate();
    }

    public void showYourSelf() {
        display.setCurrent(childSearch);
    }

    public Displayable getDisplayable() {
        return childSearch;
    }

    public void addCommand(Command cmd) {
        childSearch.addCommand(cmd);
    }

    public void setCommandListener(CommandListener l) {
        childSearch.setCommandListener(l);
    }

    public void onAlertMessage(byte b) {
        try {
            display.setCurrent(childSearch);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTitle(String title) {
        childSearch.setTitle(title);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
