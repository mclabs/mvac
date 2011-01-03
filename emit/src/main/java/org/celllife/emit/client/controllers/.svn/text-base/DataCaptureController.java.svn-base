package org.celllife.emit.client.controllers;

import org.celllife.emit.client.AppMessages;
import org.celllife.emit.client.EmitAsyncCallback;
import org.celllife.emit.client.RefreshableEvent;
import org.celllife.emit.client.RefreshablePublisher;
import org.celllife.emit.client.service.FormServiceAsync;
import org.celllife.emit.client.service.UserServiceAsync;
import org.celllife.emit.client.util.ProgressIndicator;
import org.celllife.emit.client.views.DataCaptureView;
import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.User;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

public class DataCaptureController extends Controller {
    AppMessages appMessages = (AppMessages)GWT.create(AppMessages.class); 
    public final static EventType DATACAPTURE = new EventType();

    private UserServiceAsync userService;
    private FormServiceAsync formService;
    
    public DataCaptureController(UserServiceAsync aUserService, FormServiceAsync aFormService) {
        super();
        registerEventTypes(DATACAPTURE);
        userService = aUserService;
        formService = aFormService;
    }
    
    @Override
    protected void initialize() {
    	Log.info("SurveyCaptureController : initialize");
    }

    @Override
    public void handleEvent(AppEvent event) {
    	Log.info("DataCaptureController : handleEvent");
        EventType type = event.getType();
        if (type == DATACAPTURE) {
        	DataCaptureView dataCaptureView = new DataCaptureView(this);
            forwardToView(dataCaptureView, event);
        }
    }

    public void submit(final DataCaptureView view, final FormDef formDef, final FormData formData) {
    	Log.info("DataCaptureController : onSubmit");
    	ProgressIndicator.showProgressBar();
        userService.getLoggedInUser(new EmitAsyncCallback<User>() {
            @Override
			public void onSuccess(User result) {
            	// set the creator or changedBy user (for tracking)
                if (formData.getCreator() == null) {
                	formData.setCreator(result);
               	} else {
               		formData.setChangedBy(result);
               	}
                // submit the data
                formService.saveFormData(formData, new EmitAsyncCallback<FormData>() {
                    @Override
					public void onSuccess(FormData result) {
                    	ProgressIndicator.hideProgressBar();
                        Window.alert(appMessages.dataSavedSucessfully(""+result.getFormDataId()));
                        RefreshablePublisher.get().publish(
                        		new RefreshableEvent(RefreshableEvent.Type.CAPTURE, result));
                        view.close(false);
                    }
                });
            }
        });
    }
}