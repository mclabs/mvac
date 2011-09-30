package org.openxdata.server.admin.model.util;

@SuppressWarnings("deprecation")
public class OpenXDataEmail_FieldSerializer {
  private static native boolean getAttachErrorLog(org.openxdata.server.admin.model.util.OpenXDataEmail instance) /*-{
    return instance.@org.openxdata.server.admin.model.util.OpenXDataEmail::attachErrorLog;
  }-*/;
  
  private static native void  setAttachErrorLog(org.openxdata.server.admin.model.util.OpenXDataEmail instance, boolean value) /*-{
    instance.@org.openxdata.server.admin.model.util.OpenXDataEmail::attachErrorLog = value;
  }-*/;
  
  private static native boolean getAttachLatestError(org.openxdata.server.admin.model.util.OpenXDataEmail instance) /*-{
    return instance.@org.openxdata.server.admin.model.util.OpenXDataEmail::attachLatestError;
  }-*/;
  
  private static native void  setAttachLatestError(org.openxdata.server.admin.model.util.OpenXDataEmail instance, boolean value) /*-{
    instance.@org.openxdata.server.admin.model.util.OpenXDataEmail::attachLatestError = value;
  }-*/;
  
  private static native java.util.List getCarbonCopyRecipients(org.openxdata.server.admin.model.util.OpenXDataEmail instance) /*-{
    return instance.@org.openxdata.server.admin.model.util.OpenXDataEmail::carbonCopyRecipients;
  }-*/;
  
  private static native void  setCarbonCopyRecipients(org.openxdata.server.admin.model.util.OpenXDataEmail instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.util.OpenXDataEmail::carbonCopyRecipients = value;
  }-*/;
  
  private static native java.util.List getRecipients(org.openxdata.server.admin.model.util.OpenXDataEmail instance) /*-{
    return instance.@org.openxdata.server.admin.model.util.OpenXDataEmail::recipients;
  }-*/;
  
  private static native void  setRecipients(org.openxdata.server.admin.model.util.OpenXDataEmail instance, java.util.List value) /*-{
    instance.@org.openxdata.server.admin.model.util.OpenXDataEmail::recipients = value;
  }-*/;
  
  private static native java.lang.String getSubject(org.openxdata.server.admin.model.util.OpenXDataEmail instance) /*-{
    return instance.@org.openxdata.server.admin.model.util.OpenXDataEmail::subject;
  }-*/;
  
  private static native void  setSubject(org.openxdata.server.admin.model.util.OpenXDataEmail instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.util.OpenXDataEmail::subject = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.util.OpenXDataEmail instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setAttachErrorLog(instance, streamReader.readBoolean());
    setAttachLatestError(instance, streamReader.readBoolean());
    setCarbonCopyRecipients(instance, (java.util.List) streamReader.readObject());
    setRecipients(instance, (java.util.List) streamReader.readObject());
    setSubject(instance, streamReader.readString());
    
  }
  
  public static native org.openxdata.server.admin.model.util.OpenXDataEmail instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.util.OpenXDataEmail::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.util.OpenXDataEmail instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeBoolean(getAttachErrorLog(instance));
    streamWriter.writeBoolean(getAttachLatestError(instance));
    streamWriter.writeObject(getCarbonCopyRecipients(instance));
    streamWriter.writeObject(getRecipients(instance));
    streamWriter.writeString(getSubject(instance));
    
  }
  
}
