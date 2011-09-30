package com.google.gwt.user.client.rpc.core.java.util;

@SuppressWarnings("deprecation")
public class NoSuchElementException_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, java.util.NoSuchElementException instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native java.util.NoSuchElementException instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @java.util.NoSuchElementException::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, java.util.NoSuchElementException instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
