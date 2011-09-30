/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.client.presenter.uimodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem;

/**
 *
 * @author kay
 */
public class AvailableWIRSModel
{
    HashMap<String, GWTFriendlyWorkItem> wirsMap = new HashMap<String, GWTFriendlyWorkItem>();

    public List<GWTFriendlyWorkItem> getWorkItems()
    {
        return new ArrayList<GWTFriendlyWorkItem>(wirsMap.values());
    }

    public void addWir(GWTFriendlyWorkItem wir)
    {
        wirsMap.put(wir.getWorkItemId(), wir);
    }

    public void deleteWorkItems(List<GWTFriendlyWorkItem> wirs)
    {
        for (GWTFriendlyWorkItem gwtfwi : wirs) {
            this.wirsMap.remove(gwtfwi.getWorkItemId());
        }
    }

    public void deleteWorkItems(GWTFriendlyWorkItem wir)
    {
        wirsMap.remove(wir.getWorkItemId());
    }
}
