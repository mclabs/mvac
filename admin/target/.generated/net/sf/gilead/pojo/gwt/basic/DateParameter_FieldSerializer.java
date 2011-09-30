package net.sf.gilead.pojo.gwt.basic;

@SuppressWarnings("deprecation")
public class DateParameter_FieldSerializer {
  private static native java.util.Date getValue(net.sf.gilead.pojo.gwt.basic.DateParameter instance) /*-{
    return instance.@net.sf.gilead.pojo.gwt.basic.DateParameter::value;
  }-*/;
  
  private static native void  setValue(net.sf.gilead.pojo.gwt.basic.DateParameter instance, java.util.Date value) /*-{
    instance.@net.sf.gilead.pojo.gwt.basic.DateParameter::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.basic.DateParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setValue(instance, (java.util.Date) streamReader.readObject());
    
  }
  
  public static native net.sf.gilead.pojo.gwt.basic.DateParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.basic.DateParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.basic.DateParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getValue(instance));
    
  }
  
}
