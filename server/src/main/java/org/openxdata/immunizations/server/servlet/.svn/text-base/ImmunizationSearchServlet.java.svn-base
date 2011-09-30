/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.immunizations.server.servlet;

import com.google.inject.Singleton;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openxdata.modules.workflows.server.context.WFContext;
import org.openxdata.modules.workflows.server.handlers.AccessDeniedHandler;
import org.openxdata.modules.workflows.server.handlers.ErrorWhileProcessHandler;
import org.openxdata.modules.workflows.server.handlers.ProcessorCreator;
import org.openxdata.modules.workflows.server.handlers.RequestHandler;
import org.openxdata.modules.workflows.server.service.LaunchCaseService;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.service.AuthenticationService;
import org.yawlfoundation.yawl.engine.YSpecificationID;

/**
 *
 * @author soyfactor
 */
@Singleton
public class ImmunizationSearchServlet extends HttpServlet{
    private ProcessorCreator processorCreator;
    private AuthenticationService authSrv;
    
    private class RequestParams
    {
        private User user;
        private String type;
    }
    
    @Override
    public void init() throws ServletException {
        processorCreator = WFContext.getProcessorCreator();
        authSrv = (AuthenticationService) org.openxdata.server.Context.getBean("authenticationService");

    }
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //do Nothing
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Do post");
        try {
            RequestParams params = readType(req, resp);
            RequestHandler reqHandler = processorCreator.buildRequestHandler(params.type);
            ByteArrayOutputStream tempOS = new ByteArrayOutputStream();
            reqHandler.handleRequest(params.user, req.getInputStream(), tempOS);
            resp.getOutputStream().write(tempOS.toByteArray());
            resp.getOutputStream().flush();
        } catch (Exception ex) {
            ex.printStackTrace();
            new ErrorWhileProcessHandler(ex).handleRequest(null, null, resp.getOutputStream());
        }

        

    }



    private RequestParams readType(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        RequestParams params = new RequestParams();
        DataInputStream dis = new DataInputStream(req.getInputStream());
        User user = authenticatedBinaryStream(dis);
        if (user != null) {
            params.user = user;
            params.type = dis.readUTF();
        } else {
            params.type = AccessDeniedHandler.class.getName();
        }
        return params;
    }

    private User authenticatedBinaryStream(DataInputStream dis) throws IOException
    {
        String userName = dis.readUTF();
        String password = dis.readUTF();
        User user = authSrv.authenticate(userName, password);
        return user;
    }




    

}
