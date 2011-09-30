package org.purc.purcforms.client.model;

@SuppressWarnings("deprecation")
public class SkipRule_FieldSerializer {
  private static native int getAction(org.purc.purcforms.client.model.SkipRule instance) /*-{
    return instance.@org.purc.purcforms.client.model.SkipRule::action;
  }-*/;
  
  private static native void  setAction(org.purc.purcforms.client.model.SkipRule instance, int value) /*-{
    instance.@org.purc.purcforms.client.model.SkipRule::action = value;
  }-*/;
  
  private static native java.util.Vector getActionTargets(org.purc.purcforms.client.model.SkipRule instance) /*-{
    return instance.@org.purc.purcforms.client.model.SkipRule::actionTargets;
  }-*/;
  
  private static native void  setActionTargets(org.purc.purcforms.client.model.SkipRule instance, java.util.Vector value) /*-{
    instance.@org.purc.purcforms.client.model.SkipRule::actionTargets = value;
  }-*/;
  
  private static native java.util.Vector getConditions(org.purc.purcforms.client.model.SkipRule instance) /*-{
    return instance.@org.purc.purcforms.client.model.SkipRule::conditions;
  }-*/;
  
  private static native void  setConditions(org.purc.purcforms.client.model.SkipRule instance, java.util.Vector value) /*-{
    instance.@org.purc.purcforms.client.model.SkipRule::conditions = value;
  }-*/;
  
  private static native int getConditionsOperator(org.purc.purcforms.client.model.SkipRule instance) /*-{
    return instance.@org.purc.purcforms.client.model.SkipRule::conditionsOperator;
  }-*/;
  
  private static native void  setConditionsOperator(org.purc.purcforms.client.model.SkipRule instance, int value) /*-{
    instance.@org.purc.purcforms.client.model.SkipRule::conditionsOperator = value;
  }-*/;
  
  private static native int getId(org.purc.purcforms.client.model.SkipRule instance) /*-{
    return instance.@org.purc.purcforms.client.model.SkipRule::id;
  }-*/;
  
  private static native void  setId(org.purc.purcforms.client.model.SkipRule instance, int value) /*-{
    instance.@org.purc.purcforms.client.model.SkipRule::id = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.purc.purcforms.client.model.SkipRule instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setAction(instance, streamReader.readInt());
    setActionTargets(instance, (java.util.Vector) streamReader.readObject());
    setConditions(instance, (java.util.Vector) streamReader.readObject());
    setConditionsOperator(instance, streamReader.readInt());
    setId(instance, streamReader.readInt());
    
  }
  
  public static native org.purc.purcforms.client.model.SkipRule instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.purc.purcforms.client.model.SkipRule::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.purc.purcforms.client.model.SkipRule instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeInt(getAction(instance));
    streamWriter.writeObject(getActionTargets(instance));
    streamWriter.writeObject(getConditions(instance));
    streamWriter.writeInt(getConditionsOperator(instance));
    streamWriter.writeInt(getId(instance));
    
  }
  
}
