package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class ExportedFormDataList_FieldSerializer {
  private static native java.util.List getExportedFormDataList(org.openxdata.server.admin.model.ExportedFormDataList instance) /*-{
    return instance.@org.openxdata.server.admin.model.ExportedFormDataList::exportedFormDataList;
  }-*/;
  
  private static native void  setExportedFormDataList(org.openxdata.server.admin.model.ExportedFormDataList instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.ExportedFormDataList::exportedFormDataList = value;
  }-*/;
  
  private static native java.lang.Integer getFromIndex(org.openxdata.server.admin.model.ExportedFormDataList instance) /*-{
    return instance.@org.openxdata.server.admin.model.ExportedFormDataList::fromIndex;
  }-*/;
  
  private static native void  setFromIndex(org.openxdata.server.admin.model.ExportedFormDataList instance, java.lang.Integer value) /*-{
    instance.@org.openxdata.server.admin.model.ExportedFormDataList::fromIndex = value;
  }-*/;
  
  private static native java.lang.Integer getToIndex(org.openxdata.server.admin.model.ExportedFormDataList instance) /*-{
    return instance.@org.openxdata.server.admin.model.ExportedFormDataList::toIndex;
  }-*/;
  
  private static native void  setToIndex(org.openxdata.server.admin.model.ExportedFormDataList instance, java.lang.Integer value) /*-{
    instance.@org.openxdata.server.admin.model.ExportedFormDataList::toIndex = value;
  }-*/;
  
  private static native java.lang.Integer getTotalSize(org.openxdata.server.admin.model.ExportedFormDataList instance) /*-{
    return instance.@org.openxdata.server.admin.model.ExportedFormDataList::totalSize;
  }-*/;
  
  private static native void  setTotalSize(org.openxdata.server.admin.model.ExportedFormDataList instance, java.lang.Integer value) /*-{
    instance.@org.openxdata.server.admin.model.ExportedFormDataList::totalSize = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.ExportedFormDataList instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setExportedFormDataList(instance, (java.util.List) streamReader.readObject());
    setFromIndex(instance, (java.lang.Integer) streamReader.readObject());
    setToIndex(instance, (java.lang.Integer) streamReader.readObject());
    setTotalSize(instance, (java.lang.Integer) streamReader.readObject());
    
    net.sf.gilead.pojo.gwt.LightEntity_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.ExportedFormDataList instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.ExportedFormDataList::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.ExportedFormDataList instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getExportedFormDataList(instance));
    streamWriter.writeObject(getFromIndex(instance));
    streamWriter.writeObject(getToIndex(instance));
    streamWriter.writeObject(getTotalSize(instance));
    
    net.sf.gilead.pojo.gwt.LightEntity_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
