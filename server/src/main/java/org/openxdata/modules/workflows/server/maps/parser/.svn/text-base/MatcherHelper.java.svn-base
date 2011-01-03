/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.maps.parser;

import java.util.HashMap;

/**
 *
 * @author kay
 */
public class MatcherHelper
{
    private static HashMap<String, SpecStudyParser> parserCache = new HashMap<String, SpecStudyParser>();

    public static String getFormIdForTask(String taskd, String mapXML)
    {
        SpecStudyParser specStudyP = createSpecStudyParser(mapXML);
        return specStudyP.getFormIdForTask(taskd);
    }

    public static String getQuestionText(String taskId, String formVId, String parameter, String mapXml)
    {
        SpecStudyParser parser = createSpecStudyParser(mapXml);
        return parser.getQuestionText(taskId, formVId, parameter);
    }

    public static synchronized SpecStudyParser createSpecStudyParser(String mapXML)
    {

        SpecStudyParser specStudyP = parserCache.get(mapXML);
        if (specStudyP == null) {
            specStudyP = new SpecStudyParser(mapXML);
            parserCache.put(mapXML, specStudyP);
        }
        return specStudyP;
    }
}
