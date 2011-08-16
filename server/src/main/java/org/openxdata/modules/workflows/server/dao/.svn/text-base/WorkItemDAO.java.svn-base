package org.openxdata.modules.workflows.server.dao;

import com.trg.dao.hibernate.GenericDAO;
import java.util.List;

import org.openxdata.modules.workflows.server.model.WorkItemFormMapHolder;
import org.openxdata.server.admin.model.User;
import org.openxdata.workflow.mobile.model.MWorkItemInfo;
import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;

/**
 *
 * @author kay
 */
public interface WorkItemDAO extends
        GenericDAO<WorkItemRecord, Integer>
{

        public List<WorkItemRecord> searchByPropertyEqual(String property, Object value);

        public WorkItemRecord searchUniqueByPropertyEqual(String property, Object value);

        public List<WorkItemRecord> getEnableWorkItems();

        public WorkItemRecord getWir4CaseIDTaskID(String caseId, String taskId);

        public List<WorkItemRecord> getMappedWorkItems(String stutus);

        public List<WorkItemFormMapHolder> getWorkItemWithForms(String status, User user);

        public List<WorkItemFormMapHolder> getWorkItemFormMapHolders(String status, List<MWorkItemInfo> wirInfos, User user);
}
