package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class StudyDef_FieldSerializer {
  private static native java.util.Date getDateRetired(org.openxdata.server.admin.model.StudyDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDef::dateRetired;
  }-*/;
  
  private static native void  setDateRetired(org.openxdata.server.admin.model.StudyDef instance, java.util.Date value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDef::dateRetired = value;
  }-*/;
  
  private static native java.lang.String getDescription(org.openxdata.server.admin.model.StudyDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDef::description;
  }-*/;
  
  private static native void  setDescription(org.openxdata.server.admin.model.StudyDef instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDef::description = value;
  }-*/;
  
  private static native java.util.List getForms(org.openxdata.server.admin.model.StudyDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDef::forms;
  }-*/;
  
  private static native void  setForms(org.openxdata.server.admin.model.StudyDef instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDef::forms = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.server.admin.model.StudyDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDef::name;
  }-*/;
  
  private static native void  setName(org.openxdata.server.admin.model.StudyDef instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDef::name = value;
  }-*/;
  
  private static native java.lang.Boolean getRetired(org.openxdata.server.admin.model.StudyDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDef::retired;
  }-*/;
  
  private static native void  setRetired(org.openxdata.server.admin.model.StudyDef instance, java.lang.Boolean value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDef::retired = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.User getRetiredBy(org.openxdata.server.admin.model.StudyDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDef::retiredBy;
  }-*/;
  
  private static native void  setRetiredBy(org.openxdata.server.admin.model.StudyDef instance, org.openxdata.server.admin.model.User value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDef::retiredBy = value;
  }-*/;
  
  private static native java.lang.String getRetiredReason(org.openxdata.server.admin.model.StudyDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDef::retiredReason;
  }-*/;
  
  private static native void  setRetiredReason(org.openxdata.server.admin.model.StudyDef instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDef::retiredReason = value;
  }-*/;
  
  private static native int getStudyId(org.openxdata.server.admin.model.StudyDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDef::studyId;
  }-*/;
  
  private static native void  setStudyId(org.openxdata.server.admin.model.StudyDef instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDef::studyId = value;
  }-*/;
  
  private static native java.lang.String getStudyKey(org.openxdata.server.admin.model.StudyDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDef::studyKey;
  }-*/;
  
  private static native void  setStudyKey(org.openxdata.server.admin.model.StudyDef instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDef::studyKey = value;
  }-*/;
  
  private static native java.util.List getText(org.openxdata.server.admin.model.StudyDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDef::text;
  }-*/;
  
  private static native void  setText(org.openxdata.server.admin.model.StudyDef instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDef::text = value;
  }-*/;
  
  private static native java.util.List getUsers(org.openxdata.server.admin.model.StudyDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.StudyDef::users;
  }-*/;
  
  private static native void  setUsers(org.openxdata.server.admin.model.StudyDef instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.StudyDef::users = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.StudyDef instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDateRetired(instance, (java.util.Date) streamReader.readObject());
    setDescription(instance, streamReader.readString());
    setForms(instance, (java.util.List) streamReader.readObject());
    setName(instance, streamReader.readString());
    setRetired(instance, (java.lang.Boolean) streamReader.readObject());
    setRetiredBy(instance, (org.openxdata.server.admin.model.User) streamReader.readObject());
    setRetiredReason(instance, streamReader.readString());
    setStudyId(instance, streamReader.readInt());
    setStudyKey(instance, streamReader.readString());
    setText(instance, (java.util.List) streamReader.readObject());
    setUsers(instance, (java.util.List) streamReader.readObject());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.StudyDef instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.StudyDef::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.StudyDef instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getDateRetired(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeObject(getForms(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getRetired(instance));
    streamWriter.writeObject(getRetiredBy(instance));
    streamWriter.writeString(getRetiredReason(instance));
    streamWriter.writeInt(getStudyId(instance));
    streamWriter.writeString(getStudyKey(instance));
    streamWriter.writeObject(getText(instance));
    streamWriter.writeObject(getUsers(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
