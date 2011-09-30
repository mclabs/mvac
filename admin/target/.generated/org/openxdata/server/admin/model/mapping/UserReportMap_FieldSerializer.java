package org.openxdata.server.admin.model.mapping;

@SuppressWarnings("deprecation")
public class UserReportMap_FieldSerializer {
  private static native int getReportId(org.openxdata.server.admin.model.mapping.UserReportMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.mapping.UserReportMap::reportId;
  }-*/;
  
  private static native void  setReportId(org.openxdata.server.admin.model.mapping.UserReportMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.mapping.UserReportMap::reportId = value;
  }-*/;
  
  private static native int getUserId(org.openxdata.server.admin.model.mapping.UserReportMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.mapping.UserReportMap::userId;
  }-*/;
  
  private static native void  setUserId(org.openxdata.server.admin.model.mapping.UserReportMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.mapping.UserReportMap::userId = value;
  }-*/;
  
  private static native int getUserReportMapId(org.openxdata.server.admin.model.mapping.UserReportMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.mapping.UserReportMap::userReportMapId;
  }-*/;
  
  private static native void  setUserReportMapId(org.openxdata.server.admin.model.mapping.UserReportMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.mapping.UserReportMap::userReportMapId = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.mapping.UserReportMap instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setReportId(instance, streamReader.readInt());
    setUserId(instance, streamReader.readInt());
    setUserReportMapId(instance, streamReader.readInt());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.mapping.UserReportMap instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.mapping.UserReportMap::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.mapping.UserReportMap instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeInt(getReportId(instance));
    streamWriter.writeInt(getUserId(instance));
    streamWriter.writeInt(getUserReportMapId(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
