package org.openxdata.modules.workflows.client.maps;

@SuppressWarnings("deprecation")
public class SpecStudyMap_FieldSerializer {
  private static native boolean getDirty(org.openxdata.modules.workflows.client.maps.SpecStudyMap instance) /*-{
    return instance.@org.openxdata.modules.workflows.client.maps.SpecStudyMap::dirty;
  }-*/;
  
  private static native void  setDirty(org.openxdata.modules.workflows.client.maps.SpecStudyMap instance, boolean value) /*-{
    instance.@org.openxdata.modules.workflows.client.maps.SpecStudyMap::dirty = value;
  }-*/;
  
  private static native int getId(org.openxdata.modules.workflows.client.maps.SpecStudyMap instance) /*-{
    return instance.@org.openxdata.modules.workflows.client.maps.SpecStudyMap::id;
  }-*/;
  
  private static native void  setId(org.openxdata.modules.workflows.client.maps.SpecStudyMap instance, int value) /*-{
    instance.@org.openxdata.modules.workflows.client.maps.SpecStudyMap::id = value;
  }-*/;
  
  private static native org.openxdata.modules.workflows.model.shared.OSpecification getOSpecification(org.openxdata.modules.workflows.client.maps.SpecStudyMap instance) /*-{
    return instance.@org.openxdata.modules.workflows.client.maps.SpecStudyMap::oSpecification;
  }-*/;
  
  private static native void  setOSpecification(org.openxdata.modules.workflows.client.maps.SpecStudyMap instance, org.openxdata.modules.workflows.model.shared.OSpecification value) /*-{
    instance.@org.openxdata.modules.workflows.client.maps.SpecStudyMap::oSpecification = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.StudyDef getStudyDef(org.openxdata.modules.workflows.client.maps.SpecStudyMap instance) /*-{
    return instance.@org.openxdata.modules.workflows.client.maps.SpecStudyMap::studyDef;
  }-*/;
  
  private static native void  setStudyDef(org.openxdata.modules.workflows.client.maps.SpecStudyMap instance, org.openxdata.server.admin.model.StudyDef value) /*-{
    instance.@org.openxdata.modules.workflows.client.maps.SpecStudyMap::studyDef = value;
  }-*/;
  
  private static native java.util.HashMap getTaskFormDefMaps(org.openxdata.modules.workflows.client.maps.SpecStudyMap instance) /*-{
    return instance.@org.openxdata.modules.workflows.client.maps.SpecStudyMap::taskFormDefMaps;
  }-*/;
  
  private static native void  setTaskFormDefMaps(org.openxdata.modules.workflows.client.maps.SpecStudyMap instance, java.util.HashMap value) /*-{
    instance.@org.openxdata.modules.workflows.client.maps.SpecStudyMap::taskFormDefMaps = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.client.maps.SpecStudyMap instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDirty(instance, streamReader.readBoolean());
    setId(instance, streamReader.readInt());
    setOSpecification(instance, (org.openxdata.modules.workflows.model.shared.OSpecification) streamReader.readObject());
    setStudyDef(instance, (org.openxdata.server.admin.model.StudyDef) streamReader.readObject());
    setTaskFormDefMaps(instance, (java.util.HashMap) streamReader.readObject());
    
  }
  
  public static native org.openxdata.modules.workflows.client.maps.SpecStudyMap instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.client.maps.SpecStudyMap::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.client.maps.SpecStudyMap instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeBoolean(getDirty(instance));
    streamWriter.writeInt(getId(instance));
    streamWriter.writeObject(getOSpecification(instance));
    streamWriter.writeObject(getStudyDef(instance));
    streamWriter.writeObject(getTaskFormDefMaps(instance));
    
  }
  
}
