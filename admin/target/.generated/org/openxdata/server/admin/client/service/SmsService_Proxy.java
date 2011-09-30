package org.openxdata.server.admin.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class SmsService_Proxy extends RemoteServiceProxy implements org.openxdata.server.admin.client.service.SmsServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.openxdata.server.admin.client.service.SmsService";
  private static final String SERIALIZATION_POLICY ="051C689E5FE1420DFD0AC6D6DF617576";
  private static final org.openxdata.server.admin.client.service.SmsService_TypeSerializer SERIALIZER = new org.openxdata.server.admin.client.service.SmsService_TypeSerializer();
  
  public SmsService_Proxy() {
    super(GWT.getModuleBaseURL(),
      null, 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void getFormSmsArchives(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SmsService_Proxy.getFormSmsArchives", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getFormSmsArchives");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SmsService_Proxy.getFormSmsArchives", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "SmsService_Proxy.getFormSmsArchives", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
