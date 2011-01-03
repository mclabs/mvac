
package org.openxdata.modules.workflows.server.maps.parser;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kay
 */
public class MatcherHelperTest {

    private String mapXML = "<SpecStudyMap Id='0' SpecId='MalariaSurveyForOxd-OXD-CustomService0.3' StudyId='Sample Study'>"
            + "    <TaskFormMaps>"
            + "        <TaskFormDef TaskId='Malaria_4' FormId='1'>"
            + "            <TaskFormVersionMaps>"
            + "                <TaskFormVersion TaskId='Malaria_4' FormVersionId='2'>"
            + "                    <ParamQuestionMaps>"
            + "                        <ParamQuestion Question='title' Parameter='malariaType'/>"
            + "                        <ParamQuestion Question='lastname' Parameter='weight'/>"
            + "                    </ParamQuestionMaps>"
            + "                </TaskFormVersion>"
            + "            </TaskFormVersionMaps>"
            + "        </TaskFormDef>"
            + "    </TaskFormMaps>"
            + "</SpecStudyMap>";

    public MatcherHelperTest() {
    }

    @Test
    public void testGetFormIdForTask()
    {
        System.out.println("getFormIdForTask");
        String taskd = "Malaria_4";
        String expResult = "1";
        String result = MatcherHelper.getFormIdForTask(taskd, mapXML);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetQuestionForParam(){
        System.out.print("Testing getQuestionText");
        String taskId =  "Malaria_4";
        String formId = "2";
        String param = "malariaType";
        String matchedQuestion = "title";

        String result = MatcherHelper.getQuestionText(taskId, formId, param, mapXML);
        assertEquals(matchedQuestion, result);

    }

}