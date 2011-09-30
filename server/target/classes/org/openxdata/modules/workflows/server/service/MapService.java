/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.service;

import java.util.List;
import java.util.Map;
import org.openxdata.modules.workflows.model.shared.DBSpecStudyMap;
import org.openxdata.server.admin.model.FormDef;
import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;

/**
 *
 * @author kay
 */
public interface MapService
{
    public void save(List<DBSpecStudyMap> specStudyMaps);

    public void save(DBSpecStudyMap specStudyMap);

    public List<DBSpecStudyMap> getAllMaps();

    public void delete(DBSpecStudyMap map);

    public FormDef findMatchForWorkItem(WorkItemRecord wir);

    public DBSpecStudyMap getMapForWir(WorkItemRecord wir);

    public DBSpecStudyMap getMap4CaseIDtaskID(String caseID, String taskID);

    public Map<String, String> getOutPutParamQuestionMap(int formID, WorkItemRecord workitem);
}
