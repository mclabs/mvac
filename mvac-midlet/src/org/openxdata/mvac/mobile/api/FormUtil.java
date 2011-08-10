/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.api;

import org.openxdata.db.util.StorageListener;
import org.openxdata.model.FormData;
import org.openxdata.model.FormDef;
import org.openxdata.mvac.mobile.db.WFStorage;
import org.openxdata.workflow.mobile.model.MWorkItem;

/**
 *
 * @author soyfactor
 */
public class FormUtil implements StorageListener{
    
    public FormUtil(){

    }

    public FormDef getFormDef(MWorkItem wir){
        return WFStorage.getFormDefForWorkItem(wir);

    }

    public FormData getFormData(FormDef formDef,MWorkItem wir){
        return WFStorage.getOrCreateFormData(wir, formDef);

    }

    public void saveMworkItem(MWorkItem wir){
        WFStorage.saveMWorkItem(wir, this);

    }

    public void errorOccured(String string, Exception excptn) {
        excptn.printStackTrace();
    }


}
