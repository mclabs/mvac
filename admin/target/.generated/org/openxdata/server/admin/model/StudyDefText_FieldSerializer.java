package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class StudyDefText_FieldSerializer {
  private static native java.lang.String getDescription(org.openxdata.server.admin.model.StudyDefText instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDefText::description;
  }-*/;
  
  private static native void  setDescription(org.openxdata.server.admin.model.StudyDefText instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDefText::description = value;
  }-*/;
  
  private static native java.lang.String getLocaleKey(org.openxdata.server.admin.model.StudyDefText instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDefText::localeKey;
  }-*/;
  
  private static native void  setLocaleKey(org.openxdata.server.admin.model.StudyDefText instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDefText::localeKey = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.server.admin.model.StudyDefText instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDefText::name;
  }-*/;
  
  private static native void  setName(org.openxdata.server.admin.model.StudyDefText instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDefText::name = value;
  }-*/;
  
  private static native int getStudyId(org.openxdata.server.admin.model.StudyDefText instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDefText::studyId;
  }-*/;
  
  private static native void  setStudyId(org.openxdata.server.admin.model.StudyDefText instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDefText::studyId = value;
  }-*/;
  
  private static native int getStudyTextId(org.openxdata.server.admin.model.StudyDefText instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDefText::studyTextId;
  }-*/;
  
  private static native void  setStudyTextId(org.openxdata.server.admin.model.StudyDefText instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDefText::studyTextId = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.StudyDefText instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDescription(instance, streamReader.readString());
    setLocaleKey(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setStudyId(instance, streamReader.readInt());
    setStudyTextId(instance, streamReader.readInt());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.StudyDefText instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.StudyDefText::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.StudyDefText instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getLocaleKey(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeInt(getStudyId(instance));
    streamWriter.writeInt(getStudyTextId(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
