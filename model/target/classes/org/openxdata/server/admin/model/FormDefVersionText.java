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
 * This class represents locale text of a form version.
 * 
 * @author daniel
 *
 */
public class FormDefVersionText extends AbstractEditable{

	/**
	 * Serialisation ID
	 */
	private static final long serialVersionUID = -8844252387415837817L;

	/** The database identifier of the form version text. */
	private int formDefVersionTextId = 0;
	
	/** The database identifier of the form version whose text we represent. */
	private int formDefVersionId;
	
	/** The key of the locale. */
	private String localeKey;
	
	/** The locale text for the xform as per the localeKey field. */
	private String xformText;
	
	/** The locale text for the layout xml as per the localeKey field. */
	private String layoutText;
	
	
	/**
	 * Constructs a new form definition version text object.
	 */
	public FormDefVersionText(){
		
	}
	
	public FormDefVersionText(String locale, int formDefVersionId, String xformText, String layoutText){
		this.localeKey = locale;
		this.formDefVersionId = formDefVersionId;
		this.xformText = xformText;
		this.layoutText = layoutText;
	}
	
	public int getFormDefVersionTextId() {
		return formDefVersionTextId;
	}

	@Override
	public int getId() {
		return formDefVersionTextId;
	}
	
	public void setFormDefVersionTextId(int formDefVersionTextId) {
		this.formDefVersionTextId = formDefVersionTextId;
	}
	
	public int getFormDefVersionId() {
		return formDefVersionId;
	}
	
	public void setFormDefVersionId(int formDefVersionId) {
		this.formDefVersionId = formDefVersionId;
	}
	
	public String getLocaleKey() {
		return localeKey;
	}
	
	public void setLocaleKey(String localeKey) {
		this.localeKey = localeKey;
	}
	
	public String getXformText() {
		return xformText;
	}
	
	public void setXformText(String xformText) {
		this.xformText = xformText;
	}
	
	public String getLayoutText() {
		return layoutText;
	}
	
	public void setLayoutText(String layoutText) {
		this.layoutText = layoutText;
	}
	
	@Override
	public boolean isNew(){
		return formDefVersionTextId == 0;
	}
}
