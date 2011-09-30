package com.google.gwt.user.client.rpc.core.java.lang;

@SuppressWarnings("deprecation")
public class StringIndexOutOfBoundsException_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, java.lang.StringIndexOutOfBoundsException instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native java.lang.StringIndexOutOfBoundsException instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @java.lang.StringIndexOutOfBoundsException::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, java.lang.StringIndexOutOfBoundsException instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
