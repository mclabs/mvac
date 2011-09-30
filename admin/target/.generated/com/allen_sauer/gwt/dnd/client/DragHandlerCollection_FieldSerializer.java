package com.allen_sauer.gwt.dnd.client;

@SuppressWarnings("deprecation")
public class DragHandlerCollection_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, com.allen_sauer.gwt.dnd.client.DragHandlerCollection instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native com.allen_sauer.gwt.dnd.client.DragHandlerCollection instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @com.allen_sauer.gwt.dnd.client.DragHandlerCollection::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, com.allen_sauer.gwt.dnd.client.DragHandlerCollection instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
