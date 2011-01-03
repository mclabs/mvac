package org.openxdata.server.admin.server.workflows;

import com.google.inject.Singleton;
import java.util.List;
import org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem;
import org.openxdata.server.admin.client.service.workflow.WorkItemsService;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.rpc.OxdPersistentRemoteService;

@Singleton
public class WorkItemsServiceImpl extends OxdPersistentRemoteService implements
        WorkItemsService {

    @Override
    public List<GWTFriendlyWorkItem> getWorkItems() throws OpenXDataException {
        return null;
    }
}
