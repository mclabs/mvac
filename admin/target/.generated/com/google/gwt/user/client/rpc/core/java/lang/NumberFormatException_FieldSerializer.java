package com.google.gwt.user.client.rpc.core.java.lang;

@SuppressWarnings("deprecation")
public class NumberFormatException_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, java.lang.NumberFormatException instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    com.google.gwt.user.client.rpc.core.java.lang.IllegalArgumentException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native java.lang.NumberFormatException instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @java.lang.NumberFormatException::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, java.lang.NumberFormatException instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.IllegalArgumentException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
