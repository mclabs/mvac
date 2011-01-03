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
package org.openxdata.server.export;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openxdata.server.admin.model.FormDefVersion;
import org.openxdata.server.service.DataExportService;
import org.openxdata.server.util.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Exports form data to CSV format and writes it to a stream.
 * 
 * @author daniel
 *
 */
public class CSVDataExport implements DataExport {

	@Autowired
	private DataExportService dataExportService;
	
	/**
	 * Writes data, collected for a particular form version, to a stream in a CSV format.
	 * 
	 * @param printWriter the stream to write the data.
	 * @param formId the unique identifier of the form version whose data we are to export. This should never be null.
	 * @param fromDate the data submission date from which start the export. Supply null to include all dates.
	 * @param toDate the data submission date to which to end the export. Supply null to include all dates
	 * @param userId the user who submitted the data. Supply null to export data for all users.
	 */
	@Override
	public void export(PrintWriter printWriter,Integer formId, Date fromDate, Date toDate, Integer userId){

		//Check to ensure that we have such a form version as identified by the formId.
		FormDefVersion formDefVersion = dataExportService.getFormDefVersion(formId);
		if(formDefVersion == null)
			return;

		//Get the list of xforms xml models to export.
		List<Object[]> data = dataExportService.getFormDataWithAuditing(formId, fromDate, toDate, userId);
		if(data == null || data.size() == 0)
			return;

		Document doc = XmlUtil.fromString2Doc(formDefVersion.getXform());

		//Get GPS and multimedia field names.
		List<String> gpsFields = new ArrayList<String>();
		List<String> multimediaFields = getMultimediaFields(doc,gpsFields);
		Map<String,List<String>> multSelOptions = new HashMap<String,List<String>>();
		List<String> multSelFields = getMultSelFields(doc,multSelOptions);

		//Get and write the CSV header.
		Object[] initial = data.get(0);
		String header = (String)initial[3];
		String line = "ID,CAPTURER,CREATION DATE,";
		line += getHeader(header,multimediaFields,gpsFields,multSelFields,multSelOptions).toUpperCase();//"Concept Id,Name,Description,Synonyms,Answers,Class,Datatype,Changed By,Creator\n";
		printWriter.write(line + "\n");

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		for(Object obs: data){
			line = "";
			Object[] o = (Object[])obs;
			String userName = (String)o[1];
			Date dateCreated = (Date)o[2];
			String xml = (String)o[3];
			NodeList nodes = XmlUtil.fromString2Doc(xml).getDocumentElement().getChildNodes();
			line = o[0] + "," + userName.toUpperCase() + "," + df.format(dateCreated).toUpperCase();
			for(int index = 0; index < nodes.getLength(); index++){
				Node node = nodes.item(index);
				if(node.getNodeType() != Node.ELEMENT_NODE)
					continue;

				//As for now we do not export multimedia field values.
				if(multimediaFields.contains(node.getNodeName()))
					continue;
				String value = node.getTextContent();

				//If a GPS field, split it into its various pieces (latitude, longitude and altitude)
				if(gpsFields.contains(node.getNodeName()))
					line = "," + addGPSValues(line,value);
				else if(multSelFields.contains(node.getNodeName()))
					line = "," + addMultSelValues(line,value,multSelOptions.get(node.getNodeName()));
				else
					line += "," + '"' + formatCSV(value) + '"';

			}
			printWriter.write(line + "\n");
		}
	}

	/**
	 * Splits a GPS value into its components as they will appear in the CSV export.
	 * 
	 * @param line the current CSV line to which we are to add the GPS formated value.
	 * @param value the combined GPS value.
	 * @return the CSV formated GPS value.
	 */
	private String addGPSValues(String line, String value){

		String latitude = "",longitude = "", altitude = "";

		if(value != null && value.trim().length() > 0){
			int pos1 = value.indexOf(',');
			latitude = value.substring(0,pos1);

			int pos2 = value.lastIndexOf(',');
			longitude = value.substring(pos1+1,pos2);

			altitude = value.substring(pos2+1);
		}

		line += "," + '"' + formatCSV(latitude) + '"';
		line += "," + '"' + formatCSV(longitude) + '"';
		line += "," + '"' + formatCSV(altitude) + '"';

		return line;
	}

	/**
	 * Gets a CSV line which will server as the header (Column names) for the export.
	 * 
	 * @param xml the xforms model xml.
	 * @param multimediaFields the list of multimedia field names.
	 * @param gpsFields the list of GPS field names.
	 * @return the CSV line having column names.
	 */
	private String getHeader(String xml, List<String> multimediaFields,List<String> gpsFields,List<String> multSelFields, Map<String,List<String>> multSelOptions){
		String header = "";
		Document doc = XmlUtil.fromString2Doc(xml);
		NodeList nodes = doc.getDocumentElement().getChildNodes();
		for(int index = 0; index < nodes.getLength(); index++){
			Node node = nodes.item(index);

			if(node.getNodeType() != Node.ELEMENT_NODE)
				continue;

			String name = node.getNodeName();

			//As for now we do not export multimedia field values.
			if(multimediaFields.contains(name))
				continue;

			if(header.length() > 0)
				header += ",";

			if(gpsFields.contains(name)){
				header +=  name + "_latitude";
				header +=  "," + name + "_longitude";
				header +=  "," + name + "_altitude";
			}
			else if(multSelFields.contains(name)){
				List<String> options = multSelOptions.get(name);
				if(options == null)
					continue;

				for(int i = 0; i < options.size(); i++){
					String option = options.get(i);
					if(i == 0)
						header += name + "_" + option;
					else
						header +=  "," + name + "_" + option;
				}
			}
			else
				header +=  name;
		}
		return header;
	}

	/**
	 * Formats a value in in the CSV style.
	 * 
	 * @param value the value for format.
	 * @return the CSV formated value.
	 */
	private String formatCSV(String value){
		return value.replaceAll("\"","\"\"");
	}

	/**
	 * Parses an xform document and gets a list of node names whose data is supposed to be for 
	 * multimedia (Picture, Audio & Video) types. During the process, it also fills a list
	 * of node names whose data is supposed to be containing GPS coordinates.
	 * 
	 * @param doc the xforms document.
	 * @param gpsFields the list of GPS cordinates.
	 * @return the list for multimedia.
	 */
	private List<String> getMultimediaFields(Document doc, List<String> gpsFields){
		List<String> fields = new ArrayList<String>();

		NodeList nodes = doc.getElementsByTagName("xf:bind");
		for(int index = 0; index < nodes.getLength(); index++){
			Node node = nodes.item(index);
			if(node.getNodeType() != Node.ELEMENT_NODE)
				continue;

			String type = ((Element)node).getAttribute("type");
			if(type == null || type.trim().length() == 0)
				continue;

			String nodeset = ((Element)node).getAttribute("nodeset");
			String name = nodeset.substring(nodeset.lastIndexOf('/')+1);

			if(type.contains("base64Binary"))
				fields.add(name);
			else if("gps".equals(((Element)node).getAttribute("format")))
				gpsFields.add(name);
		}

		return fields;
	}


	private List<String> getMultSelFields(Document doc, Map<String,List<String>> multSelOptions){
		List<String> fields = new ArrayList<String>();

		NodeList nodes = doc.getElementsByTagName("xf:select");
		for(int index = 0; index < nodes.getLength(); index++){
			Node node = nodes.item(index);
			if(node.getNodeType() != Node.ELEMENT_NODE)
				continue;

			String bind = ((Element)node).getAttribute("bind");
			if(bind == null || bind.trim().length() == 0)
				continue;

			fields.add(bind);

			addSelectOptions(bind, (Element)node, multSelOptions);
		}

		return fields;
	}


	private void addSelectOptions(String name, Element selectNode, Map<String,List<String>> multSelOptions){
		List<String> options = new ArrayList<String>();

		NodeList nodes = selectNode.getElementsByTagName("xf:item");

		for(int index = 0; index < nodes.getLength(); index++){
			Node node = nodes.item(index);
			if(node.getNodeType() != Node.ELEMENT_NODE)
				continue;

			String bind = ((Element)node).getAttribute("id");
			if(bind == null || bind.trim().length() == 0)
				continue;

			options.add(bind);
		}

		multSelOptions.put(name, options);
	}


	private String addMultSelValues(String line, String value, List<String> options){
		if(options != null){
			String val = "";
			for(int index = 0; index < options.size(); index++){
				String option = options.get(index);
				val = (value.contains(option)) ? "1" : "0";
				line += "," + '"' + val + '"';
			}
		}

		return line;
	}
}
