package net.customware.gwt.dispatch.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class DispatchService_Proxy extends RemoteServiceProxy implements net.customware.gwt.dispatch.client.service.DispatchServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "net.customware.gwt.dispatch.client.service.DispatchService";
  private static final String SERIALIZATION_POLICY ="784D5469CE9BF8F73FB9B1D6A1C3A04A";
  private static final net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer SERIALIZER = new net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer();
  
  public DispatchService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "dispatch", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void execute(net.customware.gwt.dispatch.shared.Action action, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("DispatchService_Proxy.execute", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("execute");
      streamWriter.writeInt(1);
      streamWriter.writeString("net.customware.gwt.dispatch.shared.Action");
      streamWriter.writeObject(action);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("DispatchService_Proxy.execute", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "DispatchService_Proxy.execute", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
