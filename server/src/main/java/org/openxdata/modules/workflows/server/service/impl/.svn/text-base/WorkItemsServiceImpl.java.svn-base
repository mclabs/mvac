package org.openxdata.modules.workflows.server.service.impl;

import com.google.inject.Inject;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

import org.jdom.JDOMException;
import org.openxdata.modules.workflows.model.shared.WorkItemQuestion;
import org.openxdata.modules.workflows.server.YawlOXDCustomService;
import org.openxdata.modules.workflows.server.context.WFContext;
import org.openxdata.modules.workflows.server.dao.WorkItemDAO;
import org.openxdata.modules.workflows.server.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yawlfoundation.yawl.elements.YTask;
import org.yawlfoundation.yawl.elements.data.YParameter;
import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;
import org.yawlfoundation.yawl.util.JDOMUtil;

@Transactional
@Service("workItemsService")
public class WorkItemsServiceImpl implements
        org.openxdata.modules.workflows.server.service.WorkItemsService
{

        public static final Logger log = Logger.getLogger(WorkItemsServiceImpl.class);
        @Autowired
        private WorkItemDAO workItemDAO;
        @Autowired
        private SpecificationService specServie;
        private YawlOXDCustomService yawlService;

        public WorkItemsServiceImpl()
        {
        }

        @Inject
        public WorkItemsServiceImpl(WorkItemDAO workItemDAO)
        {
                this.workItemDAO = workItemDAO;
        }

        @Override
        public void saveWorkItem(WorkItemRecord workItemRecord)
        {
                workItemDAO.save(workItemRecord);
        }

        @Override
        public List<WorkItemRecord> getWorkItems()
        {
                return workItemDAO.findAll();
        }

        @Override
        public List<WorkItemRecord> getEnabledWorkItems()
        {
                return workItemDAO.getEnableWorkItems();
        }

        @Override
        public WorkItemRecord getWorkitem(String caseId, String taskId)
        {
                return workItemDAO.getWir4CaseIDTaskID(caseId, taskId);
        }

        @Override
        public Map<String, YParameter> getOutputParam(WorkItemRecord wir)
        {
                YTask task = getTask(wir);
                if (task != null)
                        return task.getDecompositionPrototype().getOutputParameters();
                return new HashMap<String, YParameter>(0);
        }

        private YTask getTask(WorkItemRecord wir)
        {
                return specServie.getTask(wir.getTaskID(), wir.getSpecificationID(), wir.getSpecVersion());
        }

        @Override
        public void submitWorkItem(WorkItemRecord workitem, List<WorkItemQuestion> qnList)
        {
                String decompID = getTask(workitem).
                        getDecompositionPrototype().
                        getID();

                String datalist = questionListToString(decompID, qnList);
                try {
                        getCustomService().checkInWorkItem(workitem, datalist);
                        deleteWorkItem(workitem);
                } catch (IOException ex) {
                        log.warn("Yawl Engine Could be down: "
                                + "Resaving the workItem for later submission", ex);
                        saveWorkItem(workitem, datalist, WorkItemRecord.statusComplete);
                } catch (JDOMException ex) {
                        log.error("Submission Failed: Yawl While Parsing DataElement: for " + workitem.getID(), ex);
                        saveWorkItem(workitem, datalist, WorkItemRecord.statusFailed);
                        throw new RuntimeException(ex);
                }
        }

        public void saveWorkItem(WorkItemRecord workitem, String datalist, String state)
        {
                workitem.setUpdatedData(JDOMUtil.stringToElement(datalist));
                if (state != null)
                        workitem.setStatus(state);
                workItemDAO.save(workitem);
        }

        public static String questionListToString(String decompositionId, List<WorkItemQuestion> qnList)
        {
                StringBuilder builder = new StringBuilder();
                builder.append("<").append(decompositionId).append(">");
                for (WorkItemQuestion workItemQuestion : qnList) {
                        builder.append(workItemQuestion.toXML());
                }
                builder.append("</").append(decompositionId).append(">");
                return builder.toString();
        }

        @Override
        public void deleteWorkItem(WorkItemRecord workItemRecord)
        {
                workItemDAO.remove(workItemRecord);
        }

        @Override
        public List<WorkItemRecord> getMappedWorkItems(String status)
        {
                return workItemDAO.getMappedWorkItems(status);
        }

        @Override
        public void deleteWorkItemInCase(String caseId)
        {
                List<WorkItemRecord> wirs = workItemDAO.findAll();
                for (WorkItemRecord workItemRecord : wirs) {
                        if (workItemRecord.getRootCaseID().equals(caseId))
                                workItemDAO.remove(workItemRecord);
                }
        }

        public YawlOXDCustomService getCustomService()
        {
                if (yawlService == null)
                        yawlService = WFContext.getOXDCustomService();
                return yawlService;
        }

        public void setYawlService(YawlOXDCustomService yawlService)
        {
                this.yawlService = yawlService;
        }

        public void setSpecificationService(SpecificationService specService)
        {
                this.specServie = specService;
        }

        public void setWorkItemDAO(WorkItemDAO workItemDAO)
        {
                this.workItemDAO = workItemDAO;
        }
}
