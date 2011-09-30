package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class ReportGroup_FieldSerializer {
  private static native java.lang.String getDescription(org.openxdata.server.admin.model.ReportGroup instance) /*-{
    return instance.@org.openxdata.server.admin.model.ReportGroup::description;
  }-*/;
  
  private static native void  setDescription(org.openxdata.server.admin.model.ReportGroup instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.ReportGroup::description = value;
  }-*/;
  
  private static native java.util.List getGroups(org.openxdata.server.admin.model.ReportGroup instance) /*-{
    return instance.@org.openxdata.server.admin.model.ReportGroup::groups;
  }-*/;
  
  private static native void  setGroups(org.openxdata.server.admin.model.ReportGroup instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.ReportGroup::groups = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.server.admin.model.ReportGroup instance) /*-{
    return instance.@org.openxdata.server.admin.model.ReportGroup::name;
  }-*/;
  
  private static native void  setName(org.openxdata.server.admin.model.ReportGroup instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.ReportGroup::name = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.ReportGroup getParentReportGroup(org.openxdata.server.admin.model.ReportGroup instance) /*-{
    return instance.@org.openxdata.server.admin.model.ReportGroup::parentReportGroup;
  }-*/;
  
  private static native void  setParentReportGroup(org.openxdata.server.admin.model.ReportGroup instance, org.openxdata.server.admin.model.ReportGroup value) /*-{
    instance.@org.openxdata.server.admin.model.ReportGroup::parentReportGroup = value;
  }-*/;
  
  private static native int getReportGroupId(org.openxdata.server.admin.model.ReportGroup instance) /*-{
    return instance.@org.openxdata.server.admin.model.ReportGroup::reportGroupId;
  }-*/;
  
  private static native void  setReportGroupId(org.openxdata.server.admin.model.ReportGroup instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.ReportGroup::reportGroupId = value;
  }-*/;
  
  private static native java.util.List getReports(org.openxdata.server.admin.model.ReportGroup instance) /*-{
    return instance.@org.openxdata.server.admin.model.ReportGroup::reports;
  }-*/;
  
  private static native void  setReports(org.openxdata.server.admin.model.ReportGroup instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.ReportGroup::reports = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.ReportGroup instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDescription(instance, streamReader.readString());
    setGroups(instance, (java.util.List) streamReader.readObject());
    setName(instance, streamReader.readString());
    setParentReportGroup(instance, (org.openxdata.server.admin.model.ReportGroup) streamReader.readObject());
    setReportGroupId(instance, streamReader.readInt());
    setReports(instance, (java.util.List) streamReader.readObject());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.ReportGroup instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.ReportGroup::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.ReportGroup instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeObject(getGroups(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getParentReportGroup(instance));
    streamWriter.writeInt(getReportGroupId(instance));
    streamWriter.writeObject(getReports(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
