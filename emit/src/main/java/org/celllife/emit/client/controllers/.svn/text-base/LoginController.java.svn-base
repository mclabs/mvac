package org.celllife.emit.client.controllers;

import org.celllife.emit.client.AppMessages;
import org.celllife.emit.client.EmitAsyncCallback;
import org.celllife.emit.client.service.UserServiceAsync;
import org.celllife.emit.client.util.ProgressIndicator;
import org.celllife.emit.client.views.LoginView;
import org.openxdata.server.admin.model.User;

import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

public class LoginController extends Controller {

    AppMessages appMessages = (AppMessages)GWT.create(AppMessages.class);
    
    public final static EventType LOGIN = new EventType();

    private LoginView loginView;
    private UserServiceAsync userService;
    
    public LoginController(UserServiceAsync aUserService) {
        super();
        userService = aUserService;
        registerEventTypes(LOGIN);
    }
    
    @Override
    protected void initialize() {
        System.out.println("LoginController initialize");
        loginView = new LoginView(this);
    }

    @Override
    public void handleEvent(AppEvent event) {
        System.out.println("LoginController handleEvent");
        EventType type = event.getType();
        if (type == LOGIN) {
            forwardToView(loginView, event);
        }
    }
    
    public void performLogin(String username, String password) {
    	ProgressIndicator.showProgressBar();
        userService.authenticate(username, password,
        new EmitAsyncCallback<User>() {
            @Override
			public void onSuccess(User result) {
                if (result != null) {
                    loginView.close();
                } else {
                    Window.alert(appMessages.unsuccessfulLogin());
                    loginView.reset();
                }
                ProgressIndicator.hideProgressBar();
            }
        });
    }
}