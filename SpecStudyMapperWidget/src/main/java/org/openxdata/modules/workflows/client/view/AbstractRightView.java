package org.openxdata.modules.workflows.client.view;

import org.openxdata.modules.workflows.client.presenter.WidgetDisplay;
import org.openxdata.modules.workflows.client.util.WidgetUtil;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class AbstractRightView implements WidgetDisplay
{

    private String mainTitle;
    private String leftTitle;
    private String rightTitle;
    private String TITLE;

    private VerticalPanel vPnlRoot = new VerticalPanel();

    private ListBox lstLeftHand = new ListBox();
    private ListBox lstMiddle = new ListBox();
    private ListBox lstRightHand = new ListBox();
    private ListBox lstPatterns = new ListBox();

    private Button btnAddMatch = new Button("+");
    private Button btnDelete = new Button("-");

    private final TextBox txtRight = new TextBox();
    private final TextBox txtLeft = new TextBox();

    public AbstractRightView()
    {
	//FIXXXME Set up getters for the different string variables
	setupText();
	TITLE = "<div style=\"font-size: 15px; background: white none repeat scroll 0pt 0pt; color: black; text-align: center; \"><strong>"
		+ mainTitle + "</strong></div>";
	init();
	setupEventListeners();
    }

    private void setupEventListeners()
    {
	lstRightHand.addClickHandler(new ClickHandler()
	{
	    @Override
	    public void onClick(ClickEvent event)
	    {
		int idx = lstRightHand.getSelectedIndex();
		if (idx != -1)
		    txtRight.setText(lstRightHand.getValue(idx));

	    }
	});

	lstLeftHand.addClickHandler(new ClickHandler()
	{
	    @Override
	    public void onClick(ClickEvent event)
	    {
		int idx = lstLeftHand.getSelectedIndex();
		if (idx != -1)
		    txtLeft.setText(lstLeftHand.getValue(idx));
	    }
	});

    }

    abstract protected void setupText();

    protected final void init()
    {

	SimplePanel titlePanel = new SimplePanel();
	titlePanel.add(new HTML(TITLE));
	WidgetUtil.centerWidgetToRootPanel(vPnlRoot, titlePanel);
	vPnlRoot.setCellHeight(titlePanel, "10px");

	lstPatterns.setWidth("80%");
	HorizontalPanel pnl4DrpBox = new HorizontalPanel();
	Label w = new HTML("<b>Select Match</b>");
	pnl4DrpBox.add(w);
	pnl4DrpBox.add(lstPatterns);
	pnl4DrpBox.setWidth("100%");
	pnl4DrpBox.setCellHorizontalAlignment(lstPatterns,
		HorizontalPanel.ALIGN_LEFT);
	pnl4DrpBox.setCellHorizontalAlignment(w, HorizontalPanel.ALIGN_RIGHT);
	pnl4DrpBox.setCellWidth(w, "20%");
	vPnlRoot.add(pnl4DrpBox);

	HorizontalPanel hpanel = new HorizontalPanel();
	hpanel.setSpacing(10);
	addPanelWithHeading(hpanel, leftTitle, lstLeftHand);

	createCenterPanel(hpanel);
	addPanelWithHeading(hpanel, rightTitle, lstRightHand);
	WidgetUtil.maximise(hpanel);

	vPnlRoot.add(hpanel);
	WidgetUtil.maximise(vPnlRoot);
    }

    private Panel addPanelWithHeading(HorizontalPanel root, String text,
	    ListBox list)
    {
	VerticalPanel localPanel = new VerticalPanel();
	localPanel.setSpacing(5);

	root.add(localPanel);
	root.setCellHeight(localPanel, "100%");
	root.setCellWidth(localPanel, "33%");
	WidgetUtil.maximise(localPanel);

	HorizontalPanel pnlText = new HorizontalPanel();
	HTML child = new HTML("<div style=\" color: Black;\"><strong>" + text
		+ "</strong></div>");
	pnlText.add(child);
	pnlText.setCellHorizontalAlignment(child,
		HasHorizontalAlignment.ALIGN_CENTER);

	localPanel.setCellHeight(pnlText, "20px");
	localPanel.add(pnlText);

	list.setVisibleItemCount(10);
	WidgetUtil.maximise(list);

	localPanel.add(list);
	return localPanel;
    }

    private void createCenterPanel(HorizontalPanel root)
    {

	VerticalPanel localPanel = new VerticalPanel();

	root.add(localPanel);
	root.setCellHeight(localPanel, "100%");
	root.setCellWidth(localPanel, "33%");
	WidgetUtil.maximise(localPanel);

	HorizontalPanel pnl4Text = new HorizontalPanel();
	pnl4Text.add(txtLeft);
	pnl4Text.add(getAddMacthButton());
	pnl4Text.add(getBtnDelete());
	pnl4Text.add(txtRight);

	localPanel.add(pnl4Text);
	localPanel.setCellHeight(pnl4Text, "20px");
	localPanel.setCellWidth(pnl4Text, "100%");
	WidgetUtil.maximise(pnl4Text);

	WidgetUtil.maximise(lstMiddle);
	lstMiddle.setVisibleItemCount(10);
	localPanel.add(lstMiddle);
    }

    public void showError(String error)
    {
	MessageBox dlg = new MessageBox();
	dlg.showError(error);
	dlg.show();

    }

    public Button getAddMacthButton()
    {
	return btnAddMatch;
    }

    public HasClickHandlers taskFormList()
    {
	return lstLeftHand;
    }

    public Widget asWidget()
    {
	return vPnlRoot;
    }

    public void showMessage(String msg)
    {
	Window.alert(msg);
    }

    protected void setMainTitle(String mainTitle)
    {
	this.mainTitle = mainTitle;
    }

    protected void setLeftTitle(String leftTitle)
    {
	this.leftTitle = leftTitle;
    }

    protected void setRightTitle(String rightTitle)
    {
	this.rightTitle = rightTitle;
    }

    protected ListBox getLstMiddle()
    {
	return lstMiddle;
    }

    protected ListBox getLstRightHand()
    {
	return lstRightHand;
    }

    protected ListBox getLstPatterns()
    {
	return lstPatterns;
    }

    protected ListBox getLstLeftHand()
    {
	return lstLeftHand;
    }

    public TextBox getTxtright()
    {
	return txtRight;
    }

    public TextBox getTxtleft()
    {
	return txtLeft;
    }

    public Button getBtnDelete()
    {
	return btnDelete;
    }

}
