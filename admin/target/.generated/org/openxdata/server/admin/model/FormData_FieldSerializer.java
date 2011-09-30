package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class FormData_FieldSerializer {
  private static native java.lang.String getData(org.openxdata.server.admin.model.FormData instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormData::data;
  }-*/;
  
  private static native void  setData(org.openxdata.server.admin.model.FormData instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormData::data = value;
  }-*/;
  
  private static native java.lang.String getDescription(org.openxdata.server.admin.model.FormData instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormData::description;
  }-*/;
  
  private static native void  setDescription(org.openxdata.server.admin.model.FormData instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormData::description = value;
  }-*/;
  
  private static native java.lang.Integer getExported(org.openxdata.server.admin.model.FormData instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormData::exported;
  }-*/;
  
  private static native void  setExported(org.openxdata.server.admin.model.FormData instance, java.lang.Integer value) /*-{
    instance.@org.openxdata.server.admin.model.FormData::exported = value;
  }-*/;
  
  private static native int getFormDataId(org.openxdata.server.admin.model.FormData instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormData::formDataId;
  }-*/;
  
  private static native void  setFormDataId(org.openxdata.server.admin.model.FormData instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.FormData::formDataId = value;
  }-*/;
  
  private static native java.lang.Integer getFormDefVersionId(org.openxdata.server.admin.model.FormData instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormData::formDefVersionId;
  }-*/;
  
  private static native void  setFormDefVersionId(org.openxdata.server.admin.model.FormData instance, java.lang.Integer value) /*-{
    instance.@org.openxdata.server.admin.model.FormData::formDefVersionId = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.FormData instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setData(instance, streamReader.readString());
    setDescription(instance, streamReader.readString());
    setExported(instance, (java.lang.Integer) streamReader.readObject());
    setFormDataId(instance, streamReader.readInt());
    setFormDefVersionId(instance, (java.lang.Integer) streamReader.readObject());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.FormData instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.FormData::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.FormData instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getData(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeObject(getExported(instance));
    streamWriter.writeInt(getFormDataId(instance));
    streamWriter.writeObject(getFormDefVersionId(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
