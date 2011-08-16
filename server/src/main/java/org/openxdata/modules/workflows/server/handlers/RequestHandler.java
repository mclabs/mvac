/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import org.openxdata.server.admin.model.User;

/**
 * Handle all stream requests from the mobile client.The implemetation of this class
 * will have to know how to read the data and send the send the required reply;
 * @author kay
 */
public interface RequestHandler
{
    /**
     * Processes the request and and builds the necessary reply
     * @param user User who sent request
     * @param is Input stream from the requester
     * @param os Output stream for the requester.
     * @throws IOException
     */
    public void handleRequest(User user, InputStream is, OutputStream os,Hashtable args) throws IOException;
}
