package org.openxdata.server.admin.model.exception;

@SuppressWarnings("deprecation")
public class OpenXdataDataAccessException_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.exception.OpenXdataDataAccessException instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    org.openxdata.server.admin.model.exception.OpenXDataRuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.exception.OpenXdataDataAccessException instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.exception.OpenXdataDataAccessException::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.exception.OpenXdataDataAccessException instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    org.openxdata.server.admin.model.exception.OpenXDataRuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
