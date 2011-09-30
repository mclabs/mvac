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
package org.openxdata.server.serializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openxdata.server.admin.model.exception.UnexpectedException;
import org.openxdata.server.util.XformUtil;

import static org.apache.commons.lang.StringEscapeUtils.escapeXml;

/**
 * Provides the default xform serialization and deserialization from and to the sever.
 * An example of such clients could be mobile devices collecting data in for instance 
 * offline mode, and then send it to the server when connected.
 * 
 * For those who want a different serialization format for xforms,
 * just implement the SerializableData interface and specify the class
 * using the settings {xforms.xformSerializer}. 
 * The jar containing this class can then be
 * put under the webapps/openxdata/web-inf/lib folder.
 * One of the reasons one could want a different serialization format
 * is for performance by doing a more optimized and compact format. Such an example
 * exists in the EpiHandy compact implementation of xforms.
 * 
 * @author Mark
 *
 */
public class JavaRosaXformSerializer implements XformSerializer{

	public JavaRosaXformSerializer(){
	}

	/**
	 * 
	 * @param dos
	 * @param data
	 */
	@Override
	public void serializeForms(OutputStream os,List<String> xforms, Integer studyId, String studyName, String studyKey) {
		//This is always a list of strings.
		DataOutputStream dos = new DataOutputStream(os);
		
		for(String xml : xforms){
			try {
				String xhtml = XformUtil.fromXform2Xhtml(xml);
				dos.writeUTF(xhtml.trim());
			} catch (Exception e) {
				throw new UnexpectedException(e);
			} 
		}
	}

	@SuppressWarnings("unchecked")
	public void serializeStudies(OutputStream os,Object data){
		List<Object[]> studies = (List<Object[]>)data;
		DataOutputStream dos = new DataOutputStream(os);

		String xml = "<?xml version='1.0'?><forms> ";

		for(Object[] study : studies){
			
			int studyId = (Integer)study[0];
			String studyName = (String)study[1];
			xml += "<form url='http://localhost:8888/formdownloadservlet?action=downloadforms&amp;uname=Mark&amp;pw=daniel123&amp;formser=JRXformSerializer&amp;studyId=" + studyId + "'>" + escapeXml(studyName) + "</form>";
		}			
		xml += "</forms>";
		try {
			dos.writeUTF(xml.trim());
			dos.flush();
		} catch (IOException e) {
			throw new UnexpectedException(e);
		}
		
	}

	@SuppressWarnings("unchecked")
	public void serializeUsers(OutputStream os,Object data){
		List<Object[]> users = (List<Object[]>)data; 
		DataOutputStream dos = new DataOutputStream(os);
		try {
			dos.writeByte(users.size());
			for(Object[] user : users){
				dos.writeInt((Integer)user[0]);
				dos.writeUTF((String)user[1]);
				dos.writeUTF((String)user[2]);
				dos.writeUTF((String)user[3]);
			}
		} catch (IOException e) {
			throw new UnexpectedException(e);
		}
	}
	
	@Override
	public void serializeSuccess(OutputStream os){
		
		String str = "The data Has been successfully submitted to the server. Cross check with the server admin to clarify";
		DataOutputStream dos = new DataOutputStream(os);
		try {
			dos.writeUTF(str);
			dos.close();
		} catch (IOException e) {
			throw new UnexpectedException(e);
		}
	}
	
	@Override
	public void serializeFailure(OutputStream os, Exception ex) {
		DataOutputStream dos = new DataOutputStream(os);
		try {
			dos.writeUTF(ex.toString());
			dos.flush();
			dos.close();
		} catch (IOException e) {
			throw new UnexpectedException(e);
		}
	}
	
	@Override
	public void serializeAccessDenied(OutputStream os) {
		
		String str = "<HTML><HEAD><TITLE>Data Submission Status</TITLE>"+
		"</HEAD><BODY>Form Submitted Successfully!</BODY></HTML>";
		DataOutputStream dos = new DataOutputStream(os);
		try {
			dos.writeUTF(str);
			dos.flush();
			dos.close();
		} catch (IOException e) {
			throw new UnexpectedException(e);
		}
	}
	
	/**
	 * Deserializes forms.
	 * 
	 * @return returns an List<String> of deserialized forms
	 */
	@Override
	public List<String> deSerialize(InputStream in, Map<Integer, String> map){
		List<String> forms = new ArrayList<String>();
		DataInputStream dis = new DataInputStream(in);
		try {
			int len = dis.readByte();
			for(int i=0; i<len; i++)
				forms.add(dis.readUTF());
		} catch (IOException e) {
			throw new UnexpectedException(e);
		}

		return forms;
	}
}
