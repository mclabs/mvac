package com.google.gwt.user.client.rpc.core.java.lang;

@SuppressWarnings("deprecation")
public class AssertionError_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, java.lang.AssertionError instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    com.google.gwt.user.client.rpc.core.java.lang.Error_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native java.lang.AssertionError instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @java.lang.AssertionError::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, java.lang.AssertionError instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Error_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
