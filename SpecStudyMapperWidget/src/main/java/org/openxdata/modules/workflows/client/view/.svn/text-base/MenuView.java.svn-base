package org.openxdata.modules.workflows.client.view;

import org.openxdata.modules.workflows.client.presenter.MenuPresenter;
import org.openxdata.modules.workflows.client.util.WidgetUtil;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MenuView implements MenuPresenter.Display, ClickHandler {

    private VerticalPanel pnlMain = new VerticalPanel();
    private ToggleButton btnMatchStudies = new ToggleButton(
            "Match WorkFlow/Study");
    private ToggleButton btnAvailableWorkItems = new ToggleButton(
            "Available Work Items");
    private ToggleButton btnMatchTasks = new ToggleButton("Match Tasks/Forms");
    private ToggleButton btnMatchVariables = new ToggleButton("Match Variable");
    private ToggleButton btnSyncRoles = new ToggleButton("Sync Roles");
    private ToggleButton btnLoadSpecification = new ToggleButton(
            "Specifications");

    public MenuView() {
        WidgetUtil.maximiseWidth(pnlMain);
        addButtons();
        setUpListeners();
    }

    private void setUpListeners() {

        btnAvailableWorkItems.addClickHandler(this);
        btnMatchStudies.addClickHandler(this);
        btnMatchTasks.addClickHandler(this);
        btnMatchVariables.addClickHandler(this);
        btnSyncRoles.addClickHandler(this);
        btnLoadSpecification.addClickHandler(this);
    }

    @Override
    public void onClick(ClickEvent event) {
        Object source = event.getSource();
        btnAvailableWorkItems.setDown(source
                == btnAvailableWorkItems && btnAvailableWorkItems.isDown());
        btnMatchStudies.setDown(source
                == btnMatchStudies && btnMatchStudies.isDown());
        btnMatchTasks.setDown(source
                == btnMatchTasks && btnMatchTasks.isDown());
        btnMatchVariables.setDown(source
                == btnMatchVariables && btnMatchVariables.isDown());
        btnSyncRoles.setDown(source
                == btnSyncRoles && btnSyncRoles.isDown());
        btnLoadSpecification.setDown(source
                == btnLoadSpecification && btnLoadSpecification.isDown());

    }

    private void addButtons() {

        pnlMain.add(btnMatchStudies);
        pnlMain.add(btnMatchTasks);
        pnlMain.add(btnMatchVariables);
        pnlMain.add(btnSyncRoles);
        pnlMain.add(btnAvailableWorkItems);
        pnlMain.add(btnLoadSpecification);

        // String panelWidth = "20%";
        // btnMatchStudies.setHeight(panelWidth);
        // btnAvailableWorkItems.setHeight(panelWidth);
        // btnMatchTasks.setHeight(panelWidth);
        // btnMatchVariables.setHeight(panelWidth);
        // btnSyncRoles.setHeight(panelWidth);

        // String panelWidth ="20%";
        // btnAvailableWorkItems.setWidth(panelWidth);
        // btnMatchTasks.setWidth(panelWidth);
        // btnMatchVariables.setWidth(panelWidth);
        // btnSyncRoles.setWidth(panelWidth);
    }

    @Override
    public HasClickHandlers getAvailableWorkItemsButton() {
        return btnAvailableWorkItems;
    }

    @Override
    public HasClickHandlers getMatchTasksButton() {
        return btnMatchTasks;
    }

    @Override
    public HasClickHandlers getMatchVariablesButton() {
        return btnMatchVariables;
    }

    @Override
    public HasClickHandlers getSyncRolesButton() {
        return btnSyncRoles;
    }

    @Override
    public Widget asWidget() {
        return pnlMain;
    }

    @Override
    public HasClickHandlers getMatchWorkflowsButton() {
        return btnMatchStudies;
    }

    @Override
    public HasClickHandlers getSpecificationsButton() {
        return btnLoadSpecification;
    }

    public void showMessage(String msg) {
        Window.alert(msg);
    }
}
