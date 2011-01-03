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
package org.openxdata.server.engine.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openxdata.server.admin.model.util.DiagnosedStatus;
import org.openxdata.server.admin.model.util.ErrorRiskLevel;
import org.openxdata.server.util.FileUtil;
import org.openxdata.server.util.Log4jHtmlParser;
import org.openxdata.server.util.OpenXDataUtil;

/**
 * Utilities used by the <tt>Logging Engine.</tt>
 * 
 * @author Angel
 *
 */
public class LoggingEngineUtil {

    /** Logging Handle for this Class.*/
    private static Logger log = Logger.getLogger(FileUtil.class);
    
	/**
	 * Retrieves the latest <tt>Error</tt> in the <tt>Log File.</tt>
	 * @param logFileContent <tt>Log File</tt> to process.
	 * 
	 * @return latest <tt>Error.</tt?
	 */
	public static String getLatestError(String logFileContent){
		return Log4jHtmlParser.processtLatestError(logFileContent);
	}
	
	/**
	 * Diagnoses the system to determine the impact of 
	 * latest <tt>Errors</tt> on the stability of the system.
	 * 
	 * @param logFileContent <tt>Log File</tt> output to diagnose.
	 * @return Instance of {@link DiagnosedStatus}
	 */
	public static DiagnosedStatus determineDiagnosedStatus(String logFileContent) {
		
		//Diagnosis to return.
		DiagnosedStatus diagnosedStatus = null;
		
		// Ascertain number of Errors/Warnings in the Log.
		int errorCount = Log4jHtmlParser.getErrorCount(logFileContent);
		
		if(errorCount > 0){
			
			int diagnosis = analyzeLogOutput(logFileContent);
			
			// Analyze Logs and give approximate stability.
			if(diagnosis > 0 & diagnosis < 30)
				diagnosedStatus = DiagnosedStatus.UNSTABLE;
			else if(diagnosis > 30)
				diagnosedStatus = DiagnosedStatus.FATAL;
		}
		else if(errorCount <= 0){
			
			// System is apparently stable.
			diagnosedStatus = DiagnosedStatus.STABLE;
		}
		else{
			diagnosedStatus = DiagnosedStatus.UNDEFINED;
		}
		
		return diagnosedStatus;
	}

	/**
	 * Diagnoses the system to determine the severity of 
	 * latest <tt>Errors</tt> on the stability of the system.
	 * 
	 * @param logFileContent <tt>Log File</tt> output to diagnose.
	 * @return Instance of {@link ErrorRiskLevel}
	 */
	public static ErrorRiskLevel determineErrorRiskLevel(String logFileContent) {
		
		ErrorRiskLevel calculatedRiskLevel = null;
		
		int errorCount = Log4jHtmlParser.getErrorCount(logFileContent);
		
		if(errorCount > 0){
			
			int riskLevel = analyzeLogOutput(logFileContent);
			
			// Analyze Logs and give approximate Risk Level.
			if(riskLevel > 0 & riskLevel < 30)
				calculatedRiskLevel = ErrorRiskLevel.MEDIUM;
			else if(riskLevel > 30)
				calculatedRiskLevel = ErrorRiskLevel.CRITICAL;
		}		
		else if(errorCount <= 0){
			
			// System is apparently stable.
			calculatedRiskLevel = ErrorRiskLevel.LOW;
		}
		else{
			calculatedRiskLevel = ErrorRiskLevel.UNDEFINED;
		}
		
		return calculatedRiskLevel;
	}

	/**
	 * Calculates system stability according to Error numbers.
	 * 
	 * @param logFileContent <tt>Log File</tt> to extract errors.
	 * @return calculated Stability number.
	 */
	protected static int analyzeLogOutput(String logFileContent){
		
		int calculatedStability = -1;
		
		int uniqueErrorCount = getUniqueErrorCount(logFileContent);
		int unqiueErrorOccurenceCount = getUniqueErrorOccurenceCount(logFileContent);
		
		if(unqiueErrorOccurenceCount > 0)
			calculatedStability = uniqueErrorCount / unqiueErrorOccurenceCount;
		
		return calculatedStability;
	}
	
	/**
	 * Get the unique occurrence of each <tt>Error</tt> in the <tt>Log File.</tt>
	 * <p>
	 * Note that an<tt>Error</tt> can be repeatedly encountered hence repeatedly logged.
	 * If this is not handled properly, it can give a wrong impression about the Stability
	 * of the system to the <tt>User</tt>. Always ensure that double errors are omitted during analysis.
	 * </p>
	 * @param logFileContent <tt>Log File</tt> to process.
	 * @return Unique <tt>Error</tt> count for all the Errors in the <tt>Log File.</tt>
	 */
	private static int getUniqueErrorOccurenceCount(String logFileContent) {
		return Log4jHtmlParser.getUniqueLogsWithERRORSeverity() + Log4jHtmlParser.getUniqueLogsWithWARNSeverity();
	}

	/**
	 * Get the count of each <tt>Error</tt> that has been logged.
	 * <p>
	 * Note that an<tt>Error</tt> can be repeatedly encountered hence repeatedly logged.
	 * If this is not handled properly, it can give a wrong impression about the Stability
	 * of the system to the <tt>User</tt>. Always ensure that double errors are omitted during analysis.
	 * </p>
	 * @param logFileContent <tt>Log File</tt> to process.
	 * @return Unique <tt>Error</tt> count for all the Errors in the <tt>Log File.</tt>
	 */
	private static int getUniqueErrorCount(String logFileContent) {
		return Log4jHtmlParser.getUniqueErrorCount(logFileContent);
	}

	/**
	 * Clears Log Files and removes all logged activity in the <tt>Log File.</tt>
	 * 
	 * @throws IOException For any I/O interruption that might occur.
	 */
	public static void clearLogFiles() throws IOException {
		
		BufferedWriter out = null;

		try {
			
			out = new BufferedWriter(new FileWriter(OpenXDataUtil.getHTMLLogFilePath()));
			
			// Just make it empty.
			out.write("");
			
			// We flush just to cater for the event that the Log File is too big.
			out.flush();
			
		} catch (IOException ex) {
			log.error(ex.getLocalizedMessage(), ex);
			out.close();
		} finally {
			out.close();
		}
	}
}
