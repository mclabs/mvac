/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.client.util;

import com.google.gwt.user.client.Random;
import java.util.ArrayList;
import java.util.List;
import org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem;

/**
 * Simply used for testing purposes to generate random workitem objects
 * @author kay
 */
public class RandomWIR
{
    public static List<GWTFriendlyWorkItem> genRandomWIRs(int number)
    {
        RandomString str = new RandomString(10);
        List<GWTFriendlyWorkItem> wirs = new ArrayList<GWTFriendlyWorkItem>();
        for (int i = 0; i < number; i++) {
            GWTFriendlyWorkItem wir = new GWTFriendlyWorkItem(Random.nextInt() % 100 + ":" + str.nextString());
            wir.setEnabledTime(Random.nextInt() % 100 + ":" + Random.nextInt() % 100 + ":" + Random.nextInt() % 100 + ":");
            wir.setState(str.nextString());
            wirs.add(wir);
        }
        return wirs;
    }
}
