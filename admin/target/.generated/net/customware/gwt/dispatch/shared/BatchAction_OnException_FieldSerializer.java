package net.customware.gwt.dispatch.shared;

@SuppressWarnings("deprecation")
public class BatchAction_OnException_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.customware.gwt.dispatch.shared.BatchAction.OnException instance) throws com.google.gwt.user.client.rpc.SerializationException{
    // Enum deserialization is handled via the instantiate method
  }
  
  public static net.customware.gwt.dispatch.shared.BatchAction.OnException instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException{
    int ordinal = streamReader.readInt();
    net.customware.gwt.dispatch.shared.BatchAction.OnException[] values = net.customware.gwt.dispatch.shared.BatchAction.OnException.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.customware.gwt.dispatch.shared.BatchAction.OnException instance) throws com.google.gwt.user.client.rpc.SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
}
