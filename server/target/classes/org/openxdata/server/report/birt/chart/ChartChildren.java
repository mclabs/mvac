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
 * Creates kids of a chart.
 * 
 * @author daniel
 *
 */
public class ChartChildren extends ChartBuilderBase {
	
	public static Element getColorDefNode(String name,Integer transparency,Integer red,Integer green,Integer blue){
		Element entriesNode = doc.createElement(name);
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
	
	/*private static Element getTextNode(){
		Element textNode = doc.createElement("Text");
		
		Element valueNode = doc.createElement("Value");
		textNode.appendChild(valueNode);

		Element fontNode = doc.createElement("Font");
		fontNode.appendChild(doc.createElement("Alignment"));
		textNode.appendChild(fontNode);

		return textNode;
	}*/
	
	public static Element getSizeNode(String name,String left,String top,String width,String height){
		Element sizeNode = doc.createElement(name);
		
		Element leftNode = doc.createElement("Left");
		leftNode.appendChild(doc.createTextNode(left));
		sizeNode.appendChild(leftNode);

		Element topNode = doc.createElement("Top");
		topNode.appendChild(doc.createTextNode(top));
		sizeNode.appendChild(topNode);

		Element widthNode = doc.createElement("Width");
		widthNode.appendChild(doc.createTextNode(width));
		sizeNode.appendChild(widthNode);
		
		Element heightNode = doc.createElement("Height");
		heightNode.appendChild(doc.createTextNode(height));
		sizeNode.appendChild(heightNode);

		return sizeNode;
	}
	
	private static Element getColorNode(){
		Element colorNode = doc.createElement("Color");
		
		Element transparencyNode = doc.createElement("Transparency");
		transparencyNode.appendChild(doc.createTextNode("255"));
		colorNode.appendChild(transparencyNode);

		Element redNode = doc.createElement("Red");
		redNode.appendChild(doc.createTextNode("0"));
		colorNode.appendChild(redNode);

		Element greenNode = doc.createElement("Green");
		greenNode.appendChild(doc.createTextNode("0"));
		colorNode.appendChild(greenNode);
		
		Element blueNode = doc.createElement("Blue");
		blueNode.appendChild(doc.createTextNode("0"));
		colorNode.appendChild(blueNode);

		return colorNode;
	}
	
	public static Element getOutlineNode(Integer thickness){
		Element outlineNode = doc.createElement("Outline");
		
		Element styleNode = doc.createElement("Style");
		styleNode.appendChild(doc.createTextNode("Solid"));
		outlineNode.appendChild(styleNode);

		Element thicknessNode = doc.createElement("Thickness");
		thicknessNode.appendChild(doc.createTextNode(thickness.toString()));
		outlineNode.appendChild(thicknessNode);
		
		outlineNode.appendChild(getColorNode());
		
		Element visibleNode = doc.createElement("Visible");
		visibleNode.appendChild(doc.createTextNode("false"));
		outlineNode.appendChild(visibleNode);

		return outlineNode;
	}
	
	private static Element getClientAreaNode(){
		Element clientAreaNode = doc.createElement("ClientArea");
		
		clientAreaNode.appendChild(getOutlineNode(0));
		clientAreaNode.appendChild(getSizeNode("Insets","2.0","2.0","2.0","2.0"));

		return clientAreaNode;
	}
	
	private static Element getBoundsNode(){
		return getSizeNode("Bounds","0.0","0.0","0.0","0.0");
	}
	
	private static Element getInsetsNode(){
		return getSizeNode("Insets","3.0","3.0","3.0","3.0");
	}
	
	private static Element getFontNode(){
		Element fontNode = doc.createElement("Font");
		
		Element sizeNode = doc.createElement("Size");
		sizeNode.appendChild(doc.createTextNode("16.0"));
		fontNode.appendChild(sizeNode);
		
		Element boldNode = doc.createElement("Bold");
		boldNode.appendChild(doc.createTextNode("true"));
		fontNode.appendChild(boldNode);
		
		Element alignNode = doc.createElement("Alignment");
		
		Element horzAlignNode = doc.createElement("horizontalAlignment");
		horzAlignNode.appendChild(doc.createTextNode("Center"));
		alignNode.appendChild(horzAlignNode);
		
		Element vertAlignNode = doc.createElement("verticalAlignment");
		vertAlignNode.appendChild(doc.createTextNode("Center"));
		alignNode.appendChild(vertAlignNode);
		
		fontNode.appendChild(alignNode);

		return fontNode;
	}
	
	private static Element getCaptionNode(String title){
		Element captionNode = doc.createElement("Caption");
		
		Element valueNode = doc.createElement("Value");
		valueNode.appendChild(doc.createTextNode(title));
		captionNode.appendChild(valueNode);
		
		captionNode.appendChild(getFontNode());

		return captionNode;
	}
	
	private static Element getLabelNode(String title){
		Element labelNode = doc.createElement("Label");
		
		labelNode.appendChild(getCaptionNode(title));
		labelNode.appendChild(getColorDefNode("Background",0,255,255,255));
		labelNode.appendChild(getOutlineNode(1));
		labelNode.appendChild(getSizeNode("Insets","0.0","2.0","0.0","3.0"));
		
		Element visibleNode = doc.createElement("Visible");
		visibleNode.appendChild(doc.createTextNode("true"));
		labelNode.appendChild(visibleNode);

		return labelNode;
	}
	
	public static void addRowColSpans(Element parent){
		Element rowNode = doc.createElement("Row");
		rowNode.appendChild(doc.createTextNode("-1"));
		parent.appendChild(rowNode);

		Element colNode = doc.createElement("Column");
		colNode.appendChild(doc.createTextNode("-1"));
		parent.appendChild(colNode);
		
		Element rowSpanNode = doc.createElement("Rowspan");
		rowSpanNode.appendChild(doc.createTextNode("-1"));
		parent.appendChild(rowSpanNode);
		
		Element colSpanNode = doc.createElement("Columnspan");
		colSpanNode.appendChild(doc.createTextNode("-1"));
		parent.appendChild(colSpanNode);
	}
	
	public static Element getTitleBlock(String title){
		Element childrenNode = doc.createElement("Children");
		childrenNode.setAttribute("xsi:type","layout:TitleBlock");
		
		childrenNode.appendChild(getBoundsNode());
		childrenNode.appendChild(getInsetsNode());
		
		addRowColSpans(childrenNode);
		
		childrenNode.appendChild(getOutlineNode(1));
		
		Element visibleNode = doc.createElement("Visible");
		visibleNode.appendChild(doc.createTextNode("true"));
		childrenNode.appendChild(visibleNode);

		childrenNode.appendChild(getLabelNode(title));
		
		return childrenNode;
	}
	
	public static Element getPlot(){
		Element childrenNode = doc.createElement("Children");
		childrenNode.setAttribute("xsi:type","layout:Plot");
		
		childrenNode.appendChild(getBoundsNode());
		childrenNode.appendChild(getInsetsNode());
		
		addRowColSpans(childrenNode);
		
		childrenNode.appendChild(getOutlineNode(1));
		
		Element visibleNode = doc.createElement("Visible");
		visibleNode.appendChild(doc.createTextNode("true"));
		childrenNode.appendChild(visibleNode);
		
		Element horzSpacNode = doc.createElement("HorizontalSpacing");
		horzSpacNode.appendChild(doc.createTextNode("5"));
		childrenNode.appendChild(horzSpacNode);
		
		Element vertSpacNode = doc.createElement("VerticalSpacing");
		vertSpacNode.appendChild(doc.createTextNode("5"));
		childrenNode.appendChild(vertSpacNode);

		childrenNode.appendChild(getClientAreaNode());
		
		return childrenNode;
	}
	
	public static Element getLegend(){
		Element childrenNode = doc.createElement("Children");
		childrenNode.setAttribute("xsi:type","layout:Legend");
		
		childrenNode.appendChild(getSizeNode("Bounds","0.0","0.0","0.0","0.0"));
		
		Element visibleNode = doc.createElement("Visible");
		visibleNode.appendChild(doc.createTextNode("false"));
		childrenNode.appendChild(visibleNode);

		//TODO if bar=Series, pie=Categories
		Element itemTypeNode = doc.createElement("ItemType");
		itemTypeNode.appendChild(doc.createTextNode("Categories"));
		childrenNode.appendChild(itemTypeNode);
		
		return childrenNode;
	}
}
