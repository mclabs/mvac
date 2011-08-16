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
    
    public void downloadLotNames(TransportLayerListener tlListener) {
        setCommunicationParams();

        WFRequest      req                = getRequest("LotNameDownload", null);
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
        
        System.out.println("@ DowloadManager : getting request");
        
        WFRequest         req             = getRequest("WIRUpload", "epihandyser");
        
        System.out.println("@ DowloadManager : gotten request");
        
        MWorkItemDataList dataList        = getMWorkItemDatalist();
        
        
        if (dataList!=null) {
            System.out.println("@ DowloadManager : gotten datalist of ->"+dataList.getDataList().size());
            ResponseHeader    rh              = new ResponseHeader();
            System.out.println("@ DowloadManager : gotten response header");
        
            Persistent        nullDataFromOut = null;

            tLayer.upload(req, dataList, rh, nullDataFromOut, tLayerListener, req.getUserName(), req.getPassword(),
                      "Uploading workItems...");
        }else{
            tLayerListener.uploaded(null, null);
        }
        
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
         System.out.println("NurseName=>"+(String)AppUtil.get().getItem(Constants.NURSENAME));
         System.out.println("DownloadDate=>"+(String)AppUtil.get().getItem(Constants.DOWNLOAD_DATE));
         String nurseName=(String)AppUtil.get().getItem(Constants.NURSENAME);
         String downDate = (String)AppUtil.get().getItem(Constants.DOWNLOAD_DATE);
         
         if(nurseName==null){
             nurseName="NoNurse";
         }
         if (downDate==null) {
            downDate="NoDate";
        }
         
        WFRequest wfRequest = new WFRequest((String)AppUtil.get().getItem(Constants.USERNAME), (String)AppUtil.get().getItem(Constants.PASSWROD),nurseName,downDate, action);

        wfRequest.setSerializer(seriliser);

        return wfRequest;
    }

    public void setCommunicationParams() {
        //String url = ConnectionSettings.getHttpUrl();
        //System.out.println("@ DowloadManager : url->"+url);
        tLayer.setCommunicationParameter(TransportLayer.KEY_HTTP_URL, Constants.DWN_URL);
//        if (url != null) {
//            
//        }
            //http://158.38.65.142:8888/openxdatawf/wirdownload
            //http://localhost:8888/wirdownload
//            tLayer.setCommunicationParameter(TransportLayer.KEY_HTTP_URL, "http://158.38.65.142:8888/openxdatawf/wirdownload");
            
        
    }

    public void errorOccured(String errorMessage, Exception e) {
        e.printStackTrace();
    }

    private MWorkItemDataList getMWorkItemDatalist() {
        System.out.println("@ DowloadManager : getting workItemList->");
        Vector   workItemList =null;
        
        try {
            workItemList = WFStorage.getMWorkItemListWithData(this);
        } catch (Exception e) {
            System.out.println("@ DowloadManager : Exception Here");
            //e.printStackTrace();
        }
         
        System.out.println("@ DowloadManager : gotten workItemList->"+workItemList);
        if(workItemList==null){
            return null;
        }
        System.out.println("@ DowloadManager : continuing workItemList->"+workItemList);
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
