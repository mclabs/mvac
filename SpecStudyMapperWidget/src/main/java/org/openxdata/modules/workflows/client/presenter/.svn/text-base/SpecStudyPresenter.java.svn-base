package org.openxdata.modules.workflows.client.presenter;

import org.openxdata.modules.workflows.client.event.ACTION;
import org.openxdata.modules.workflows.client.event.NewSpecStudyMapEvent;
import org.openxdata.modules.workflows.client.event.NewSpecicationEvent;
import org.openxdata.modules.workflows.client.event.NewStudyEvent;
import org.openxdata.modules.workflows.client.presenter.uimodel.SpecStudyUiModel;
import org.openxdata.modules.workflows.model.shared.OSpecification;
import org.openxdata.modules.workflows.client.maps.SpecStudyMap;
import org.openxdata.server.admin.model.StudyDef;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasText;
import com.google.inject.Inject;

public class SpecStudyPresenter implements
        IPresenter<SpecStudyPresenter.Display>
{
    public interface Display extends WidgetDisplay
    {
        public HasClickHandlers taskFormList();

        public HasText getSpecTxt();

        public HasText getStudyTxt();

        public HasClickHandlers getAddMatchBtn();

        public HasClickHandlers getDeleteMatchBtn();

        public void showError(String error);

        public void setModel(SpecStudyUiModel model);

        public void refresh();

        public String getSelectedMatch();
    }
    private Display display;
    private HandlerManager eventBus;
    private SpecStudyUiModel model;
    private boolean selfFired = false;

    @Inject
    public SpecStudyPresenter(HandlerManager eventBus,
                              Display display,
                              SpecStudyUiModel model)
    {
        this.display = display;
        this.eventBus = eventBus;
        this.model = model;

        display.setModel(model);
        bindUi();
        initHandlers();
    }

    private void bindUi()
    {
        display.getAddMatchBtn().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                match();
            }
        });

        display.getDeleteMatchBtn().addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                unmatch();
            }
        });
    }

    private void initHandlers()
    {

        NewSpecicationEvent.Handler newSpecHandler = new NewSpecicationEvent.Handler()
        {
            @Override
            public void onSpecLoaded(OSpecification spec)
            {
                addSpecification(spec);
            }
        };
        eventBus.addHandler(NewSpecicationEvent.TYPE, newSpecHandler);

        NewStudyEvent.Handler newStudyEvntHandler = new NewStudyEvent.Handler()
        {
            @Override
            public void onStudyLoaded(StudyDef studyDef)
            {
                addStudy(studyDef);
            }
        };
        eventBus.addHandler(NewStudyEvent.TYPE, newStudyEvntHandler);

        NewSpecStudyMapEvent.Handler newSpecStudyEventHandler = new NewSpecStudyMapEvent.Handler()
        {
            @Override
            public void mapDeleted(SpecStudyMap map)
            {
                if (!selfFired)
                    removerMap(map);
            }

            @Override
            public void mapCreated(SpecStudyMap map)
            {
                if (!selfFired)
                    addMap(map);
            }
        };
        eventBus.addHandler(NewSpecStudyMapEvent.TYPE, newSpecStudyEventHandler);

    }

    public void removerMap(SpecStudyMap map)
    {
        model.removeMatch(map.getUniqueName());
        refreshDisplay();
    }

    public void addMap(SpecStudyMap map)
    {
        model.addMatch(map);
        refreshDisplay();
    }

    protected void unmatch()
    {
        String matchString = display.getSelectedMatch();
        if (matchString == null) {
            display.showError("No Match Selected");
        } else {
            SpecStudyMap removedMap = model.removeMatch(matchString);
            eventBus.fireEvent(new NewSpecStudyMapEvent(removedMap, ACTION.DELETE));
            refreshDisplay();
        }
    }

    private void match()
    {
        String specText = display.getSpecTxt().getText();
        if (specText == null || specText.equals("")) {
            display.showError("Please Select a Specification");
            return;
        }
        String studyText = display.getStudyTxt().getText();
        if (studyText == null || studyText.equals("")) {
            display.showError("Please Select a Study");
            return;
        }

        SpecStudyMap map = model.match(specText, studyText);
        selfFired = true;
        eventBus.fireEvent(new NewSpecStudyMapEvent(map));
        selfFired = false;
        refreshDisplay();
    }

    public void addSpecification(OSpecification spec)
    {
        model.addSpec(spec);
        refreshDisplay();
    }

    public void addStudy(StudyDef studyDef)
    {
        model.addStudy(studyDef);
        refreshDisplay();
    }

    @Override
    public Display getDisplay()
    {
        return display;
    }

    private void refreshDisplay()
    {
        display.refresh();
    }
}
