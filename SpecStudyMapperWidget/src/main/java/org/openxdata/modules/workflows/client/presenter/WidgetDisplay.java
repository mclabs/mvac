package org.openxdata.modules.workflows.client.presenter;

import com.google.gwt.user.client.ui.Widget;

public interface WidgetDisplay {
	
	public Widget asWidget() ;
	
	public void showMessage(String message);

}
