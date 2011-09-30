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
package org.openxdata.server.admin.client.controller;

import java.util.List;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.callback.OpenXDataAsyncCallback;
import org.openxdata.server.admin.client.controller.observe.OpenXDataObservable;
import org.openxdata.server.admin.client.listeners.SaveCompleteListener;
import org.openxdata.server.admin.client.locale.OpenXdataText;
import org.openxdata.server.admin.client.locale.TextConstants;
import org.openxdata.server.admin.client.util.AsyncCallBackUtil;
import org.openxdata.server.admin.client.util.MainViewControllerUtil;
import org.openxdata.server.admin.model.Editable;
import org.openxdata.server.admin.model.Locale;
import org.openxdata.server.admin.model.MobileMenuText;
import org.purc.purcforms.client.util.FormUtil;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;

/**
 * This controller deals with loading and saving of utility related data
 * to and from the database for the various utility related views.
 * 
 * Some of the utilities include locales, mobile menu text
 * 
 * @author Angel
 *
 */
public class UtilityViewController extends OpenXDataObservable implements SaveCompleteListener {

	private List<Locale> locales;
	private List<MobileMenuText> mobileMenuText;
	
	/**
	 * Constructs an instance of this <tt>class.</tt>
	 */
	public UtilityViewController() { }

	/**
	 * Loads locales from the database.
	 * 
	 * @param reload set to false if you want to use the cached locales, if any, without
	 *        having to reload them from the database.
	 */
	public void loadLocales(boolean reload){
		if(locales != null && !reload)
			return;
		
		FormUtil.dlg.setText(OpenXdataText.get(TextConstants.LOADING_LOCALES));
		FormUtil.dlg.center();

		DeferredCommand.addCommand(new Command(){
			@Override
			public void execute() {
				try{
					Context.getUtilityService().getLocales(new OpenXDataAsyncCallback<List<Locale>>() {
						@Override
						public void onOtherFailure(Throwable caught) {
							FormUtil.dlg.hide();
							AsyncCallBackUtil.handleGenericOpenXDataException(caught);
						}

						@Override
						public void onSuccess(List<Locale> argLocales) {
							locales = argLocales;
							
							setChanged();
						    notifyObservers(locales, Locale.class);
						    
							FormUtil.dlg.hide();
						}
					});
				}
				catch(Exception ex){
					FormUtil.dlg.hide();
					FormUtil.displayException(ex);
				}	
			}
		});
	}

	/**
	 * Loads mobile menu text from the database.
	 * 
	 * @param reload set to false if you want to use the cached mobile menu text, if any, without
	 *        having to reload them from the database.
	 */
	public void loadMobileMenuText(boolean reload){
		if(mobileMenuText != null && !reload)
			return;

		FormUtil.dlg.setText(OpenXdataText.get(TextConstants.LOADING_MOBILE_MENU_TEXT));
		FormUtil.dlg.center();

		DeferredCommand.addCommand(new Command(){
			
			//Just a hack 
			private String locale;

			@Override
			public void execute() {
				try{
					Context.getUtilityService().getMobileMenuText(locale, new OpenXDataAsyncCallback<List<MobileMenuText>>() {

						@Override
						public void onOtherFailure(Throwable caught) {
							FormUtil.dlg.hide();
							AsyncCallBackUtil.handleGenericOpenXDataException(caught);

						}

						@Override
						public void onSuccess(List<MobileMenuText> mobileMenuTextDefs) {
							mobileMenuText = mobileMenuTextDefs;
							
							setChanged();
						    notifyObservers(locales, MobileMenuText.class);
						    
							FormUtil.dlg.hide();

						}

					});
				}
				catch(Exception ex){
					FormUtil.dlg.hide();
					FormUtil.displayException(ex);
				}	
			}
		});
	}
	
	@Override
	public void onSaveComplete(List<? extends Editable> modifiedList, List<? extends Editable> deletedList) {
		MainViewControllerUtil.onSaveComplete(modifiedList, deletedList);
		loadLocales(true);
	}
}
