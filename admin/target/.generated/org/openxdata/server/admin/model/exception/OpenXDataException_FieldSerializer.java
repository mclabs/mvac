package org.openxdata.server.admin.model.exception;

@SuppressWarnings("deprecation")
public class OpenXDataException_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.exception.OpenXDataException instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.exception.OpenXDataException instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.exception.OpenXDataException::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.exception.OpenXDataException instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
