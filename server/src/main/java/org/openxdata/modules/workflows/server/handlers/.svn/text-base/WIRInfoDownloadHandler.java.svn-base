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
import org.openxdata.server.admin.model.User;

/**
 *
 * @author kay
 */
@SuppressWarnings("UseOfObsoleteCollectionType")
public class WIRInfoDownloadHandler implements RequestHandler {


        private ResourceService rsService;

        public WIRInfoDownloadHandler() {
                rsService = WFContext.getResourceService();
        }

        @Override
        public void handleRequest(User user, InputStream is, OutputStream os) throws IOException {
                List<WorkItemFormMapHolder> wirFormMap = rsService.getCurrentUserWorkItemFormMapHolders();
                List infos = Op.on(wirFormMap).map(Call.methodForObject("asMWorkItemInfo")).get();
                HandlerStreamUtil streamHelper = new HandlerStreamUtil(is, os);
                streamHelper.writeSucess();
                streamHelper.writeBigVector(new Vector(infos));
                streamHelper.flush();
        }
}
