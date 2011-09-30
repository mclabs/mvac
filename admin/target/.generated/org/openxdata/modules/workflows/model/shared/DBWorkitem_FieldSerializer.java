package org.openxdata.modules.workflows.model.shared;

@SuppressWarnings("deprecation")
public class DBWorkitem_FieldSerializer {
  private static native java.lang.Integer getId(org.openxdata.modules.workflows.model.shared.DBWorkitem instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.DBWorkitem::id;
  }-*/;
  
  private static native void  setId(org.openxdata.modules.workflows.model.shared.DBWorkitem instance, java.lang.Integer value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.DBWorkitem::id = value;
  }-*/;
  
  private static native java.lang.String getState(org.openxdata.modules.workflows.model.shared.DBWorkitem instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.DBWorkitem::state;
  }-*/;
  
  private static native void  setState(org.openxdata.modules.workflows.model.shared.DBWorkitem instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.DBWorkitem::state = value;
  }-*/;
  
  private static native java.lang.String getWorkitemId(org.openxdata.modules.workflows.model.shared.DBWorkitem instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.DBWorkitem::workitemId;
  }-*/;
  
  private static native void  setWorkitemId(org.openxdata.modules.workflows.model.shared.DBWorkitem instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.DBWorkitem::workitemId = value;
  }-*/;
  
  private static native java.lang.String getXml(org.openxdata.modules.workflows.model.shared.DBWorkitem instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.DBWorkitem::xml;
  }-*/;
  
  private static native void  setXml(org.openxdata.modules.workflows.model.shared.DBWorkitem instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.DBWorkitem::xml = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.model.shared.DBWorkitem instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setId(instance, (java.lang.Integer) streamReader.readObject());
    setState(instance, streamReader.readString());
    setWorkitemId(instance, streamReader.readString());
    setXml(instance, streamReader.readString());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.modules.workflows.model.shared.DBWorkitem instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.model.shared.DBWorkitem::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.model.shared.DBWorkitem instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getState(instance));
    streamWriter.writeString(getWorkitemId(instance));
    streamWriter.writeString(getXml(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
