package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class ExportedDataType_DataTypeInteger_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.ExportedDataType.DataTypeInteger instance) throws com.google.gwt.user.client.rpc.SerializationException{
    instance.value = (java.lang.Integer) streamReader.readObject();
    
    org.openxdata.server.admin.model.ExportedDataType_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.ExportedDataType.DataTypeInteger instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.ExportedDataType.DataTypeInteger::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.ExportedDataType.DataTypeInteger instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(instance.value);
    
    org.openxdata.server.admin.model.ExportedDataType_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
