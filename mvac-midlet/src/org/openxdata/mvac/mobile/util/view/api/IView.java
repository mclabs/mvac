/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.util.view.api;

import com.sun.lwuit.Dialog;
import java.util.Hashtable;

/**
 *
 * @author soyfactor
 */
public interface IView {

    public Object getScreenObject();

    public void dialogReturned(Dialog dialog,boolean yesNo);

    public void resume(Hashtable args);

}
