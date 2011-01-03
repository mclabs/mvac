package org.celllife.emit.client.views;

import java.util.ArrayList;
import java.util.List;

import org.celllife.emit.client.AppMessages;
import org.celllife.emit.client.Emit;
import org.celllife.emit.client.Refreshable;
import org.celllife.emit.client.RefreshableEvent;
import org.celllife.emit.client.controllers.FormListController;
import org.celllife.emit.client.model.FormSummary;
import org.celllife.emit.client.util.ProgressIndicator;
import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.FormDefVersion;
import org.openxdata.server.admin.model.StudyDef;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.custom.Portal;
import com.extjs.gxt.ui.client.widget.custom.Portlet;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;

public class FormListView extends View  implements Refreshable  {
    final AppMessages appMessages = (AppMessages)GWT.create(AppMessages.class);	
    
    private Portlet portlet;
	private Grid<FormSummary> grid;
	
    public FormListView(Controller controller) {
        super(controller);
    }
    
    @Override
    protected void initialize() {
    	Log.info("FormListView : initialize");
    	ProgressIndicator.showProgressBar();
        
        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
        configs.add(new ColumnConfig("id", appMessages.id(), 20));
        configs.add(new ColumnConfig("form", appMessages.form(), 580));
        ColumnConfig ver =new ColumnConfig("version", appMessages.version(), 50); 
        ver.setAlignment(HorizontalAlignment.CENTER);
        configs.add(ver);
        ColumnConfig responsesColConfig = new ColumnConfig("responses", appMessages.responses(), 70);
        responsesColConfig.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(responsesColConfig);
        
        ColumnModel cm = new ColumnModel(configs); 
        cm.setHidden(0, true); // hide ID column  
             
        ListStore<FormSummary> store = new ListStore<FormSummary>();
        grid = new Grid<FormSummary>(store, cm);
        grid.setAutoExpandColumn("form");
        grid.setAutoExpandMax(10000);
        grid.setStripeRows(true);
        grid.setBorders(true);
        
        grid.addListener(Events.CellDoubleClick, new Listener<GridEvent<FormSummary>>() {
            @Override
			public void handleEvent(GridEvent<FormSummary> be) {
                if (be.getColIndex() == 1) {
                    captureData();
                } else if (be.getColIndex() == 3) {
                    browseResponses();
                }
            }
        });

        portlet = new Portlet(new FitLayout());
        portlet.setHeading(appMessages.listOfForms()); 
        ContentPanel cp = new ContentPanel();
        cp.setLayout(new FitLayout());
        cp.setHeaderVisible(false);
        cp.add(grid);
        portlet.add(cp);
        portlet.setScrollMode(Scroll.AUTOY);
        portlet.setSize(725,225);
        
        DeferredCommand.addCommand(new Command() {
            @Override
			public void execute() {
                ProgressIndicator.showProgressBar();
                ((FormListController)FormListView.this.getController()).getForms();
            }
        });
        
        Button capture = new Button(appMessages.captureData());       
        capture.addListener(Events.Select, new Listener<ButtonEvent>() {
          @Override
		public void handleEvent(ButtonEvent be) {
              captureData();
          }
        });	
        
        /*Button print = new Button(appMessages.printForm());      
        print.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent be) {
                if (grid.getSelectionModel().getSelectedItem() != null) {
                    String id = grid.getSelectionModel().getSelectedItem().getId();                    
                    FormListController controller = (FormListController) getController();
                    controller.forwardToFormPrint(id);
                } else {
              	  MessageBox.alert(appMessages.printForm(), appMessages.formMustBeSelected(), null);
                }
            }
          });
        */
        Button browseResponses = new Button(appMessages.viewResponses());     
        browseResponses.addListener(Events.Select, new Listener<ButtonEvent>() {
            @Override
			public void handleEvent(ButtonEvent be) {
                browseResponses();
            }
          });
        
        portlet.addButton(capture);
        //portlet.addButton(print);
        portlet.addButton(browseResponses);
    }
    
    public void setFormData(List<FormDef> formDefs) {
    	Log.info("FormListView : setFormData");
    	ProgressIndicator.showProgressBar();
        ListStore<FormSummary> store = grid.getStore();
        store.removeAll();
        for (FormDef formDef : formDefs) {
            final FormDefVersion formVersion = formDef.getDefaultVersion();
            if (formVersion != null) {
                FormSummary formSummary = new FormSummary();
                formSummary.setFormDefinition(formDef);
                formSummary.setId(String.valueOf(formDef.getFormId()));
                formSummary.setForm(formDef.getName());
                formSummary.setVersion(formVersion.getName());
                formSummary.setStatus(appMessages.loading());
                StudyDef study = formDef.getStudy();
                formSummary.setOrganisation(study.getName());
                formSummary.setCreator(formDef.getCreator().getName());
                if (formDef.getDateChanged() == null) {
                    formSummary.setChanged(formDef.getDateCreated());
                } else {
                    formSummary.setChanged(formDef.getDateChanged());
                }            
                formSummary.setResponses(appMessages.loading());
                store.add(formSummary);
                // get response data
                DeferredCommand.addCommand(new Command() {
                    @Override
					public void execute() {
                        ((FormListController)FormListView.this.getController()).hasFormData(formVersion);
                    }
                });
            } else {
                //log.info("FormDef '"+formDef.getName()+"' has been ignored because it does not have any versions (or version marked default)");
            }
        }
        ProgressIndicator.hideProgressBar();
    }
    
    private void captureData() {
        if (grid.getSelectionModel().getSelectedItem() != null) {
            ProgressIndicator.showProgressBar();
            DeferredCommand.addCommand(new Command() {
                @Override
				public void execute() {
                    FormDef formDef = grid.getSelectionModel().getSelectedItem().getFormDefinition();
                    FormListController controller = (FormListController) getController();
                    controller.forwardToDataCapture(formDef);
                }
            });
        } else {
            MessageBox.alert(appMessages.viewResponses(), appMessages.formMustBeSelected(), null);
        }
    }
    
    private void browseResponses() {
        if (grid.getSelectionModel().getSelectedItem() != null) {
            ProgressIndicator.showProgressBar();
            DeferredCommand.addCommand(new Command() {
                @Override
				public void execute() {
                    FormSummary summary = grid.getSelectionModel().getSelectedItem();
                    FormListController controller = (FormListController) getController();
                    controller.forwardToFormResponses(summary);
                }
            });
        } else {
            MessageBox.alert(appMessages.viewResponses(), appMessages.formMustBeSelected(), null);
        }
    }
    
    public void setNumberOfFormResponses(FormDef formDef, Integer numberOfResponses) {
        FormSummary formSummary = getFormSummary(formDef.getFormId());
        if (formSummary != null) {
            formSummary.setResponses(String.valueOf(numberOfResponses));
        }
        grid.getView().refresh(false);
    }
    
    public void setFormStatus(FormDef formDef, Boolean active) {
        FormSummary formSummary = getFormSummary(formDef.getFormId());
        if (formSummary != null) {
            // TODO: fix localisation
            if (active) {
                formSummary.setStatus("active");
            } else {
                formSummary.setStatus("design");
            }
        }
        grid.getView().refresh(false);
    }
    
    FormSummary getFormSummary(int formDefId) {
        String formDefIdStr = String.valueOf(formDefId);
        ListStore<FormSummary> store = grid.getStore();
        for (FormSummary formSummary : store.getModels()) {
            if (formDefIdStr.equals(formSummary.getId())) {
                return formSummary;
            }
        }
        return null;
    }

    @Override
    protected void handleEvent(AppEvent event) {
    	Log.info("FormListView : handleEvent");
        if (event.getType() == FormListController.FORMLIST) {
        	Portal portal = Registry.get(Emit.PORTAL);
        	portal.add(portlet, 0);
          }
    }

	@Override
	public void refresh(RefreshableEvent event) {
		Log.debug("Refreshing...");
        ListStore<FormSummary> store = grid.getStore();
        FormData data = event.getData();
        for (final FormSummary summary : store.getModels()) {
        	FormDef formDef = summary.getFormDefinition();
        	FormDefVersion formDefVer = formDef.getDefaultVersion();
        	if (data.getFormDefVersionId().equals(formDefVer.getFormDefVersionId())) {
                DeferredCommand.addCommand(new Command() {
                    @Override
					public void execute() {
                        ((FormListController)FormListView.this.getController()).hasFormData(summary.getFormDefinition().getDefaultVersion());
                    }
                });
                break;
        	}
        }
	}
}
