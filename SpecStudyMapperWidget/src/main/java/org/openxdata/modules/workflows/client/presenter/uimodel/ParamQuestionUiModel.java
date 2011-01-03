package org.openxdata.modules.workflows.client.presenter.uimodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openxdata.modules.workflows.model.shared.OParameter;
import org.openxdata.modules.workflows.shared.exception.TypeMisMatchException;
import org.openxdata.modules.workflows.client.maps.ParamQuestionMap;
import org.openxdata.modules.workflows.client.maps.TaskFormDefMap;
import org.openxdata.modules.workflows.client.maps.TaskFormVersionMap;
import org.openxdata.modules.workflows.client.maps.validator.TypeValidator;
import org.purc.purcforms.client.model.QuestionDef;

public class ParamQuestionUiModel
{
    private HashMap<String, TaskFormDefMap> maps = new HashMap<String, TaskFormDefMap>();
    public TaskFormVersionMap currentFormVersionMap = null;

    public void addTaskFormDefMap(TaskFormDefMap defMap)
    {
        //TODO: This is a bug. Should probably use object reference.
        //Some task and formsdefs could be having the same sting value
        if (!containsMapWithString(defMap.toString()))
            maps.put(defMap.getUniqueName(), defMap);
    }

    public boolean containsMapWithString(String otherMap)
    {
        for (TaskFormDefMap map : maps.values()) {
            if (map.toString().equals(otherMap))
                return true;
        }
        return false;
    }

    public List<TaskFormDefMap> getTaskFormDefMaps()
    {
        return new ArrayList<TaskFormDefMap>(maps.values());
    }

    public List<QuestionDef> getUnMatchedQuestions()
    {
        if (currentFormVersionMap == null) {
            return new ArrayList<QuestionDef>(0);
        }
        return currentFormVersionMap.getUnMatchedQuestions();
    }

    public void setCurrentTaskFormVersion(String taskFormVerStr)
    {
        TaskFormVersionMap taskFormVerMap = getTaskVerFormMap(taskFormVerStr);
        if (taskFormVerMap != null)
            currentFormVersionMap = taskFormVerMap;
    }

    private TaskFormVersionMap getTaskVerFormMap(String taskFormVerStr)
    {
        for (TaskFormDefMap taskFormDefMap : this.maps.values()) {
            if (taskFormDefMap.containsTaskFormVerMap(taskFormVerStr)) {
                return taskFormDefMap.getTaskFormVerMap(taskFormVerStr);
            }
        }
        return null;
    }

    public TaskFormVersionMap getCurrentFormVersionMap()
    {
        return currentFormVersionMap;
    }

    public List<OParameter> getUnMatchedParams()
    {
        if (currentFormVersionMap == null)
            return new ArrayList<OParameter>(0);
        return currentFormVersionMap.getUnMatchedParams();
    }

    public void removeTaskFormDefMap(TaskFormDefMap map)
    {
        if (currentFormVersionMap != null && currentFormVersionMap.getTaskFormDefMap() == map)
            currentFormVersionMap = null;
        maps.remove(map.getUniqueName());
    }

    public void addParamQuestionMap(String parameter, String question) throws TypeMisMatchException
    {
        addParamQuestionMap(parameter, question, null);
    }

    public List<ParamQuestionMap> getParamQuestionMaps()
    {
        if (currentFormVersionMap == null)
            return new ArrayList<ParamQuestionMap>(0);
        return currentFormVersionMap.getParamQuestionMaps();
    }

    public void removeParmaQuestionMapForString(String mapString)
    {
        if (currentFormVersionMap == null)
            return;

        currentFormVersionMap.removePramQuesMap(mapString);

    }

    public void addParamQuestionMap(String parameter, String question, TypeValidator typeValidator) throws TypeMisMatchException
    {
        currentFormVersionMap.addParamQuestionMap(parameter, question,typeValidator);

    }
}
