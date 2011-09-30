package org.openxdata.modules.workflows.shared.rpc;

@SuppressWarnings("deprecation")
public class GetStudiesAction_Result_FieldSerializer {
  private static native java.util.ArrayList getStudies(org.openxdata.modules.workflows.shared.rpc.GetStudiesAction.Result instance) /*-{
    return instance.@org.openxdata.modules.workflows.shared.rpc.GetStudiesAction$Result::studies;
  }-*/;
  
  private static native void  setStudies(org.openxdata.modules.workflows.shared.rpc.GetStudiesAction.Result instance, java.util.ArrayList value) /*-{
    instance.@org.openxdata.modules.workflows.shared.rpc.GetStudiesAction$Result::studies = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.shared.rpc.GetStudiesAction.Result instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setStudies(instance, (java.util.ArrayList) streamReader.readObject());
    
  }
  
  public static native org.openxdata.modules.workflows.shared.rpc.GetStudiesAction.Result instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.shared.rpc.GetStudiesAction.Result::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.shared.rpc.GetStudiesAction.Result instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getStudies(instance));
    
  }
  
}
