package ie.sortons.gwtfbplus.server.fql;

/**
 * @author brianhenry
 * @see http://stackoverflow.com/questions/10478812/facebook-graph-api-error-code-list
 * @see http://fbdevwiki.com/wiki/Error_codes
 *
 *
 *	Also got this when access token was expired:
 *	{"error_code":"104", "error_msg":"Requires valid signature", "request_args":[{"key":"api_key", "value":"251403644880972"},{"key":"callback", "value":"FB.__globalCallbacks.f21f3f80794af1"},{"key":"format", "value":"json-strings"},{"key":"method", "value":"fql.query"},{"key":"pretty", "value":"0"},{"key":"query", "value":"SELECT page_id, name, page_url, location FROM page WHERE page_id IN (SELECT page_id FROM page_fan WHERE uid IN (176727859052209,133490393390530,136338279838233,176727859052209) AND NOT (page_id IN (176727859052209,136338279838233,133490393390530)) LIMIT 250)"},{"key":"sdk", "value":"joey"}]}
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
