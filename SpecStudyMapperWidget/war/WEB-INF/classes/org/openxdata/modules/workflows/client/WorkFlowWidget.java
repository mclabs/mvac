package org.openxdata.modules.workflows.client;

import org.openxdata.modules.workflows.client.gin.WFInjector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Composite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openxdata.modules.workflows.client.event.ACTION;
import org.openxdata.modules.workflows.client.event.NewSpecStudyMapEvent;
import org.openxdata.modules.workflows.client.event.NewSpecicationEvent;
import org.openxdata.modules.workflows.client.event.NewStudyEvent;
import org.openxdata.modules.workflows.client.event.NewTaskFormEvent;
import org.openxdata.modules.workflows.client.event.NewWIREvent;
import org.openxdata.modules.workflows.client.parser.MapParser;
import org.openxdata.modules.workflows.client.presenter.uimodel.AvailableWIRSModel;
import org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem;
import org.openxdata.modules.workflows.model.shared.OSpecification;
import org.openxdata.modules.workflows.client.maps.SpecStudyMap;
import org.openxdata.modules.workflows.client.maps.TaskFormDefMap;
import org.openxdata.server.admin.model.StudyDef;

public class WorkFlowWidget extends Composite
{

        private WFInjector injector = GWT.create(WFInjector.class);
        private HandlerManager eventBus;
        private HashMap<String, SpecStudyMap> deletedMaps;
        private HashMap<String, Integer> keysMap;

        public WorkFlowWidget()
        {
                initWidget(injector.getRootPanelPresenter().asWidget());
                eventBus = injector.getHandlerManager();
                deletedMaps = new HashMap<String, SpecStudyMap>();
                keysMap = new HashMap<String, Integer>();
                initHandlers();
        }

        /*
         * Initialiase all the eventBus handlers to listen to all application
         * events
         */
        private void initHandlers()
        {
                //Initialiase a handler to keep track of the deleted maps
                eventBus.addHandler(NewSpecStudyMapEvent.TYPE, new NewSpecStudyMapEvent.Handler()
                {

                        public void mapCreated(SpecStudyMap map)
                        {
                                //Remove the map from deleted maps table
                                removeDeletedMap(map);
                        }

                        public void mapDeleted(SpecStudyMap map)
                        {
                                //Add the map to deleted maps table
                                addDeletedMap(map);
                        }
                });
        }

        /**
         * Loads studies into the whole widget
         * @param studies studies to load
         */
        public void loadStudies(List<StudyDef> studies)
        {
                //Notify all the guys listening for new studies
                for (StudyDef studyDef : studies) {
                        eventBus.fireEvent(new NewStudyEvent(studyDef));
                }
        }

        /**
         * Loads OSpecifications into the widget
         * @param oSpecs
         */
        public void loadOSpecifications(List<OSpecification> oSpecs)
        {
                //Notify all the guys listening through the event bus
                for (OSpecification oSpecification : oSpecs) {
                        eventBus.fireEvent(new NewSpecicationEvent(oSpecification));
                }
        }

        /**
         * Remove map from deleted maps
         * @param map map to remove
         */
        private void removeDeletedMap(SpecStudyMap map)
        {
                deletedMaps.remove(map.getUniqueName());
        }

        /**
         * Adds a deleted map to the deletedMaps {@link HashMap} but only if the
         * map that is deleted was loaded externally e.g from the DB
         * @param map map to add
         */
        private void addDeletedMap(SpecStudyMap map)
        {
                //Check if map was loaded from the DB.i.e if its string
                //representation is contained in the keys map then
                //add it to the deleted maps
                if (keysMap.containsKey(map.getUniqueName())) {
                        map.setId(keysMap.get(map.getUniqueName()));
                        deletedMaps.put(map.getUniqueName(), map);
                }
        }

        public List<SpecStudyMap> getMaps()
        {
                List<SpecStudyMap> maps = injector.getSpecStudyUiModel().getMaps();
                //Get all the maps set there IDs just in case a map was deleted and recreated
                //hence the id could have gotten lost
                for (SpecStudyMap specStudyMap : maps) {
                        Integer intId = this.keysMap.get(specStudyMap.getUniqueName());
                        if (intId != null) {
                                specStudyMap.setId(intId);
                        }
                }
                return maps;
        }

        /**
         * Gets all newly created maps and modifies maps
         * @return Lists off all dirty maps that need to be save
         */
        public List<SpecStudyMap> getDirtyMaps()
        {
                List<SpecStudyMap> maps = getMaps();
                for (SpecStudyMap specStudyMap : getMaps()) {
                        if (!specStudyMap.isDirty()) {
                                maps.remove(specStudyMap);
                        }
                }
                return maps;
        }

        public List<SpecStudyMap> getDeletedMaps()
        {
                return new ArrayList<SpecStudyMap>(deletedMaps.values());
        }

        public List<OSpecification> getSpecs()
        {
                return injector.getSpecStudyUiModel().getSpecsAsList();
        }

        public List<StudyDef> getStudies()
        {
                return injector.getSpecStudyUiModel().getStudiesAsList();
        }

        /**
         * Loads a list of all xmlMap strings
         * @param xmlMaps XML map strings
         */
        public void LoadSpecStudyMaps(List<String> xmlMaps)
        {

                StringBuilder builder = new StringBuilder();
                /*Concatenate all and load them all at once*/
                builder.append("<Maps>");
                for (String string : xmlMaps) {
                        builder.append(string);
                }
                builder.append("</Maps>");
                loadXMLMap(builder.toString());
        }

        public void loadXMLMap(String xmlMap)
        {
                List<SpecStudyMap> specStudyMaps = MapParser.createMaps(getSpecs(), getStudies(), xmlMap.toString());
                //Set all maps to cleans before loading them
                for (SpecStudyMap specStudyMap : specStudyMaps) {
                        specStudyMap.setDirty(false);
                }
                loadMaps(specStudyMaps);
        }

        public void loadMaps(List<SpecStudyMap> maps)
        {
                for (SpecStudyMap specStudyMap : maps) {
                        eventBus.fireEvent(new NewSpecStudyMapEvent(specStudyMap));
                        /*Store the ids so that they can be later used by hibernate for persistance*/
                        this.keysMap.put(specStudyMap.getUniqueName(), specStudyMap.getId());

                        List<TaskFormDefMap> taskFormDefMaps = specStudyMap.getTaskFormDefMaps();
                        for (TaskFormDefMap taskFormDefMap : taskFormDefMaps) {
                                eventBus.fireEvent(new NewTaskFormEvent(taskFormDefMap, ACTION.ADD));
                        }
                }
        }

        /**
         * Deletes all SpecStudy maps.
         */
        public void clearMaps()
        {
                List<SpecStudyMap> maps = injector.getSpecStudyUiModel().getMaps();
                for (SpecStudyMap specStdMp : maps) {
                        eventBus.fireEvent(new NewSpecStudyMapEvent(specStdMp, ACTION.DELETE));
                }
                final AvailableWIRSModel availableWIRSModel = injector.getAvailableWIRSModel();
                eventBus.fireEvent(new NewWIREvent(availableWIRSModel.getWorkItems(), ACTION.DELETE));
                this.deletedMaps.clear(); //clear the deleted maps
                this.keysMap.clear();//clear the map which holds the database ids
        }

        public void loadWorkItems(List<GWTFriendlyWorkItem> wirs)
        {
                eventBus.fireEvent(new NewWIREvent(wirs));
        }

        /**
         * Return true if there is any newly created map. This is true if there is any
         * {@link SpecStudyMap#getId() } == 0
         * @return
         */
        public boolean hasNewMaps()
        {
                List<SpecStudyMap> dirtyMaps = getDirtyMaps();
                for (SpecStudyMap map : dirtyMaps) {
                        if (map.getId() == 0) {
                                return true;
                        }
                }
                return false;
        }

        public boolean isComplete()
        {
                return false;
        }
}
