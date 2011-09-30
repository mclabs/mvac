package com.google.gwt.user.client.ui;

import com.google.gwt.resources.client.ResourcePrototype;
import com.google.gwt.core.client.GWT;

public class com_google_gwt_user_client_ui_HorizontalSplitPanel_Resources_en_InlineClientBundleGenerator implements com.google.gwt.user.client.ui.HorizontalSplitPanel.Resources {
  public com.google.gwt.resources.client.ImageResource horizontalSplitPanelThumb() {
    if (horizontalSplitPanelThumb == null) {
      horizontalSplitPanelThumb = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
        "horizontalSplitPanelThumb",
        internedUrl0,
        0, 0, 7, 7, false, false
      );
    }
    return horizontalSplitPanelThumb;
  }
  private static final java.lang.String internedUrl0 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAcAAAAHCAYAAADEUlfTAAAArklEQVR42mNgAAI/Pz/xsLCweUC8KygoqJ4BBnx8fKRjYmJeBAQEPAwODr4THR39DIgPgSVBOoCCD+Pi4s5UVVWdaW5uPpOdnf02Pj7emyEiImJXYmLinUmTJp3ZsmXLmV27dp1pamp6UVxcXMgQFRXVnJ+f/xQkcerUqTMnTpw4W1tb+66trU0LbHRBQcH+urq6dz09PS9B9MSJExGOAgGgSnug0ekzZszQgokBAExeULnCXQAFAAAAAElFTkSuQmCC";
  private static com.google.gwt.resources.client.ImageResource horizontalSplitPanelThumb;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      horizontalSplitPanelThumb(), 
    };
  }
  public native ResourcePrototype getResource(String name) /*-{
    switch (name) {
      case 'horizontalSplitPanelThumb': return this.@com.google.gwt.user.client.ui.HorizontalSplitPanel.Resources::horizontalSplitPanelThumb()();
    }
    return null;
  }-*/;
}
