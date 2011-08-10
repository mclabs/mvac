package org.openxdata.mvac.mobile;

//~--- non-JDK imports --------------------------------------------------------

import org.openxdata.communication.ConnectionSettings;
import org.openxdata.communication.TransportLayer;
import org.openxdata.communication.TransportLayerListener;
import org.openxdata.db.util.Persistent;
import org.openxdata.db.util.StorageListener;
import org.openxdata.model.FormData;
import org.openxdata.model.ResponseHeader;
import org.openxdata.model.StudyData;
import org.openxdata.model.StudyDataList;
import org.openxdata.model.UserListStudyDefList;
import org.openxdata.mvac.mobile.db.WFStorage;
import org.openxdata.workflow.mobile.model.MWorkItem;
import org.openxdata.workflow.mobile.model.MWorkItemData;
import org.openxdata.workflow.mobile.model.MWorkItemDataList;
import org.openxdata.workflow.mobile.model.MWorkItemInfoList;
import org.openxdata.workflow.mobile.model.MWorkItemList;
import org.openxdata.workflow.mobile.model.WFRequest;

//~--- JDK imports ------------------------------------------------------------

import java.util.Vector;
import org.openxdata.mvac.communication.MvacTransportLayer;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.Constants;

public class DownloadManager implements StorageListener {
    private final MvacTransportLayer tLayer;

    public DownloadManager(MvacTransportLayer tLayer) {
        this.tLayer = tLayer;
    }


    public void downloadWorkItems(TransportLayerListener tlListener) {
        setCommunicationParams();

        WFRequest      req                = getRequest("WIRDownload", null);
        MWorkItemList  workItemsToReceive = new MWorkItemList();
        Persistent     localData          = null;
        ResponseHeader rh                 = new ResponseHeader();
        System.out.println("tlayerDownload");
        tLayer.download(req, localData, rh, workItemsToReceive, tlListener, req.userName, req.password,
                        "Downloading Appointments");
    }

    public void downloadWorkItemsById(MWorkItemInfoList infoList, TransportLayerListener tListener) {
        setCommunicationParams();

        WFRequest      req                = getRequest("WIRDownloadById", null);
        MWorkItemList  workItemsToReceive = new MWorkItemList();
        ResponseHeader rh                 = new ResponseHeader();

        tLayer.download(req, infoList, rh, workItemsToReceive, tListener, req.userName, req.password,
                        "Downloading Selected Appointment");
    }

    public void downloadStudies(TransportLayerListener listener) {
        setCommunicationParams();

        WFRequest            req              = getRequest("FormDownload", "epihandyser");
        UserListStudyDefList listStudyDefList = new UserListStudyDefList();
        Persistent           nullLocalData    = null;
        ResponseHeader       rh               = new ResponseHeader();

        tLayer.download(req, nullLocalData, rh, listStudyDefList, listener, req.getUserName(), req.getPassword(),
                        "Downloading forms...");
    }

    public void uploadWorkItems(TransportLayerListener tLayerListener) {
        setCommunicationParams();

        WFRequest         req             = getRequest("WIRUpload", "epihandyser");
        MWorkItemDataList dataList        = getMWorkItemDatalist();
        ResponseHeader    rh              = new ResponseHeader();
        Persistent        nullDataFromOut = null;

        tLayer.upload(req, dataList, rh, nullDataFromOut, tLayerListener, req.getUserName(), req.getPassword(),
                      "Uploading workItems...");
    }

    public void dowloadWIRPreview(TransportLayerListener wirInfoPresenter) {
        setCommunicationParams();

        WFRequest         req            = getRequest("WIRInfoDownload", null);
        MWorkItemInfoList infoList       = new MWorkItemInfoList();
        Persistent        nullDataFromIn = null;
        ResponseHeader    rh             = new ResponseHeader();

        tLayer.download(req, nullDataFromIn, rh, infoList, wirInfoPresenter, (String)AppUtil.get().getItem(Constants.USERNAME),
                        (String)AppUtil.get().getItem(Constants.PASSWROD), "Downloading workItem List");
    }

    private WFRequest getRequest(String action, String seriliser) {
        System.out.println("Username=>"+(String)AppUtil.get().getItem(Constants.USERNAME));
         System.out.println("Password=>"+(String)AppUtil.get().getItem(Constants.PASSWROD));
        WFRequest wfRequest = new WFRequest((String)AppUtil.get().getItem(Constants.USERNAME), (String)AppUtil.get().getItem(Constants.PASSWROD), action);

        wfRequest.setSerializer(seriliser);

        return wfRequest;
    }

    public void setCommunicationParams() {
        String url = ConnectionSettings.getHttpUrl();

        if (url != null) {
            //http://158.38.65.142:8888/openxdatawf/wirdownload
            //http://localhost:8888/wirdownload
            tLayer.setCommunicationParameter(TransportLayer.KEY_HTTP_URL, "http://158.38.65.142:8888/openxdatawf/wirdownload");
        }
    }

    public void errorOccured(String errorMessage, Exception e) {
        e.printStackTrace();
    }

    private MWorkItemDataList getMWorkItemDatalist() {
        Vector            workItemList = WFStorage.getMWorkItemListWithData(this);
        MWorkItemDataList dataList     = new MWorkItemDataList();

        for (int i = 0; i < workItemList.size(); i++) {
            MWorkItem     wir      = (MWorkItem) workItemList.elementAt(i);
            MWorkItemData itemData = createMWorkItemData(wir);

            if (itemData.getFormDataData().isRequiredAnswered()) {
                dataList.addWorkItemData(itemData);
            }
        }

        return dataList;
    }

    private MWorkItemData createMWorkItemData(MWorkItem wir) {
        MWorkItemData wirData = new MWorkItemData();

        wirData.setTaskName(wir.getTaskName());
        wirData.setTaskId(wir.getTaskId());
        wirData.setCaseId(wir.getCaseId());

        FormData      formData      = WFStorage.getFormData(wir, true);
        StudyData     studyData     = new StudyData(-1, formData);
        StudyDataList studyDataList = new StudyDataList(studyData);

        wirData.setFormData(studyDataList);

        return wirData;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
