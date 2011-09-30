package org.openxdata.server.admin.model.exception;

@SuppressWarnings("deprecation")
public class UserNotFoundException_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.exception.UserNotFoundException instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    org.openxdata.server.admin.model.exception.OpenXDataException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.exception.UserNotFoundException instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.exception.UserNotFoundException::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.exception.UserNotFoundException instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    org.openxdata.server.admin.model.exception.OpenXDataException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
