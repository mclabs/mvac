/*
 *  Licensed to the OpenXdata Foundation (OXDF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The OXDF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, 
 *  software distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 *
 *  Copyright 2010 http://www.openxdata.org.
 */
package org.openxdata.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.openxdata.server.OpenXDataPropertyPlaceholderConfigurer;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.admin.model.exception.UserNotFoundException;
import org.openxdata.server.security.OpenXDataUserDetails;
import org.openxdata.server.service.UserService;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.context.SecurityContextImpl;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ResetPasswordServlet extends HttpServlet {	
    
    private Logger log = Logger.getLogger(this.getClass());

    private static final long serialVersionUID = 2310768931768394086L;
    private MailSender mailSender;
    private UserService userService;
    private UserDetailsService userDetailsService;
    private OpenXDataPropertyPlaceholderConfigurer propertyPlaceholder;
    
    Locale userLocale;
    ResourceBundleMessageSource messageSource;
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ServletContext sctx = this.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sctx);
		userService = (UserService) ctx.getBean("userService");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
	    
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		mailSender = (org.springframework.mail.javamail.JavaMailSenderImpl) ctx.getBean("mailSender");
		userService = (UserService) ctx.getBean("userService");
		userDetailsService = (UserDetailsService) ctx.getBean("userDetailsService");
		messageSource = (ResourceBundleMessageSource) ctx.getBean("messageSource");
	    userLocale = new Locale((String)request.getSession().getAttribute("locale")); //new AcceptHeaderLocaleResolver().resolveLocale(request);
	    log.debug("userLocale="+userLocale.getLanguage());

		String email = request.getParameter("email");
		if (email == null) {
		    //ajax response reference text
		    out.println("noEmailSuppliedError");
		}
		
		
        try{
    		User user = userService.findUserByEmail(email);
	        /*
             * Valid User with the correct e-mail.
             */
			insertUserInSecurityContext(user); // this is so that it is possible to reset their password (security checks)
			
    		Properties props = propertyPlaceholder.getResolvedProps();
            String from = props.getProperty("mailSender.from");		
		
			try {
				//Reset the User password and send an email
				userService.resetPassword(user, 6);
				SimpleMailMessage msg = new SimpleMailMessage();
	            msg.setTo(email);
	            msg.setSubject(messageSource.getMessage("resetPasswordEmailSubject", new Object[] {user.getFullName()}, userLocale));
	            msg.setText(messageSource.getMessage("resetPasswordEmail", new Object[] { user.getName(), user.getClearTextPassword() }, userLocale));
	            msg.setFrom(from);
	            
	            try {
	                mailSender.send(msg);
	                //ajax response reference text
	                out.println("passwordResetSuccessful");
	            } catch (MailException ex) {
	                log.error("Error while sending an email to the user "+user.getName()+" in order to reset their password.", ex);
	                log.error("Password reset email:"+msg.toString());
	                //ajax response reference text
	                out.println("emailSendError");
	            }
			} catch (Exception e) {
			    log.error("Error while resetting the user "+user.getName()+"'s password", e);
			    //ajax response reference text
			    out.println("passwordResetError");
			}
		} catch(UserNotFoundException userNotFound) {
			/*
			* Invalid User or incorrect Email.
			*/
			//ajax response reference text
		    out.println("validationError");
		}
	}
	
	private void insertUserInSecurityContext(User user) {
		OpenXDataUserDetails userDetails = (OpenXDataUserDetails) userDetailsService.loadUserByUsername(user.getName());
		Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, userDetails, userDetails.getAuthorities());
		SecurityContext sc = new SecurityContextImpl();
        sc.setAuthentication(auth);
        SecurityContextHolder.setContext(sc);
	}
} 
