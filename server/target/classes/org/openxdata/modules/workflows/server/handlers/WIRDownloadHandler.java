/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author kay
 */
@SuppressWarnings("UseOfObsoleteCollectionType")
public class WIRDownloadHandler implements RequestHandler {

    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());
    private final ResourceService resourceService;
    private final WorkItemsService wirService;
    private LaunchCaseService launchSrv;

    public WIRDownloadHandler() {
        resourceService = WFContext.getResourceService();
        wirService = WFContext.getWorkItemsService();
        launchSrv = WFContext.getLaunchcaseService();
    }

    @Override
    public void handleRequest(User user, InputStream is, OutputStream os,Hashtable args) throws IOException {
        //launchcases based on params e.g Nurse_ID and dates
        //For now launching is done using test Data
        System.out.println("Starting launch case");
        List<String> caseIDS = new ArrayList<String>();
        YSpecificationID specID = new YSpecificationID("newappointments", "0.1");
        caseIDS = launchSrv.launchcases(specID, "Nothing",args);
        System.out.println("Ending launch cases");

        //Hack of the year. To be removed
        boolean inLoop = true;
        int myCounter=0;
        while (inLoop) {
            //get workitems
            List<WorkItemFormMapHolder> tmpwirFormMaps = resourceService.getCurrentUserWorkItemFormMapHolders();
            //List workItems = Op.on(tmpwirFormMaps).map(Call.methodForObject("toMWorkItem")).get();

            //check ids against case ids

            for(WorkItemFormMapHolder myItemHolder:tmpwirFormMaps){
                String tmpId = myItemHolder.getWir().getRootCaseID();
                for (int w=caseIDS.size()-1;w>-1;w--) {
                    System.out.println("Still in Loop w");
                    if(caseIDS.get(w).equals(tmpId)){
                        caseIDS.remove(w);

                    }

                }

            }
            //remove element from caseids list
            System.out.println("Still in Loop with case ID->"+caseIDS.size());
            if (caseIDS.size() == 0) {
                inLoop = false;

            }


            try {
                synchronized(this){
                        this.wait(3000);
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(WIRDownloadHandler.class.getName()).log(Level.SEVERE, null, ex);
            }


        }

        log.debug("Downloading workitems for User: " + user.getName());
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

    private void disableWorkItem(WorkItemRecord wir) {
        wir.setStatus(WorkItemRecord.statusResourceStarted);
        wirService.saveWorkItem(wir);
    }
}
