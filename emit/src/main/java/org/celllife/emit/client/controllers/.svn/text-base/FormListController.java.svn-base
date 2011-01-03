package org.celllife.emit.client.controllers;

import java.util.List;

import org.celllife.emit.client.AppMessages;
import org.celllife.emit.client.EmitAsyncCallback;
import org.celllife.emit.client.RefreshableEvent;
import org.celllife.emit.client.RefreshablePublisher;
import org.celllife.emit.client.model.FormSummary;
import org.celllife.emit.client.service.FormServiceAsync;
import org.celllife.emit.client.views.FormListView;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.FormDefVersion;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.GWT;

public class FormListController extends Controller {
    AppMessages appMessages = (AppMessages)GWT.create(AppMessages.class); 
    public final static EventType FORMLIST = new EventType();

    private FormListView formListView;
    private FormServiceAsync formService;
    
    public FormListController(FormServiceAsync aFormService) {
        super();
        formService = aFormService;
        registerEventTypes(FORMLIST);
    }
    
    @Override
    protected void initialize() {
        Log.info("FormListController : initialize");
        formListView = new FormListView(this);
        RefreshablePublisher.get().subscribe(RefreshableEvent.Type.CAPTURE, formListView);
    }

    @Override
    public void handleEvent(AppEvent event) {
    	Log.info("FormListController : handleEvent");
        EventType type = event.getType();
        if (type == FORMLIST) {
            forwardToView(formListView, event);
        }
    }
    
    public void forwardToDataCapture(FormDef formDef){
    	Log.info("FormListController : forwardToDataCapture");
        Dispatcher dispatcher = Dispatcher.get();
        AppEvent event = new AppEvent(DataCaptureController.DATACAPTURE);
        event.setData("formDef", formDef);
    	dispatcher.dispatch(event);
    }
        
    public void forwardToFormPrint(String id){
    	Log.info("FormListController : forwardToFormPrint");
    	Dispatcher dispatcher = Dispatcher.get();
    	dispatcher.dispatch(FormPrintController.FORMPRINTVIEW);
    }     
        
    public void forwardToFormResponses(FormSummary formSummary){
    	Log.info("FormListController : forwardToFormResponses");
    	Dispatcher dispatcher = Dispatcher.get();
    	dispatcher.dispatch(FormResponsesController.BROWSE, formSummary);
    }
    
    public void getForms() {
    	Log.info("FormListController : getForms");
        formService.getFormsForCurrentUser(new EmitAsyncCallback<List<FormDef>>() {
            @Override
			public void onSuccess(List<FormDef> result) {
                formListView.setFormData(result);
            }
        });
    }
    
    public void hasFormData(final FormDefVersion formDefVersion) {
    	Log.info("FormListController : hasFormData");
        formService.getFormResponseCount(formDefVersion.getFormDefVersionId(), new EmitAsyncCallback<Integer>() {
            @Override
			public void onSuccess(Integer result) {
                if (result > 0) {
                    formListView.setFormStatus(formDefVersion.getFormDef(), true);
                } else {
                    formListView.setFormStatus(formDefVersion.getFormDef(), false);
                }
                formListView.setNumberOfFormResponses(formDefVersion.getFormDef(), result);
            }
        });
    }
}