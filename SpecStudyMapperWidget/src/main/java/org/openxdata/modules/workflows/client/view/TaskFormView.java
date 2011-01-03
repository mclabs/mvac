package org.openxdata.modules.workflows.client.view;

import java.util.List;

import org.openxdata.modules.workflows.client.presenter.TaskFormPresenter;
import org.openxdata.modules.workflows.client.presenter.uimodel.TaskFormUiModel;
import org.openxdata.modules.workflows.client.util.WidgetUtil;
import org.openxdata.modules.workflows.model.shared.OTask;
import org.openxdata.modules.workflows.client.maps.SpecStudyMap;
import org.openxdata.modules.workflows.client.maps.TaskFormDefMap;
import org.openxdata.server.admin.model.FormDef;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;

public class TaskFormView extends AbstractRightView implements
	TaskFormPresenter.Display
{

    private TaskFormUiModel model;

    protected void setupText()
    {
	setMainTitle("Match Tasks and Forms");
	setLeftTitle("Tasks");
	setRightTitle("Forms");
    }

    @Override
    public void setModel(TaskFormUiModel model)
    {
	this.model = model;
	refresh();
    }

    @Override
    public HasClickHandlers getSpecStudyMapList()
    {
	return getLstPatterns();
    }

    @Override
    public void refresh()
    {
	List<SpecStudyMap> specStudyList = model.getSpecToStudyList();
	getLstPatterns().clear();
	for (SpecStudyMap specToStudyMap : specStudyList) {
	    getLstPatterns().addItem(specToStudyMap.toString());
	}

	int idx = specStudyList.indexOf(model.getCurrentSpecStudy());
	if (idx != -1)
	    getLstPatterns().setSelectedIndex(idx);

	List<OTask> tasksList = model.getTasksList();
	getLstLeftHand().clear();
	for (OTask oTask : tasksList) {
	    // getLstLeftHand().addItem(oTask.getName());
	    getLstLeftHand().addItem(oTask.getId());
	}

	List<TaskFormDefMap> maps = model.getMaps();
	getLstMiddle().clear();
	for (TaskFormDefMap taskToFormVersionMap : maps) {
	    getLstMiddle().addItem(taskToFormVersionMap.toString());
	}

	List<FormDef> formsList = model.getFormsList();
	getLstRightHand().clear();
	for (FormDef formDef : formsList) {
	    getLstRightHand().addItem(formDef.getName());
	}
	
	//clear the Text Boxes
	getTxtleft().setText(null);
	getTxtright().setText(null);

    }

    @Override
    public String getSelectedSpecStudy()
    {
	int idx = getLstPatterns().getSelectedIndex();
	if (idx == -1)
	    return null;
	return getLstPatterns().getItemText(idx);
    }

    @Override
    public String getSelectedTaskForm()
    {
	return WidgetUtil.getListBoxValue(getLstMiddle());
    }

    @Override
    public HasText getFormTxt()
    {
	return getTxtright();
    }

    @Override
    public HasText getTaskTxt()
    {
	return getTxtleft();
    }

    @Override
    public HasClickHandlers getDeleteMatchButton()
    {
	return getBtnDelete();
    }

}
