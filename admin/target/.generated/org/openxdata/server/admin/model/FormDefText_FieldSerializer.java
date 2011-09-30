package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class FormDefText_FieldSerializer {
  private static native java.lang.String getDescription(org.openxdata.server.admin.model.FormDefText instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefText::description;
  }-*/;
  
  private static native void  setDescription(org.openxdata.server.admin.model.FormDefText instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefText::description = value;
  }-*/;
  
  private static native int getFormId(org.openxdata.server.admin.model.FormDefText instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefText::formId;
  }-*/;
  
  private static native void  setFormId(org.openxdata.server.admin.model.FormDefText instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefText::formId = value;
  }-*/;
  
  private static native int getFormTextId(org.openxdata.server.admin.model.FormDefText instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefText::formTextId;
  }-*/;
  
  private static native void  setFormTextId(org.openxdata.server.admin.model.FormDefText instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefText::formTextId = value;
  }-*/;
  
  private static native java.lang.String getLocaleKey(org.openxdata.server.admin.model.FormDefText instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefText::localeKey;
  }-*/;
  
  private static native void  setLocaleKey(org.openxdata.server.admin.model.FormDefText instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefText::localeKey = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.server.admin.model.FormDefText instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefText::name;
  }-*/;
  
  private static native void  setName(org.openxdata.server.admin.model.FormDefText instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefText::name = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.FormDefText instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDescription(instance, streamReader.readString());
    setFormId(instance, streamReader.readInt());
    setFormTextId(instance, streamReader.readInt());
    setLocaleKey(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.FormDefText instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.FormDefText::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.FormDefText instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeInt(getFormId(instance));
    streamWriter.writeInt(getFormTextId(instance));
    streamWriter.writeString(getLocaleKey(instance));
    streamWriter.writeString(getName(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
