package org.openxdata.modules.workflows.model.shared;

@SuppressWarnings("deprecation")
public class OParameter_FieldSerializer {
  private static native org.openxdata.modules.workflows.model.shared.OParameter.Flow getFlow(org.openxdata.modules.workflows.model.shared.OParameter instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.OParameter::flow;
  }-*/;
  
  private static native void  setFlow(org.openxdata.modules.workflows.model.shared.OParameter instance, org.openxdata.modules.workflows.model.shared.OParameter.Flow value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.OParameter::flow = value;
  }-*/;
  
  private static native java.lang.String getInitialValue(org.openxdata.modules.workflows.model.shared.OParameter instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.OParameter::initialValue;
  }-*/;
  
  private static native void  setInitialValue(org.openxdata.modules.workflows.model.shared.OParameter instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.OParameter::initialValue = value;
  }-*/;
  
  private static native java.lang.String getName(org.openxdata.modules.workflows.model.shared.OParameter instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.OParameter::name;
  }-*/;
  
  private static native void  setName(org.openxdata.modules.workflows.model.shared.OParameter instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.OParameter::name = value;
  }-*/;
  
  private static native java.lang.String getNameSpace(org.openxdata.modules.workflows.model.shared.OParameter instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.OParameter::nameSpace;
  }-*/;
  
  private static native void  setNameSpace(org.openxdata.modules.workflows.model.shared.OParameter instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.OParameter::nameSpace = value;
  }-*/;
  
  private static native java.lang.String getType(org.openxdata.modules.workflows.model.shared.OParameter instance) /*-{
    return instance.@org.openxdata.modules.workflows.model.shared.OParameter::type;
  }-*/;
  
  private static native void  setType(org.openxdata.modules.workflows.model.shared.OParameter instance, java.lang.String value) /*-{
    instance.@org.openxdata.modules.workflows.model.shared.OParameter::type = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.model.shared.OParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setFlow(instance, (org.openxdata.modules.workflows.model.shared.OParameter.Flow) streamReader.readObject());
    setInitialValue(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    setNameSpace(instance, streamReader.readString());
    setType(instance, streamReader.readString());
    
  }
  
  public static native org.openxdata.modules.workflows.model.shared.OParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.modules.workflows.model.shared.OParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.model.shared.OParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getFlow(instance));
    streamWriter.writeString(getInitialValue(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getNameSpace(instance));
    streamWriter.writeString(getType(instance));
    
  }
  
}
