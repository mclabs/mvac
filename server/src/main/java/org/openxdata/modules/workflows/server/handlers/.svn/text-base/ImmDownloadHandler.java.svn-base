/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.modules.workflows.server.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.op4j.Op;
import org.op4j.functions.Call;
import org.openxdata.modules.workflows.server.context.WFContext;
import org.openxdata.modules.workflows.server.model.WorkItemFormMapHolder;
import org.openxdata.modules.workflows.server.service.LaunchCaseService;
import org.openxdata.modules.workflows.server.service.ResourceService;
import org.openxdata.modules.workflows.server.service.WorkItemsService;
import org.openxdata.server.admin.model.User;
import org.yawlfoundation.yawl.engine.YSpecificationID;
import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;

/**
 *
 * @author soyfactor
 */
public class ImmDownloadHandler implements RequestHandler{
    private final ResourceService resourceService;
    private final WorkItemsService wirService;
    private LaunchCaseService launchSrv;

    public ImmDownloadHandler(){
        resourceService = WFContext.getResourceService();
        wirService = WFContext.getWorkItemsService();
        launchSrv=WFContext.getLaunchcaseService();
    }

    @Override
    public void handleRequest(User user, InputStream is, OutputStream os) throws IOException {
        //launchcases based on params e.g Nurse_ID and dates
        //For now launching is done using test Data
        System.out.println("Starting launch case");
        List<String> caseIDS=new ArrayList<String>();
        YSpecificationID specID=new YSpecificationID("appointment","0.4");
        caseIDS=launchSrv.launchcases(specID, "Nothing");
        System.out.println("Ending launch cases");

        //end launch of cases
        List<WorkItemFormMapHolder> wirFormMaps = resourceService.getCurrentUserWorkItemFormMapHolders();
        List workItems = Op.on(wirFormMaps).map(Call.methodForObject("toMWorkItem")).get();
        HandlerStreamUtil streamHelper = new HandlerStreamUtil(is, os);
        streamHelper.writeSucess();
        streamHelper.writeSmallVector(new Vector(workItems));
        streamHelper.flush();
        //Disable all the work items
        for (WorkItemFormMapHolder wir : wirFormMaps) {
              //disableWorkItem(wir.getWir());
        }
    }
    
    private void disableWorkItem(WorkItemRecord wir)
    {
        wir.setStatus(WorkItemRecord.statusResourceStarted);
        wirService.saveWorkItem(wir);
    }



}
