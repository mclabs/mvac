package com.google.gwt.user.client.ui;

@SuppressWarnings("deprecation")
public class TableListenerCollection_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, com.google.gwt.user.client.ui.TableListenerCollection instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native com.google.gwt.user.client.ui.TableListenerCollection instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @com.google.gwt.user.client.ui.TableListenerCollection::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, com.google.gwt.user.client.ui.TableListenerCollection instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
