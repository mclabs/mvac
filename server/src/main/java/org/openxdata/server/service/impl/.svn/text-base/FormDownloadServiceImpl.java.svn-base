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
package org.openxdata.server.service.impl;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openxdata.server.OpenXDataConstants;
import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.FormSmsArchive;
import org.openxdata.server.admin.model.FormSmsError;
import org.openxdata.server.admin.model.Locale;
import org.openxdata.server.admin.model.MobileMenuText;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.admin.model.exception.UnexpectedException;
import org.openxdata.server.dao.FormDownloadDAO;
import org.openxdata.server.serializer.StudySerializer;
import org.openxdata.server.serializer.UserSerializer;
import org.openxdata.server.serializer.XformSerializer;
import org.openxdata.server.service.FormDownloadService;
import org.openxdata.server.service.LocaleService;
import org.openxdata.server.service.SerializationService;
import org.openxdata.server.service.StudyManagerService;
import org.openxdata.server.service.UserService;
import org.openxdata.server.service.UtilityService;
import org.openxdata.server.util.LanguageUtil;
import org.openxdata.server.util.XformUtil;
import org.openxdata.server.util.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Default implementation for form download service.
 * 
 * @author daniel
 *
 */
@Service("formDownloadService")
@Transactional
public class FormDownloadServiceImpl implements FormDownloadService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private FormDownloadDAO dao;

	@Autowired
	private UserService userService;
	
	@Autowired
	private UtilityService utilityService;
	
	@Autowired
	private StudyManagerService studyManagerService;
	
	@Autowired
	private SerializationService serializationService;

    @Autowired
    private LocaleService localeService;

	/** Reference to the document builder factory. */
	private static final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

	public FormDownloadServiceImpl(){
	}

	public FormDownloadDAO getDao() {
		return dao;
	}

	public void setDao(FormDownloadDAO dao) {
		this.dao = dao;
	}

	public void setStudyManagerService(StudyManagerService studyManagerService) {
		this.studyManagerService = studyManagerService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public UserService getUserService() {
		return this.userService;
	}

	public void setUtilityService(UtilityService utilityService) {
		this.utilityService = utilityService;
	}

	public UtilityService getUtilityService() {
		return utilityService;
	}
	
	@Override
	public List<Object[]> getUsers() {
		List<User> users = userService.getUsers();
		List<Object[]> retUsers = new ArrayList<Object[]>();
		for(User user : users){
			Object[] retUser = new Object[4];
			retUser[0] = user.getUserId();
			retUser[1] = user.getName();
			retUser[2] = user.getPassword();
			retUser[3] = user.getSalt();

			retUsers.add(retUser);
		}
		return retUsers;
	}

	@Override
	public List<Object[]> getStudyList(User user) {
		List<Object[]> studies = null;
		if(user.hasAdministrativePrivileges()) {
			log.info("User "+ user.getName()+ " is an administrator, so all studies will be loaded");
			studies = dao.getStudyList();
		}
		else {
			studies = dao.getStudyList(user);			
		}
		return studies;
	}

	@Override
	public List<String> getFormsDefaultVersionXml(User user, String locale){
		Map<Integer, String> forms = dao.getFormsDefaultVersionXml(user);
		return getFormsDefaultVersionXml(forms,locale);
	}

	/**
	 * Gets a map of default form versions keyed by the form version id.
	 * 
	 * @return the map of xml texts for each default form version keyed by the form version id.
	 */
	public Map<Integer,String> getFormsDefaultVersionXmlMap(User user){
		return getFormsVersionXmlMap(dao.getFormsDefaultVersionXml(user));
	}
	
	/**
	 * Gets a map of all form versions keyed by the form version id.
	 * 
	 * @return the map of xml texts for each form version keyed by the form version id.
	 */
	@Override
	public Map<Integer,String> getFormsVersionXmlMap(){
		return getFormsVersionXmlMap(dao.getFormsVersionXml());
	}

	@Override
	@Transactional(readOnly=true)
	public List<String> getFormsDefaultVersionXml(User user, Integer studyId,String locale){
		Map<Integer, String> formsDefaultVersionXml = dao.getFormsDefaultVersionXml(user, studyId);
		return getFormsDefaultVersionXml(formsDefaultVersionXml,locale);
	}

    @Override
    public void saveFormData(FormData formData) {
        try {
            studyManagerService.saveFormData(formData);
        } catch (Throwable ex) {
            log.error("Error while saving form! Form data:" + formData.getData());
            throw new UnexpectedException("Form Data Not Successfully submitted!", ex);
        }
    }

	@Override
	public void saveFormData(String xml,User user, Date creationDate) {
		saveFormData(getFormId(xml), xml, null, user, creationDate);
	}

	@Override
	public void downloadForms(OutputStream os,String serializerName,String locale) {
		User user = userService.getLoggedInUser();
		XformSerializer formSerializer = serializationService.getFormSerializer(serializerName);
		List<String> formsDefaultVersionXml = getFormsDefaultVersionXml(user, locale);
		formSerializer.serializeForms(os, formsDefaultVersionXml, 1, "Study", "");
	}

	@Override
	public void downloadForms(int studyId, OutputStream os,String serializerName,String locale) {
		//We allow users to fill data for only default (Current) form versions
		//and so are the only ones we send back in form download requests.
		User user = userService.getLoggedInUser();
		XformSerializer formSerializer = serializationService.getFormSerializer(serializerName);
		
		String studyKey = studyManagerService.getStudyKey(studyId);
		String studyName = studyManagerService.getStudyName(studyId);
		List<String> formsDefaultVersionXml = getFormsDefaultVersionXml(user, studyId, locale);
		formSerializer.serializeForms(os, formsDefaultVersionXml, studyId, studyName, studyKey);
	}
	
	@Override
	public void downloadAllForms(OutputStream os,String serializerName,String locale) {
		User user = userService.getLoggedInUser();
		StudySerializer studySerializer = serializationService.getStudySerializer(serializerName);
		List<Object[]> studies = getStudyList(user);
		List<Object[]> studiesWithForms = new ArrayList<Object[]>();
		for (Object[] study : studies) {
			Integer studyId = (Integer)study[0];
			String studyName = (String)study[1];
			List<String> formsDefaultVersionXml = getFormsDefaultVersionXml(user, studyId, locale);
			Object[] studyWithForms = new Object[3];
			studyWithForms[0] = studyId;
			studyWithForms[1] = studyName;
			studyWithForms[2] = formsDefaultVersionXml;
			studiesWithForms.add(studyWithForms);
		}
		studySerializer.serializeStudies(os, studiesWithForms);
	}

    @Override
	public void submitForms(InputStream is, OutputStream os, String serializerName) {
        //When submitting data, we need all the form versions and not just the default ones
        //because the user can change the default form version which already has data on
        //mobile devices. So getting all versions shields us from such problems.
        List<FormData> formDataList = new ArrayList<FormData>();
        User user = userService.getLoggedInUser();
        XformSerializer formSerializer = serializationService.getFormSerializer(serializerName);
        Map<Integer, String> formsVersionXmlMap = getFormsVersionXmlMap();
		List<String> xforms = (List<String>) formSerializer.deSerialize(is, formsVersionXmlMap);
        if (xforms == null || xforms.size() == 0) {
            throw new UnexpectedException("Problem encountered while deserializing data.");
        }
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            for (String xml : xforms) {
                Document doc = db.parse(IOUtils.toInputStream(xml, "UTF-8"));
                Integer formId = Integer.valueOf(doc.getDocumentElement().getAttribute(OpenXDataConstants.ATTRIBUTE_NAME_FORMID));
                String descTemplate = doc.getDocumentElement().getAttribute(OpenXDataConstants.ATTRIBUTE_NAME_DESCRIPTION_TEMPLATE);
                FormData formData = saveFormData(formId, xml, XmlUtil.getDescriptionTemplate(doc.getDocumentElement(), descTemplate), user, new Date());
                formDataList.add(formData);
            }
            // serialize the summaries
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeByte(formDataList.size());
            for (FormData fd : formDataList) {
                String description = fd.getDescription();
                if (description != null) {
                    dos.writeUTF(description);
                } else {
                    dos.writeUTF("form {"+fd.getFormDefVersionId()+"}"); // description can be null
                }
                dos.writeInt(fd.getFormDataId());
            }
        } catch (ParserConfigurationException ex) {
            throw new UnexpectedException(ex);
        } catch (SAXException ex) {
        	throw new UnexpectedException(ex);
        } catch (IOException ex) {
        	throw new UnexpectedException(ex);
        }
    }

	@Override
	public void downloadUsers(OutputStream os,String serializerName) {
		UserSerializer userSerializer = serializationService.getUserSerializer(serializerName);
		userSerializer.serializeUsers(os, getUsers());
	}

	@Override
	public void downloadStudies(OutputStream os,String serializerName,String locale) {
		User user = userService.getLoggedInUser();
		StudySerializer studySerializer = serializationService.getStudySerializer(serializerName);
		studySerializer.serializeStudies(os, getStudyList(user));
	}
	
    /**
     * Gets the form id contained in an xml document.
     *
     * @param xml the xml for the document.
     * @return the formId.
     */
    private Integer getFormId(String xml) {
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(IOUtils.toInputStream(xml, "UTF-8"));
            return getXformFormId(doc.getDocumentElement());
        } catch (IOException ex) {
            throw new UnexpectedException(ex);
        } catch (SAXException ex) {
            throw new UnexpectedException(ex);
        } catch (ParserConfigurationException ex) {
            throw new UnexpectedException(ex);
        }
    }
	
	/**
	 * Gets the form id contained in an xforms document.
	 * 
	 * @param element the root element of the xforms document.
	 * @return the formId.
	 */
	private Integer getXformFormId(Element element){
		String value = element.getAttribute(OpenXDataConstants.ATTRIBUTE_NAME_FORMID);

		if(value == null || value.trim().length() == 0)
			value = getDataNodeAttributeValue(element, OpenXDataConstants.ATTRIBUTE_NAME_FORMID);

		if(validId(value))
			return Integer.parseInt(value);

		return null;
	}
	
	/**
	 * Checks if text contains a valid numeric id.
	 * 
	 * @param id the text to check.
	 * @return true if it has, else false.
	 */
	private boolean validId(String id){
		try{
			Integer.parseInt(id);
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}
	
	/**
	 * Gets a data node attribute value of an xforms document.
	 * 
	 * @param element the root of the xforms document.
	 * @param name the name of the attribute.
	 * @return the value of the data node attribute.
	 */
	private String getDataNodeAttributeValue(Element element, String name){
		Element instanceNode = getInstanceNode(element);
		if(instanceNode == null)
			return null;

		NodeList kids = instanceNode.getChildNodes();
		for(int index = 0; index < kids.getLength(); index++){
			Node child = kids.item(index);
			if(child.getNodeType() != Node.ELEMENT_NODE)
				continue;

			return ((Element)child).getAttribute(name);
		}
		return null;
	}
	
	/**
	 * Gets the instance node of an xforms document.
	 * 
	 * @param parent the root node of the xforms document.
	 * @return the instance node.
	 */
	private Element getInstanceNode(Element parent){
		NodeList kids = parent.getChildNodes();
		for(int index = 0; index < kids.getLength(); index++){
			Node child = kids.item(index);
			if(child.getNodeType() != Node.ELEMENT_NODE)
				continue;

			if(child.getNodeName().contains("instance"))
				return (Element)child;
			else{
				child = getInstanceNode((Element)child);
				if(child != null)
					return (Element)child;
			}
		}

		return null;
	}
	
	/**
	 * Gets a list of default xforms in a given locale.
	 * 
	 * @param forms a map of the xforms keyed by their ids.
	 * @param locale the locale key.
	 * @return the xforms list.
	 */
	private List<String> getFormsDefaultVersionXml(Map<Integer,String> forms, String locale){
		try{
			if(forms != null){
				List<String> xforms = new ArrayList<String>();
				Iterator<Entry<Integer,String>> iterator = forms.entrySet().iterator();
				while(iterator.hasNext()){
					Entry<Integer,String> entry = iterator.next();

					String xml = LanguageUtil.translate(entry.getValue(),dao.getXformLocaleText(entry.getKey(), locale));
					if(xml != null)
						xforms.add(xml);
				}
				return xforms;
			}
		}
		catch(Exception ex){
			log.error(ex.getMessage(), ex);
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Takes a map form versions keyed by their ids and puts the ids in the xforms xml.
	 * The form id is put as a of the id attribute in the xforms model child node.
	 * 
	 * @param forms a map form versions keyed by their ids.
	 * @return the map form versions keyed by their ids. 
	 */
	private Map<Integer,String> getFormsVersionXmlMap(Map<Integer,String> forms/*, String locale*/){
		try{
			if(forms != null){
				Iterator<Entry<Integer,String>> iterator = forms.entrySet().iterator();
				while(iterator.hasNext()){
					Entry<Integer,String> entry = iterator.next();				
					entry.setValue(XformUtil.addFormId2Xform(entry.getKey(),entry.getValue()));
				}
				return forms;
			}
		}
		catch(Exception ex){
			log.error(ex.getMessage(), ex);
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void downloadLocales(InputStream is,OutputStream os,String serializerName) throws IOException {
		DataOutputStream dos = new DataOutputStream(os);

		List<Locale> locales = localeService.getLocales();
		if(locales == null || locales.size() == 0)
			dos.writeByte(0);
		else{
			dos.writeByte(locales.size());
			for(Locale locale : locales){
				dos.writeUTF(locale.getKey());
				dos.writeUTF(locale.getName());
			}
		}
	}
	
	@Override
	public void downloadMenuText(InputStream is,OutputStream os,String serializerName,String locale) {
		DataOutputStream dos = new DataOutputStream(os);
		
		try {
			List<MobileMenuText> text = utilityService.getMobileMenuText(locale);
			if(text == null || text.size() == 0)
				dos.writeShort(0);
			else{
				dos.writeShort(text.size());
				for(MobileMenuText txt : text){
					dos.writeShort(txt.getMenuId());
					dos.writeUTF(txt.getMenuText());
				}
			}
		}
		catch(Exception ex) {
			throw new UnexpectedException(ex);
		}
	}

	@Override
	public void saveFormSmsArchive(FormSmsArchive data)  {
		dao.saveFormSmsArchive(data);
	}
	
	@Override
	public void saveFormSmsError(FormSmsError error)  {
		dao.saveFormSmsError(error);
	}
	
	@Override
	public User getUserByPhoneNo(String phoneNo){
		return dao.getUserByPhoneNo(phoneNo);
	}
	
	/**
	 * Saves submitted form data.
	 * 
	 * @param versionId the identifier of the form version to which the data belongs.
	 * @param xml the xforms model containing the data.
	 * @param description the description of the data.
	 * @param user the user who submitted the data.
	 * @param creationDate the date when data was submitted.
	 * @throws Exception
	 */
	private FormData saveFormData(int versionId, String xml, String description, User user, Date creationDate) {
		FormData formData = new FormData(versionId,xml,description,creationDate,user);
		saveFormData(formData);
		return formData;
	}
	
	@Override
	public Integer getStudyIdWithKey(String studyKey){
		return dao.getStudyIdWithKey(studyKey);
	}
}
