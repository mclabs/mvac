
package org.openxdata.workflow.mobile.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.openxdata.db.util.Persistent;
import org.openxdata.db.util.PersistentHelper;

/**
 *
 * @author kay
 */
public class WFRequest implements Persistent
{
    public String userName;
    public String password;
    public String action;
    public String serializer;
//    private String nurseName;
//    private String downLoadDate;

    public WFRequest()
    {
    }

//    public String getDownLoadDate() {
//        return downLoadDate;
//    }



//    public void setDownLoadDate(String downLoadDate) {
//        this.downLoadDate = downLoadDate;
//    }
//
//    public String getNurseName() {
//        return nurseName;
//    }
//
//    public void setNurseName(String nurseName) {
//        this.nurseName = nurseName;
//    }



    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public WFRequest(String userName, String password, String action)
    {
        this.userName = userName;
        this.password = password;
//        this.nurseName = nurseName;
//        this.downLoadDate = downloadDate;
        this.action = action;
    }

    public String getSerializer()
    {
        return serializer;
    }

    public void setSerializer(String serializer)
    {
        this.serializer = serializer;
    }

    public void write(DataOutputStream dos) throws IOException
    {
        dos.writeUTF(userName);
        dos.writeUTF(password);
//        dos.writeUTF(nurseName);
//        dos.writeUTF(downLoadDate);
        dos.writeUTF(action);
        PersistentHelper.writeUTF(dos, serializer);
    }

    public void read(DataInputStream dis) throws IOException, InstantiationException, IllegalAccessException
    {
        userName = dis.readUTF();
        password = dis.readUTF();
//        nurseName = dis.readUTF();
//        downLoadDate = dis.readUTF();
        action = dis.readUTF();
        serializer = PersistentHelper.readUTF(dis);
    }
}
