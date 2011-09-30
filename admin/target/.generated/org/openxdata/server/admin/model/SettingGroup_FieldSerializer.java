package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class SettingGroup_FieldSerializer {
  private static native java.lang.String getDescription(org.openxdata.server.admin.model.SettingGroup instance) /*-{
    return instance.@org.openxdata.server.admin.model.SettingGroup::description;
  }-*/;
  
  private static native void  setDescription(org.openxdata.server.admin.model.SettingGroup instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.SettingGroup::description = value;
  }-*/;
  
  private static native java.util.List getGroups(org.openxdata.server.admin.model.SettingGroup instance) /*-{
    return instance.@org.openxdata.server.admin.model.SettingGroup::groups;
  }-*/;
  
  private static native void  setGroups(org.openxdata.server.admin.model.SettingGroup instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.SettingGroup::groups = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.server.admin.model.SettingGroup instance) /*-{
    return instance.@org.openxdata.server.admin.model.SettingGroup::name;
  }-*/;
  
  private static native void  setName(org.openxdata.server.admin.model.SettingGroup instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.SettingGroup::name = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.SettingGroup getParentSettingGroup(org.openxdata.server.admin.model.SettingGroup instance) /*-{
    return instance.@org.openxdata.server.admin.model.SettingGroup::parentSettingGroup;
  }-*/;
  
  private static native void  setParentSettingGroup(org.openxdata.server.admin.model.SettingGroup instance, org.openxdata.server.admin.model.SettingGroup value) /*-{
    instance.@org.openxdata.server.admin.model.SettingGroup::parentSettingGroup = value;
  }-*/;
  
  private static native int getSettingGroupId(org.openxdata.server.admin.model.SettingGroup instance) /*-{
    return instance.@org.openxdata.server.admin.model.SettingGroup::settingGroupId;
  }-*/;
  
  private static native void  setSettingGroupId(org.openxdata.server.admin.model.SettingGroup instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.SettingGroup::settingGroupId = value;
  }-*/;
  
  private static native java.util.List getSettings(org.openxdata.server.admin.model.SettingGroup instance) /*-{
    return instance.@org.openxdata.server.admin.model.SettingGroup::settings;
  }-*/;
  
  private static native void  setSettings(org.openxdata.server.admin.model.SettingGroup instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.SettingGroup::settings = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.SettingGroup instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDescription(instance, streamReader.readString());
    setGroups(instance, (java.util.List) streamReader.readObject());
    setName(instance, streamReader.readString());
    setParentSettingGroup(instance, (org.openxdata.server.admin.model.SettingGroup) streamReader.readObject());
    setSettingGroupId(instance, streamReader.readInt());
    setSettings(instance, (java.util.List) streamReader.readObject());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.SettingGroup instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.SettingGroup::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.SettingGroup instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeObject(getGroups(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getParentSettingGroup(instance));
    streamWriter.writeInt(getSettingGroupId(instance));
    streamWriter.writeObject(getSettings(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
