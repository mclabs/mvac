package org.openxdata.modules.workflows.model.shared;

@SuppressWarnings("deprecation")
public class GWTFriendlyWorkItem_FieldSerializer {
  private static native java.lang.String getEnabledTime(org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem::enabledTime;
  }-*/;
  
  private static native void  setEnabledTime(org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem::enabledTime = value;
  }-*/;
  
  private static native java.util.ArrayList getInputParams(org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem::inputParams;
  }-*/;
  
  private static native void  setInputParams(org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instance, java.util.ArrayList value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem::inputParams = value;
  }-*/;
  
  private static native java.util.ArrayList getOutputParams(org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem::outputParams;
  }-*/;
  
  private static native void  setOutputParams(org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instance, java.util.ArrayList value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem::outputParams = value;
  }-*/;
  
  private static native java.lang.String getState(org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem::state;
  }-*/;
  
  private static native void  setState(org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem::state = value;
  }-*/;
  
  private static native java.lang.String getTaskName(org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem::taskName;
  }-*/;
  
  private static native void  setTaskName(org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem::taskName = value;
  }-*/;
  
  private static native java.lang.String getWorkItemId(org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem::workItemId;
  }-*/;
  
  private static native void  setWorkItemId(org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem::workItemId = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setEnabledTime(instance, streamReader.readString());
    setInputParams(instance, (java.util.ArrayList) streamReader.readObject());
    setOutputParams(instance, (java.util.ArrayList) streamReader.readObject());
    setState(instance, streamReader.readString());
    setTaskName(instance, streamReader.readString());
    setWorkItemId(instance, streamReader.readString());
    
  }
  
  public static native org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getEnabledTime(instance));
    streamWriter.writeObject(getInputParams(instance));
    streamWriter.writeObject(getOutputParams(instance));
    streamWriter.writeString(getState(instance));
    streamWriter.writeString(getTaskName(instance));
    streamWriter.writeString(getWorkItemId(instance));
    
  }
  
}
