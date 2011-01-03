package org.celllife.emit.client.views;

import java.util.Date;

import org.celllife.emit.client.AppMessages;
import org.celllife.emit.client.controllers.DataCaptureController;
import org.celllife.emit.client.util.ProgressIndicator;
import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.FormDefVersion;
import org.purc.purcforms.client.FormRunnerEntryPoint;
import org.purc.purcforms.client.controller.SubmitListener;
import org.purc.purcforms.client.locale.LocaleText;
import org.purc.purcforms.client.util.FormUtil;
import org.purc.purcforms.client.view.FormRunnerView.Images;
import org.purc.purcforms.client.widget.FormRunnerWidget;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.widget.Window;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;

public class DataCaptureView extends View implements SubmitListener {
    final AppMessages appMessages = (AppMessages)GWT.create(AppMessages.class);    
    private FormDef formDef;
    private FormData formData;
	private FormRunnerWidget widget;
	private boolean displayCloseWarning = true;
	private final Window window = new Window();

    public DataCaptureView(Controller controller) {
        super(controller);
    }
    
    @Override
    protected void initialize() {
        Log.info("DataCaptureView : initialize");
        
        FormUtil.retrieveUserDivParameters();
        FormUtil.setDateDisplayFormat("dd MMM yyyy");
        FormUtil.setDateSubmitFormat("yyyy-MM-dd");
        FormUtil.setDateTimeDisplayFormat("dd MMM yyyy HH:mm:ss");
        FormUtil.setDateTimeSubmitFormat("yyyy-MM-dd HH:mm:ss");
        FormUtil.setTimeDisplayFormat("HH:mm:ss");
        FormUtil.setTimeSubmitFormat("HH:mm:ss");
        FormRunnerEntryPoint.registerAuthenticationCallback();
        
        widget = new FormRunnerWidget((Images)GWT.create(Images.class));
        widget.setSubmitListener(this);

	    window.setPlain(true);  
	    window.setHeading(appMessages.dataCapture());    
	    window.setMaximizable(true);
        window.setMinimizable(false);
        window.setDraggable(false);
	    window.setResizable(false);
	    window.setModal(true);
	    window.setSize(com.google.gwt.user.client.Window.getClientWidth(), com.google.gwt.user.client.Window.getClientHeight());
        window.add(widget);
	    // FIXME: note there are some issues with the purcform widget if you allow the window to be resized (i.e. more than one open at a time)
	    window.setScrollMode(Scroll.AUTO);
	    window.addListener(Events.BeforeHide, new Listener<ComponentEvent>() {
	    	@Override
			public void handleEvent(ComponentEvent be) {
	    		if (displayCloseWarning) {
		    		if (!com.google.gwt.user.client.Window.confirm(LocaleText.get("cancelFormPrompt"))) {
		    			System.out.println("here!");
		    			be.setCancelled(true);
		            }
	    		}
	    	}
	    });
        window.setModal(true);
    }
    
    @Override
    protected void handleEvent(final AppEvent event) {
        if (event.getType() == DataCaptureController.DATACAPTURE) {
        	 Log.info("DataCaptureView : handleEvent - DataCaptureController.DATACAPTURE");
             DeferredCommand.addCommand(new Command() {
                 @Override
				public void execute() {
                	 ProgressIndicator.showProgressBar();
                	 formDef = event.getData("formDef");
                	 formData = event.getData("formData");
                     window.setHeading("Capture data : "+formDef.getName());
                     FormDefVersion formDefVersion = formDef.getDefaultVersion();
		             if (formDefVersion != null && formDefVersion.getXform() != null) {
		            	 if (formData == null) {
		            		 widget.loadForm(formDefVersion.getXform(), formDefVersion.getLayout(), "");
		            	 } else {
		            		 widget.loadForm(0, formDefVersion.getXform(), formData.getData(), formDefVersion.getLayout(), "");
		            	 }
		                  window.show();
		          	      window.maximize();
		          	      ProgressIndicator.hideProgressBar();
		             } else {
		            	 ProgressIndicator.hideProgressBar();
		            	 com.google.gwt.user.client.Window.alert(appMessages.errorWhileRetrievingForms());
		             }
                 }
             });
         }
    }
    
    @Override
	public void onCancel() {
    	Log.info("DataCaptureView : cancelled");
    	close(false);
    }

    @Override
	public void onSubmit(String xml) {
    	Log.info("DataCaptureView : submitted");
    	if (formData == null) {
    		formData = new FormData();
    		formData.setFormDefVersionId(formDef.getDefaultVersion().getFormDefVersionId());
    		//formData.setDescription(Utilities.getDescriptionTemplate(xformXml,xml)); // FIXME: figure out what to do about the description
    		formData.setDateCreated(new Date());
    	} else {
    		formData.setDateChanged(new Date());
    	}
    	formData.setData(xml);
    	DeferredCommand.addCommand(new Command() {
            @Override
			public void execute() {
            	((DataCaptureController)DataCaptureView.this.getController()).submit(DataCaptureView.this, formDef, formData);
            }
    	});
    }
    
    /**
     * Closes the window
     */
    public void close(boolean displayWarning) {
    	displayCloseWarning = displayWarning;
    	window.hide();
    }
}
