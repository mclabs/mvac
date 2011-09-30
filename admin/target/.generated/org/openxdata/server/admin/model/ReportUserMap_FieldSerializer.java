package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class ReportUserMap_FieldSerializer {
  private static native int getReportId(org.openxdata.server.admin.model.ReportUserMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.ReportUserMap::reportId;
  }-*/;
  
  private static native void  setReportId(org.openxdata.server.admin.model.ReportUserMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.ReportUserMap::reportId = value;
  }-*/;
  
  private static native int getReportUserId(org.openxdata.server.admin.model.ReportUserMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.ReportUserMap::reportUserId;
  }-*/;
  
  private static native void  setReportUserId(org.openxdata.server.admin.model.ReportUserMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.ReportUserMap::reportUserId = value;
  }-*/;
  
  private static native int getUserId(org.openxdata.server.admin.model.ReportUserMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.ReportUserMap::userId;
  }-*/;
  
  private static native void  setUserId(org.openxdata.server.admin.model.ReportUserMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.ReportUserMap::userId = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.ReportUserMap instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setReportId(instance, streamReader.readInt());
    setReportUserId(instance, streamReader.readInt());
    setUserId(instance, streamReader.readInt());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.ReportUserMap instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.ReportUserMap::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.ReportUserMap instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeInt(getReportId(instance));
    streamWriter.writeInt(getReportUserId(instance));
    streamWriter.writeInt(getUserId(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
