package org.openxdata.server.admin.client.service.workflow;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class SpecificationService_Proxy extends RemoteServiceProxy implements org.openxdata.server.admin.client.service.workflow.SpecificationServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.openxdata.server.admin.client.service.workflow.SpecificationService";
  private static final String SERIALIZATION_POLICY ="358BDF56373CBD2F30B50E4561576063";
  private static final org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer SERIALIZER = new org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer();
  
  public SpecificationService_Proxy() {
    super(GWT.getModuleBaseURL(),
      null, 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void getOSpecifications(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SpecificationService_Proxy.getOSpecifications", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getOSpecifications");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SpecificationService_Proxy.getOSpecifications", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "SpecificationService_Proxy.getOSpecifications", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
