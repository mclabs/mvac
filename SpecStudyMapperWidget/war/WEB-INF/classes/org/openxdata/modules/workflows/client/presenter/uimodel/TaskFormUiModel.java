package org.openxdata.modules.workflows.client.presenter.uimodel;

import java.util.ArrayList;
import java.util.List;

import org.openxdata.modules.workflows.model.shared.OTask;
import org.openxdata.modules.workflows.client.maps.SpecStudyMap;
import org.openxdata.modules.workflows.client.maps.TaskFormDefMap;
import org.openxdata.server.admin.model.FormDef;

public class TaskFormUiModel
{

    private List<SpecStudyMap> specStudyList = new ArrayList<SpecStudyMap>();
  
    private SpecStudyMap currentSpecStudy;

    public TaskFormUiModel()
    {
    }

    public List<SpecStudyMap> getSpecToStudyList()
    {
	return specStudyList;
    }

    public List<OTask> getTasksList()
    {
	if(currentSpecStudy == null)
	    return new ArrayList<OTask>(0);//FIXXXME
	return currentSpecStudy.getAllUnMatchedTasks();
    }

    public List<FormDef> getFormsList()
    {
	if(currentSpecStudy == null)
	    return new ArrayList<FormDef>(0);//FIXXXME
	return currentSpecStudy.getAllUnMatchedForms();
    }

    public List<TaskFormDefMap> getMaps()
    {
	if(currentSpecStudy == null)
	    return new ArrayList<TaskFormDefMap>(0);
	return currentSpecStudy.getTaskFormDefMaps();
    }

    public void addSpecStudyMap(SpecStudyMap map)
    {
	if (!hasSpecStudyMap(map))
	    specStudyList.add(map);
    }

    public void removeSpecStudyMap(SpecStudyMap map)
    {
	if (map == null)
	    return;
	specStudyList.remove(map);
	if (currentSpecStudy != null && currentSpecStudy.equals(map)) {
	    if (specStudyList.size() > 0)
		currentSpecStudy = specStudyList.get(0);
	    else
		currentSpecStudy = null;
	}
    }
    
    public TaskFormDefMap addTaskFormDefMap(String formTxt, String taskTxt)
    {
	if(currentSpecStudy != null){
	    return currentSpecStudy.addTaskFormDefMap(formTxt, taskTxt);
	}
	return null;
    }

    public SpecStudyMap getCurrentSpecStudy()
    {
	return currentSpecStudy;
    }

    public boolean hasSpecStudyMap(SpecStudyMap map)
    {
	for (SpecStudyMap specToStudyMap : specStudyList) {
	    if (specToStudyMap.equals(map))
		return true;
	}
	return false;
    }

    public void setCurrentSpecStudyMap(String selectedPattern)
    {
	SpecStudyMap specStudy = getSpecStudyMapFromString(selectedPattern);
	if (specStudy != null) {
	    currentSpecStudy = specStudy;
	}
    }

    private SpecStudyMap getSpecStudyMapFromString(String code)
    {
	for (SpecStudyMap specStudy : specStudyList) {
	    if (specStudy.toString().equals(code))
		return specStudy;
	}
	return null;
    }

    public TaskFormDefMap removeTaskFormDefMap(String selectedPattern)
    {
	if(currentSpecStudy != null){
	  return  currentSpecStudy.removeTaskFormDefForString(selectedPattern);
	}
	return null;
    }
}
