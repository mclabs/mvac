package com.google.gwt.user.client.rpc.core.java.io;

@SuppressWarnings("deprecation")
public class IOException_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, java.io.IOException instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native java.io.IOException instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @java.io.IOException::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, java.io.IOException instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
