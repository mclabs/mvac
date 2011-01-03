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

import org.openxdata.server.admin.model.exception.OpenXDataException;

/**
 * Encapsulates the Diagnosed status of the system according to the errors in the <tt>Log File.</tt>
 * <p>
 * Each <tt>Enum constant</tt> has to be given a programmer specific value that we can duly call and
 * re use later when we doing calculations.
 * <p>
 * <b>Example Usage:</b>
 * 
 * <pre class="code">
 *  Foo(0),// where 0 is the underlying value of the constant.
 *  
 * </pre>
 * 
 * All attributes of this class and its descendants MUST implement
 * {@link Serializable}<p>
 * 
 * @author Angel
 *
 */
public enum DiagnosedStatus implements Serializable {
	
	// Indicates that the impact of the system is in a stable state.
	STABLE(0),
	
	// Indicates that the impact of the system is in a unstable state.
	UNSTABLE(1),
	
	// Indicates that the impact of the system is in a fatal state.
	FATAL(2), 
	
	UNDEFINED(3);

	private byte value;

	/**
	 * Constructs an instance of this <tt>type</tt> with a strongly typed underlying value.
	 * @param value
	 */
	DiagnosedStatus(int value) {
		this.value = (byte) value;
	}

	/**
	 * Returns the underlying value of a given status.
	 * @return underlying value.
	 */
	public byte getValue() {
		return value;
	}

	@Override
	public String toString() {
		return ErrorRiskLevel.class.getName() + " " + value;
	}
	
	/**
	 * Retrieves the Status given the underlying type.
	 * 
	 * @param type type to retrieve status for.
	 * @return Status if exists.
	 * @throws OpenXDataException if type cannot be discerned or UNKNOWN.
	 */
	public static DiagnosedStatus valueOf(byte type) throws OpenXDataException {
		for (DiagnosedStatus mode : DiagnosedStatus.values()) {
			if (type == mode.value)
				return mode;
		}
		//Probably erratic System Status -- But how can it happen?
		throw new OpenXDataException("Unknown Map Mode: " + type);
	}
	
	/**
	 * Returns a String representing the underlying caption <tt>ENUM Constant Name.</tt>
	 * 
	 * @param type <tt>Type</tt> to retrieve string for.
	 * @return Pseudo String name if exists.
	 */
	public String valueOf(DiagnosedStatus type){
		if(type == STABLE)
			return "STABLE";
		else if(type == UNSTABLE)
			return "UNSTABLE";
		else if(type == FATAL)
			return "FATAL";
		else if(type == UNDEFINED)
			return "UNDEFINED";
		return null;
		
	}
}
