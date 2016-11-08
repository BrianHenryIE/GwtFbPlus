package ie.sortons.gwtfbplus.shared.domain;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

public class FbError implements JsonSerializable {

	private String message;
	private String code;
	private String error_subcode;

	private String error_user_msg;
	private String error_user_title;
	private String fbtrace_id;

	private String type;

	/**
	 * @return A human-readable description of the error. code: An error code.
	 *         Common values are listed below, along with common recovery
	 *         tactics.
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
	public String getErrorSubcode() {
		return error_subcode;
	}

	public String getError_subcode() {
		return error_subcode;
	}

	public void setError_subcode(String error_subcode) {
		this.error_subcode = error_subcode;
	}

	/**
	 * @return The message to display to the user. The language of the message
	 *         is based on the locale of the API request.
	 */
	public String getError_user_msg() {
		return error_user_msg;
	}

	public void setError_user_msg(String error_user_msg) {
		this.error_user_msg = error_user_msg;
	}

	/**
	 * @return The title of the dialog, if shown. The language of the message is
	 *         based on the locale of the API request.
	 */
	public String getError_user_title() {
		return error_user_title;
	}

	public void setError_user_title(String error_user_title) {
		this.error_user_title = error_user_title;
	}

	/**
	 * @return Internal support identifier. When reporting a bug related to a
	 *         Graph API call, include the fbtrace_id to help us find log data
	 *         for debugging.
	 */
	public String getFbtrace_id() {
		return fbtrace_id;
	}

	public void setFbtrace_id(String fbtrace_id) {
		this.fbtrace_id = fbtrace_id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setType(String type) {
		this.type = type;
	}

	// fbtrace_id
}
