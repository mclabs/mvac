/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.server.admin.server.workflows;

import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import org.openxdata.modules.workflows.model.shared.OSpecification;
import org.openxdata.modules.workflows.server.service.SpecificationService;
import org.openxdata.modules.workflows.server.util.SpecificationMapperUtil;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.rpc.OxdPersistentRemoteService;
import org.yawlfoundation.yawl.elements.YSpecification;

/**
 *
 * @author kay
 */
@Singleton
public class SpecificationServiceImpl extends OxdPersistentRemoteService
        implements
        org.openxdata.server.admin.client.service.workflow.SpecificationService
{

    private SpecificationService specService;

    @Override
    public void init() throws ServletException
    {
        super.init();
        specService = (SpecificationService) getApplicationContext().getBean("specificationsService");
    }

    //TODO: Shift the specification mapper to the serverside
    @Override
    public List<OSpecification> getOSpecifications() throws OpenXDataException
    {

        try {
            List<YSpecification> specifications = specService.getSpecifications();
            List<OSpecification> oSpecs = new ArrayList<OSpecification>();
            for (YSpecification ySpecification : specifications) {
                OSpecification oSpec = SpecificationMapperUtil.mapToSimpleOXDModel(ySpecification);
                oSpecs.add(oSpec);
            }
            return oSpecs;
        } catch (Throwable t) {
            throw new OpenXDataException(t);
        }
    }
}
