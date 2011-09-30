package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class ExportedDataType_DataTypeString_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.ExportedDataType.DataTypeString instance) throws com.google.gwt.user.client.rpc.SerializationException{
    instance.value = streamReader.readString();
    
    org.openxdata.server.admin.model.ExportedDataType_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.ExportedDataType.DataTypeString instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.ExportedDataType.DataTypeString::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.ExportedDataType.DataTypeString instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(instance.value);
    
    org.openxdata.server.admin.model.ExportedDataType_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
