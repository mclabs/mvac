package net.sf.gilead.pojo.gwt.basic;

@SuppressWarnings("deprecation")
public class StringParameter_FieldSerializer {
  private static native java.lang.String getValue(net.sf.gilead.pojo.gwt.basic.StringParameter instance) /*-{
    return instance.@net.sf.gilead.pojo.gwt.basic.StringParameter::value;
  }-*/;
  
  private static native void  setValue(net.sf.gilead.pojo.gwt.basic.StringParameter instance, java.lang.String value) /*-{
    instance.@net.sf.gilead.pojo.gwt.basic.StringParameter::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.basic.StringParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setValue(instance, streamReader.readString());
    
  }
  
  public static native net.sf.gilead.pojo.gwt.basic.StringParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.basic.StringParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.basic.StringParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getValue(instance));
    
  }
  
}
