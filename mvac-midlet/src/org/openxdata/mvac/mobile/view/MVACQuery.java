
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package org.openxdata.mvac.mobile.view;

//~--- non-JDK imports --------------------------------------------------------

import javax.microedition.lcdui.ChoiceGroup;
import org.openxdata.util.AlertMessageListener;

//~--- JDK imports ------------------------------------------------------------

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

/**
 *
 * @author mutahi
 */
public class MVACQuery implements AlertMessageListener {
    private Display     display = null;
    private ChoiceGroup options = null;
    private Form        query   = null;

    public MVACQuery() {
        initForm();
    }

    public MVACQuery(Display display2) {
        this();
        this.display = display2;
    }

    void initForm() {
        query   = new Form("Download Appointments");
        options = new ChoiceGroup("Select Date Range", ChoiceGroup.POPUP);

        String[] stringOptions = { "1 Week", "2 Weeks", "3 Weeks", "4 Weeks" };

        for (int i = 0; i < stringOptions.length; i++) {
            options.append(stringOptions[i], null);
        }

        query.append(options);
    }

    public void showYourSelf() {
        display.setCurrent(query);
    }

    public Displayable getDisplayable() {
        return query;
    }

    public void addCommand(Command cmd) {
        query.addCommand(cmd);
    }

    public void setCommandListener(CommandListener l) {
        query.setCommandListener(l);
    }

    public int getSelectedOption() {
        return options.getSelectedIndex();
    }

    public void onAlertMessage(byte b) {
        try {
            display.setCurrent(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
