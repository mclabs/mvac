package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class FormDefVersionText_FieldSerializer {
  private static native int getFormDefVersionId(org.openxdata.server.admin.model.FormDefVersionText instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersionText::formDefVersionId;
  }-*/;
  
  private static native void  setFormDefVersionId(org.openxdata.server.admin.model.FormDefVersionText instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersionText::formDefVersionId = value;
  }-*/;
  
  private static native int getFormDefVersionTextId(org.openxdata.server.admin.model.FormDefVersionText instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersionText::formDefVersionTextId;
  }-*/;
  
  private static native void  setFormDefVersionTextId(org.openxdata.server.admin.model.FormDefVersionText instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersionText::formDefVersionTextId = value;
  }-*/;
  
  private static native java.lang.String getLayoutText(org.openxdata.server.admin.model.FormDefVersionText instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersionText::layoutText;
  }-*/;
  
  private static native void  setLayoutText(org.openxdata.server.admin.model.FormDefVersionText instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersionText::layoutText = value;
  }-*/;
  
  private static native java.lang.String getLocaleKey(org.openxdata.server.admin.model.FormDefVersionText instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersionText::localeKey;
  }-*/;
  
  private static native void  setLocaleKey(org.openxdata.server.admin.model.FormDefVersionText instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersionText::localeKey = value;
  }-*/;
  
  private static native java.lang.String getXformText(org.openxdata.server.admin.model.FormDefVersionText instance) /*-{
    return instance.@org.openxdata.server.admin.model.FormDefVersionText::xformText;
  }-*/;
  
  private static native void  setXformText(org.openxdata.server.admin.model.FormDefVersionText instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.FormDefVersionText::xformText = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.FormDefVersionText instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setFormDefVersionId(instance, streamReader.readInt());
    setFormDefVersionTextId(instance, streamReader.readInt());
    setLayoutText(instance, streamReader.readString());
    setLocaleKey(instance, streamReader.readString());
    setXformText(instance, streamReader.readString());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.FormDefVersionText instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.FormDefVersionText::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.FormDefVersionText instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeInt(getFormDefVersionId(instance));
    streamWriter.writeInt(getFormDefVersionTextId(instance));
    streamWriter.writeString(getLayoutText(instance));
    streamWriter.writeString(getLocaleKey(instance));
    streamWriter.writeString(getXformText(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
