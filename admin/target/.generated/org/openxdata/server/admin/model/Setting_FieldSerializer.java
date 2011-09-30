package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class Setting_FieldSerializer {
  private static native java.lang.String getDescription(org.openxdata.server.admin.model.Setting instance) /*-{
    return instance.@org.openxdata.server.admin.model.Setting::description;
  }-*/;
  
  private static native void  setDescription(org.openxdata.server.admin.model.Setting instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Setting::description = value;
  }-*/;
  
  private static native int getId(org.openxdata.server.admin.model.Setting instance) /*-{
    return instance.@org.openxdata.server.admin.model.Setting::id;
  }-*/;
  
  private static native void  setId(org.openxdata.server.admin.model.Setting instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.Setting::id = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.server.admin.model.Setting instance) /*-{
    return instance.@org.openxdata.server.admin.model.Setting::name;
  }-*/;
  
  private static native void  setName(org.openxdata.server.admin.model.Setting instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Setting::name = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.SettingGroup getSettingGroup(org.openxdata.server.admin.model.Setting instance) /*-{
    return instance.@org.openxdata.server.admin.model.Setting::settingGroup;
  }-*/;
  
  private static native void  setSettingGroup(org.openxdata.server.admin.model.Setting instance, org.openxdata.server.admin.model.SettingGroup value) /*-{
    instance.@org.openxdata.server.admin.model.Setting::settingGroup = value;
  }-*/;
  
  private static native java.lang.String getValue(org.openxdata.server.admin.model.Setting instance) /*-{
    return instance.@org.openxdata.server.admin.model.Setting::value;
  }-*/;
  
  private static native void  setValue(org.openxdata.server.admin.model.Setting instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Setting::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.Setting instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDescription(instance, streamReader.readString());
    setId(instance, streamReader.readInt());
    setName(instance, streamReader.readString());
    setSettingGroup(instance, (org.openxdata.server.admin.model.SettingGroup) streamReader.readObject());
    setValue(instance, streamReader.readString());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.Setting instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.Setting::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.Setting instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeInt(getId(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getSettingGroup(instance));
    streamWriter.writeString(getValue(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
