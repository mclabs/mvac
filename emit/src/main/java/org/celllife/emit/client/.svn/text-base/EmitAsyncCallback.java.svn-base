package org.celllife.emit.client;

import org.celllife.emit.client.controllers.LoginController;
import org.openxdata.server.admin.model.exception.OpenXDataSecurityException;
import org.openxdata.server.admin.model.exception.OpenXDataSessionExpiredException;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Emit application AsynCallback that automatically handles errors that occur
 * 
 * @author dagmar@cell-life.org.za
 * @param <T>
 */
public abstract class EmitAsyncCallback<T> implements AsyncCallback<T> {
    
    AppMessages appMessages = (AppMessages)GWT.create(AppMessages.class); 

    /**
     * Implements some auto error handling for SpringSecurityException and general errors.
     */
    @Override
	final public void onFailure(Throwable throwable) {
        Log.error("Error caught while performing an action on the server: "+throwable.getMessage(), throwable);
        if (throwable instanceof OpenXDataSessionExpiredException) {
            // allow the user to login again (show a login popup so they can continue where they left off)
            //Window.alert(appMessages.sessionExpired());
            Dispatcher.get().dispatch(LoginController.LOGIN);
        } else if (throwable instanceof OpenXDataSecurityException) {
            // access denied
            Window.alert(appMessages.accessDeniedError());
        } else {
            // all other errors
            Window.alert(appMessages.pleaseTryAgainLater(throwable.getMessage()));
        }
    }
    

}