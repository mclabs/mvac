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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.op4j.Op;
import org.op4j.functions.Call;
import org.openxdata.model.ResponseHeader;
import org.openxdata.modules.workflows.server.context.WFContext;
import org.openxdata.modules.workflows.server.model.WorkItemFormMapHolder;
import org.openxdata.modules.workflows.server.service.ResourceService;
import org.openxdata.modules.workflows.server.service.WorkItemsService;
import org.openxdata.server.admin.model.User;
import org.openxdata.workflow.mobile.model.MWorkItemInfoList;
import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;

/**
 *
 * @author kay
 */
@SuppressWarnings("UseOfObsoleteCollectionType")
public class WIRDownloadByIdHandler implements RequestHandler {

        private final ResourceService service;
        private final WorkItemsService wirService;

        public WIRDownloadByIdHandler() {
                service = WFContext.getResourceService();
                wirService = WFContext.getWorkItemsService();
        }

        @Override
        public void handleRequest(User user, InputStream is, OutputStream os) throws IOException {
                try {
                        HandlerStreamUtil stream = new HandlerStreamUtil(is, os);
                        MWorkItemInfoList wirInfoList = new MWorkItemInfoList();
                        stream.read(wirInfoList);

                        Vector workItemInfoList = wirInfoList.getWorkItemInfo();

                        List<WorkItemFormMapHolder> wirMaps = service.getCurrentUserWorkItemFormMapHolders(workItemInfoList);

                        List workItems = Op.on(wirMaps).map(Call.methodForObject("toMWorkItem")).get();
                        stream.write(new ResponseHeader(ResponseHeader.STATUS_SUCCESS));
                        stream.writeSmallVector(new Vector(workItems));
                        stream.flush();

                        for (WorkItemFormMapHolder workItemFormMapHolder : wirMaps) {
                                disableWorkItem(workItemFormMapHolder.getWir());
                        }
                } catch (Exception ex) {
                        Logger.getLogger(WIRDownloadByIdHandler.class.getName()).log(Level.SEVERE, null, ex);
                        throw new RuntimeException(ex);
                }
        }

        private void disableWorkItem(WorkItemRecord wir) {
                wir.setStatus(WorkItemRecord.statusResourceStarted);
                wirService.saveWorkItem(wir);
        }
}
