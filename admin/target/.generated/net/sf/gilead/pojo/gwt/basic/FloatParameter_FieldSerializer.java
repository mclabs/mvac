package net.sf.gilead.pojo.gwt.basic;

@SuppressWarnings("deprecation")
public class FloatParameter_FieldSerializer {
  private static native java.lang.Float getValue(net.sf.gilead.pojo.gwt.basic.FloatParameter instance) /*-{
    return instance.@net.sf.gilead.pojo.gwt.basic.FloatParameter::value;
  }-*/;
  
  private static native void  setValue(net.sf.gilead.pojo.gwt.basic.FloatParameter instance, java.lang.Float value) /*-{
    instance.@net.sf.gilead.pojo.gwt.basic.FloatParameter::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.basic.FloatParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setValue(instance, (java.lang.Float) streamReader.readObject());
    
  }
  
  public static native net.sf.gilead.pojo.gwt.basic.FloatParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.basic.FloatParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.basic.FloatParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getValue(instance));
    
  }
  
}
