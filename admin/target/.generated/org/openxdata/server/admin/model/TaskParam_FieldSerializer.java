package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class TaskParam_FieldSerializer {
  private static native java.lang.String getName(org.openxdata.server.admin.model.TaskParam instance) /*-{
    return instance.@org.openxdata.server.admin.model.TaskParam::name;
  }-*/;
  
  private static native void  setName(org.openxdata.server.admin.model.TaskParam instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.TaskParam::name = value;
  }-*/;
  
  private static native int getParamId(org.openxdata.server.admin.model.TaskParam instance) /*-{
    return instance.@org.openxdata.server.admin.model.TaskParam::paramId;
  }-*/;
  
  private static native void  setParamId(org.openxdata.server.admin.model.TaskParam instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.TaskParam::paramId = value;
  }-*/;
  
  private static native org.openxdata.server.admin.model.TaskDef getTaskDef(org.openxdata.server.admin.model.TaskParam instance) /*-{
    return instance.@org.openxdata.server.admin.model.TaskParam::taskDef;
  }-*/;
  
  private static native void  setTaskDef(org.openxdata.server.admin.model.TaskParam instance, org.openxdata.server.admin.model.TaskDef value) /*-{
    instance.@org.openxdata.server.admin.model.TaskParam::taskDef = value;
  }-*/;
  
  private static native java.lang.String getValue(org.openxdata.server.admin.model.TaskParam instance) /*-{
    return instance.@org.openxdata.server.admin.model.TaskParam::value;
  }-*/;
  
  private static native void  setValue(org.openxdata.server.admin.model.TaskParam instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.TaskParam::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.TaskParam instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setName(instance, streamReader.readString());
    setParamId(instance, streamReader.readInt());
    setTaskDef(instance, (org.openxdata.server.admin.model.TaskDef) streamReader.readObject());
    setValue(instance, streamReader.readString());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.TaskParam instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.TaskParam::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.TaskParam instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getName(instance));
    streamWriter.writeInt(getParamId(instance));
    streamWriter.writeObject(getTaskDef(instance));
    streamWriter.writeString(getValue(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
