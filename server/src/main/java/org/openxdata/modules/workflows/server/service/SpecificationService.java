/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.service;

import java.util.List;
import org.openxdata.modules.workflows.model.shared.DBSpecification;
import org.yawlfoundation.yawl.elements.YSpecification;

/**
 *
 * @author kay
 */
public interface SpecificationService
{
    public void saveSpec(YSpecification specification);

    public void saveSpecs(String specifications);

    public List<YSpecification> getSpecifications();

    public List<DBSpecification> getDBSpecifications();

    public DBSpecification getDBSpecWithSpecID(String specID);

    public YSpecification getSpec(String specID, String version);



}
