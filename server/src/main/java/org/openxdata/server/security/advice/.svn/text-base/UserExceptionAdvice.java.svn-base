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
package org.openxdata.server.security.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.springframework.aop.ThrowsAdvice;

/**
 * Advice for capturing any 
 * <code>User related Exceptions</code> that can potentially occur on the 
 * <code>Service layer.</code> like disabled <code>Users</code> trying to log in.
 * <p>
 * <code>Exceptions</code> must be
 * <code>instance of org.openxdata.server.admin
 * .model.exception.OpenXDataException.</code>
 * </p>
 * 
 * <p>
 * Using <code>AOP</code>, we re-throw the 
 * meaningful <code>exception</code> to the client 
 * to avoid <code>"Call failed on Server" Exception</code>.
 * </p>
 * <p>Refer to the <code>applicationContext-security.xml</code>.</p>  
 * 
 * @author Angel
 *
 */
@Aspect
public class UserExceptionAdvice implements ThrowsAdvice {
	
	 /** The logger. */
    private Logger log = Logger.getLogger(this.getClass());
	
    /**
     * Re throws a known <code>exception</code>
     * to the client. 
     * <p>
     * This is achieved using 
     * <code>AOP</code> in the <code>applicationContext-security.xml</code>.
     * </p>
     * 
     * @param exception <code>User exception</code> thrown on the service layer. 
     * @throws OpenXDataException the re-thrown [known] <code>exception</code> by this advice.
     */
	public void afterThrowing(Exception exception) throws OpenXDataException{
		if(exception instanceof OpenXDataDisabledUserException){
        	//TODO This message should be internationalized. 
        	String exMsg = "Your account has been disabled! Contact the System Administrator.";
        	
    		// log the error on the server so it is not lost
    		log.error("Caught server side Disabled User Exception, throwing new exception to the client '"+ 
    				exception.getMessage() +"'", exception);
    		
    		throw new OpenXDataDisabledUserException(exMsg);
		}
	}
}
