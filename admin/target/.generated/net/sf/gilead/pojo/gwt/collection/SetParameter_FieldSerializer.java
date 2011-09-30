package net.sf.gilead.pojo.gwt.collection;

@SuppressWarnings("deprecation")
public class SetParameter_FieldSerializer {
  private static native java.util.Set getValue(net.sf.gilead.pojo.gwt.collection.SetParameter instance) /*-{
    return instance.@net.sf.gilead.pojo.gwt.collection.SetParameter::value;
  }-*/;
  
  private static native void  setValue(net.sf.gilead.pojo.gwt.collection.SetParameter instance, java.util.Set value) /*-{
    instance.@net.sf.gilead.pojo.gwt.collection.SetParameter::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.collection.SetParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setValue(instance, (java.util.Set) streamReader.readObject());
    
  }
  
  public static native net.sf.gilead.pojo.gwt.collection.SetParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.collection.SetParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.collection.SetParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getValue(instance));
    
  }
  
}
