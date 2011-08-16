package org.openxdata.modules.workflows.client.maps;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.openxdata.modules.workflows.model.shared.OSpecification;
import org.openxdata.modules.workflows.model.shared.OTask;
import org.openxdata.modules.workflows.client.maps.validator.CompletenessValidator;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.StudyDef;

/**
 * A class representing a specification and a study map. It contains a list of
 * mapping between the forms in the tasks within the specification and map
 * 
 * @author kay
 * 
 */
public class SpecStudyMap implements Serializable
{

        private static final long serialVersionUID = 1L;
        public static boolean validateOnConversion = false;
        /**
         * A hash map containing the Task and FormDef Maps. The Hash map is keyed by
         * the unique name of the {@link TaskFormDefMap}.i.e the Key is
         * {@link TaskFormDefMap#getUniqueName()}
         */
        private HashMap<String, TaskFormDefMap> taskFormDefMaps = new HashMap<String, TaskFormDefMap>();
        private OSpecification oSpecification;
        private StudyDef studyDef;
        private boolean dirty = true;
        private int id = 0;

        SpecStudyMap()
        {
        }

        public SpecStudyMap(OSpecification spec, StudyDef study)
        {
                this.oSpecification = spec;
                this.studyDef = study;
        }

        public OSpecification getoSpecification()
        {
                return oSpecification;
        }

        public StudyDef getStudyDef()
        {
                return studyDef;
        }

        @Override
        public String toString()
        {
                return getUniqueName();
        }

        public String getUniqueName()
        {
                return oSpecification.getUniqueName() + "/" + studyDef.getName();
        }

        public int getId()
        {
                return id;
        }

        public void setId(int id)
        {
                this.id = id;
        }

        public boolean equals(SpecStudyMap obj)
        {
                return obj.toString().equals(this.toString());
        }

        /**
         * Adds a match of a task and form.Keyed by the taskName and FormName
         *
         * @param taskName
         *            unique name(id) of the task.
         * @param formName
         *            unique name of the form
         */
        public TaskFormDefMap addTaskFormDefMap(String taskName, String formName)
        {
                TaskFormDefMap taskFormMap = null;
                OTask task = getTaskWithName(taskName);
                FormDef form = getFormWithName(formName);
                if (task != null && form != null) {
                        taskFormMap = new TaskFormDefMap(task, form, this);
                        if (!addTaskFormDefMap(taskFormMap)) {
                                taskFormMap = null;
                        }
                }
                return taskFormMap;
        }

        /**
         * Adds a task form map. The map is first validated to check whether the
         * task and form are contained in the this this SpecStudyMap match
         *
         * @param map
         *            the map to add
         */
        public boolean addTaskFormDefMap(TaskFormDefMap map)
        {
                if (!validMap(map)) {
                        return false;
                }
                taskFormDefMaps.put(map.getUniqueName(), map);
                setDirty(true);
                return true;
        }

        /**
         * Map to remove the in this study.If the map is invalid or not contained in
         * this specStudyMap the state of this object is left unaltered
         *
         * @param map
         *            map to remove
         */
        public void removeTaskFormDef(TaskFormDefMap map)
        {
                if (map == null) {
                        return;
                }
                removeTaskFormDefForString(map.getUniqueName());
        }

        /**
         * Validates TaskFormDefMap map. A map is valid if the FormDef and OTask it
         * contains exits with in this specStudyMap object
         *
         * @param map
         *            map to validate
         * @return
         */
        private boolean validMap(TaskFormDefMap map)
        {
                if (map == null) {
                        return false;
                }
                FormDef formDef = map.getFormDef();
                if (!studyDef.getForms().contains(formDef)) {
                        return false;
                }
                if (!oSpecification.getTasks().contains(map.getoTask())) {
                        return false;
                }
                return true;
        }

        /**
         * Returns a list off all Tasks that are not Matched with a study
         *
         * @return list off all Tasks that are not Matched with a study
         */
        public List<OTask> getAllUnMatchedTasks()
        {
                Collection<TaskFormDefMap> allMaps = taskFormDefMaps.values();
                List<OTask> allTasks = new ArrayList<OTask>(oSpecification.getTasks());
                // remove all maps that are are all already mapped
                for (TaskFormDefMap taskFormDefMap : allMaps) {
                        allTasks.remove(taskFormDefMap.getoTask());
                }
                return allTasks;
        }

        public List<FormDef> getAllUnMatchedForms()
        {
                return studyDef.getForms();
        }

        public OTask getTaskWithName(String taskName)
        {
                for (OTask oTask : oSpecification.getTasks()) {
                        if (oTask.getId().equals(taskName)) {
                                return oTask;
                        }
                }
                return null;
        }

        public FormDef getFormWithName(String formName)
        {
                for (FormDef form : studyDef.getForms()) {
                        if (form.getName().equals(formName)) {
                                return form;
                        }
                }
                return null;
        }

        public List<TaskFormDefMap> getTaskFormDefMaps()
        {
                return new ArrayList<TaskFormDefMap>(taskFormDefMaps.values());
        }

        public TaskFormDefMap removeTaskFormDefForString(String selectedPattern)
        {
                if (selectedPattern != null) {
                        final TaskFormDefMap map = taskFormDefMaps.remove(selectedPattern);
                        if (map != null) {
                                setDirty(true);
                        }
                        return map;

                }
                return null;
        }

        @Override
        public int hashCode()
        {
                final int prime = 31;
                int result = 1;
                result = prime * result
                        + ((oSpecification == null) ? 0 : oSpecification.hashCode());
                result = prime * result
                        + ((studyDef == null) ? 0 : studyDef.hashCode());
                return result;
        }

        /**
         * Object is equal only if the OSpecifation and Study contained are equal.
         * Currently they are equal by use of references.
         */
        @Override
        public boolean equals(Object obj)
        {
                if (this == obj) {
                        return true;
                }
                if (obj == null) {
                        return false;
                }
                if (getClass() != obj.getClass()) {
                        return false;
                }
                SpecStudyMap other = (SpecStudyMap) obj;
                if (oSpecification == null) {
                        if (other.oSpecification != null) {
                                return false;
                        }
                } else if (!oSpecification.equals(other.oSpecification)) {
                        return false;
                }
                if (studyDef == null) {
                        if (other.studyDef != null) {
                                return false;
                        }
                } else if (!studyDef.equals(other.studyDef)) {
                        return false;
                }
                return true;
        }

        public String asXml(CompletenessValidator validator)
        {

                if (validator != null) {
                        validator.isComplete(this);
                }
                StringBuilder builder = new StringBuilder();

                builder.append("<SpecStudyMap ");
                builder.append("Id='").append(id).append("' ");
                builder.append("SpecId='").append(oSpecification.getUniqueName()).append("' ");
                builder.append("StudyId='").append(studyDef.getName()).append("'>");
                builder.append("<TaskFormMaps>");
                for (TaskFormDefMap defMap : this.taskFormDefMaps.values()) {
                        builder.append(defMap.asXml(validator));
                }
                builder.append("</TaskFormMaps>");
                builder.append("</SpecStudyMap>");

                return builder.toString();
        }

        public FormDef getFormWithId(int formId)
        {
                for (FormDef form : studyDef.getForms()) {
                        if (form.getFormId() == formId) {
                                return form;
                        }
                }
                return null;

        }

        public boolean isDirty()
        {
                return dirty;
        }

        public void setDirty(boolean dirty)
        {
                this.dirty = dirty;
        }
}
