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
package org.openxdata.server.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.FormSmsArchive;
import org.openxdata.server.admin.model.FormSmsError;
import org.openxdata.server.admin.model.User;

/**
 * Service that handles download of studies, forms, users, languages, menu text
 * together with upload of collected data for mobile devices.
 * 
 * @author daniel
 *
 */
public interface FormDownloadService {

    /**
     * Gets the list of users. Each item in this list being an array
     * of four objects. The first is an Integer which is the user id, the second
     * is a String which is the user name, the third is a String which is the
     * user hashed password, and the fourth is a String which is the salt used
     * to hash the user password.
     *
     * @return the user list.
     */
    List<Object[]> getUsers();

    /**
     * Gets a list of studies. Each item in this list being an array
     * of two objects. The first is an Integer which is the study id, and the second
     * is a String which is the study name.
     *
     * @param User logged in user
     * @return the study list.
     */
    List<Object[]> getStudyList(User user);

    /**
     * Gets a list of default form versions for a given locale.
     *
     * @param User logged in user
     * @param locale the locale key. eg en
     * @return the list of xml texts for each default form version.
     */
    List<String> getFormsDefaultVersionXml(User user, String locale);

    /**
     * Gets a list of default form versions for a given study and locale.
     *
     * @param User logged in user
     * @param studyId the study identifier.
     * @param locale the locale key.
     * @return the list of xml texts form each default form version.
     */
    List<String> getFormsDefaultVersionXml(User user, Integer studyId, String locale);

    /**
     * Saves form data.
     *
     * @param xml the xforms model xml data to save.
     * @param user the user who is submitting the data.
     * @param creationDate the date when the data is being submitted.
     */
    void saveFormData(String xml, User user, Date creationDate);

    /**
     * Saves form data.
     *
     * @param formData the form data to save.
     */
    void saveFormData(FormData formData);

    /**
     * Archives successfully processed sms.
     *
     * @param data the sms data archive object.
     */
    void saveFormSmsArchive(FormSmsArchive data);

    /**
     * Saves sms which has resulted into errors during its processing.
     *
     * @param error the sms error object.
     */
    void saveFormSmsError(FormSmsError error);

    /**
     * Writes forms onto a stream.
     *
     * @param os the stream for writing to.
     * @param serializerName the name of the setting which points to the form serializer class.
     * @param locale the locale key.
     */
    void downloadForms(OutputStream os, String serializerName, String locale);

    /**
     * Writes forms, in a given study, onto a stream.
     *
     * @param studyId the identifier of the study whose forms to write.
     * @param os the stream for writing to.
     * @param serializerName the name of the setting which points to the form serializer class.
     * @param locale the locale key.
     */
    void downloadForms(int studyId, OutputStream os, String serializerName, String locale);

    /**
     * Writes all forms, onto a stream.
     *
     * @param os the stream for writing to.
     * @param serializerName the name of the setting which points to the form serializer class.
     * @param locale the locale key.
     */
    void downloadAllForms(OutputStream os, String serializerName, String locale);

    /**
     * Reads submitted form data from a stream.
     *
     * @param is the stream from which to read the submitted data.
     * @param os the stream for writing the response.
     * @param serializerName the name of the setting which points to the form serializer class.
     */
    void submitForms(InputStream is, OutputStream os, String serializerName);

    /**
     * Writes users onto a stream.
     *
     * @param os the stream for writing to.
     * @param serializerName the name of the setting which points to the user serializer class.
     */
    void downloadUsers(OutputStream os, String serializerName);

    /**
     * Writes studies onto a stream.
     *
     * @param os the stream for writing to.
     * @param serializerName the name of the setting which points to the study serializer class.
     * @param locale the locale key.
     */
    void downloadStudies(OutputStream os, String serializerName, String locale);

    /**
     * Writes mobile application menu text onto a stream.
     *
     * @param is the stream from which to read request parameters, if any.
     * @param os the stream for writing to.
     * @param serializerName the name of the setting which points to the serializer class.
     * @param locale the locale key.
     * @throws IOException
     */
    void downloadMenuText(InputStream is, OutputStream os, String serializerName, String locale) throws IOException;

    /**
     * Writes locales or languages onto a stream.
     *
     * @param is the stream from which to read request parameters, if any.
     * @param os the stream for writing to.
     * @param serializerName the name of the setting which points to the form serializer class.
     * @throws IOException
     */
    void downloadLocales(InputStream is, OutputStream os, String serializerName) throws IOException;

    /**
     * Gets a user registered with a given phone number.
     *
     * @param phoneNo the phone number.
     * @return the user.
     */
    User getUserByPhoneNo(String phoneNo);

    Integer getStudyIdWithKey(String studyKey);

    /**
     * Gets a map of all form versions keyed by the form version id.
     *
     * @return the map of xml texts for each form version keyed by the form version id.
     */
    public Map<Integer, String> getFormsVersionXmlMap();
}
