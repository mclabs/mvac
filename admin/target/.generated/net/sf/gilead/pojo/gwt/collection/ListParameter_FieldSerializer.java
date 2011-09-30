package net.sf.gilead.pojo.gwt.collection;

@SuppressWarnings("deprecation")
public class ListParameter_FieldSerializer {
  private static native java.util.List getValue(net.sf.gilead.pojo.gwt.collection.ListParameter instance) /*-{
    return instance.@net.sf.gilead.pojo.gwt.collection.ListParameter::value;
  }-*/;
  
  private static native void  setValue(net.sf.gilead.pojo.gwt.collection.ListParameter instance, java.util.List value) /*-{
    instance.@net.sf.gilead.pojo.gwt.collection.ListParameter::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.collection.ListParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setValue(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static native net.sf.gilead.pojo.gwt.collection.ListParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.collection.ListParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.collection.ListParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getValue(instance));
    
  }
  
}
