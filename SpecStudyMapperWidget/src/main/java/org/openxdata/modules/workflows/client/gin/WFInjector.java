package org.openxdata.modules.workflows.client.gin;

import org.openxdata.modules.workflows.client.presenter.RootPanelPresenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import net.customware.gwt.dispatch.client.gin.ClientDispatchModule;
import org.openxdata.modules.workflows.client.presenter.uimodel.AvailableWIRSModel;
import org.openxdata.modules.workflows.client.presenter.uimodel.ParamQuestionUiModel;
import org.openxdata.modules.workflows.client.presenter.uimodel.SpecStudyUiModel;
import org.openxdata.modules.workflows.client.presenter.uimodel.TaskFormUiModel;

@GinModules({ClientDispatchModule.class, WFModule.class})
public interface WFInjector extends Ginjector
{

    public HandlerManager getHandlerManager();

    public RootPanelPresenter getRootPanelPresenter();

    public RootPanelPresenter.Display getMainPanelDisplay();

    public SpecStudyUiModel getSpecStudyUiModel();

    public TaskFormUiModel getTaskFormUiModel();

    public ParamQuestionUiModel getParamQuestionUiModel();

    public AvailableWIRSModel getAvailableWIRSModel();
}
