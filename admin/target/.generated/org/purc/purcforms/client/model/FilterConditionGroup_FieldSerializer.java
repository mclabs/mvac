package org.purc.purcforms.client.model;

@SuppressWarnings("deprecation")
public class FilterConditionGroup_FieldSerializer {
  private static native java.util.List getConditions(org.purc.purcforms.client.model.FilterConditionGroup instance) /*-{
    return instance.@org.purc.purcforms.client.model.FilterConditionGroup::conditions;
  }-*/;
  
  private static native void  setConditions(org.purc.purcforms.client.model.FilterConditionGroup instance, java.util.List value) /*-{
    instance.@org.purc.purcforms.client.model.FilterConditionGroup::conditions = value;
  }-*/;
  
  private static native java.lang.String getConditionsOperator(org.purc.purcforms.client.model.FilterConditionGroup instance) /*-{
    return instance.@org.purc.purcforms.client.model.FilterConditionGroup::conditionsOperator;
  }-*/;
  
  private static native void  setConditionsOperator(org.purc.purcforms.client.model.FilterConditionGroup instance, java.lang.String value) /*-{
    instance.@org.purc.purcforms.client.model.FilterConditionGroup::conditionsOperator = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.purc.purcforms.client.model.FilterConditionGroup instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setConditions(instance, (java.util.List) streamReader.readObject());
    setConditionsOperator(instance, streamReader.readString());
    
    org.purc.purcforms.client.model.FilterConditionRow_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.purc.purcforms.client.model.FilterConditionGroup instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.purc.purcforms.client.model.FilterConditionGroup::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.purc.purcforms.client.model.FilterConditionGroup instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getConditions(instance));
    streamWriter.writeString(getConditionsOperator(instance));
    
    org.purc.purcforms.client.model.FilterConditionRow_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
