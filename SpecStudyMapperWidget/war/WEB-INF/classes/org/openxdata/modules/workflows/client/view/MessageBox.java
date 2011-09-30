package org.openxdata.modules.workflows.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class MessageBox extends PopupPanel
{

    /** The label to show the progress or processing message. */
    private HTML label = new HTML("processingMsg");

    /**
     * Creates a new instance of the progress dialog.
     */
    public MessageBox()
    {
	super(false, true);
	VerticalPanel panel = new VerticalPanel();
	Button btnOk = new Button("OK");

	panel.add(label);
	panel.add(btnOk);
	panel.setCellHorizontalAlignment(btnOk, HasAlignment.ALIGN_CENTER);
	setWidget(panel);

	btnOk.addClickHandler(new ClickHandler()
	{
	    @Override
	    public void onClick(ClickEvent event)
	    {
		dispose();
	    }
	});
    }

    private void dispose()
    {
	this.hide();
    }

    /**
     * Displays the progress dialog box at the center of the browser window with
     * the default progress message which is "Please wait while processing..."
     */
    public void center()
    {

	// Reset the progress message to the default because it may have been
	// been changed with a custom one.
	label.setText("processingMsg");

	super.center();
    }

    /**
     * Displays the progress dialog box at the center of the browser window and
     * with a custom progress message.
     * 
     * @param progressMsg
     *            the custom progress message.
     */
    public void showMsg(String progressMsg)
    {
	if (progressMsg == null)
	    center();
	else {
	    label.setHTML("<div>"+progressMsg+"</div>");
	    super.center();
	}
    }
    
    public void showError(String msq){
	setGlassEnabled(true);
	showMsg(msq);
    }
}
