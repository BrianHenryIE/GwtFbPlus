package ie.sortons.gwtfbplus.server.fql;

/**
 * @author brianhenry
 * @see http://stackoverflow.com/questions/10478812/facebook-graph-api-error-code-list
 * @see http://fbdevwiki.com/wiki/Error_codes
 *
 */
public class Error {
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @return the error_subcode
	 */
	public String getError_subcode() {
		return error_subcode;
	}
	
	private String message;
	private String type;
	private String code;
	private String error_subcode;


}
