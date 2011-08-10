/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.util.view.dialogs;

import com.sun.lwuit.Dialog;
import com.sun.lwuit.Label;
import com.sun.lwuit.layouts.BorderLayout;
import java.util.Hashtable;
import org.openxdata.mvac.mobile.util.view.api.IDialog;
import org.openxdata.mvac.mobile.util.view.api.IDialogListener;

/**
 *
 * @author soyfactor
 */
public class InfoDialog extends Dialog implements IDialog {
    private Label lbl;
    private String text;
    private String title;
    private int type;
    private IDialogListener listener;
    

    public InfoDialog(String title,String text,int type) {
        super();
        this.title = title;
        this.type =type;
        this.text=text;
        initView();
    }



    public void setParent(IDialogListener listener) {
        this.listener = listener;
    }

    public Object getScreenObject() {
        return this;
    }

    public void resume(Hashtable args) {
    }

    

    private void initView() {
        setDialogType(type);
        setLayout(new BorderLayout());
        lbl = new Label(this.text);
        
    }

    public void show() {
        super.show(this.title, this.lbl, null);
    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
    }

 
}
