
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package org.openxdata.mvac.mobile.presenter;

//~--- non-JDK imports --------------------------------------------------------

import org.openxdata.mvac.mobile.Factory;
import org.openxdata.mvac.mobile.FormListenerAdaptor;
import org.openxdata.mvac.mobile.command.ActionDispatcher;
import org.openxdata.mvac.mobile.command.ActionListener;
import org.openxdata.mvac.mobile.command.Viewable;
import org.openxdata.mvac.mobile.command.WFCommands;
import org.openxdata.mvac.mobile.view.MVACSearch;
import org.openxdata.util.DefaultCommands;

//~--- JDK imports ------------------------------------------------------------

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;

/**
 *
 * @author mutahi
 */
public class MVACChildSearchPresenter extends FormListenerAdaptor implements CommandListener, ActionListener, Viewable {
    private ActionDispatcher dispatcher = null;
    private Display          display    = null;
    private MVACSearch       search     = null;

    public MVACChildSearchPresenter(Display display, MVACSearch mVACSearch, ActionDispatcher dispatcher) {
        this.search     = mVACSearch;
        this.display    = display;
        this.dispatcher = dispatcher;
        initCommands();
    }

    void initCommands() {
        search.addCommand(WFCommands.cmdSearch);
        search.addCommand(DefaultCommands.cmdBack);
        search.setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == WFCommands.cmdSearch) {

            // Search Code Here
        } else if (c == DefaultCommands.cmdBack) {
            Factory.getMVACMenuPresenter().showItems();
        }
    }

    public boolean handle(Command cmd, Viewable disp, Object obj) {
        return false;
    }

    public void show() {
        search.showYourSelf();
    }

    public Displayable getDisplay() {
        return search.getDisplayable();
    }

    public void setTitle(String title) {
        search.setTitle(title);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
