package org.openxdata.modules.workflows.model.shared;

@SuppressWarnings("deprecation")
public class DBSpecStudyMap_FieldSerializer {
  private static native java.lang.Integer getId(org.openxdata.modules.workflows.model.shared.DBSpecStudyMap instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.DBSpecStudyMap::id;
  }-*/;
  
  private static native void  setId(org.openxdata.modules.workflows.model.shared.DBSpecStudyMap instance, java.lang.Integer value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.DBSpecStudyMap::id = value;
  }-*/;
  
  private static native org.openxdata.modules.workflows.model.shared.DBSpecification getSpecifications(org.openxdata.modules.workflows.model.shared.DBSpecStudyMap instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.DBSpecStudyMap::specifications;
  }-*/;
  
  private static native void  setSpecifications(org.openxdata.modules.workflows.model.shared.DBSpecStudyMap instance, org.openxdata.modules.workflows.model.shared.DBSpecification value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.DBSpecStudyMap::specifications = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.StudyDef getStudy(org.openxdata.modules.workflows.model.shared.DBSpecStudyMap instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.DBSpecStudyMap::study;
  }-*/;
  
  private static native void  setStudy(org.openxdata.modules.workflows.model.shared.DBSpecStudyMap instance, org.openxdata.server.admin.model.StudyDef value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.DBSpecStudyMap::study = value;
  }-*/;
  
  private static native java.lang.String getXml(org.openxdata.modules.workflows.model.shared.DBSpecStudyMap instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.DBSpecStudyMap::xml;
  }-*/;
  
  private static native void  setXml(org.openxdata.modules.workflows.model.shared.DBSpecStudyMap instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.DBSpecStudyMap::xml = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.model.shared.DBSpecStudyMap instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setId(instance, (java.lang.Integer) streamReader.readObject());
    setSpecifications(instance, (org.openxdata.modules.workflows.model.shared.DBSpecification) streamReader.readObject());
    setStudy(instance, (org.openxdata.server.admin.model.StudyDef) streamReader.readObject());
    setXml(instance, streamReader.readString());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.modules.workflows.model.shared.DBSpecStudyMap instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.model.shared.DBSpecStudyMap::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.model.shared.DBSpecStudyMap instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getId(instance));
    streamWriter.writeObject(getSpecifications(instance));
    streamWriter.writeObject(getStudy(instance));
    streamWriter.writeString(getXml(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
