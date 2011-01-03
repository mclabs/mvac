package org.openxdata.server.admin.model.exception;

/**
 * This is for exceptions that not known before hand
 * But will be thrown later with a custom Runtime Exception.
 * 
 * 
 * @author Angel
 * @since First code Quality meeting.
 *
 */
@Deprecated
public class ReplaceThisExceptionRuntimeException extends OpenXDataRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4921735309910141608L;
	
    /**
     * Default non arg constructor.
     */
    public ReplaceThisExceptionRuntimeException() {
    	super("Replace the Generic Exception with a custom Runtime Exception that extends the OpenXDataRuntimeException.");
    }
    
    /**
     * Constructor that takes an argument which is
	 * a <code>String </code> message for the instance of any 
	 * unregistered security exception that might be thrown on the server.
	 * 
	 * @param message the message of the unregistered exception thrown on the server.
     */
    public ReplaceThisExceptionRuntimeException(String message) {
        super(message + ".Replace the Generic Exception with a custom Runtime Exception that extends the OpenXDataRuntimeException.");
    }
}
