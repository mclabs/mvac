package org.purc.purcforms.client.model;

@SuppressWarnings("deprecation")
public class SortField_FieldSerializer {
  private static native java.lang.String getName(org.purc.purcforms.client.model.SortField instance) /*-{
    return instance.@org.purc.purcforms.client.model.SortField::name;
  }-*/;
  
  private static native void  setName(org.purc.purcforms.client.model.SortField instance, java.lang.String value) /*-{
    instance.@org.purc.purcforms.client.model.SortField::name = value;
  }-*/;
  
  private static native int getSortOrder(org.purc.purcforms.client.model.SortField instance) /*-{
    return instance.@org.purc.purcforms.client.model.SortField::sortOrder;
  }-*/;
  
  private static native void  setSortOrder(org.purc.purcforms.client.model.SortField instance, int value) /*-{
    instance.@org.purc.purcforms.client.model.SortField::sortOrder = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.purc.purcforms.client.model.SortField instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setName(instance, streamReader.readString());
    setSortOrder(instance, streamReader.readInt());
    
  }
  
  public static native org.purc.purcforms.client.model.SortField instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.purc.purcforms.client.model.SortField::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.purc.purcforms.client.model.SortField instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getName(instance));
    streamWriter.writeInt(getSortOrder(instance));
    
  }
  
}
