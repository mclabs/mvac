package org.celllife.emit.client.service;

import java.util.List;

import org.openxdata.server.admin.model.ExportedFormDataList;
import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.exception.OpenXDataException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("form")
public interface FormService extends RemoteService {
	
    /**
     * Saves the data captured by the user for a particular form
     * @param formData FormData
     * @return FormData that was saved (contains id reference)
     */
    FormData saveFormData(FormData formData) throws Exception;
    
    /**
     * Retrieves all the form definitions in the system
     * @return List of FormDef
     */
    List<FormDef> getForms() throws OpenXDataException;
    
    /**
     * Retrives all the form definitions that are available for the currently logged in user
     * @return List of FormDef
     */
    List<FormDef> getFormsForCurrentUser() throws OpenXDataException;
    
    /**
     * Calculates the number of responses captured for a specified formDefVersion
     * @param formId int identifier for a form def version
     * @return Integer (positive number, 0 for no responses)
     */
    Integer getFormResponseCount(int formDefVersionId) throws OpenXDataException;    
    /**
     * Retrieves all the FormData for a specified formDefVersion
     * @param formId int identifier of the form def version
     * @return List of FormData
     */
    List<FormData> getFormData(int formDefVersionId) throws OpenXDataException;
    
    /**
     * Retrieves a page of the form data (directly from exported tables) for a specified form definition
     * @param formBinding String xform binding (table name)
     * @param formFields String question binding (column names)
     * @param offset int indicating at which position to start returning FormData objects
     * @param limit int indicating how many FormData objects to return
     * @param sortField String containing the binding of the question the data should be sorted by
     * @param ascending boolean true if sort should be ascending
     * @return ExportedFormDataList containing ExportedData
     * @throws OpenXDataException
     */
    ExportedFormDataList getFormDataList(String formBinding, String[] questionBindings, int offset, int limit, String sortField, boolean ascending) throws OpenXDataException;
}
