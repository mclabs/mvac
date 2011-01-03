package org.openxdata.modules.workflows.client.view;

import org.openxdata.modules.workflows.client.presenter.SpecificationPresenter;
import org.openxdata.modules.workflows.client.util.WidgetUtil;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class SpecificationView implements SpecificationPresenter.Display
{

    private VerticalPanel vPanel = new VerticalPanel();
    private TextArea txtXML = new TextArea();
    private Button btnLoadSpec = new Button("Load Specification");
    private Button btnLoadStudy = new Button("Load Study");
    private Button btnFileStudies = new Button("Load from Files");
    private Button btnFileSpecs = new Button("Load Spec Froom Files");
    private Button btnShowXml = new Button("Show XML");
    private Button btnParseXMl = new Button("Parse XML");
    private Button btnLoadWorkItems = new Button("Loas WorkItems");

    public SpecificationView()
    {
        HorizontalPanel pnl = new HorizontalPanel();
        pnl.add(btnLoadSpec);
        pnl.add(btnLoadStudy);
        pnl.add(btnFileSpecs);
        pnl.add(btnFileStudies);
        pnl.add(btnShowXml);
        pnl.add(btnParseXMl);
        pnl.add(btnLoadWorkItems);

        vPanel.add(txtXML);
        vPanel.setCellHeight(txtXML, "80%");
        WidgetUtil.maximise(txtXML);

        vPanel.add(pnl);
        WidgetUtil.maximise(vPanel);

    }

    @Override
    public HasClickHandlers getLoadSpecButton()
    {

        return btnLoadSpec;
    }

    @Override
    public HasText getXMLTextBox()
    {

        return txtXML;
    }

    @Override
    public Widget asWidget()
    {
        // TODO Auto-generated method stub
        return vPanel;
    }

    @Override
    public HasClickHandlers getLoadStudyButton()
    {
        return btnLoadStudy;
    }

    public void showMessage(String msg)
    {
        Window.alert(msg);
    }

    @Override
    public HasClickHandlers getLoadSpecFilesButton()
    {
        return btnFileSpecs;
    }

    @Override
    public HasClickHandlers getLoadStudyFilesButton()
    {
        return btnFileStudies;
    }

    @Override
    public HasClickHandlers getShowXMLButton()
    {
        return btnShowXml;
    }

    public HasClickHandlers getparseXMLButton()
    {
        return btnParseXMl;
    }

    public HasClickHandlers getLoadWorkItemsButton()
    {
       return btnLoadWorkItems;
    }
}
