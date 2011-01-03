package org.celllife.emit.client.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.celllife.emit.client.AppMessages;
import org.celllife.emit.client.EmitAsyncCallback;
import org.celllife.emit.client.RefreshableEvent;
import org.celllife.emit.client.RefreshablePublisher;
import org.celllife.emit.client.model.FormDataBinding;
import org.celllife.emit.client.model.FormDataSummary;
import org.celllife.emit.client.service.FormServiceAsync;
import org.celllife.emit.client.service.UserServiceAsync;
import org.celllife.emit.client.util.ProgressIndicator;
import org.celllife.emit.client.views.FormResponsesView;
import org.openxdata.server.admin.model.ExportedFormData;
import org.openxdata.server.admin.model.ExportedFormDataList;
import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.User;
import org.purc.purcforms.client.model.PageDef;
import org.purc.purcforms.client.model.QuestionDef;
import org.purc.purcforms.client.xforms.XformParser;
import org.purc.purcforms.client.xforms.XformUtil;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.form.Time;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class FormResponsesController  extends Controller {
    AppMessages appMessages = (AppMessages)GWT.create(AppMessages.class); 
    public final static EventType BROWSE = new EventType();
    public final static EventType EDIT = new EventType();
    public final static EventType EXPORT = new EventType();

    private FormResponsesView formResponsesView;
    private FormServiceAsync formService;
    private UserServiceAsync userService;
    
    public FormResponsesController(FormServiceAsync aFormService, UserServiceAsync aUserService) {
        super();
        formService = aFormService;
        userService = aUserService;
        registerEventTypes(BROWSE);
        registerEventTypes(EDIT);
        registerEventTypes(EXPORT);
    }
    
    @Override
    protected void initialize() {
    	Log.info("FormResponsesController : initialize");
        formResponsesView = new FormResponsesView(this);
        RefreshablePublisher.get().subscribe(RefreshableEvent.Type.CAPTURE, formResponsesView);
    }

    @Override
    public void handleEvent(AppEvent event) {
    	Log.info("FormResponsesController : handleEvent");
        EventType type = event.getType();
        if (type == BROWSE) {
            forwardToView(formResponsesView, event);
        }
    }
    
    public void forwardToDataCapture(FormDef formDef, FormData formData) {
    	Log.info("FormResponsesController : forwardToDataCapture");
        Dispatcher dispatcher = Dispatcher.get();
        AppEvent event = new AppEvent(DataCaptureController.DATACAPTURE);
        event.setData("formDef", formDef);
        event.setData("formData", formData);
    	dispatcher.dispatch(event);
    }
    
    public FormDataBinding getFormDataColumnModel(final FormDef formDef) {
    	
    	Log.info("FormResponsesController : getFormDataColumnModel");

        Map<String, String> formColumnData = new HashMap<String, String>();
        Map<String, QuestionDef> formColumnQuestionDef = new HashMap<String, QuestionDef>();
        List<String> formColumnDataKey = new ArrayList<String>();
        
        // convert the FormData using purcForms
        org.purc.purcforms.client.model.FormDef purcFormDef = XformParser.fromXform2FormDef(formDef.getDefaultVersion().getXform());

        // go through all the pages in this form
        Iterator<PageDef> pageIt = purcFormDef.getPages().iterator();
        while (pageIt.hasNext()) {
            PageDef purcPageDef = pageIt.next();
            // now go through all the questions in this page
            Iterator<QuestionDef> questionIt = purcPageDef.getQuestions().iterator();
            while (questionIt.hasNext()) {
                QuestionDef purcQuestionDef = questionIt.next();
                int dataType = purcQuestionDef.getDataType(); 
                if (dataType == QuestionDef.QTN_TYPE_REPEAT || dataType == QuestionDef.QTN_TYPE_AUDIO || dataType == QuestionDef.QTN_TYPE_VIDEO) {
                    // ignore this one for now...
                    Log.debug("Ignoring question "+purcQuestionDef.getVariableName()+" because it is a repeat question, audio or video");
                } else {
                    // get the question text (for the model)
                    formColumnData.put(purcQuestionDef.getVariableName(), purcQuestionDef.getText());
                    formColumnDataKey.add(purcQuestionDef.getVariableName());
                    formColumnQuestionDef.put(purcQuestionDef.getVariableName(), purcQuestionDef);
                }
            }
        }
        return new FormDataBinding(purcFormDef, formColumnData, formColumnQuestionDef,  formColumnDataKey);
        //  return new FormDataBinding(purcFormDef.getVariableName(), formColumnData, formColumnQuestionDef, formColumnDataKey);
    }
    
    public void getFormDataSummary(final FormDef formDef, final FormDataBinding formDataBinding, 
            final PagingLoadConfig pagingLoadConfig, final AsyncCallback<PagingLoadResult<FormDataSummary>> callback) {
    	Log.info("FormResponsesController : getFormDataSummary");
        ProgressIndicator.showProgressBar();

    	Collection<String> questionBindingsList = formDataBinding.getQuestionBindingKeys();
    	String[] questionBindings = questionBindingsList.toArray(new String[questionBindingsList.size()]);
    	boolean sortAscending = false;
    	if (pagingLoadConfig.getSortDir() == SortDir.ASC || pagingLoadConfig.getSortDir() == SortDir.NONE) {
    	    sortAscending = true;
    	}
    	formService.getFormDataList(formDataBinding.getFormBinding(), questionBindings, 
                pagingLoadConfig.getOffset(), 
                pagingLoadConfig.getLimit(), 
                pagingLoadConfig.getSortField(),
                sortAscending,
    	        new EmitAsyncCallback<ExportedFormDataList>() {
            @Override
			public void onSuccess(ExportedFormDataList result) {
                List<FormDataSummary> results = new ArrayList<FormDataSummary>();
                for (ExportedFormData data : result.getExportedFormData()) {
                	FormDataSummary formDataSummary = new FormDataSummary(formDef, data);
                    results.add(formDataSummary);
                }
                ProgressIndicator.hideProgressBar();
                callback.onSuccess(new BasePagingLoadResult<FormDataSummary>(results, pagingLoadConfig.getOffset(), result.getTotalSize()));
            }
    	});
    }
    
    public void getUser() {
        userService.getLoggedInUser(new EmitAsyncCallback<User>() {
            @Override
			public void onSuccess(User result) {
            	formResponsesView.setUser(result);
            }
        });
    }
    
    public void saveFormDataResponse(final User user, final Record record, final FormDef formDef, org.purc.purcforms.client.model.FormDef purcFormDef) {
        ProgressIndicator.showProgressBar(); 
        // 1: Copy the updated data from the grid model and save in the purc form def
        Iterator<PageDef> pageIt = purcFormDef.getPages().iterator();
        while (pageIt.hasNext()) {            
            // Loop through all the questions in this page
            PageDef purcPageDef = pageIt.next();                        
            Iterator<QuestionDef> questionIt = purcPageDef.getQuestions().iterator();
            while (questionIt.hasNext()) {
                QuestionDef purcQuestionDef = questionIt.next();
                String updatedAnswer = null;
                switch (purcQuestionDef.getDataType()) {
                    // Retrieve the answer value from the record grid record
                    case QuestionDef.QTN_TYPE_TEXT:
                        String answerTxt = (String) record.get(purcQuestionDef.getVariableName());
                        updatedAnswer = (String) answerTxt;
                        break;
                    case QuestionDef.QTN_TYPE_NUMERIC:
                        Integer answerInt = (Integer) record.get(purcQuestionDef.getVariableName());
                        if (answerInt != null) {
                            updatedAnswer = String.valueOf(answerInt);
                        }
                        break;
                    case QuestionDef.QTN_TYPE_DECIMAL:
                        Double decimal = (Double) record.get(purcQuestionDef.getVariableName());
                        if (decimal != null) {
                            updatedAnswer = String.valueOf(decimal);
                        }
                        break;
                    case QuestionDef.QTN_TYPE_DATE:
                        Date answerDate = (Date)record.get(purcQuestionDef.getVariableName());
                        if (answerDate != null) {
                            DateTimeFormat dateFmt = DateTimeFormat.getFormat("yyyy-MM-dd");
                            updatedAnswer = dateFmt.format(answerDate);
                        }
                        break;
                    case QuestionDef.QTN_TYPE_TIME:
                        java.sql.Time t = (java.sql.Time)record.get(purcQuestionDef.getVariableName());
                        if (t != null) {
                        	Time timeField = new Time(t);
                            DateTimeFormat timeFmt = DateTimeFormat.getFormat("hh:mm:ss");
                            updatedAnswer = timeFmt.format(timeField.getDate());
                        }
                        break;
                        // This is a question with alist of options where not more than one option can be selected at a time. 
                    case QuestionDef.QTN_TYPE_LIST_EXCLUSIVE:
                        String answerLstExl = (String) record.get(purcQuestionDef.getVariableName());
                        updatedAnswer = (String) answerLstExl;                                  
                        break;
                        // This is a question with alist of options where more than one option can be selected at a time.
                    case QuestionDef.QTN_TYPE_LIST_MULTIPLE:
                        String answerLstMul = (String) record.get(purcQuestionDef.getVariableName());
                        updatedAnswer = (String) answerLstMul;                                  
                        break;
                        // Date and Time question type. This has both the date and time components
                    case QuestionDef.QTN_TYPE_DATE_TIME:
                        break;
                        // Question with true and false answers. 
                    case QuestionDef.QTN_TYPE_BOOLEAN:
                        String answerBool = (String) record.get(purcQuestionDef.getVariableName());
                        updatedAnswer = (String) answerBool;                                        
                        break;
                        // Question with repeat sets of questions.
                    case QuestionDef.QTN_TYPE_REPEAT:
                        break;
                        // Question with image. 
                    case QuestionDef.QTN_TYPE_IMAGE:
                        break;
                        // Question with recorded video.
                    case QuestionDef.QTN_TYPE_VIDEO:
                        break;
                        // Question with recoded audio.
                    case QuestionDef.QTN_TYPE_AUDIO:
                        break;
                    case QuestionDef.QTN_TYPE_LIST_EXCLUSIVE_DYNAMIC:
                        String answerLstDyn = (String) record.get(purcQuestionDef.getVariableName());
                        updatedAnswer = (String) answerLstDyn;   
                        break;
                } 
                
                Log.debug("Updated answer: "+purcQuestionDef.getVariableName()+"="+updatedAnswer);
                purcQuestionDef.setAnswer(updatedAnswer);
            }
        }

        // 2: Update the QuestionDef xml
        purcFormDef.updateDoc(true);
        
        // 3: Format XML data and pass it to FormData
        FormDataSummary fds = (FormDataSummary)record.getModel();
        final FormData fd = (FormData)fds.getExportedFormData().getFormData();
        String xml = XformUtil.getInstanceDataDoc(purcFormDef.getDoc()).toString();
        xml = "<?xml version='1.0' encoding='UTF-8' ?>\n"+xml;
        fd.setData(xml);
        
        // 4: Save the form data
        fd.setFormDefVersionId(formDef.getDefaultVersion().getFormDefVersionId());                          
        fd.setDateChanged(new Date());                          
        fd.setChangedBy(user);
        // submit the data
        formService.saveFormData(fd, new EmitAsyncCallback<FormData>() {
            @Override
			public void onSuccess(FormData result) {
                Log.info("Successful commit of Response");
                record.commit(false); // this clears the red triangle markers after the edit
            }
        });
        ProgressIndicator.hideProgressBar();            

    }
}
