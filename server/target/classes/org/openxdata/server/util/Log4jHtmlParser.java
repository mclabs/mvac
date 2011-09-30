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
package org.openxdata.server.util;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.openxdata.server.OpenXDataConstants;
import org.openxdata.server.admin.model.exception.UnexpectedException;

/**
 * Utilities used to parse <tt>HTML Files.</tt>
 * 
 * @author Angel
 *
 */
public class Log4jHtmlParser {
		
	// The number of read Errors.
	private static int errorCount = 0;
	
	private static boolean cont = false;
	
	// Latest Error.
	private static String latestError = "";
	
	// The number of Errors with WARN severity Level.
	private static int severityLevelTypeOfWARNCount = 0;
	
	// The number of Errors with Error severity Level.
	private static int severityLevelTypeOfERRORCount = 0;
	
	// Holds Unique Error count.
	private static Set<String> uniqueErrorCount = new HashSet<String>();
	
	// Holds the Unique warning count.
	private static Set<String> uniqueWarningCount = new HashSet<String>();
	
	
	/**
	 * Extracts all the Nodes contained in an <tt>HTML File.</tt>
	 * 
	 * @param htmlFile <tt>HTML File</tt> tp process.
	 * @param tagFilter The Tag fileter. 
	 * @return <tt>NodeList.</tt>
	 */
	private static NodeList getNodeList(String htmlFile, String tagFilter){		
		try {
		
			Parser parser = Parser.createParser(htmlFile, null);
			NodeList nodes = parser.extractAllNodesThatMatch(new TagNameFilter (tagFilter));
			
			return nodes;
			
		} catch (ParserException ex) {
			throw new UnexpectedException(ex);
		}		
	}
	
	/**
	 * Retrieves the total number of <tt>Errors</tt> in the <tt>Log File.</tt>
	 * 
	 * @param htmlFile <tt>HTML Log File</tt> to process.
	 * @return errorCount.
	 */
	public static int getErrorCount(String htmlFile){
		try{
			// Get all tags with Table Row as they are the actual errors.
			NodeList nodeList = getNodeList(htmlFile, OpenXDataConstants.LOG_FILE_TABLE_ROW_TAG_NAME);
			
			// Remove the default table row tag
			errorCount = nodeList.size();
			
			// Retrieve only the Table Data Tags as they are the ones with Errors.
			NodeList xNodeList = getNodeList(htmlFile, OpenXDataConstants.LOG_FILE_TABLE_DATA_TAG_NAME);
			NodeIterator iter = xNodeList.elements();		
			
			//Possibility of nullity if log is empty.
			if(null != iter){						
				
				while(iter.hasMoreNodes()){
					
					Node node = iter.nextNode();
					
					// We take advantage of this loop to process
					// other errors and handles.
					processUniqueErrors(node);
					processUniqueWarnining(node);
					
					processSeverityTypeOfWARNLevelNodes(node);
					processSeverityTypeOfERRORLevelNodes(node);
				}
			}
			
		}catch(ParserException ex){
			throw new UnexpectedException(ex);
		}
		

		// If its one, return that number
		// Else, check for possible duplicates.
		if(errorCount == 2)
			errorCount = 1;
		else if(errorCount > 1){
			
			// We subtract the initial Table Row definition tag.
			// Divide to remove the closing tags on each of the Errors.
			errorCount = (errorCount - 1) / 2;
		}
		
		return errorCount;
	}
	
	/**
	 * Process the Unique <tt>Errors</tt> in the <tt>Log File.</tt>
	 * 
	 * @param node <tt>Node</tt> we checking for uniqueness.
	 * @throws ParserException If a parsing <tt>Error</tt> occurs during processing.
	 */
	private static void processUniqueErrors(Node node) throws ParserException {
		if(node.getText().contains(OpenXDataConstants.LOG_FILE_LEVEL_TAG_NAME)){
			if(node.getChildren() != null){
				NodeIterator iter = node.getChildren().elements();
				if(iter != null){
					while(iter.hasMoreNodes()){
						Node xNode = iter.nextNode();
						if(xNode instanceof TextNode){
							if(xNode.getText().contains(OpenXDataConstants.LOG_FILE_ERROR_STRING))
								severityLevelTypeOfERRORCount++;
						}
					}
				}
			}
		}
	}

	/**
	 * Process the Unique <tt>Warnings</tt> in the <tt>Log File.</tt>
	 * 
	 * @param node <tt>Node</tt> we checking for uniqueness.
	 * @throws ParserException If a parsing <tt>Error</tt> occurs during processing.
	 */
	private static void processUniqueWarnining(Node node) throws ParserException {
		if(node.getText().contains(OpenXDataConstants.LOG_FILE_LEVEL_TAG_NAME)){
			if(node.getChildren() != null){
				NodeIterator iter = node.getChildren().elements();
				if(iter != null){
					while(iter.hasMoreNodes()){
						Node xNode = iter.nextNode();
						if(xNode instanceof TextNode){
							if(xNode.getText().contains(OpenXDataConstants.LOG_FILE_WARN_STRING))
								severityLevelTypeOfWARNCount++;
						}
					}
				}
			}
		}
	}
	
	/**
	 * Extracts the latest <tt>Error</tt> from the <tt>Log File.</tt>
	 * 
	 * @param htmlFile <tt>Log File</tt> for process.
	 * 
	 * @return Latest <tt>Error.</tt>
	 * 
	 * @throws ParserException If an parse <tt>Exception</tt> occurs.
	 */
	public static String processtLatestError(String htmlFile){
	
		try {
			
			// Read all the Table Row tags
			NodeList nodeList = getNodeList(htmlFile, OpenXDataConstants.LOG_FILE_TABLE_ROW_TAG_NAME);		
			NodeIterator iter = nodeList.elements();		
			if(null != iter){
				while(iter.hasMoreNodes()){
					TagNode node = (TagNode) iter.nextNode();
					if(node.getChildren().size() > 0){
						extractLatestError(htmlFile);
					}
				}
			}
		} catch (ParserException ex) {
			throw new UnexpectedException(ex);
		}
		
		return latestError;
	}

	/**
	 * Processes the children of a given {@link NodeList}
	 * 
	 * @param htmlFile List of children to process.
	 * 
	 * @throws ParserException If an parse <tt>Exception</tt> occurs.
	 */
	private static void extractLatestError(String htmlFile) throws ParserException {		
		try{
			
			NodeList nodeList = getNodeList(htmlFile, OpenXDataConstants.LOG_FILE_TABLE_DATA_TAG_NAME);	
			NodeIterator iter = nodeList.elements();		
			if(null != iter){
				while(iter.hasMoreNodes()){
					
					Node node = iter.nextNode();
					
					// Process the Nodes.
					processCategoryNodes(node);					
				}
			}
		}
		catch(NoSuchElementException ex){
			throw new UnexpectedException(ex);
		}
	}

	/**
	 * Process the <tt>Category Tag.</tt>
	 * 
	 * @param node <tt>Node</tt> to process.
	 */
	private static void processCategoryNodes(Node node) {
		try{
			
			if(node.getText().contains(OpenXDataConstants.LOG_FILE_CATEGORY_TAG_NAME)){
				if(node.getChildren() != null){
					NodeIterator iter = node.getChildren().elements();
					if (null != iter){
						while(iter.hasMoreNodes()){
							Node xNode = iter.nextNode();
							if(xNode instanceof TextNode){
								if(!cont){
									cont = true;
									latestError = xNode.getText();
									break;
								}
							}
						}
					}
				}
			}
		}catch(ParserException pEx){
			throw new UnexpectedException(pEx);
		}
	}

	/**
	 * Process the <tt>WARN Tags.</tt>
	 * 
	 * @param node <tt>Node</tt> to process.
	 * @throws ParserException If a parsing <tt>Error</tt> occurs during processing.
	 */
	private static void processSeverityTypeOfWARNLevelNodes(Node node) throws ParserException {
		if(node.getText().contains(OpenXDataConstants.LOG_FILE_LEVEL_TAG_NAME)){
			if(node.getChildren() != null){
				NodeIterator iter = node.getChildren().elements();
				if(iter != null){
					while(iter.hasMoreNodes()){
						Node xNode = iter.nextNode();
						if(xNode instanceof TextNode){
							if(xNode.getText().contains(OpenXDataConstants.LOG_FILE_WARN_STRING)){
								if(uniqueWarningCount.contains(xNode.getText()))
									return;
								else
									uniqueWarningCount.add(xNode.getText());
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Process the <tt>Error Tags.</tt>
	 * 
	 * @param node <tt>Node</tt> to process.
	 * @throws ParserException If a parsing <tt>Error</tt> occurs during processing.  
	 */
	private static void processSeverityTypeOfERRORLevelNodes(Node node) throws ParserException {
		if(node.getText().contains(OpenXDataConstants.LOG_FILE_LEVEL_TAG_NAME)){
			if(node.getChildren() != null){
				NodeIterator iter = node.getChildren().elements();
				if(iter != null){
					while(iter.hasMoreNodes()){
						Node xNode = iter.nextNode();
						if(xNode instanceof TextNode){
							if(xNode.getText().contains(OpenXDataConstants.LOG_FILE_ERROR_STRING)){
								if(uniqueErrorCount.contains(xNode.getText()))
									return;
								else
									uniqueErrorCount.add(xNode.getText());
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Returns the total number of <tt>Errors</tt> with the severity level of <tt>WARN.</tt>
	 * 
	 * @return the severityLevelTypeOfWARNCount
	 */
	public static int getSeverityLevelTypeOfWARNCount() {
		return severityLevelTypeOfWARNCount;
	}
	
	/**
	 * Returns the total number of <tt>Errors</tt> with the severity level of <tt>ERROR.</tt>
	 * @return the severityLevelTypeOfERRORCount
	 */
	public static int getSeverityLevelTypeOfERRORCount() {
		return severityLevelTypeOfERRORCount;
	}

	/**
	 * Retrieve each unique occurrence of an <tt>Error.</tt>
	 * 
	 * @param htmlFile <tt>Log File</tt> to process.
	 * 
	 * @return uniqueErrorCount.
	 */
	public static int getUniqueErrorCount(String htmlFile) {
		
		Set<String> uniqueErrors = new HashSet<String>();
		
		// Get all tags with Table Row as they are the actual errors.
		NodeList nodeList = getNodeList(htmlFile, OpenXDataConstants.LOG_FILE_TABLE_DATA_TAG_NAME);
		try{
			
			NodeIterator iter = nodeList.elements();
			
			//Possibility of nullity if log is empty.
			if(null != iter){			
				
				while(iter.hasMoreNodes()){
					
					Node node = iter.nextNode();
					
					// Extract unique errors.
					processChildNodesToExtractUniqueErrors(uniqueErrors, node);
				}
			}
		} catch (ParserException ex) {
			throw new UnexpectedException(ex);
		}
		
		return uniqueErrors.size();
	}

	/**
	 * Iterates over child <tt>Nodes</tt> to extract <tt>Errors.</tt>
	 * 
	 * @param uniqueErrors List to bind unique <tt>Errors</tt> to.
	 * @param node <tt>Node</tt> we iterating over to get children.
	 * 
	 * @throws ParserException If a parsing <tt>Error</tt> occurs during processing. 
	 */
	private static void processChildNodesToExtractUniqueErrors(Set<String> uniqueErrors, Node node) throws ParserException {
		
		// Iterate over the Nodes children to get the Category.
		if(node.getText().contains(OpenXDataConstants.LOG_FILE_CATEGORY_TAG_NAME)){
			NodeIterator xIter = node.getChildren().elements();
			while(xIter.hasMoreNodes()){							
				Node xNode = xIter.nextNode();
				
				// Set was accepting duplicates.
				if(xNode instanceof TextNode){
					if(uniqueErrors.contains(xNode.getText()))
						return;
					else
						uniqueErrors.add(xNode.getText());
				}
			}
		}
	}
	
	/**
	 * Returns Unique <tt>ERRORs</tt> ignoring duplicates logs of the same <tt>exception.</tt>
	 * @return uniqueErrorCount
	 */
	public static int getUniqueLogsWithERRORSeverity(){
		return uniqueErrorCount.size();
		
	}
	
	/**
	 * Returns Unique <tt>WARNINGs</tt> ignoring duplicates logs of the same <tt>Warning.</tt>
	 * @return uniqueWarningsCount
	 */
	public static int getUniqueLogsWithWARNSeverity(){
		return uniqueWarningCount.size();
	}
}
