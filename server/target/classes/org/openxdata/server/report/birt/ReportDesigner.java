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
package org.openxdata.server.report.birt;

import java.util.List;

import org.openxdata.server.report.birt.chart.ChartBuilder;
import org.openxdata.server.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * This class is responsible for automatically building a report design file.
 * 
 * @author daniel
 *
 */
public class ReportDesigner {
	
	public static final String REPORT_TYPE_LISTING = "Report Listing";

	/** The node with name: property. */
	public static final String NODE_NAME_PROPERTY = "property";

	/** The node with name: structure. */
	public static final String NODE_NAME_STRUCTURE = "structure";

	/** The node with name: expression. */
	public static final String NODE_NAME_EXPRESSION = "expression";

	/** The node with name: row. */
	public static final String NODE_NAME_ROW = "row";

	/** The node with name: cell. */
	public static final String NODE_NAME_CELL = "cell";

	/** The node with name: label. */
	public static final String NODE_NAME_LABEL = "label";

	/** The node with name: data. */
	public static final String NODE_NAME_DATA = "data";

	/** The node with name: text-property. */
	public static final String NODE_NAME_TEXT_PROPERTY = "text-property";

	/** The node with name: text. */
	public static final String NODE_NAME_TEXT = "text";

	/** The node with name: column. */
	public static final String NODE_NAME_COLUMN = "column";

	/** The attribute with name: called name. */
	public static final String ATTRIBUTE_NAME_NAME = "name";

	/** The attribute with name: id. */
	public static final String ATTRIBUTE_NAME_ID = "id";

	/** The attribute with value: name. */
	public static final String ATTRIBUTE_VALUE_NAME = "name";

	/** The attribute with value: expression. */
	public static final String ATTRIBUTE_VALUE_EXPRESSION = "expression";

	/** The attribute with value: resultSetColumn. */
	public static final String ATTRIBUTE_VALUE_RESULTSETCOLUMN = "resultSetColumn";

	/** The attribute with value: text. */
	public static final String ATTRIBUTE_VALUE_TEXT = "text";

	/** The report design document. */
	private Document doc;

	/** A list of report columns. */
	private List<ReportColumn> reportColumns;

	/** The database connection url. */
	private String dburl;
	
	/** The database driver. */
	private String dbdriver;
	

	/** Holds the current id which is incremented to generated 
	 * a new id for a report design item.
	 */
	private Integer id = 1;

	/**
	 * Creates a new instance of the report designer.
	 * @param dbDriver 
	 * @param dbUrl 
	 */
	public ReportDesigner(String dbUrl, String dbDriver){
		dburl = dbUrl;
		dbdriver = dbDriver;
		initDoc();
	}

	/** 
	 * Gets the report design document.
	 * 
	 * @return the report design document.
	 */
	public Document getDoc(){
		return doc;
	}

	/**
	 * Gets the report columns.
	 * 
	 * @return the report column list.
	 */
	public List<ReportColumn> getReportColumns(){
		return reportColumns;
	}

	/**
	 * Creates a new instance of the report design document.
	 */
    private void initDoc() {
        doc = XmlUtil.createNewXmlDocument();
    }

	/**
	 * Creates a report design document.
	 * 
	 * @param type the type of the report to create.
	 * 
	 * @param title the report title.
	 * @param xAxisTitle the x axis title for charts.
	 * @param yAxisTitle the y axis title for charts.
	 * @param reportColumns the list of report columns to display.
	 * @param sql the database sql statement to fetch report data.
	 * @return xml for the new report design document.
	 */
	public String createReportDesign(String type, String title, String xAxisTitle, String yAxisTitle, List<ReportColumn> reportColumns, String sql,String evenColor, String oddColor){
		this.reportColumns = reportColumns;
		id = 1;

		//Create report root element.
		Element reportnode = doc.createElement("report");
		reportnode.setAttribute("xmlns", "http://www.eclipse.org/birt/2005/design");
		reportnode.setAttribute("version", "3.2.20");
		reportnode.setAttribute(ATTRIBUTE_NAME_ID, getNextId());
		doc.appendChild(reportnode);


		//Create propety elements.
		Element propertynode = doc.createElement(NODE_NAME_PROPERTY);
		propertynode.setAttribute(ATTRIBUTE_NAME_NAME, "createdBy");
		propertynode.appendChild(doc.createTextNode("Eclipse BIRT Designer Version 2.5.0.v20090603 Build &lt;2.5.0.v20090617-0630>"));
		reportnode.appendChild(propertynode);

		propertynode = doc.createElement(NODE_NAME_PROPERTY);
		propertynode.setAttribute(ATTRIBUTE_NAME_NAME, "units");
		propertynode.appendChild(doc.createTextNode("in"));
		reportnode.appendChild(propertynode);

		propertynode = doc.createElement(NODE_NAME_PROPERTY);
		propertynode.setAttribute(ATTRIBUTE_NAME_NAME, "iconFile");
		propertynode.appendChild(doc.createTextNode("/templates/blank_report.gif"));
		reportnode.appendChild(propertynode);

		propertynode = doc.createElement(NODE_NAME_PROPERTY);
		propertynode.setAttribute(ATTRIBUTE_NAME_NAME, "bidiLayoutOrientation");
		propertynode.appendChild(doc.createTextNode("ltr"));
		reportnode.appendChild(propertynode);


		//Create data sources.
		Element datasourcesnode = doc.createElement("data-sources");
		reportnode.appendChild(datasourcesnode);


		//Create the oda data source.
		Element odaDataSourceNode = doc.createElement("oda-data-source");
		odaDataSourceNode.setAttribute("extensionID", "org.eclipse.birt.report.data.oda.jdbc");
		odaDataSourceNode.setAttribute(ATTRIBUTE_NAME_NAME, "Data Source");
		odaDataSourceNode.setAttribute(ATTRIBUTE_NAME_ID, getNextId());
		datasourcesnode.appendChild(odaDataSourceNode);

		//Create the oda data source properties.
		propertynode = doc.createElement(NODE_NAME_PROPERTY);
		propertynode.setAttribute(ATTRIBUTE_NAME_NAME, "odaDriverClass");
		propertynode.appendChild(doc.createTextNode(dbdriver));
		odaDataSourceNode.appendChild(propertynode);

		propertynode = doc.createElement(NODE_NAME_PROPERTY);
		propertynode.setAttribute(ATTRIBUTE_NAME_NAME, "odaURL");
		propertynode.appendChild(doc.createTextNode(dburl));
		odaDataSourceNode.appendChild(propertynode);

		propertynode = doc.createElement(NODE_NAME_PROPERTY);
		propertynode.setAttribute(ATTRIBUTE_NAME_NAME, "odaUser");
		propertynode.appendChild(doc.createTextNode("test"));
		odaDataSourceNode.appendChild(propertynode);

		propertynode = doc.createElement("encrypted-property");
		propertynode.setAttribute(ATTRIBUTE_NAME_NAME, "odaPassword");
		propertynode.setAttribute("encryptionID", "base64");
		propertynode.appendChild(doc.createTextNode("dGVzdA=="));
		odaDataSourceNode.appendChild(propertynode);

		reportnode.appendChild(createDataSetsElement(sql));
		reportnode.appendChild(createStylesElement());
		reportnode.appendChild(createPageSetupElement());

		if(type.equals(REPORT_TYPE_LISTING))
			reportnode.appendChild(createBodyElement(title, evenColor, oddColor));
		else{
			ChartBuilder.setDoc(doc);
			reportnode.appendChild(ChartBuilder.createBodyElement(this,type,title, xAxisTitle, yAxisTitle));
		}

		//designReport(XmlUtil.doc2String(doc));

		return XmlUtil.doc2String(doc);
	}

	/**
	 * Creates a data sets section.
	 * 
	 * @param sql the sql statement used to run the report.
	 * @return the parent element of the section.
	 */
	private Element createDataSetsElement(String sql){
		Element dataSetsNode = doc.createElement("data-sets");

		//Create the oda data set.
		Element odaDataSetNode = doc.createElement("oda-data-set");
		odaDataSetNode.setAttribute("extensionID", "org.eclipse.birt.report.data.oda.jdbc.JdbcSelectDataSet");
		odaDataSetNode.setAttribute(ATTRIBUTE_NAME_NAME, "Data Set");
		odaDataSetNode.setAttribute(ATTRIBUTE_NAME_ID, getNextId());
		dataSetsNode.appendChild(odaDataSetNode);

		//Column Hints
		odaDataSetNode.appendChild(createColumnHints());

		//add data source name
		Element propertynode = doc.createElement(NODE_NAME_PROPERTY);
		propertynode.setAttribute(ATTRIBUTE_NAME_NAME, "dataSource");
		propertynode.appendChild(doc.createTextNode("Data Source"));
		odaDataSetNode.appendChild(propertynode);

		//add result set list
		odaDataSetNode.appendChild(createResultsetList());

		//add xml property node
		propertynode = doc.createElement("xml-property");
		propertynode.setAttribute(ATTRIBUTE_NAME_NAME, "queryText");
		propertynode.appendChild(doc.createCDATASection(sql)); //"select * from setting"
		odaDataSetNode.appendChild(propertynode);

		return dataSetsNode;
	}

	/**
	 * Creates a column hints section.
	 * 
	 * @return the parent element of the section.
	 */
	private Element createColumnHints(){
		Element listNode = doc.createElement("list-property");
		listNode.setAttribute(ATTRIBUTE_NAME_NAME, "columnHints");

		for(ReportColumn col : reportColumns){
			Element structureNode = doc.createElement(NODE_NAME_STRUCTURE);
			listNode.appendChild(structureNode);

			Element propertyNode = doc.createElement(NODE_NAME_PROPERTY);
			propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"columnName");
			propertyNode.appendChild(doc.createTextNode(col.getName()));
			structureNode.appendChild(propertyNode);

			propertyNode = doc.createElement(NODE_NAME_PROPERTY);
			propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"displayName");
			propertyNode.appendChild(doc.createTextNode(col.getDisplayName()));
			structureNode.appendChild(propertyNode);
		}

		return listNode;
	}

	/**
	 * Creates the report result set list section.
	 * 
	 * @return the parent element of the section.
	 */
	private Element createResultsetList(){
		Element listNode = doc.createElement("list-property");
		listNode.setAttribute(ATTRIBUTE_NAME_NAME, "resultSet");

		Integer position = 1;
		for(ReportColumn col : reportColumns){
			Element structureNode = doc.createElement(NODE_NAME_STRUCTURE);
			listNode.appendChild(structureNode);

			Element propertyNode = doc.createElement(NODE_NAME_PROPERTY);
			propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"position");
			propertyNode.appendChild(doc.createTextNode((position++).toString()));
			structureNode.appendChild(propertyNode);

			propertyNode = doc.createElement(NODE_NAME_PROPERTY);
			propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"name");
			propertyNode.appendChild(doc.createTextNode(col.getName()));
			structureNode.appendChild(propertyNode);

			propertyNode = doc.createElement(NODE_NAME_PROPERTY);
			propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"nativeName");
			propertyNode.appendChild(doc.createTextNode(col.getName()));
			structureNode.appendChild(propertyNode);

			propertyNode = doc.createElement(NODE_NAME_PROPERTY);
			propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"dataType");
			propertyNode.appendChild(doc.createTextNode(fromXsd2ReportType(col.getDataType())));
			structureNode.appendChild(propertyNode);

			propertyNode = doc.createElement(NODE_NAME_PROPERTY);
			propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"nativeDataType");
			propertyNode.appendChild(doc.createTextNode(fromXsd2NativeDataType(col.getDataType())));
			structureNode.appendChild(propertyNode);
		}

		return listNode;
	}

	/**
	 * Creates a report styles section.
	 * 
	 * @return the report styles section.
	 */
	private Element createStylesElement(){
		Element stylesNode = doc.createElement("styles");

		//add style node
		Element styleNode = doc.createElement("style");
		styleNode.setAttribute(ATTRIBUTE_NAME_NAME,"report");
		styleNode.setAttribute(ATTRIBUTE_NAME_ID,getNextId());
		stylesNode.appendChild(styleNode);

		//add properties to the style node
		Element propertyNode = doc.createElement(NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"fontFamily");
		propertyNode.appendChild(doc.createTextNode("Verdana"));
		styleNode.appendChild(propertyNode);

		propertyNode = doc.createElement(NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"fontSize");
		propertyNode.appendChild(doc.createTextNode("10pt"));
		styleNode.appendChild(propertyNode);

		stylesNode.appendChild(ReportStyle.createTableCellStyle(this));

		return stylesNode;
	}

	/**
	 * Creates a page setup section.
	 * 
	 * @return the parent element of the section.
	 */
	private Element createPageSetupElement(){
		Element pageSetupNode = doc.createElement("page-setup");

		Element masterPageNode = doc.createElement("simple-master-page");
		masterPageNode.setAttribute(ATTRIBUTE_NAME_NAME,"Simple MasterPage");
		masterPageNode.setAttribute(ATTRIBUTE_NAME_ID,getNextId());
		pageSetupNode.appendChild(masterPageNode);

		Element pageFooterNode = doc.createElement("page-footer");
		masterPageNode.appendChild(pageFooterNode);

		Element textNode = doc.createElement(NODE_NAME_TEXT);
		textNode.setAttribute(ATTRIBUTE_NAME_ID,getNextId());
		pageFooterNode.appendChild(textNode);

		Element propertyNode = doc.createElement(NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"contentType");
		propertyNode.appendChild(doc.createTextNode("html"));
		textNode.appendChild(propertyNode);

		propertyNode = doc.createElement("text-property");
		propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"content");
		propertyNode.appendChild(doc.createCDATASection("<value-of>new Date()</value-of>"));
		textNode.appendChild(propertyNode);

		return pageSetupNode;
	}

	/**
	 * Create the report body section. 
	 * 
	 * @param title the report title.
	 * @return the parent element of the section.
	 */
	private Element createBodyElement(String title,String evenColor, String oddColor){
		Element bodyNode = doc.createElement("body");

		bodyNode.appendChild(createTitleElement(title));
		
		Element tableNode = doc.createElement("table");
		tableNode.setAttribute(ATTRIBUTE_NAME_ID,getNextId());
		bodyNode.appendChild(tableNode);

		Element propertyNode = doc.createElement(NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"dataSet");
		propertyNode.appendChild(doc.createTextNode("Data Set"));
		tableNode.appendChild(propertyNode);

		tableNode.appendChild(createBoundDataColumns());
		addReportColumns(tableNode);
		tableNode.appendChild(createTableHeader());
		tableNode.appendChild(createTableDetail(evenColor, oddColor));
		tableNode.appendChild(createTableFooter());

		return bodyNode;
	}
	
	
	/**
	 * Creates the title section.
	 * 
	 * @param title the report title.
	 * @return the title element.
	 */
	private Element createTitleElement(String title){
		Element labelNode = doc.createElement("label");
		labelNode.setAttribute(ATTRIBUTE_NAME_ID,getNextId());
		
		Element propertyNode = doc.createElement(NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"fontWeight");
		propertyNode.appendChild(doc.createTextNode("bold"));
		labelNode.appendChild(propertyNode);
		
		propertyNode = doc.createElement(NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"paddingTop");
		propertyNode.appendChild(doc.createTextNode("10pt"));
		labelNode.appendChild(propertyNode);
		
		propertyNode = doc.createElement(NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"paddingBottom");
		propertyNode.appendChild(doc.createTextNode("20pt"));
		labelNode.appendChild(propertyNode);
		
		propertyNode = doc.createElement(NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"textAlign");
		propertyNode.appendChild(doc.createTextNode("center"));
		labelNode.appendChild(propertyNode);
		
		propertyNode = doc.createElement("text-property");
		propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"text");
		propertyNode.appendChild(doc.createTextNode(title));
		labelNode.appendChild(propertyNode);
		
		return labelNode;
	}
	

	/**
	 * Creates a bound data columns section.
	 * 
	 * @return the parent element of the section.
	 */
	private Element createBoundDataColumns(){
		Element listNode = doc.createElement("list-property");
		listNode.setAttribute(ATTRIBUTE_NAME_NAME,"boundDataColumns");

		for(ReportColumn col : reportColumns){
			Element structureNode = doc.createElement(NODE_NAME_STRUCTURE);
			listNode.appendChild(structureNode);

			Element propertyNode = doc.createElement(NODE_NAME_PROPERTY);
			propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,ATTRIBUTE_VALUE_NAME);
			propertyNode.appendChild(doc.createTextNode(col.getName()));
			structureNode.appendChild(propertyNode);

			propertyNode = doc.createElement(NODE_NAME_EXPRESSION);
			propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,ATTRIBUTE_VALUE_EXPRESSION);
			propertyNode.appendChild(doc.createTextNode("dataSetRow[\""+col.getName()+"\"]"));
			structureNode.appendChild(propertyNode);

			propertyNode = doc.createElement(NODE_NAME_PROPERTY);
			propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"dataType");
			propertyNode.appendChild(doc.createTextNode(fromXsd2ReportType(col.getDataType())));
			structureNode.appendChild(propertyNode);
		}

		return listNode;
	}

	/**
	 * Creates a table header section.
	 * 
	 * @return the parent element of the section.
	 */
	private Element createTableHeader(){
		Element headerNode = doc.createElement("header");

		Element rowNode = doc.createElement(NODE_NAME_ROW);
		rowNode.setAttribute(ATTRIBUTE_NAME_ID,getNextId());
		headerNode.appendChild(rowNode);

		for(ReportColumn col : reportColumns){
			Element cellNode = doc.createElement(NODE_NAME_CELL);
			cellNode.setAttribute(ATTRIBUTE_NAME_ID,getNextId());
			rowNode.appendChild(cellNode);

			Element labelNode = doc.createElement(NODE_NAME_LABEL);
			labelNode.setAttribute(ATTRIBUTE_NAME_ID,getNextId());
			cellNode.appendChild(labelNode);

			Element propertyNode = doc.createElement(NODE_NAME_TEXT_PROPERTY);
			propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,ATTRIBUTE_VALUE_TEXT);
			propertyNode.appendChild(doc.createTextNode(col.getDisplayName()));
			labelNode.appendChild(propertyNode);
		}

		return headerNode;
	}

	/**
	 * Creates a report table detail section.
	 * 
	 * @return the report table detail section node.
	 */
	private Element createTableDetail(String evenColor, String oddColor){
		Element detailNode = doc.createElement("detail");

		Element rowNode = doc.createElement(NODE_NAME_ROW);
		rowNode.setAttribute(ATTRIBUTE_NAME_ID,getNextId());
		detailNode.appendChild(rowNode);

		rowNode.appendChild(createAlternatingRowColorNode(true,evenColor));
		rowNode.appendChild(createAlternatingRowColorNode(false,oddColor));

		for(ReportColumn col : reportColumns){
			Element cellNode = doc.createElement(NODE_NAME_CELL);
			cellNode.setAttribute(ATTRIBUTE_NAME_ID,getNextId());
			rowNode.appendChild(cellNode);

			Element dataNode = doc.createElement(NODE_NAME_DATA);
			dataNode.setAttribute(ATTRIBUTE_NAME_ID,getNextId());
			cellNode.appendChild(dataNode);

			Element propertyNode = doc.createElement(NODE_NAME_PROPERTY);
			propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,"style");
			propertyNode.appendChild(doc.createTextNode("tablecell"));
			dataNode.appendChild(propertyNode);

			propertyNode = doc.createElement(NODE_NAME_PROPERTY);
			propertyNode.setAttribute(ATTRIBUTE_NAME_NAME,ATTRIBUTE_VALUE_RESULTSETCOLUMN);
			propertyNode.appendChild(doc.createTextNode(col.getName()));
			dataNode.appendChild(propertyNode);


		}

		return detailNode;
	}

	/**
	 * Creates an alternating row color node.
	 * 
	 * @return the row color node.
	 */
	private Element createAlternatingRowColorNode(boolean even, String color){
		Element listNode = doc.createElement("list-property");
		listNode.setAttribute(ATTRIBUTE_NAME_NAME, "highlightRules");

		Element structureNode = doc.createElement(NODE_NAME_STRUCTURE);
		listNode.appendChild(structureNode);

		Element propertyNode = doc.createElement(NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ATTRIBUTE_NAME_NAME, "operator");
		propertyNode.appendChild(doc.createTextNode("eq"));
		structureNode.appendChild(propertyNode);

		propertyNode = doc.createElement(NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ATTRIBUTE_NAME_NAME, "backgroundColor");
		propertyNode.appendChild(doc.createTextNode(color)); //#808080
		structureNode.appendChild(propertyNode);

		Element expressionNode = doc.createElement(NODE_NAME_EXPRESSION);
		expressionNode.setAttribute(ATTRIBUTE_NAME_NAME, "testExpr");
		expressionNode.appendChild(doc.createTextNode("Total.runningCount() % 2"));
		structureNode.appendChild(expressionNode);

		Element simpPropListNode = doc.createElement("simple-property-list");
		simpPropListNode.setAttribute(ATTRIBUTE_NAME_NAME, "value1");
		structureNode.appendChild(simpPropListNode);

		Element valueNode = doc.createElement("value");
		valueNode.appendChild(doc.createTextNode(even ? "0" : "1"));
		simpPropListNode.appendChild(valueNode);

		return listNode;
	}

	/**
	 * Creates a report table footer.
	 * 
	 * @return the table footer node.
	 */
	private Element createTableFooter(){
		Element footerNode = doc.createElement("footer");

		Element rowNode = doc.createElement(NODE_NAME_ROW);
		rowNode.setAttribute(ATTRIBUTE_NAME_ID,getNextId());
		footerNode.appendChild(rowNode);

		for (int i = 0; i < reportColumns.size(); i++) {
			Element cellNode = doc.createElement(NODE_NAME_CELL);
			cellNode.setAttribute(ATTRIBUTE_NAME_ID,getNextId());
			rowNode.appendChild(cellNode);
		}
		
		return footerNode;
	}

	/**
	 * Adds report columns to a table node.
	 * 
	 * @param tableNode the table node.
	 */
	private void addReportColumns(Element tableNode){
		for (int i = 0; i < reportColumns.size(); i++) {
			Element colNode = doc.createElement(NODE_NAME_COLUMN);
			colNode.setAttribute(ATTRIBUTE_NAME_ID,getNextId());
			tableNode.appendChild(colNode);
		}
	}

	/** 
	 * Gets a new id
	 * 
	 * @return a new integer id.
	 */
	public String getNextId(){
		return (id++).toString();
	}

	/**
	 * Converts an xsd data type to a BIRT report column type.
	 * 
	 * @param type the xsd type.
	 * @return the BIRT colum data type.
	 */
	public static String fromXsd2ReportType(String type){
		if(type.equalsIgnoreCase("xsd:int"))
			return "integer";
		else if(type.equalsIgnoreCase("xsd:boolean"))
			return "boolean";
		else if(type.equalsIgnoreCase("xsd:date"))
			return "date";
		else if(type.equalsIgnoreCase("xsd:dateTime"))
			return "date-time";
		else if(type.equalsIgnoreCase("xsd:decimal"))
			return "decimal";
		else if(type.equalsIgnoreCase("xsd:float"))
			return "float";
		else if(type.equalsIgnoreCase("xsd:time"))
			return "time";
		else if(type.equalsIgnoreCase("xsd:base64Binary"))
			return "blob";

		return "string";
	}

	public static String fromXsd2NativeDataType(String type){
		/*if(type.equalsIgnoreCase("xsd:int"))
			return "4";
		else if(type.equalsIgnoreCase("xsd:boolean"))
			return ""+IPropertyType.BOOLEAN_TYPE;
		else if(type.equalsIgnoreCase("xsd:date"))
			return ""+IPropertyType.DATE_TIME_TYPE;
		else if(type.equalsIgnoreCase("xsd:dateTime"))
			return ""+IPropertyType.DATE_TIME_TYPE;
		else if(type.equalsIgnoreCase("xsd:decimal"))
			return ""+IPropertyType.FLOAT_TYPE;
		else if(type.equalsIgnoreCase("xsd:float"))
			return ""+IPropertyType.FLOAT_TYPE;
		else if(type.equalsIgnoreCase("xsd:time"))
			return ""+IPropertyType.DATE_TIME_TYPE;
		else if(type.equalsIgnoreCase("xsd:base64Binary"))
			return "4";*/

		return "12";
	}

}
