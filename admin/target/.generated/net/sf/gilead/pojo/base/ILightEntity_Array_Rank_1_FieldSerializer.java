package net.sf.gilead.pojo.base;

@SuppressWarnings("deprecation")
public class ILightEntity_Array_Rank_1_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.base.ILightEntity[] instance) throws com.google.gwt.user.client.rpc.SerializationException{
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static net.sf.gilead.pojo.base.ILightEntity[] instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException{
    int rank = streamReader.readInt();
    return new net.sf.gilead.pojo.base.ILightEntity[rank];
  }
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.base.ILightEntity[] instance) throws com.google.gwt.user.client.rpc.SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
