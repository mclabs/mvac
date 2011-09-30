package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class FormSmsArchive_FieldSerializer {
  private static native org.openxdata.server.admin.model.User getArchiveCreator(org.openxdata.server.admin.model.FormSmsArchive instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormSmsArchive::archiveCreator;
  }-*/;
  
  private static native void  setArchiveCreator(org.openxdata.server.admin.model.FormSmsArchive instance, org.openxdata.server.admin.model.User value) /*-{
    instance.@org.openxdata.server.admin.model.FormSmsArchive::archiveCreator = value;
  }-*/;
  
  private static native java.util.Date getArchiveDateCreated(org.openxdata.server.admin.model.FormSmsArchive instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormSmsArchive::archiveDateCreated;
  }-*/;
  
  private static native void  setArchiveDateCreated(org.openxdata.server.admin.model.FormSmsArchive instance, java.util.Date value) /*-{
    instance.@org.openxdata.server.admin.model.FormSmsArchive::archiveDateCreated = value;
  }-*/;
  
  private static native int getFormSmsArchiveId(org.openxdata.server.admin.model.FormSmsArchive instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormSmsArchive::formSmsArchiveId;
  }-*/;
  
  private static native void  setFormSmsArchiveId(org.openxdata.server.admin.model.FormSmsArchive instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.FormSmsArchive::formSmsArchiveId = value;
  }-*/;
  
  private static native java.lang.String getSender(org.openxdata.server.admin.model.FormSmsArchive instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormSmsArchive::sender;
  }-*/;
  
  private static native void  setSender(org.openxdata.server.admin.model.FormSmsArchive instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormSmsArchive::sender = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.FormSmsArchive instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setArchiveCreator(instance, (org.openxdata.server.admin.model.User) streamReader.readObject());
    setArchiveDateCreated(instance, (java.util.Date) streamReader.readObject());
    setFormSmsArchiveId(instance, streamReader.readInt());
    setSender(instance, streamReader.readString());
    
    org.openxdata.server.admin.model.FormData_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.FormSmsArchive instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.FormSmsArchive::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.FormSmsArchive instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getArchiveCreator(instance));
    streamWriter.writeObject(getArchiveDateCreated(instance));
    streamWriter.writeInt(getFormSmsArchiveId(instance));
    streamWriter.writeString(getSender(instance));
    
    org.openxdata.server.admin.model.FormData_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
