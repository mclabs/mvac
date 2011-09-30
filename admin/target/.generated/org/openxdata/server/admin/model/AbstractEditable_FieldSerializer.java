package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class AbstractEditable_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.AbstractEditable instance) throws com.google.gwt.user.client.rpc.SerializationException{
    instance.changedBy = (org.openxdata.server.admin.model.User) streamReader.readObject();
    instance.creator = (org.openxdata.server.admin.model.User) streamReader.readObject();
    instance.dateChanged = (java.util.Date) streamReader.readObject();
    instance.dateCreated = (java.util.Date) streamReader.readObject();
    instance.dirty = streamReader.readBoolean();
    instance.hasErrors = streamReader.readBoolean();
    
    net.sf.gilead.pojo.gwt.LightEntity_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.AbstractEditable instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeObject(instance.changedBy);
    streamWriter.writeObject(instance.creator);
    streamWriter.writeObject(instance.dateChanged);
    streamWriter.writeObject(instance.dateCreated);
    streamWriter.writeBoolean(instance.dirty);
    streamWriter.writeBoolean(instance.hasErrors);
    
    net.sf.gilead.pojo.gwt.LightEntity_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
