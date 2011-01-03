/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.model.shared.dto;

import java.io.Serializable;
import org.openxdata.modules.workflows.model.shared.OSpecification;
import org.openxdata.server.admin.model.StudyDef;

/**
 * Data transfer object for transfering an xml map along with the study and  Spec
 * since the  class spec study map cannot be transfering directly through RPC
 * @author kay
 */
public class SpecStudyMapDTO implements Serializable
{

    private StudyDef studyDef;
    private OSpecification oSpecification;
    private String xmlMap;
    private int studyId;
    private String specId;
    private int id;

    public SpecStudyMapDTO()
    {
    }

    public SpecStudyMapDTO(StudyDef studyDef, OSpecification oSpecification,
                           String xmlMap)
    {
        this.studyDef = studyDef;
        this.oSpecification = oSpecification;
        this.xmlMap = xmlMap;
    }

    public OSpecification getoSpecification()
    {
        return oSpecification;
    }

    public void setoSpecification(OSpecification oSpecification)
    {
        this.oSpecification = oSpecification;
    }

    public StudyDef getStudyDef()
    {
        return studyDef;
    }

    public void setStudyDef(StudyDef studyDef)
    {
        this.studyDef = studyDef;
    }

    public String getXmlMap()
    {
        return xmlMap;
    }

    public void setXmlMap(String xmlMap)
    {
        this.xmlMap = xmlMap;
    }

    public String getSpecId()
    {
        return specId;
    }

    public void setSpecId(String specId)
    {
        this.specId = specId;
    }

    public int getStudyId()
    {
        return studyId;
    }

    public void setStudyId(int studyId)
    {
        this.studyId = studyId;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
