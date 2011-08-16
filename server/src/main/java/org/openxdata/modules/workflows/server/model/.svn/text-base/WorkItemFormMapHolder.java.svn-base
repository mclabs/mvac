/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.model;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.apache.log4j.Logger;


import org.jdom.Element;
import org.openxdata.modules.workflows.model.shared.DBSpecStudyMap;
import org.openxdata.modules.workflows.model.shared.WorkItemQuestion;
import org.openxdata.modules.workflows.server.YawlOXDCustomService;
import org.openxdata.modules.workflows.server.maps.parser.MatcherHelper;
import org.openxdata.modules.workflows.server.util.OxdUtil;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.FormDefVersion;
import org.openxdata.workflow.mobile.model.MQuestionMap;
import org.openxdata.workflow.mobile.model.MWorkItem;
import org.openxdata.workflow.mobile.model.MWorkItemInfo;
import org.yawlfoundation.yawl.elements.YExternalNetElement;
import org.yawlfoundation.yawl.elements.YSpecification;
import org.yawlfoundation.yawl.elements.YTask;
import org.yawlfoundation.yawl.elements.data.YParameter;
import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;
import org.yawlfoundation.yawl.util.JDOMUtil;

/**
 *
 * @author kay
 */
@SuppressWarnings("UseOfObsoleteCollectionType")
public class WorkItemFormMapHolder
{

        private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());
        private FormDef formDef;
        private WorkItemRecord wir;
        private String xmlMap;
        private DBSpecStudyMap map;

        public WorkItemFormMapHolder(WorkItemRecord wir, FormDef formDef, String xmlMap)
        {
                this.formDef = formDef;
                this.wir = wir;
                this.xmlMap = xmlMap;
        }

        public WorkItemFormMapHolder(WorkItemRecord wir, DBSpecStudyMap map)
        {
                this.wir = wir;
                this.map = map;
                xmlMap = map.getXml();
                String formIdForTask = MatcherHelper.getFormIdForTask(wir.getTaskID(), xmlMap);
                if (formIdForTask != null) {
                        try {
                                this.formDef = map.getStudy().getForm(Integer.parseInt(formIdForTask));
                        } catch (NumberFormatException x) {
                                log.error("Map with erratic Match: TaskId=" + wir.getTaskID() + " FormId = " + formIdForTask,x);
                        }
                }
        }

        public String getXmlMap()
        {
                return xmlMap;
        }

        public void setXmlMap(String xmlMap)
        {
                this.xmlMap = xmlMap;
        }

        public FormDefVersion getFormVersion()
        {
                return formDef.getDefaultVersion();
        }

        public WorkItemRecord getWir()
        {
                return wir;
        }

        public Vector<MQuestionMap> getPrefilledQuestionsAndAnswers()
        {
                String dataList = wir.getDataListString();
                Element dataListElem = JDOMUtil.stringToElement(dataList);
                List<WorkItemQuestion> wirQnData = YawlOXDCustomService.createQuestionListFromXML(dataListElem);
                Vector<MQuestionMap> questionMaps = new Vector<MQuestionMap>();
                for (WorkItemQuestion qn : wirQnData) {
                        MQuestionMap qnMap = createQuestionMap(qn);
                        if (qnMap != null) {
                                questionMaps.add(qnMap);
                        }
                }
                return questionMaps;
        }

        public MQuestionMap createQuestionMap(WorkItemQuestion qn)
        {
                String qnVariable = MatcherHelper.getQuestionText(wir.getTaskID(), formDef.getDefaultVersion().getFormDefVersionId() + "", qn.getQuestion(), xmlMap);
                if (qnVariable == null) {
                        return null;
                }
                MQuestionMap qnMap = new MQuestionMap();
                qnMap.setParameter(qn.getQuestion());
                qnMap.setQuestion(qnVariable);
                qnMap.setValue(qn.getAnswer());
                qnMap.setType(qn.getType());
                if (isOutput(qn.getQuestion())) {
                        qnMap.setOutput(true);
                }
                return qnMap;
        }

        private boolean isOutput(String param)
        {

                YSpecification ySpec = null;
                try {
                        ySpec = OxdUtil.fromDBSpecToYSpec(map.getSpecifications());
                } catch (Exception ex) {
                        log.error("Map with erratic Spec XML: ", ex);
                        return false;
                }
                YExternalNetElement element = ySpec.getRootNet().getNetElement(wir.getTaskID());

                if (element == null || !(element instanceof YTask))
                        return false;

                YTask yTask = (YTask) element;

                Map<String, YParameter> inputParameters = yTask.getDecompositionPrototype().getInputParameters();
                Map<String, YParameter> outputParameters = yTask.getDecompositionPrototype().getOutputParameters();
                return inputParameters.containsKey(param)
                        && outputParameters.containsKey(param);
        }

        public MWorkItem toMWorkItem()
        {
                MWorkItem mWir = new MWorkItem();
                mWir.setFormId(getFormVersion().getFormDef().getDefaultVersion().getFormDefVersionId());
                mWir.setStudyId(getFormVersion().getFormDef().getStudy().getStudyId());
                mWir.setTaskName(wir.getTaskIDForDisplay());
                mWir.setCaseId(wir.getCaseID());
                mWir.setTaskId(wir.getTaskID());
                mWir.setPrefilledQns(getPrefilledQuestionsAndAnswers());
                return mWir;
        }

        public MWorkItemInfo asMWorkItemInfo()
        {
                MWorkItem mWir = toMWorkItem();
                MWorkItemInfo info = new MWorkItemInfo();
                info.setDescription(mWir.getDisplayName());
                info.setTaskId(mWir.getTaskId());
                info.setCaseId(wir.getCaseID());
                return info;
        }
}
