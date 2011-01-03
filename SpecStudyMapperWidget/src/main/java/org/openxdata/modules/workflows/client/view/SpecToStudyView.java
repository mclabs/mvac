package org.openxdata.modules.workflows.client.view;

import java.util.ArrayList;
import java.util.List;

import org.openxdata.modules.workflows.client.presenter.SpecStudyPresenter;
import org.openxdata.modules.workflows.client.presenter.uimodel.SpecStudyUiModel;
import org.openxdata.modules.workflows.model.shared.OSpecification;
import org.openxdata.modules.workflows.client.maps.SpecStudyMap;
import org.openxdata.server.admin.model.StudyDef;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;

public class SpecToStudyView extends AbstractRightView implements
	SpecStudyPresenter.Display
{

    private SpecStudyUiModel model;

    @Override
    protected void setupText()
    {
	this.setMainTitle("Match WorkFlow with Studies");
	this.setLeftTitle("Workflows");
	this.setRightTitle("Studies");
    }

    @Override
    public void refresh()
    {
	ArrayList<OSpecification> specList = model.getSpecsAsList();
	getLstLeftHand().clear();
	for (OSpecification oSpecification : specList) {
	    getLstLeftHand().addItem(oSpecification.getUniqueName());
	}

	List<StudyDef> studyList = model.getStudiesAsList();
	getLstRightHand().clear();
	for (StudyDef studyDef : studyList) {
	    getLstRightHand().addItem(studyDef.getName());
	}

	List<SpecStudyMap> matches = model.getMaps();
	getLstMiddle().clear();
	for (SpecStudyMap specToStudyMatch : matches) {
	    getLstMiddle().addItem(specToStudyMatch.toString());
	}

	getSpecTxt().setText(null);
	getStudyTxt().setText(null);
    }

    @Override
    public void setModel(SpecStudyUiModel model)
    {
	this.model = model;
	refresh();
    }

    @Override
    public HasClickHandlers getAddMatchBtn()
    {
	return super.getAddMacthButton();
    }

    @Override
    public HasText getSpecTxt()
    {
	return super.getTxtleft();
    }

    @Override
    public HasText getStudyTxt()
    {
	return super.getTxtright();
    }

    @Override
    public HasClickHandlers getDeleteMatchBtn()
    {

	return getBtnDelete();
    }

    @Override
    public String getSelectedMatch()
    {
	int selectedIndex = getLstMiddle().getSelectedIndex();
	if (selectedIndex == -1)
	    return null;
	return getLstMiddle().getItemText(selectedIndex);
    }


}
