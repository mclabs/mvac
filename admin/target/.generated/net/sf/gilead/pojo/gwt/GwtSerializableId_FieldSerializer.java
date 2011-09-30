package net.sf.gilead.pojo.gwt;

@SuppressWarnings("deprecation")
public class GwtSerializableId_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.GwtSerializableId instance) throws com.google.gwt.user.client.rpc.SerializationException{
    instance.entityName = streamReader.readString();
    instance.hashCode = (java.lang.Integer) streamReader.readObject();
    instance.id = (net.sf.gilead.pojo.gwt.IGwtSerializableParameter) streamReader.readObject();
    
  }
  
  public static native net.sf.gilead.pojo.gwt.GwtSerializableId instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.sf.gilead.pojo.gwt.GwtSerializableId::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.GwtSerializableId instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(instance.entityName);
    streamWriter.writeObject(instance.hashCode);
    streamWriter.writeObject(instance.id);
    
  }
  
}
