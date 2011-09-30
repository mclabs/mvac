/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.server.admin.client.service.workflow;

import com.google.gwt.user.client.rpc.RemoteService;
import java.util.List;
import org.openxdata.modules.workflows.model.shared.OSpecification;
import org.openxdata.server.admin.model.exception.OpenXDataException;

/**
 *
 * @author kay
 */
public interface SpecificationService extends RemoteService {

    public List<OSpecification> getOSpecifications() throws OpenXDataException;
}
