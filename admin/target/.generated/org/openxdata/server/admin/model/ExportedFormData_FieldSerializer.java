package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class ExportedFormData_FieldSerializer {
  private static native java.util.Map getExportedFields(org.openxdata.server.admin.model.ExportedFormData instance) /*-{
    return instance.@org.openxdata.server.admin.model.ExportedFormData::exportedFields;
  }-*/;
  
  private static native void  setExportedFields(org.openxdata.server.admin.model.ExportedFormData instance, java.util.Map value) /*-{
    instance.@org.openxdata.server.admin.model.ExportedFormData::exportedFields = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.FormData getFormData(org.openxdata.server.admin.model.ExportedFormData instance) /*-{
    return instance.@org.openxdata.server.admin.model.ExportedFormData::formData;
  }-*/;
  
  private static native void  setFormData(org.openxdata.server.admin.model.ExportedFormData instance, org.openxdata.server.admin.model.FormData value) /*-{
    instance.@org.openxdata.server.admin.model.ExportedFormData::formData = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.ExportedFormData instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setExportedFields(instance, (java.util.Map) streamReader.readObject());
    setFormData(instance, (org.openxdata.server.admin.model.FormData) streamReader.readObject());
    
    net.sf.gilead.pojo.gwt.LightEntity_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.ExportedFormData instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.ExportedFormData::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.ExportedFormData instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getExportedFields(instance));
    streamWriter.writeObject(getFormData(instance));
    
    net.sf.gilead.pojo.gwt.LightEntity_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
