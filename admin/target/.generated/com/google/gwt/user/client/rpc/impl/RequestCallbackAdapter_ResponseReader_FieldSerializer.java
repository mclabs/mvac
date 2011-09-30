package com.google.gwt.user.client.rpc.impl;

@SuppressWarnings("deprecation")
public class RequestCallbackAdapter_ResponseReader_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader instance) throws com.google.gwt.user.client.rpc.SerializationException{
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException{
    int ordinal = streamReader.readInt();
    com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader[] values = com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader instance) throws com.google.gwt.user.client.rpc.SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
}
