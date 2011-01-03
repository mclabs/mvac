/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.maps.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.openxdata.server.util.XmlUtil;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author kay
 */
public class MapsLoader
{
    public static String readMapResources() throws IOException
    {
        InputStream is = MapsLoader.class.getResourceAsStream("/org/openxdata/modules/workflows/resources/Map1.xml");
        return IOUtils.toString(is);
    }

    public static List<Node> readMapsAsListNodes() throws IOException
    {
        String map = readMapResources();
        org.w3c.dom.Document doc = XmlUtil.fromString2Doc(map);
        NodeList elementsByTagName = doc.getElementsByTagName("SpecStudyMap");
        List<Node> nodes = new ArrayList<Node>();

        for (int i = 0; i < elementsByTagName.getLength(); i++)
            nodes.add(elementsByTagName.item(i));
        return nodes;

    }
}
