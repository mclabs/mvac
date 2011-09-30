package org.openxdata.modules.workflows.shared.rpc;

@SuppressWarnings("deprecation")
public class ParseSpecAction_FieldSerializer {
  private static native java.lang.String getXml(org.openxdata.modules.workflows.shared.rpc.ParseSpecAction instance) /*-{
    return instance.@org.openxdata.modules.workflows.shared.rpc.ParseSpecAction::xml;
  }-*/;
  
  private static native void  setXml(org.openxdata.modules.workflows.shared.rpc.ParseSpecAction instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.shared.rpc.ParseSpecAction::xml = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.shared.rpc.ParseSpecAction instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setXml(instance, streamReader.readString());
    
  }
  
  public static native org.openxdata.modules.workflows.shared.rpc.ParseSpecAction instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.shared.rpc.ParseSpecAction::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.shared.rpc.ParseSpecAction instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getXml(instance));
    
  }
  
}
