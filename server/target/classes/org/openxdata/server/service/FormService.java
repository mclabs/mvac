/*
 *  Licensed to the OpenXdata Foundation (OXDF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The OXDF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, 
 *  software distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 *
 *  Copyright 2010 http://www.openxdata.org.
 */
package org.openxdata.server.service;

import java.util.List;

import org.openxdata.server.admin.model.ExportedFormDataList;
import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.FormDef;


public interface FormService {

    /**
     * Saves the data captured by the user for a particular form
     * @param formData FormData
     * @return FormData that was saved (contains id reference)
     */
    FormData saveFormData(FormData formData);
    
    /**
     * Retrieves all the form definitions in the system
     * @return List of FormDef
     */
    List<FormDef> getForms();
    
    /**
     * Retrives all the form definitions that are available for the currently logged in user
     * @return List of FormDef
     */
    List<FormDef> getFormsForCurrentUser();
    
    /**
     * Calculates the number of responses captured for a specified formDefVersion
     * @param formId int identifier for a form definition version
     * @return Integer (positive number, 0 for no responses)
     */
    Integer getFormResponseCount(int formDefVersionId);
    
    /**
     * Retrieves all the FormData for a specified formDefVersion
     * @param formId int identifier of the form definition version
     * @return List of FormData
     */
    List<FormData> getFormData(int formDefVersionId);
    
    /**
     * Retrieves a page of the form data (directly from exported tables) for a specified form definition
     * @param formBinding String xform binding (table name)
     * @param formFields String question binding (column names)
     * @param offset int indicating at which position to start returning FormData objects
     * @param limit int indicating how many FormData objects to return
     * @param sortField String containing binding of field to sort
     * @param ascending boolean true if the sort should be ascendings
     * @return ExportedFormDataList containing ExportedData
     */
    ExportedFormDataList getFormDataList(String formBinding, String[] questionBindings, int offset, int limit, String sortField, boolean ascending);
}
