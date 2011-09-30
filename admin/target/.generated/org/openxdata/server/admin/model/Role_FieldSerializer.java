package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class Role_FieldSerializer {
  private static native java.lang.String getDescription(org.openxdata.server.admin.model.Role instance) /*-{
    return instance.@org.openxdata.server.admin.model.Role::description;
  }-*/;
  
  private static native void  setDescription(org.openxdata.server.admin.model.Role instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Role::description = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.server.admin.model.Role instance) /*-{
    return instance.@org.openxdata.server.admin.model.Role::name;
  }-*/;
  
  private static native void  setName(org.openxdata.server.admin.model.Role instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.Role::name = value;
  }-*/;
  
  private static native java.util.List getPermissions(org.openxdata.server.admin.model.Role instance) /*-{
    return instance.@org.openxdata.server.admin.model.Role::permissions;
  }-*/;
  
  private static native void  setPermissions(org.openxdata.server.admin.model.Role instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.Role::permissions = value;
  }-*/;
  
  private static native int getRoleId(org.openxdata.server.admin.model.Role instance) /*-{
    return instance.@org.openxdata.server.admin.model.Role::roleId;
  }-*/;
  
  private static native void  setRoleId(org.openxdata.server.admin.model.Role instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.Role::roleId = value;
  }-*/;
  
  private static native java.util.List getUsers(org.openxdata.server.admin.model.Role instance) /*-{
    return instance.@org.openxdata.server.admin.model.Role::users;
  }-*/;
  
  private static native void  setUsers(org.openxdata.server.admin.model.Role instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.Role::users = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.Role instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDescription(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setPermissions(instance, (java.util.List) streamReader.readObject());
    setRoleId(instance, streamReader.readInt());
    setUsers(instance, (java.util.List) streamReader.readObject());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.Role instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.Role::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.Role instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getPermissions(instance));
    streamWriter.writeInt(getRoleId(instance));
    streamWriter.writeObject(getUsers(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
