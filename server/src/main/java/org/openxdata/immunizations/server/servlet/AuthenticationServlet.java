/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.immunizations.server.servlet;

import com.google.inject.Singleton;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.service.AuthenticationService;

/**
 *
 * @author gmimano
 */
@Singleton
public class AuthenticationServlet extends HttpServlet {


    private AuthenticationService authSrv;

    @Override
    public void init() throws ServletException {
        super.init();

        authSrv = (AuthenticationService) org.openxdata.server.Context.getBean("authenticationService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        processRequest(req, resp);
    }


    public void processRequest(HttpServletRequest req, HttpServletResponse resp){
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        User user=null;
        user = authSrv.authenticate(uname, pwd);
        PrintWriter out=null;
        try {
            out = resp.getWriter();
        } catch (IOException ex) {
            Logger.getLogger(AuthenticationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (user!=null) {
            // "200";
           out.print("200");
        }else{
            // "201"
            out.print("201");
        }


    }






}
