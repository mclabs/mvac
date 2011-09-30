package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class StudyUserMap_FieldSerializer {
  private static native int getStudyId(org.openxdata.server.admin.model.StudyUserMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyUserMap::studyId;
  }-*/;
  
  private static native void  setStudyId(org.openxdata.server.admin.model.StudyUserMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.StudyUserMap::studyId = value;
  }-*/;
  
  private static native int getStudyUserId(org.openxdata.server.admin.model.StudyUserMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyUserMap::studyUserId;
  }-*/;
  
  private static native void  setStudyUserId(org.openxdata.server.admin.model.StudyUserMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.StudyUserMap::studyUserId = value;
  }-*/;
  
  private static native int getUserId(org.openxdata.server.admin.model.StudyUserMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyUserMap::userId;
  }-*/;
  
  private static native void  setUserId(org.openxdata.server.admin.model.StudyUserMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.StudyUserMap::userId = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.StudyUserMap instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setStudyId(instance, streamReader.readInt());
    setStudyUserId(instance, streamReader.readInt());
    setUserId(instance, streamReader.readInt());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.StudyUserMap instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.StudyUserMap::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.StudyUserMap instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeInt(getStudyId(instance));
    streamWriter.writeInt(getStudyUserId(instance));
    streamWriter.writeInt(getUserId(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
