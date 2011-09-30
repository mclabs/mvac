package com.google.gwt.xml.client;

@SuppressWarnings("deprecation")
public class DOMException_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, com.google.gwt.xml.client.DOMException instance) throws com.google.gwt.user.client.rpc.SerializationException{
    instance.code = streamReader.readShort();
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, com.google.gwt.xml.client.DOMException instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeShort(instance.code);
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
