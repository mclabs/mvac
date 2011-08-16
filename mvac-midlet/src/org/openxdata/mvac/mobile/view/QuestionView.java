/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BoxLayout;
import java.util.Hashtable;
import org.openxdata.model.QuestionData;
import org.openxdata.mvac.mobile.api.MvacController;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.Constants;
import org.openxdata.mvac.mobile.util.view.api.IView;

/**
 *
 * @author soyfactor
 */
public abstract class QuestionView extends Form   implements IView,ActionListener {
    protected  QuestionData questionObj;
    private MvacController contoller;
    protected Container queContainer;
    protected Command next;
    protected Command prev;
    protected Command done;
    protected Command back;

    public QuestionView(QuestionData questionObj){
        this.questionObj=questionObj;
        this.contoller = (MvacController)AppUtil.get().getItem(Constants.CONTROLLER);
        queContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        next = new Command("Next", 1);
        prev = new Command("Previous", 2);
        done = new Command("Done", 3);
        back = new Command("Back", 4);
        initView();

    }

    public abstract void initView();



    public Object getScreenObject() {
        return this;
    }

    public void resume(Hashtable args) {
        AppUtil.get().setView(this);

    }

    protected void saveQuestionData(QuestionData qtnData){
        //save before proceedint
        contoller.saveQtnData(qtnData);

    }

}
