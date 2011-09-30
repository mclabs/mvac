package org.openxdata.modules.workflows.model.shared;

@SuppressWarnings("deprecation")
public class OTask_FieldSerializer {
  private static native org.openxdata.modules.workflows.model.shared.ODecomposition getDecomposition(org.openxdata.modules.workflows.model.shared.OTask instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.OTask::decomposition;
  }-*/;
  
  private static native void  setDecomposition(org.openxdata.modules.workflows.model.shared.OTask instance, org.openxdata.modules.workflows.model.shared.ODecomposition value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.OTask::decomposition = value;
  }-*/;
  
  private static native java.lang.String getId(org.openxdata.modules.workflows.model.shared.OTask instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.OTask::id;
  }-*/;
  
  private static native void  setId(org.openxdata.modules.workflows.model.shared.OTask instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.OTask::id = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.modules.workflows.model.shared.OTask instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.OTask::name;
  }-*/;
  
  private static native void  setName(org.openxdata.modules.workflows.model.shared.OTask instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.OTask::name = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.model.shared.OTask instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDecomposition(instance, (org.openxdata.modules.workflows.model.shared.ODecomposition) streamReader.readObject());
    setId(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    
  }
  
  public static native org.openxdata.modules.workflows.model.shared.OTask instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.model.shared.OTask::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.model.shared.OTask instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getDecomposition(instance));
    streamWriter.writeString(getId(instance));
    streamWriter.writeString(getName(instance));
    
  }
  
}
