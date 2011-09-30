package org.openxdata.modules.workflows.model.shared.dto;

@SuppressWarnings("deprecation")
public class SpecStudyMapDTO_FieldSerializer {
  private static native int getId(org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO::id;
  }-*/;
  
  private static native void  setId(org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instance, int value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO::id = value;
  }-*/;
  
  private static native org.openxdata.modules.workflows.model.shared.OSpecification getOSpecification(org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO::oSpecification;
  }-*/;
  
  private static native void  setOSpecification(org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instance, org.openxdata.modules.workflows.model.shared.OSpecification value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO::oSpecification = value;
  }-*/;
  
  private static native java.lang.String getSpecId(org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO::specId;
  }-*/;
  
  private static native void  setSpecId(org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO::specId = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.StudyDef getStudyDef(org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO::studyDef;
  }-*/;
  
  private static native void  setStudyDef(org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instance, org.openxdata.server.admin.model.StudyDef value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO::studyDef = value;
  }-*/;
  
  private static native int getStudyId(org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO::studyId;
  }-*/;
  
  private static native void  setStudyId(org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instance, int value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO::studyId = value;
  }-*/;
  
  private static native java.lang.String getXmlMap(org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO::xmlMap;
  }-*/;
  
  private static native void  setXmlMap(org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO::xmlMap = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setId(instance, streamReader.readInt());
    setOSpecification(instance, (org.openxdata.modules.workflows.model.shared.OSpecification) streamReader.readObject());
    setSpecId(instance, streamReader.readString());
    setStudyDef(instance, (org.openxdata.server.admin.model.StudyDef) streamReader.readObject());
    setStudyId(instance, streamReader.readInt());
    setXmlMap(instance, streamReader.readString());
    
  }
  
  public static native org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeInt(getId(instance));
    streamWriter.writeObject(getOSpecification(instance));
    streamWriter.writeString(getSpecId(instance));
    streamWriter.writeObject(getStudyDef(instance));
    streamWriter.writeInt(getStudyId(instance));
    streamWriter.writeString(getXmlMap(instance));
    
  }
  
}
