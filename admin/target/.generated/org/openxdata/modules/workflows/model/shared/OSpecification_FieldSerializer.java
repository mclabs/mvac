package org.openxdata.modules.workflows.model.shared;

@SuppressWarnings("deprecation")
public class OSpecification_FieldSerializer {
  private static native java.util.ArrayList getDecompositions(org.openxdata.modules.workflows.model.shared.OSpecification instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.OSpecification::decompositions;
  }-*/;
  
  private static native void  setDecompositions(org.openxdata.modules.workflows.model.shared.OSpecification instance, java.util.ArrayList value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.OSpecification::decompositions = value;
  }-*/;
  
  private static native java.lang.String getId(org.openxdata.modules.workflows.model.shared.OSpecification instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.OSpecification::id;
  }-*/;
  
  private static native void  setId(org.openxdata.modules.workflows.model.shared.OSpecification instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.OSpecification::id = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.modules.workflows.model.shared.OSpecification instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.OSpecification::name;
  }-*/;
  
  private static native void  setName(org.openxdata.modules.workflows.model.shared.OSpecification instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.OSpecification::name = value;
  }-*/;
  
  private static native java.util.ArrayList getTasks(org.openxdata.modules.workflows.model.shared.OSpecification instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.OSpecification::tasks;
  }-*/;
  
  private static native void  setTasks(org.openxdata.modules.workflows.model.shared.OSpecification instance, java.util.ArrayList value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.OSpecification::tasks = value;
  }-*/;
  
  private static native java.lang.String getVersion(org.openxdata.modules.workflows.model.shared.OSpecification instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.OSpecification::version;
  }-*/;
  
  private static native void  setVersion(org.openxdata.modules.workflows.model.shared.OSpecification instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.OSpecification::version = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.model.shared.OSpecification instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDecompositions(instance, (java.util.ArrayList) streamReader.readObject());
    setId(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setTasks(instance, (java.util.ArrayList) streamReader.readObject());
    setVersion(instance, streamReader.readString());
    
  }
  
  public static native org.openxdata.modules.workflows.model.shared.OSpecification instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.model.shared.OSpecification::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.model.shared.OSpecification instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getDecompositions(instance));
    streamWriter.writeString(getId(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getTasks(instance));
    streamWriter.writeString(getVersion(instance));
    
  }
  
}
