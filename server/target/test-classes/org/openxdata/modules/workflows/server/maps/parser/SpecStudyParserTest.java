/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.maps.parser;

import org.w3c.dom.Node;
import java.util.List;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kay
 */
public class SpecStudyParserTest
{
    private static List<Node> mapNodes;

    public SpecStudyParserTest()
    {
    }

    @BeforeClass
    public static void beforeClass() throws IOException
    {
        mapNodes = MapsLoader.readMapsAsListNodes();
    }

    @Before
    public void setUp() throws IOException
    {
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of getSpecId method, of class SpecStudyParser.
     */
    @Test
    public void testGetSpecId()
    {
        System.out.println("getSpecId");
        SpecStudyParser instance = new SpecStudyParser(mapNodes.get(0));
        String expResult = "MalariaSurveyForOxd0.1";
        String result = instance.getSpecId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStudyId method, of class SpecStudyParser.
     */
    @Test
    public void testGetStudyId()
    {
        System.out.println("getStudyId");
        SpecStudyParser instance = new SpecStudyParser(mapNodes.get(0));
        String expResult = "New Study4";
        String result = instance.getStudyId();
        assertEquals(expResult, result);
    }
}
