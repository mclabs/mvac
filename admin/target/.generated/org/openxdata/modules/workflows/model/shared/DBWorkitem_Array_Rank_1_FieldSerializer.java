package org.openxdata.modules.workflows.model.shared;

@SuppressWarnings("deprecation")
public class DBWorkitem_Array_Rank_1_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.modules.workflows.model.shared.DBWorkitem[] instance) throws com.google.gwt.user.client.rpc.SerializationException{
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.openxdata.modules.workflows.model.shared.DBWorkitem[] instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException{
    int rank = streamReader.readInt();
    return new org.openxdata.modules.workflows.model.shared.DBWorkitem[rank];
  }
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.modules.workflows.model.shared.DBWorkitem[] instance) throws com.google.gwt.user.client.rpc.SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
}
