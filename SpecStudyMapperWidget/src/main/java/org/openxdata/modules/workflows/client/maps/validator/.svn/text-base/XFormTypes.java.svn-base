/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.modules.workflows.client.maps.validator;

import java.util.HashMap;
import org.purc.purcforms.client.model.QuestionDef;


/**
 *
 * @author kay
 */
public class XFormTypes {

    private final  static HashMap  typeMap = new HashMap();

    static {
        
        typeMap.put(QuestionDef.QTN_TYPE_BOOLEAN, "Boolean");
        typeMap.put(QuestionDef.QTN_TYPE_DATE, "Date");
        typeMap.put(QuestionDef.QTN_TYPE_DATE_TIME, "DateTime");
        typeMap.put(QuestionDef.QTN_TYPE_DECIMAL, "Decimal");
        typeMap.put(QuestionDef.QTN_TYPE_GPS, "GPS");
        typeMap.put(QuestionDef.QTN_TYPE_IMAGE, "Image");
        typeMap.put(QuestionDef.QTN_TYPE_LIST_EXCLUSIVE, "Single Select");
        typeMap.put(QuestionDef.QTN_TYPE_LIST_EXCLUSIVE_DYNAMIC, "Dynamic List");
        typeMap.put(QuestionDef.QTN_TYPE_LIST_MULTIPLE, "Multiple Select");
        typeMap.put(QuestionDef.QTN_TYPE_NUMERIC, "Numeric");
        typeMap.put(QuestionDef.QTN_TYPE_REPEAT, "Repeat");
        typeMap.put(QuestionDef.QTN_TYPE_TEXT, "Text");
        typeMap.put(QuestionDef.QTN_TYPE_TIME, "Time");
        typeMap.put((int)QuestionDef.QTN_TYPE_VIDEO, "Video");
        typeMap.put((int)QuestionDef.QTN_TYPE_AUDIO, "Audio");
    }

    public static  String toText(int idx){
        return (String) typeMap.get(idx);
    }

}
