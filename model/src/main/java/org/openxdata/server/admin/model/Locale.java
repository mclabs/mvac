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
 * This class represents a locale or language.
 * 
 * @author daniel
 *
 */
public class Locale extends AbstractEditable{
	
	/**
	 * Serialisation ID
	 */
	private static final long serialVersionUID = 2100312849246884803L;

	/** The data base identifier for the locale. */
	private int localeId = 0;
	
	/** The locale key. eg en */
	private String key;
	
	/** The locale name. eg English. */
	private String name;
	
	
	/** Constructs a new locale object. */
	public Locale(){
		
	}
	
	public int getLocaleId() {
		return localeId;
	}
	
	@Override
	public int getId() {
		return localeId;
	}
	
	public void setLocaleId(int localeId) {
		this.localeId = localeId;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean isNew(){
		return localeId == 0;
	}
}
