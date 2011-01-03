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
package org.openxdata.server.report.birt.chart;

import java.util.List;

import org.apache.log4j.Logger;
import org.openxdata.server.report.birt.ReportColumn;
import org.openxdata.server.report.birt.ReportDesigner;
import org.openxdata.server.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * This class creates a BIRT chart type of report.
 * 
 * @author daniel
 *
 */
public class ChartBuilder extends ChartBuilderBase {

	private static final Logger log = Logger.getLogger(ChartBuilder.class);
	
	/**
	 * Creates a body section for a chart.
	 * 
	 * @param reportDesigner reference to the report designer object.
	 * @param type the type of chart. eg Pie Char, Bar Chart, etc.
	 * @param title the chart title.
	 * @param xAxisTitle the x axis title for the chart.
	 * @param yAxisTitle the y axis title for the chart.
	 * @return the parent element of the section.
	 */
	public static Element createBodyElement(ReportDesigner reportDesigner,String type, String title,String xAxisTitle, String yAxisTitle){
		Element bodyNode = doc.createElement("body");

		Element extendedItemNode = doc.createElement("extended-item");
		extendedItemNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_ID,reportDesigner.getNextId());
		extendedItemNode.setAttribute("extensionName","Chart");
		extendedItemNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"NewChart");
		bodyNode.appendChild(extendedItemNode);

		Element xmlPropNode = doc.createElement("xml-property");
		xmlPropNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"xmlRepresentation");

		//Store document as the following method replaces it.
		Document prevDoc = doc;
		xmlPropNode.appendChild(doc.createCDATASection(createChartCDATASection(type,title,xAxisTitle, yAxisTitle,reportDesigner)));

		//Restore our doc
		doc = prevDoc;
		extendedItemNode.appendChild(xmlPropNode);

		addExtendedItemNonXmlProps(extendedItemNode,reportDesigner);

		return bodyNode;
	}

	/**
	 * Adds non xml properties to the extended-item child node of the body node.
	 * 
	 * @param extendedItemNode the extended-item node.
	 * @param reportDesigner reference to the report designer object.
	 */
	private static void addExtendedItemNonXmlProps(Element extendedItemNode,ReportDesigner reportDesigner){
		//outputFormat
		Element propertyNode = doc.createElement("property");
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"outputFormat");
		propertyNode.appendChild(doc.createTextNode("JPG"));
		extendedItemNode.appendChild(propertyNode);

		//inheritColumns
		propertyNode = doc.createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"inheritColumns");
		propertyNode.appendChild(doc.createTextNode("false"));
		extendedItemNode.appendChild(propertyNode);

		//Data Set Chart
		propertyNode = doc.createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"dataSet");
		propertyNode.appendChild(doc.createTextNode("Data Set"));
		extendedItemNode.appendChild(propertyNode);

		//height
		propertyNode = doc.createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"height");
		propertyNode.appendChild(doc.createTextNode("3.7916666666666665in"));
		extendedItemNode.appendChild(propertyNode);

		//width
		propertyNode = doc.createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"width");
		propertyNode.appendChild(doc.createTextNode("7.875in"));
		extendedItemNode.appendChild(propertyNode);

		extendedItemNode.appendChild(createExtendedItemListProp(reportDesigner));
	}

	/**
	 * Creates the extended-item list-property node.
	 * 
	 * @param reportDesigner reference to the report designer object.
	 * @return the list-property node.
	 */
	private static Element createExtendedItemListProp(ReportDesigner reportDesigner){
		Element listPropertyNode = doc.createElement("list-property");
		listPropertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"boundDataColumns");

		List<ReportColumn> reportColumns = reportDesigner.getReportColumns();

		for(ReportColumn col : reportColumns){
			Element structureNode = doc.createElement(ReportDesigner.NODE_NAME_STRUCTURE);
			listPropertyNode.appendChild(structureNode);

			Element propertyNode = doc.createElement(ReportDesigner.NODE_NAME_PROPERTY);
			propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,ReportDesigner.ATTRIBUTE_VALUE_NAME);
			propertyNode.appendChild(doc.createTextNode(col.getName()));
			structureNode.appendChild(propertyNode);

			Element expressionNode = doc.createElement(ReportDesigner.NODE_NAME_EXPRESSION);
			expressionNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,ReportDesigner.ATTRIBUTE_VALUE_EXPRESSION);
			expressionNode.appendChild(doc.createTextNode("dataSetRow[\""+col.getName()+"\"]"));
			structureNode.appendChild(expressionNode);

			propertyNode = doc.createElement(ReportDesigner.NODE_NAME_PROPERTY);
			propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"dataType");
			propertyNode.appendChild(doc.createTextNode(ReportDesigner.fromXsd2ReportType(col.getDataType())));
			structureNode.appendChild(propertyNode);
		}

		return listPropertyNode;
	}

	/**
	 * Creates a CDATA section of a chart.
	 * 
	 * @param type the chart type. eg Bar Chart, Pie Chart, etc
	 * @param title the chart title.
	 * @param xAxisTitle the x axis title for the chart.
	 * @param yAxisTitle the y axis title for the chart.
	 * @param reportDesigner reference to the report designer.
	 * @return the CDATA section text.
	 */
	private static String createChartCDATASection(String type, String title,String xAxisTitle, String yAxisTitle,ReportDesigner reportDesigner){
		try{

			Document doc = XmlUtil.createNewXmlDocument();
			ChartBlock.setDoc(doc);

			String name = "model:ChartWithAxes";
			if(type.contains("Pie"))
				name = "model:ChartWithoutAxes";

			Element modelNode = doc.createElement(name);
			doc.appendChild(modelNode);

			modelNode.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
			modelNode.setAttribute("xmlns:attribute","http://www.birt.eclipse.org/ChartModelAttribute");
			modelNode.setAttribute("xmlns:data","http://www.birt.eclipse.org/ChartModelData");
			modelNode.setAttribute("xmlns:layout","http://www.birt.eclipse.org/ChartModelLayout");
			modelNode.setAttribute("xmlns:model","http://www.birt.eclipse.org/ChartModel");
			modelNode.setAttribute("xmlns:type","http://www.birt.eclipse.org/ChartModelType");

			Element versionNode = doc.createElement("Version");
			versionNode.appendChild(doc.createTextNode("2.5.0"));
			modelNode.appendChild(versionNode);

			Element typeNode = doc.createElement("Type");
			typeNode.appendChild(doc.createTextNode(type));
			modelNode.appendChild(typeNode);

			Element subTypeNode = doc.createElement("SubType");
			subTypeNode.appendChild(doc.createTextNode("Standard"));
			modelNode.appendChild(subTypeNode);

			modelNode.appendChild(ChartBlock.createBlock(title));

			String xml = XmlUtil.doc2String(doc).replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");

			String numericColName = reportDesigner.getReportColumns().get(0).getName();
			String textColName = reportDesigner.getReportColumns().get(1).getName();

			String chartType = type;
			int pos = type.indexOf(" Chart");
			if(pos > 0)
				chartType = type.substring(0,pos);

			if(chartType.contains("Bar")){
				xml = xml.replace("</model:ChartWithAxes>", BarChartXml.getXml(numericColName,textColName,chartType,xAxisTitle, yAxisTitle));
				xml += "</model:ChartWithAxes>";
			}
			else if(chartType.contains("Line")){
				xml = xml.replace("</model:ChartWithAxes>", LineChartXml.getXml(numericColName,textColName,chartType,xAxisTitle, yAxisTitle));
				xml += "</model:ChartWithAxes>";
			}
			else{
				xml = xml.replace("</model:ChartWithoutAxes>", PieChartXml.getXml(numericColName,textColName,chartType,xAxisTitle, yAxisTitle));
				xml += "</model:ChartWithoutAxes>";
			}

			return xml;
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);//ex.printStackTrace();
		}

		return null;
	}
}
