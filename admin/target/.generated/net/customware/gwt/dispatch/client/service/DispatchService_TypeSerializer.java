package net.customware.gwt.dispatch.client.service;

import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.impl.Serializer;

public class DispatchService_TypeSerializer extends com.google.gwt.user.client.rpc.impl.SerializerBase {
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
  
  private static native void registerSignatures() /*-{
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @com.allen_sauer.gwt.dnd.client.VetoDragException::class,
      "com.allen_sauer.gwt.dnd.client.VetoDragException/1174378338");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @com.google.gwt.http.client.RequestException::class,
      "com.google.gwt.http.client.RequestException/190587325");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException::class,
      "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.rpc.SerializableException::class,
      "com.google.gwt.user.client.rpc.SerializableException/3047383460");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.rpc.SerializationException::class,
      "com.google.gwt.user.client.rpc.SerializationException/2836333220");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.rpc.ServiceDefTarget$NoServiceEntryPointSpecifiedException::class,
      "com.google.gwt.user.client.rpc.ServiceDefTarget$NoServiceEntryPointSpecifiedException/3408313447");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @com.google.gwt.xml.client.impl.DOMParseException::class,
      "com.google.gwt.xml.client.impl.DOMParseException/3799120635");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.io.IOException::class,
      "java.io.IOException/1159940531");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.ArithmeticException::class,
      "java.lang.ArithmeticException/1539622151");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.ArrayIndexOutOfBoundsException::class,
      "java.lang.ArrayIndexOutOfBoundsException/600550433");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.ArrayStoreException::class,
      "java.lang.ArrayStoreException/3540507190");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.ClassCastException::class,
      "java.lang.ClassCastException/702295179");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.Exception::class,
      "java.lang.Exception/1920171873");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.IllegalArgumentException::class,
      "java.lang.IllegalArgumentException/1755012560");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.IllegalStateException::class,
      "java.lang.IllegalStateException/1972187323");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.IndexOutOfBoundsException::class,
      "java.lang.IndexOutOfBoundsException/2489527753");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.NegativeArraySizeException::class,
      "java.lang.NegativeArraySizeException/3846860241");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.NullPointerException::class,
      "java.lang.NullPointerException/1463492344");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.NumberFormatException::class,
      "java.lang.NumberFormatException/3305228476");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.RuntimeException::class,
      "java.lang.RuntimeException/515124647");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.String::class,
      "java.lang.String/2004016611");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.StringIndexOutOfBoundsException::class,
      "java.lang.StringIndexOutOfBoundsException/500777603");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.UnsupportedOperationException::class,
      "java.lang.UnsupportedOperationException/3744010015");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.lang.annotation.AnnotationTypeMismatchException::class,
      "java.lang.annotation.AnnotationTypeMismatchException/976205828");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.util.ArrayList::class,
      "java.util.ArrayList/3821976829");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.util.ConcurrentModificationException::class,
      "java.util.ConcurrentModificationException/2717383897");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.util.EmptyStackException::class,
      "java.util.EmptyStackException/89438517");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.util.HashMap::class,
      "java.util.HashMap/962170901");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.util.LinkedHashMap::class,
      "java.util.LinkedHashMap/1551059846");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.util.NoSuchElementException::class,
      "java.util.NoSuchElementException/1559248883");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @java.util.TooManyListenersException::class,
      "java.util.TooManyListenersException/2023078032");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @net.customware.gwt.dispatch.shared.ActionException::class,
      "net.customware.gwt.dispatch.shared.ActionException/1936455038");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @net.customware.gwt.dispatch.shared.UnsupportedActionException::class,
      "net.customware.gwt.dispatch.shared.UnsupportedActionException/3409690421");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.ODecomposition::class,
      "org.openxdata.modules.workflows.model.shared.ODecomposition/3639879065");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.OParameter::class,
      "org.openxdata.modules.workflows.model.shared.OParameter/1731418771");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.OParameter$Flow::class,
      "org.openxdata.modules.workflows.model.shared.OParameter$Flow/1068938111");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.OSpecification::class,
      "org.openxdata.modules.workflows.model.shared.OSpecification/3722947521");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.OTask::class,
      "org.openxdata.modules.workflows.model.shared.OTask/356769286");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.shared.rpc.GetSpecsAction::class,
      "org.openxdata.modules.workflows.shared.rpc.GetSpecsAction/3450705413");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.shared.rpc.GetSpecsAction$Result::class,
      "org.openxdata.modules.workflows.shared.rpc.GetSpecsAction$Result/3311661682");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.shared.rpc.GetStudiesAction::class,
      "org.openxdata.modules.workflows.shared.rpc.GetStudiesAction/673062037");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.shared.rpc.GetStudiesAction$Result::class,
      "org.openxdata.modules.workflows.shared.rpc.GetStudiesAction$Result/2663011514");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.shared.rpc.ParseSpecAction::class,
      "org.openxdata.modules.workflows.shared.rpc.ParseSpecAction/229058437");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.shared.rpc.ParseSpecAction$Result::class,
      "org.openxdata.modules.workflows.shared.rpc.ParseSpecAction$Result/932556104");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.ContextException::class,
      "org.openxdata.server.admin.model.exception.ContextException/1531694116");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException/3185263335");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataException/534124950");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataParsingException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataParsingException/2600572337");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataRuntimeException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataRuntimeException/51530723");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataSecurityException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataSecurityException/2054087488");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataSessionExpiredException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataSessionExpiredException/4188424438");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataValidationException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataValidationException/991789436");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXdataDataAccessException::class,
      "org.openxdata.server.admin.model.exception.OpenXdataDataAccessException/1308223918");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.ReplaceThisExceptionRuntimeException::class,
      "org.openxdata.server.admin.model.exception.ReplaceThisExceptionRuntimeException/919674052");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.UnexpectedException::class,
      "org.openxdata.server.admin.model.exception.UnexpectedException/2433619902");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.UserNotFoundException::class,
      "org.openxdata.server.admin.model.exception.UserNotFoundException/260296396");
    
  }-*/;
  
  private static native void registerMethods() /*-{
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "com.allen_sauer.gwt.dnd.client.VetoDragException/1174378338" , [
        @com.allen_sauer.gwt.dnd.client.VetoDragException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.allen_sauer.gwt.dnd.client.VetoDragException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/allen_sauer/gwt/dnd/client/VetoDragException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "com.google.gwt.http.client.RequestException/190587325" , [
        @com.google.gwt.http.client.RequestException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.http.client.RequestException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/http/client/RequestException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533" , [
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;)
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.rpc.SerializableException/3047383460" , [
        @com.google.gwt.user.client.rpc.SerializableException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.SerializableException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/SerializableException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.rpc.SerializationException/2836333220" , [
        @com.google.gwt.user.client.rpc.SerializationException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.SerializationException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/SerializationException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.rpc.ServiceDefTarget$NoServiceEntryPointSpecifiedException/3408313447" , [
        @com.google.gwt.user.client.rpc.ServiceDefTarget_NoServiceEntryPointSpecifiedException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.ServiceDefTarget_NoServiceEntryPointSpecifiedException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/ServiceDefTarget$NoServiceEntryPointSpecifiedException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "com.google.gwt.xml.client.impl.DOMParseException/3799120635" , [
        @com.google.gwt.xml.client.impl.DOMParseException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.xml.client.impl.DOMParseException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/xml/client/impl/DOMParseException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.io.IOException/1159940531" , [
        @com.google.gwt.user.client.rpc.core.java.io.IOException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.io.IOException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/io/IOException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.ArithmeticException/1539622151" , [
        @com.google.gwt.user.client.rpc.core.java.lang.ArithmeticException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.ArithmeticException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/ArithmeticException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.ArrayIndexOutOfBoundsException/600550433" , [
        @com.google.gwt.user.client.rpc.core.java.lang.ArrayIndexOutOfBoundsException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.ArrayIndexOutOfBoundsException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/ArrayIndexOutOfBoundsException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.ArrayStoreException/3540507190" , [
        @com.google.gwt.user.client.rpc.core.java.lang.ArrayStoreException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.ArrayStoreException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/ArrayStoreException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.ClassCastException/702295179" , [
        @com.google.gwt.user.client.rpc.core.java.lang.ClassCastException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.ClassCastException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/ClassCastException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.Exception/1920171873" , [
        @com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Exception;),
        @com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Exception;)
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.IllegalArgumentException/1755012560" , [
        @com.google.gwt.user.client.rpc.core.java.lang.IllegalArgumentException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.IllegalArgumentException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/IllegalArgumentException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.IllegalStateException/1972187323" , [
        @com.google.gwt.user.client.rpc.core.java.lang.IllegalStateException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.IllegalStateException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/IllegalStateException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.IndexOutOfBoundsException/2489527753" , [
        @com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.IndexOutOfBoundsException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/IndexOutOfBoundsException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.NegativeArraySizeException/3846860241" , [
        @com.google.gwt.user.client.rpc.core.java.lang.NegativeArraySizeException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.NegativeArraySizeException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/NegativeArraySizeException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.NullPointerException/1463492344" , [
        @com.google.gwt.user.client.rpc.core.java.lang.NullPointerException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.NullPointerException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/NullPointerException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.NumberFormatException/3305228476" , [
        @com.google.gwt.user.client.rpc.core.java.lang.NumberFormatException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.NumberFormatException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/NumberFormatException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.RuntimeException/515124647" , [
        @com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/RuntimeException;),
        @com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/RuntimeException;)
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.String/2004016611" , [
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/String;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/String;)
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.StringIndexOutOfBoundsException/500777603" , [
        @com.google.gwt.user.client.rpc.core.java.lang.StringIndexOutOfBoundsException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.StringIndexOutOfBoundsException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/StringIndexOutOfBoundsException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.UnsupportedOperationException/3744010015" , [
        @com.google.gwt.user.client.rpc.core.java.lang.UnsupportedOperationException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.UnsupportedOperationException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/UnsupportedOperationException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.lang.annotation.AnnotationTypeMismatchException/976205828" , [
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.AnnotationTypeMismatchException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.AnnotationTypeMismatchException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/annotation/AnnotationTypeMismatchException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.util.ArrayList/3821976829" , [
        @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::create_com_google_gwt_user_client_rpc_core_java_util_ArrayList_CustomFieldSerializer(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/ArrayList;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.util.ConcurrentModificationException/2717383897" , [
        @com.google.gwt.user.client.rpc.core.java.util.ConcurrentModificationException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.ConcurrentModificationException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/ConcurrentModificationException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.util.EmptyStackException/89438517" , [
        @com.google.gwt.user.client.rpc.core.java.util.EmptyStackException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.EmptyStackException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/EmptyStackException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.util.HashMap/962170901" , [
        @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::create_com_google_gwt_user_client_rpc_core_java_util_HashMap_CustomFieldSerializer(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.HashMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/HashMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.util.LinkedHashMap/1551059846" , [
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/LinkedHashMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.util.NoSuchElementException/1559248883" , [
        @com.google.gwt.user.client.rpc.core.java.util.NoSuchElementException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.NoSuchElementException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/NoSuchElementException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "java.util.TooManyListenersException/2023078032" , [
        @com.google.gwt.user.client.rpc.core.java.util.TooManyListenersException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.TooManyListenersException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/TooManyListenersException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "net.customware.gwt.dispatch.shared.ActionException/1936455038" , [
        @net.customware.gwt.dispatch.shared.ActionException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.customware.gwt.dispatch.shared.ActionException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/customware/gwt/dispatch/shared/ActionException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "net.customware.gwt.dispatch.shared.UnsupportedActionException/3409690421" , [
        @net.customware.gwt.dispatch.shared.UnsupportedActionException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @net.customware.gwt.dispatch.shared.UnsupportedActionException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lnet/customware/gwt/dispatch/shared/UnsupportedActionException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.ODecomposition/3639879065" , [
        @org.openxdata.modules.workflows.model.shared.ODecomposition_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.ODecomposition_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/ODecomposition;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.OParameter/1731418771" , [
        @org.openxdata.modules.workflows.model.shared.OParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.OParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/OParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.OParameter$Flow/1068938111" , [
        @org.openxdata.modules.workflows.model.shared.OParameter_Flow_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.OParameter_Flow_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/OParameter$Flow;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.OSpecification/3722947521" , [
        @org.openxdata.modules.workflows.model.shared.OSpecification_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.OSpecification_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/OSpecification;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.OTask/356769286" , [
        @org.openxdata.modules.workflows.model.shared.OTask_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.OTask_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/OTask;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.shared.rpc.GetSpecsAction/3450705413" , [
        ,
        ,
        @org.openxdata.modules.workflows.shared.rpc.GetSpecsAction_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lorg/openxdata/modules/workflows/shared/rpc/GetSpecsAction;)
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.shared.rpc.GetSpecsAction$Result/3311661682" , [
        @org.openxdata.modules.workflows.shared.rpc.GetSpecsAction_Result_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.shared.rpc.GetSpecsAction_Result_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/shared/rpc/GetSpecsAction$Result;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.shared.rpc.GetStudiesAction/673062037" , [
        ,
        ,
        @org.openxdata.modules.workflows.shared.rpc.GetStudiesAction_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lorg/openxdata/modules/workflows/shared/rpc/GetStudiesAction;)
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.shared.rpc.GetStudiesAction$Result/2663011514" , [
        @org.openxdata.modules.workflows.shared.rpc.GetStudiesAction_Result_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.shared.rpc.GetStudiesAction_Result_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/shared/rpc/GetStudiesAction$Result;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.shared.rpc.ParseSpecAction/229058437" , [
        ,
        ,
        @org.openxdata.modules.workflows.shared.rpc.ParseSpecAction_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lorg/openxdata/modules/workflows/shared/rpc/ParseSpecAction;)
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.shared.rpc.ParseSpecAction$Result/932556104" , [
        @org.openxdata.modules.workflows.shared.rpc.ParseSpecAction_Result_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.shared.rpc.ParseSpecAction_Result_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/shared/rpc/ParseSpecAction$Result;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.ContextException/1531694116" , [
        @org.openxdata.server.admin.model.exception.ContextException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.ContextException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/ContextException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException/3185263335" , [
        @org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataDisabledUserException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataDisabledUserException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataException/534124950" , [
        @org.openxdata.server.admin.model.exception.OpenXDataException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataParsingException/2600572337" , [
        @org.openxdata.server.admin.model.exception.OpenXDataParsingException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataParsingException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataParsingException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataRuntimeException/51530723" , [
        @org.openxdata.server.admin.model.exception.OpenXDataRuntimeException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataRuntimeException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataRuntimeException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataSecurityException/2054087488" , [
        @org.openxdata.server.admin.model.exception.OpenXDataSecurityException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataSecurityException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataSecurityException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataSessionExpiredException/4188424438" , [
        @org.openxdata.server.admin.model.exception.OpenXDataSessionExpiredException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataSessionExpiredException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataSessionExpiredException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataValidationException/991789436" , [
        @org.openxdata.server.admin.model.exception.OpenXDataValidationException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataValidationException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataValidationException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXdataDataAccessException/1308223918" , [
        @org.openxdata.server.admin.model.exception.OpenXdataDataAccessException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXdataDataAccessException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXdataDataAccessException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.ReplaceThisExceptionRuntimeException/919674052" , [
        @org.openxdata.server.admin.model.exception.ReplaceThisExceptionRuntimeException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.ReplaceThisExceptionRuntimeException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/ReplaceThisExceptionRuntimeException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.UnexpectedException/2433619902" , [
        @org.openxdata.server.admin.model.exception.UnexpectedException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.UnexpectedException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/UnexpectedException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @net.customware.gwt.dispatch.client.service.DispatchService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.UserNotFoundException/260296396" , [
        @org.openxdata.server.admin.model.exception.UserNotFoundException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.UserNotFoundException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/UserNotFoundException;),
      ]);
    
  }-*/;
  
  private static void raiseSerializationException(String msg) throws SerializationException {
    throw new SerializationException(msg);
  }
  
}
