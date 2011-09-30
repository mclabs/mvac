package org.openxdata.modules.workflows.client.util;

import org.openxdata.server.admin.model.Editable;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.FormDefVersion;
import org.openxdata.server.admin.model.FormDefVersionText;
import org.openxdata.server.admin.model.StudyDef;
import org.purc.purcforms.client.xforms.XmlUtil;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

/**
 * This is a utility for importing studies, forms and form versions from
 * xml files.
 * 
 * @author daniel
 *
 */
public class StudyImport
{

    /**
     * Imports a study, form, or form version from xml.
     *
     * @param xml the xml text.
     * @return study, form or form version, depending on what is in the xml text.
     */
    /**
     * @param xml
     * @return
     */
    public static Editable importStudyItem(String xml)
    {
        if (xml == null || xml.trim().length() == 0)
            return null;

        Editable editable = null;

        StudyDef studyDef = null;
        FormDef formDef = null;
        FormDefVersion formDefVersion = null;

        Document doc = null;

        try {
            doc = XMLParser.parse(xml);
        } catch (Exception ex) {
            return null;
        }

        Element root = doc.getDocumentElement();
        if (root != null) {
            String name = root.getAttribute("name");
            String description = root.getAttribute("description");

            if (name == null || name.trim().length() == 0)
                return null;

            if (root.getNodeName().equalsIgnoreCase("study")) {
                studyDef = new StudyDef(0, name, description);
                editable = studyDef;
            } else if (root.getNodeName().equalsIgnoreCase("form")) {
                formDef = new FormDef(0, name, description, studyDef);
                editable = formDef;
            } else if (root.getNodeName().equalsIgnoreCase("version")) {
                formDefVersion = new FormDefVersion(0, name, description, formDef);
                editable = formDefVersion;
            }

            NodeList formNodes = root.getChildNodes();
            for (int index = 0; index < formNodes.getLength(); index++) {
                Node node = formNodes.item(index);
                if (node.getNodeType() != Node.ELEMENT_NODE)
                    continue;
                if (node.getNodeName().equalsIgnoreCase("form"))
                    importForm(studyDef, (Element) node);
                else if (node.getNodeName().equalsIgnoreCase("version"))
                    importFormVersion(formDef, (Element) node);
                else if (node.getNodeName().equalsIgnoreCase("versionText"))
                    importFormVersionText(formDefVersion, (Element) node);
                else if (node.getNodeName().equalsIgnoreCase("xform"))
                    formDefVersion.setXform(XmlUtil.getTextValue((Element) node));
                else if (node.getNodeName().equalsIgnoreCase("layout"))
                    formDefVersion.setLayout(XmlUtil.getTextValue((Element) node));
            }
        }

        return editable;
    }

    /**
     * Imports a form definition from an xml node and adds it to a study definition object.
     *
     * @param studyDef the study definition object.
     * @param formNode the xml node containing the form definition.
     */
    private static void importForm(StudyDef studyDef, Element formNode)
    {
        FormDef formDef = new FormDef(0, formNode.getAttribute("name"), formNode.getAttribute("description"), studyDef);
        studyDef.addForm(formDef);

        NodeList versionNodes = formNode.getChildNodes();
        for (int index = 0; index < versionNodes.getLength(); index++) {
            Node node = versionNodes.item(index);
            if (node.getNodeType() != Node.ELEMENT_NODE)
                continue;
            else if (node.getNodeName().equalsIgnoreCase("version"))
                importFormVersion(formDef, (Element) node);
        }
    }

    /**
     * Imports a form version from an xml node and adds it to a form definition object.
     *
     * @param formDef the form definition object.
     * @param versionNode the xml node containing the form version.
     */
    private static void importFormVersion(FormDef formDef, Element versionNode)
    {
        FormDefVersion formDefVersion = new FormDefVersion(0, versionNode.getAttribute("name"), versionNode.getAttribute("description"), formDef);
        formDef.addVersion(formDefVersion);

        NodeList versionTextNodes = versionNode.getChildNodes();
        for (int index = 0; index < versionTextNodes.getLength(); index++) {
            Node node = versionTextNodes.item(index);
            if (node.getNodeType() != Node.ELEMENT_NODE)
                continue;
            else if (node.getNodeName().equalsIgnoreCase("xform"))
                formDefVersion.setXform(XmlUtil.getTextValue((Element) node));
            else if (node.getNodeName().equalsIgnoreCase("layout"))
                formDefVersion.setLayout(XmlUtil.getTextValue((Element) node));
            else if (node.getNodeName().equalsIgnoreCase("versionText"))
                importFormVersionText(formDefVersion, (Element) node);
        }
    }

    /**
     * Imports form version text from an xml node and adds it to a form version object.
     *
     * @param formDefVersion the form version object.
     * @param versionTextNode the xml node containing form version text.
     */
    private static void importFormVersionText(FormDefVersion formDefVersion, Element versionTextNode)
    {
        FormDefVersionText formDefVersionText = new FormDefVersionText();
        formDefVersionText.setFormDefVersionId(0);
        formDefVersion.addVersionText(formDefVersionText);

        formDefVersionText.setLocaleKey(versionTextNode.getAttribute("locale"));

        NodeList nodes = versionTextNode.getChildNodes();
        for (int index = 0; index < nodes.getLength(); index++) {
            Node node = nodes.item(index);
            if (node.getNodeType() != Node.ELEMENT_NODE)
                continue;
            if (node.getNodeName().equalsIgnoreCase("xform"))
                formDefVersionText.setXformText(XmlUtil.getTextValue((Element) node));
            else if (node.getNodeName().equalsIgnoreCase("layout"))
                formDefVersionText.setLayoutText(XmlUtil.getTextValue((Element) node));
        }
    }
}
