package org.openxdata.modules.workflows.server.maps.parser;

import org.w3c.dom.Element;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import org.w3c.dom.Node;
import static org.junit.Assert.*;

/**
 *
 * <SpecStudyMap SpecId='MalariaSurveyForOxd0.1' StudyId='New Study4'>
        <TaskFormMaps>
            <TaskFormDef TaskId='Malaria_4' FormId='0'>
                <TaskFormVersionMaps>
                    <TaskFormVersion TaskId='Malaria_4' FormVersionId='0'>
                        <ParamQuestionMaps />
                    </TaskFormVersion>
                </TaskFormVersionMaps>
            </TaskFormDef>
            <TaskFormDef TaskId='Patient_3' FormId='0'>
                <TaskFormVersionMaps>
                    <TaskFormVersion TaskId='Patient_3' FormVersionId='0'>
                        <ParamQuestionMaps>
                            <ParamQuestion Question='question10' Parameter='name' />
                        </ParamQuestionMaps>
                    </TaskFormVersion>
                </TaskFormVersionMaps>
            </TaskFormDef>
        </TaskFormMaps>
    </SpecStudyMap>
 * @author kay
 */
public class OverAllMapsTest
{
    @Test
    public void testOverAllMapps() throws IOException
    {
        List<Node> mapNodes = MapsLoader.readMapsAsListNodes();
        assertEquals(3, mapNodes.size());

        for (Node node : mapNodes) {
            Element elem = (Element) node;
            if (elem.getAttribute("SpecId").equals("MalariaSurveyForOxd0.1")) {
                SpecStudyParser specStudyParser = new SpecStudyParser(node);
                testNumberOfTaskFormParser(specStudyParser);
            }
        }

    }

    public void testNumberOfTaskFormParser(SpecStudyParser specStudyParser)
    {
        List<TaskFormDefParser> taskFormDefParsers = specStudyParser.getTaskFormDefParsers();
        int numTaskFormParser = taskFormDefParsers.size();
        assertEquals(2, numTaskFormParser);

        List<TaskFormVersionParser> taskFormVParsers = taskFormDefParsers.get(0).getTaskFormVParsers();
        int taskFormVSize = taskFormVParsers.size();
        assertEquals(1, taskFormVSize);
        List<ParamQuestionParser> paramQuestionParsers = taskFormVParsers.get(0).getParamQuestionParsers();
        assertEquals(0, paramQuestionParsers.size());


        List<TaskFormVersionParser> taskFormVParsers2 = taskFormDefParsers.get(1).getTaskFormVParsers();
        int taskFormVSize2 = taskFormVParsers2.size();
        assertEquals(1, taskFormVSize2);
        List<ParamQuestionParser> paramQuestionParsers2 = taskFormVParsers2.get(0).getParamQuestionParsers();
        assertEquals(1, paramQuestionParsers2.size());
    }
}
