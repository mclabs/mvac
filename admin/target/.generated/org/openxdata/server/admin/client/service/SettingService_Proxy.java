package org.openxdata.server.admin.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class SettingService_Proxy extends RemoteServiceProxy implements org.openxdata.server.admin.client.service.SettingServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.openxdata.server.admin.client.service.SettingService";
  private static final String SERIALIZATION_POLICY ="D94014F88C4460A7EE4C140697779ACF";
  private static final org.openxdata.server.admin.client.service.SettingService_TypeSerializer SERIALIZER = new org.openxdata.server.admin.client.service.SettingService_TypeSerializer();
  
  public SettingService_Proxy() {
    super(GWT.getModuleBaseURL(),
      null, 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void deleteSetting(org.openxdata.server.admin.model.Setting setting, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SettingService_Proxy.deleteSetting", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteSetting");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.Setting/2518311461");
      streamWriter.writeObject(setting);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SettingService_Proxy.deleteSetting", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "SettingService_Proxy.deleteSetting", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteSettingGroup(org.openxdata.server.admin.model.SettingGroup settingGroup, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SettingService_Proxy.deleteSettingGroup", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteSettingGroup");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.SettingGroup/3809470920");
      streamWriter.writeObject(settingGroup);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SettingService_Proxy.deleteSettingGroup", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "SettingService_Proxy.deleteSettingGroup", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getSetting(java.lang.String name, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SettingService_Proxy.getSetting", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getSetting");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(name);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SettingService_Proxy.getSetting", requestId, "requestSerialized"));
      doInvoke(ResponseReader.STRING, "SettingService_Proxy.getSetting", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getSettings(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SettingService_Proxy.getSettings", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getSettings");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SettingService_Proxy.getSettings", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "SettingService_Proxy.getSettings", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveSetting(org.openxdata.server.admin.model.Setting setting, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SettingService_Proxy.saveSetting", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveSetting");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.Setting/2518311461");
      streamWriter.writeObject(setting);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SettingService_Proxy.saveSetting", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "SettingService_Proxy.saveSetting", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveSettingGroup(org.openxdata.server.admin.model.SettingGroup settingGroup, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SettingService_Proxy.saveSettingGroup", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveSettingGroup");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.SettingGroup/3809470920");
      streamWriter.writeObject(settingGroup);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SettingService_Proxy.saveSettingGroup", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "SettingService_Proxy.saveSettingGroup", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
