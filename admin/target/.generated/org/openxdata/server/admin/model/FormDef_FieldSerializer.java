package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class FormDef_FieldSerializer {
  private static native java.util.Date getDateRetired(org.openxdata.server.admin.model.FormDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDef::dateRetired;
  }-*/;
  
  private static native void  setDateRetired(org.openxdata.server.admin.model.FormDef instance, java.util.Date value) /*-{
    instance.@org.openxdata.server.admin.model.FormDef::dateRetired = value;
  }-*/;
  
  private static native java.lang.String getDescription(org.openxdata.server.admin.model.FormDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDef::description;
  }-*/;
  
  private static native void  setDescription(org.openxdata.server.admin.model.FormDef instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDef::description = value;
  }-*/;
  
  private static native int getFormId(org.openxdata.server.admin.model.FormDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDef::formId;
  }-*/;
  
  private static native void  setFormId(org.openxdata.server.admin.model.FormDef instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.FormDef::formId = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.server.admin.model.FormDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDef::name;
  }-*/;
  
  private static native void  setName(org.openxdata.server.admin.model.FormDef instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDef::name = value;
  }-*/;
  
  private static native java.lang.Boolean getRetired(org.openxdata.server.admin.model.FormDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDef::retired;
  }-*/;
  
  private static native void  setRetired(org.openxdata.server.admin.model.FormDef instance, java.lang.Boolean value) /*-{
    instance.@org.openxdata.server.admin.model.FormDef::retired = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.User getRetiredBy(org.openxdata.server.admin.model.FormDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDef::retiredBy;
  }-*/;
  
  private static native void  setRetiredBy(org.openxdata.server.admin.model.FormDef instance, org.openxdata.server.admin.model.User value) /*-{
    instance.@org.openxdata.server.admin.model.FormDef::retiredBy = value;
  }-*/;
  
  private static native java.lang.String getRetiredReason(org.openxdata.server.admin.model.FormDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDef::retiredReason;
  }-*/;
  
  private static native void  setRetiredReason(org.openxdata.server.admin.model.FormDef instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDef::retiredReason = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.StudyDef getStudy(org.openxdata.server.admin.model.FormDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDef::study;
  }-*/;
  
  private static native void  setStudy(org.openxdata.server.admin.model.FormDef instance, org.openxdata.server.admin.model.StudyDef value) /*-{
    instance.@org.openxdata.server.admin.model.FormDef::study = value;
  }-*/;
  
  private static native java.util.List getText(org.openxdata.server.admin.model.FormDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDef::text;
  }-*/;
  
  private static native void  setText(org.openxdata.server.admin.model.FormDef instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.FormDef::text = value;
  }-*/;
  
  private static native java.util.List getUsers(org.openxdata.server.admin.model.FormDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDef::users;
  }-*/;
  
  private static native void  setUsers(org.openxdata.server.admin.model.FormDef instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.FormDef::users = value;
  }-*/;
  
  private static native java.util.List getVersions(org.openxdata.server.admin.model.FormDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDef::versions;
  }-*/;
  
  private static native void  setVersions(org.openxdata.server.admin.model.FormDef instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.FormDef::versions = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.FormDef instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDateRetired(instance, (java.util.Date) streamReader.readObject());
    setDescription(instance, streamReader.readString());
    setFormId(instance, streamReader.readInt());
    setName(instance, streamReader.readString());
    setRetired(instance, (java.lang.Boolean) streamReader.readObject());
    setRetiredBy(instance, (org.openxdata.server.admin.model.User) streamReader.readObject());
    setRetiredReason(instance, streamReader.readString());
    setStudy(instance, (org.openxdata.server.admin.model.StudyDef) streamReader.readObject());
    setText(instance, (java.util.List) streamReader.readObject());
    setUsers(instance, (java.util.List) streamReader.readObject());
    setVersions(instance, (java.util.List) streamReader.readObject());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.FormDef instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.FormDef::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.FormDef instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getDateRetired(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeInt(getFormId(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getRetired(instance));
    streamWriter.writeObject(getRetiredBy(instance));
    streamWriter.writeString(getRetiredReason(instance));
    streamWriter.writeObject(getStudy(instance));
    streamWriter.writeObject(getText(instance));
    streamWriter.writeObject(getUsers(instance));
    streamWriter.writeObject(getVersions(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
