package org.openxdata.modules.workflows.server.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class JJ
{
    public static String prettyFormat(String input, int indent)
    {
	try {
	    Source xmlInput = new StreamSource(new StringReader(input));
	    StringWriter stringWriter = new StringWriter();
	    StreamResult xmlOutput = new StreamResult(stringWriter);

	    Transformer transformer = TransformerFactory.newInstance()
		    .newTransformer();

	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	    transformer.setOutputProperty(
		    "{http://xml.apache.org/xslt}indent-amount", String
			    .valueOf(indent));

	    transformer.transform(xmlInput, xmlOutput);

	    return xmlOutput.getWriter().toString();
	} catch (Exception e) {
	    throw new RuntimeException(e); // simple exception handling, please
	    // review it
	}
    }

    public static String prettyFormat(String input)
    {
	return prettyFormat(input, 2);
    }

    public static void main(String[] args)
    {
	String prettyFormat = prettyFormat("<Maps><SpecStudyMap SpecId='MalariaSurveyForOxd-OXD-CustomService0.3' StudyId='Sample Study'><TaskFormMaps><TaskFormDef TaskId='Patient_3' FormId='1'><TaskFormVersionMaps><TaskFormVersion TaskId='Patient_3' FormVersionId='1'><ParamQuestionMaps><ParamQuestion Question='lastname' Parameter='name'/><ParamQuestion Question='title' Parameter='hasMalaria'/></ParamQuestionMaps></TaskFormVersion></TaskFormVersionMaps></TaskFormDef><TaskFormDef TaskId='Malaria_4' FormId='1'><TaskFormVersionMaps><TaskFormVersion TaskId='Malaria_4' FormVersionId='1'><ParamQuestionMaps/></TaskFormVersion></TaskFormVersionMaps></TaskFormDef></TaskFormMaps></SpecStudyMap></Maps>");
	System.out.println(prettyFormat);
    }

}
