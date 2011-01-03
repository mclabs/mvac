
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.inject.Inject;
import java.util.List;
import org.openxdata.modules.workflows.client.event.NewWIREvent;
import org.openxdata.modules.workflows.client.presenter.uimodel.AvailableWIRSModel;
import org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem;

/**
 *
 * @author kay
 */
public class AvailableWIRPresenter implements
        IPresenter<AvailableWIRPresenter.Display>
{
    public interface Display extends WidgetDisplay
    {
        public void setModel(AvailableWIRSModel model);

        public void refresh();
    }
    private HandlerManager eventBus;
    private Display display;
    private final AvailableWIRSModel model;

    @Inject
    public AvailableWIRPresenter(HandlerManager eventBus, Display display,
                                 AvailableWIRSModel model)
    {
        this.eventBus = eventBus;
        this.display = display;
        this.model = model;
        bindUi();
        bindHandlers();
    }

    private void bindUi()
    {
        display.setModel(model);
    }

    private void bindHandlers()
    {
        eventBus.addHandler(NewWIREvent.TYPE, new NewWIREvent.Handler()
        {
            public void onWirLoaded(GWTFriendlyWorkItem wir)
            {
                loadWorkItem(wir);
            }

            public void onWirsLoaded(List<GWTFriendlyWorkItem> wirs)
            {
                loadWorkItems(wirs);
            }

            public void onWirsDeleted(List<GWTFriendlyWorkItem> wirs)
            {
                deleteWorkItems(wirs);
            }

            public void onWirDeleted(GWTFriendlyWorkItem wir)
            {
                deleteWorkItem(wir);
            }
        });
    }

    private void loadWorkItems(List<GWTFriendlyWorkItem> wirs)
    {
        for (GWTFriendlyWorkItem wir : wirs) {
            model.addWir(wir);
        }
        refreshDisplay();
    }

    private void loadWorkItem(GWTFriendlyWorkItem wir)
    {
        model.addWir(wir);
        refreshDisplay();
    }

    private void deleteWorkItems(List<GWTFriendlyWorkItem> wirs)
    {
        model.deleteWorkItems(wirs);
        refreshDisplay();
    }

    private void deleteWorkItem(GWTFriendlyWorkItem wir)
    {
        model.deleteWorkItems(wir);
        refreshDisplay();
    }

    public Display getDisplay()
    {
        return display;
    }

    public void refreshDisplay()
    {
        display.refresh();
    }
}
