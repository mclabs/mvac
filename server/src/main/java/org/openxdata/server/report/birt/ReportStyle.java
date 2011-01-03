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

import org.w3c.dom.Element;

/**
 * Creates report styles.
 * 
 * @author daniel
 *
 */
public class ReportStyle {
	
	/**
	 * Creates a report table cell style.
	 * 
	 * @param designer reference to the report designer object.
	 * @return the new report table cell style.
	 */
	public static Element createTableCellStyle(ReportDesigner designer){
		Element styleNode = designer.getDoc().createElement("style");
		styleNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"tablecell");
		styleNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_ID,designer.getNextId());
		
		Element propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"borderBottomColor");
		propertyNode.appendChild(designer.getDoc().createTextNode("#CCCCCC"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"borderBottomStyle");
		propertyNode.appendChild(designer.getDoc().createTextNode("solid"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"borderBottomWidth");
		propertyNode.appendChild(designer.getDoc().createTextNode("1pt"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"borderLeftColor");
		propertyNode.appendChild(designer.getDoc().createTextNode("#CCCCCC"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"borderLeftStyle");
		propertyNode.appendChild(designer.getDoc().createTextNode("solid"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"borderLeftWidth");
		propertyNode.appendChild(designer.getDoc().createTextNode("1pt"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"borderRightColor");
		propertyNode.appendChild(designer.getDoc().createTextNode("#CCCCCC"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"borderRightStyle");
		propertyNode.appendChild(designer.getDoc().createTextNode("solid"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"borderRightWidth");
		propertyNode.appendChild(designer.getDoc().createTextNode("1pt"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"borderTopColor");
		propertyNode.appendChild(designer.getDoc().createTextNode("#CCCCCC"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"borderTopStyle");
		propertyNode.appendChild(designer.getDoc().createTextNode("solid"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"borderTopWidth");
		propertyNode.appendChild(designer.getDoc().createTextNode("1pt"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"paddingTop");
		propertyNode.appendChild(designer.getDoc().createTextNode("0pt"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"paddingLeft");
		propertyNode.appendChild(designer.getDoc().createTextNode("0pt"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"paddingBottom");
		propertyNode.appendChild(designer.getDoc().createTextNode("0pt"));
		styleNode.appendChild(propertyNode);
		
		propertyNode = designer.getDoc().createElement(ReportDesigner.NODE_NAME_PROPERTY);
		propertyNode.setAttribute(ReportDesigner.ATTRIBUTE_NAME_NAME,"paddingRight");
		propertyNode.appendChild(designer.getDoc().createTextNode("0pt"));
		styleNode.appendChild(propertyNode);
		
		return styleNode;
	}
}
