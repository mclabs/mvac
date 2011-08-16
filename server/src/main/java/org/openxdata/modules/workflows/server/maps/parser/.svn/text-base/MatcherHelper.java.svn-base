package org.openxdata.modules.workflows.server.maps.parser;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author kay
 */
public class MatcherHelper
{

        private static ConcurrentHashMap<String, SpecStudyParser> parserCache = new ConcurrentHashMap<String, SpecStudyParser>();

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

        public static SpecStudyParser createSpecStudyParser(String mapXML)
        {
                SpecStudyParser specStudyP = parserCache.get(mapXML);
                if (specStudyP == null) {
                        specStudyP = new SpecStudyParser(mapXML);
                        parserCache.put(mapXML, specStudyP);
                }
                return specStudyP;
        }
}
