package org.celllife.emit.client.service;

import org.openxdata.server.admin.model.User;
import org.openxdata.server.admin.model.exception.OpenXDataException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("user")
public interface UserService extends RemoteService {
    User authenticate(String username, String password) throws OpenXDataException;
	void saveUser(User user) throws OpenXDataException;
    User getUser(String username) throws OpenXDataException;
    boolean validatePassword(User user) throws OpenXDataException;
    User getLoggedInUser() throws OpenXDataException;
    User findUserByEmail(String email) throws OpenXDataException;
    void resetPassword(User user, int size) throws OpenXDataException;
}
