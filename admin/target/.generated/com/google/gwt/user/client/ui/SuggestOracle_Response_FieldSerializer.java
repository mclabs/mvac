package com.google.gwt.user.client.ui;

@SuppressWarnings("deprecation")
public class SuggestOracle_Response_FieldSerializer {
  private static native java.util.Collection getSuggestions(com.google.gwt.user.client.ui.SuggestOracle.Response instance) /*-{
    return instance.@com.google.gwt.user.client.ui.SuggestOracle$Response::suggestions;
  }-*/;
  
  private static native void  setSuggestions(com.google.gwt.user.client.ui.SuggestOracle.Response instance, java.util.Collection value) /*-{
    instance.@com.google.gwt.user.client.ui.SuggestOracle$Response::suggestions = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, com.google.gwt.user.client.ui.SuggestOracle.Response instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setSuggestions(instance, (java.util.Collection) streamReader.readObject());
    
  }
  
  public static native com.google.gwt.user.client.ui.SuggestOracle.Response instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @com.google.gwt.user.client.ui.SuggestOracle.Response::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, com.google.gwt.user.client.ui.SuggestOracle.Response instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getSuggestions(instance));
    
  }
  
}
