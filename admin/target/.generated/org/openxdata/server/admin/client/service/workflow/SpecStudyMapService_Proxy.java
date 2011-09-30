package org.openxdata.server.admin.client.service.workflow;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class SpecStudyMapService_Proxy extends RemoteServiceProxy implements org.openxdata.server.admin.client.service.workflow.SpecStudyMapServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.openxdata.server.admin.client.service.workflow.SpecStudyMapService";
  private static final String SERIALIZATION_POLICY ="FB96A34790D62D5C5B24BD315B3F84FE";
  private static final org.openxdata.server.admin.client.service.workflow.SpecStudyMapService_TypeSerializer SERIALIZER = new org.openxdata.server.admin.client.service.workflow.SpecStudyMapService_TypeSerializer();
  
  public SpecStudyMapService_Proxy() {
    super(GWT.getModuleBaseURL(),
      null, 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void deleteSpecStudy(org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO mapDTO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.deleteSpecStudy", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteSpecStudy");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO/192434349");
      streamWriter.writeObject(mapDTO);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.deleteSpecStudy", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "SpecStudyMapService_Proxy.deleteSpecStudy", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteSpecStudyList(java.util.ArrayList mapDTOs, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.deleteSpecStudyList", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteSpecStudyList");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.util.ArrayList/3821976829");
      streamWriter.writeObject(mapDTOs);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.deleteSpecStudyList", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "SpecStudyMapService_Proxy.deleteSpecStudyList", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getAllMaps(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.getAllMaps", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getAllMaps");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.getAllMaps", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "SpecStudyMapService_Proxy.getAllMaps", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getEntireXMLMap(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.getEntireXMLMap", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getEntireXMLMap");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.getEntireXMLMap", requestId, "requestSerialized"));
      doInvoke(ResponseReader.STRING, "SpecStudyMapService_Proxy.getEntireXMLMap", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getMappedWorkItems(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.getMappedWorkItems", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getMappedWorkItems");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.getMappedWorkItems", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "SpecStudyMapService_Proxy.getMappedWorkItems", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveMaos(java.util.ArrayList dirtyMaps, java.util.ArrayList deletedMaps, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.saveMaos", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveMaos");
      streamWriter.writeInt(2);
      streamWriter.writeString("java.util.ArrayList/3821976829");
      streamWriter.writeString("java.util.ArrayList/3821976829");
      streamWriter.writeObject(dirtyMaps);
      streamWriter.writeObject(deletedMaps);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.saveMaos", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "SpecStudyMapService_Proxy.saveMaos", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveSpecStudyList(java.util.ArrayList maps, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.saveSpecStudyList", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveSpecStudyList");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.util.ArrayList/3821976829");
      streamWriter.writeObject(maps);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.saveSpecStudyList", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "SpecStudyMapService_Proxy.saveSpecStudyList", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveSpecStudyMap(org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO mapDTO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.saveSpecStudyMap", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveSpecStudyMap");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO/192434349");
      streamWriter.writeObject(mapDTO);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("SpecStudyMapService_Proxy.saveSpecStudyMap", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "SpecStudyMapService_Proxy.saveSpecStudyMap", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
