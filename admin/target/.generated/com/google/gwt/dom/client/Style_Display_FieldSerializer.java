package com.google.gwt.dom.client;

@SuppressWarnings("deprecation")
public class Style_Display_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, com.google.gwt.dom.client.Style.Display instance) throws com.google.gwt.user.client.rpc.SerializationException{
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.google.gwt.dom.client.Style.Display instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException{
    int ordinal = streamReader.readInt();
    com.google.gwt.dom.client.Style.Display[] values = com.google.gwt.dom.client.Style.Display.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, com.google.gwt.dom.client.Style.Display instance) throws com.google.gwt.user.client.rpc.SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
}
