package org.openxdata.server.admin.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class UtilityService_Proxy extends RemoteServiceProxy implements org.openxdata.server.admin.client.service.UtilityServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.openxdata.server.admin.client.service.UtilityService";
  private static final String SERIALIZATION_POLICY ="6FEA30EA72157C16C22FC4555DEDC989";
  private static final org.openxdata.server.admin.client.service.UtilityService_TypeSerializer SERIALIZER = new org.openxdata.server.admin.client.service.UtilityService_TypeSerializer();
  
  public UtilityService_Proxy() {
    super(GWT.getModuleBaseURL(),
      null, 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void checkIfPasswordsMatchOnAdministrator(java.lang.String username, java.lang.String password, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.checkIfPasswordsMatchOnAdministrator", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("checkIfPasswordsMatchOnAdministrator");
      streamWriter.writeInt(2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(username);
      streamWriter.writeString(password);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.checkIfPasswordsMatchOnAdministrator", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UtilityService_Proxy.checkIfPasswordsMatchOnAdministrator", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void clearLogFiles(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.clearLogFiles", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("clearLogFiles");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.clearLogFiles", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "UtilityService_Proxy.clearLogFiles", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteLocale(org.openxdata.server.admin.model.Locale locale, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.deleteLocale", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteLocale");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.Locale/511307334");
      streamWriter.writeObject(locale);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.deleteLocale", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "UtilityService_Proxy.deleteLocale", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getLocales(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.getLocales", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getLocales");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.getLocales", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UtilityService_Proxy.getLocales", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getLogFileProcessedOutput(java.lang.String logFilePath, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.getLogFileProcessedOutput", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getLogFileProcessedOutput");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(logFilePath);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.getLogFileProcessedOutput", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UtilityService_Proxy.getLogFileProcessedOutput", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getMobileMenuText(java.lang.String locale, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.getMobileMenuText", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getMobileMenuText");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(locale);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.getMobileMenuText", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UtilityService_Proxy.getMobileMenuText", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void installMobileApp(java.util.List phonenos, java.lang.String url, java.lang.String modemComPort, int modemBaudRate, java.lang.String promptText, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.installMobileApp", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("installMobileApp");
      streamWriter.writeInt(5);
      streamWriter.writeString("java.util.List");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("I");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(phonenos);
      streamWriter.writeString(url);
      streamWriter.writeString(modemComPort);
      streamWriter.writeInt(modemBaudRate);
      streamWriter.writeString(promptText);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.installMobileApp", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UtilityService_Proxy.installMobileApp", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveLocale(java.util.List locales, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.saveLocale", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveLocale");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.util.List");
      streamWriter.writeObject(locales);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.saveLocale", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "UtilityService_Proxy.saveLocale", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveMobileMenuText(java.util.List mobileMenuText, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.saveMobileMenuText", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveMobileMenuText");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.util.List");
      streamWriter.writeObject(mobileMenuText);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.saveMobileMenuText", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "UtilityService_Proxy.saveMobileMenuText", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void sendEmail(org.openxdata.server.admin.model.util.OpenXDataEmail email, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.sendEmail", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("sendEmail");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.util.OpenXDataEmail/1832342926");
      streamWriter.writeObject(email);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UtilityService_Proxy.sendEmail", requestId, "requestSerialized"));
      doInvoke(ResponseReader.BOOLEAN, "UtilityService_Proxy.sendEmail", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
