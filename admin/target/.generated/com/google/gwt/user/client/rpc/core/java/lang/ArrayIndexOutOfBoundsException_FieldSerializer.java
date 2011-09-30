package com.google.gwt.user.client.rpc.core.java.lang;

@SuppressWarnings("deprecation")
public class ArrayIndexOutOfBoundsException_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, java.lang.ArrayIndexOutOfBoundsException instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native java.lang.ArrayIndexOutOfBoundsException instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @java.lang.ArrayIndexOutOfBoundsException::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, java.lang.ArrayIndexOutOfBoundsException instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
