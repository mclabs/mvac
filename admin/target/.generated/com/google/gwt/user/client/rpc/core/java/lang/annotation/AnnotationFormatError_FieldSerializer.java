package com.google.gwt.user.client.rpc.core.java.lang.annotation;

@SuppressWarnings("deprecation")
public class AnnotationFormatError_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, java.lang.annotation.AnnotationFormatError instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    com.google.gwt.user.client.rpc.core.java.lang.Error_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native java.lang.annotation.AnnotationFormatError instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @java.lang.annotation.AnnotationFormatError::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, java.lang.annotation.AnnotationFormatError instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Error_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
