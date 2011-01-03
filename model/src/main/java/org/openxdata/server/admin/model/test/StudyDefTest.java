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

import org.openxdata.server.admin.model.*;

public class StudyDefTest {

	public static StudyDef getTestStudyDef1(){
		StudyDef study = new StudyDef(1,"Baseline Study");
		
		study.addForm(FormDefTest.getTestFormDef1());
		study.addForm(FormDefTest.getTestFormDef2());
		study.addForm(FormDefTest.getTestFormDef3());
		study.addForm(FormDefTest.getTestFormDef4());
		study.addForm(FormDefTest.getTestFormDef5());
		
		return study;
	}
	
	public static StudyDef getTestStudyDef2(){
		StudyDef study = new StudyDef(2,"Update Round Study");
		
		study.addForm(FormDefTest.getTestFormDef1());
		study.addForm(FormDefTest.getTestFormDef2());
		study.addForm(FormDefTest.getTestFormDef3());
		study.addForm(FormDefTest.getTestFormDef4());
		study.addForm(FormDefTest.getTestFormDef5());
		
		return study;
	}
	
	public static StudyDef getTestStudyDef3(){
		StudyDef study = new StudyDef(2,"Update Round Study");
		
		study.addForm(FormDefTest.getTestFormDef1());
		study.addForm(FormDefTest.getTestFormDef2());
		study.addForm(FormDefTest.getTestFormDef3());
		study.addForm(FormDefTest.getTestFormDef4());
		study.addForm(FormDefTest.getTestFormDef5());
		
		return study;
	}
	
	public static List<StudyDef> getTestStudies(){
		Vector<StudyDef> studies = new Vector<StudyDef>();
	    studies.add(StudyDefTest.getTestStudyDef1());
	    studies.add(StudyDefTest.getTestStudyDef2());
	    studies.add(StudyDefTest.getTestStudyDef3());
	    return studies;
	}
}
