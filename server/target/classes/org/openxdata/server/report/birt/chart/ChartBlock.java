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

import org.w3c.dom.Element;

/**
 * This class creates a BIRT report chart block section.
 * 
 * @author daniel
 *
 */
public class ChartBlock extends ChartBuilderBase {
	
	
	/**
	 * Creates a report chart block section.
	 * 
	 * @param title the block title.
	 * @return the parent element of the chart block section.
	 */
	public static Element createBlock(String title){
		Element blockNode = doc.createElement("Block");
		
		blockNode.appendChild(ChartChildren.getTitleBlock(title));
		blockNode.appendChild(ChartChildren.getPlot());
		blockNode.appendChild(ChartChildren.getLegend());
		
		blockNode.appendChild(ChartChildren.getSizeNode("Bounds", "0.0", "0.0", "567.0", "273.0"));
		blockNode.appendChild(ChartChildren.getSizeNode("Insets", "3.0", "3.0", "3.0", "3.0"));
		
		ChartChildren.addRowColSpans(blockNode);
		
		blockNode.appendChild(ChartChildren.getOutlineNode(1));
		blockNode.appendChild(ChartChildren.getColorDefNode("Background",255,255,255,255));
		
		Element visibleNode = doc.createElement("Visible");
		visibleNode.appendChild(doc.createTextNode("true"));
		blockNode.appendChild(visibleNode);
		
		return blockNode;
	}
}
