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
 * This class contains text for a given mobile menu item in a particular locale.
 * With the help of this class, we can translate mobile menu text at runtime
 * as they come from the database instead of having to be compiled in the application.
 * 
 * @author daniel
 *
 */
public class MobileMenuText extends AbstractEditable{
	
	/**
	 * Serialisation ID
	 */
	private static final long serialVersionUID = -1374321447951545934L;

	/** The database identifier for the menu text. */
	private int menuTextId = 0;
	
	/** The locale key for the menu text. */
	private String localeKey;
	
	/** The unique identifier for the menu item. eg Exit=1, Close=2, Cancel=3, and more. */
	private short menuId;
	
	/** The text for the menu item in the locale as given by the localeKey field. */
	private String menuText;
	
	/**
	 * Constructs a new mobile menu text object.
	 */
	public MobileMenuText(){
		
	}
	
	public int getMenuTextId() {
		return menuTextId;
	}
	
	@Override
	public int getId() {
		return menuTextId;
	}
	
	public void setMenuTextId(int menuTextId) {
		this.menuTextId = menuTextId;
	}
	
	public String getLocaleKey() {
		return localeKey;
	}
	
	public void setLocaleKey(String localeKey) {
		this.localeKey = localeKey;
	}
	
	public short getMenuId() {
		return menuId;
	}
	
	public void setMenuId(short menuId) {
		this.menuId = menuId;
	}
	
	public String getMenuText() {
		return menuText;
	}
	
	public void setMenuText(String menuText) {
		this.menuText = menuText;
	}
}
