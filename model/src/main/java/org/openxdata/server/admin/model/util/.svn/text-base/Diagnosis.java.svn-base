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
package org.openxdata.server.admin.model.util;

import java.io.Serializable;

/**
 * Models the system diagnosis according to the <tt>Log File.</tt>
 * 
 * <p>
 * All attributes of this class and its descendants MUST implement
 * {@link Serializable}
 * <p>
 * 
 * @author Angel
 *
 */
public class Diagnosis implements Serializable {

	/** Generated serialization ID*/
	private static final long serialVersionUID = -2737752773535423259L;
	
	/** Latest Error*/
	private String latestError;
	
	/** Contents of the <tt>Log File.</tt>*/
	private String logFileStream;

	/** Calculated Risk Level.*/
	private ErrorRiskLevel riskLevel;
	
	/** Diagnosed Status.*/
	private DiagnosedStatus diagnosedStatus;

	/** Number of <tt>Errors</tt> in the <tt>Log File.</tt>*/
	private int errorCount;
	
	/** Constructs an instance of this class.*/
	public Diagnosis(){}

	/**
	 * Sets the Risk Level.
	 * 
	 * @param riskLevel the riskLevel to set
	 */
	public void setRiskLevel(ErrorRiskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}

	/**
	 * Returns the calculated Risk Level.
	 * @return the riskLevel
	 */
	public ErrorRiskLevel getRiskLevel() {
		return riskLevel;
	}

	/**
	 * Sets the diagnosed system status.
	 * 
	 * @param diagnosedStatus the diagnosedStatus to set
	 */
	public void setDiagnosedStatus(DiagnosedStatus diagnosedStatus) {
		this.diagnosedStatus = diagnosedStatus;
	}

	/**
	 * Retrieves the Diagnosed system status.
	 * 
	 * @return the diagnosedStatus
	 */
	public DiagnosedStatus getDiagnosedStatus() {
		return diagnosedStatus;
	}

	/**
	 * Sets the contents of a specific <tt>Log File.</tt>
	 * @param logFileStream the logFileStream to set
	 */
	public void setLogFileStream(String logFileStream) {
		this.logFileStream = logFileStream;
	}

	/**
	 * Retrieves the contents of the <tt>Log File.</tt>
	 * @return the logFileStream
	 */
	public String getLogFileStream() {
		return logFileStream;
	}

	/**
	 * Sets the Latest Error as logged in the <tt>Log File.</tt>
	 * @param latestError the latestError to set
	 */
	public void setLatestError(String latestError) {
		this.latestError = latestError;
	}

	/**
	 * Retrieves the Latest Error as set in the <tt>Log File.</tt>
	 * @return the latestError
	 */
	public String getLatestError() {
		return latestError;
	}

	
	/**
	 * @param errorCount
	 */
	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;		
	}
	
	/**
	 * Retrieves the number of <tt>Errors</tt> in the <tt>Log File.</tt>
	 */
	public int getErrorCount(){
		return this.errorCount;
	}
	
}
