package com.google.gwt.user.client.ui;

@SuppressWarnings("deprecation")
public class MultiWordSuggestOracle_MultiWordSuggestion_Array_Rank_1_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion[] instance) throws com.google.gwt.user.client.rpc.SerializationException{
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion[] instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException{
    int rank = streamReader.readInt();
    return new com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion[rank];
  }
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion[] instance) throws com.google.gwt.user.client.rpc.SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
