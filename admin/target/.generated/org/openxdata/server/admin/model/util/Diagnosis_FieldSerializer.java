package org.openxdata.server.admin.model.util;

@SuppressWarnings("deprecation")
public class Diagnosis_FieldSerializer {
  private static native org.openxdata.server.admin.model.util.DiagnosedStatus getDiagnosedStatus(org.openxdata.server.admin.model.util.Diagnosis instance) /*-{
    return instance.@org.openxdata.server.admin.model.util.Diagnosis::diagnosedStatus;
  }-*/;
  
  private static native void  setDiagnosedStatus(org.openxdata.server.admin.model.util.Diagnosis instance, org.openxdata.server.admin.model.util.DiagnosedStatus value) /*-{
    instance.@org.openxdata.server.admin.model.util.Diagnosis::diagnosedStatus = value;
  }-*/;
  
  private static native int getErrorCount(org.openxdata.server.admin.model.util.Diagnosis instance) /*-{
    return instance.@org.openxdata.server.admin.model.util.Diagnosis::errorCount;
  }-*/;
  
  private static native void  setErrorCount(org.openxdata.server.admin.model.util.Diagnosis instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.util.Diagnosis::errorCount = value;
  }-*/;
  
  private static native java.lang.String getLatestError(org.openxdata.server.admin.model.util.Diagnosis instance) /*-{
    return instance.@org.openxdata.server.admin.model.util.Diagnosis::latestError;
  }-*/;
  
  private static native void  setLatestError(org.openxdata.server.admin.model.util.Diagnosis instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.util.Diagnosis::latestError = value;
  }-*/;
  
  private static native java.lang.String getLogFileStream(org.openxdata.server.admin.model.util.Diagnosis instance) /*-{
    return instance.@org.openxdata.server.admin.model.util.Diagnosis::logFileStream;
  }-*/;
  
  private static native void  setLogFileStream(org.openxdata.server.admin.model.util.Diagnosis instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.util.Diagnosis::logFileStream = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.util.ErrorRiskLevel getRiskLevel(org.openxdata.server.admin.model.util.Diagnosis instance) /*-{
    return instance.@org.openxdata.server.admin.model.util.Diagnosis::riskLevel;
  }-*/;
  
  private static native void  setRiskLevel(org.openxdata.server.admin.model.util.Diagnosis instance, org.openxdata.server.admin.model.util.ErrorRiskLevel value) /*-{
    instance.@org.openxdata.server.admin.model.util.Diagnosis::riskLevel = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.util.Diagnosis instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDiagnosedStatus(instance, (org.openxdata.server.admin.model.util.DiagnosedStatus) streamReader.readObject());
    setErrorCount(instance, streamReader.readInt());
    setLatestError(instance, streamReader.readString());
    setLogFileStream(instance, streamReader.readString());
    setRiskLevel(instance, (org.openxdata.server.admin.model.util.ErrorRiskLevel) streamReader.readObject());
    
  }
  
  public static native org.openxdata.server.admin.model.util.Diagnosis instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.util.Diagnosis::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.util.Diagnosis instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getDiagnosedStatus(instance));
    streamWriter.writeInt(getErrorCount(instance));
    streamWriter.writeString(getLatestError(instance));
    streamWriter.writeString(getLogFileStream(instance));
    streamWriter.writeObject(getRiskLevel(instance));
    
  }
  
}
