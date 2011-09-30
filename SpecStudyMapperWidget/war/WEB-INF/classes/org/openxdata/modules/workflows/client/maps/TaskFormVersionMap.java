package org.openxdata.modules.workflows.client.maps;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openxdata.modules.workflows.model.shared.OParameter;
import org.openxdata.modules.workflows.model.shared.OTask;
import org.openxdata.modules.workflows.client.maps.validator.TypeValidator;
import org.openxdata.server.admin.model.FormDefVersion;
import org.purc.purcforms.client.model.FormDef;
import org.purc.purcforms.client.model.QuestionDef;
import org.purc.purcforms.client.xforms.XformParser;

import com.google.gwt.core.client.GWT;
import org.openxdata.modules.workflows.shared.exception.TypeMisMatchException;
import org.openxdata.modules.workflows.client.maps.validator.CompletenessValidator;
import org.openxdata.modules.workflows.client.maps.validator.DafaultTypeValidator;

public class TaskFormVersionMap implements Serializable
{

        public static HashMap<String, FormDef> formDefCache = new HashMap<String, FormDef>();
        private static final long serialVersionUID = 1L;
        private TaskFormDefMap taskFormDefMap;
        private FormDefVersion formVersion;
        private FormDef formVersion2;
        private OTask task;
        private HashMap<String, ParamQuestionMap> paramQuestionMaps = new HashMap<String, ParamQuestionMap>();

        TaskFormVersionMap()
        {
        }

        public TaskFormVersionMap(TaskFormDefMap taskFormDefMap, OTask task,
                FormDefVersion formDef)
        {
                this.taskFormDefMap = taskFormDefMap;
                this.task = task;
                this.formVersion = formDef;
                this.formVersion2 = getFormDef(formDef.getXform());
        }

        private FormDef getFormDef(String xfrom)
        {
                FormDef formDef = formDefCache.get(xfrom);
                if (formDef == null) {
                        formDef = XformParser.fromXform2FormDef(xfrom);
                        formDefCache.put(xfrom, formDef);
                }
                return formDef;
        }

        @Override
        public String toString()
        {
                return getUniqueName();
        }

        public String getUniqueName()
        {
                return task.getId() + "/" + taskFormDefMap.getFormDef().getName() + "_"
                        + formVersion.getName();
        }

        public TaskFormDefMap getTaskFormDefMap()
        {
                return taskFormDefMap;
        }

        public List<ParamQuestionMap> getParamQuestionMaps()
        {
                return new ArrayList<ParamQuestionMap>(paramQuestionMaps.values());
        }

        public List<QuestionDef> getUnMatchedQuestions()
        {
                List<QuestionDef> questions = getAllQuestions();
                for (ParamQuestionMap map : paramQuestionMaps.values()) {
                        QuestionDef questionDef = map.getQuestionDef();
                        questions.remove(questionDef);
                }
                return questions;
        }

        public List<QuestionDef> getAllQuestions()
        {
                List<QuestionDef> questions = new ArrayList<QuestionDef>();
                for (int i = 0; i < formVersion2.getQuestionCount(); i++) {
                        questions.add(formVersion2.getQuestionAt(i));
                }
                return questions;
        }

        public List<OParameter> getUnMatchedParams()
        {
                ArrayList<OParameter> params = new ArrayList<OParameter>(task.getAllParams());
                for (ParamQuestionMap paramQuestionMap : paramQuestionMaps.values()) {
                        params.remove(paramQuestionMap.getOParameter());
                }
                return params;
        }

        public void addParamQuestionMap(String paramName, String quesName) throws TypeMisMatchException
        {
                addParamQuestionMap(paramName, quesName, new DafaultTypeValidator());
        }

        public void addParamQuestionMap(String paramName, String quesName, TypeValidator typeValidator) throws TypeMisMatchException
        {
                if (typeValidator == null) {
                        typeValidator = new DafaultTypeValidator();
                }

                OParameter param = getParamWithName(paramName);
                QuestionDef questionDef = getQuestionWithName(quesName);
                if (param == null || questionDef == null) {
                        GWT.log("Param or QuestionDef was null");
                        return;
                }
                if (!typeValidator.isValid(param, questionDef)) {
                        throw new TypeMisMatchException(typeValidator.getErrorMessage());
                }
                ParamQuestionMap paramQuestionMap = new ParamQuestionMap(param,
                        questionDef, this);
                if (!paramQuestionMaps.containsValue(paramQuestionMap)) {
                        paramQuestionMaps.put(paramQuestionMap.getUniqueName(),
                                paramQuestionMap);
                        makeDirty();
                }
        }

        private void makeDirty()
        {
                this.taskFormDefMap.getSpecStudyMap().setDirty(true);
        }

        public OParameter getParamWithName(String paramName)
        {
                ArrayList<OParameter> outPutParams = task.getAllParams();
                for (OParameter oParameter : outPutParams) {
                        if (oParameter.getName().equals(paramName)) {
                                return oParameter;
                        }
                }
                return null;
        }

        public QuestionDef getQuestionWithName(String question)
        {
                List<QuestionDef> allQuestions = getAllQuestions();
                for (QuestionDef questionDef : allQuestions) {
                        if (questionDef.getVariableName().equals(question)) {
                                return questionDef;
                        }
                }
                return null;
        }

        public void removePramQuesMap(String mapString)
        {
                ParamQuestionMap map = paramQuestionMaps.remove(mapString);
                if (map != null) {
                        makeDirty();
                }
        }

        public String asXml(CompletenessValidator validator)
        {
                if (validator != null) {
                        validator.isComplete(this);
                }
                StringBuilder builder = new StringBuilder();
                builder.append("<TaskFormVersion ");
                builder.append("TaskId='").append(task.getId()).append("' ");
                builder.append("FormVersionId='").append(formVersion.getFormDefVersionId()).append("'>");
                builder.append("<ParamQuestionMaps>");
                for (ParamQuestionMap map : paramQuestionMaps.values()) {
                        builder.append(map.asXml());
                }
                builder.append("</ParamQuestionMaps>");
                builder.append("</TaskFormVersion>");
                return builder.toString();
        }

        public OTask getTask()
        {
                return task;
        }

        public FormDefVersion getFormVersion()
        {
                return formVersion;
        }

        public QuestionDef getQuestionWithBinding(String binding)
        {
                List<QuestionDef> allQuestions = getAllQuestions();
                for (QuestionDef questionDef : allQuestions) {
                        if (questionDef.getVariableName().equals(binding)) {
                                return questionDef;
                        }
                }
                return null;
        }
}
