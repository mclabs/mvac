
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package org.openxdata.mvac.mobile.presenter;

//~--- non-JDK imports --------------------------------------------------------

import org.openxdata.db.util.Persistent;
import org.openxdata.db.util.StorageListener;
import org.openxdata.model.ResponseHeader;
import org.openxdata.mvac.mobile.DownloadManager;
import org.openxdata.mvac.mobile.Factory;
import org.openxdata.mvac.mobile.FormListenerAdaptor;
import org.openxdata.mvac.mobile.command.ActionDispatcher;
import org.openxdata.mvac.mobile.command.ActionListener;
import org.openxdata.mvac.mobile.command.Viewable;
import org.openxdata.mvac.mobile.command.WFCommands;
import org.openxdata.mvac.mobile.db.WFStorage;
import org.openxdata.mvac.mobile.view.MVACQuery;
import org.openxdata.mvac.mobile.view.WIRView;
import org.openxdata.util.DefaultCommands;
import org.openxdata.workflow.mobile.model.MWorkItemInfoList;
import org.openxdata.workflow.mobile.model.MWorkItemList;

//~--- JDK imports ------------------------------------------------------------

import java.util.Vector;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;

/**
 *
 * @author mutahi
 */
public class MVACQueryPresenter extends FormListenerAdaptor
        implements CommandListener, ActionListener, Viewable, StorageListener {
    private WIRView          view = null;
    private ActionDispatcher dispatcher;
    private Display          display;
    private DownloadManager  downloadManager;
    private MVACQuery        queryForm;
    private WIRPresenter     wIRPresenter;

    public MVACQueryPresenter(MVACQuery queryForm, DownloadManager manager, WIRView wIRView, Display display,
                              ActionDispatcher dispatcher) {
        this.queryForm       = queryForm;
        this.display         = display;
        this.dispatcher      = dispatcher;
        this.view            = wIRView;
        this.wIRPresenter    = Factory.getWirPresenter();
        this.downloadManager = manager;
        dispatcher.registerListener(WFCommands.cmdDldSelected, this);
        initQueryCommands();
    }

    void initQueryCommands() {
        queryForm.addCommand(WFCommands.cmdWirDld);
        queryForm.addCommand(DefaultCommands.cmdBack);
        queryForm.setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == WFCommands.cmdWirDld) {
            dldWorkItems(null);
        } else if (c == DefaultCommands.cmdBack) {
            Factory.getMVACMenuPresenter().showItems();
        }
    }

    public boolean handle(Command cmd, Viewable disp, Object obj) {
        if (cmd == WFCommands.cmdDldSelected) {
            Vector selected = (Vector) obj;

            dldWorkItems(selected);
        }

        return false;
    }

    private void dldWorkItems(Vector vector) {
        if ((vector == null) || vector.isEmpty()) {
            downloadManager.downloadWorkItems(this);
        } else {
            MWorkItemInfoList list = new MWorkItemInfoList();

            list.setWorkItemInfo(vector);
            downloadManager.downloadWorkItemsById(list, this);
        }
    }

    public void show() {
        queryForm.showYourSelf();
    }

    public Displayable getDisplay() {
        return queryForm.getDisplayable();
    }

    public void downloaded(Persistent dataOutParams, Persistent dataOut) {
        System.out.println("Downloaded...");
        ResponseHeader rh = (ResponseHeader) dataOutParams;

        if (!rh.isSuccess()) {
            return;
        } else if (dataOut instanceof MWorkItemList) {
            saveAndDisplayWorkItems((MWorkItemList) dataOut);
        }
    }

    private void saveAndDisplayWorkItems(MWorkItemList dataOut) {
        if (dataOut.getmWorkItems().isEmpty()) {
            view.showMsg("No WorkItems Available");

            return;
        }

        WFStorage.saveMWorkItemList(dataOut, this);
        wIRPresenter.showItems(false);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
