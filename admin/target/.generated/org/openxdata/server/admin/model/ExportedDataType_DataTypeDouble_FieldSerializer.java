package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class ExportedDataType_DataTypeDouble_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.ExportedDataType.DataTypeDouble instance) throws com.google.gwt.user.client.rpc.SerializationException{
    instance.value = (java.lang.Double) streamReader.readObject();
    
    org.openxdata.server.admin.model.ExportedDataType_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.ExportedDataType.DataTypeDouble instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.ExportedDataType.DataTypeDouble::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.ExportedDataType.DataTypeDouble instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(instance.value);
    
    org.openxdata.server.admin.model.ExportedDataType_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
