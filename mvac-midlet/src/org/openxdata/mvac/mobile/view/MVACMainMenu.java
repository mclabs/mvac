
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package org.openxdata.mvac.mobile.view;

//~--- non-JDK imports --------------------------------------------------------

import org.openxdata.util.AlertMessageListener;
import org.openxdata.util.DefaultCommands;

//~--- JDK imports ------------------------------------------------------------

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author mutahi
 */
public class MVACMainMenu implements AlertMessageListener {
    private List           mainMenu = null;
    private final String[] options  = { "Download Appointments", "Appointments", "Find Child/Caretaker",
            "Register Child/Caretaker" };;
    private Display display;

    public MVACMainMenu() {
        initMenu();
    }

    public MVACMainMenu(Display display2) {
        this();
        this.display = display2;
    }

    private void initMenu() {
        mainMenu = new List("Main Menu", List.IMPLICIT);

        for (int i = 0; i < options.length; i++) {
            mainMenu.append(options[i], null);
        }
    }

    public void showYourSelf() {
        display.setCurrent(mainMenu);
    }

    public Displayable getDisplayable() {
        return mainMenu;
    }

    public void addCommand(Command cmd) {
        mainMenu.addCommand(cmd);
    }

    public void setCommandListener(CommandListener l) {
        mainMenu.setCommandListener(l);
    }

    public int getSelectedMenu() {
        int idx = mainMenu.getSelectedIndex();

        return idx;
    }

    public void onAlertMessage(byte b) {
        try {
            display.setCurrent(mainMenu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
