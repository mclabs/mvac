/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.service;

import java.util.List;
import org.openxdata.modules.workflows.server.model.WorkItemFormMapHolder;
import org.openxdata.server.admin.model.User;
import org.openxdata.workflow.mobile.model.MWorkItemInfo;
import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;

/**
 *
 * @author kay
 */
public interface ResourceService
{
    public List<WorkItemRecord> getWorkItemsForCurrentUser();

    public List<WorkItemRecord> getWorkItemsForUser(User user);

    public List<WorkItemFormMapHolder> getCurrentUserWorkItemFormMapHolders();

    public List<WorkItemFormMapHolder> getCurrentUserWorkItemFormMapHolders(List<MWorkItemInfo> wirInfo);
}
