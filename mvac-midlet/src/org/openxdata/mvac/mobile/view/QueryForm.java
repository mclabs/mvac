
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package org.openxdata.mvac.mobile.view;

//~--- non-JDK imports --------------------------------------------------------

import org.openxdata.mvac.mobile.command.WFCommands;

//~--- JDK imports ------------------------------------------------------------

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

/**
 *
 * @author mutahi
 */
public class QueryForm extends Form implements CommandListener {
    private ChoiceGroup dateRange   = null;
    private String[]    stringRange = { "1 Week", "2 Weeks", "3 Weeks", "4 Weeks" };

    public QueryForm() {
        super("Download Appointments");
        initVariables();
    }

    public void setCommanListener() {
        this.setCommandListener(this);
    }

    public void initVariables() {
        dateRange = new ChoiceGroup("Select Appointments Date Range ", ChoiceGroup.EXCLUSIVE);

        for (int i = 0; i < stringRange.length; i++) {
            dateRange.append(stringRange[i], null);
        }

        this.append(dateRange);
        this.addCommand(WFCommands.cmdWirDld);
        setCommanListener();
    }

    public void commandAction(Command c, Displayable d) {
        if (c == WFCommands.cmdWirDld) {

            // Download Appintments
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
