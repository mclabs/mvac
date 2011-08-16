/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Vector;
import org.op4j.Op;
import org.op4j.functions.Call;
import org.openxdata.modules.workflows.server.context.WFContext;
import org.openxdata.modules.workflows.server.model.WorkItemFormMapHolder;
import org.openxdata.modules.workflows.server.service.ResourceService;
import org.openxdata.modules.workflows.server.service.WorkItemsService;
import org.openxdata.server.admin.model.User;
import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;

/**
 *
 * @author kay
 */
@SuppressWarnings("UseOfObsoleteCollectionType")
public class WIRDownloadHandler implements RequestHandler
{

        private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());
        private final ResourceService resourceService;
        private final WorkItemsService wirService;

        public WIRDownloadHandler()
        {
                resourceService = WFContext.getResourceService();
                wirService = WFContext.getWorkItemsService();
        }

        @Override
        public void handleRequest(User user, InputStream is, OutputStream os) throws IOException
        {
                log.debug("Downloading workitems for User: "+user.getName());
                List<WorkItemFormMapHolder> wirFormMaps = resourceService.getCurrentUserWorkItemFormMapHolders();
                List workItems = Op.on(wirFormMaps).map(Call.methodForObject("toMWorkItem")).get();
                HandlerStreamUtil streamHelper = new HandlerStreamUtil(is, os);
                streamHelper.writeSucess();
                streamHelper.writeSmallVector(new Vector(workItems));
                streamHelper.flush();
                //Disable all the work items
                for (WorkItemFormMapHolder wir : wirFormMaps) {
                        disableWorkItem(wir.getWir());
                }
        }

        private void disableWorkItem(WorkItemRecord wir)
        {
                wir.setStatus(WorkItemRecord.statusResourceStarted);
                wirService.saveWorkItem(wir);
        }
}
