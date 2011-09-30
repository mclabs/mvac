package org.openxdata.server.admin.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class RoleService_Proxy extends RemoteServiceProxy implements org.openxdata.server.admin.client.service.RoleServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.openxdata.server.admin.client.service.RoleService";
  private static final String SERIALIZATION_POLICY ="07B8F976FE46570592BB22925C44BD9F";
  private static final org.openxdata.server.admin.client.service.RoleService_TypeSerializer SERIALIZER = new org.openxdata.server.admin.client.service.RoleService_TypeSerializer();
  
  public RoleService_Proxy() {
    super(GWT.getModuleBaseURL(),
      null, 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void deletePermission(org.openxdata.server.admin.model.Permission permission, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("RoleService_Proxy.deletePermission", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deletePermission");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.Permission/3900349777");
      streamWriter.writeObject(permission);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("RoleService_Proxy.deletePermission", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "RoleService_Proxy.deletePermission", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteRole(org.openxdata.server.admin.model.Role role, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("RoleService_Proxy.deleteRole", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteRole");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.Role/4048295481");
      streamWriter.writeObject(role);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("RoleService_Proxy.deleteRole", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "RoleService_Proxy.deleteRole", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getPermissions(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("RoleService_Proxy.getPermissions", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getPermissions");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("RoleService_Proxy.getPermissions", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "RoleService_Proxy.getPermissions", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getRoles(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("RoleService_Proxy.getRoles", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getRoles");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("RoleService_Proxy.getRoles", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "RoleService_Proxy.getRoles", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void savePermission(org.openxdata.server.admin.model.Permission permission, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("RoleService_Proxy.savePermission", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("savePermission");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.Permission/3900349777");
      streamWriter.writeObject(permission);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("RoleService_Proxy.savePermission", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "RoleService_Proxy.savePermission", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveRole(org.openxdata.server.admin.model.Role role, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("RoleService_Proxy.saveRole", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveRole");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.Role/4048295481");
      streamWriter.writeObject(role);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("RoleService_Proxy.saveRole", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "RoleService_Proxy.saveRole", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
