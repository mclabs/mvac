package org.openxdata.modules.workflows.client.gin;

import org.openxdata.modules.workflows.client.presenter.MenuPresenter;
import org.openxdata.modules.workflows.client.presenter.RootPanelPresenter;
import org.openxdata.modules.workflows.client.presenter.SpecStudyPresenter;
import org.openxdata.modules.workflows.client.presenter.SpecificationPresenter;
import org.openxdata.modules.workflows.client.presenter.TaskFormPresenter;
import org.openxdata.modules.workflows.client.presenter.ParamQuestionPresenter;
import org.openxdata.modules.workflows.client.presenter.uimodel.SpecStudyUiModel;
import org.openxdata.modules.workflows.client.presenter.uimodel.TaskFormUiModel;
import org.openxdata.modules.workflows.client.presenter.uimodel.ParamQuestionUiModel;
import org.openxdata.modules.workflows.client.view.MenuView;
import org.openxdata.modules.workflows.client.view.RootPanelView;
import org.openxdata.modules.workflows.client.view.SpecToStudyView;
import org.openxdata.modules.workflows.client.view.SpecificationView;
import org.openxdata.modules.workflows.client.view.TaskFormView;
import org.openxdata.modules.workflows.client.view.ParamQuestionView;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import org.openxdata.modules.workflows.client.presenter.AvailableWIRPresenter;
import org.openxdata.modules.workflows.client.presenter.uimodel.AvailableWIRSModel;
import org.openxdata.modules.workflows.client.view.AvailableWIRView;

public class WFModule extends AbstractGinModule
{

    protected void configure()
    {
        // Event Bus
        bind(HandlerManager.class).toProvider(EventBusProvider.class).in(Singleton.class);

        // Root Panel
        bind(RootPanelPresenter.class).in(Singleton.class);
        bind(RootPanelPresenter.Display.class).to(RootPanelView.class).in(Singleton.class);

        // Menus
        bind(MenuPresenter.class).in(Singleton.class);
        bind(MenuPresenter.Display.class).to(MenuView.class).in(Singleton.class);

        // FormTasksMatcher Panel
        bind(TaskFormPresenter.class).in(Singleton.class);
        bind(TaskFormPresenter.Display.class).to(TaskFormView.class).in(Singleton.class);
        bind(TaskFormUiModel.class).in(Singleton.class);

        // StudyMatcher Panel
        bind(SpecStudyPresenter.class).in(Singleton.class);
        bind(SpecStudyPresenter.Display.class).to(SpecToStudyView.class).in(Singleton.class);
        bind(SpecStudyUiModel.class).in(Singleton.class);

        // WorkFlow loader
        bind(SpecificationPresenter.class).in(Singleton.class);
        bind(SpecificationPresenter.Display.class).to(SpecificationView.class).in(Singleton.class);

        // Variables to questions
        bind(ParamQuestionPresenter.class).in(Singleton.class);
        bind(ParamQuestionPresenter.Display.class).to(ParamQuestionView.class).in(Singleton.class);
        bind(ParamQuestionUiModel.class).in(Singleton.class);

        // Available WorkItems
        bind(AvailableWIRPresenter.class).in(Singleton.class);
        bind(AvailableWIRPresenter.Display.class).to(AvailableWIRView.class).in(Singleton.class);
        bind(AvailableWIRSModel.class).in(Singleton.class);

    }
}
