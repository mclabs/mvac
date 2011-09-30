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

import java.util.ArrayList;
import java.util.List;

import net.sf.gilead.pojo.gwt.LightEntity;

public class ExportedFormDataList extends LightEntity {

    private static final long serialVersionUID = -1839643565661087763L;

    private Integer fromIndex;
    private Integer toIndex;
    private Integer totalSize;

    private List<ExportedFormData> exportedFormDataList = new ArrayList<ExportedFormData>();

    public ExportedFormDataList() {
    }

    public Integer getFromIndex() {
        return fromIndex;
    }

    public void setFromIndex(Integer fromIndex) {
        this.fromIndex = fromIndex;
    }

    public Integer getToIndex() {
        return toIndex;
    }

    public void setToIndex(Integer toIndex) {
        this.toIndex = toIndex;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public List<ExportedFormData> getExportedFormData() {
        return exportedFormDataList;
    }

    public void setExportedFormData(List<ExportedFormData> exportedFormData) {
        this.exportedFormDataList = exportedFormData;
    }
    
    public void addExportedFormData(ExportedFormData exportedFormData) {
        this.exportedFormDataList.add(exportedFormData);
    }
}
