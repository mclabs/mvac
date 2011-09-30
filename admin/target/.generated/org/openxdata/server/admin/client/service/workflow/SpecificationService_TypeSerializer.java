package org.openxdata.server.admin.client.service.workflow;

import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.impl.Serializer;

public class SpecificationService_TypeSerializer extends com.google.gwt.user.client.rpc.impl.SerializerBase {
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
  
  private static native java.util.LinkedList create_com_google_gwt_user_client_rpc_core_java_util_LinkedList_CustomFieldSerializer(SerializationStreamReader streamReader) throws SerializationException /*-{
    return @java.util.LinkedList::new()();
  }-*/;
  
  private static native java.util.Vector create_com_google_gwt_user_client_rpc_core_java_util_Vector_CustomFieldSerializer(SerializationStreamReader streamReader) throws SerializationException /*-{
    return @java.util.Vector::new()();
  }-*/;
  
  private static native void registerSignatures() /*-{
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException::class,
      "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @java.lang.String::class,
      "java.lang.String/2004016611");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @java.util.ArrayList::class,
      "java.util.ArrayList/3821976829");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @java.util.Arrays$ArrayList::class,
      "java.util.Arrays$ArrayList/1243019747");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @java.util.HashMap::class,
      "java.util.HashMap/962170901");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @java.util.LinkedHashMap::class,
      "java.util.LinkedHashMap/1551059846");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @java.util.LinkedList::class,
      "java.util.LinkedList/1060625595");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @java.util.Stack::class,
      "java.util.Stack/1031431137");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @java.util.Vector::class,
      "java.util.Vector/3125574444");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.ODecomposition::class,
      "org.openxdata.modules.workflows.model.shared.ODecomposition/3639879065");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.OParameter::class,
      "org.openxdata.modules.workflows.model.shared.OParameter/1731418771");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.OParameter$Flow::class,
      "org.openxdata.modules.workflows.model.shared.OParameter$Flow/1068938111");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.OSpecification::class,
      "org.openxdata.modules.workflows.model.shared.OSpecification/3722947521");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.OSpecification[]::class,
      "[Lorg.openxdata.modules.workflows.model.shared.OSpecification;/703461552");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @org.openxdata.modules.workflows.model.shared.OTask::class,
      "org.openxdata.modules.workflows.model.shared.OTask/356769286");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.ContextException::class,
      "org.openxdata.server.admin.model.exception.ContextException/1531694116");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataException/534124950");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataParsingException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataParsingException/2600572337");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.OpenXDataValidationException::class,
      "org.openxdata.server.admin.model.exception.OpenXDataValidationException/991789436");
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerSignature(Lcom/google/gwt/core/client/JsArrayString;Ljava/lang/Class;Ljava/lang/String;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::signatureMap,
      @org.openxdata.server.admin.model.exception.UserNotFoundException::class,
      "org.openxdata.server.admin.model.exception.UserNotFoundException/260296396");
    
  }-*/;
  
  private static native void registerMethods() /*-{
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533" , [
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;)
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "java.lang.String/2004016611" , [
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/String;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/String;)
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "java.util.ArrayList/3821976829" , [
        @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::create_com_google_gwt_user_client_rpc_core_java_util_ArrayList_CustomFieldSerializer(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/ArrayList;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "java.util.Arrays$ArrayList/1243019747" , [
        @com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/List;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "java.util.HashMap/962170901" , [
        @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::create_com_google_gwt_user_client_rpc_core_java_util_HashMap_CustomFieldSerializer(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.HashMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/HashMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "java.util.LinkedHashMap/1551059846" , [
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/LinkedHashMap;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "java.util.LinkedList/1060625595" , [
        @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::create_com_google_gwt_user_client_rpc_core_java_util_LinkedList_CustomFieldSerializer(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/LinkedList;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "java.util.Stack/1031431137" , [
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Stack;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "java.util.Vector/3125574444" , [
        @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::create_com_google_gwt_user_client_rpc_core_java_util_Vector_CustomFieldSerializer(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Vector;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.ODecomposition/3639879065" , [
        @org.openxdata.modules.workflows.model.shared.ODecomposition_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.ODecomposition_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/ODecomposition;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.OParameter/1731418771" , [
        @org.openxdata.modules.workflows.model.shared.OParameter_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.OParameter_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/OParameter;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.OParameter$Flow/1068938111" , [
        @org.openxdata.modules.workflows.model.shared.OParameter_Flow_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.OParameter_Flow_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/OParameter$Flow;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.OSpecification/3722947521" , [
        @org.openxdata.modules.workflows.model.shared.OSpecification_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.OSpecification_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/OSpecification;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "[Lorg.openxdata.modules.workflows.model.shared.OSpecification;/703461552" , [
        @org.openxdata.modules.workflows.model.shared.OSpecification_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.OSpecification_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lorg/openxdata/modules/workflows/model/shared/OSpecification;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "org.openxdata.modules.workflows.model.shared.OTask/356769286" , [
        @org.openxdata.modules.workflows.model.shared.OTask_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.modules.workflows.model.shared.OTask_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/modules/workflows/model/shared/OTask;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.ContextException/1531694116" , [
        @org.openxdata.server.admin.model.exception.ContextException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.ContextException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/ContextException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataException/534124950" , [
        @org.openxdata.server.admin.model.exception.OpenXDataException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataParsingException/2600572337" , [
        @org.openxdata.server.admin.model.exception.OpenXDataParsingException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataParsingException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataParsingException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.OpenXDataValidationException/991789436" , [
        @org.openxdata.server.admin.model.exception.OpenXDataValidationException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.OpenXDataValidationException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/OpenXDataValidationException;),
      ]);
    
    @com.google.gwt.user.client.rpc.impl.SerializerBase::registerMethods(Lcom/google/gwt/user/client/rpc/impl/SerializerBase$MethodMap;Ljava/lang/String;Lcom/google/gwt/core/client/JsArray;)(
      @org.openxdata.server.admin.client.service.workflow.SpecificationService_TypeSerializer::methodMap,
      "org.openxdata.server.admin.model.exception.UserNotFoundException/260296396" , [
        @org.openxdata.server.admin.model.exception.UserNotFoundException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @org.openxdata.server.admin.model.exception.UserNotFoundException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lorg/openxdata/server/admin/model/exception/UserNotFoundException;),
      ]);
    
  }-*/;
  
  private static void raiseSerializationException(String msg) throws SerializationException {
    throw new SerializationException(msg);
  }
  
}
