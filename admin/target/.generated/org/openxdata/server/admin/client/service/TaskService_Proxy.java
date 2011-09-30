package org.openxdata.server.admin.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class TaskService_Proxy extends RemoteServiceProxy implements org.openxdata.server.admin.client.service.TaskServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.openxdata.server.admin.client.service.TaskService";
  private static final String SERIALIZATION_POLICY ="0DD69F9D1289652EFAEA6878EF9726DF";
  private static final org.openxdata.server.admin.client.service.TaskService_TypeSerializer SERIALIZER = new org.openxdata.server.admin.client.service.TaskService_TypeSerializer();
  
  public TaskService_Proxy() {
    super(GWT.getModuleBaseURL(),
      null, 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void deleteTask(org.openxdata.server.admin.model.TaskDef task, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("TaskService_Proxy.deleteTask", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteTask");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.TaskDef/636505884");
      streamWriter.writeObject(task);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("TaskService_Proxy.deleteTask", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "TaskService_Proxy.deleteTask", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getTasks(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("TaskService_Proxy.getTasks", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getTasks");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("TaskService_Proxy.getTasks", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "TaskService_Proxy.getTasks", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveTask(org.openxdata.server.admin.model.TaskDef task, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("TaskService_Proxy.saveTask", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveTask");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.TaskDef/636505884");
      streamWriter.writeObject(task);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("TaskService_Proxy.saveTask", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "TaskService_Proxy.saveTask", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void startTask(org.openxdata.server.admin.model.TaskDef task, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("TaskService_Proxy.startTask", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("startTask");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.TaskDef/636505884");
      streamWriter.writeObject(task);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("TaskService_Proxy.startTask", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "TaskService_Proxy.startTask", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void stopTask(org.openxdata.server.admin.model.TaskDef task, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("TaskService_Proxy.stopTask", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("stopTask");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.TaskDef/636505884");
      streamWriter.writeObject(task);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("TaskService_Proxy.stopTask", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "TaskService_Proxy.stopTask", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
