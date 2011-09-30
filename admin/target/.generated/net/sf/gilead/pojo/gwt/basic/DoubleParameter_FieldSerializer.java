package net.sf.gilead.pojo.gwt.basic;

@SuppressWarnings("deprecation")
public class DoubleParameter_FieldSerializer {
  private static native java.lang.Double getValue(net.sf.gilead.pojo.gwt.basic.DoubleParameter instance) /*-{
    return instance.@net.sf.gilead.pojo.gwt.basic.DoubleParameter::value;
  }-*/;
  
  private static native void  setValue(net.sf.gilead.pojo.gwt.basic.DoubleParameter instance, java.lang.Double value) /*-{
    instance.@net.sf.gilead.pojo.gwt.basic.DoubleParameter::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.basic.DoubleParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setValue(instance, (java.lang.Double) streamReader.readObject());
    
  }
  
  public static native net.sf.gilead.pojo.gwt.basic.DoubleParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.basic.DoubleParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.basic.DoubleParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getValue(instance));
    
  }
  
}
