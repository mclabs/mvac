package net.sf.gilead.pojo.gwt.basic;

@SuppressWarnings("deprecation")
public class LongParameter_FieldSerializer {
  private static native java.lang.Long getValue(net.sf.gilead.pojo.gwt.basic.LongParameter instance) /*-{
    return instance.@net.sf.gilead.pojo.gwt.basic.LongParameter::value;
  }-*/;
  
  private static native void  setValue(net.sf.gilead.pojo.gwt.basic.LongParameter instance, java.lang.Long value) /*-{
    instance.@net.sf.gilead.pojo.gwt.basic.LongParameter::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.basic.LongParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setValue(instance, (java.lang.Long) streamReader.readObject());
    
  }
  
  public static native net.sf.gilead.pojo.gwt.basic.LongParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.basic.LongParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.basic.LongParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getValue(instance));
    
  }
  
}
