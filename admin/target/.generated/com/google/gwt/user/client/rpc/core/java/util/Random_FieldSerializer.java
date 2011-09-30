package com.google.gwt.user.client.rpc.core.java.util;

@SuppressWarnings("deprecation")
public class Random_FieldSerializer {
  private static native boolean getHaveNextNextGaussian(java.util.Random instance) /*-{
    return instance.@java.util.Random::haveNextNextGaussian;
  }-*/;
  
  private static native void  setHaveNextNextGaussian(java.util.Random instance, boolean value) /*-{
    instance.@java.util.Random::haveNextNextGaussian = value;
  }-*/;
  
  private static native double getNextNextGaussian(java.util.Random instance) /*-{
    return instance.@java.util.Random::nextNextGaussian;
  }-*/;
  
  private static native void  setNextNextGaussian(java.util.Random instance, double value) /*-{
    instance.@java.util.Random::nextNextGaussian = value;
  }-*/;
  
  private static native double getSeedhi(java.util.Random instance) /*-{
    return instance.@java.util.Random::seedhi;
  }-*/;
  
  private static native void  setSeedhi(java.util.Random instance, double value) /*-{
    instance.@java.util.Random::seedhi = value;
  }-*/;
  
  private static native double getSeedlo(java.util.Random instance) /*-{
    return instance.@java.util.Random::seedlo;
  }-*/;
  
  private static native void  setSeedlo(java.util.Random instance, double value) /*-{
    instance.@java.util.Random::seedlo = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, java.util.Random instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setHaveNextNextGaussian(instance, streamReader.readBoolean());
    setNextNextGaussian(instance, streamReader.readDouble());
    setSeedhi(instance, streamReader.readDouble());
    setSeedlo(instance, streamReader.readDouble());
    
  }
  
  public static native java.util.Random instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @java.util.Random::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, java.util.Random instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeBoolean(getHaveNextNextGaussian(instance));
    streamWriter.writeDouble(getNextNextGaussian(instance));
    streamWriter.writeDouble(getSeedhi(instance));
    streamWriter.writeDouble(getSeedlo(instance));
    
  }
  
}
