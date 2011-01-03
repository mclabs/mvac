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
 * Creates a series pallete section of charts.
 * 
 * @author daniel
 *
 */
public class SeriesPalette extends ChartBuilderBase {

	public static Element getEntriesNode(Integer transparency,Integer red,Integer green,Integer blue){
		Element entriesNode = doc.createElement("Entries");
		entriesNode.setAttribute("xsi:type","attribute:ColorDefinition");
		
		Element transparencyNode = doc.createElement("Transparency");
		transparencyNode.appendChild(doc.createTextNode(transparency.toString()));
		entriesNode.appendChild(transparencyNode);

		Element redNode = doc.createElement("Red");
		redNode.appendChild(doc.createTextNode(red.toString()));
		entriesNode.appendChild(redNode);

		Element greenNode = doc.createElement("Green");
		greenNode.appendChild(doc.createTextNode(green.toString()));
		entriesNode.appendChild(greenNode);
		
		Element blueNode = doc.createElement("Blue");
		blueNode.appendChild(doc.createTextNode(blue.toString()));
		entriesNode.appendChild(blueNode);

		return entriesNode;
	}
	
	public static Element getSecondElement(){
		Element seriesPaletteNode = doc.createElement("SeriesPalette");
		
		seriesPaletteNode.appendChild(getEntriesNode(255,80,166,218));
		seriesPaletteNode.appendChild(getEntriesNode(255,242,88,106));
		seriesPaletteNode.appendChild(getEntriesNode(255,232,172,57));
		seriesPaletteNode.appendChild(getEntriesNode(255,128,255,128));
		seriesPaletteNode.appendChild(getEntriesNode(255,64,128,128));
		seriesPaletteNode.appendChild(getEntriesNode(255,128,128,192));
		seriesPaletteNode.appendChild(getEntriesNode(255,170,85,85));
		seriesPaletteNode.appendChild(getEntriesNode(255,128,128,0));
		seriesPaletteNode.appendChild(getEntriesNode(255,192,192,192));
		seriesPaletteNode.appendChild(getEntriesNode(255,255,255,128));
		
		seriesPaletteNode.appendChild(getEntriesNode(255,128,192,128));
		seriesPaletteNode.appendChild(getEntriesNode(255,7,146,94));
		seriesPaletteNode.appendChild(getEntriesNode(255,0,128,255));
		seriesPaletteNode.appendChild(getEntriesNode(255,255,128,192));
		seriesPaletteNode.appendChild(getEntriesNode(255,0,255,255));
		seriesPaletteNode.appendChild(getEntriesNode(255,255,128,128));
		seriesPaletteNode.appendChild(getEntriesNode(255,0,128,192));
		seriesPaletteNode.appendChild(getEntriesNode(255,128,128,192));
		seriesPaletteNode.appendChild(getEntriesNode(255,255,0,255));
		seriesPaletteNode.appendChild(getEntriesNode(255,128,64,64));
		
		
		seriesPaletteNode.appendChild(getEntriesNode(255,255,128,64));
		seriesPaletteNode.appendChild(getEntriesNode(255,80,240,120));
		seriesPaletteNode.appendChild(getEntriesNode(255,0,64,128));
		seriesPaletteNode.appendChild(getEntriesNode(255,128,0,64));
		seriesPaletteNode.appendChild(getEntriesNode(255,255,0,128));
		seriesPaletteNode.appendChild(getEntriesNode(255,128,128,64));
		seriesPaletteNode.appendChild(getEntriesNode(255,128,128,128));
		seriesPaletteNode.appendChild(getEntriesNode(255,255,128,255));
		seriesPaletteNode.appendChild(getEntriesNode(255,0,64,0));
		seriesPaletteNode.appendChild(getEntriesNode(255,0,0,0));
		
		seriesPaletteNode.appendChild(getEntriesNode(255,255,255,255));
		seriesPaletteNode.appendChild(getEntriesNode(255,255,128,0));
		
		return seriesPaletteNode;
	}
}
