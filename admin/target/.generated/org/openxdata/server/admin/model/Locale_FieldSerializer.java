package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class Locale_FieldSerializer {
  private static native java.lang.String getKey(org.openxdata.server.admin.model.Locale instance) /*-{
    return instance.@org.openxdata.server.admin.model.Locale::key;
  }-*/;
  
  private static native void  setKey(org.openxdata.server.admin.model.Locale instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Locale::key = value;
  }-*/;
  
  private static native int getLocaleId(org.openxdata.server.admin.model.Locale instance) /*-{
    return instance.@org.openxdata.server.admin.model.Locale::localeId;
  }-*/;
  
  private static native void  setLocaleId(org.openxdata.server.admin.model.Locale instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.Locale::localeId = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.server.admin.model.Locale instance) /*-{
    return instance.@org.openxdata.server.admin.model.Locale::name;
  }-*/;
  
  private static native void  setName(org.openxdata.server.admin.model.Locale instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Locale::name = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.Locale instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setKey(instance, streamReader.readString());
    setLocaleId(instance, streamReader.readInt());
    setName(instance, streamReader.readString());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.Locale instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.Locale::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.Locale instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getKey(instance));
    streamWriter.writeInt(getLocaleId(instance));
    streamWriter.writeString(getName(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
