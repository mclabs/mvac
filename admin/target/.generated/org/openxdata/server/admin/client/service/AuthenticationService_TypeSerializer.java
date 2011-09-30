package org.openxdata.server.admin.client.service;

import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.impl.Serializer;

public class AuthenticationService_TypeSerializer extends com.google.gwt.user.client.rpc.impl.SerializerBase {
  private static final MethodMap methodMap = JavaScriptObject.createObject().cast();
  private static final JsArrayString signatureMap = JavaScriptObject.createArray().cast();
  protected MethodMap getMethodMap() { return methodMap; }
  protected JsArrayString getSignatureMap() { return signatureMap; }
  
  static {
    registerMethods();
    registerSignatures();
  }
  private static native java.util.ArrayList create_com_google_gwt_user_client_rpc_core_java_util_ArrayList_CustomFieldSerializer(SerializationStreamReader streamReader) throws SerializationException /*-{
    return @java.util.ArrayList::new()();
  }-*/;
  
  private static native java.util.HashMap create_com_google_gwt_user_client_rpc_core_java_util_HashMap_CustomFieldSerializer(SerializationStreamReader streamReader) throws SerializationException /*-{
    return @java.util.HashMap::new()();
  }-*/;
  
  private static native java.util.HashSet create_com_google_gwt_user_client_rpc_core_java_util_HashSet_CustomFieldSerializer(SerializationStreamReader streamReader) throws SerializationException /*-{
    return @java.util.HashSet::new()();
  }-*/;
  
  private static native java.util.IdentityHashMap create_com_google_gwt_user_client_rpc_core_java_util_IdentityHashMap_CustomFieldSerializer(SerializationStreamReader streamReader) throws SerializationException /*-{
    return @java.util.IdentityHashMap::new()();
  }-*/;
  
  private static native java.util.LinkedList create_com_google_gwt_user_client_rpc_core_java_util_LinkedList_CustomFieldSerializer(SerializationStreamReader streamReader) throws SerializationException /*-{
    return @java.util.LinkedList::new()();
  }-*/;
  
  private static native java.util.Vector create_com_google_gwt_user_client_rpc_core_java_util_Vector_CustomFieldSerializer(SerializationStreamReader streamReader) throws SerializationException /*-{
    return @java.util.Vector::new()();
  }-*/;
  
  private static native void registerSignatures() /*-{
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.allen_sauer.gwt.dnd.client.DragHandlerCollection::class,
      "com.allen_sauer.gwt.dnd.client.DragHandlerCollection/3197961493");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.allen_sauer.gwt.dnd.client.VetoDragException::class,
      "com.allen_sauer.gwt.dnd.client.VetoDragException/1174378338");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.dom.client.Style$BorderStyle::class,
      "com.google.gwt.dom.client.Style$BorderStyle/2769837833");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.dom.client.Style$Cursor::class,
      "com.google.gwt.dom.client.Style$Cursor/2666657890");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.dom.client.Style$Display::class,
      "com.google.gwt.dom.client.Style$Display/1537475515");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.dom.client.Style$Float::class,
      "com.google.gwt.dom.client.Style$Float/1495215860");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.dom.client.Style$FontStyle::class,
      "com.google.gwt.dom.client.Style$FontStyle/2182768286");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.dom.client.Style$FontWeight::class,
      "com.google.gwt.dom.client.Style$FontWeight/3557458763");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.dom.client.Style$ListStyleType::class,
      "com.google.gwt.dom.client.Style$ListStyleType/1064239610");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.dom.client.Style$Overflow::class,
      "com.google.gwt.dom.client.Style$Overflow/982122884");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.dom.client.Style$Position::class,
      "com.google.gwt.dom.client.Style$Position/548017857");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.dom.client.Style$TextDecoration::class,
      "com.google.gwt.dom.client.Style$TextDecoration/3846779252");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.dom.client.Style$Unit::class,
      "com.google.gwt.dom.client.Style$Unit/269426519");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.dom.client.Style$VerticalAlign::class,
      "com.google.gwt.dom.client.Style$VerticalAlign/352429624");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.dom.client.Style$Visibility::class,
      "com.google.gwt.dom.client.Style$Visibility/1861510052");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.http.client.RequestException::class,
      "com.google.gwt.http.client.RequestException/190587325");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.i18n.client.HasDirection$Direction::class,
      "com.google.gwt.i18n.client.HasDirection$Direction/1284232723");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.i18n.client.impl.DateRecord::class,
      "com.google.gwt.i18n.client.impl.DateRecord/112389920");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.layout.client.Layout$Alignment::class,
      "com.google.gwt.layout.client.Layout$Alignment/1758648740");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.resources.client.ImageResource$RepeatStyle::class,
      "com.google.gwt.resources.client.ImageResource$RepeatStyle/2798118115");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException::class,
      "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.rpc.SerializableException::class,
      "com.google.gwt.user.client.rpc.SerializableException/3047383460");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.rpc.SerializationException::class,
      "com.google.gwt.user.client.rpc.SerializationException/2836333220");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.rpc.ServiceDefTarget$NoServiceEntryPointSpecifiedException::class,
      "com.google.gwt.user.client.rpc.ServiceDefTarget$NoServiceEntryPointSpecifiedException/3408313447");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter$ResponseReader::class,
      "com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter$ResponseReader/3885798731");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.ChangeListenerCollection::class,
      "com.google.gwt.user.client.ui.ChangeListenerCollection/687647911");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.ClickListenerCollection::class,
      "com.google.gwt.user.client.ui.ClickListenerCollection/3821115695");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.DockLayoutPanel$Direction::class,
      "com.google.gwt.user.client.ui.DockLayoutPanel$Direction/1124902987");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.FocusListenerCollection::class,
      "com.google.gwt.user.client.ui.FocusListenerCollection/666063950");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.FormHandlerCollection::class,
      "com.google.gwt.user.client.ui.FormHandlerCollection/917012841");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.KeyboardListenerCollection::class,
      "com.google.gwt.user.client.ui.KeyboardListenerCollection/1999488875");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.LoadListenerCollection::class,
      "com.google.gwt.user.client.ui.LoadListenerCollection/3375237009");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.MouseListenerCollection::class,
      "com.google.gwt.user.client.ui.MouseListenerCollection/3197118915");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.MouseWheelListenerCollection::class,
      "com.google.gwt.user.client.ui.MouseWheelListenerCollection/3231183817");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.MultiWordSuggestOracle$MultiWordSuggestion::class,
      "com.google.gwt.user.client.ui.MultiWordSuggestOracle$MultiWordSuggestion/2803420099");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.MultiWordSuggestOracle$MultiWordSuggestion[]::class,
      "[Lcom.google.gwt.user.client.ui.MultiWordSuggestOracle$MultiWordSuggestion;/1531882420");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.PopupListenerCollection::class,
      "com.google.gwt.user.client.ui.PopupListenerCollection/3060919138");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.PopupPanel$AnimationType::class,
      "com.google.gwt.user.client.ui.PopupPanel$AnimationType/2686977168");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.ScrollListenerCollection::class,
      "com.google.gwt.user.client.ui.ScrollListenerCollection/295710993");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.SuggestOracle$Request::class,
      "com.google.gwt.user.client.ui.SuggestOracle$Request/3707347745");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.SuggestOracle$Response::class,
      "com.google.gwt.user.client.ui.SuggestOracle$Response/3788519620");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.SuggestOracle$Suggestion[]::class,
      "[Lcom.google.gwt.user.client.ui.SuggestOracle$Suggestion;/3224244884");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.TabListenerCollection::class,
      "com.google.gwt.user.client.ui.TabListenerCollection/2392296549");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.TableListenerCollection::class,
      "com.google.gwt.user.client.ui.TableListenerCollection/285369783");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.ui.TreeListenerCollection::class,
      "com.google.gwt.user.client.ui.TreeListenerCollection/449704629");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @com.google.gwt.xml.client.impl.DOMParseException::class,
      "com.google.gwt.xml.client.impl.DOMParseException/3799120635");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.io.IOException::class,
      "java.io.IOException/1159940531");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.ArithmeticException::class,
      "java.lang.ArithmeticException/1539622151");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.ArrayIndexOutOfBoundsException::class,
      "java.lang.ArrayIndexOutOfBoundsException/600550433");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.ArrayStoreException::class,
      "java.lang.ArrayStoreException/3540507190");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.AssertionError::class,
      "java.lang.AssertionError/3490171458");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.Boolean::class,
      "java.lang.Boolean/476441737");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.Byte::class,
      "java.lang.Byte/1571082439");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.Character::class,
      "java.lang.Character/2663399736");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.ClassCastException::class,
      "java.lang.ClassCastException/702295179");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.Double::class,
      "java.lang.Double/858496421");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.Error::class,
      "java.lang.Error/1331973429");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.Exception::class,
      "java.lang.Exception/1920171873");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.Float::class,
      "java.lang.Float/1718559123");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.IllegalArgumentException::class,
      "java.lang.IllegalArgumentException/1755012560");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.IllegalStateException::class,
      "java.lang.IllegalStateException/1972187323");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.IndexOutOfBoundsException::class,
      "java.lang.IndexOutOfBoundsException/2489527753");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.Integer::class,
      "java.lang.Integer/3438268394");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.Long::class,
      "java.lang.Long/4227064769");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.NegativeArraySizeException::class,
      "java.lang.NegativeArraySizeException/3846860241");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.NullPointerException::class,
      "java.lang.NullPointerException/1463492344");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.NumberFormatException::class,
      "java.lang.NumberFormatException/3305228476");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.RuntimeException::class,
      "java.lang.RuntimeException/515124647");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.Short::class,
      "java.lang.Short/551743396");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.StackTraceElement::class,
      "java.lang.StackTraceElement/1098092073");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.String::class,
      "java.lang.String/2004016611");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.StringIndexOutOfBoundsException::class,
      "java.lang.StringIndexOutOfBoundsException/500777603");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.String[]::class,
      "[Ljava.lang.String;/2600011424");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.Throwable::class,
      "java.lang.Throwable/2953622131");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.UnsupportedOperationException::class,
      "java.lang.UnsupportedOperationException/3744010015");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.annotation.AnnotationFormatError::class,
      "java.lang.annotation.AnnotationFormatError/2257184627");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.annotation.AnnotationTypeMismatchException::class,
      "java.lang.annotation.AnnotationTypeMismatchException/976205828");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.annotation.ElementType::class,
      "java.lang.annotation.ElementType/15413163");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.lang.annotation.RetentionPolicy::class,
      "java.lang.annotation.RetentionPolicy/1244130522");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.sql.Date::class,
      "java.sql.Date/3996530531");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.sql.Time::class,
      "java.sql.Time/831929183");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.sql.Timestamp::class,
      "java.sql.Timestamp/1769758459");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.ArrayList::class,
      "java.util.ArrayList/3821976829");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.Arrays$ArrayList::class,
      "java.util.Arrays$ArrayList/1243019747");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.ConcurrentModificationException::class,
      "java.util.ConcurrentModificationException/2717383897");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.Date::class,
      "java.util.Date/1659716317");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.EmptyStackException::class,
      "java.util.EmptyStackException/89438517");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.HashMap::class,
      "java.util.HashMap/962170901");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.HashSet::class,
      "java.util.HashSet/1594477813");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.IdentityHashMap::class,
      "java.util.IdentityHashMap/3881143367");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.LinkedHashMap::class,
      "java.util.LinkedHashMap/1551059846");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.LinkedHashSet::class,
      "java.util.LinkedHashSet/3628722029");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.LinkedList::class,
      "java.util.LinkedList/1060625595");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.NoSuchElementException::class,
      "java.util.NoSuchElementException/1559248883");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.Random::class,
      "java.util.Random/1301739975");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.Stack::class,
      "java.util.Stack/1031431137");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.TooManyListenersException::class,
      "java.util.TooManyListenersException/2023078032");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.TreeMap::class,
      "java.util.TreeMap/1575826026");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.TreeSet::class,
      "java.util.TreeSet/1002270346");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @java.util.Vector::class,
      "java.util.Vector/3125574444");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.customware.gwt.dispatch.shared.ActionException::class,
      "net.customware.gwt.dispatch.shared.ActionException/1936455038");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.customware.gwt.dispatch.shared.BatchAction$OnException::class,
      "net.customware.gwt.dispatch.shared.BatchAction$OnException/2668157727");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.customware.gwt.dispatch.shared.UnsupportedActionException::class,
      "net.customware.gwt.dispatch.shared.UnsupportedActionException/3409690421");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.base.ILightEntity[]::class,
      "[Lnet.sf.gilead.pojo.base.ILightEntity;/3861184979");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.GwtSerializableId::class,
      "net.sf.gilead.pojo.gwt.GwtSerializableId/4079459173");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.GwtSerializableId[]::class,
      "[Lnet.sf.gilead.pojo.gwt.GwtSerializableId;/3533025312");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.IGwtSerializableParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.IGwtSerializableParameter;/2071697777");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.LightEntity[]::class,
      "[Lnet.sf.gilead.pojo.gwt.LightEntity;/3449970074");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.SerializedParameter::class,
      "net.sf.gilead.pojo.gwt.SerializedParameter/132341980");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.SerializedParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.SerializedParameter;/2694220992");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.BooleanParameter::class,
      "net.sf.gilead.pojo.gwt.basic.BooleanParameter/2694046737");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.BooleanParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.basic.BooleanParameter;/659978017");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.ByteParameter::class,
      "net.sf.gilead.pojo.gwt.basic.ByteParameter/2737926916");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.ByteParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.basic.ByteParameter;/2840751033");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.CharacterParameter::class,
      "net.sf.gilead.pojo.gwt.basic.CharacterParameter/3361494208");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.CharacterParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.basic.CharacterParameter;/537814816");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.DateParameter::class,
      "net.sf.gilead.pojo.gwt.basic.DateParameter/3691507541");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.DateParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.basic.DateParameter;/2753979251");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.DoubleParameter::class,
      "net.sf.gilead.pojo.gwt.basic.DoubleParameter/367474200");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.DoubleParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.basic.DoubleParameter;/2828072013");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.FloatParameter::class,
      "net.sf.gilead.pojo.gwt.basic.FloatParameter/2266458363");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.FloatParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.basic.FloatParameter;/1883925208");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.IntegerParameter::class,
      "net.sf.gilead.pojo.gwt.basic.IntegerParameter/3421404974");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.IntegerParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.basic.IntegerParameter;/408650838");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.LongParameter::class,
      "net.sf.gilead.pojo.gwt.basic.LongParameter/1349029528");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.LongParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.basic.LongParameter;/3419125299");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.ShortParameter::class,
      "net.sf.gilead.pojo.gwt.basic.ShortParameter/3591328655");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.ShortParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.basic.ShortParameter;/1337822491");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.StringParameter::class,
      "net.sf.gilead.pojo.gwt.basic.StringParameter/2783524083");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.basic.StringParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.basic.StringParameter;/2215125269");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.collection.ListParameter::class,
      "net.sf.gilead.pojo.gwt.collection.ListParameter/3890945144");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.collection.ListParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.collection.ListParameter;/2269834606");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.collection.MapParameter::class,
      "net.sf.gilead.pojo.gwt.collection.MapParameter/1940144086");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.collection.MapParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.collection.MapParameter;/1810339670");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.collection.SetParameter::class,
      "net.sf.gilead.pojo.gwt.collection.SetParameter/3311896573");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @net.sf.gilead.pojo.gwt.collection.SetParameter[]::class,
      "[Lnet.sf.gilead.pojo.gwt.collection.SetParameter;/3930796824");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.client.event.ACTION::class,
      "org.openxdata.modules.workflows.client.event.ACTION/1417808955");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.client.maps.SpecStudyMap::class,
      "org.openxdata.modules.workflows.client.maps.SpecStudyMap/40541639");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.client.maps.TaskFormDefMap::class,
      "org.openxdata.modules.workflows.client.maps.TaskFormDefMap/4080592458");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.DBSpecStudyMap::class,
      "org.openxdata.modules.workflows.model.shared.DBSpecStudyMap/883597168");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.DBSpecStudyMap[]::class,
      "[Lorg.openxdata.modules.workflows.model.shared.DBSpecStudyMap;/712588583");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.DBSpecification::class,
      "org.openxdata.modules.workflows.model.shared.DBSpecification/2573613644");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.DBSpecification[]::class,
      "[Lorg.openxdata.modules.workflows.model.shared.DBSpecification;/3373382586");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.DBWorkitem::class,
      "org.openxdata.modules.workflows.model.shared.DBWorkitem/4198381441");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.DBWorkitem[]::class,
      "[Lorg.openxdata.modules.workflows.model.shared.DBWorkitem;/2246806208");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem::class,
      "org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem/2493820116");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.ODecomposition::class,
      "org.openxdata.modules.workflows.model.shared.ODecomposition/3639879065");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.OParameter::class,
      "org.openxdata.modules.workflows.model.shared.OParameter/1731418771");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.OParameter$Flow::class,
      "org.openxdata.modules.workflows.model.shared.OParameter$Flow/1068938111");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.OSpecification::class,
      "org.openxdata.modules.workflows.model.shared.OSpecification/3722947521");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.OTask::class,
      "org.openxdata.modules.workflows.model.shared.OTask/356769286");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO::class,
      "org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO/192434349");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.shared.rpc.GetSpecsAction::class,
      "org.openxdata.modules.workflows.shared.rpc.GetSpecsAction/3450705413");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.shared.rpc.GetSpecsAction$Result::class,
      "org.openxdata.modules.workflows.shared.rpc.GetSpecsAction$Result/3311661682");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.shared.rpc.GetStudiesAction::class,
      "org.openxdata.modules.workflows.shared.rpc.GetStudiesAction/673062037");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.shared.rpc.GetStudiesAction$Result::class,
      "org.openxdata.modules.workflows.shared.rpc.GetStudiesAction$Result/2663011514");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.shared.rpc.ParseSpecAction::class,
      "org.openxdata.modules.workflows.shared.rpc.ParseSpecAction/229058437");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.shared.rpc.ParseSpecAction$Result::class,
      "org.openxdata.modules.workflows.shared.rpc.ParseSpecAction$Result/932556104");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.client.util.CronEntity$CronType::class,
      "org.openxdata.server.admin.client.util.CronEntity$CronType/2963716724");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.AbstractEditable[]::class,
      "[Lorg.openxdata.server.admin.model.AbstractEditable;/3682085886");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.ExportedDataType::class,
      "org.openxdata.server.admin.model.ExportedDataType/2739284275");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.ExportedDataType$DataTypeBoolean::class,
      "org.openxdata.server.admin.model.ExportedDataType$DataTypeBoolean/3035213053");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.ExportedDataType$DataTypeDate::class,
      "org.openxdata.server.admin.model.ExportedDataType$DataTypeDate/481305177");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.ExportedDataType$DataTypeDouble::class,
      "org.openxdata.server.admin.model.ExportedDataType$DataTypeDouble/3794348323");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.ExportedDataType$DataTypeInteger::class,
      "org.openxdata.server.admin.model.ExportedDataType$DataTypeInteger/668461207");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.ExportedDataType$DataTypeString::class,
      "org.openxdata.server.admin.model.ExportedDataType$DataTypeString/1577214727");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.ExportedFormData::class,
      "org.openxdata.server.admin.model.ExportedFormData/550182800");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.ExportedFormDataList::class,
      "org.openxdata.server.admin.model.ExportedFormDataList/1294369846");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.ExportedFormDataList[]::class,
      "[Lorg.openxdata.server.admin.model.ExportedFormDataList;/3323454926");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.ExportedFormData[]::class,
      "[Lorg.openxdata.server.admin.model.ExportedFormData;/2671356400");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormData::class,
      "org.openxdata.server.admin.model.FormData/669483682");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormDataHeader::class,
      "org.openxdata.server.admin.model.FormDataHeader/438593830");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormDataHeader[]::class,
      "[Lorg.openxdata.server.admin.model.FormDataHeader;/4143830484");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormDataVersion::class,
      "org.openxdata.server.admin.model.FormDataVersion/3418963757");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormDataVersion[]::class,
      "[Lorg.openxdata.server.admin.model.FormDataVersion;/2291877296");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormData[]::class,
      "[Lorg.openxdata.server.admin.model.FormData;/3712340536");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormDef::class,
      "org.openxdata.server.admin.model.FormDef/141965068");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormDefText::class,
      "org.openxdata.server.admin.model.FormDefText/1818126158");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormDefText[]::class,
      "[Lorg.openxdata.server.admin.model.FormDefText;/826312313");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormDefVersion::class,
      "org.openxdata.server.admin.model.FormDefVersion/3312619097");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormDefVersionText::class,
      "org.openxdata.server.admin.model.FormDefVersionText/18245592");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormDefVersionText[]::class,
      "[Lorg.openxdata.server.admin.model.FormDefVersionText;/289985101");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormDefVersion[]::class,
      "[Lorg.openxdata.server.admin.model.FormDefVersion;/3048165195");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormDef[]::class,
      "[Lorg.openxdata.server.admin.model.FormDef;/4027982323");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormSmsArchive::class,
      "org.openxdata.server.admin.model.FormSmsArchive/2587987833");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormSmsArchive[]::class,
      "[Lorg.openxdata.server.admin.model.FormSmsArchive;/2449947473");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormSmsError::class,
      "org.openxdata.server.admin.model.FormSmsError/402375958");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.FormSmsError[]::class,
      "[Lorg.openxdata.server.admin.model.FormSmsError;/2148055138");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.Locale::class,
      "org.openxdata.server.admin.model.Locale/511307334");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.Locale[]::class,
      "[Lorg.openxdata.server.admin.model.Locale;/3231908972");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.MobileMenuText::class,
      "org.openxdata.server.admin.model.MobileMenuText/2521859443");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.MobileMenuText[]::class,
      "[Lorg.openxdata.server.admin.model.MobileMenuText;/3230105197");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.Permission::class,
      "org.openxdata.server.admin.model.Permission/3900349777");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.Permission[]::class,
      "[Lorg.openxdata.server.admin.model.Permission;/823405003");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.Report::class,
      "org.openxdata.server.admin.model.Report/2003074756");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.ReportGroup::class,
      "org.openxdata.server.admin.model.ReportGroup/74344348");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.ReportGroup[]::class,
      "[Lorg.openxdata.server.admin.model.ReportGroup;/360764835");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.ReportUserMap::class,
      "org.openxdata.server.admin.model.ReportUserMap/1712655250");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.ReportUserMap[]::class,
      "[Lorg.openxdata.server.admin.model.ReportUserMap;/2062619609");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.Report[]::class,
      "[Lorg.openxdata.server.admin.model.Report;/125191226");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.Role::class,
      "org.openxdata.server.admin.model.Role/4048295481");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.Role[]::class,
      "[Lorg.openxdata.server.admin.model.Role;/700324796");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.Setting::class,
      "org.openxdata.server.admin.model.Setting/2518311461");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.SettingGroup::class,
      "org.openxdata.server.admin.model.SettingGroup/3809470920");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.SettingGroup[]::class,
      "[Lorg.openxdata.server.admin.model.SettingGroup;/23270514");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.Setting[]::class,
      "[Lorg.openxdata.server.admin.model.Setting;/3894462238");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.StudyDef::class,
      "org.openxdata.server.admin.model.StudyDef/2343592517");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.StudyDefText::class,
      "org.openxdata.server.admin.model.StudyDefText/3102970746");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.StudyDefText[]::class,
      "[Lorg.openxdata.server.admin.model.StudyDefText;/3593446375");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.StudyDef[]::class,
      "[Lorg.openxdata.server.admin.model.StudyDef;/473800205");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.StudyUserMap::class,
      "org.openxdata.server.admin.model.StudyUserMap/2458132194");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.StudyUserMap[]::class,
      "[Lorg.openxdata.server.admin.model.StudyUserMap;/1375394302");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.TaskDef::class,
      "org.openxdata.server.admin.model.TaskDef/636505884");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.TaskDef[]::class,
      "[Lorg.openxdata.server.admin.model.TaskDef;/59864267");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.TaskParam::class,
      "org.openxdata.server.admin.model.TaskParam/858745130");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.TaskParam[]::class,
      "[Lorg.openxdata.server.admin.model.TaskParam;/3408107169");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.User::class,
      "org.openxdata.server.admin.model.User/2493671347");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.User[]::class,
      "[Lorg.openxdata.server.admin.model.User;/3783754529");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.ContextException::class,
      "org.openxdata.server.admin.model.exception.ContextException/1531694116");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException/3185263335");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataException/534124950");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataParsingException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataParsingException/2600572337");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataRuntimeException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataRuntimeException/51530723");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataSecurityException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataSecurityException/2054087488");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataSessionExpiredException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataSessionExpiredException/4188424438");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataValidationException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataValidationException/991789436");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXdataDataAccessException::class,
      "org.openxdata.server.admin.model.exception.OpenXdataDataAccessException/1308223918");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.ReplaceThisExceptionRuntimeException::class,
      "org.openxdata.server.admin.model.exception.ReplaceThisExceptionRuntimeException/919674052");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.UnexpectedException::class,
      "org.openxdata.server.admin.model.exception.UnexpectedException/2433619902");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.UserNotFoundException::class,
      "org.openxdata.server.admin.model.exception.UserNotFoundException/260296396");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.mapping.UserFormMap::class,
      "org.openxdata.server.admin.model.mapping.UserFormMap/4284888440");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.mapping.UserFormMap[]::class,
      "[Lorg.openxdata.server.admin.model.mapping.UserFormMap;/909395769");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.mapping.UserReportGroupMap::class,
      "org.openxdata.server.admin.model.mapping.UserReportGroupMap/4053001426");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.mapping.UserReportGroupMap[]::class,
      "[Lorg.openxdata.server.admin.model.mapping.UserReportGroupMap;/1325504761");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.mapping.UserReportMap::class,
      "org.openxdata.server.admin.model.mapping.UserReportMap/3581611453");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.mapping.UserReportMap[]::class,
      "[Lorg.openxdata.server.admin.model.mapping.UserReportMap;/3845254698");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.mapping.UserStudyMap::class,
      "org.openxdata.server.admin.model.mapping.UserStudyMap/451157830");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.mapping.UserStudyMap[]::class,
      "[Lorg.openxdata.server.admin.model.mapping.UserStudyMap;/3155378308");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.util.DiagnosedStatus::class,
      "org.openxdata.server.admin.model.util.DiagnosedStatus/3551064309");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.util.Diagnosis::class,
      "org.openxdata.server.admin.model.util.Diagnosis/489819592");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.util.ErrorRiskLevel::class,
      "org.openxdata.server.admin.model.util.ErrorRiskLevel/1255873120");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.util.OpenXDataEmail::class,
      "org.openxdata.server.admin.model.util.OpenXDataEmail/1832342926");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.purc.purcforms.client.model.DisplayField::class,
      "org.purc.purcforms.client.model.DisplayField/4087645775");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.purc.purcforms.client.model.FilterCondition::class,
      "org.purc.purcforms.client.model.FilterCondition/1324066477");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.purc.purcforms.client.model.FilterConditionGroup::class,
      "org.purc.purcforms.client.model.FilterConditionGroup/672018332");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.purc.purcforms.client.model.FilterConditionGroup[]::class,
      "[Lorg.purc.purcforms.client.model.FilterConditionGroup;/2568993387");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.purc.purcforms.client.model.FilterConditionRow::class,
      "org.purc.purcforms.client.model.FilterConditionRow/1625140544");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.purc.purcforms.client.model.FilterConditionRow[]::class,
      "[Lorg.purc.purcforms.client.model.FilterConditionRow;/1169401321");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.purc.purcforms.client.model.FilterCondition[]::class,
      "[Lorg.purc.purcforms.client.model.FilterCondition;/3566707007");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.purc.purcforms.client.model.ModelConstants::class,
      "org.purc.purcforms.client.model.ModelConstants/1479937812");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.purc.purcforms.client.model.SkipRule::class,
      "org.purc.purcforms.client.model.SkipRule/2993525537");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::signatureMap,
      @org.purc.purcforms.client.model.SortField::class,
      "org.purc.purcforms.client.model.SortField/557051153");
    
  }-*/;
  
  private static native void registerMethods() /*-{
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.allen_sauer.gwt.dnd.client.DragHandlerCollection/3197961493" , [
        @com.allen_sauer.gwt.dnd.client.DragHandlerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.allen_sauer.gwt.dnd.client.DragHandlerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/allen_sauer/gwt/dnd/client/DragHandlerCollection;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.allen_sauer.gwt.dnd.client.VetoDragException/1174378338" , [
        @com.allen_sauer.gwt.dnd.client.VetoDragException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.allen_sauer.gwt.dnd.client.VetoDragException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/allen_sauer/gwt/dnd/client/VetoDragException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.dom.client.Style$BorderStyle/2769837833" , [
        @com.google.gwt.dom.client.Style_BorderStyle_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_BorderStyle_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$BorderStyle;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.dom.client.Style$Cursor/2666657890" , [
        @com.google.gwt.dom.client.Style_Cursor_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_Cursor_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$Cursor;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.dom.client.Style$Display/1537475515" , [
        @com.google.gwt.dom.client.Style_Display_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_Display_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$Display;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.dom.client.Style$Float/1495215860" , [
        @com.google.gwt.dom.client.Style_Float_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_Float_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$Float;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.dom.client.Style$FontStyle/2182768286" , [
        @com.google.gwt.dom.client.Style_FontStyle_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_FontStyle_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$FontStyle;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.dom.client.Style$FontWeight/3557458763" , [
        @com.google.gwt.dom.client.Style_FontWeight_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_FontWeight_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$FontWeight;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.dom.client.Style$ListStyleType/1064239610" , [
        @com.google.gwt.dom.client.Style_ListStyleType_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_ListStyleType_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$ListStyleType;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.dom.client.Style$Overflow/982122884" , [
        @com.google.gwt.dom.client.Style_Overflow_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_Overflow_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$Overflow;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.dom.client.Style$Position/548017857" , [
        @com.google.gwt.dom.client.Style_Position_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_Position_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$Position;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.dom.client.Style$TextDecoration/3846779252" , [
        @com.google.gwt.dom.client.Style_TextDecoration_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_TextDecoration_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$TextDecoration;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.dom.client.Style$Unit/269426519" , [
        @com.google.gwt.dom.client.Style_Unit_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_Unit_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$Unit;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.dom.client.Style$VerticalAlign/352429624" , [
        @com.google.gwt.dom.client.Style_VerticalAlign_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_VerticalAlign_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$VerticalAlign;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.dom.client.Style$Visibility/1861510052" , [
        @com.google.gwt.dom.client.Style_Visibility_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_Visibility_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$Visibility;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.http.client.RequestException/190587325" , [
        @com.google.gwt.http.client.RequestException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.http.client.RequestException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/http/client/RequestException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.i18n.client.HasDirection$Direction/1284232723" , [
        @com.google.gwt.i18n.client.HasDirection_Direction_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.i18n.client.HasDirection_Direction_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/i18n/client/HasDirection$Direction;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.i18n.client.impl.DateRecord/112389920" , [
        @com.google.gwt.i18n.client.impl.DateRecord_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.i18n.client.impl.DateRecord_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/i18n/client/impl/DateRecord;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.layout.client.Layout$Alignment/1758648740" , [
        @com.google.gwt.layout.client.Layout_Alignment_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.layout.client.Layout_Alignment_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/layout/client/Layout$Alignment;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.resources.client.ImageResource$RepeatStyle/2798118115" , [
        @com.google.gwt.resources.client.ImageResource_RepeatStyle_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.resources.client.ImageResource_RepeatStyle_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/resources/client/ImageResource$RepeatStyle;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533" , [
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;)
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.rpc.SerializableException/3047383460" , [
        @com.google.gwt.user.client.rpc.SerializableException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.SerializableException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/SerializableException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.rpc.SerializationException/2836333220" , [
        @com.google.gwt.user.client.rpc.SerializationException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.SerializationException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/SerializationException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.rpc.ServiceDefTarget$NoServiceEntryPointSpecifiedException/3408313447" , [
        @com.google.gwt.user.client.rpc.ServiceDefTarget_NoServiceEntryPointSpecifiedException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.ServiceDefTarget_NoServiceEntryPointSpecifiedException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/ServiceDefTarget$NoServiceEntryPointSpecifiedException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter$ResponseReader/3885798731" , [
        @com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter_ResponseReader_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter_ResponseReader_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/impl/RequestCallbackAdapter$ResponseReader;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.ChangeListenerCollection/687647911" , [
        @com.google.gwt.user.client.ui.ChangeListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.ChangeListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/ChangeListenerCollection;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.ClickListenerCollection/3821115695" , [
        @com.google.gwt.user.client.ui.ClickListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.ClickListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/ClickListenerCollection;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.DockLayoutPanel$Direction/1124902987" , [
        @com.google.gwt.user.client.ui.DockLayoutPanel_Direction_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.DockLayoutPanel_Direction_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/DockLayoutPanel$Direction;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.FocusListenerCollection/666063950" , [
        @com.google.gwt.user.client.ui.FocusListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.FocusListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/FocusListenerCollection;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.FormHandlerCollection/917012841" , [
        @com.google.gwt.user.client.ui.FormHandlerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.FormHandlerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/FormHandlerCollection;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.KeyboardListenerCollection/1999488875" , [
        @com.google.gwt.user.client.ui.KeyboardListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.KeyboardListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/KeyboardListenerCollection;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.LoadListenerCollection/3375237009" , [
        @com.google.gwt.user.client.ui.LoadListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.LoadListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/LoadListenerCollection;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.MouseListenerCollection/3197118915" , [
        @com.google.gwt.user.client.ui.MouseListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.MouseListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/MouseListenerCollection;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.MouseWheelListenerCollection/3231183817" , [
        @com.google.gwt.user.client.ui.MouseWheelListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.MouseWheelListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/MouseWheelListenerCollection;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.MultiWordSuggestOracle$MultiWordSuggestion/2803420099" , [
        @com.google.gwt.user.client.ui.MultiWordSuggestOracle_MultiWordSuggestion_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.MultiWordSuggestOracle_MultiWordSuggestion_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/MultiWordSuggestOracle$MultiWordSuggestion;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lcom.google.gwt.user.client.ui.MultiWordSuggestOracle$MultiWordSuggestion;/1531882420" , [
        @com.google.gwt.user.client.ui.MultiWordSuggestOracle_MultiWordSuggestion_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.MultiWordSuggestOracle_MultiWordSuggestion_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/google/gwt/user/client/ui/MultiWordSuggestOracle$MultiWordSuggestion;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.PopupListenerCollection/3060919138" , [
        @com.google.gwt.user.client.ui.PopupListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.PopupListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/PopupListenerCollection;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.PopupPanel$AnimationType/2686977168" , [
        @com.google.gwt.user.client.ui.PopupPanel_AnimationType_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.PopupPanel_AnimationType_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/PopupPanel$AnimationType;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.ScrollListenerCollection/295710993" , [
        @com.google.gwt.user.client.ui.ScrollListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.ScrollListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/ScrollListenerCollection;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.SuggestOracle$Request/3707347745" , [
        @com.google.gwt.user.client.ui.SuggestOracle_Request_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.SuggestOracle_Request_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/SuggestOracle$Request;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.SuggestOracle$Response/3788519620" , [
        @com.google.gwt.user.client.ui.SuggestOracle_Response_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.SuggestOracle_Response_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/SuggestOracle$Response;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lcom.google.gwt.user.client.ui.SuggestOracle$Suggestion;/3224244884" , [
        @com.google.gwt.user.client.ui.SuggestOracle_Suggestion_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.SuggestOracle_Suggestion_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/google/gwt/user/client/ui/SuggestOracle$Suggestion;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.TabListenerCollection/2392296549" , [
        @com.google.gwt.user.client.ui.TabListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.TabListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/TabListenerCollection;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.TableListenerCollection/285369783" , [
        @com.google.gwt.user.client.ui.TableListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.TableListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/TableListenerCollection;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.ui.TreeListenerCollection/449704629" , [
        @com.google.gwt.user.client.ui.TreeListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.TreeListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/TreeListenerCollection;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "com.google.gwt.xml.client.impl.DOMParseException/3799120635" , [
        @com.google.gwt.xml.client.impl.DOMParseException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.xml.client.impl.DOMParseException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/xml/client/impl/DOMParseException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.io.IOException/1159940531" , [
        @com.google.gwt.user.client.rpc.core.java.io.IOException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.io.IOException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/io/IOException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.ArithmeticException/1539622151" , [
        @com.google.gwt.user.client.rpc.core.java.lang.ArithmeticException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.ArithmeticException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/ArithmeticException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.ArrayIndexOutOfBoundsException/600550433" , [
        @com.google.gwt.user.client.rpc.core.java.lang.ArrayIndexOutOfBoundsException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.ArrayIndexOutOfBoundsException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/ArrayIndexOutOfBoundsException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.ArrayStoreException/3540507190" , [
        @com.google.gwt.user.client.rpc.core.java.lang.ArrayStoreException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.ArrayStoreException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/ArrayStoreException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.AssertionError/3490171458" , [
        @com.google.gwt.user.client.rpc.core.java.lang.AssertionError_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.AssertionError_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/AssertionError;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.Boolean/476441737" , [
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Boolean;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.Byte/1571082439" , [
        @com.google.gwt.user.client.rpc.core.java.lang.Byte_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Byte_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Byte;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.Character/2663399736" , [
        @com.google.gwt.user.client.rpc.core.java.lang.Character_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Character_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Character;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.ClassCastException/702295179" , [
        @com.google.gwt.user.client.rpc.core.java.lang.ClassCastException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.ClassCastException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/ClassCastException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.Double/858496421" , [
        @com.google.gwt.user.client.rpc.core.java.lang.Double_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Double_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Double;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.Error/1331973429" , [
        @com.google.gwt.user.client.rpc.core.java.lang.Error_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Error_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Error;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.Exception/1920171873" , [
        @com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Exception;),
        @com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Exception;)
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.Float/1718559123" , [
        @com.google.gwt.user.client.rpc.core.java.lang.Float_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Float_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Float;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.IllegalArgumentException/1755012560" , [
        @com.google.gwt.user.client.rpc.core.java.lang.IllegalArgumentException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.IllegalArgumentException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/IllegalArgumentException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.IllegalStateException/1972187323" , [
        @com.google.gwt.user.client.rpc.core.java.lang.IllegalStateException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.IllegalStateException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/IllegalStateException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.IndexOutOfBoundsException/2489527753" , [
        @com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/IndexOutOfBoundsException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.Integer/3438268394" , [
        @com.google.gwt.user.client.rpc.core.java.lang.Integer_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Integer_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Integer;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.Long/4227064769" , [
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Long;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.NegativeArraySizeException/3846860241" , [
        @com.google.gwt.user.client.rpc.core.java.lang.NegativeArraySizeException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.NegativeArraySizeException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/NegativeArraySizeException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.NullPointerException/1463492344" , [
        @com.google.gwt.user.client.rpc.core.java.lang.NullPointerException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.NullPointerException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/NullPointerException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.NumberFormatException/3305228476" , [
        @com.google.gwt.user.client.rpc.core.java.lang.NumberFormatException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.NumberFormatException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/NumberFormatException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.RuntimeException/515124647" , [
        @com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/RuntimeException;),
        @com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/RuntimeException;)
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.Short/551743396" , [
        @com.google.gwt.user.client.rpc.core.java.lang.Short_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Short_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Short;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.StackTraceElement/1098092073" , [
        @com.google.gwt.user.client.rpc.core.java.lang.StackTraceElement_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.StackTraceElement_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/StackTraceElement;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.String/2004016611" , [
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/String;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/String;)
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.StringIndexOutOfBoundsException/500777603" , [
        @com.google.gwt.user.client.rpc.core.java.lang.StringIndexOutOfBoundsException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.StringIndexOutOfBoundsException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/StringIndexOutOfBoundsException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Ljava.lang.String;/2600011424" , [
        @com.google.gwt.user.client.rpc.core.java.lang.String_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Ljava/lang/String;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.Throwable/2953622131" , [
        @com.google.gwt.user.client.rpc.core.java.lang.Throwable_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Throwable_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Throwable;),
        @com.google.gwt.user.client.rpc.core.java.lang.Throwable_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Throwable;)
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.UnsupportedOperationException/3744010015" , [
        @com.google.gwt.user.client.rpc.core.java.lang.UnsupportedOperationException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.UnsupportedOperationException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/UnsupportedOperationException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.annotation.AnnotationFormatError/2257184627" , [
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.AnnotationFormatError_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.AnnotationFormatError_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/annotation/AnnotationFormatError;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.annotation.AnnotationTypeMismatchException/976205828" , [
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.AnnotationTypeMismatchException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.AnnotationTypeMismatchException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/annotation/AnnotationTypeMismatchException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.annotation.ElementType/15413163" , [
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.ElementType_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.ElementType_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/annotation/ElementType;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.lang.annotation.RetentionPolicy/1244130522" , [
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.RetentionPolicy_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.RetentionPolicy_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/annotation/RetentionPolicy;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.sql.Date/3996530531" , [
        @com.google.gwt.user.client.rpc.core.java.sql.Date_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.sql.Date_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/sql/Date;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.sql.Time/831929183" , [
        @com.google.gwt.user.client.rpc.core.java.sql.Time_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.sql.Time_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/sql/Time;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.sql.Timestamp/1769758459" , [
        @com.google.gwt.user.client.rpc.core.java.sql.Timestamp_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.sql.Timestamp_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/sql/Timestamp;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.ArrayList/3821976829" , [
        @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::create_com_google_gwt_user_client_rpc_core_java_util_ArrayList_CustomFieldSerializer(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/ArrayList;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.Arrays$ArrayList/1243019747" , [
        @com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/List;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.ConcurrentModificationException/2717383897" , [
        @com.google.gwt.user.client.rpc.core.java.util.ConcurrentModificationException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.ConcurrentModificationException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/ConcurrentModificationException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.Date/1659716317" , [
        @com.google.gwt.user.client.rpc.core.java.util.Date_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Date_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Date;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.EmptyStackException/89438517" , [
        @com.google.gwt.user.client.rpc.core.java.util.EmptyStackException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.EmptyStackException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/EmptyStackException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.HashMap/962170901" , [
        @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::create_com_google_gwt_user_client_rpc_core_java_util_HashMap_CustomFieldSerializer(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.HashMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/HashMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.HashSet/1594477813" , [
        @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::create_com_google_gwt_user_client_rpc_core_java_util_HashSet_CustomFieldSerializer(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.HashSet_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/HashSet;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.IdentityHashMap/3881143367" , [
        @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::create_com_google_gwt_user_client_rpc_core_java_util_IdentityHashMap_CustomFieldSerializer(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.IdentityHashMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/IdentityHashMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.LinkedHashMap/1551059846" , [
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/LinkedHashMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.LinkedHashSet/3628722029" , [
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/LinkedHashSet;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.LinkedList/1060625595" , [
        @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::create_com_google_gwt_user_client_rpc_core_java_util_LinkedList_CustomFieldSerializer(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/LinkedList;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.NoSuchElementException/1559248883" , [
        @com.google.gwt.user.client.rpc.core.java.util.NoSuchElementException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.NoSuchElementException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/NoSuchElementException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.Random/1301739975" , [
        @com.google.gwt.user.client.rpc.core.java.util.Random_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Random_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Random;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.Stack/1031431137" , [
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Stack;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.TooManyListenersException/2023078032" , [
        @com.google.gwt.user.client.rpc.core.java.util.TooManyListenersException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.TooManyListenersException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/TooManyListenersException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.TreeMap/1575826026" , [
        @com.google.gwt.user.client.rpc.core.java.util.TreeMap_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.TreeMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/TreeMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.TreeSet/1002270346" , [
        @com.google.gwt.user.client.rpc.core.java.util.TreeSet_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.TreeSet_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/TreeSet;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "java.util.Vector/3125574444" , [
        @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::create_com_google_gwt_user_client_rpc_core_java_util_Vector_CustomFieldSerializer(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Vector;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.customware.gwt.dispatch.shared.ActionException/1936455038" , [
        @net.customware.gwt.dispatch.shared.ActionException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.customware.gwt.dispatch.shared.ActionException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/customware/gwt/dispatch/shared/ActionException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.customware.gwt.dispatch.shared.BatchAction$OnException/2668157727" , [
        @net.customware.gwt.dispatch.shared.BatchAction_OnException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.customware.gwt.dispatch.shared.BatchAction_OnException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/customware/gwt/dispatch/shared/BatchAction$OnException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.customware.gwt.dispatch.shared.UnsupportedActionException/3409690421" , [
        @net.customware.gwt.dispatch.shared.UnsupportedActionException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.customware.gwt.dispatch.shared.UnsupportedActionException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/customware/gwt/dispatch/shared/UnsupportedActionException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.base.ILightEntity;/3861184979" , [
        @net.sf.gilead.pojo.base.ILightEntity_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.base.ILightEntity_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/base/ILightEntity;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.GwtSerializableId/4079459173" , [
        @net.sf.gilead.pojo.gwt.GwtSerializableId_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.GwtSerializableId_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/GwtSerializableId;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.GwtSerializableId;/3533025312" , [
        @net.sf.gilead.pojo.gwt.GwtSerializableId_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.GwtSerializableId_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/GwtSerializableId;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.IGwtSerializableParameter;/2071697777" , [
        @net.sf.gilead.pojo.gwt.IGwtSerializableParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.IGwtSerializableParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/IGwtSerializableParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.LightEntity;/3449970074" , [
        @net.sf.gilead.pojo.gwt.LightEntity_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.LightEntity_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/LightEntity;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.SerializedParameter/132341980" , [
        @net.sf.gilead.pojo.gwt.SerializedParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.SerializedParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/SerializedParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.SerializedParameter;/2694220992" , [
        @net.sf.gilead.pojo.gwt.SerializedParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.SerializedParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/SerializedParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.basic.BooleanParameter/2694046737" , [
        @net.sf.gilead.pojo.gwt.basic.BooleanParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.BooleanParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/basic/BooleanParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.basic.BooleanParameter;/659978017" , [
        @net.sf.gilead.pojo.gwt.basic.BooleanParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.BooleanParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/basic/BooleanParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.basic.ByteParameter/2737926916" , [
        @net.sf.gilead.pojo.gwt.basic.ByteParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.ByteParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/basic/ByteParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.basic.ByteParameter;/2840751033" , [
        @net.sf.gilead.pojo.gwt.basic.ByteParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.ByteParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/basic/ByteParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.basic.CharacterParameter/3361494208" , [
        @net.sf.gilead.pojo.gwt.basic.CharacterParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.CharacterParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/basic/CharacterParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.basic.CharacterParameter;/537814816" , [
        @net.sf.gilead.pojo.gwt.basic.CharacterParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.CharacterParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/basic/CharacterParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.basic.DateParameter/3691507541" , [
        @net.sf.gilead.pojo.gwt.basic.DateParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.DateParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/basic/DateParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.basic.DateParameter;/2753979251" , [
        @net.sf.gilead.pojo.gwt.basic.DateParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.DateParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/basic/DateParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.basic.DoubleParameter/367474200" , [
        @net.sf.gilead.pojo.gwt.basic.DoubleParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.DoubleParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/basic/DoubleParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.basic.DoubleParameter;/2828072013" , [
        @net.sf.gilead.pojo.gwt.basic.DoubleParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.DoubleParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/basic/DoubleParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.basic.FloatParameter/2266458363" , [
        @net.sf.gilead.pojo.gwt.basic.FloatParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.FloatParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/basic/FloatParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.basic.FloatParameter;/1883925208" , [
        @net.sf.gilead.pojo.gwt.basic.FloatParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.FloatParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/basic/FloatParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.basic.IntegerParameter/3421404974" , [
        @net.sf.gilead.pojo.gwt.basic.IntegerParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.IntegerParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/basic/IntegerParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.basic.IntegerParameter;/408650838" , [
        @net.sf.gilead.pojo.gwt.basic.IntegerParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.IntegerParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/basic/IntegerParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.basic.LongParameter/1349029528" , [
        @net.sf.gilead.pojo.gwt.basic.LongParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.LongParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/basic/LongParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.basic.LongParameter;/3419125299" , [
        @net.sf.gilead.pojo.gwt.basic.LongParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.LongParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/basic/LongParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.basic.ShortParameter/3591328655" , [
        @net.sf.gilead.pojo.gwt.basic.ShortParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.ShortParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/basic/ShortParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.basic.ShortParameter;/1337822491" , [
        @net.sf.gilead.pojo.gwt.basic.ShortParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.ShortParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/basic/ShortParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.basic.StringParameter/2783524083" , [
        @net.sf.gilead.pojo.gwt.basic.StringParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.StringParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/basic/StringParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.basic.StringParameter;/2215125269" , [
        @net.sf.gilead.pojo.gwt.basic.StringParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.basic.StringParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/basic/StringParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.collection.ListParameter/3890945144" , [
        @net.sf.gilead.pojo.gwt.collection.ListParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.collection.ListParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/collection/ListParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.collection.ListParameter;/2269834606" , [
        @net.sf.gilead.pojo.gwt.collection.ListParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.collection.ListParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/collection/ListParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.collection.MapParameter/1940144086" , [
        @net.sf.gilead.pojo.gwt.collection.MapParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.collection.MapParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/collection/MapParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.collection.MapParameter;/1810339670" , [
        @net.sf.gilead.pojo.gwt.collection.MapParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.collection.MapParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/collection/MapParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "net.sf.gilead.pojo.gwt.collection.SetParameter/3311896573" , [
        @net.sf.gilead.pojo.gwt.collection.SetParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.collection.SetParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/sf/gilead/pojo/gwt/collection/SetParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lnet.sf.gilead.pojo.gwt.collection.SetParameter;/3930796824" , [
        @net.sf.gilead.pojo.gwt.collection.SetParameter_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.sf.gilead.pojo.gwt.collection.SetParameter_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lnet/sf/gilead/pojo/gwt/collection/SetParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.client.event.ACTION/1417808955" , [
        @org.openxdata.modules.workflows.client.event.ACTION_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.client.event.ACTION_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/client/event/ACTION;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.client.maps.SpecStudyMap/40541639" , [
        @org.openxdata.modules.workflows.client.maps.SpecStudyMap_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.client.maps.SpecStudyMap_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/client/maps/SpecStudyMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.client.maps.TaskFormDefMap/4080592458" , [
        @org.openxdata.modules.workflows.client.maps.TaskFormDefMap_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.client.maps.TaskFormDefMap_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/client/maps/TaskFormDefMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.DBSpecStudyMap/883597168" , [
        @org.openxdata.modules.workflows.model.shared.DBSpecStudyMap_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.DBSpecStudyMap_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/DBSpecStudyMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.modules.workflows.model.shared.DBSpecStudyMap;/712588583" , [
        @org.openxdata.modules.workflows.model.shared.DBSpecStudyMap_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.DBSpecStudyMap_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/modules/workflows/model/shared/DBSpecStudyMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.DBSpecification/2573613644" , [
        @org.openxdata.modules.workflows.model.shared.DBSpecification_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.DBSpecification_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/DBSpecification;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.modules.workflows.model.shared.DBSpecification;/3373382586" , [
        @org.openxdata.modules.workflows.model.shared.DBSpecification_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.DBSpecification_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/modules/workflows/model/shared/DBSpecification;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.DBWorkitem/4198381441" , [
        @org.openxdata.modules.workflows.model.shared.DBWorkitem_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.DBWorkitem_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/DBWorkitem;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.modules.workflows.model.shared.DBWorkitem;/2246806208" , [
        @org.openxdata.modules.workflows.model.shared.DBWorkitem_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.DBWorkitem_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/modules/workflows/model/shared/DBWorkitem;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem/2493820116" , [
        @org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/GWTFriendlyWorkItem;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.ODecomposition/3639879065" , [
        @org.openxdata.modules.workflows.model.shared.ODecomposition_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.ODecomposition_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/ODecomposition;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.OParameter/1731418771" , [
        @org.openxdata.modules.workflows.model.shared.OParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.OParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/OParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.OParameter$Flow/1068938111" , [
        @org.openxdata.modules.workflows.model.shared.OParameter_Flow_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.OParameter_Flow_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/OParameter$Flow;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.OSpecification/3722947521" , [
        @org.openxdata.modules.workflows.model.shared.OSpecification_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.OSpecification_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/OSpecification;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.OTask/356769286" , [
        @org.openxdata.modules.workflows.model.shared.OTask_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.OTask_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/OTask;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO/192434349" , [
        @org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/dto/SpecStudyMapDTO;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.shared.rpc.GetSpecsAction/3450705413" , [
        @org.openxdata.modules.workflows.shared.rpc.GetSpecsAction_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.shared.rpc.GetSpecsAction_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/shared/rpc/GetSpecsAction;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.shared.rpc.GetSpecsAction$Result/3311661682" , [
        @org.openxdata.modules.workflows.shared.rpc.GetSpecsAction_Result_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.shared.rpc.GetSpecsAction_Result_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/shared/rpc/GetSpecsAction$Result;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.shared.rpc.GetStudiesAction/673062037" , [
        @org.openxdata.modules.workflows.shared.rpc.GetStudiesAction_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.shared.rpc.GetStudiesAction_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/shared/rpc/GetStudiesAction;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.shared.rpc.GetStudiesAction$Result/2663011514" , [
        @org.openxdata.modules.workflows.shared.rpc.GetStudiesAction_Result_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.shared.rpc.GetStudiesAction_Result_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/shared/rpc/GetStudiesAction$Result;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.shared.rpc.ParseSpecAction/229058437" , [
        @org.openxdata.modules.workflows.shared.rpc.ParseSpecAction_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.shared.rpc.ParseSpecAction_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/shared/rpc/ParseSpecAction;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.shared.rpc.ParseSpecAction$Result/932556104" , [
        @org.openxdata.modules.workflows.shared.rpc.ParseSpecAction_Result_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.shared.rpc.ParseSpecAction_Result_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/shared/rpc/ParseSpecAction$Result;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.client.util.CronEntity$CronType/2963716724" , [
        @org.openxdata.server.admin.client.util.CronEntity_CronType_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.client.util.CronEntity_CronType_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/client/util/CronEntity$CronType;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.AbstractEditable;/3682085886" , [
        @org.openxdata.server.admin.model.AbstractEditable_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.AbstractEditable_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/AbstractEditable;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.ExportedDataType/2739284275" , [
        @org.openxdata.server.admin.model.ExportedDataType_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.ExportedDataType_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/ExportedDataType;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.ExportedDataType$DataTypeBoolean/3035213053" , [
        @org.openxdata.server.admin.model.ExportedDataType_DataTypeBoolean_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.ExportedDataType_DataTypeBoolean_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/ExportedDataType$DataTypeBoolean;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.ExportedDataType$DataTypeDate/481305177" , [
        @org.openxdata.server.admin.model.ExportedDataType_DataTypeDate_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.ExportedDataType_DataTypeDate_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/ExportedDataType$DataTypeDate;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.ExportedDataType$DataTypeDouble/3794348323" , [
        @org.openxdata.server.admin.model.ExportedDataType_DataTypeDouble_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.ExportedDataType_DataTypeDouble_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/ExportedDataType$DataTypeDouble;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.ExportedDataType$DataTypeInteger/668461207" , [
        @org.openxdata.server.admin.model.ExportedDataType_DataTypeInteger_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.ExportedDataType_DataTypeInteger_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/ExportedDataType$DataTypeInteger;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.ExportedDataType$DataTypeString/1577214727" , [
        @org.openxdata.server.admin.model.ExportedDataType_DataTypeString_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.ExportedDataType_DataTypeString_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/ExportedDataType$DataTypeString;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.ExportedFormData/550182800" , [
        @org.openxdata.server.admin.model.ExportedFormData_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.ExportedFormData_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/ExportedFormData;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.ExportedFormDataList/1294369846" , [
        @org.openxdata.server.admin.model.ExportedFormDataList_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.ExportedFormDataList_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/ExportedFormDataList;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.ExportedFormDataList;/3323454926" , [
        @org.openxdata.server.admin.model.ExportedFormDataList_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.ExportedFormDataList_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/ExportedFormDataList;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.ExportedFormData;/2671356400" , [
        @org.openxdata.server.admin.model.ExportedFormData_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.ExportedFormData_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/ExportedFormData;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.FormData/669483682" , [
        @org.openxdata.server.admin.model.FormData_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormData_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/FormData;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.FormDataHeader/438593830" , [
        @org.openxdata.server.admin.model.FormDataHeader_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormDataHeader_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/FormDataHeader;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.FormDataHeader;/4143830484" , [
        @org.openxdata.server.admin.model.FormDataHeader_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormDataHeader_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/FormDataHeader;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.FormDataVersion/3418963757" , [
        @org.openxdata.server.admin.model.FormDataVersion_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormDataVersion_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/FormDataVersion;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.FormDataVersion;/2291877296" , [
        @org.openxdata.server.admin.model.FormDataVersion_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormDataVersion_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/FormDataVersion;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.FormData;/3712340536" , [
        @org.openxdata.server.admin.model.FormData_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormData_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/FormData;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.FormDef/141965068" , [
        @org.openxdata.server.admin.model.FormDef_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormDef_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/FormDef;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.FormDefText/1818126158" , [
        @org.openxdata.server.admin.model.FormDefText_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormDefText_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/FormDefText;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.FormDefText;/826312313" , [
        @org.openxdata.server.admin.model.FormDefText_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormDefText_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/FormDefText;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.FormDefVersion/3312619097" , [
        @org.openxdata.server.admin.model.FormDefVersion_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormDefVersion_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/FormDefVersion;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.FormDefVersionText/18245592" , [
        @org.openxdata.server.admin.model.FormDefVersionText_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormDefVersionText_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/FormDefVersionText;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.FormDefVersionText;/289985101" , [
        @org.openxdata.server.admin.model.FormDefVersionText_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormDefVersionText_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/FormDefVersionText;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.FormDefVersion;/3048165195" , [
        @org.openxdata.server.admin.model.FormDefVersion_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormDefVersion_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/FormDefVersion;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.FormDef;/4027982323" , [
        @org.openxdata.server.admin.model.FormDef_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormDef_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/FormDef;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.FormSmsArchive/2587987833" , [
        @org.openxdata.server.admin.model.FormSmsArchive_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormSmsArchive_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/FormSmsArchive;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.FormSmsArchive;/2449947473" , [
        @org.openxdata.server.admin.model.FormSmsArchive_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormSmsArchive_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/FormSmsArchive;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.FormSmsError/402375958" , [
        @org.openxdata.server.admin.model.FormSmsError_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormSmsError_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/FormSmsError;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.FormSmsError;/2148055138" , [
        @org.openxdata.server.admin.model.FormSmsError_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.FormSmsError_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/FormSmsError;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.Locale/511307334" , [
        @org.openxdata.server.admin.model.Locale_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.Locale_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/Locale;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.Locale;/3231908972" , [
        @org.openxdata.server.admin.model.Locale_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.Locale_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/Locale;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.MobileMenuText/2521859443" , [
        @org.openxdata.server.admin.model.MobileMenuText_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.MobileMenuText_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/MobileMenuText;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.MobileMenuText;/3230105197" , [
        @org.openxdata.server.admin.model.MobileMenuText_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.MobileMenuText_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/MobileMenuText;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.Permission/3900349777" , [
        @org.openxdata.server.admin.model.Permission_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.Permission_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/Permission;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.Permission;/823405003" , [
        @org.openxdata.server.admin.model.Permission_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.Permission_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/Permission;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.Report/2003074756" , [
        @org.openxdata.server.admin.model.Report_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.Report_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/Report;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.ReportGroup/74344348" , [
        @org.openxdata.server.admin.model.ReportGroup_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.ReportGroup_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/ReportGroup;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.ReportGroup;/360764835" , [
        @org.openxdata.server.admin.model.ReportGroup_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.ReportGroup_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/ReportGroup;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.ReportUserMap/1712655250" , [
        @org.openxdata.server.admin.model.ReportUserMap_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.ReportUserMap_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/ReportUserMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.ReportUserMap;/2062619609" , [
        @org.openxdata.server.admin.model.ReportUserMap_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.ReportUserMap_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/ReportUserMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.Report;/125191226" , [
        @org.openxdata.server.admin.model.Report_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.Report_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/Report;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.Role/4048295481" , [
        @org.openxdata.server.admin.model.Role_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.Role_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/Role;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.Role;/700324796" , [
        @org.openxdata.server.admin.model.Role_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.Role_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/Role;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.Setting/2518311461" , [
        @org.openxdata.server.admin.model.Setting_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.Setting_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/Setting;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.SettingGroup/3809470920" , [
        @org.openxdata.server.admin.model.SettingGroup_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.SettingGroup_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/SettingGroup;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.SettingGroup;/23270514" , [
        @org.openxdata.server.admin.model.SettingGroup_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.SettingGroup_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/SettingGroup;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.Setting;/3894462238" , [
        @org.openxdata.server.admin.model.Setting_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.Setting_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/Setting;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.StudyDef/2343592517" , [
        @org.openxdata.server.admin.model.StudyDef_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.StudyDef_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/StudyDef;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.StudyDefText/3102970746" , [
        @org.openxdata.server.admin.model.StudyDefText_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.StudyDefText_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/StudyDefText;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.StudyDefText;/3593446375" , [
        @org.openxdata.server.admin.model.StudyDefText_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.StudyDefText_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/StudyDefText;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.StudyDef;/473800205" , [
        @org.openxdata.server.admin.model.StudyDef_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.StudyDef_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/StudyDef;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.StudyUserMap/2458132194" , [
        @org.openxdata.server.admin.model.StudyUserMap_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.StudyUserMap_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/StudyUserMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.StudyUserMap;/1375394302" , [
        @org.openxdata.server.admin.model.StudyUserMap_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.StudyUserMap_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/StudyUserMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.TaskDef/636505884" , [
        @org.openxdata.server.admin.model.TaskDef_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.TaskDef_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/TaskDef;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.TaskDef;/59864267" , [
        @org.openxdata.server.admin.model.TaskDef_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.TaskDef_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/TaskDef;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.TaskParam/858745130" , [
        @org.openxdata.server.admin.model.TaskParam_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.TaskParam_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/TaskParam;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.TaskParam;/3408107169" , [
        @org.openxdata.server.admin.model.TaskParam_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.TaskParam_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/TaskParam;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.User/2493671347" , [
        @org.openxdata.server.admin.model.User_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.User_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/User;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.User;/3783754529" , [
        @org.openxdata.server.admin.model.User_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.User_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/User;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.ContextException/1531694116" , [
        @org.openxdata.server.admin.model.exception.ContextException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.ContextException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/ContextException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException/3185263335" , [
        @org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataDisabledUserException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataException/534124950" , [
        @org.openxdata.server.admin.model.exception.OpenXDataException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataParsingException/2600572337" , [
        @org.openxdata.server.admin.model.exception.OpenXDataParsingException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataParsingException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataParsingException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataRuntimeException/51530723" , [
        @org.openxdata.server.admin.model.exception.OpenXDataRuntimeException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataRuntimeException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataRuntimeException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataSecurityException/2054087488" , [
        @org.openxdata.server.admin.model.exception.OpenXDataSecurityException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataSecurityException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataSecurityException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataSessionExpiredException/4188424438" , [
        @org.openxdata.server.admin.model.exception.OpenXDataSessionExpiredException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataSessionExpiredException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataSessionExpiredException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataValidationException/991789436" , [
        @org.openxdata.server.admin.model.exception.OpenXDataValidationException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataValidationException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataValidationException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXdataDataAccessException/1308223918" , [
        @org.openxdata.server.admin.model.exception.OpenXdataDataAccessException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXdataDataAccessException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXdataDataAccessException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.ReplaceThisExceptionRuntimeException/919674052" , [
        @org.openxdata.server.admin.model.exception.ReplaceThisExceptionRuntimeException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.ReplaceThisExceptionRuntimeException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/ReplaceThisExceptionRuntimeException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.UnexpectedException/2433619902" , [
        @org.openxdata.server.admin.model.exception.UnexpectedException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.UnexpectedException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/UnexpectedException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.UserNotFoundException/260296396" , [
        @org.openxdata.server.admin.model.exception.UserNotFoundException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.UserNotFoundException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/UserNotFoundException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.mapping.UserFormMap/4284888440" , [
        @org.openxdata.server.admin.model.mapping.UserFormMap_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.mapping.UserFormMap_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/mapping/UserFormMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.mapping.UserFormMap;/909395769" , [
        @org.openxdata.server.admin.model.mapping.UserFormMap_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.mapping.UserFormMap_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/mapping/UserFormMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.mapping.UserReportGroupMap/4053001426" , [
        @org.openxdata.server.admin.model.mapping.UserReportGroupMap_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.mapping.UserReportGroupMap_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/mapping/UserReportGroupMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.mapping.UserReportGroupMap;/1325504761" , [
        @org.openxdata.server.admin.model.mapping.UserReportGroupMap_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.mapping.UserReportGroupMap_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/mapping/UserReportGroupMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.mapping.UserReportMap/3581611453" , [
        @org.openxdata.server.admin.model.mapping.UserReportMap_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.mapping.UserReportMap_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/mapping/UserReportMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.mapping.UserReportMap;/3845254698" , [
        @org.openxdata.server.admin.model.mapping.UserReportMap_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.mapping.UserReportMap_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/mapping/UserReportMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.mapping.UserStudyMap/451157830" , [
        @org.openxdata.server.admin.model.mapping.UserStudyMap_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.mapping.UserStudyMap_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/mapping/UserStudyMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.server.admin.model.mapping.UserStudyMap;/3155378308" , [
        @org.openxdata.server.admin.model.mapping.UserStudyMap_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.mapping.UserStudyMap_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/server/admin/model/mapping/UserStudyMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.util.DiagnosedStatus/3551064309" , [
        @org.openxdata.server.admin.model.util.DiagnosedStatus_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.util.DiagnosedStatus_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/util/DiagnosedStatus;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.util.Diagnosis/489819592" , [
        @org.openxdata.server.admin.model.util.Diagnosis_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.util.Diagnosis_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/util/Diagnosis;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.util.ErrorRiskLevel/1255873120" , [
        @org.openxdata.server.admin.model.util.ErrorRiskLevel_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.util.ErrorRiskLevel_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/util/ErrorRiskLevel;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.util.OpenXDataEmail/1832342926" , [
        @org.openxdata.server.admin.model.util.OpenXDataEmail_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.util.OpenXDataEmail_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/util/OpenXDataEmail;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.purc.purcforms.client.model.DisplayField/4087645775" , [
        @org.purc.purcforms.client.model.DisplayField_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.purc.purcforms.client.model.DisplayField_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/purc/purcforms/client/model/DisplayField;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.purc.purcforms.client.model.FilterCondition/1324066477" , [
        @org.purc.purcforms.client.model.FilterCondition_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.purc.purcforms.client.model.FilterCondition_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/purc/purcforms/client/model/FilterCondition;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.purc.purcforms.client.model.FilterConditionGroup/672018332" , [
        @org.purc.purcforms.client.model.FilterConditionGroup_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.purc.purcforms.client.model.FilterConditionGroup_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/purc/purcforms/client/model/FilterConditionGroup;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.purc.purcforms.client.model.FilterConditionGroup;/2568993387" , [
        @org.purc.purcforms.client.model.FilterConditionGroup_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.purc.purcforms.client.model.FilterConditionGroup_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/purc/purcforms/client/model/FilterConditionGroup;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.purc.purcforms.client.model.FilterConditionRow/1625140544" , [
        @org.purc.purcforms.client.model.FilterConditionRow_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.purc.purcforms.client.model.FilterConditionRow_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/purc/purcforms/client/model/FilterConditionRow;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.purc.purcforms.client.model.FilterConditionRow;/1169401321" , [
        @org.purc.purcforms.client.model.FilterConditionRow_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.purc.purcforms.client.model.FilterConditionRow_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/purc/purcforms/client/model/FilterConditionRow;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "[Lorg.purc.purcforms.client.model.FilterCondition;/3566707007" , [
        @org.purc.purcforms.client.model.FilterCondition_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.purc.purcforms.client.model.FilterCondition_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/purc/purcforms/client/model/FilterCondition;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.purc.purcforms.client.model.ModelConstants/1479937812" , [
        @org.purc.purcforms.client.model.ModelConstants_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.purc.purcforms.client.model.ModelConstants_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/purc/purcforms/client/model/ModelConstants;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.purc.purcforms.client.model.SkipRule/2993525537" , [
        @org.purc.purcforms.client.model.SkipRule_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.purc.purcforms.client.model.SkipRule_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/purc/purcforms/client/model/SkipRule;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.AuthenticationService_TypeSerializer::methodMap,
      "org.purc.purcforms.client.model.SortField/557051153" , [
        @org.purc.purcforms.client.model.SortField_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.purc.purcforms.client.model.SortField_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/purc/purcforms/client/model/SortField;),
      ]);
    
  }-*/;
  
  private static void raiseSerializationException(String msg) throws SerializationException {
    throw new SerializationException(msg);
  }
  
}
