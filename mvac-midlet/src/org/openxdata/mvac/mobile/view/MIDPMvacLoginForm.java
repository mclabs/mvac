/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Dialog;
import java.util.Hashtable;
import javax.microedition.lcdui.Form;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.view.api.IView;

/**
 *
 * @author soyfactor
 */
public class MIDPMvacLoginForm extends Form implements IView{

    public MIDPMvacLoginForm(String label) {
        super(label);
        initView();
    }



    //return this object for display
    public Object getScreenObject() {
        return this;
    }

    private void initView() {
        this.append("Hello World");
    }

    public void resume(Hashtable args) {
        //process args
        //set next displayable
        AppUtil.get().setView(this);
    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
    }

}
