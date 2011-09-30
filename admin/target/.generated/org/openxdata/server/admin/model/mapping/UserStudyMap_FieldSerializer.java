package org.openxdata.server.admin.model.mapping;

@SuppressWarnings("deprecation")
public class UserStudyMap_FieldSerializer {
  private static native int getStudyId(org.openxdata.server.admin.model.mapping.UserStudyMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.mapping.UserStudyMap::studyId;
  }-*/;
  
  private static native void  setStudyId(org.openxdata.server.admin.model.mapping.UserStudyMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.mapping.UserStudyMap::studyId = value;
  }-*/;
  
  private static native int getUserId(org.openxdata.server.admin.model.mapping.UserStudyMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.mapping.UserStudyMap::userId;
  }-*/;
  
  private static native void  setUserId(org.openxdata.server.admin.model.mapping.UserStudyMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.mapping.UserStudyMap::userId = value;
  }-*/;
  
  private static native int getUserStudyMapId(org.openxdata.server.admin.model.mapping.UserStudyMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.mapping.UserStudyMap::userStudyMapId;
  }-*/;
  
  private static native void  setUserStudyMapId(org.openxdata.server.admin.model.mapping.UserStudyMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.mapping.UserStudyMap::userStudyMapId = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.mapping.UserStudyMap instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setStudyId(instance, streamReader.readInt());
    setUserId(instance, streamReader.readInt());
    setUserStudyMapId(instance, streamReader.readInt());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.mapping.UserStudyMap instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.mapping.UserStudyMap::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.mapping.UserStudyMap instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeInt(getStudyId(instance));
    streamWriter.writeInt(getUserId(instance));
    streamWriter.writeInt(getUserStudyMapId(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
