package org.openxdata.server.admin.model.util;

@SuppressWarnings("deprecation")
public class ErrorRiskLevel_FieldSerializer {
  private static native byte getValue(org.openxdata.server.admin.model.util.ErrorRiskLevel instance) /*-{
    return instance.@org.openxdata.server.admin.model.util.ErrorRiskLevel::value;
  }-*/;
  
  private static native void  setValue(org.openxdata.server.admin.model.util.ErrorRiskLevel instance, byte value) /*-{
    instance.@org.openxdata.server.admin.model.util.ErrorRiskLevel::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.util.ErrorRiskLevel instance) throws com.google.gwt.user.client.rpc.SerializationException{
    // Enum deserialization is handled via the instantiate method
  }
  
  public static org.openxdata.server.admin.model.util.ErrorRiskLevel instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException{
    int ordinal = streamReader.readInt();
    org.openxdata.server.admin.model.util.ErrorRiskLevel[] values = org.openxdata.server.admin.model.util.ErrorRiskLevel.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.util.ErrorRiskLevel instance) throws com.google.gwt.user.client.rpc.SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
}
