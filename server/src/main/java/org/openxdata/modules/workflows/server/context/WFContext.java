package org.openxdata.modules.workflows.server.context;

import org.openxdata.modules.workflows.server.YawlOXDCustomService;
import org.openxdata.modules.workflows.server.service.WorkItemsService;

import org.openxdata.modules.workflows.server.handlers.ProcessorCreator;
import org.openxdata.modules.workflows.server.service.LaunchCaseService;
import org.openxdata.modules.workflows.server.service.MapService;
import org.openxdata.modules.workflows.server.service.ResourceService;
import org.openxdata.modules.workflows.server.service.SpecificationService;
import org.openxdata.server.Context;
import org.openxdata.server.service.FormDownloadService;

public class WFContext {
    public static WorkItemsService getWorkItemsService() {
        return (WorkItemsService) Context.getBean("workItemsService");
    }

    public static SpecificationService getSpecificationService() {
        return (SpecificationService) Context.getBean("specificationsService");
    }

    public static MapService getSpecStudyService() {
        return (MapService) Context.getBean("specStudyService");
    }

    public static ProcessorCreator getProcessorCreator() {
        return (ProcessorCreator) Context.getBean("processorCreator");
    }

    public static YawlOXDCustomService getYawlService() {
        return (YawlOXDCustomService) Context.getBean("YawlOXDCustomService");
    }

    public static FormDownloadService getFormDownloadService() {
        return (FormDownloadService) Context.getBean("formDownloadService");
    }

    public static ResourceService getResourceService() {
        return (ResourceService) Context.getBean("resourceService");
    }

    public static YawlOXDCustomService getOXDCustomService() {
        return (YawlOXDCustomService) Context.getBean("YawlOXDCustomService");
    }

    public static LaunchCaseService getLaunchcaseService(){
        return (LaunchCaseService)Context.getBean("launchCaseService");
    }
}
