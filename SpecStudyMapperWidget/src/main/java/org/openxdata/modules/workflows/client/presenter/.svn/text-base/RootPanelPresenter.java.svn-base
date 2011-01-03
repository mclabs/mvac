package org.openxdata.modules.workflows.client.presenter;

import org.openxdata.modules.workflows.client.event.ViewLoadItemsEvent;
import org.openxdata.modules.workflows.client.event.ViewSpecStudyEvent;
import org.openxdata.modules.workflows.client.event.ViewTasksFormEvent;
import org.openxdata.modules.workflows.client.event.ViewVariableQuestionEvent;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import org.openxdata.modules.workflows.client.event.ViewAvailableWIREvent;

public class RootPanelPresenter
{
    private final AvailableWIRPresenter availableWIRPresenter;

    public interface Display extends WidgetDisplay
    {
        public void setCurrentDipsplay(WidgetDisplay display);
    }
    private HandlerManager eventBus;
    private Display display;
    private SpecStudyPresenter workFlowPresenter;
    private TaskFormPresenter taskPresenter;
    private SpecificationPresenter specificationPresenter;
    private ParamQuestionPresenter variableQuestionPresenter;

    @Inject
    public RootPanelPresenter(HandlerManager eventBus, Display display,
                              TaskFormPresenter formTaskDisplay,
                              MenuPresenter menuDisplay,
                              SpecStudyPresenter workFlowPresenter,
                              SpecificationPresenter specificationPresenter,
                              ParamQuestionPresenter variableQuestionPresenter,
                              AvailableWIRPresenter availableWIRPresenter)
    {
        this.eventBus = eventBus;
        this.display = display;
        this.workFlowPresenter = workFlowPresenter;
        this.taskPresenter = formTaskDisplay;
        this.specificationPresenter = specificationPresenter;
        this.variableQuestionPresenter = variableQuestionPresenter;
        this.availableWIRPresenter = availableWIRPresenter;
        bindHandlers();

    }

    private void bindHandlers()
    {
        eventBus.addHandler(ViewTasksFormEvent.TYPE, new ViewTasksFormEvent.Handler()
        {
            @Override
            public void onEvent()
            {
                matchTasks();
            }
        });

        eventBus.addHandler(ViewSpecStudyEvent.TYPE, new ViewSpecStudyEvent.Handler()
        {
            @Override
            public void onEvent()
            {
                matchWorkWorklows();
            }
        });

        eventBus.addHandler(ViewLoadItemsEvent.TYPE, new ViewLoadItemsEvent.Handler()
        {
            @Override
            public void onEvent()
            {
                showItemsLoader();
            }
        });
        eventBus.addHandler(ViewVariableQuestionEvent.TYPE, new ViewVariableQuestionEvent.Handler()
        {
            @Override
            public void onEvent()
            {
                showVariableQuestionMapper();
            }
        });
        eventBus.addHandler(ViewAvailableWIREvent.TYPE, new ViewAvailableWIREvent.Handler()
        {
            public void onEvent()
            {
                showAvailableWorkItems();
            }
        });
    }

    private void showVariableQuestionMapper()
    {
        display.setCurrentDipsplay(variableQuestionPresenter.getDisplay());
    }

    private void showItemsLoader()
    {
        display.setCurrentDipsplay(specificationPresenter.getDisplay());
    }

    protected void matchWorkWorklows()
    {
        display.setCurrentDipsplay(workFlowPresenter.getDisplay());
    }

    private void matchTasks()
    {
        display.setCurrentDipsplay(taskPresenter.getDisplay());
    }

    private void showAvailableWorkItems()
    {
        display.setCurrentDipsplay(availableWIRPresenter.getDisplay());
    }

    public Widget asWidget()
    {
        return display.asWidget();
    }
}
