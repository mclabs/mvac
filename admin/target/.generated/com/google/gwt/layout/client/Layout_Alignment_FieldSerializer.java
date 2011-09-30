package com.google.gwt.layout.client;

@SuppressWarnings("deprecation")
public class Layout_Alignment_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, com.google.gwt.layout.client.Layout.Alignment instance) throws com.google.gwt.user.client.rpc.SerializationException{
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.google.gwt.layout.client.Layout.Alignment instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException{
    int ordinal = streamReader.readInt();
    com.google.gwt.layout.client.Layout.Alignment[] values = com.google.gwt.layout.client.Layout.Alignment.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, com.google.gwt.layout.client.Layout.Alignment instance) throws com.google.gwt.user.client.rpc.SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
}
