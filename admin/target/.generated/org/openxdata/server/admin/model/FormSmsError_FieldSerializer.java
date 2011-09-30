package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class FormSmsError_FieldSerializer {
  private static native java.lang.String getData(org.openxdata.server.admin.model.FormSmsError instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormSmsError::data;
  }-*/;
  
  private static native void  setData(org.openxdata.server.admin.model.FormSmsError instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormSmsError::data = value;
  }-*/;
  
  private static native java.lang.String getErrorMsg(org.openxdata.server.admin.model.FormSmsError instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormSmsError::errorMsg;
  }-*/;
  
  private static native void  setErrorMsg(org.openxdata.server.admin.model.FormSmsError instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormSmsError::errorMsg = value;
  }-*/;
  
  private static native int getFormSmsErrorId(org.openxdata.server.admin.model.FormSmsError instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormSmsError::formSmsErrorId;
  }-*/;
  
  private static native void  setFormSmsErrorId(org.openxdata.server.admin.model.FormSmsError instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.FormSmsError::formSmsErrorId = value;
  }-*/;
  
  private static native java.lang.String getSender(org.openxdata.server.admin.model.FormSmsError instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormSmsError::sender;
  }-*/;
  
  private static native void  setSender(org.openxdata.server.admin.model.FormSmsError instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormSmsError::sender = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.FormSmsError instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setData(instance, streamReader.readString());
    setErrorMsg(instance, streamReader.readString());
    setFormSmsErrorId(instance, streamReader.readInt());
    setSender(instance, streamReader.readString());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.FormSmsError instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.FormSmsError::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.FormSmsError instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getData(instance));
    streamWriter.writeString(getErrorMsg(instance));
    streamWriter.writeInt(getFormSmsErrorId(instance));
    streamWriter.writeString(getSender(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
