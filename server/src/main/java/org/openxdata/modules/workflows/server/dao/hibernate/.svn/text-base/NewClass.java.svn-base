package org.openxdata.modules.workflows.server.dao.hibernate;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kay
 */
public class NewClass
{
    public static void main(String[] args)
    {
        String xmlMap = "<SpecStudyMap Id='0' StudyId='New Study2'><TaskFormMaps><TaskFormDef TaskId='Patient_3' FormId='2'><TaskFormVersionMaps></TaskFormVersionMaps></TaskFormDef></TaskFormMaps></SpecStudyMap>";
        String replaceIdIfZero = replaceIdIfZero(6, xmlMap);

        System.out.print(replaceIdIfZero);

        sin((Serializable) "djusjjjds");

    }

    public static String replaceIdIfZero(int id, String xmlMap)
    {
        int startTag = xmlMap.indexOf("<SpecStudyMap");
        int closeTag = xmlMap.indexOf(">", startTag);

        String mapTag = xmlMap.substring(startTag, closeTag);

        String regex = "Id[\\s]*=[\\s]*[\"|\']0[\"|\']";
        Matcher matcher = Pattern.compile(regex).matcher(mapTag);
        if (matcher.find()) {
            String idAttrib = matcher.group(0);
            String newMapTag = mapTag.replace(idAttrib, "Id='" + 5 + "'");
            String newXmlMap = xmlMap.replace(mapTag, newMapTag);
            return newXmlMap;
        }
        return xmlMap;
    }

    static void sin(Serializable s)
    {
        System.out.println("Serializable");
    }

    static void sin(String s)
    {
        System.out.println("String");
    }
}
