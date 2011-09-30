package net.sf.gilead.pojo.gwt;

@SuppressWarnings("deprecation")
public class SerializedParameter_FieldSerializer {
  private static native java.lang.String getValue(net.sf.gilead.pojo.gwt.SerializedParameter instance) /*-{
    return instance.@net.sf.gilead.pojo.gwt.SerializedParameter::value;
  }-*/;
  
  private static native void  setValue(net.sf.gilead.pojo.gwt.SerializedParameter instance, java.lang.String value) /*-{
    instance.@net.sf.gilead.pojo.gwt.SerializedParameter::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.SerializedParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setValue(instance, streamReader.readString());
    
  }
  
  public static native net.sf.gilead.pojo.gwt.SerializedParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.SerializedParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.SerializedParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getValue(instance));
    
  }
  
}
