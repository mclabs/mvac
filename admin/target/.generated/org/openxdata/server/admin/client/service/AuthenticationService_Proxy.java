package org.openxdata.server.admin.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class AuthenticationService_Proxy extends RemoteServiceProxy implements org.openxdata.server.admin.client.service.AuthenticationServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.openxdata.server.admin.client.service.AuthenticationService";
  private static final String SERIALIZATION_POLICY ="DCD2D208BFCF7B6F50C63F51BFB41C22";
  private static final org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer SERIALIZER = new org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer();
  
  public AuthenticationService_Proxy() {
    super(GWT.getModuleBaseURL(),
      null, 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void authenticate(java.lang.String username, java.lang.String password, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("AuthenticationService_Proxy.authenticate", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("authenticate");
      streamWriter.writeInt(2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(username);
      streamWriter.writeString(password);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("AuthenticationService_Proxy.authenticate", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "AuthenticationService_Proxy.authenticate", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void isValidUserPassword(java.lang.String username, java.lang.String password, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("AuthenticationService_Proxy.isValidUserPassword", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("isValidUserPassword");
      streamWriter.writeInt(2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(username);
      streamWriter.writeString(password);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("AuthenticationService_Proxy.isValidUserPassword", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "AuthenticationService_Proxy.isValidUserPassword", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
