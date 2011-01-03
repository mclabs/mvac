package org.openxdata.modules.workflows.client.presenter;

import org.openxdata.modules.workflows.client.event.ViewVariableQuestionEvent;
import org.openxdata.modules.workflows.client.event.ViewTasksFormEvent;
import org.openxdata.modules.workflows.client.event.ViewSpecStudyEvent;
import org.openxdata.modules.workflows.client.event.ViewLoadItemsEvent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import org.openxdata.modules.workflows.client.event.ViewAvailableWIREvent;

public class MenuPresenter implements IPresenter<MenuPresenter.Display>
{

    public interface Display extends WidgetDisplay
    {

        public HasClickHandlers getMatchTasksButton();

        public HasClickHandlers getMatchVariablesButton();

        public HasClickHandlers getSyncRolesButton();

        public HasClickHandlers getAvailableWorkItemsButton();

        public HasClickHandlers getMatchWorkflowsButton();

        public HasClickHandlers getSpecificationsButton();
    }
    private HandlerManager eventBus;
    private Display display;

    @Inject
    public MenuPresenter(HandlerManager eventBus, Display display)
    {
        this.eventBus = eventBus;
        this.display = display;
        bind();
    }

    private void bind()
    {
        display.getMatchTasksButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                eventBus.fireEvent(new ViewTasksFormEvent());
            }
        });

        display.getMatchWorkflowsButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                eventBus.fireEvent(new ViewSpecStudyEvent());
            }
        });

        display.getSpecificationsButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                eventBus.fireEvent(new ViewLoadItemsEvent());
            }
        });

        display.getMatchVariablesButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                eventBus.fireEvent(new ViewVariableQuestionEvent());
            }
        });
        display.getAvailableWorkItemsButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                eventBus.fireEvent(new ViewAvailableWIREvent());
            }
        });
    }

    public Widget asWidget()
    {
        return display.asWidget();
    }

    @Override
    public Display getDisplay()
    {
        return display;
    }
}
