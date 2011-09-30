/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.servlet;

import com.google.inject.Singleton;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openxdata.modules.workflows.server.context.WFContext;
import org.openxdata.modules.workflows.server.handlers.AccessDeniedHandler;
import org.openxdata.modules.workflows.server.handlers.ErrorWhileProcessHandler;
import org.openxdata.modules.workflows.server.handlers.ProcessorCreator;
import org.openxdata.modules.workflows.server.handlers.RequestHandler;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.service.AuthenticationService;

/**
 *
 * @author kay
 */
@Singleton
public class WorkItemsServlet extends HttpServlet
{

        private class RequestParams
        {
                private User user;
                private String type;
        }
        private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());
        private ProcessorCreator processorCreator;
        private AuthenticationService authSrv;

        @Override
        public void init() throws ServletException
        {
                super.init();
                processorCreator = WFContext.getProcessorCreator();
                authSrv = (AuthenticationService) org.openxdata.server.Context.getBean("authenticationService");

        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
                try {
                        RequestParams params = readType(req, resp);
                        RequestHandler reqHandler = processorCreator.buildRequestHandler(params.type);
                        ByteArrayOutputStream tempOS = new ByteArrayOutputStream();
                        reqHandler.handleRequest(params.user, req.getInputStream(), tempOS);
                        resp.getOutputStream().write(tempOS.toByteArray());
                        resp.getOutputStream().flush();
                } catch (Exception ex) {
                        log.error("Problem while processing request from mobile: ",ex);
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
