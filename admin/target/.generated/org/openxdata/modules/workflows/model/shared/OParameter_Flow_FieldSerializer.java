package org.openxdata.modules.workflows.model.shared;

@SuppressWarnings("deprecation")
public class OParameter_Flow_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.model.shared.OParameter.Flow instance) throws com.google.gwt.user.client.rpc.SerializationException{
    // Enum deserialization is handled via the instantiate method
  }
  
  public static org.openxdata.modules.workflows.model.shared.OParameter.Flow instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException{
    int ordinal = streamReader.readInt();
    org.openxdata.modules.workflows.model.shared.OParameter.Flow[] values = org.openxdata.modules.workflows.model.shared.OParameter.Flow.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.model.shared.OParameter.Flow instance) throws com.google.gwt.user.client.rpc.SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
}
