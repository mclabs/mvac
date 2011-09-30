package org.openxdata.modules.workflows.shared.rpc;

@SuppressWarnings("deprecation")
public class ParseSpecAction_Result_FieldSerializer {
  private static native org.openxdata.modules.workflows.model.shared.OSpecification getOspecification(org.openxdata.modules.workflows.shared.rpc.ParseSpecAction.Result instance) /*-{
    return instance.@org.openxdata.modules.workflows.shared.rpc.ParseSpecAction$Result::ospecification;
  }-*/;
  
  private static native void  setOspecification(org.openxdata.modules.workflows.shared.rpc.ParseSpecAction.Result instance, org.openxdata.modules.workflows.model.shared.OSpecification value) /*-{
    instance.@org.openxdata.modules.workflows.shared.rpc.ParseSpecAction$Result::ospecification = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.shared.rpc.ParseSpecAction.Result instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setOspecification(instance, (org.openxdata.modules.workflows.model.shared.OSpecification) streamReader.readObject());
    
  }
  
  public static native org.openxdata.modules.workflows.shared.rpc.ParseSpecAction.Result instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.shared.rpc.ParseSpecAction.Result::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.shared.rpc.ParseSpecAction.Result instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getOspecification(instance));
    
  }
  
}
