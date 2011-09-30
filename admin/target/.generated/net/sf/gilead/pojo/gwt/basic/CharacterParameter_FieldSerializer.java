package net.sf.gilead.pojo.gwt.basic;

@SuppressWarnings("deprecation")
public class CharacterParameter_FieldSerializer {
  private static native java.lang.Character getValue(net.sf.gilead.pojo.gwt.basic.CharacterParameter instance) /*-{
    return instance.@net.sf.gilead.pojo.gwt.basic.CharacterParameter::value;
  }-*/;
  
  private static native void  setValue(net.sf.gilead.pojo.gwt.basic.CharacterParameter instance, java.lang.Character value) /*-{
    instance.@net.sf.gilead.pojo.gwt.basic.CharacterParameter::value = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.basic.CharacterParameter instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setValue(instance, (java.lang.Character) streamReader.readObject());
    
  }
  
  public static native net.sf.gilead.pojo.gwt.basic.CharacterParameter instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.basic.CharacterParameter::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.basic.CharacterParameter instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(getValue(instance));
    
  }
  
}
