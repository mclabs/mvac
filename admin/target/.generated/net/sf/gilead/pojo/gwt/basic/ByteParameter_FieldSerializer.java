package net.sf.gilead.pojo.gwt.basic;

@SuppressWarnings("deprecation")
public class ByteParameter_FieldSerializer {
  private static native java.lang.Byte getValue(net.sf.gilead.pojo.gwt.basic.ByteParameter instance) /*-{
    return instance.@net.sf.gilead.pojo.gwt.basic.ByteParameter::value;
  }-*/;
  
  private static native void  setValue(net.sf.gilead.pojo.gwt.basic.ByteParameter instance, java.lang.Byte value) /*-{
    instance.@net.sf.gilead.pojo.gwt.basic.ByteParameter::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.basic.ByteParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setValue(instance, (java.lang.Byte) streamReader.readObject());
    
  }
  
  public static native net.sf.gilead.pojo.gwt.basic.ByteParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.basic.ByteParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.basic.ByteParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getValue(instance));
    
  }
  
}
