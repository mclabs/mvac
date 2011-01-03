package org.openxdata.modules.workflows.client.view;

import org.openxdata.modules.workflows.client.presenter.ParamQuestionPresenter;
import org.openxdata.modules.workflows.client.presenter.uimodel.ParamQuestionUiModel;
import org.openxdata.modules.workflows.client.util.WidgetUtil;
import org.openxdata.modules.workflows.model.shared.OParameter;
import org.openxdata.modules.workflows.client.maps.ParamQuestionMap;
import org.openxdata.modules.workflows.client.maps.TaskFormDefMap;
import org.openxdata.modules.workflows.client.maps.TaskFormVersionMap;
import org.purc.purcforms.client.model.QuestionDef;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;
import org.openxdata.modules.workflows.client.maps.validator.XFormTypes;

public class ParamQuestionView extends AbstractRightView implements
	ParamQuestionPresenter.Display
{
    private ParamQuestionUiModel model;

    @Override
    protected void setupText()
    {
	super.setLeftTitle("Parameters");
	super.setMainTitle("Match Variables and Questions");
	super.setRightTitle("Questions");
    }

    @Override
    public HasText getQuestionText()
    {
	return getTxtright();
    }

    @Override
    public HasClickHandlers getRemoveMatchButton()
    {
	return getBtnDelete();
    }

    @Override
    public HasClickHandlers getAddMatchButton()
    {
	return super.getAddMacthButton();
    }

    @Override
    public String getSelectedMapString()
    {
	return WidgetUtil.getListBoxValue(getLstMiddle());
    }

    @Override
    public HasText getVariableText()
    {
	return getTxtleft();
    }

    @Override
    public void refresh()
    {
	getLstPatterns().clear();
	int i = 0;
	for (TaskFormDefMap map : model.getTaskFormDefMaps()) {

	    for (TaskFormVersionMap taskFormVersionMap : map
		    .getFormVersionMaps()) {
		getLstPatterns().addItem(taskFormVersionMap.toString());
		if (taskFormVersionMap == model.getCurrentFormVersionMap())
		    getLstPatterns().setSelectedIndex(i);
		i++;
	    }
	}

	// Populate the questions
	getLstRightHand().clear();
	for (QuestionDef question : model.getUnMatchedQuestions()) {
	    getLstRightHand().addItem(question.getText()+"  #"+XFormTypes.toText(question.getDataType()), question.getVariableName());
	}

	// Populate the the params
	getLstLeftHand().clear();
	for (OParameter parameter : model.getUnMatchedParams()) {
	    getLstLeftHand().addItem(parameter.getDisplayName(), parameter.getName());
	}

	getLstMiddle().clear();
	for (ParamQuestionMap map : model.getParamQuestionMaps()) {
	    getLstMiddle().addItem(map.getUniqueName());
	}

	getTxtleft().setText(null);
	getTxtright().setText(null);
    }

    @Override
    public void setModel(ParamQuestionUiModel model)
    {
	this.model = model;
	refresh();
    }

    @Override
    public HasClickHandlers getTaskFormVersionList()
    {
	return getLstPatterns();
    }

    @Override
    public String getSelectedTaskFormVersionString()
    {
	return WidgetUtil.getListBoxValue(getLstPatterns());
    }

}
