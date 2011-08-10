/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.api;

import org.openxdata.model.QuestionData;
import org.openxdata.mvac.mobile.util.view.api.IView;
import org.openxdata.mvac.mobile.view.TextQuestionView;

/**
 *
 * @author soyfactor
 */
public class ViewFactory {

    public IView getView(QuestionData qtnData,byte type){
        IView view=null;
        switch(type){
            case 1:
                view = new TextQuestionView(qtnData);
                break;
            default:
                view = new TextQuestionView(qtnData);
                break;



        }
        return view;
        
    }

}
