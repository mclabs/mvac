package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class Permission_FieldSerializer {
  private static native java.lang.String getDescription(org.openxdata.server.admin.model.Permission instance) /*-{
    return instance.@org.openxdata.server.admin.model.Permission::description;
  }-*/;
  
  private static native void  setDescription(org.openxdata.server.admin.model.Permission instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Permission::description = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.server.admin.model.Permission instance) /*-{
    return instance.@org.openxdata.server.admin.model.Permission::name;
  }-*/;
  
  private static native void  setName(org.openxdata.server.admin.model.Permission instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Permission::name = value;
  }-*/;
  
  private static native int getPermissionId(org.openxdata.server.admin.model.Permission instance) /*-{
    return instance.@org.openxdata.server.admin.model.Permission::permissionId;
  }-*/;
  
  private static native void  setPermissionId(org.openxdata.server.admin.model.Permission instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.Permission::permissionId = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.Permission instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDescription(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setPermissionId(instance, streamReader.readInt());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.Permission instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.Permission::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.Permission instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeInt(getPermissionId(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
