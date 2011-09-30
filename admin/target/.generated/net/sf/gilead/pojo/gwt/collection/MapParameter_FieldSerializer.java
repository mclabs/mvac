package net.sf.gilead.pojo.gwt.collection;

@SuppressWarnings("deprecation")
public class MapParameter_FieldSerializer {
  private static native java.util.Map getValue(net.sf.gilead.pojo.gwt.collection.MapParameter instance) /*-{
    return instance.@net.sf.gilead.pojo.gwt.collection.MapParameter::value;
  }-*/;
  
  private static native void  setValue(net.sf.gilead.pojo.gwt.collection.MapParameter instance, java.util.Map value) /*-{
    instance.@net.sf.gilead.pojo.gwt.collection.MapParameter::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.collection.MapParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setValue(instance, (java.util.Map) streamReader.readObject());
    
  }
  
  public static native net.sf.gilead.pojo.gwt.collection.MapParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.collection.MapParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.collection.MapParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getValue(instance));
    
  }
  
}
