package org.openxdata.modules.workflows.model.shared;

@SuppressWarnings("deprecation")
public class ODecomposition_FieldSerializer {
  private static native java.lang.String getId(org.openxdata.modules.workflows.model.shared.ODecomposition instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.ODecomposition::id;
  }-*/;
  
  private static native void  setId(org.openxdata.modules.workflows.model.shared.ODecomposition instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.ODecomposition::id = value;
  }-*/;
  
  private static native java.util.HashMap getMParams(org.openxdata.modules.workflows.model.shared.ODecomposition instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.ODecomposition::mParams;
  }-*/;
  
  private static native void  setMParams(org.openxdata.modules.workflows.model.shared.ODecomposition instance, java.util.HashMap value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.ODecomposition::mParams = value;
  }-*/;
  
  private static native java.lang.String getUrlService(org.openxdata.modules.workflows.model.shared.ODecomposition instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.ODecomposition::urlService;
  }-*/;
  
  private static native void  setUrlService(org.openxdata.modules.workflows.model.shared.ODecomposition instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.ODecomposition::urlService = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.model.shared.ODecomposition instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setId(instance, streamReader.readString());
    setMParams(instance, (java.util.HashMap) streamReader.readObject());
    setUrlService(instance, streamReader.readString());
    
  }
  
  public static native org.openxdata.modules.workflows.model.shared.ODecomposition instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.model.shared.ODecomposition::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.model.shared.ODecomposition instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getId(instance));
    streamWriter.writeObject(getMParams(instance));
    streamWriter.writeString(getUrlService(instance));
    
  }
  
}
