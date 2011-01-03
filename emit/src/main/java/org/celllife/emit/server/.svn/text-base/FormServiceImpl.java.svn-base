package org.celllife.emit.server;

import java.util.List;

import org.celllife.emit.client.service.FormService;
import org.openxdata.server.admin.model.ExportedFormDataList;
import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.rpc.OxdPersistentRemoteService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class FormServiceImpl extends OxdPersistentRemoteService implements FormService {

    private static final long serialVersionUID = 2126615349350883086L;
    private org.openxdata.server.service.FormService formService;
	
    @Override
	public List<FormData> getFormData(int formId) throws OpenXDataException {
        return getFormService().getFormData(formId);
    }

    @Override
	public Integer getFormResponseCount(int formId) throws OpenXDataException {
        return getFormService().getFormResponseCount(formId);
    }

    @Override
	public List<FormDef> getForms() throws OpenXDataException {
        return getFormService().getForms();
    }

    @Override
	public FormData saveFormData(FormData formData) throws Exception {
        return getFormService().saveFormData(formData);
    }
    
    @Override
	public List<FormDef> getFormsForCurrentUser() throws OpenXDataException {
        return getFormService().getFormsForCurrentUser();
    }
    
    @Override
	public  ExportedFormDataList getFormDataList(String formBinding, String[] questionBindings, int offset, int limit, String sortField, boolean ascending) throws OpenXDataException {
        return getFormService().getFormDataList(formBinding, questionBindings, offset, limit, sortField, ascending);
    }
    
    private org.openxdata.server.service.FormService getFormService() {
        if (formService == null) {
            WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
            formService = (org.openxdata.server.service.FormService) ctx.getBean("formService");
        }
        return formService;
    }
}