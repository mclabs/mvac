package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class FormDataHeader_FieldSerializer {
  private static native java.lang.String getChangedBy(org.openxdata.server.admin.model.FormDataHeader instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDataHeader::changedBy;
  }-*/;
  
  private static native void  setChangedBy(org.openxdata.server.admin.model.FormDataHeader instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDataHeader::changedBy = value;
  }-*/;
  
  private static native java.lang.String getCreator(org.openxdata.server.admin.model.FormDataHeader instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDataHeader::creator;
  }-*/;
  
  private static native void  setCreator(org.openxdata.server.admin.model.FormDataHeader instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDataHeader::creator = value;
  }-*/;
  
  private static native java.util.Date getDateChanged(org.openxdata.server.admin.model.FormDataHeader instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDataHeader::dateChanged;
  }-*/;
  
  private static native void  setDateChanged(org.openxdata.server.admin.model.FormDataHeader instance, java.util.Date value) /*-{
    instance.@org.openxdata.server.admin.model.FormDataHeader::dateChanged = value;
  }-*/;
  
  private static native java.util.Date getDateCreated(org.openxdata.server.admin.model.FormDataHeader instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDataHeader::dateCreated;
  }-*/;
  
  private static native void  setDateCreated(org.openxdata.server.admin.model.FormDataHeader instance, java.util.Date value) /*-{
    instance.@org.openxdata.server.admin.model.FormDataHeader::dateCreated = value;
  }-*/;
  
  private static native java.lang.String getDescription(org.openxdata.server.admin.model.FormDataHeader instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDataHeader::description;
  }-*/;
  
  private static native void  setDescription(org.openxdata.server.admin.model.FormDataHeader instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDataHeader::description = value;
  }-*/;
  
  private static native int getFormDataId(org.openxdata.server.admin.model.FormDataHeader instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDataHeader::formDataId;
  }-*/;
  
  private static native void  setFormDataId(org.openxdata.server.admin.model.FormDataHeader instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.FormDataHeader::formDataId = value;
  }-*/;
  
  private static native java.lang.Integer getFormDefVersionId(org.openxdata.server.admin.model.FormDataHeader instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDataHeader::formDefVersionId;
  }-*/;
  
  private static native void  setFormDefVersionId(org.openxdata.server.admin.model.FormDataHeader instance, java.lang.Integer value) /*-{
    instance.@org.openxdata.server.admin.model.FormDataHeader::formDefVersionId = value;
  }-*/;
  
  private static native java.lang.String getFormName(org.openxdata.server.admin.model.FormDataHeader instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDataHeader::formName;
  }-*/;
  
  private static native void  setFormName(org.openxdata.server.admin.model.FormDataHeader instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDataHeader::formName = value;
  }-*/;
  
  private static native java.lang.String getVersionName(org.openxdata.server.admin.model.FormDataHeader instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDataHeader::versionName;
  }-*/;
  
  private static native void  setVersionName(org.openxdata.server.admin.model.FormDataHeader instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDataHeader::versionName = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.FormDataHeader instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setChangedBy(instance, streamReader.readString());
    setCreator(instance, streamReader.readString());
    setDateChanged(instance, (java.util.Date) streamReader.readObject());
    setDateCreated(instance, (java.util.Date) streamReader.readObject());
    instance.deleted = streamReader.readBoolean();
    setDescription(instance, streamReader.readString());
    setFormDataId(instance, streamReader.readInt());
    setFormDefVersionId(instance, (java.lang.Integer) streamReader.readObject());
    setFormName(instance, streamReader.readString());
    setVersionName(instance, streamReader.readString());
    
    net.sf.gilead.pojo.gwt.LightEntity_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.FormDataHeader instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.FormDataHeader::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.FormDataHeader instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getChangedBy(instance));
    streamWriter.writeString(getCreator(instance));
    streamWriter.writeObject(getDateChanged(instance));
    streamWriter.writeObject(getDateCreated(instance));
    streamWriter.writeBoolean(instance.deleted);
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeInt(getFormDataId(instance));
    streamWriter.writeObject(getFormDefVersionId(instance));
    streamWriter.writeString(getFormName(instance));
    streamWriter.writeString(getVersionName(instance));
    
    net.sf.gilead.pojo.gwt.LightEntity_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
