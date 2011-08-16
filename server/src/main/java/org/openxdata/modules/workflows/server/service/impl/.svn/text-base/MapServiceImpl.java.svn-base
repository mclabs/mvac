/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.openxdata.modules.workflows.model.shared.DBSpecStudyMap;
import org.openxdata.modules.workflows.server.dao.DBSpecStudyMapDAO;
import org.openxdata.modules.workflows.server.maps.parser.MatcherHelper;
import org.openxdata.modules.workflows.server.service.MapService;
import org.openxdata.modules.workflows.server.service.WorkItemsService;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.dao.FormDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yawlfoundation.yawl.elements.data.YParameter;
import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;

/**
 *
 * @author kay
 */
@Transactional
@Service("specStudyService")
public class MapServiceImpl implements MapService
{

        @Autowired
        private DBSpecStudyMapDAO specStudyMapDAO;
        @Autowired
        private FormDAO formDAO;
        @Autowired
        private WorkItemsService wirSrv;
        private Logger log = Logger.getLogger(this.getClass());

        public void setSpecStudyMapDAO(DBSpecStudyMapDAO specStudyMapDAO)
        {
                this.specStudyMapDAO = specStudyMapDAO;
        }

        public void setFormDAO(FormDAO formDAO)
        {
                this.formDAO = formDAO;
        }

        public void setWirSrv(WorkItemsService wirSrv)
        {
                this.wirSrv = wirSrv;
        }



        @Override
        public void save(List<DBSpecStudyMap> specStudyMaps)
        {
                for (DBSpecStudyMap dBSpecStudyMap : specStudyMaps) {
                        specStudyMapDAO.save(dBSpecStudyMap);
                }
        }

        @Override
        public void save(DBSpecStudyMap specStudyMap)
        {
                specStudyMapDAO.save(specStudyMap);
        }

        @Override
        public List<DBSpecStudyMap> getAllMaps()
        {
                return specStudyMapDAO.findAll();
        }

        @Override
        public void delete(DBSpecStudyMap map)
        {
                specStudyMapDAO.remove(map);
        }

        @Override
        public DBSpecStudyMap getMapForWir(WorkItemRecord wir)
        {
                return getMap4CaseIDtaskID(wir.getCaseID(), wir.getTaskID());
        }

        @Override
        public DBSpecStudyMap getMap4CaseIDtaskID(String caseID, String taskID)
        {
                return specStudyMapDAO.getMap(caseID, taskID);
        }

        @Override
        public FormDef findMatchForWorkItem(WorkItemRecord wir)
        {
                if (wir == null)
                        return null;
                int formIdForWorkItem = getMatchingFormIdForWorkItem(wir);
                if (formIdForWorkItem == -1)
                        return null;
                return formDAO.find(formIdForWorkItem);
        }

        public int getMatchingFormIdForWorkItem(WorkItemRecord wir)
        {
                DBSpecStudyMap requiredMap = getMapForWir(wir);
                if (requiredMap == null) {
                        return -1;
                }
                String taskID = wir.getTaskID();
                String formIdForTask = MatcherHelper.getFormIdForTask(taskID, requiredMap.getXml());
                try {
                        return Integer.parseInt(formIdForTask);
                } catch (NumberFormatException ex) {
                        log.error(wir + " Workitem has no valid formId match in map " + requiredMap.getXml(), ex);
                        return -1;
                }
        }

        @Override
        public Map<String, String> getOutPutParamQuestionMap(int formID, WorkItemRecord workitem)
        {
                String xmlMap = getMap4CaseIDtaskID(workitem.getCaseID(), workitem.getTaskID()).getXml();
                Map<String, YParameter> outputParams = wirSrv.getOutputParam(workitem);
                Map<String, String> paramQnMap = new HashMap<String, String>();
                for (String paramVar : outputParams.keySet()) {
                        String qnVar = MatcherHelper.getQuestionText(workitem.getTaskID(), formID + "", paramVar, xmlMap);
                        paramQnMap.put(paramVar, qnVar);
                }
                return paramQnMap;
        }
}
