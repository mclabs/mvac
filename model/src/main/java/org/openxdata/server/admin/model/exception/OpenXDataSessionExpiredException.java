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
package org.openxdata.server.admin.model.exception;

/**
 * Exception that is thrown when the user's session has expired.
 * Indicates that the user should be redirected to a login page
 * @author dagmar@cell-life.org.za
 */
public class OpenXDataSessionExpiredException extends OpenXDataSecurityException  {
    
	/**
	 * Generated <code>serialization</code> ID.
	 */
    private static final long serialVersionUID = -4151708298744270279L;

    /**
     * Default non arg constructor.
     */
    public OpenXDataSessionExpiredException() {}
    
    /**
     * Constructor that takes an argument which is
	 * a <code>String </code> message for the instance of any 
	 * unregistered security exception that might be thrown on the server.
	 * 
	 * @param message the message of the unregistered exception thrown on the server.
     */
    public OpenXDataSessionExpiredException(String message) {
        super(message);
    }

	/**
	 * Constructor that takes an argument 
	 * which is an instance any unregistered 
	 * security exception that might be thrown on the server.
	 * 
	 * @param throwable the unregistered <code>exception</code> thrown on the server.
	 */
    public OpenXDataSessionExpiredException(Throwable throwable) {
        super(throwable);
    }
}
