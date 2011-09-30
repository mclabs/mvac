package org.purc.purcforms.client.model;

@SuppressWarnings("deprecation")
public class DisplayField_FieldSerializer {
  private static native java.lang.String getAggFunc(org.purc.purcforms.client.model.DisplayField instance) /*-{
    return instance.@org.purc.purcforms.client.model.DisplayField::AggFunc;
  }-*/;
  
  private static native void  setAggFunc(org.purc.purcforms.client.model.DisplayField instance, java.lang.String value) /*-{
    instance.@org.purc.purcforms.client.model.DisplayField::AggFunc = value;
  }-*/;
  
  private static native int getDataType(org.purc.purcforms.client.model.DisplayField instance) /*-{
    return instance.@org.purc.purcforms.client.model.DisplayField::dataType;
  }-*/;
  
  private static native void  setDataType(org.purc.purcforms.client.model.DisplayField instance, int value) /*-{
    instance.@org.purc.purcforms.client.model.DisplayField::dataType = value;
  }-*/;
  
  private static native java.lang.String getName(org.purc.purcforms.client.model.DisplayField instance) /*-{
    return instance.@org.purc.purcforms.client.model.DisplayField::name;
  }-*/;
  
  private static native void  setName(org.purc.purcforms.client.model.DisplayField instance, java.lang.String value) /*-{
    instance.@org.purc.purcforms.client.model.DisplayField::name = value;
  }-*/;
  
  private static native java.lang.String getText(org.purc.purcforms.client.model.DisplayField instance) /*-{
    return instance.@org.purc.purcforms.client.model.DisplayField::text;
  }-*/;
  
  private static native void  setText(org.purc.purcforms.client.model.DisplayField instance, java.lang.String value) /*-{
    instance.@org.purc.purcforms.client.model.DisplayField::text = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.purc.purcforms.client.model.DisplayField instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setAggFunc(instance, streamReader.readString());
    setDataType(instance, streamReader.readInt());
    setName(instance, streamReader.readString());
    setText(instance, streamReader.readString());
    
  }
  
  public static native org.purc.purcforms.client.model.DisplayField instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.purc.purcforms.client.model.DisplayField::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.purc.purcforms.client.model.DisplayField instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getAggFunc(instance));
    streamWriter.writeInt(getDataType(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getText(instance));
    
  }
  
}
