package org.openxdata.server.admin.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class StudyManagerService_Proxy extends RemoteServiceProxy implements org.openxdata.server.admin.client.service.StudyManagerServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.openxdata.server.admin.client.service.StudyManagerService";
  private static final String SERIALIZATION_POLICY ="C3E920666A1406899BEA36C1ACF82D6F";
  private static final org.openxdata.server.admin.client.service.StudyManagerService_TypeSerializer SERIALIZER = new org.openxdata.server.admin.client.service.StudyManagerService_TypeSerializer();
  
  public StudyManagerService_Proxy() {
    super(GWT.getModuleBaseURL(),
      null, 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void deleteForm(org.openxdata.server.admin.model.FormDef formDef, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.deleteForm", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteForm");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.FormDef/141965068");
      streamWriter.writeObject(formDef);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.deleteForm", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "StudyManagerService_Proxy.deleteForm", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteFormData(java.lang.Integer formDataId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.deleteFormData", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteFormData");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeObject(formDataId);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.deleteFormData", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "StudyManagerService_Proxy.deleteFormData", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteStudy(org.openxdata.server.admin.model.StudyDef studyDef, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.deleteStudy", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteStudy");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.StudyDef/2343592517");
      streamWriter.writeObject(studyDef);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.deleteStudy", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "StudyManagerService_Proxy.deleteStudy", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteUserMappedForm(org.openxdata.server.admin.model.mapping.UserFormMap userMappedForm, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.deleteUserMappedForm", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteUserMappedForm");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.mapping.UserFormMap/4284888440");
      streamWriter.writeObject(userMappedForm);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.deleteUserMappedForm", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "StudyManagerService_Proxy.deleteUserMappedForm", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteUserMappedStudy(org.openxdata.server.admin.model.mapping.UserStudyMap userMappedStudy, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.deleteUserMappedStudy", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteUserMappedStudy");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.mapping.UserStudyMap/451157830");
      streamWriter.writeObject(userMappedStudy);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.deleteUserMappedStudy", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "StudyManagerService_Proxy.deleteUserMappedStudy", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getFormData(java.lang.Integer formDataId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.getFormData", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getFormData");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeObject(formDataId);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.getFormData", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "StudyManagerService_Proxy.getFormData", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getFormData(java.lang.Integer formDefId, java.lang.Integer userId, java.util.Date fromDate, java.util.Date toDate, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.getFormData", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getFormData");
      streamWriter.writeInt(4);
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeString("java.util.Date/1659716317");
      streamWriter.writeString("java.util.Date/1659716317");
      streamWriter.writeObject(formDefId);
      streamWriter.writeObject(userId);
      streamWriter.writeObject(fromDate);
      streamWriter.writeObject(toDate);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.getFormData", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "StudyManagerService_Proxy.getFormData", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getForms(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.getForms", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getForms");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.getForms", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "StudyManagerService_Proxy.getForms", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getStudies(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.getStudies", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getStudies");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.getStudies", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "StudyManagerService_Proxy.getStudies", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getUserMappedForms(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.getUserMappedForms", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getUserMappedForms");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.getUserMappedForms", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "StudyManagerService_Proxy.getUserMappedForms", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getUserMappedStudies(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.getUserMappedStudies", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getUserMappedStudies");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.getUserMappedStudies", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "StudyManagerService_Proxy.getUserMappedStudies", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void hasEditableData(org.openxdata.server.admin.model.Editable editable, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.hasEditableData", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("hasEditableData");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.Editable");
      streamWriter.writeObject(editable);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.hasEditableData", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "StudyManagerService_Proxy.hasEditableData", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveForm(org.openxdata.server.admin.model.FormDef formDef, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.saveForm", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveForm");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.FormDef/141965068");
      streamWriter.writeObject(formDef);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.saveForm", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "StudyManagerService_Proxy.saveForm", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveFormData(org.openxdata.server.admin.model.FormData formData, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.saveFormData", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveFormData");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.FormData/669483682");
      streamWriter.writeObject(formData);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.saveFormData", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "StudyManagerService_Proxy.saveFormData", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveStudy(org.openxdata.server.admin.model.StudyDef studyDef, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.saveStudy", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveStudy");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.StudyDef/2343592517");
      streamWriter.writeObject(studyDef);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.saveStudy", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "StudyManagerService_Proxy.saveStudy", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveUserMappedForm(org.openxdata.server.admin.model.mapping.UserFormMap userMappedForm, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.saveUserMappedForm", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveUserMappedForm");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.mapping.UserFormMap/4284888440");
      streamWriter.writeObject(userMappedForm);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.saveUserMappedForm", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "StudyManagerService_Proxy.saveUserMappedForm", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveUserMappedStudy(org.openxdata.server.admin.model.mapping.UserStudyMap userMappedStudy, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.saveUserMappedStudy", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveUserMappedStudy");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.mapping.UserStudyMap/451157830");
      streamWriter.writeObject(userMappedStudy);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("StudyManagerService_Proxy.saveUserMappedStudy", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "StudyManagerService_Proxy.saveUserMappedStudy", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
