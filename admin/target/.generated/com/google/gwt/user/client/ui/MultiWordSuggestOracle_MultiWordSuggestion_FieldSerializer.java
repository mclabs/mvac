package com.google.gwt.user.client.ui;

@SuppressWarnings("deprecation")
public class MultiWordSuggestOracle_MultiWordSuggestion_FieldSerializer {
  private static native java.lang.String getDisplayString(com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion instance) /*-{
    return instance.@com.google.gwt.user.client.ui.MultiWordSuggestOracle$MultiWordSuggestion::displayString;
  }-*/;
  
  private static native void  setDisplayString(com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion instance, java.lang.String value) /*-{
    instance.@com.google.gwt.user.client.ui.MultiWordSuggestOracle$MultiWordSuggestion::displayString = value;
  }-*/;
  
  private static native java.lang.String getReplacementString(com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion instance) /*-{
    return instance.@com.google.gwt.user.client.ui.MultiWordSuggestOracle$MultiWordSuggestion::replacementString;
  }-*/;
  
  private static native void  setReplacementString(com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion instance, java.lang.String value) /*-{
    instance.@com.google.gwt.user.client.ui.MultiWordSuggestOracle$MultiWordSuggestion::replacementString = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDisplayString(instance, streamReader.readString());
    setReplacementString(instance, streamReader.readString());
    
  }
  
  public static native com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getDisplayString(instance));
    streamWriter.writeString(getReplacementString(instance));
    
  }
  
}
