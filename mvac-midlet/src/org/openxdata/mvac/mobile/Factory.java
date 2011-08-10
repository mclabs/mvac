package org.openxdata.mvac.mobile;

//~--- non-JDK imports --------------------------------------------------------

import com.sun.lwuit.Image;
import org.openxdata.communication.TransportLayer;
import org.openxdata.forms.FormManager;
import org.openxdata.forms.UserManager;
import org.openxdata.mvac.mobile.command.ActionDispatcher;
import org.openxdata.mvac.mobile.presenter.FormPresenter;
import org.openxdata.mvac.mobile.presenter.MVACChildSearchPresenter;
import org.openxdata.mvac.mobile.presenter.MVACMenuPresenter;
import org.openxdata.mvac.mobile.presenter.MVACQueryPresenter;
import org.openxdata.mvac.mobile.presenter.WIRInfoPresenter;
import org.openxdata.mvac.mobile.presenter.WIRPresenter;
import org.openxdata.mvac.mobile.view.MVACMainMenu;
import org.openxdata.mvac.mobile.view.MVACQuery;
import org.openxdata.mvac.mobile.view.MVACSearch;
import org.openxdata.mvac.mobile.view.WIRInfoView;
import org.openxdata.mvac.mobile.view.WIRView;

//~--- JDK imports ------------------------------------------------------------

import javax.microedition.lcdui.Display;

public class Factory {
    private static ActionDispatcher         commandDispatcher;
    private static Display                  display;
    private static DownloadManager          dldMgr;
    private static FormManager              formManager;
    private static FormPresenter            formPresenter;
    private static WIRInfoPresenter         infoPresenter;
    private static WIRInfoView              infoView;
    private static MVACChildSearchPresenter mVACChildSearchPresenter;
    private static MVACMainMenu             mVACMainMenu;
    private static MVACQuery                mVACQuery;
    private static MVACQueryPresenter       mVACQueryPresenter;
    private static MVACSearch               mVACSearch;
    private static MVACMenuPresenter        menuPresenter;
    private static TransportLayer           tLayer;
    private static UserManager              userMgr;
    //private static WFMainForm               wfMainForm;
    private static WIRPresenter             wirPresenter;
    private static WIRView                  wirView;
    private static Image logo = null;

    static {
        commandDispatcher = new ActionDispatcher();
    }

    public static Display getDisplay() {
        return display;
    }

//    public static void setWfMainForm(WFMainForm wfMainForm) {
//        Factory.wfMainForm = wfMainForm;
//    }
//
//    public static WFMainForm getWFMainForm()
//    {
//        return wfMainForm;
//    }

    public static void setDisplay(Display display) {
        Factory.display = display;
        initTransportLayer();
    }

    private static void initTransportLayer() {
        if (display == null) {
            return;
        }

        tLayer = new TransportLayer();
        tLayer.setDisplay(display);
        tLayer.setPrevScreen(getWirView().getDisplayable());

//      tLayer.setPrevScreen(getmVACMainMenu().getDisplayable());
        tLayer.setDefaultCommunicationParameter(TransportLayer.KEY_HTTP_URL, "http://127.0.0.1:8888/immdownload");
    }

    public static UserManager getUserMgr() {
        if (userMgr == null) {

//          userMgr = new UserManager(display, getWirView().getDisplayable(), "Workflow Mobile", wfMainForm);
            //userMgr = new UserManager(display, getmVACMainMenu().getDisplayable(), "Workflow Mobile", wfMainForm);
        }

        return userMgr;
    }

    public static TransportLayer getTransportLayer() {
        return tLayer;
    }

    public static void setFormManager(FormManager formManager) {
        Factory.formManager = formManager;
    }

    public static FormManager getFormManager() {
        if (formManager == null) {
//            formManager = new FormManager("Workflow Mobile", getDisplay(), wfMainForm.getListener(),
//                                          getWirView().getDisplayable(), getTransportLayer(), wfMainForm.getListener(),
//                                          wfMainForm);
//
////          formManager = new FormManager("Workflow Mobile", getDisplay(), wfMainForm.getListener(),
////                                        getmVACMainMenu().getDisplayable(), getTransportLayer(), wfMainForm.getListener(),
////                                        wfMainForm);
//            formManager.setUserManager(getUserMgr());

            // FormManager.setGlobalInstance(formManager);
        }

        return formManager;
    }

    public static WIRView getWirView() {
        if (wirView == null) {
            wirView = new WIRView(display);
        }

        return wirView;
    }

    public static DownloadManager getDldMgr() {
        if (dldMgr == null) {
            //dldMgr = new DownloadManager(getTransportLayer());
           // dldMgr.setUserMgr(getUserMgr());
        }

        return dldMgr;
    }

    public static WIRPresenter getWirPresenter() {
        if (wirPresenter == null) {
            wirPresenter = new WIRPresenter(display, getDldMgr(), getWirView(), commandDispatcher, tLayer);
        }

        return wirPresenter;
    }

    public static MVACMenuPresenter getMVACMenuPresenter() {
        if (menuPresenter == null) {
            menuPresenter = new MVACMenuPresenter(display, getmVACMainMenu(), commandDispatcher);
        }

        return menuPresenter;
    }

    public static FormPresenter getFormPresenter() {
        if (formPresenter == null) {
            formPresenter = new FormPresenter(getDisplay(), getFormManager(), getDldMgr(), commandDispatcher);
        }

        return formPresenter;
    }

    public static WIRInfoPresenter getWirInfoPresenter() {
        if (infoPresenter == null) {
            infoPresenter = new WIRInfoPresenter(getWirInfoView(), getDldMgr(), getDisplay(), commandDispatcher);
        }

        return infoPresenter;
    }

    public static MVACQueryPresenter getmvacQueryPresenter() {
        if (mVACQueryPresenter == null) {
            mVACQueryPresenter = new MVACQueryPresenter(getmvacQuery(), getDldMgr(), getWirView(), getDisplay(),
                    commandDispatcher);
        }

        return mVACQueryPresenter;
    }

    public static MVACChildSearchPresenter getChildSearchPresenter() {
        if (mVACChildSearchPresenter == null) {
            mVACChildSearchPresenter = new MVACChildSearchPresenter(display, getmvacSearch(), commandDispatcher);
        }

        return mVACChildSearchPresenter;
    }

    public static WIRInfoView getWirInfoView() {
        if (infoView == null) {
            infoView = new WIRInfoView(getDisplay());
        }

        return infoView;
    }

    public static MVACMainMenu getmVACMainMenu() {
        if (mVACMainMenu == null) {
            mVACMainMenu = new MVACMainMenu(display);
        }

        return mVACMainMenu;
    }

    public static MVACQuery getmvacQuery() {
        if (mVACQuery == null) {
            mVACQuery = new MVACQuery(display);
        }

        return mVACQuery;
    }

    public static MVACSearch getmvacSearch() {
        if (mVACSearch == null) {
            mVACSearch = new MVACSearch(display);
        }

        return mVACSearch;
    }

    public static void init() {
        getWirInfoPresenter();
        getFormPresenter();
    }

    public static void dispose() {
        commandDispatcher.clear();
        infoPresenter = null;
        formPresenter = null;
        wirPresenter  = null;
        formManager   = null;
        dldMgr        = null;
        //wfMainForm    = null;
        tLayer        = null;
        infoView      = null;
        userMgr       = null;
        display       = null;
        wirView       = null;
        mVACMainMenu  = null;
    }

    public static void destroy() {
//        wfMainForm.destroyApp(false);
//        wfMainForm.notifyDestroyed();
    }

    public  static Image getLogo(){
        try{
           logo = Image.createImage("/iis_logo.gif");
        }catch(Exception e){e.printStackTrace();}
        return logo;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
