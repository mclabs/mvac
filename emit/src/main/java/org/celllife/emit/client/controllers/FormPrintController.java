package org.celllife.emit.client.controllers;

import org.celllife.emit.client.views.FormPrintView;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;

public class FormPrintController extends Controller {

    public final static EventType FORMPRINTVIEW = new EventType();

    private FormPrintView formPrintView;
    
    public FormPrintController() {
        super();
        registerEventTypes(FORMPRINTVIEW);
    }
    
    @Override
    protected void initialize() {
        Log.info("FormPrintController : initialize");
        formPrintView = new FormPrintView(this);
    }

    @Override
    public void handleEvent(AppEvent event) {
    	Log.info("SurveyViewController handleEvent");
        EventType type = event.getType();
        if (type == FORMPRINTVIEW) {
            forwardToView(formPrintView, event);
        }
    }
}
