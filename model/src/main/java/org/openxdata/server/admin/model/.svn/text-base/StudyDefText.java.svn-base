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

/**
 * This class contains text for a study in a given locale.
 * 
 * @author daniel
 *
 */
public class StudyDefText extends AbstractEditable{

	/**
	 * Serialisation ID
	 */
	private static final long serialVersionUID = -4438293413015913822L;

	/** The database identifier for the study text. */
	private int studyTextId = 0;
	
	/** The database identifier for the study whose text we contain. */
	private int studyId;
	
	/** The locale key for this study text. */
	private String localeKey;
	
	/** The name of the study in the locale specified by the localKey field. */
	private String name;
	
	/** The description of the study in the locale specified in the localeKey field. */
	private String description;
	
	/**
	 * Constructs a new study text object.
	 */
	public StudyDefText(){
		
	}

	public int getStudyTextId() {
		return studyTextId;
	}

	@Override
	public int getId() {
		return studyTextId;
	}

	public void setStudyTextId(int studyTextId) {
		this.studyTextId = studyTextId;
	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public String getLocaleKey() {
		return localeKey;
	}

	public void setLocaleKey(String localeKey) {
		this.localeKey = localeKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public boolean isNew(){
		return studyTextId == 0;
	}
}
