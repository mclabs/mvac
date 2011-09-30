package org.openxdata.modules.workflows.client.maps;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openxdata.modules.workflows.model.shared.OTask;
import org.openxdata.modules.workflows.client.maps.validator.CompletenessValidator;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.FormDefVersion;

public class TaskFormDefMap implements Serializable
{
    private static final long serialVersionUID = 1L;

    private FormDef formDef;
    private OTask oTask;
    private SpecStudyMap specStudyMap;
    private HashMap<String, TaskFormVersionMap> formVersionMaps;

    TaskFormDefMap()
    {
    }

    public TaskFormDefMap(OTask oTask, FormDef formDef,
	    SpecStudyMap specStudyMap)
    {
	this.oTask = oTask;
	this.formDef = formDef;
	formVersionMaps = new HashMap<String, TaskFormVersionMap>();
	this.specStudyMap = specStudyMap;
	createFormVersionMaps();
    }

    private void createFormVersionMaps()
    {
	List<FormDefVersion> versions = formDef.getVersions();
	for (FormDefVersion formDefVersion : versions) {
            if(formDefVersion.getXform() != null){
	    TaskFormVersionMap taskFormVer = new TaskFormVersionMap(this,
		    oTask, formDefVersion);
	    formVersionMaps.put(taskFormVer.getUniqueName(), taskFormVer);
            }
	}
    }

    public FormDef getFormDef()
    {
	return formDef;
    }

    public OTask getoTask()
    {
	return oTask;
    }

    public List<TaskFormVersionMap> getFormVersionMaps()
    {
	return new ArrayList<TaskFormVersionMap>(formVersionMaps.values());
    }

    public String getUniqueName()
    {
	return oTask.getId() + "/" + formDef.getName();
    }

    @Override
    public String toString()
    {
	return getUniqueName();
    }

    public boolean isEqual(TaskFormDefMap map)
    {
	return map.getUniqueName().equals(getUniqueName());
    }

    @Override
    public int hashCode()
    {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((formDef == null) ? 0 : formDef.hashCode());
	result = prime * result + ((oTask == null) ? 0 : oTask.hashCode());
	return result;
    }
    
    public SpecStudyMap getSpecStudyMap()
    {
	return specStudyMap;
    }

    @Override
    public boolean equals(Object obj)
    {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	TaskFormDefMap other = (TaskFormDefMap) obj;
	if (formDef == null) {
	    if (other.formDef != null)
		return false;
	} else if (!formDef.equals(other.formDef))
	    return false;
	if (oTask == null) {
	    if (other.oTask != null)
		return false;
	} else if (!oTask.equals(other.oTask))
	    return false;
	return true;
    }

    public boolean containsTaskFormVerMap(String taskFormVerStr)
    {

	if (formVersionMaps.get(taskFormVerStr) == null)
	    return false;
	return true;
    }

    public TaskFormVersionMap getTaskFormVerMap(String taskFormVerStr)
    {
	return formVersionMaps.get(taskFormVerStr);
    }

    public String asXml(CompletenessValidator validator)
    {
	StringBuilder builder = new StringBuilder();
	builder.append("<TaskFormDef ");
	builder.append("TaskId='").append(oTask.getId()).append("' ");
	builder.append("FormId='").append(formDef.getFormId()).append("'>");
	builder.append("<TaskFormVersionMaps>");
	for(TaskFormVersionMap  tfMap: this.formVersionMaps.values()){
	    builder.append(tfMap.asXml(validator));
	}
	builder.append("</TaskFormVersionMaps>");
	builder.append("</TaskFormDef>");
	return builder.toString();
    }

}
