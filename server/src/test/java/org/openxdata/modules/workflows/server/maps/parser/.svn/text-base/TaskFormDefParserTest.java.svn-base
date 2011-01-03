/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.maps.parser;

import org.junit.Before;
import org.junit.Test;
import org.openxdata.server.util.XmlUtil;
import static org.junit.Assert.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author kay
 */
public class TaskFormDefParserTest
{
    private String xml = " <TaskFormDef TaskId='Weight_5' FormId='0'>"
            + "                <TaskFormVersionMaps>"
            + "                    <TaskFormVersion TaskId='Weight_5' FormVersionId='0'>"
            + "                        <ParamQuestionMaps />"
            + "                    </TaskFormVersion>"
            + "                </TaskFormVersionMaps>"
            + "            </TaskFormDef>";
    private Node doc;

    public TaskFormDefParserTest()
    {
    }

    @Before
    public void setUp()
    {
        Document fromString2Doc = XmlUtil.fromString2Doc(xml);
      //  doc = fromString2Doc.getElementsByTagName("TaskFormDef").item(0);
        doc = fromString2Doc.getFirstChild();
    }

    /**
     * Test of getTaskId method, of class TaskFormDefParser.
     */
    @Test
    public void testGetTaskId()
    {
        System.out.println("getTaskId");
        TaskFormDefParser instance = new TaskFormDefParser((Element) doc);
        String expResult = "Weight_5";
        String result = instance.getTaskId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormId method, of class TaskFormDefParser.
     */
    @Test
    public void testGetFormId()
    {
        System.out.println("getFormId");
        TaskFormDefParser instance = new TaskFormDefParser((Element) doc);
        String expResult = "0";
        String result = instance.getFormId();
        assertEquals(expResult, result);
    }
}
