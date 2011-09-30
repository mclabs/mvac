/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.server.admin.client.view;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import java.util.ArrayList;
import java.util.List;
import org.openxdata.modules.workflows.client.WorkFlowWidget;
import org.openxdata.modules.workflows.client.dispatch.HelpCalback;
import org.openxdata.modules.workflows.client.view.MessageBox;
import org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem;
import org.openxdata.modules.workflows.model.shared.OSpecification;
import org.openxdata.modules.workflows.model.shared.dto.SpecStudyMapDTO;
import org.openxdata.modules.workflows.client.maps.SpecStudyMap;
import org.openxdata.modules.workflows.client.maps.validator.CompletenessValidator;
import org.openxdata.modules.workflows.client.maps.validator.DefaultCompletenessValidator;
import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.events.ViewMatchWorkflowsEvent;
import org.openxdata.server.admin.client.listeners.ItemChangeListener;
import org.openxdata.server.admin.client.service.workflow.SpecStudyMapServiceAsync;
import org.openxdata.server.admin.client.service.workflow.SpecificationServiceAsync;
import org.openxdata.server.admin.client.view.factory.OpenXDataViewFactory;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.bar.OpenXDataToolBar;
import org.openxdata.server.admin.client.view.listeners.OpenXDataViewApplicationEventListener;
import org.openxdata.server.admin.model.StudyDef;

/**
 *
 * @author kay
 */
public class WorkFlowView extends OpenXDataBaseView implements
        OpenXDataViewApplicationEventListener {

        private HandlerManager eventBus = Context.getEventBus();
        private WorkFlowWidget workFlowWidget;
        private SpecStudyMapServiceAsync specStdSrv;
        private SpecificationServiceAsync specSrv;
        private boolean alreadyInitialiased = false;

        public WorkFlowView(ItemChangeListener itemChangeListener,
                OpenXDataViewFactory openXDataViewFactory) {
                super(itemChangeListener, openXDataViewFactory);
                initHandlers();
                bindToToolBarEvents();
                specStdSrv = Context.getSpecStudyMapServiceAsync();
                specSrv = Context.getSpecificationServiceAsync();
        }

        @Override
        protected void setUp() {
                workFlowWidget = new WorkFlowWidget();
                initWidget(tabs);
                Utilities.maximizeWidget(workFlowWidget);
                tabs.add(workFlowWidget, "Match Workflows");
                Utilities.maximizeWidget(tabs);
                tabs.selectTab(0);
        }

        private void initHandlers() {
                ViewMatchWorkflowsEvent.Handler handler = new ViewMatchWorkflowsEvent.Handler() {

                        @Override
                        public void onViewed() {
                                if (!alreadyInitialiased) {
                                        loadData();
                                        alreadyInitialiased = true;
                                }
                        }
                };
                eventBus.addHandler(ViewMatchWorkflowsEvent.TYPE, handler);
        }

        private void loadData() {
                loadStudiesIntoWidget();
                loadSpecAndMapsIntoWidget();
                loadWorkItems();
        }

        private void loadWorkItems() {
                HelpCalback<ArrayList<GWTFriendlyWorkItem>> callBck = new HelpCalback<ArrayList<GWTFriendlyWorkItem>>() {

                        @Override
                        public void callback(ArrayList<GWTFriendlyWorkItem> result) {
                                workFlowWidget.loadWorkItems(result);
                        }
                };
                specStdSrv.getMappedWorkItems(callBck);
        }

        private void loadStudiesIntoWidget() {
                List<StudyDef> studies = Context.getStudies();
                workFlowWidget.loadStudies(studies);
        }

        private void loadSpecAndMapsIntoWidget() {
                HelpCalback<List<OSpecification>> callBack = new HelpCalback<List<OSpecification>>() {

                        @Override
                        public void callback(List<OSpecification> specs) {
                                workFlowWidget.loadOSpecifications(specs);
                                loadMapsFromDB();
                        }
                };
                specSrv.getOSpecifications(callBack);
        }

        private void loadMapsFromDB() {
                HelpCalback<String> callBck = new HelpCalback<String>() {

                        @Override
                        public void callback(String result) {
                                workFlowWidget.loadXMLMap(result);
                        }
                };
                specStdSrv.getEntireXMLMap(callBck);
        }

        @Override
        public void onSave() {

                CompletenessValidator completeValidator = new DefaultCompletenessValidator();
                final ArrayList<SpecStudyMapDTO> deletedMapDTOs = (ArrayList<SpecStudyMapDTO>) getDeletedMapDTOs(completeValidator);
                final ArrayList<SpecStudyMapDTO> dirtyMapDTOs = (ArrayList<SpecStudyMapDTO>) getDirtyMapDTOs(completeValidator);

                if (deletedMapDTOs.isEmpty() && dirtyMapDTOs.isEmpty()) {
                        return;
                }

                if (completeValidator.hasErrors()) {
                        MessageBox box = new MessageBox();
                        box.showError(completeValidator.getErrors());
                        return;
                }
                HelpCalback<Void> callBck = new HelpCalback<Void>() {

                        @Override
                        public void callback(Void result) {
                                Window.alert("Maps Saved");
                                //reload the maps only if there were some new maps that were createad
                                if (workFlowWidget.hasNewMaps() && !dirtyMapDTOs.isEmpty()) {
                                        refreshMaps();
                                }

                        }
                };
                specStdSrv.saveMaos(dirtyMapDTOs, deletedMapDTOs, callBck);




        }

        private List<SpecStudyMapDTO> getDirtyMapDTOs(CompletenessValidator completeValidator) {
                List<SpecStudyMap> maps = workFlowWidget.getDirtyMaps();
                return toSpecStudyDTOs(maps, completeValidator);
        }

        private List<SpecStudyMapDTO> getDeletedMapDTOs(CompletenessValidator completeValidator) {
                List<SpecStudyMap> deletedMaps = workFlowWidget.getDeletedMaps();
                return toSpecStudyDTOs(deletedMaps, completeValidator);
        }

        public List<SpecStudyMapDTO> toSpecStudyDTOs(List<SpecStudyMap> maps, CompletenessValidator completeValidator) {
                List<SpecStudyMapDTO> mapDTOs = new ArrayList<SpecStudyMapDTO>();
                for (SpecStudyMap map : maps) {
                        mapDTOs.add(toSpecStudyDTO(map, completeValidator));
                }
                return mapDTOs;
        }

        private SpecStudyMapDTO toSpecStudyDTO(SpecStudyMap map, CompletenessValidator completeValidator) {


                SpecStudyMapDTO specStudyMapDTO = new SpecStudyMapDTO(
                        map.getStudyDef(), map.getoSpecification(), map.asXml(completeValidator));

                specStudyMapDTO.setSpecId(map.getoSpecification().getUniqueName());
                specStudyMapDTO.setId(map.getId());
                return specStudyMapDTO;
        }

        private void refreshMaps() {
                workFlowWidget.clearMaps();
                loadMapsFromDB();
                loadWorkItems();
        }

        private void bindToToolBarEvents() {
                ((OpenXDataToolBar) widgetFactory.getOpenXDataToolBar()).registerApplicationEventListener(this);
        }

        @Override
        public void onRefresh() {
                refreshMaps();
        }

        @Override
        public void onNewItem() {
        }

        @Override
        public void onDeleteItem() {
        }

        @Override
        public void onNewChildItem() {
        }

        @Override
        public void onItemSelected(Composite sender, Object item) {
        }
}
