/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.events.DataChangedListener;
import com.sun.lwuit.events.SelectionListener;
import com.sun.lwuit.list.ListModel;

/**
 *
 * @author soyfactor
 */
public class QuestionListModel implements ListModel {
    private DataChangedListener dl;
    private Object[] objs;
    private int selected;

    public QuestionListModel(Object[] obj){
        this.objs = obj;

    }

    public Object getItemAt(int i) {
        return objs[i];
    }

    public int getSize() {
        return objs.length;
    }

    public int getSelectedIndex() {
        return selected;
    }

    public void setSelectedIndex(int i) {
        selected=i;
    }

    public void addDataChangedListener(DataChangedListener dl) {
        this.dl = dl;
    }

    public void removeDataChangedListener(DataChangedListener dl) {
        this.dl = null;
    }

    public void addSelectionListener(SelectionListener sl) {
    }

    public void removeSelectionListener(SelectionListener sl) {
    }

    public void addItem(Object o) {
        if(o!=null){
            Object[] newObjs = new Object[objs.length+1];
            for (int i = 0; i < objs.length; i++) {
                newObjs[i]=objs[i];
            }
            newObjs[objs.length]=o;

            objs=newObjs;
            dl.dataChanged(DataChangedListener.CHANGED, -1);
        }

    }

    public void removeItem(int i) {
        if(!(i>=objs.length||i<0)){
            Object[] newObjs = new Object[objs.length-1];
            for (int k = 0; k < objs.length-1; k++) {
                newObjs[i]=objs[i];
            }
            objs=newObjs;
            dl.dataChanged(DataChangedListener.CHANGED, -1);

        }
    }


    

}
