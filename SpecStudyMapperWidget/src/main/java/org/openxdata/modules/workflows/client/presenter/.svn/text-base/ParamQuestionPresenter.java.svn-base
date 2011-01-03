package org.openxdata.modules.workflows.client.presenter;

import org.openxdata.modules.workflows.client.event.NewTaskFormEvent;
import org.openxdata.modules.workflows.client.presenter.uimodel.ParamQuestionUiModel;
import org.openxdata.modules.workflows.shared.exception.TypeMisMatchException;
import org.openxdata.modules.workflows.client.maps.TaskFormDefMap;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasText;
import com.google.inject.Inject;

public class ParamQuestionPresenter implements IPresenter<WidgetDisplay>
{
    public interface Display extends WidgetDisplay
    {
        public HasClickHandlers getTaskFormVersionList();

        public HasClickHandlers getAddMatchButton();

        public HasClickHandlers getRemoveMatchButton();

        public String getSelectedMapString();

        public HasText getVariableText();

        public HasText getQuestionText();

        public void refresh();

        public void setModel(ParamQuestionUiModel model);

        public String getSelectedTaskFormVersionString();
    }
    private Display display;
    private HandlerManager eventBus;
    private ParamQuestionUiModel model;

    @Inject
    public ParamQuestionPresenter(HandlerManager eventBus, Display display,
                                  ParamQuestionUiModel model)
    {
        this.display = display;
        this.eventBus = eventBus;
        this.model = model;
        bindUi();
        initHandlers();
    }

    private void initHandlers()
    {
        NewTaskFormEvent.Handler handler = new NewTaskFormEvent.Handler()
        {
            @Override
            public void onCreated(TaskFormDefMap map)
            {
                addTaskFormDefMap(map);
            }

            @Override
            public void onDeleted(TaskFormDefMap map)
            {
                deleteTaskFormDefMap(map);
            }
        };
        eventBus.addHandler(NewTaskFormEvent.TYPE, handler);

    }

    private void bindUi()
    {
        display.setModel(model);
        display.getAddMatchButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                addMatch();
            }
        });
        display.getTaskFormVersionList().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                setCurrentTaskFormVersionMap();
            }
        });
        display.getRemoveMatchButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                deleteParamQuestionMap();
            }
        });
    }

    public void deleteTaskFormDefMap(TaskFormDefMap map)
    {
        model.removeTaskFormDefMap(map);
        refreshDiplay();
    }

    protected void deleteParamQuestionMap()
    {
        String mapString = display.getSelectedMapString();
        if (mapString == null || mapString.equals("")) {
            display.showMessage("Please select a match");
            return;
        }
        model.removeParmaQuestionMapForString(mapString);
        refreshDiplay();
    }

    protected void setCurrentTaskFormVersionMap()
    {
        String taskFormVersion = display.getSelectedTaskFormVersionString();
        if (taskFormVersion == null || taskFormVersion.equals("")) {
            return;
        }
        model.setCurrentTaskFormVersion(taskFormVersion);
        refreshDiplay();
    }

    public void addTaskFormDefMap(TaskFormDefMap map)
    {
        model.addTaskFormDefMap(map);
        refreshDiplay();

    }

    public void addMatch()
    {
        String question = display.getQuestionText().getText();
        if (question == null || question.equals("")) {
            display.showMessage("Please Select a question");
            return;
        }

        String parameter = display.getVariableText().getText();
        if (parameter == null || parameter.equals("")) {
            display.showMessage("Please Select a Task Parameter");
            return;
        }

        try {
            model.addParamQuestionMap(parameter, question);
            refreshDiplay();
        } catch (TypeMisMatchException ex) {
            display.showMessage(ex.getMessage());
        }


    }

    private void refreshDiplay()
    {
        display.refresh();
    }

    @Override
    public WidgetDisplay getDisplay()
    {
        return display;
    }
}
