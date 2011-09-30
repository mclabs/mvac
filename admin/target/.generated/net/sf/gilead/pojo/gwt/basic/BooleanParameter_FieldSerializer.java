package net.sf.gilead.pojo.gwt.basic;

@SuppressWarnings("deprecation")
public class BooleanParameter_FieldSerializer {
  private static native java.lang.Boolean getValue(net.sf.gilead.pojo.gwt.basic.BooleanParameter instance) /*-{
    return instance.@net.sf.gilead.pojo.gwt.basic.BooleanParameter::value;
  }-*/;
  
  private static native void  setValue(net.sf.gilead.pojo.gwt.basic.BooleanParameter instance, java.lang.Boolean value) /*-{
    instance.@net.sf.gilead.pojo.gwt.basic.BooleanParameter::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.basic.BooleanParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setValue(instance, (java.lang.Boolean) streamReader.readObject());
    
  }
  
  public static native net.sf.gilead.pojo.gwt.basic.BooleanParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.basic.BooleanParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.basic.BooleanParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getValue(instance));
    
  }
  
}
