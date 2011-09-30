package com.google.gwt.xml.client.impl;

@SuppressWarnings("deprecation")
public class DOMParseException_FieldSerializer {
  private static native java.lang.String getContents(com.google.gwt.xml.client.impl.DOMParseException instance) /*-{
    return instance.@com.google.gwt.xml.client.impl.DOMParseException::contents;
  }-*/;
  
  private static native void  setContents(com.google.gwt.xml.client.impl.DOMParseException instance, java.lang.String value) /*-{
    instance.@com.google.gwt.xml.client.impl.DOMParseException::contents = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, com.google.gwt.xml.client.impl.DOMParseException instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setContents(instance, streamReader.readString());
    
    com.google.gwt.xml.client.DOMException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native com.google.gwt.xml.client.impl.DOMParseException instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @com.google.gwt.xml.client.impl.DOMParseException::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, com.google.gwt.xml.client.impl.DOMParseException instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getContents(instance));
    
    com.google.gwt.xml.client.DOMException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
