package org.openxdata.mvac.mobile.presenter;

//~--- non-JDK imports --------------------------------------------------------

import org.openxdata.communication.TransportLayer;
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
import org.openxdata.mvac.mobile.view.WIRView;
import org.openxdata.util.DefaultCommands;
import org.openxdata.workflow.mobile.model.MWorkItem;
import org.openxdata.workflow.mobile.model.MWorkItemInfoList;
import org.openxdata.workflow.mobile.model.MWorkItemList;

//~--- JDK imports ------------------------------------------------------------

import java.util.Vector;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

public class WIRPresenter extends FormListenerAdaptor
        implements CommandListener, ActionListener, StorageListener, Viewable {
    private final ActionDispatcher dispatcher;
    private final Display          display;
    private final DownloadManager  dldMgr;
    private final TransportLayer   tLayer;
    private final WIRView          view;

    public WIRPresenter(Display display, DownloadManager dldMgr, WIRView view, ActionDispatcher dispacther,
                        TransportLayer tLayer) {
        this.dldMgr     = dldMgr;
        this.view       = view;
        this.display    = display;
        this.dispatcher = dispacther;
        this.tLayer     = tLayer;
        dispacther.registerListener(WFCommands.cmdDldSelected, this);
        initViewCommands();
    }

    private void initViewCommands() {
        view.addCommand(WFCommands.cmdWirDld);
        view.addCommand(WFCommands.cmdOpenWir);
        view.addCommand(WFCommands.cmdSubmitWir);
        view.addCommand(WFCommands.cmdPrevWir);
        view.addCommand(DefaultCommands.cmdSettings);
        view.addCommand(DefaultCommands.cmdBack);
        view.setCommandListener(this);
    }

    public void showItems(boolean downloadIfNo) {
        Vector mWorkItemList = WFStorage.getMWorkItemList(this);

        if (downloadIfNo && ((mWorkItemList == null) || mWorkItemList.isEmpty())) {
            dldWorkItems(null);

            // queryPresenter.show();
        } else {
            view.setWorkItems(mWorkItemList);
            view.showYourSelf();
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (isSubmitWIRSCmd(c)) {
            submitWorkItems();
        } else if (isOpenWorkItemCmd(c)) {
            openWorkItem(c);
        } else if (isDownloadWIRCms(c)) {
            dldWorkItems(null);
        } else if (DefaultCommands.cmdSettings == c) {
            tLayer.getUserSettings(display, view.getDisplayable(), null, null);
        } else if (c == DefaultCommands.cmdBack) {
            Factory.getMVACMenuPresenter().showItems();
        } else {
            dispatcher.fireAction(c, this, null);
        }
    }

    public boolean handle(Command cmd, Viewable disp, Object obj) {
        if (cmd == WFCommands.cmdDldSelected) {
            Vector selected = (Vector) obj;

            dldWorkItems(selected);
        }

        return false;
    }

    private boolean isDownloadWIRCms(Command c) {
        return c == WFCommands.cmdWirDld;
    }

    private boolean isOpenWorkItemCmd(Command c) {
        return (c == WFCommands.cmdOpenWir) || (c == List.SELECT_COMMAND);
    }

    private boolean isSubmitWIRSCmd(Command c) {
        return c == WFCommands.cmdSubmitWir;
    }

    private void dldWorkItems(Vector vector) {
        if ((vector == null) || vector.isEmpty()) {
            dldMgr.downloadWorkItems(this);
        } else {
            MWorkItemInfoList list = new MWorkItemInfoList();

            list.setWorkItemInfo(vector);
            dldMgr.downloadWorkItemsById(list, this);
        }
    }

    private void openWorkItem(Command c) {
        MWorkItem wir = view.getSelectedWorkItem();

        dispatcher.fireAction(WFCommands.cmdOpenWir, this, wir);
    }

    private void submitWorkItems() {
        dldMgr.uploadWorkItems(this);
    }

    public void downloaded(Persistent dataOutParams, Persistent dataOut) {
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
        showItems(false);
    }

    public void errorOccured(String errorMessage, Exception e) {
        view.showError(errorMessage + ": " + e);

        if (e != null) {
            e.printStackTrace();
        }
    }

    public void uploaded(Persistent dataOutParams, Persistent dataOut) {
        ResponseHeader rh = (ResponseHeader) dataOutParams;

        if (rh.isSuccess()) {
            view.setWorkItems(null);
            WFStorage.deleteCompleteWorkItems(this, false);
            showItems(false);
        } else {
            view.showError("Upload failed!");
            showItems(false);
        }
    }

    public Displayable getView() {
        return view.getDisplayable();
    }

    public void show() {
        view.showYourSelf();
    }

    public Displayable getDisplay() {
        return view.getDisplayable();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
