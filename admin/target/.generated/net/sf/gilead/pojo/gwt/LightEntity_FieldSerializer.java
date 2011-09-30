package net.sf.gilead.pojo.gwt;

@SuppressWarnings("deprecation")
public class LightEntity_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.LightEntity instance) throws com.google.gwt.user.client.rpc.SerializationException{
    instance._initializationMap = (java.util.Map) streamReader.readObject();
    instance._proxyInformations = (java.util.Map) streamReader.readObject();
    
  }
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.LightEntity instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(instance._initializationMap);
    streamWriter.writeObject(instance._proxyInformations);
    
  }
  
}
