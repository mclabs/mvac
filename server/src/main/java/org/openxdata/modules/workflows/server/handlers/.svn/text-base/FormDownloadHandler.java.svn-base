/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.handlers;

import com.jcraft.jzlib.JZlib;
import com.jcraft.jzlib.ZOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.openxdata.db.util.PersistentHelper;
import org.openxdata.model.ResponseHeader;
import org.openxdata.modules.workflows.server.context.WFContext;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.service.FormDownloadService;

/**
 *
 * @author kay
 */
public class FormDownloadHandler implements RequestHandler
{
    FormDownloadService formDownloadService;

    public FormDownloadHandler()
    {
        formDownloadService = WFContext.getFormDownloadService();
    }

    @Override
    public void handleRequest(User user,InputStream is, OutputStream os) throws IOException
    {
        String serName = PersistentHelper.readUTF(new DataInputStream(is));
        ZOutputStream zos = new ZOutputStream(os, JZlib.Z_BEST_COMPRESSION);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        formDownloadService.downloadUsers(baos,serName);
        formDownloadService.downloadAllForms(baos,serName,"en");
        zos.write(ResponseHeader.STATUS_SUCCESS);
        zos.write(baos.toByteArray());
        zos.flush();
        zos.finish();
    }
}
