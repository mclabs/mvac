package org.openxdata.server.admin.model.exception;

@SuppressWarnings("deprecation")
public class OpenXDataDisabledUserException_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    org.openxdata.server.admin.model.exception.OpenXDataSecurityException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    org.openxdata.server.admin.model.exception.OpenXDataSecurityException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
