package com.google.gwt.user.client.rpc.core.java.util;

@SuppressWarnings("deprecation")
public class LinkedHashSet_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, java.util.LinkedHashSet instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    com.google.gwt.user.client.rpc.core.java.util.HashSet_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native java.util.LinkedHashSet instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @java.util.LinkedHashSet::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, java.util.LinkedHashSet instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.util.HashSet_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
