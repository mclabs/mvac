
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
import org.openxdata.mvac.mobile.view.MVACMainMenu;
import org.openxdata.util.DefaultCommands;

//~--- JDK imports ------------------------------------------------------------

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
//import org.openxdata.mvac.mobile.WFMainForm;

/**
 *
 * @author mutahi
 */
public class MVACMenuPresenter extends FormListenerAdaptor implements CommandListener, ActionListener, Viewable {
    private ActionDispatcher   dispatcher     = null;
    private Display            display        = null;
    private MVACMainMenu       mainMenu       = null;
    private MVACQueryPresenter queryPresenter = null;

    public MVACMenuPresenter(Display display, MVACMainMenu menu, ActionDispatcher dispatcher) {
        this.dispatcher     = dispatcher;
        this.display        = display;
        this.mainMenu       = menu;
        this.queryPresenter = Factory.getmvacQueryPresenter();
        dispatcher.registerListener(DefaultCommands.cmdExit, this);
        initMenuCommands();
    }

    public void showItems() {
        mainMenu.showYourSelf();
    }

    private void initMenuCommands() {
        mainMenu.addCommand(DefaultCommands.cmdExit);
        mainMenu.addCommand(DefaultCommands.cmdSelect);
        mainMenu.setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if ((c == DefaultCommands.cmdSelect) || (c == List.SELECT_COMMAND)) {
            int selection = mainMenu.getSelectedMenu();

            switch (selection) {
            case 0 :
                queryPresenter.show();

                break;

            case 1 :
                Factory.getWirPresenter().showItems(true);

                break;

            case 2 :
                Factory.getChildSearchPresenter().show();

                break;

            case 3 :
                Factory.getChildSearchPresenter().setTitle("Register Child/Caretaker");
                Factory.getChildSearchPresenter().show();

                break;

            default :
                break;
            }
        } else if (c == DefaultCommands.cmdExit) {
            Factory.dispose();
            
            
            
        }
    }

    public boolean handle(Command cmd, Viewable disp, Object obj) {
         if (cmd == DefaultCommands.cmdExit) {
           Factory.dispose();
           //Factory.getWFMainForm().notifyDestroyed();
        }
        return false;
    }

    public void show() {
        mainMenu.showYourSelf();
    }

    public Displayable getDisplay() {
        return mainMenu.getDisplayable();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
