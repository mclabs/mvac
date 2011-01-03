package org.openxdata.modules.workflows.client.view;

import org.openxdata.modules.workflows.client.presenter.MenuPresenter;
import org.openxdata.modules.workflows.client.presenter.RootPanelPresenter;
import org.openxdata.modules.workflows.client.presenter.WidgetDisplay;
import org.openxdata.modules.workflows.client.presenter.SpecStudyPresenter;
import org.openxdata.modules.workflows.client.util.WidgetUtil;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class RootPanelView implements RootPanelPresenter.Display
{

    VerticalPanel pnlVerticalRoot = new VerticalPanel();
    private HorizontalSplitPanel pnlHorizontalSplit = new HorizontalSplitPanel();

    private MenuPresenter.Display menuDisplay;
    private WidgetDisplay rightDisplay;

    @Inject
    public RootPanelView(MenuPresenter.Display menuDisplay,
	    SpecStudyPresenter.Display workFlowDisplay)
    {

	this.menuDisplay = menuDisplay;// .getDisplay();
	this.rightDisplay = workFlowDisplay;// .getDisplay();

	init();
    }

    private void init()
    {

	WidgetUtil.maximise(pnlHorizontalSplit);
	HTML header = new HTML(
		"<div style=\"background: lightBlue none repeat scroll 0% 0%;  color: black; text-align: left ; font-size: 15px;\"><strong>Workflow Admin Console</strong></div>");
	pnlVerticalRoot.add(header);

	pnlHorizontalSplit.setHeight("250px");
	pnlHorizontalSplit.setWidth("100%");

	pnlHorizontalSplit.setSplitPosition("20%");

	pnlHorizontalSplit.setLeftWidget(menuDisplay.asWidget());
	setCurrentDipsplay(rightDisplay);

	pnlVerticalRoot.add(pnlHorizontalSplit);
	pnlVerticalRoot
		.add(new HTML(
			"<div style=\"background: lightBlue none repeat scroll 0% 0%; color: lightBlue; height: 2px;\"><hr style='display: none;'></div>"));
	WidgetUtil.maximise(pnlVerticalRoot);
    }

    @Override
    public Widget asWidget()
    {
	return pnlVerticalRoot;
    }

    @Override
    public void setCurrentDipsplay(WidgetDisplay display)
    {
	pnlHorizontalSplit.setRightWidget(display.asWidget());

    }

    public void showMessage(String msg)
    {
	Window.alert(msg);
    }

}
