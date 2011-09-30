package com.google.gwt.user.client.ui;

@SuppressWarnings("deprecation")
public class SuggestOracle_Request_FieldSerializer {
  private static native int getLimit(com.google.gwt.user.client.ui.SuggestOracle.Request instance) /*-{
    return instance.@com.google.gwt.user.client.ui.SuggestOracle$Request::limit;
  }-*/;
  
  private static native void  setLimit(com.google.gwt.user.client.ui.SuggestOracle.Request instance, int value) /*-{
    instance.@com.google.gwt.user.client.ui.SuggestOracle$Request::limit = value;
  }-*/;
  
  private static native java.lang.String getQuery(com.google.gwt.user.client.ui.SuggestOracle.Request instance) /*-{
    return instance.@com.google.gwt.user.client.ui.SuggestOracle$Request::query;
  }-*/;
  
  private static native void  setQuery(com.google.gwt.user.client.ui.SuggestOracle.Request instance, java.lang.String value) /*-{
    instance.@com.google.gwt.user.client.ui.SuggestOracle$Request::query = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, com.google.gwt.user.client.ui.SuggestOracle.Request instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setLimit(instance, streamReader.readInt());
    setQuery(instance, streamReader.readString());
    
  }
  
  public static native com.google.gwt.user.client.ui.SuggestOracle.Request instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @com.google.gwt.user.client.ui.SuggestOracle.Request::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, com.google.gwt.user.client.ui.SuggestOracle.Request instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeInt(getLimit(instance));
    streamWriter.writeString(getQuery(instance));
    
  }
  
}
