/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.service.impl;

import java.util.List;
import java.util.Map;
import org.openxdata.modules.workflows.server.dao.WorkItemDAO;
import org.openxdata.modules.workflows.server.model.WorkItemFormMapHolder;
import org.openxdata.modules.workflows.server.service.MapService;
import org.openxdata.modules.workflows.server.service.ResourceService;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.service.FormService;
import org.openxdata.server.service.UserService;
import org.openxdata.workflow.mobile.model.MWorkItemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;

/**
 *
 * @author kay
 */
@Transactional
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService
{
    @Autowired
    private UserService userService;
    @Autowired
    private MapService mapService;
    @Autowired
    private FormService formService;
    @Autowired
    private WorkItemDAO dao;

    @Override
    public List<WorkItemFormMapHolder> getCurrentUserWorkItemFormMapHolders()
    {
        return dao.getWorkItemWithForms(WorkItemRecord.statusExecuting, userService.getLoggedInUser());
    }

    @Override
    public List<WorkItemRecord> getWorkItemsForUser(User user)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<WorkItemRecord> getWorkItemsForCurrentUser()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<WorkItemFormMapHolder> getCurrentUserWorkItemFormMapHolders(List<MWorkItemInfo> wirInfos)
    {
        return dao.getWorkItemFormMapHolders(WorkItemRecord.statusExecuting, wirInfos, userService.getLoggedInUser());
    }
}
