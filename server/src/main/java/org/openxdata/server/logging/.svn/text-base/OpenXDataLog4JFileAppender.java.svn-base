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
package org.openxdata.server.logging;

import java.io.File;

import org.apache.log4j.DailyRollingFileAppender;

/**
 * Extends the <code>Log4j DailyRollingFileAppender</code> to enable custom actions like creating directory.
 * 
 * @author Angel
 * 
 */
public class OpenXDataLog4JFileAppender extends DailyRollingFileAppender {

	/**
	 * Constructs an instance of this type.
	 */
	public OpenXDataLog4JFileAppender() {
		super();
	}

	/**
	 * Sets the <tt>File</tt> where the logs will be captured.
	 * 
	 * @param openXDataLogFilePath Path to the <tt>File.</tt>
	 */
	@Override
	public void setFile(String openXDataLogFilePath) {
		if (isLogDirectoryAvailable(openXDataLogFilePath)) {
			super.setFile(openXDataLogFilePath);
		}
	}

	/**
	 * Ensures that the logging directory is in place.
	 * 
	 * @param openXDataLogFilePath - file path to check for.
	 * @return <code>True only and only if directory exists or has been successfully created</code>.
	 */
	private boolean isLogDirectoryAvailable(String openXDataLogFilePath) {
		final File dir = new File("openXdata Logs");
		if (!dir.exists() && !dir.mkdirs()) {
			throw new RuntimeException("Could not create directory <" + dir	+ ">");
		}
		return true;
	}

}
