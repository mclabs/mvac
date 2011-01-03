/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.client.view;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLTable.RowFormatter;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;
import org.openxdata.modules.workflows.client.presenter.AvailableWIRPresenter;
import org.openxdata.modules.workflows.client.presenter.uimodel.AvailableWIRSModel;
import org.openxdata.modules.workflows.client.util.WidgetUtil;
import org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem;

/**
 *
 * @author kay
 */
public class AvailableWIRView implements AvailableWIRPresenter.Display
{
    private VerticalPanel vPnl = new VerticalPanel();
    private FlexTable wirsTable = new FlexTable();
    private AvailableWIRSModel model;
    private RowFormatter rowFormatter;

    public AvailableWIRView()
    {

        vPnl.add(new HTML("<b>Avalaible WorkItems</b>"));

        rowFormatter = wirsTable.getRowFormatter();
        WidgetUtil.maximise(wirsTable);
        ScrollPanel scrollPanel = new ScrollPanel(wirsTable);
        WidgetUtil.maximise(scrollPanel);
        vPnl.add(scrollPanel);

        WidgetUtil.maximise(vPnl);
    }

    public void setModel(AvailableWIRSModel model)
    {
        this.model = model;
        refresh();
    }

    public void refresh()
    {
        wirsTable.clear();
        wirsTable.setWidget(0, 0, new Label("WorkItem Id"));
        wirsTable.setWidget(0, 1, new Label("Enable Time"));
        wirsTable.setWidget(0, 2, new Label("State"));
        rowFormatter.addStyleName(0, "flex-Heading-Table");

        List<GWTFriendlyWorkItem> wirs = model.getWorkItems();
        int row = 1;
        for (GWTFriendlyWorkItem wir : wirs) {
            wirsTable.setWidget(row, 0, new Label(wir.getTaskNames4Disp()));
            wirsTable.setWidget(row, 1, new Label(wir.getEnabledTime()));
            wirsTable.setWidget(row, 2, new Label(wir.getState()));
            setColorForTableRow(row);
            row++;
        }
    }

    public Widget asWidget()
    {
        return vPnl;
    }

    public void showMessage(String message)
    {
    }

    private void setColorForTableRow(int row)
    {
        if (row % 2 == 0)
            rowFormatter.addStyleName(row, "flex-Even-Row");
        else
            rowFormatter.addStyleName(row, "flex-Odd-Row");
    }
}
