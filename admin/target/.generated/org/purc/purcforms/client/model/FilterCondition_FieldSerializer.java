package org.purc.purcforms.client.model;

@SuppressWarnings("deprecation")
public class FilterCondition_FieldSerializer {
  private static native int getDataType(org.purc.purcforms.client.model.FilterCondition instance) /*-{
    return instance.@org.purc.purcforms.client.model.FilterCondition::dataType;
  }-*/;
  
  private static native void  setDataType(org.purc.purcforms.client.model.FilterCondition instance, int value) /*-{
    instance.@org.purc.purcforms.client.model.FilterCondition::dataType = value;
  }-*/;
  
  private static native java.lang.String getFieldName(org.purc.purcforms.client.model.FilterCondition instance) /*-{
    return instance.@org.purc.purcforms.client.model.FilterCondition::fieldName;
  }-*/;
  
  private static native void  setFieldName(org.purc.purcforms.client.model.FilterCondition instance, java.lang.String value) /*-{
    instance.@org.purc.purcforms.client.model.FilterCondition::fieldName = value;
  }-*/;
  
  private static native java.lang.String getFirstValue(org.purc.purcforms.client.model.FilterCondition instance) /*-{
    return instance.@org.purc.purcforms.client.model.FilterCondition::firstValue;
  }-*/;
  
  private static native void  setFirstValue(org.purc.purcforms.client.model.FilterCondition instance, java.lang.String value) /*-{
    instance.@org.purc.purcforms.client.model.FilterCondition::firstValue = value;
  }-*/;
  
  private static native int getOperator(org.purc.purcforms.client.model.FilterCondition instance) /*-{
    return instance.@org.purc.purcforms.client.model.FilterCondition::operator;
  }-*/;
  
  private static native void  setOperator(org.purc.purcforms.client.model.FilterCondition instance, int value) /*-{
    instance.@org.purc.purcforms.client.model.FilterCondition::operator = value;
  }-*/;
  
  private static native java.lang.String getSecondValue(org.purc.purcforms.client.model.FilterCondition instance) /*-{
    return instance.@org.purc.purcforms.client.model.FilterCondition::secondValue;
  }-*/;
  
  private static native void  setSecondValue(org.purc.purcforms.client.model.FilterCondition instance, java.lang.String value) /*-{
    instance.@org.purc.purcforms.client.model.FilterCondition::secondValue = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.purc.purcforms.client.model.FilterCondition instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setDataType(instance, streamReader.readInt());
    setFieldName(instance, streamReader.readString());
    setFirstValue(instance, streamReader.readString());
    setOperator(instance, streamReader.readInt());
    setSecondValue(instance, streamReader.readString());
    
    org.purc.purcforms.client.model.FilterConditionRow_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.purc.purcforms.client.model.FilterCondition instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.purc.purcforms.client.model.FilterCondition::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.purc.purcforms.client.model.FilterCondition instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeInt(getDataType(instance));
    streamWriter.writeString(getFieldName(instance));
    streamWriter.writeString(getFirstValue(instance));
    streamWriter.writeInt(getOperator(instance));
    streamWriter.writeString(getSecondValue(instance));
    
    org.purc.purcforms.client.model.FilterConditionRow_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
