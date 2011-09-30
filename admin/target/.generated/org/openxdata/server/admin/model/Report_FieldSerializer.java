package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class Report_FieldSerializer {
  private static native java.lang.String getDefinition(org.openxdata.server.admin.model.Report instance) /*-{
    return instance.@org.openxdata.server.admin.model.Report::definition;
  }-*/;
  
  private static native void  setDefinition(org.openxdata.server.admin.model.Report instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Report::definition = value;
  }-*/;
  
  private static native java.lang.String getDescription(org.openxdata.server.admin.model.Report instance) /*-{
    return instance.@org.openxdata.server.admin.model.Report::description;
  }-*/;
  
  private static native void  setDescription(org.openxdata.server.admin.model.Report instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Report::description = value;
  }-*/;
  
  private static native java.lang.Integer getFormDefVersionId(org.openxdata.server.admin.model.Report instance) /*-{
    return instance.@org.openxdata.server.admin.model.Report::formDefVersionId;
  }-*/;
  
  private static native void  setFormDefVersionId(org.openxdata.server.admin.model.Report instance, java.lang.Integer value) /*-{
    instance.@org.openxdata.server.admin.model.Report::formDefVersionId = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.server.admin.model.Report instance) /*-{
    return instance.@org.openxdata.server.admin.model.Report::name;
  }-*/;
  
  private static native void  setName(org.openxdata.server.admin.model.Report instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Report::name = value;
  }-*/;
  
  private static native java.lang.String getParamValues(org.openxdata.server.admin.model.Report instance) /*-{
    return instance.@org.openxdata.server.admin.model.Report::paramValues;
  }-*/;
  
  private static native void  setParamValues(org.openxdata.server.admin.model.Report instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Report::paramValues = value;
  }-*/;
  
  private static native java.lang.String getQueryDefinition(org.openxdata.server.admin.model.Report instance) /*-{
    return instance.@org.openxdata.server.admin.model.Report::queryDefinition;
  }-*/;
  
  private static native void  setQueryDefinition(org.openxdata.server.admin.model.Report instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Report::queryDefinition = value;
  }-*/;
  
  private static native java.lang.String getQuerySql(org.openxdata.server.admin.model.Report instance) /*-{
    return instance.@org.openxdata.server.admin.model.Report::querySql;
  }-*/;
  
  private static native void  setQuerySql(org.openxdata.server.admin.model.Report instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Report::querySql = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.ReportGroup getReportGroup(org.openxdata.server.admin.model.Report instance) /*-{
    return instance.@org.openxdata.server.admin.model.Report::reportGroup;
  }-*/;
  
  private static native void  setReportGroup(org.openxdata.server.admin.model.Report instance, org.openxdata.server.admin.model.ReportGroup value) /*-{
    instance.@org.openxdata.server.admin.model.Report::reportGroup = value;
  }-*/;
  
  private static native int getReportId(org.openxdata.server.admin.model.Report instance) /*-{
    return instance.@org.openxdata.server.admin.model.Report::reportId;
  }-*/;
  
  private static native void  setReportId(org.openxdata.server.admin.model.Report instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.Report::reportId = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.Report instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDefinition(instance, streamReader.readString());
    setDescription(instance, streamReader.readString());
    setFormDefVersionId(instance, (java.lang.Integer) streamReader.readObject());
    setName(instance, streamReader.readString());
    setParamValues(instance, streamReader.readString());
    setQueryDefinition(instance, streamReader.readString());
    setQuerySql(instance, streamReader.readString());
    setReportGroup(instance, (org.openxdata.server.admin.model.ReportGroup) streamReader.readObject());
    setReportId(instance, streamReader.readInt());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.Report instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.Report::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.Report instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getDefinition(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeObject(getFormDefVersionId(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getParamValues(instance));
    streamWriter.writeString(getQueryDefinition(instance));
    streamWriter.writeString(getQuerySql(instance));
    streamWriter.writeObject(getReportGroup(instance));
    streamWriter.writeInt(getReportId(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
