package org.celllife.emit.client.controllers;

import org.celllife.emit.client.AppMessages;
import org.celllife.emit.client.EmitAsyncCallback;
import org.celllife.emit.client.RefreshableEvent;
import org.celllife.emit.client.RefreshablePublisher;
import org.celllife.emit.client.service.UserServiceAsync;
import org.celllife.emit.client.views.UserProfileView;
import org.openxdata.server.admin.model.User;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

public class UserProfileController extends Controller {
    AppMessages appMessages = (AppMessages)GWT.create(AppMessages.class); 
    public final static EventType USERPROFILE = new EventType();
    private UserProfileView userProfileView;
    private UserServiceAsync userService;
    
    public UserProfileController(UserServiceAsync aUserService) {
        super();
        registerEventTypes(USERPROFILE);
        userService = aUserService;
    }
    
    @Override
    protected void initialize() {
    	Log.info("UserProfileController : initialize");
    }

    @Override
    public void handleEvent(final AppEvent event) {
    	Log.info("UserProfileController : handleEvent");
        EventType type = event.getType();
        if (type == USERPROFILE) {
        	userService.getLoggedInUser(new EmitAsyncCallback<User>() {
                @Override
				public void onSuccess(User result) {
                    event.setData(result);
                    userProfileView = new UserProfileView(UserProfileController.this);
                    forwardToView(userProfileView, event);                    
                }
            });
        }
    }
    
    public void checkPasswordSaveUser(final User user) {
        Log.info("UserProfileController : checkPasswordSaveUser, user : " + user.getFullName());
        userService.validatePassword(user, new EmitAsyncCallback<Boolean>() {
            @Override
			public void onSuccess(Boolean result) {
                if (result) {
                    saveUserProfile(user);
                } else {
                    userProfileView.displayError(appMessages.oldPasswordNotValid());
                }
            }
        });
    }
    
    public void saveUserProfile(final User user) {
    	Log.info("UserProfileController : saveUserProfile , user : " + user.getFullName());
        userService.saveUser(user, new EmitAsyncCallback<Void>() {
                @Override
				public void onSuccess(Void result) {
                    Window.alert(appMessages.user() + " " + user.getName() + " " + appMessages.profileSaved());
                    RefreshablePublisher.get().publish(
                    		new RefreshableEvent(RefreshableEvent.Type.NAME_CHANGE, user));                    
                    userProfileView.closeWindow();
                }
            });
    }
}
