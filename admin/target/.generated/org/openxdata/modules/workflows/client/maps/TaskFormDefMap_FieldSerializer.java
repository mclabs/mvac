package org.openxdata.modules.workflows.client.maps;

@SuppressWarnings("deprecation")
public class TaskFormDefMap_FieldSerializer {
  private static native org.openxdata.server.admin.model.FormDef getFormDef(org.openxdata.modules.workflows.client.maps.TaskFormDefMap instance) /*-{
    return instance.@org.openxdata.modules.workflows.client.maps.TaskFormDefMap::formDef;
  }-*/;
  
  private static native void  setFormDef(org.openxdata.modules.workflows.client.maps.TaskFormDefMap instance, org.openxdata.server.admin.model.FormDef value) /*-{
    instance.@org.openxdata.modules.workflows.client.maps.TaskFormDefMap::formDef = value;
  }-*/;
  
  private static native java.util.HashMap getFormVersionMaps(org.openxdata.modules.workflows.client.maps.TaskFormDefMap instance) /*-{
    return instance.@org.openxdata.modules.workflows.client.maps.TaskFormDefMap::formVersionMaps;
  }-*/;
  
  private static native void  setFormVersionMaps(org.openxdata.modules.workflows.client.maps.TaskFormDefMap instance, java.util.HashMap value) /*-{
    instance.@org.openxdata.modules.workflows.client.maps.TaskFormDefMap::formVersionMaps = value;
  }-*/;
  
  private static native org.openxdata.modules.workflows.model.shared.OTask getOTask(org.openxdata.modules.workflows.client.maps.TaskFormDefMap instance) /*-{
    return instance.@org.openxdata.modules.workflows.client.maps.TaskFormDefMap::oTask;
  }-*/;
  
  private static native void  setOTask(org.openxdata.modules.workflows.client.maps.TaskFormDefMap instance, org.openxdata.modules.workflows.model.shared.OTask value) /*-{
    instance.@org.openxdata.modules.workflows.client.maps.TaskFormDefMap::oTask = value;
  }-*/;
  
  private static native org.openxdata.modules.workflows.client.maps.SpecStudyMap getSpecStudyMap(org.openxdata.modules.workflows.client.maps.TaskFormDefMap instance) /*-{
    return instance.@org.openxdata.modules.workflows.client.maps.TaskFormDefMap::specStudyMap;
  }-*/;
  
  private static native void  setSpecStudyMap(org.openxdata.modules.workflows.client.maps.TaskFormDefMap instance, org.openxdata.modules.workflows.client.maps.SpecStudyMap value) /*-{
    instance.@org.openxdata.modules.workflows.client.maps.TaskFormDefMap::specStudyMap = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.client.maps.TaskFormDefMap instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setFormDef(instance, (org.openxdata.server.admin.model.FormDef) streamReader.readObject());
    setFormVersionMaps(instance, (java.util.HashMap) streamReader.readObject());
    setOTask(instance, (org.openxdata.modules.workflows.model.shared.OTask) streamReader.readObject());
    setSpecStudyMap(instance, (org.openxdata.modules.workflows.client.maps.SpecStudyMap) streamReader.readObject());
    
  }
  
  public static native org.openxdata.modules.workflows.client.maps.TaskFormDefMap instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.client.maps.TaskFormDefMap::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.client.maps.TaskFormDefMap instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getFormDef(instance));
    streamWriter.writeObject(getFormVersionMaps(instance));
    streamWriter.writeObject(getOTask(instance));
    streamWriter.writeObject(getSpecStudyMap(instance));
    
  }
  
}
