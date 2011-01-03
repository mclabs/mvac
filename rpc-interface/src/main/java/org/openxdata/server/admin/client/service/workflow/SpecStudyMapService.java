/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.server.admin.client.service.workflow;

import com.google.gwt.user.client.rpc.RemoteService;
import java.util.ArrayList;
import org.openxdata.modules.workflows.model.shared.DBSpecStudyMap;
import org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem;
import org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO;
import org.openxdata.server.admin.model.exception.OpenXDataException;

/**
 *
 * @author kay
 */
public interface SpecStudyMapService extends RemoteService
{
    public void saveSpecStudyList(ArrayList<SpecStudyMapDTO> maps) throws OpenXDataException;

    public void saveSpecStudyMap(SpecStudyMapDTO mapDTO) throws OpenXDataException;

    public void saveMaos(ArrayList<SpecStudyMapDTO> dirtyMaps,
                         ArrayList<SpecStudyMapDTO> deletedMaps) throws OpenXDataException;

    public ArrayList<DBSpecStudyMap> getAllMaps() throws OpenXDataException;

    public String getEntireXMLMap() throws OpenXDataException;

    public void deleteSpecStudyList(ArrayList<SpecStudyMapDTO> mapDTOs) throws OpenXDataException;

    public void deleteSpecStudy(SpecStudyMapDTO mapDTO) throws OpenXDataException;

    public ArrayList<GWTFriendlyWorkItem> getMappedWorkItems() throws OpenXDataException;
}
