
package org.openxdata.workflow.mobile.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;
import org.openxdata.db.util.Persistent;
import org.openxdata.db.util.PersistentHelper;

/**
 *
 * @author kay
 */
public class MWorkItemDataList implements Persistent
{
    private Vector dataList;

    public MWorkItemDataList()
    {
        dataList = new Vector(2);
    }

    public MWorkItemDataList(Vector dataList)
    {
        this.dataList = dataList;
    }

    public void write(DataOutputStream dos) throws IOException
    {
        PersistentHelper.write(dataList, dos);
    }

    public void read(DataInputStream dis) throws IOException, InstantiationException, IllegalAccessException
    {
        dataList = PersistentHelper.read(dis, new MWorkItemData().getClass());
    }

    /**
     * Returns vector of MWorkItemData in a vector
     * @return Vector of @link MWorkItemData
     */
    public Vector getDataList()
    {
        return dataList;
    }

    public void setDataList(Vector dataList)
    {
        this.dataList = dataList;
    }

    public synchronized void addWorkItemData(MWorkItemData data)
    {
        dataList.addElement(data);
    }
}
