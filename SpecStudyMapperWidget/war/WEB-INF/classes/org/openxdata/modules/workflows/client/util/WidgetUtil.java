package org.openxdata.modules.workflows.client.util;

import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

public class WidgetUtil
{

    public static void maximise(Widget l1)
    {
	l1.setSize("100%", "100%");

    }

    public static void maximiseWidth(Widget pnlMain)
    {
	pnlMain.setWidth("100%");

    }

    public static Panel centerWidgetToRootPanel(CellPanel root, Widget w)
    {
	Panel p = bindWidgetInPanel(root, w);

	root.setCellHorizontalAlignment(p, HasHorizontalAlignment.ALIGN_CENTER);
	root.setCellVerticalAlignment(p, HasVerticalAlignment.ALIGN_MIDDLE);

	return p;
    }

    private static Panel bindWidgetInPanel(CellPanel root, Widget w)
    {
	Panel p = null;
	if (w instanceof Panel) {
	    p = (Panel) w;
	} else {
	    root.remove(w);
	    p = new HorizontalPanel();
	    p.add(w);
	}
	if (root.getWidgetIndex(p) == -1)
	    root.add(p);
	return p;
    }

    public static HorizontalPanel getMeACenteredWidget(Widget w)
    {
	return (HorizontalPanel) centerWidgetToRootPanel(new HorizontalPanel(),
		w);
    }

    public static String getListBoxValue(ListBox listBox)
    {
	int idx = listBox.getSelectedIndex();
	if (idx == -1)
	    return null;
	return listBox.getItemText(idx);
    }

}
