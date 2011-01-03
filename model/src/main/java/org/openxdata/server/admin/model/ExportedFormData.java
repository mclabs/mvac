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
package org.openxdata.server.admin.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import net.sf.gilead.pojo.gwt.LightEntity;

/**
 * Class to represent exported form data - form data that has been
 * archived to a rdms.
 * 
 * @author dagmar@cell-life.org
 * @author simon@cell-life.org
 */
public class ExportedFormData extends LightEntity {

    private static final long serialVersionUID = -3170346869483517114L;

    /** original form data */
    private FormData formData;
    /** array of exported form data in original format. question binding is used as the key*/
    private Map<String, ExportedDataType> exportedFields = new HashMap<String, ExportedDataType>();

    public ExportedFormData() {
        super();
    }
    
    public ExportedFormData(FormData formData) {
        super();
        this.formData = formData;
    }

    public ExportedFormData(FormData formData, Map<String, ExportedDataType> exportedFields) {
        super();
        this.formData = formData;
        this.exportedFields = exportedFields;
    }

    public FormData getFormData() {
        return formData;
    }

    public void setFormData(FormData formData) {
        this.formData = formData;
    }

    public Map<String, ExportedDataType> getExportedFields() {
        return exportedFields;
    }
    
    public ExportedDataType getExportedField(String binding) {
        return exportedFields.get(binding);
    }

    public void setExportedFields(Map<String, ExportedDataType> exportedFields) {
        this.exportedFields = exportedFields;
    }
    
    /**
     * Converts the Serializable object for the field (from the database) 
     * to an ExportedDataType (which can be used in the client) 
     * and stores the value in a map using the key
     * 
     * @param key String key identifying the field
     * @param fieldObject Serializable object representing the field value
     */
    public void putExportedField(String key, Serializable fieldObject) {
        if (fieldObject != null) {
            ExportedDataType dataType = ExportedDataType.getDataType(fieldObject);
        	if (dataType == null)
        		throw new IllegalArgumentException("Unsupported type of fieldObject: '" + fieldObject.getClass().getName() + "' for field: '" + key + "'");
        	this.exportedFields.put(key, dataType);
        }
    }
}
