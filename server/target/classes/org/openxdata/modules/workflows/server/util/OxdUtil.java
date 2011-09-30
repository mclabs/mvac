/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.util;

import com.jcraft.jzlib.JZlib;
import com.jcraft.jzlib.ZInputStream;
import com.jcraft.jzlib.ZOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jdom.JDOMException;

import org.openxdata.modules.workflows.model.shared.DBSpecification;
import org.openxdata.modules.workflows.model.shared.DBWorkitem;
import org.yawlfoundation.yawl.elements.YSpecification;
import org.yawlfoundation.yawl.engine.YSpecificationID;
import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;
import org.yawlfoundation.yawl.exceptions.YSchemaBuildingException;
import org.yawlfoundation.yawl.exceptions.YSyntaxException;
import org.yawlfoundation.yawl.unmarshal.YMarshal;

/**
/**
 *
 * @author kay
 */
public class OxdUtil
{
    public static ConcurrentHashMap<String, YSpecification> specMap = new ConcurrentHashMap<String, YSpecification>();

    public static DBWorkitem fromWorkItemRecordToDBWorkItem(WorkItemRecord wir)
    {
        String wirXml = wir.toXML();
        return new DBWorkitem(wir.getID(), wirXml, wir.getStatus());
    }

    public static DBSpecification fromSpecificationToBSpecification(
            YSpecification ys)
    {
        String specXML = ys.toXML();
        YSpecificationID specId = ys.getSpecificationID();
        String specName = specId.getSpecName();
        String version = specId.getVersionAsString();
        return new DBSpecification(specName ,version, specXML);
    }

    public static YSpecification fromDBSpecToYSpec(
            DBSpecification dBSpecification)
            throws YSyntaxException, YSchemaBuildingException, JDOMException, IOException
    {
        YSpecification yspec = specMap.get(dBSpecification.getXml());
        if(yspec == null){
        List<YSpecification> ySpecs =
                YMarshal.unmarshalSpecifications("<specificationSet xmlns=\"http://www.yawlfoundation.org/yawlschema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"2.0\" xsi:schemaLocation=\"http://www.yawlfoundation.org/yawlschema http://www.yawlfoundation.org/yawlschema/YAWL_Schema2.0.xsd\">"
                + dBSpecification.getXml()
                + "</specificationSet>", false);
        yspec = ySpecs.get(0);
        specMap.put(dBSpecification.getXml(), yspec);
        }
        return yspec;
    }

    public static DataInputStream getCompressedInputStream(InputStream is)
    {
        if (is instanceof ZInputStream)
            return new DataInputStream(is);
        else
            return new DataInputStream(new ZInputStream(is));
    }

    public static DataOutputStream getCompressedOutputStream(OutputStream os)
    {
        if (os instanceof ZOutputStream)
            return new DataOutputStream(os);
        else
            return new DataOutputStream(new ZOutputStream(os,JZlib.Z_BEST_COMPRESSION ));
    }
}
