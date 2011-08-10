package org.openxdata.mvac.mobile.view;

//~--- non-JDK imports --------------------------------------------------------

import org.openxdata.db.OpenXdataDataStorage;
import org.openxdata.model.FormData;
import org.openxdata.model.FormDef;
import org.openxdata.model.PageDef;
import org.openxdata.model.QuestionData;
import org.openxdata.model.QuestionDef;
import org.openxdata.model.StudyDef;
import org.openxdata.mvac.mobile.Factory;
import org.openxdata.mvac.mobile.db.WFStorage;
import org.openxdata.mvac.mobile.util.AlertMsgHelper;
import org.openxdata.util.AlertMessageListener;
import org.openxdata.workflow.mobile.model.MQuestionMap;
import org.openxdata.workflow.mobile.model.MWorkItem;

//~--- JDK imports ------------------------------------------------------------

import java.util.Vector;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

public class WIRView implements AlertMessageListener {
    private Display display;
    private List    listDisplay;
    private Vector  workItems;

    public WIRView() {
        initScreen();
    }

    public WIRView(Display display2) {
        this();
        this.display = display2;
    }

    private void initScreen() {
        listDisplay = new List("Available Appointments", List.IMPLICIT);
    }

    public void setWorkItems(Vector workItems) {
        if (workItems == null) {
            this.workItems = new Vector(0);
        } else {
            this.workItems = workItems;
        }

        refresh();
    }

    public Vector getWorkItems() {
        Vector workItemsCopy = new Vector();

        for (int i = 0; i < workItems.size(); i++) {
            workItemsCopy.addElement(workItems.elementAt(i));
        }

        return workItemsCopy;
    }

    ;
    private void refresh() {
        listDisplay.deleteAll();

        for (int i = 0; i < workItems.size(); i++) {
            MWorkItem wir          = (MWorkItem) workItems.elementAt(i);
            StudyDef  study        = OpenXdataDataStorage.getStudy(wir.getStudyId());
            FormDef   formDef      = study.getForm(wir.getFormId());
            FormData  data         = WFStorage.getOrCreateFormData(wir, formDef);
            String    answer       = null;
            String    formName     = data.getDef().getVariableName();
            Vector    prefilledQns = wir.getPrefilledQns();

            for (int k = 0; k < prefilledQns.size(); k++) {
                MQuestionMap qnMap        = (MQuestionMap) prefilledQns.elementAt(k);
                String       questionName = qnMap.getQuestion();
                if (questionName.equals("child_name")) {
                    answer = qnMap.getValue();
        
                }
            }

            try {
                listDisplay.append(answer, null);
            } catch (NullPointerException npe) {}
            ;
        }
    }

    public void showYourSelf() {
        display.setCurrent(listDisplay);
    }

    public Displayable getDisplayable() {
        return listDisplay;
    }

    public void addCommand(Command cmd) {
        listDisplay.addCommand(cmd);
    }

    public void setCommandListener(CommandListener l) {
        listDisplay.setCommandListener(l);
    }

    public MWorkItem getSelectedWorkItem() {
        int idx = listDisplay.getSelectedIndex();

        if (idx != -1) {
            return (MWorkItem) workItems.elementAt(idx);
        }

        return null;
    }

    public void onAlertMessage(byte msg) {
        try {
            display.setCurrent(listDisplay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showError(String string) {
        AlertMsgHelper.showError(display, listDisplay, string);
    }

    public void showMsg(String string) {
        AlertMsgHelper.showMsg(display, listDisplay, string);

//      Displayable disp = Factory.getmVACMainMenu().getDisplayable();
//      AlertMsgHelper.showMsg(display,disp, string);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
