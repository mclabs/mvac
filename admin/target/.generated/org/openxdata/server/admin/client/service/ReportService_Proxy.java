package org.openxdata.server.admin.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class ReportService_Proxy extends RemoteServiceProxy implements org.openxdata.server.admin.client.service.ReportServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.openxdata.server.admin.client.service.ReportService";
  private static final String SERIALIZATION_POLICY ="072D597F0EAA703501C26E36D269F42C";
  private static final org.openxdata.server.admin.client.service.ReportService_TypeSerializer SERIALIZER = new org.openxdata.server.admin.client.service.ReportService_TypeSerializer();
  
  public ReportService_Proxy() {
    super(GWT.getModuleBaseURL(),
      null, 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void deleteReport(org.openxdata.server.admin.model.Report report, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.deleteReport", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteReport");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.Report/2003074756");
      streamWriter.writeObject(report);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.deleteReport", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "ReportService_Proxy.deleteReport", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteReportGroup(org.openxdata.server.admin.model.ReportGroup reportGroup, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.deleteReportGroup", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteReportGroup");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.ReportGroup/74344348");
      streamWriter.writeObject(reportGroup);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.deleteReportGroup", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "ReportService_Proxy.deleteReportGroup", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteUserMappedReport(org.openxdata.server.admin.model.mapping.UserReportMap userReportMap, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.deleteUserMappedReport", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteUserMappedReport");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.mapping.UserReportMap/3581611453");
      streamWriter.writeObject(userReportMap);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.deleteUserMappedReport", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "ReportService_Proxy.deleteUserMappedReport", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteUserMappedReportGroup(org.openxdata.server.admin.model.mapping.UserReportGroupMap userReportGroupMap, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.deleteUserMappedReportGroup", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("deleteUserMappedReportGroup");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.mapping.UserReportGroupMap/4053001426");
      streamWriter.writeObject(userReportGroupMap);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.deleteUserMappedReportGroup", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "ReportService_Proxy.deleteUserMappedReportGroup", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getReportData(org.openxdata.server.admin.model.Report report, java.lang.String format, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.getReportData", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getReportData");
      streamWriter.writeInt(2);
      streamWriter.writeString("org.openxdata.server.admin.model.Report/2003074756");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(report);
      streamWriter.writeString(format);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.getReportData", requestId, "requestSerialized"));
      doInvoke(ResponseReader.STRING, "ReportService_Proxy.getReportData", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getReports(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.getReports", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getReports");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.getReports", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ReportService_Proxy.getReports", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getUserMappedReportGroups(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.getUserMappedReportGroups", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getUserMappedReportGroups");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.getUserMappedReportGroups", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ReportService_Proxy.getUserMappedReportGroups", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getUserMappedReports(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.getUserMappedReports", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getUserMappedReports");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.getUserMappedReports", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "ReportService_Proxy.getUserMappedReports", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveReport(org.openxdata.server.admin.model.Report report, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.saveReport", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveReport");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.Report/2003074756");
      streamWriter.writeObject(report);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.saveReport", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "ReportService_Proxy.saveReport", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveReportGroup(org.openxdata.server.admin.model.ReportGroup reportGroup, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.saveReportGroup", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveReportGroup");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.ReportGroup/74344348");
      streamWriter.writeObject(reportGroup);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.saveReportGroup", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "ReportService_Proxy.saveReportGroup", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveUserMappedReport(org.openxdata.server.admin.model.mapping.UserReportMap userReportMap, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.saveUserMappedReport", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveUserMappedReport");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.mapping.UserReportMap/3581611453");
      streamWriter.writeObject(userReportMap);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.saveUserMappedReport", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "ReportService_Proxy.saveUserMappedReport", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveUserMappedReportGroup(org.openxdata.server.admin.model.mapping.UserReportGroupMap userReportGroupMap, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.saveUserMappedReportGroup", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("saveUserMappedReportGroup");
      streamWriter.writeInt(1);
      streamWriter.writeString("org.openxdata.server.admin.model.mapping.UserReportGroupMap/4053001426");
      streamWriter.writeObject(userReportGroupMap);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("ReportService_Proxy.saveUserMappedReportGroup", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "ReportService_Proxy.saveUserMappedReportGroup", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
