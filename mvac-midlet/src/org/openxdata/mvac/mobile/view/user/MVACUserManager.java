/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view.user;

import org.bouncycastle.crypto.digests.SHA1Digest;
import org.openxdata.db.OpenXdataDataStorage;
import org.openxdata.db.util.Settings;
import org.openxdata.model.User;
import org.openxdata.model.UserList;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.Constants;

/**
 *
 * @author soyfactor
 */
public class MVACUserManager {
    /** The currently logged on user. */
	private static User user;

        private static final String STORAGE_NAME_SETTINGS = "util.Settings";
	private static final String KEY_LAST_USERNAME = "lastusername";

        private boolean loggedOn = false; //false;   //thi is just for development to prevent the tiresome logons

    
    
    /**
	 * Check to see if a user is authorised. As for now, we are not checking user
	 * passwords because of danger of tranfering passwords over the place.
	 * The password check will be done at the server. This means that all
	 * one needs to know is username and gets into the system on device,
	 * which is not good and hence needs more input. But for now, that's it.
	 * 
	 * @param name - the user name.
	 * @param password - the user password.
	 * @return true when valid user, else false.
	 */
    public boolean isUserValid(String name, String password) throws Exception {
        //I think it makes sense to force users enter a user name and password
		//even when no user information has yet been loaded from the server.
		if(name.trim().length() == 0 || password.trim().length() == 0)
			return false;

		UserList users = OpenXdataDataStorage.getUsers();
		if(users == null || users.size() == 0)
			return true; //No users in db so every one has free entry

		user = null;
		for(int i=0; i<users.size(); i++){
			user = users.getUser(i);
			if(user.getName().toLowerCase().equals(name.toLowerCase()) /*&& user.getPassword().equals(password)*/)
				return authenticate(user,password);
		}

		return false;


    }

    private boolean authenticate(User user, String password) throws Exception {
		String hashedPassword = encodeString(password + user.getSalt(), false);
		boolean result = (hashedPassword.equals(user.getPassword()));
		if (!result) {
			String hashedPassword2 = encodeString(password + user.getSalt(), true);
			result = (hashedPassword2.equals(user.getPassword()));
		}
		return result;
	}

     /**
     * @param string to encode
     * @return the SHA-1 encryption of a given string
     */
    public static String encodeString(String strToEncode, boolean hexString2) throws Exception {
    	//SHA512Digest digEng = new SHA512Digest();
    	SHA1Digest digEng = new SHA1Digest();

    	//pick a specific character encoding, don't rely on the platform default
  		byte[] input = strToEncode.getBytes("UTF-8");
  		digEng.update(input, 0, input.length);

  		byte[] digest = new byte[digEng.getDigestSize()];
  		digEng.doFinal(digest, 0);

  		if (!hexString2) {
  			return hexString(digest);
  		} else {
  			return hexString2(digest);
  		}
    }

    /**
     * @param Byte array to convert to HexString
     * @return Hexidecimal based string
     */

	private static String hexString(byte[] b) {
		if (b == null || b.length < 1)
			return "";
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			s.append(Integer.toHexString(b[i] & 0xFF));
		}
		return new String(s);
	}

	private static String hexString2(byte[] b) {
		StringBuffer buf = new StringBuffer();
		char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		int len = b.length;
		int high = 0;
		int low = 0;
		for (int i = 0; i < len; i++) {
			high = ((b[i] & 0xf0) >> 4);
			low = (b[i] & 0x0f);
			buf.append(hexChars[high]);
			buf.append(hexChars[low]);
		}

		return buf.toString();
	}


        /**
	 * Gets login information from the user and check if he or she is authorised.
	 * @param d
	 */
	private boolean validateUser(String username,String password) throws Exception {
		if(isUserValid(username,password)){
			//setLoggedOn(true); //set state of user in global registry
                        AppUtil.get().putItem(Constants.LOGIN_STATUS, "true");
			saveUserName(username); //save in rms
			
                        //save the user params in global registry
                        AppUtil.get().putItem(Constants.USERNAME, username);
                        AppUtil.get().putItem(Constants.PASSWROD, password);
                        return true;
		}
		else{
                    return false;
                }
			
	}


        //
        private void saveUserName(String username){
		Settings settings = new Settings(STORAGE_NAME_SETTINGS,true);
		settings.setSetting(KEY_LAST_USERNAME,username );
		settings.saveSettings();
	}

    

}
