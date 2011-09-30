package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class FormDataVersion_FieldSerializer {
  private static native java.lang.String getData(org.openxdata.server.admin.model.FormDataVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDataVersion::data;
  }-*/;
  
  private static native void  setData(org.openxdata.server.admin.model.FormDataVersion instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDataVersion::data = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.FormData getFormData(org.openxdata.server.admin.model.FormDataVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDataVersion::formData;
  }-*/;
  
  private static native void  setFormData(org.openxdata.server.admin.model.FormDataVersion instance, org.openxdata.server.admin.model.FormData value) /*-{
    instance.@org.openxdata.server.admin.model.FormDataVersion::formData = value;
  }-*/;
  
  private static native int getFormDataVersionId(org.openxdata.server.admin.model.FormDataVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDataVersion::formDataVersionId;
  }-*/;
  
  private static native void  setFormDataVersionId(org.openxdata.server.admin.model.FormDataVersion instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.FormDataVersion::formDataVersionId = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.FormDataVersion instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setData(instance, streamReader.readString());
    setFormData(instance, (org.openxdata.server.admin.model.FormData) streamReader.readObject());
    setFormDataVersionId(instance, streamReader.readInt());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.FormDataVersion instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.FormDataVersion::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.FormDataVersion instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getData(instance));
    streamWriter.writeObject(getFormData(instance));
    streamWriter.writeInt(getFormDataVersionId(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
