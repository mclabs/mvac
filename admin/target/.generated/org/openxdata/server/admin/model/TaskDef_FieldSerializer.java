package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class TaskDef_FieldSerializer {
  private static native java.lang.String getCronExpression(org.openxdata.server.admin.model.TaskDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.TaskDef::cronExpression;
  }-*/;
  
  private static native void  setCronExpression(org.openxdata.server.admin.model.TaskDef instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.TaskDef::cronExpression = value;
  }-*/;
  
  private static native java.lang.String getDescription(org.openxdata.server.admin.model.TaskDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.TaskDef::description;
  }-*/;
  
  private static native void  setDescription(org.openxdata.server.admin.model.TaskDef instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.TaskDef::description = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.server.admin.model.TaskDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.TaskDef::name;
  }-*/;
  
  private static native void  setName(org.openxdata.server.admin.model.TaskDef instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.TaskDef::name = value;
  }-*/;
  
  private static native java.util.List getParameters(org.openxdata.server.admin.model.TaskDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.TaskDef::parameters;
  }-*/;
  
  private static native void  setParameters(org.openxdata.server.admin.model.TaskDef instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.TaskDef::parameters = value;
  }-*/;
  
  private static native boolean getRunning(org.openxdata.server.admin.model.TaskDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.TaskDef::running;
  }-*/;
  
  private static native void  setRunning(org.openxdata.server.admin.model.TaskDef instance, boolean value) /*-{
    instance.@org.openxdata.server.admin.model.TaskDef::running = value;
  }-*/;
  
  private static native java.lang.Boolean getStartOnStartup(org.openxdata.server.admin.model.TaskDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.TaskDef::startOnStartup;
  }-*/;
  
  private static native void  setStartOnStartup(org.openxdata.server.admin.model.TaskDef instance, java.lang.Boolean value) /*-{
    instance.@org.openxdata.server.admin.model.TaskDef::startOnStartup = value;
  }-*/;
  
  private static native java.lang.String getTaskClass(org.openxdata.server.admin.model.TaskDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.TaskDef::taskClass;
  }-*/;
  
  private static native void  setTaskClass(org.openxdata.server.admin.model.TaskDef instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.TaskDef::taskClass = value;
  }-*/;
  
  private static native int getTaskId(org.openxdata.server.admin.model.TaskDef instance) /*-{
    return instance.@org.openxdata.server.admin.model.TaskDef::taskId;
  }-*/;
  
  private static native void  setTaskId(org.openxdata.server.admin.model.TaskDef instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.TaskDef::taskId = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.TaskDef instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setCronExpression(instance, streamReader.readString());
    setDescription(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setParameters(instance, (java.util.List) streamReader.readObject());
    setRunning(instance, streamReader.readBoolean());
    setStartOnStartup(instance, (java.lang.Boolean) streamReader.readObject());
    setTaskClass(instance, streamReader.readString());
    setTaskId(instance, streamReader.readInt());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.TaskDef instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.TaskDef::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.TaskDef instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getCronExpression(instance));
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeObject(getParameters(instance));
    streamWriter.writeBoolean(getRunning(instance));
    streamWriter.writeObject(getStartOnStartup(instance));
    streamWriter.writeString(getTaskClass(instance));
    streamWriter.writeInt(getTaskId(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
