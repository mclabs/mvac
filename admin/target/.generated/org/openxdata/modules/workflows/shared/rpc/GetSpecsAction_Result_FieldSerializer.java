package org.openxdata.modules.workflows.shared.rpc;

@SuppressWarnings("deprecation")
public class GetSpecsAction_Result_FieldSerializer {
  private static native java.util.ArrayList getOspecifications(org.openxdata.modules.workflows.shared.rpc.GetSpecsAction.Result instance) /*-{
    return instance.@org.openxdata.modules.workflows.shared.rpc.GetSpecsAction$Result::ospecifications;
  }-*/;
  
  private static native void  setOspecifications(org.openxdata.modules.workflows.shared.rpc.GetSpecsAction.Result instance, java.util.ArrayList value) /*-{
    instance.@org.openxdata.modules.workflows.shared.rpc.GetSpecsAction$Result::ospecifications = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.shared.rpc.GetSpecsAction.Result instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setOspecifications(instance, (java.util.ArrayList) streamReader.readObject());
    
  }
  
  public static native org.openxdata.modules.workflows.shared.rpc.GetSpecsAction.Result instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.shared.rpc.GetSpecsAction.Result::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.shared.rpc.GetSpecsAction.Result instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getOspecifications(instance));
    
  }
  
}
