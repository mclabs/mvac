package org.openxdata.server.admin.model.mapping;

@SuppressWarnings("deprecation")
public class UserReportGroupMap_FieldSerializer {
  private static native int getReportGroupId(org.openxdata.server.admin.model.mapping.UserReportGroupMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.mapping.UserReportGroupMap::reportGroupId;
  }-*/;
  
  private static native void  setReportGroupId(org.openxdata.server.admin.model.mapping.UserReportGroupMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.mapping.UserReportGroupMap::reportGroupId = value;
  }-*/;
  
  private static native int getUserId(org.openxdata.server.admin.model.mapping.UserReportGroupMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.mapping.UserReportGroupMap::userId;
  }-*/;
  
  private static native void  setUserId(org.openxdata.server.admin.model.mapping.UserReportGroupMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.mapping.UserReportGroupMap::userId = value;
  }-*/;
  
  private static native int getUserReportGroupMapId(org.openxdata.server.admin.model.mapping.UserReportGroupMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.mapping.UserReportGroupMap::userReportGroupMapId;
  }-*/;
  
  private static native void  setUserReportGroupMapId(org.openxdata.server.admin.model.mapping.UserReportGroupMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.mapping.UserReportGroupMap::userReportGroupMapId = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.mapping.UserReportGroupMap instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setReportGroupId(instance, streamReader.readInt());
    setUserId(instance, streamReader.readInt());
    setUserReportGroupMapId(instance, streamReader.readInt());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.mapping.UserReportGroupMap instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.mapping.UserReportGroupMap::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.mapping.UserReportGroupMap instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeInt(getReportGroupId(instance));
    streamWriter.writeInt(getUserId(instance));
    streamWriter.writeInt(getUserReportGroupMapId(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
