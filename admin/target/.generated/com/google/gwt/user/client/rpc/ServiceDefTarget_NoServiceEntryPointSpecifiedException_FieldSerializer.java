package com.google.gwt.user.client.rpc;

@SuppressWarnings("deprecation")
public class ServiceDefTarget_NoServiceEntryPointSpecifiedException_FieldSerializer {
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, com.google.gwt.user.client.rpc.ServiceDefTarget.NoServiceEntryPointSpecifiedException instance) throws com.google.gwt.user.client.rpc.SerializationException{
    
    com.google.gwt.user.client.rpc.InvocationException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native com.google.gwt.user.client.rpc.ServiceDefTarget.NoServiceEntryPointSpecifiedException instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @com.google.gwt.user.client.rpc.ServiceDefTarget.NoServiceEntryPointSpecifiedException::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, com.google.gwt.user.client.rpc.ServiceDefTarget.NoServiceEntryPointSpecifiedException instance) throws com.google.gwt.user.client.rpc.SerializationException {
    
    com.google.gwt.user.client.rpc.InvocationException_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
