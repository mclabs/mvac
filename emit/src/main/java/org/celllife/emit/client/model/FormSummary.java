package org.celllife.emit.client.model;

import java.util.Date;

import org.openxdata.server.admin.model.FormDef;

import com.extjs.gxt.ui.client.data.BaseModel;

public class FormSummary extends BaseModel {

    private static final long serialVersionUID = 3037791298938446908L;
    
    private FormDef formDefinition;

    public FormSummary() {
	}
	
	public FormSummary(String id, String form, String version, String status, String organisation, String creator, Date changed, String responses) {
		setId(id);
	    setForm(form);
	    setVersion(version);
	    setStatus(status);
	    setOrganisation(organisation);
	    setCreator(creator);
	    setChanged(changed);
	    setResponses(responses);
	}	

	  public String getId() {
	    return get("id");
	  }

	  public void setId(String id) {
	    set("id", id);
	  }	

	  public String getForm() {
	    return get("form");
	  }

	  public void setForm(String form) {
	    set("form", form);
	  }

	  public String getStatus() {
	    return get("status");
	  }

	  public void setStatus(String status) {
	    set("status", status);
	  }
	  

	  public String getOrganisation() {
	    return get("organisation");
	  }

	  public void setOrganisation(String organisation) {
	    set("organisation", organisation);
	  }
	  

	  public String getCreator() {
	    return get("creator");
	  }

	  public void setCreator(String creator) {
	    set("creator", creator);
	  }
	  

	  public Date getChanged() {
	    return get("changed");
	  }

	  public void setChanged(Date changed) {
	    set("changed", changed);
	  }
	  
	  public String getResponses() {
	      return get("responses");
	  }
	  
	  public void setResponses(String responses) {
	      set("responses", responses);
	  }
	  
	  public String getVersion() {
	      return get("version");
	  }
	  
	  public void setVersion(String version) {
	      set("version", version);
	  }

    public FormDef getFormDefinition() {
        return formDefinition;
    }

    public void setFormDefinition(FormDef formDefinition) {
        this.formDefinition = formDefinition;
    }
}
