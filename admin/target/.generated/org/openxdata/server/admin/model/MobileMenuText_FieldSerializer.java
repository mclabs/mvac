package org.openxdata.server.admin.model;

@SuppressWarnings("deprecation")
public class MobileMenuText_FieldSerializer {
  private static native java.lang.String getLocaleKey(org.openxdata.server.admin.model.MobileMenuText instance) /*-{
    return instance.@org.openxdata.server.admin.model.MobileMenuText::localeKey;
  }-*/;
  
  private static native void  setLocaleKey(org.openxdata.server.admin.model.MobileMenuText instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.MobileMenuText::localeKey = value;
  }-*/;
  
  private static native short getMenuId(org.openxdata.server.admin.model.MobileMenuText instance) /*-{
    return instance.@org.openxdata.server.admin.model.MobileMenuText::menuId;
  }-*/;
  
  private static native void  setMenuId(org.openxdata.server.admin.model.MobileMenuText instance, short value) /*-{
    instance.@org.openxdata.server.admin.model.MobileMenuText::menuId = value;
  }-*/;
  
  private static native java.lang.String getMenuText(org.openxdata.server.admin.model.MobileMenuText instance) /*-{
    return instance.@org.openxdata.server.admin.model.MobileMenuText::menuText;
  }-*/;
  
  private static native void  setMenuText(org.openxdata.server.admin.model.MobileMenuText instance, java.lang.String value) /*-{
    instance.@org.openxdata.server.admin.model.MobileMenuText::menuText = value;
  }-*/;
  
  private static native int getMenuTextId(org.openxdata.server.admin.model.MobileMenuText instance) /*-{
    return instance.@org.openxdata.server.admin.model.MobileMenuText::menuTextId;
  }-*/;
  
  private static native void  setMenuTextId(org.openxdata.server.admin.model.MobileMenuText instance, int value) /*-{
    instance.@org.openxdata.server.admin.model.MobileMenuText::menuTextId = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, org.openxdata.server.admin.model.MobileMenuText instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setLocaleKey(instance, streamReader.readString());
    setMenuId(instance, streamReader.readShort());
    setMenuText(instance, streamReader.readString());
    setMenuTextId(instance, streamReader.readInt());
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static native org.openxdata.server.admin.model.MobileMenuText instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @org.openxdata.server.admin.model.MobileMenuText::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, org.openxdata.server.admin.model.MobileMenuText instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getLocaleKey(instance));
    streamWriter.writeShort(getMenuId(instance));
    streamWriter.writeString(getMenuText(instance));
    streamWriter.writeInt(getMenuTextId(instance));
    
    org.openxdata.server.admin.model.AbstractEditable_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
