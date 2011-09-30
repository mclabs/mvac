package org.openxdata.server.admin.server.workflows;

import com.google.inject.Singleton;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import org.openxdata.modules.workflows.model.shared.DBSpecStudyMap;
import org.openxdata.modules.workflows.model.shared.DBSpecification;
import org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem;
import org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO;
import org.openxdata.modules.workflows.server.context.WFContext;
import org.openxdata.modules.workflows.server.model.WorkItemFormMapHolder;
import org.openxdata.modules.workflows.server.service.MapService;
import org.openxdata.modules.workflows.server.service.ResourceService;
import org.openxdata.modules.workflows.server.service.SpecificationService;
import org.openxdata.server.admin.client.service.workflow.SpecStudyMapService;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.rpc.OxdPersistentRemoteService;

/**
 *
 * @author kay
 */
@Singleton
public class SpecStudyMapServiceImpl extends OxdPersistentRemoteService
        implements SpecStudyMapService
{
    private MapService specStudySrv;
    private SpecificationService specSrv;
    private ResourceService rsrcSrv;

    @Override
    public void init() throws ServletException
    {
        super.init();
        specStudySrv = (MapService) getApplicationContext().getBean("specStudyService");
        specSrv = (SpecificationService) getApplicationContext().getBean("specificationsService");
        rsrcSrv = WFContext.getResourceService();
    }

    @Override
    public void saveSpecStudyList(ArrayList<SpecStudyMapDTO> maps) throws OpenXDataException
    {
        for (SpecStudyMapDTO specStudyMapDTO : maps) {
            saveSpecStudyMap(specStudyMapDTO);
        }
    }

    @Override
    public void saveSpecStudyMap(SpecStudyMapDTO mapDTO) throws OpenXDataException
    {
        try {
            DBSpecStudyMap dbSpMap = convertToDBSpecStudy(mapDTO);
            specStudySrv.save(dbSpMap);
        } catch (Throwable t) {
            throw new OpenXDataException(t);
        }
    }

    private DBSpecStudyMap convertToDBSpecStudy(SpecStudyMapDTO mapDTO)
    {
        DBSpecification dbSpec = specSrv.getDBSpecWithSpecID(mapDTO.getSpecId());
        DBSpecStudyMap dbSpMap = new DBSpecStudyMap(dbSpec, mapDTO.getStudyDef(), mapDTO.getXmlMap());
        dbSpMap.setId(mapDTO.getId());
        return dbSpMap;
    }

    @Override
    public ArrayList<DBSpecStudyMap> getAllMaps() throws OpenXDataException
    {
        try {
            return (ArrayList<DBSpecStudyMap>) specStudySrv.getAllMaps();
        } catch (Throwable t) {
            t.printStackTrace();
            throw new OpenXDataException(t);
        }
    }

    @Override
    public String getEntireXMLMap() throws OpenXDataException
    {
        ArrayList<DBSpecStudyMap> allMaps = getAllMaps();
        StringBuilder builder = new StringBuilder();
        builder.append("<Maps>");
        for (DBSpecStudyMap dBSpecStudyMap : allMaps) {
            builder.append(dBSpecStudyMap.getXml());
        }
        builder.append("</Maps>");
        return builder.toString();
    }

    @Override
    public void deleteSpecStudyList(ArrayList<SpecStudyMapDTO> mapDTOs) throws OpenXDataException
    {
        for (SpecStudyMapDTO mapDTO : mapDTOs) {
            deleteSpecStudy(mapDTO);
        }
    }

    @Override
    public void deleteSpecStudy(SpecStudyMapDTO mapDTO) throws OpenXDataException
    {
        try {
            DBSpecStudyMap dbSpecStudy = convertToDBSpecStudy(mapDTO);
            specStudySrv.delete(dbSpecStudy);
        } catch (Throwable t) {
            t.printStackTrace();
            throw new OpenXDataException(t);
        }
    }

    @Override
    public ArrayList<GWTFriendlyWorkItem> getMappedWorkItems() throws OpenXDataException
    {
        ArrayList<WorkItemFormMapHolder> mobileWorkItems = (ArrayList<WorkItemFormMapHolder>) rsrcSrv.getCurrentUserWorkItemFormMapHolders();
        ArrayList<GWTFriendlyWorkItem> gwtfwis = new ArrayList<GWTFriendlyWorkItem>();

        for (WorkItemFormMapHolder mwir : mobileWorkItems) {
            try {
                GWTFriendlyWorkItem gwtfwi = WFContext.getYawlService().getGWTFriendlyWorkItem(mwir.getWir(), false);
                gwtfwis.add(gwtfwi);
            } catch (IOException ex) {
                Logger.getLogger(SpecStudyMapServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return gwtfwis;
    }

    @Override
    public void saveMaos(ArrayList<SpecStudyMapDTO> dirtyMaps,
                         ArrayList<SpecStudyMapDTO> deletedMaps) throws OpenXDataException
    {
        if (dirtyMaps != null)
            saveSpecStudyList(dirtyMaps);
        if (deletedMaps != null)
            deleteSpecStudyList(deletedMaps);
    }
}
