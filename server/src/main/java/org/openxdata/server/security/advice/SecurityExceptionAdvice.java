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
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.admin.model.exception.OpenXDataSecurityException;
import org.openxdata.server.admin.model.exception.OpenXDataSessionExpiredException;
import org.openxdata.server.security.OpenXDataUserDetails;
import org.openxdata.server.service.UserService;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.AccessDeniedException;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

/**
 * Advice for capturing any <code>Exceptions</code> 
 * that can potentially occur on the <code>Service layer.</code>
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
 * @author dagmar@cell-life.org.za
 */
@Aspect
public class SecurityExceptionAdvice implements ThrowsAdvice {
    
	@Autowired
	private UserService userService;
	
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
     * @param exception <code>exception</code> thrown on the service layer. 
     * @throws OpenXDataException the re-thrown [known] <code>exception</code> by this advice.
     */
	public void afterThrowing(Exception exception) throws OpenXDataException {	
		if (exception instanceof AccessDeniedException ) {
	        if (isUserLoggedIn()) {

	        	//We handle a security exception after
	        	//confirming the User is still logged in
	        	//But lacks permission to accomplish operation.
	        	logAndFireSecurityException(exception);
	            
	        } else {
	        	
	        	//We handle a session expiry after affirming
	        	//that the User is no longer in the Security Context.
	        	logAndFireSessionExpiredException(exception);
	        }
	    }
	}

	/**
	 * Handles the {@link OpenXDataSecurityException}.
	 * 
	 * @param exception <tt>Exception</tt> thrown.
	 * @throws OpenXDataSecurityException With meaningful <tt>Message</tt> to the <tt>User.</tt>
	 */
	private void logAndFireSecurityException(Exception exception) throws OpenXDataSecurityException {
		
		//TODO This message should be internationalized. 
		String exMsg = "Access to restricted operation is denied";
		
		// log the error on the server so it is not lost
		log.debug("Caught server side Access Denied exception, throwing new exception to the client '"+ 
				exception.getMessage() +"'", exception);
		
		//Re throw know exception to the User.
		throw new OpenXDataSecurityException(exMsg);
	}

	/**
	 * Handles the {@link OpenXDataSessionExpiredException}.
	 * 
	 * @param exception <tt>Exception</tt> thrown.
	 * @throws OpenXDataSessionExpiredException With meaningful <tt>Message</tt> to the <tt>User.</tt>
	 */
	private void logAndFireSessionExpiredException(Exception exception) throws OpenXDataSessionExpiredException {
		
		
		//TODO This message should be internationalized.	        	
		String exMsg = "Your session has expired. Re-Login to proceed.";
		
		// log the error on the server so it is not lost
		log.debug("Caught server side Session Expired exception, throwing new exception to the client '"+ 
				exception.getMessage()+"'", exception);
		
		// Logout User.
		userService.logout();
		
		//Re throw know exception to the User.
		throw new OpenXDataSessionExpiredException(exMsg);
	}
	
	/**
	 * Checks if the <code>User</code> is still 
	 * registered in the <code>Spring security context.</code>
	 * 
	 * @return 
	 * 		<code>true</code> 
	 * <code>if(auth instanceof OpenXDataUserDetails)</code>
	 * <p>
	 * else
	 * 	<code>false</code>
	 * </p>
	 */
	private boolean isUserLoggedIn() {
		
		// see if the authentication object is intact.
        SecurityContext context = SecurityContextHolder.getContext();
        if (context != null) {
        	
        	// Get the User's authentication if it is still intact.
            Authentication auth = context.getAuthentication();            
            if (auth != null) {
            	
            	// Check if the security context is still intact.
                if (auth instanceof OpenXDataUserDetails) {
                    return true;
                }
            }
        }
     
        // Return false if Security Context has been invalidated.
        return false;
	}
}
