package net.sf.gilead.pojo.gwt.basic;

@SuppressWarnings("deprecation")
public class ShortParameter_FieldSerializer {
  private static native java.lang.Short getValue(net.sf.gilead.pojo.gwt.basic.ShortParameter instance) /*-{
    return instance.@net.sf.gilead.pojo.gwt.basic.ShortParameter::value;
  }-*/;
  
  private static native void  setValue(net.sf.gilead.pojo.gwt.basic.ShortParameter instance, java.lang.Short value) /*-{
    instance.@net.sf.gilead.pojo.gwt.basic.ShortParameter::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.basic.ShortParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setValue(instance, (java.lang.Short) streamReader.readObject());
    
  }
  
  public static native net.sf.gilead.pojo.gwt.basic.ShortParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.basic.ShortParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.basic.ShortParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getValue(instance));
    
  }
  
}
