package org.openxdata.modules.workflows.client.presenter;


import org.openxdata.modules.workflows.client.event.ACTION;
import org.openxdata.modules.workflows.client.event.NewTaskFormEvent;
import org.openxdata.modules.workflows.client.event.NewSpecStudyMapEvent;
import org.openxdata.modules.workflows.client.presenter.uimodel.TaskFormUiModel;
import org.openxdata.modules.workflows.client.maps.SpecStudyMap;
import org.openxdata.modules.workflows.client.maps.TaskFormDefMap;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasText;
import com.google.inject.Inject;

public class TaskFormPresenter implements IPresenter<TaskFormPresenter.Display> {

    public interface Display extends WidgetDisplay {

        public HasClickHandlers getSpecStudyMapList();

        public String getSelectedSpecStudy();

        public String getSelectedTaskForm();

        public HasText getTaskTxt();

        public HasText getFormTxt();

        public void showError(String error);

        public HasClickHandlers getAddMacthButton();

        public HasClickHandlers getDeleteMatchButton();

        public void setModel(TaskFormUiModel model);

        public void refresh();
    }
    private Display display;
    private HandlerManager eventBus;
    private TaskFormUiModel model;

    @Inject
    public TaskFormPresenter(HandlerManager eventBus,
                             TaskFormUiModel model, Display display) {

        this.eventBus = eventBus;

        this.display = display;
        this.model = model;

        this.display.setModel(model);
        bindUi();
        bindHandlers();

    }

    private void bindUi() {
        display.getAddMacthButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                addTaskFormMatch();
            }
        });
        display.getDeleteMatchButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                deleteTaskFormMatch();
            }
        });

        display.getSpecStudyMapList().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                setCurrentSpecStudy();
            }
        });

    }

    private void bindHandlers() {
        NewSpecStudyMapEvent.Handler specStudyEvtHandler = new NewSpecStudyMapEvent.Handler() {

            @Override
            public void mapDeleted(SpecStudyMap map) {
                deleteSpecStudyMap(map);
            }

            @Override
            public void mapCreated(SpecStudyMap map) {
                addSpecStudyMap(map);
            }
        };
        eventBus.addHandler(NewSpecStudyMapEvent.TYPE, specStudyEvtHandler);
    }

    protected void deleteTaskFormMatch() {
        String selectedPattern = display.getSelectedTaskForm();
        if (selectedPattern == null) {
            display.showError("Please Select a Pattern");
            return;
        }

        TaskFormDefMap removedMap = model.removeTaskFormDefMap(selectedPattern);

        eventBus.fireEvent(new NewTaskFormEvent(removedMap, ACTION.DELETE));
        refreshDisplay();
    }

    protected void addTaskFormMatch() {
        String formTxt = display.getFormTxt().getText();
        if (formTxt == null || formTxt.equals("")) {
            display.showError("Please select a Form");
            return;
        }
        String taskTxt = display.getTaskTxt().getText();
        if (taskTxt == null || taskTxt.equals("")) {
            display.showError("Please Select a Task");
            return;
        }
        TaskFormDefMap addedMap = model.addTaskFormDefMap(taskTxt, formTxt);
        eventBus.fireEvent(new NewTaskFormEvent(addedMap, ACTION.ADD));
        refreshDisplay();
    }

    protected void setCurrentSpecStudy() {
        String selectedPattern = display.getSelectedSpecStudy();
        model.setCurrentSpecStudyMap(selectedPattern);
        refreshDisplay();
    }

    protected void deleteSpecStudyMap(SpecStudyMap map) {
        model.removeSpecStudyMap(map);
        //Notify all other items listening over a deleted map
        for (TaskFormDefMap tfMap : map.getTaskFormDefMaps()) {
            eventBus.fireEvent(new NewTaskFormEvent(tfMap, ACTION.DELETE));
        }
        refreshDisplay();
    }

    protected void addSpecStudyMap(SpecStudyMap map) {
        model.addSpecStudyMap(map);
        refreshDisplay();
    }

    @Override
    public Display getDisplay() {
        return display;
    }

    private void refreshDisplay() {
        display.refresh();
    }
}
