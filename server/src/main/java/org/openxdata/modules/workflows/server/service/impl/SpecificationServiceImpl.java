/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openxdata.modules.workflows.server.dao.DBSpecificationDAO;
import org.openxdata.modules.workflows.server.service.SpecificationService;
import org.openxdata.modules.workflows.server.util.OxdUtil;
import org.openxdata.modules.workflows.model.shared.DBSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yawlfoundation.yawl.elements.YSpecification;
import org.yawlfoundation.yawl.unmarshal.YMarshal;

/**
 *
 * @author kay
 */
@Transactional
@Service("specificationsService")
public class SpecificationServiceImpl implements SpecificationService
{
    @Autowired
    private DBSpecificationDAO specDAO;

    public SpecificationServiceImpl()
    {
    }

    public SpecificationServiceImpl(DBSpecificationDAO specDAO)
    {
        this.specDAO = specDAO;
    }

    @Override
    public void saveSpec(YSpecification specification)
    {
        specDAO.save(OxdUtil.fromSpecificationToBSpecification(specification));
    }

    @Override
    public void saveSpecs(String specifications)
    {
        try {
            List<YSpecification> unmarshalSpecifications = YMarshal.unmarshalSpecifications(specifications, false);
            for (YSpecification ySpecification : unmarshalSpecifications) {
                saveSpec(ySpecification);
            }
        } catch (Exception ex) {
            org.apache.log4j.Logger.getLogger(getClass()).error("Problem While Unmarshalling", ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<YSpecification> getSpecifications()
    {
        List<YSpecification> ySpecs = new ArrayList<YSpecification>();

        for (DBSpecification dBSpecification : getDBSpecifications()) {
            try {
                YSpecification ySpec = OxdUtil.fromDBSpecToYSpec(dBSpecification);
                ySpecs.add(ySpec);
            } catch (Exception ex) {
                //Just Log and continue unmarshalling the rest
                Logger.getLogger(SpecificationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ySpecs;
    }

    @Override
    public List<DBSpecification> getDBSpecifications()
    {
        return specDAO.findAll();
    }

    @Override
    public DBSpecification getDBSpecWithSpecID(String specID)
    {
        return specDAO.searchUniqueByPropertyEqual("specId", specID);
    }

    @Override
    public YSpecification getSpec(String specID, String version)
    {
        try {
            DBSpecification dbSpec = specDAO.getDBSpecBySpecID(specID, version);
            if (dbSpec == null)
                return null;
            YSpecification ySpec = OxdUtil.fromDBSpecToYSpec(dbSpec);
            return ySpec;
        } catch (Exception ex) {
            Logger.getLogger(SpecificationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
}
