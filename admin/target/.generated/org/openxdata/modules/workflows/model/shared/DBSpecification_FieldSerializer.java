package org.openxdata.modules.workflows.model.shared;

@SuppressWarnings("deprecation")
public class DBSpecification_FieldSerializer {
  private static native java.lang.Integer getId(org.openxdata.modules.workflows.model.shared.DBSpecification instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.DBSpecification::id;
  }-*/;
  
  private static native void  setId(org.openxdata.modules.workflows.model.shared.DBSpecification instance, java.lang.Integer value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.DBSpecification::id = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.modules.workflows.model.shared.DBSpecification instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.DBSpecification::name;
  }-*/;
  
  private static native void  setName(org.openxdata.modules.workflows.model.shared.DBSpecification instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.DBSpecification::name = value;
  }-*/;
  
  private static native java.lang.String getSpecId(org.openxdata.modules.workflows.model.shared.DBSpecification instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.DBSpecification::specId;
  }-*/;
  
  private static native void  setSpecId(org.openxdata.modules.workflows.model.shared.DBSpecification instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.DBSpecification::specId = value;
  }-*/;
  
  private static native java.util.Set getSpecStudyMapses(org.openxdata.modules.workflows.model.shared.DBSpecification instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.DBSpecification::specStudyMapses;
  }-*/;
  
  private static native void  setSpecStudyMapses(org.openxdata.modules.workflows.model.shared.DBSpecification instance, java.util.Set value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.DBSpecification::specStudyMapses = value;
  }-*/;
  
  private static native java.lang.String getVersion(org.openxdata.modules.workflows.model.shared.DBSpecification instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.DBSpecification::version;
  }-*/;
  
  private static native void  setVersion(org.openxdata.modules.workflows.model.shared.DBSpecification instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.DBSpecification::version = value;
  }-*/;
  
  private static native java.lang.String getXml(org.openxdata.modules.workflows.model.shared.DBSpecification instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.DBSpecification::xml;
  }-*/;
  
  private static native void  setXml(org.openxdata.modules.workflows.model.shared.DBSpecification instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.DBSpecification::xml = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.model.shared.DBSpecification instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setId(instance, (java.lang.Integer) streamReader.readObject());
    setName(instance, streamReader.readString());
    setSpecId(instance, streamReader.readString());
    setSpecStudyMapses(instance, (java.util.Set) streamReader.readObject());
    setVersion(instance, streamReader.readString());
    setXml(instance, streamReader.readString());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.modules.workflows.model.shared.DBSpecification instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.model.shared.DBSpecification::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.model.shared.DBSpecification instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getSpecId(instance));
    streamWriter.writeObject(getSpecStudyMapses(instance));
    streamWriter.writeString(getVersion(instance));
    streamWriter.writeString(getXml(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
