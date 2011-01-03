<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->
<%@ taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>

<html>
<head>
<%@ include file="locale.jsp" %>
<fmt:setBundle basename='org.celllife.emit.client.PurcformsText'/>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="gwt:property" content="locale=${locale}">
<link rel="shortcut icon" href="favicon.ico" >
<!--                                           -->
<!-- stylesheet for gxt -->
<!--                                           -->
<link rel="stylesheet" type="text/css" href="gxt/css/gxt-all.css" />

<!--                                                               -->
<!-- Consider inlining CSS to reduce the number of requested files -->
<!--                                                               -->
<link type="text/css" rel="stylesheet" href="Emit.css">

<title>Emit 1.0</title>

<!--                                           -->
<!-- This script loads your compiled module.   -->
<!-- If you add any GWT meta tags, they must   -->
<!-- be added before this line.                -->
<!--                                           -->
<script type="text/javascript" language="javascript"
	src="emit/emit.nocache.js"></script>
	
<script type="text/javascript" language="javascript" src="gxt/flash/swfobject.js"></script>

<script language="javascript">
        var PurcformsText = {
                close: "<fmt:message key='close'/>",
                errorMessage: "<fmt:message key='errorMessage'/>",
                question: "<fmt:message key='question'/>",
                noDataFound: "No data found.",
                noFormId: "No formId or ",
                divFound: " div found",
                noFormLayout: "No form layout found. Please first design and save the form.",
                formSubmitSuccess: "Form Data Submitted Successfully",
                missingDataNode: "Missing data node for :",
                openingForm: "<fmt:message key='openingForm'/>",
                clickToPlay: "<fmt:message key='clickToPlay'/>",
                loadingPreview: "<fmt:message key='loadingPreview'/>",
                unexpectedFailure: "<fmt:message key='unexpectedFailure'/>",
                uncaughtException: "Uncaught exception: ",
                causedBy: "Caused by: ",
                openFile: "<fmt:message key='openFile'/>",
                saveFileAs: "<fmt:message key='saveFileAs'/>",
                more: "<fmt:message key='more'/>",
                requiredErrorMsg: "<fmt:message key='requiredErrorMsg'/>",
                remove: "<fmt:message key='remove'/>",
                browse: "<fmt:message key='browse'/>",
                clear: "<fmt:message key='clear'/>",
                deleteItem: "<fmt:message key='deleteItem'/>",
                cancel: "<fmt:message key='cancel'/>",
                submitting: "<fmt:message key='submitting'/>",
        		welcome: "Welcome to openXdata server",
        		authenticationPrompt: "Please enter your user name and password",
        		invalidUser: "Invalid UserName or Password",
        		login: "Login",
        		userName: "User Name",
        		password: "Password",
                noSelection: "<fmt:message key='noSelection'/>",
                cancelFormPrompt: "<fmt:message key='cancelFormPrompt'/>",
                print: "<fmt:message key='print'/>",
                yes: "<fmt:message key='yes'/>",
                no: "<fmt:message key='no'/>",
                searchServer: "<fmt:message key='searchServer'/>",
                recording: "<fmt:message key='recording'/>",
                search: "<fmt:message key='search'/>",
                processingMsg: "<fmt:message key='processingMsg'/>",
                ok: "<fmt:message key='ok'/>",
                loading: "<fmt:message key='loading'/>"
          };

          function isUserAuthenticated(){
              authenticationCallback(true);
              return true; //Not expected to be used in the design mode.
          }

          function authenticateUser(username, password){
              return true; //Not expected to be used in the design mode.
          }

          function searchExternal(key,value,parentElement,textElement,valueElement){
        
          }

          function initialize(){

          }
         
    </script>

</head>
<body>

<!-- history support -->
<iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1'
	style="width: 0; height: 0; border: 0;"></iframe>
</body>
</html>