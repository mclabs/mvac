package net.sf.gilead.pojo.gwt.basic;

@SuppressWarnings("deprecation")
public class IntegerParameter_FieldSerializer {
  private static native java.lang.Integer getValue(net.sf.gilead.pojo.gwt.basic.IntegerParameter instance) /*-{
    return instance.@net.sf.gilead.pojo.gwt.basic.IntegerParameter::value;
  }-*/;
  
  private static native void  setValue(net.sf.gilead.pojo.gwt.basic.IntegerParameter instance, java.lang.Integer value) /*-{
    instance.@net.sf.gilead.pojo.gwt.basic.IntegerParameter::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.basic.IntegerParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setValue(instance, (java.lang.Integer) streamReader.readObject());
    
  }
  
  public static native net.sf.gilead.pojo.gwt.basic.IntegerParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.basic.IntegerParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.basic.IntegerParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getValue(instance));
    
  }
  
}
