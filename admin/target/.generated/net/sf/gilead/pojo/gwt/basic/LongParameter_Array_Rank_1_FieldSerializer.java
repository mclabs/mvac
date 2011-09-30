package net.sf.gilead.pojo.gwt.basic;

@SuppressWarnings("deprecation")
public class LongParameter_Array_Rank_1_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.sf.gilead.pojo.gwt.basic.LongParameter[] instance) throws com.google.gwt.user.client.rpc.SerializationException{
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static net.sf.gilead.pojo.gwt.basic.LongParameter[] instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException{
    int rank = streamReader.readInt();
    return new net.sf.gilead.pojo.gwt.basic.LongParameter[rank];
  }
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.sf.gilead.pojo.gwt.basic.LongParameter[] instance) throws com.google.gwt.user.client.rpc.SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
