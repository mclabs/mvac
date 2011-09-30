package com.google.gwt.i18n.client.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class LocaleInfoImpl_shared extends com.google.gwt.i18n.client.impl.LocaleInfoImpl {
  private JavaScriptObject nativeDisplayNames;
  
  @Override
  public String[] getAvailableLocaleNames() {
    return new String[] {
      "default",
      "de_CH",
      "de_DE",
      "en",
      "en_GB",
      "en_UK",
      "fr",
      "fr_CA",
      "fr_CH",
      "fr_FR",
      "hu_HU",
      "it_CH",
      "it_IT",
      "lug_UG",
      "pl_PL",
      "pt_BR",
      "pt_PT",
    };
  }
  
  @Override
  public native String getLocaleNativeDisplayName(String localeName) /*-{
    this.@com.google.gwt.i18n.client.impl.LocaleInfoImpl_shared::ensureNativeDisplayNames()();
    return this.@com.google.gwt.i18n.client.impl.LocaleInfoImpl_shared::nativeDisplayNames[localeName];
  }-*/;
  
  private native void ensureNativeDisplayNames() /*-{
    if (this.@com.google.gwt.i18n.client.impl.LocaleInfoImpl_shared::nativeDisplayNames != null) {
      return;
    }
    this.@com.google.gwt.i18n.client.impl.LocaleInfoImpl_shared::nativeDisplayNames = {
      "de_CH": "Schweizer Hochdeutsch",
      "de_DE": "Deutsch - Deutschland",
      "en": "English",
      "en_GB": "British English",
      "fr": "français",
      "fr_CA": "français canadien",
      "fr_CH": "français suisse",
      "fr_FR": "français - France",
      "hu_HU": "magyar - Magyarország",
      "it_CH": "italiano - Svizzera",
      "it_IT": "italiano - Italia",
      "pl_PL": "polski - Polska",
      "pt_BR": "português do Brasil",
      "pt_PT": "português europeu"
    };
  }-*/;
}
