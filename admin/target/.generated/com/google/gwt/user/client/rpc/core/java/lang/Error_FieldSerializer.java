package com.google.gwt.user.client.rpc.core.java.lang;

@SuppressWarnings("deprecation")
public class Error_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, java.lang.Error instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    com.google.gwt.user.client.rpc.core.java.lang.Throwable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native java.lang.Error instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @java.lang.Error::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, java.lang.Error instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Throwable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
