package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class FormDefVersion_FieldSerializer {
  private static native java.util.Date getDateRetired(org.openxdata.server.admin.model.FormDefVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersion::dateRetired;
  }-*/;
  
  private static native void  setDateRetired(org.openxdata.server.admin.model.FormDefVersion instance, java.util.Date value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersion::dateRetired = value;
  }-*/;
  
  private static native java.lang.String getDescription(org.openxdata.server.admin.model.FormDefVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersion::description;
  }-*/;
  
  private static native void  setDescription(org.openxdata.server.admin.model.FormDefVersion instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersion::description = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.FormDef getFormDef(org.openxdata.server.admin.model.FormDefVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersion::formDef;
  }-*/;
  
  private static native void  setFormDef(org.openxdata.server.admin.model.FormDefVersion instance, org.openxdata.server.admin.model.FormDef value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersion::formDef = value;
  }-*/;
  
  private static native int getFormDefVersionId(org.openxdata.server.admin.model.FormDefVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersion::formDefVersionId;
  }-*/;
  
  private static native void  setFormDefVersionId(org.openxdata.server.admin.model.FormDefVersion instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersion::formDefVersionId = value;
  }-*/;
  
  private static native java.lang.Boolean getIsDefault(org.openxdata.server.admin.model.FormDefVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersion::isDefault;
  }-*/;
  
  private static native void  setIsDefault(org.openxdata.server.admin.model.FormDefVersion instance, java.lang.Boolean value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersion::isDefault = value;
  }-*/;
  
  private static native java.lang.String getLayout(org.openxdata.server.admin.model.FormDefVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersion::layout;
  }-*/;
  
  private static native void  setLayout(org.openxdata.server.admin.model.FormDefVersion instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersion::layout = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.server.admin.model.FormDefVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersion::name;
  }-*/;
  
  private static native void  setName(org.openxdata.server.admin.model.FormDefVersion instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersion::name = value;
  }-*/;
  
  private static native java.lang.Boolean getRetired(org.openxdata.server.admin.model.FormDefVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersion::retired;
  }-*/;
  
  private static native void  setRetired(org.openxdata.server.admin.model.FormDefVersion instance, java.lang.Boolean value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersion::retired = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.User getRetiredBy(org.openxdata.server.admin.model.FormDefVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersion::retiredBy;
  }-*/;
  
  private static native void  setRetiredBy(org.openxdata.server.admin.model.FormDefVersion instance, org.openxdata.server.admin.model.User value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersion::retiredBy = value;
  }-*/;
  
  private static native java.lang.String getRetiredReason(org.openxdata.server.admin.model.FormDefVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersion::retiredReason;
  }-*/;
  
  private static native void  setRetiredReason(org.openxdata.server.admin.model.FormDefVersion instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersion::retiredReason = value;
  }-*/;
  
  private static native java.util.List getVersionText(org.openxdata.server.admin.model.FormDefVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersion::versionText;
  }-*/;
  
  private static native void  setVersionText(org.openxdata.server.admin.model.FormDefVersion instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersion::versionText = value;
  }-*/;
  
  private static native java.lang.String getXform(org.openxdata.server.admin.model.FormDefVersion instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersion::xform;
  }-*/;
  
  private static native void  setXform(org.openxdata.server.admin.model.FormDefVersion instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersion::xform = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.FormDefVersion instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDateRetired(instance, (java.util.Date) streamReader.readObject());
    setDescription(instance, streamReader.readString());
    setFormDef(instance, (org.openxdata.server.admin.model.FormDef) streamReader.readObject());
    setFormDefVersionId(instance, streamReader.readInt());
    setIsDefault(instance, (java.lang.Boolean) streamReader.readObject());
    setLayout(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setRetired(instance, (java.lang.Boolean) streamReader.readObject());
    setRetiredBy(instance, (org.openxdata.server.admin.model.User) streamReader.readObject());
    setRetiredReason(instance, streamReader.readString());
    setVersionText(instance, (java.util.List) streamReader.readObject());
    setXform(instance, streamReader.readString());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.FormDefVersion instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.FormDefVersion::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.FormDefVersion instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getDateRetired(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeObject(getFormDef(instance));
    streamWriter.writeInt(getFormDefVersionId(instance));
    streamWriter.writeObject(getIsDefault(instance));
    streamWriter.writeString(getLayout(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getRetired(instance));
    streamWriter.writeObject(getRetiredBy(instance));
    streamWriter.writeString(getRetiredReason(instance));
    streamWriter.writeObject(getVersionText(instance));
    streamWriter.writeString(getXform(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
