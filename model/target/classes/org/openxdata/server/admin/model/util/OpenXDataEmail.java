/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

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
package org.openxdata.server.admin.model.util;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

/**
 * Models an Email that can be sent over the wire.
 * <p>
 * The motivation for creating this <tt>object</tt> was to be able to construct
 * an email object from the client and pass it over to the server for eventual transfer.
 * </p>
 * @author Angel
 *
 */
public class OpenXDataEmail implements Serializable {
	
	private List<String> recipients = new Vector<String>();
	
	private List<String> carbonCopyRecipients = new Vector<String>();
	
	private String subject = "";
	
	private boolean attachErrorLog = false;
	
	private boolean attachLatestError = false;

	/** Generated serialization ID*/
	private static final long serialVersionUID = 4818600319018492727L;
	
	public OpenXDataEmail(){}

	/**
	 * Sets the recipients of this <tt>OpenXDataEmail.</tt>
	 * 
	 * @param recipients the recipients to set
	 */
	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}

	/**
	 * Returns the recipients of this <tt>OpenXDataEmail.</tt>
	 * 
	 * @return the recipients
	 */
	public List<String> getRecipients() {
		return recipients;
	}

	/**
	 * Sets the carbon copy recipients of this <tt>OpenXDataEmail.</tt>
	 * 
	 * @param carbonCopyRecipients the carbonCopyRecipients to set
	 */
	public void setCarbonCopyRecipients(List<String> carbonCopyRecipients) {
		this.carbonCopyRecipients = carbonCopyRecipients;
	}

	/**
	 * Returns the carbon copy recipients of this <tt>OpenXDataEmail.</tt>
	 * 
	 * @return the carbonCopyRecipients
	 */
	public List<String> getCarbonCopyRecipients() {
		return carbonCopyRecipients;
	}

	/**
	 * Sets the subject of this <tt>OpenXDataEmail.</tt>
	 * 
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Returns the subject of this <tt>OpenXDataEmail.</tt>
	 * 
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the Flag to indicate that the <tt>Error Log</tt> should be attached.
	 * 
	 * @param attachErrorLog the attachErrorLog to set
	 */
	public void setAttachErrorLog(boolean attachErrorLog) {
		this.attachErrorLog = attachErrorLog;
	}

	/**
	 * Returns the flag indicating if <tt>Error Log</tt> should be attached.
	 * 
	 * @return the attachErrorLog
	 */
	public boolean isAttachErrorLog() {
		return attachErrorLog;
	}

	/**
	 * Sets the Flag to indicate that the <tt>Latest Error</tt> should be attached.
	 * @param attachLatestError the attachLatestError to set
	 */
	public void setAttachLatestError(boolean attachLatestError) {
		this.attachLatestError = attachLatestError;
	}

	/**
	 * Returns the flag indicating if <tt>Latest Error</tt> should be attached.
	 * 
	 * @return the attachLatestError
	 */
	public boolean isAttachLatestError() {
		return attachLatestError;
	}
	
	

}
