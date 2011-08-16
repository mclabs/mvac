package org.openxdata.mvac.mobile.command;

//~--- JDK imports ------------------------------------------------------------

import javax.microedition.lcdui.Command;

public class WFCommands {
    public static Command cmdOpenWir     = new Command("Open", Command.OK, 1);
    public static Command cmdPrevWir     = new Command("Select WorkItems", Command.OK, 1);
    public static Command cmdDld         = new Command("Download", Command.OK, 1);
    public static Command cmdSubmitWir   = new Command("Submit Data", Command.SCREEN, 1);
    public static Command cmdWirDld      = new Command("Download", Command.SCREEN, 1);
    public static Command cmdSelect      = new Command("Select", Command.OK, 0);
    public static Command cmdSearch      = new Command("Find", Command.OK, 0);
    public static Command cmdDldSelected = new Command("Download Selected", Command.SCREEN, 1);
}


//~ Formatted by Jindent --- http://www.jindent.com
