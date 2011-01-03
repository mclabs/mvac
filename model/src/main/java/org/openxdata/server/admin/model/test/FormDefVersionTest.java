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
package org.openxdata.server.admin.model.test;

import java.util.List;
import java.util.Vector;

import org.openxdata.server.admin.model.FormDefVersion;

public class FormDefVersionTest {

	public static FormDefVersion getTestFormDefVersionTest1(){
		return new FormDefVersion(1,"v1.0","The first version of the form",null);
	}
	
	public static FormDefVersion getTestFormDefVersionTest2(){
		return new FormDefVersion(1,"v2.0","The second version of the form",null);
	}
	
	public static FormDefVersion getTestFormDefVersionTest3(){
		return new FormDefVersion(1,"v3.0","The third version of the form",null);
	}
	
	public static List<FormDefVersion> getTestFormDefVersionsTest(){
		List<FormDefVersion> versions  = new Vector<FormDefVersion>();
		versions.add(getTestFormDefVersionTest1());
		versions.add(getTestFormDefVersionTest2());
		versions.add(getTestFormDefVersionTest3());
		
		return versions;
	}
}
