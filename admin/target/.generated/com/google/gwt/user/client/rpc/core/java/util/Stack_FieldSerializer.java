package com.google.gwt.user.client.rpc.core.java.util;

@SuppressWarnings("deprecation")
public class Stack_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, java.util.Stack instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native java.util.Stack instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @java.util.Stack::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, java.util.Stack instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
