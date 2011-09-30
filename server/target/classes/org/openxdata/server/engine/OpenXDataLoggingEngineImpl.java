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
package org.openxdata.server.engine;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openxdata.server.admin.model.util.DiagnosedStatus;
import org.openxdata.server.admin.model.util.Diagnosis;
import org.openxdata.server.admin.model.util.ErrorRiskLevel;
import org.openxdata.server.engine.util.LoggingEngineUtil;
import org.openxdata.server.util.FileUtil;
import org.openxdata.server.util.Log4jHtmlParser;
import org.springframework.stereotype.Repository;

/**
 * Implements the {@link OpenXDataLoggingEngine} contract and also determines the <tt>Engine</tt> to use for processing.
 * 
 * @author Angel
 *
 */
@Repository("loggingEngine")
public class OpenXDataLoggingEngineImpl implements OpenXDataLoggingEngine {
	
	/** Logging Handle for this Class.*/
	private static Logger log = Logger.getLogger(FileUtil.class);
	
	/**
	 * Constructs an instance of this class.
	 * <p><b>
	 * SHOULD ONLY BE USED FOR TESTING. USE THE SPRING FRAMEWORK TO INJECT INTO OTHER CLASSES.
	 * </b></p>
	 */
	public OpenXDataLoggingEngineImpl(){}
	
	
 	@Override
	public Diagnosis processLogFile(String filePath) {
		
		//Check the log file and use appropriate Engine.
		if(filePath.endsWith("log"))
			return processPlainTextLogFile(filePath);
		else if(filePath.endsWith("htm"))
			return processHTMLLogFile(filePath);
		
		return null;
	}
	
    /**
     * Retrieves the contents of a given <tt>Log File.</tt>
     * Mainly added to aid in Testing.
     *
     * @param LogFile <tt>Log File</tt> to get contents for.
     * @return <tt>File</tt> contents.
     */
    public String getLogFileContent(String LogFile) {
        return FileUtil.readFile(LogFile);
    }
	
	/**
	 * Process the text log file.
	 * 
	 * @param filePath relative path to the <tt>Log File.</tt>
	 * @return <tt>Diagnosis</tt> from the <tt>Log File.</tt>
	 */
	private Diagnosis processPlainTextLogFile(String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Process the HTML formatted log file.
	 * 
	 * @return HTML Formatted output.
	 */
	private Diagnosis processHTMLLogFile(String logFilePath) {
		
		try{
			// Read Log File
			String logFileOutput = FileUtil.readFile(logFilePath);
			
			// Process Contents.
			return buildDiagnosisFromHTMLFileOutput(logFileOutput);
			
			
		}catch(Exception ex){
			log.error("Log Processing Engine: " + this.getClass() + ex.getLocalizedMessage(), ex);
		}
		
		return null;
	}

	/**
	 * Builds a {@link Diagnosis} from given <tt>Log File</tt> output.
	 * 
	 * @param logFileOutput <tt>Log File</tt> output to diagnose.
	 * @return Instance of {@link Diagnosis}.
	 */
	private Diagnosis buildDiagnosisFromHTMLFileOutput(String logFileOutput) {
		
		Diagnosis diagnosis = new Diagnosis();
		String logFileStream = logFileOutput.toString();
		
		if(logFileStream != null){
			
			// Retrieve Latest Error.
			String latestError = LoggingEngineUtil.getLatestError(logFileOutput);
			
			// Determine Risk Level.
			ErrorRiskLevel riskLevel = LoggingEngineUtil.determineErrorRiskLevel(logFileOutput);
			
			// Determine Diagnosed status.
			DiagnosedStatus status = LoggingEngineUtil.determineDiagnosedStatus(logFileOutput);
			
			int errorCount = Log4jHtmlParser.getErrorCount(logFileOutput);

			// Set Diagnosis properties.
			diagnosis.setRiskLevel(riskLevel);
			diagnosis.setDiagnosedStatus(status);
			diagnosis.setLatestError(latestError);
			diagnosis.setLogFileStream(logFileOutput);		
			diagnosis.setErrorCount(errorCount);
		}
		
		return diagnosis;
	}

	
	@Override
	public void clearLogFiles() {
		try {
			LoggingEngineUtil.clearLogFiles();
		} catch (IOException ex) {
			log.error(ex.getLocalizedMessage(), ex);
		}		
	}
}
