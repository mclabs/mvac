package org.openxdata.modules.workflows.client.presenter;

import java.util.ArrayList;
import java.util.List;


import org.openxdata.modules.workflows.client.event.NewSpecStudyMapEvent;
import org.openxdata.modules.workflows.client.event.NewStudyEvent;
import org.openxdata.modules.workflows.client.util.StudyImport;
import org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem;
import org.openxdata.modules.workflows.client.maps.SpecStudyMap;
import org.openxdata.server.admin.model.StudyDef;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.XMLParser;
import com.google.inject.Inject;
import net.customware.gwt.dispatch.client.DispatchAsync;
import org.openxdata.modules.workflows.client.dispatch.HelpCalback;
import org.openxdata.modules.workflows.client.event.NewSpecicationEvent;
import org.openxdata.modules.workflows.client.event.NewWIREvent;
import org.openxdata.modules.workflows.client.parser.MapParser;
import org.openxdata.modules.workflows.client.util.RandomWIR;
import org.openxdata.modules.workflows.model.shared.OSpecification;
import org.openxdata.modules.workflows.shared.rpc.GetSpecsAction;
import org.openxdata.modules.workflows.shared.rpc.GetStudiesAction;
import org.openxdata.modules.workflows.shared.rpc.ParseSpecAction;

public class SpecificationPresenter implements
        IPresenter<SpecificationPresenter.Display>
{
    private StringBuilder getMapXML()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("<Maps>");
        for (SpecStudyMap map : specStudyMap) {
            builder.append(map.asXml(null));
        }
        builder.append("</Maps>");
        return builder;
    }

    public interface Display extends WidgetDisplay
    {
        public HasText getXMLTextBox();

        public HasClickHandlers getLoadSpecButton();

        public HasClickHandlers getLoadStudyButton();

        public HasClickHandlers getLoadStudyFilesButton();

        public HasClickHandlers getLoadSpecFilesButton();

        public HasClickHandlers getShowXMLButton();

        public HasClickHandlers getparseXMLButton();

        public HasClickHandlers getLoadWorkItemsButton();
    }
    private Display display;
    private final DispatchAsync dispatch;
    private HandlerManager eventBus;
    private List<SpecStudyMap> specStudyMap = new ArrayList<SpecStudyMap>();

    @Inject
    public SpecificationPresenter(DispatchAsync dispatch,
                                  HandlerManager eventBus, Display display)
    {

        this.display = display;
        this.dispatch = dispatch;
        this.eventBus = eventBus;


        bindUi();
        initHandlers();
    }

    private void initHandlers()
    {
        NewSpecStudyMapEvent.Handler handler = new NewSpecStudyMapEvent.Handler()
        {
            @Override
            public void mapDeleted(SpecStudyMap map)
            {
                specStudyMap.remove(map);
            }

            @Override
            public void mapCreated(SpecStudyMap map)
            {
                specStudyMap.add(map);
            }
        };
        eventBus.addHandler(NewSpecStudyMapEvent.TYPE, handler);

    }

    private void bindUi()
    {

        display.getLoadSpecButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                String specXml = display.getXMLTextBox().getText();
                loadSpecification(specXml);
            }
        });

        display.getLoadStudyButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                String studyXml = display.getXMLTextBox().getText();
                loadStudy(studyXml);
            }
        });

        display.getLoadSpecFilesButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                loadSpecFiles();
            }
        });
        display.getLoadStudyFilesButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                loadFileStudies();
            }
        });
        display.getShowXMLButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                showXML();
            }
        });

        display.getparseXMLButton().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                parseXML();
            }
        });
        display.getLoadWorkItemsButton().addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                loadRandomWorkItems();
            }
        });
    }

    public void showXML()
    {
        StringBuilder builder = getMapXML();
        Document parse = null;
        try {
            parse = XMLParser.parse(builder.toString());
        } catch (Exception e) {
            display.showMessage(e.getMessage());
        }
        if (parse == null) {
            display.getXMLTextBox().setText(
                    "=====TEXT PLAIN====\n" + builder.toString());
        } else {
            display.getXMLTextBox().setText(
                    "=====PARSER PLAIN====\n" + parse.toString());
        }
    }

    private void parseXML()
    {
        StringBuilder mapXML = getMapXML();
        MapParser.parseXMLMap(mapXML.toString());
    }

    public void loadFileStudies()
    {
        HelpCalback<GetStudiesAction.Result> callback = new HelpCalback<GetStudiesAction.Result>()
        {
            @Override
            public void callback(GetStudiesAction.Result result)
            {
                loadStudies(result.getStudies());
            }
        };
        dispatch.execute(new GetStudiesAction(), callback);
    }

    public void loadStudy(String studyXml)
    {
        ArrayList<String> studies = new ArrayList<String>();
        studies.add(studyXml);
        loadStudies(studies);
    }

    public void loadStudies(List<String> studies)
    {
        StringBuilder error = new StringBuilder();
        int i = 0;
        for (String studyXml : studies) {
            try {
                StudyDef stDef = (StudyDef) StudyImport.importStudyItem(studyXml);

                if (stDef != null) {
                    eventBus.fireEvent(new NewStudyEvent(stDef));
                    i++;
                } else {
                    throw new RuntimeException("Error in XML");
                }
            } catch (Exception e) {
                error.append(e.getMessage()).append("\n");
            }
        }

        if (error.toString().equals("")) {
            display.showMessage(i + " Studies Loaded with no Errors");
        } else {
            display.showMessage(i
                    + " Studies Loaded with the following errors\n" + error);
        }
    }

    public void loadSpecFiles()
    {
        HelpCalback<GetSpecsAction.Result> callback = new HelpCalback<GetSpecsAction.Result>()
        {
            @Override
            public void callback(GetSpecsAction.Result result)
            {
                ArrayList<OSpecification> ospecifications = result.getOspecification();
                int i = 0;
                for (OSpecification oSpecification : ospecifications) {
                    eventBus.fireEvent(new NewSpecicationEvent(oSpecification));
                    i++;
                }
                display.showMessage(i + " Specification Loaded...Done!");
            }
        };
        dispatch.execute(new GetSpecsAction(), callback);
    }

    public void loadSpecification(String xml)
    {
        HelpCalback<ParseSpecAction.Result> callback = new HelpCalback<ParseSpecAction.Result>()
        {
            @Override
            public void callback(ParseSpecAction.Result result)
            {
                eventBus.fireEvent(new NewSpecicationEvent(result.getOspecification()));
                display.showMessage("Loaded Succesfully");
            }
        };
        dispatch.execute(new ParseSpecAction(xml), callback);
    }

    private void loadRandomWorkItems()
    {
        List<GWTFriendlyWorkItem> wirs = RandomWIR.genRandomWIRs(100);
        eventBus.fireEvent(new NewWIREvent(wirs));
    }

    @Override
    public Display getDisplay()
    {

        return display;
    }
}
