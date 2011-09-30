package net.customware.gwt.dispatch.shared;

@SuppressWarnings("deprecation")
public class UnsupportedActionException_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, net.customware.gwt.dispatch.shared.UnsupportedActionException instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    net.customware.gwt.dispatch.shared.ActionException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native net.customware.gwt.dispatch.shared.UnsupportedActionException instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @net.customware.gwt.dispatch.shared.UnsupportedActionException::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, net.customware.gwt.dispatch.shared.UnsupportedActionException instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    net.customware.gwt.dispatch.shared.ActionException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
