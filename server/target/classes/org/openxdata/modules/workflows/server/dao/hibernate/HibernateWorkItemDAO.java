package org.openxdata.modules.workflows.server.dao.hibernate;

import com.trg.dao.hibernate.GenericDAOImpl;
import com.trg.search.Search;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.op4j.Op;
import org.op4j.functions.Call;
import org.openxdata.modules.workflows.model.shared.DBSpecStudyMap;
import org.openxdata.modules.workflows.server.dao.WorkItemDAO;
import org.openxdata.modules.workflows.server.model.WorkItemFormMapHolder;
import org.openxdata.server.admin.model.User;
import org.openxdata.workflow.mobile.model.MWorkItemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;

/**
 *
 * @author kay
 */
@Repository("workItemDAO")
public class HibernateWorkItemDAO extends GenericDAOImpl<WorkItemRecord, Integer>
        implements WorkItemDAO
{

        @Autowired
        @Override
        public void setSessionFactory(SessionFactory sessionFactory)
        {
                super.setSessionFactory(sessionFactory);
        }

        @Override
        public List<WorkItemRecord> searchByPropertyEqual(String property, Object value)
        {
                Search search = new Search();
                search.addFilterEqual(property, value);
                return search(search);
        }

        @Override
        public WorkItemRecord searchUniqueByPropertyEqual(String property, Object value)
        {
                Search search = new Search();
                search.addFilterEqual(property, value);
                return (WorkItemRecord) searchUnique(search);
        }

        @Override
        public List<WorkItemRecord> getEnableWorkItems()
        {
                return searchByPropertyEqual("_status", WorkItemRecord.statusExecuting);
        }

        @Override
        public WorkItemRecord getWir4CaseIDTaskID(String caseId, String taskId)
        {
                Search search = new Search();
                search.addFilterEqual("_caseID", caseId);
                search.addFilterEqual("_taskID", taskId);
                return searchUnique(search);
        }

        @Override
        public List<WorkItemFormMapHolder> getWorkItemWithForms(String status, User user)
        {
                return getWorkItemFoms(user, status, "");
        }

        @Override
        public List<WorkItemFormMapHolder> getWorkItemFormMapHolders(String status, List<MWorkItemInfo> wirInfos, User user)
        {
                StringBuilder builder = new StringBuilder();

                //Build a filter query based on the task ids and case id that were supplied
                //i.e <<WORKITEMS QUERY>> AND { (wir._taskID='EnterName' and wir._caseID='234.8') OR (......) }

                for (MWorkItemInfo wirInfo : wirInfos) {
                        if (builder.length() > 0) {
                                builder.append(" OR ");
                        }

                        builder.append("( wir._taskID='").
                                append(wirInfo.getTaskId()).
                                append("' and ").
                                append("wir._caseID='").
                                append(wirInfo.getCaseId()).
                                append("')");
                }

                return getWorkItemFoms(user, status, " AND (" + builder.toString() + ")");
        }

        /**
         * Get workItem + map + formversion for a particular user. Based on the status
         * of the workItem and an extra filter. The filter should be in HQL and it is
         * just appended to the entire query that this method uses to query the DB
         * @param user user who workitems should be fetched. if null administrator is assumed
         * @param status status of the workitem
         * @param filterString extra filter string should be in HQL
         * @return an object containing the Workitem + FormVersion + The Map
         * @throws HibernateException if there is an error in the HQL
         */
        private List<WorkItemFormMapHolder> getWorkItemFoms(User user, String status, String filterString) throws HibernateException
        {
                String queryString = getRequiredQuery(user);

                //Add status and filter supplied to the query
                queryString = queryString + " and wir._status=:status " + filterString;

                Query query = getSession().createQuery(queryString);
                query.setParameter("status", status);

                //Add user parameter only if the ""query"" has user restriction filter
                //otherwise u will get an error. Query for admins has no user filter
                //parameter
                if (user != null && !user.hasAdministrativePrivileges()) {
                        query.setParameter("user", user);
                }
                return toWorkItemMaps(query.list());
        }

        @Override
        public List<WorkItemRecord> getMappedWorkItems(String status)
        {
                List<WorkItemFormMapHolder> workItemFoms = getWorkItemFoms(null, status, "");
                List wirs = Op.on(workItemFoms).map(Call.methodForObject("getWir")).get();
                return wirs;
        }

        private List<WorkItemFormMapHolder> toWorkItemMaps(List<Object[]> list)
        {
                List<WorkItemFormMapHolder> formMapHolders = new ArrayList<WorkItemFormMapHolder>();
                for (Object object : list) {

                        Object[] items = (Object[]) object;
                        WorkItemRecord wir = (WorkItemRecord) items[0];
                        DBSpecStudyMap map = (DBSpecStudyMap) items[1];

                        WorkItemFormMapHolder formMap = new WorkItemFormMapHolder(wir, map);
                        if (formMap.getFormVersion() == null) {
                                //There was an error in the XML Map.
                                //This workitem task has no form Mapped to it.
                                //So dont add it to the mapped workItems
                                continue;
                        }
                        Hibernate.initialize(map.getSpecifications());
                        formMapHolders.add(formMap);
                }
                return formMapHolders;
        }

        private String getRequiredQuery(User user)
        {
                String queryString = null;
                if (user == null || user.hasAdministrativePrivileges()) {
                        queryString = "select distinct (wir), map from WorkItemRecord wir, DBSpecStudyMap map "
                                + " where wir._specificationID = map.specifications.name and"
                                + " wir._specVersion=map.specifications.version  ";
                } else {
                        queryString = "select distinct (wir), map from "
                                + " WorkItemRecord wir, DBSpecStudyMap map, FormDef def, User u "
                                + " where  u=:user and "
                                + " wir._specificationID = map.specifications.name and "
                                + " wir._specVersion=map.specifications.version and "
                                + " def.study = map.study and "
                                + " (u in elements(def.users) or u in elements(def.study.users))";
                }
                return queryString;
        }

       
}
