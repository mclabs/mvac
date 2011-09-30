package org.openxdata.server.admin.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class UserService_Proxy extends RemoteServiceProxy implements org.openxdata.server.admin.client.service.UserServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.openxdata.server.admin.client.service.UserService";
  private static final String SERIALIZATION_POLICY ="9D4C19CB9F73CEC67290C7E352DA47F9";
  private static final org.openxdata.server.admin.client.service.UserService_TypeSerializer SERIALIZER = new org.openxdata.server.admin.client.service.UserService_TypeSerializer();
  
  public UserService_Proxy() {
    super(GWT.getModuleBaseURL(),
      null, 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void checkIfUserChangedPassword(org.openxdata.server.admin.model.User user, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UserService_Proxy.checkIfUserChangedPassword", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("checkIfUserChangedPassword");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.User/2493671347");
      streamWriter.writeObject(user);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UserService_Proxy.checkIfUserChangedPassword", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UserService_Proxy.checkIfUserChangedPassword", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteUser(org.openxdata.server.admin.model.User user, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UserService_Proxy.deleteUser", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteUser");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.User/2493671347");
      streamWriter.writeObject(user);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UserService_Proxy.deleteUser", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "UserService_Proxy.deleteUser", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getUser(java.lang.String username, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UserService_Proxy.getUser", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getUser");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(username);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UserService_Proxy.getUser", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UserService_Proxy.getUser", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getUsers(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UserService_Proxy.getUsers", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getUsers");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UserService_Proxy.getUsers", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "UserService_Proxy.getUsers", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void logout(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UserService_Proxy.logout", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("logout");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UserService_Proxy.logout", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "UserService_Proxy.logout", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveUser(org.openxdata.server.admin.model.User user, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("UserService_Proxy.saveUser", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveUser");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.User/2493671347");
      streamWriter.writeObject(user);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("UserService_Proxy.saveUser", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "UserService_Proxy.saveUser", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
