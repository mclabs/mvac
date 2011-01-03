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
package org.openxdata.server.report.birt;

import java.io.File;
import java.util.logging.Level;

/**
 * Constants used by the BIRT report engine.
 * 
 * @author daniel
 *
 */
class BirtConstants {

	/** The report out put format. */
	public static final String PARAM_OUTPUT_FORMAT = "outputFormat";
	
	/** HTML format. */
	public static final String HTML_FORMAT = "html";
	
	/** PDF format. */
	public static final String PDF_FORMAT = "pdf";
	
	/** Rich text document format. */
	public static final String DOC_FORMAT = "doc";
	
	/** Excel format. */
	public static final String XLS_FORMAT = "xls";
	
	
	//This is now under database settings.
	//public static String DEFAULT_BIRT_HOME 				= 	"F:/Software/birt-runtime-2_5_0_2/birt-runtime-2_5_0/ReportEngine";
	
	/** The default root directory for all other directories. */
	public static final String DEFAULT_BASE_DIR 				= 	System.getProperty("user.home");
	
	/** The default directory where BIRT should look for report design files. */
	public static final String DEFAULT_REPORT_DIR				= 	DEFAULT_BASE_DIR + File.separator + "reports";
	
	/** The default directory where BIRT logs errors. */
	public static final String DEFAULT_LOGGING_DIR 				= 	DEFAULT_REPORT_DIR + File.separator + "logs";
	
	/** The default directory where BIRT should output run results. */
	public static final String DEFAULT_OUTPUT_DIR 				= 	DEFAULT_REPORT_DIR + File.separator + "output";
	
	/** The directory where BIRT should output run results. */
	public static String OUTPUT_DIR = DEFAULT_OUTPUT_DIR;
	
	/** The directory where BIRT should look for report design files. */
	public static String REPORT_DIR = DEFAULT_REPORT_DIR;
	
	/** The directory where BIRT should log errors. */
	public static final String LOGGING_DIR = DEFAULT_LOGGING_DIR;
	
	/** The logger level. */
	public static final Level LOGGING_LEVEL = Level.ALL;
}
