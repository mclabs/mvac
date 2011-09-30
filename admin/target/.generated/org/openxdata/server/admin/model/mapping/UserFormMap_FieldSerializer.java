package org.openxdata.server.admin.model.mapping;

@SuppressWarnings("deprecation")
public class UserFormMap_FieldSerializer {
  private static native int getFormId(org.openxdata.server.admin.model.mapping.UserFormMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.mapping.UserFormMap::formId;
  }-*/;
  
  private static native void  setFormId(org.openxdata.server.admin.model.mapping.UserFormMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.mapping.UserFormMap::formId = value;
  }-*/;
  
  private static native int getUserFormMapId(org.openxdata.server.admin.model.mapping.UserFormMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.mapping.UserFormMap::userFormMapId;
  }-*/;
  
  private static native void  setUserFormMapId(org.openxdata.server.admin.model.mapping.UserFormMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.mapping.UserFormMap::userFormMapId = value;
  }-*/;
  
  private static native int getUserId(org.openxdata.server.admin.model.mapping.UserFormMap instance) /*-{
    return instance.@org.openxdata.server.admin.model.mapping.UserFormMap::userId;
  }-*/;
  
  private static native void  setUserId(org.openxdata.server.admin.model.mapping.UserFormMap instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.mapping.UserFormMap::userId = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.mapping.UserFormMap instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setFormId(instance, streamReader.readInt());
    setUserFormMapId(instance, streamReader.readInt());
    setUserId(instance, streamReader.readInt());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.mapping.UserFormMap instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.mapping.UserFormMap::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.mapping.UserFormMap instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeInt(getFormId(instance));
    streamWriter.writeInt(getUserFormMapId(instance));
    streamWriter.writeInt(getUserId(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
