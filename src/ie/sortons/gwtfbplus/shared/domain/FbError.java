package ie.sortons.gwtfbplus.shared.domain;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

/**
 * @author brianhenry
 * @see http://stackoverflow.com/questions/10478812/facebook-graph-api-error-code-list
 * @see http://fbdevwiki.com/wiki/Error_codes
 *
 *
 *	Also got this different error structure, now JsFqlError when access token was expired using gwtfb:
 *	{"error_code":"104", "error_msg":"Requires valid signature", "request_args":[{"key":"api_key", "value":"251403644880972"},{"key":"callback", "value":"FB.__globalCallbacks.f21f3f80794af1"},{"key":"format", "value":"json-strings"},{"key":"method", "value":"fql.query"},{"key":"pretty", "value":"0"},{"key":"query", "value":"SELECT page_id, name, page_url, location FROM page WHERE page_id IN (SELECT page_id FROM page_fan WHERE uid IN (176727859052209,133490393390530,136338279838233,176727859052209) AND NOT (page_id IN (176727859052209,136338279838233,133490393390530)) LIMIT 250)"},{"key":"sdk", "value":"joey"}]}
 *  {"error_code":"601", "error_msg":"Parser error: unexpected ',' at position 203.", "request_args":[{"key":"access_token", "value":"CAADkpnjyyEwBAJu2cd3OndZCLyQH0u4dSp1NTdBGxq2gFi6LFjx9VZAxxnxcZAuQ4StfZAf3z4vdYusv56dGDaDZCm8cZBTukhOGOynFt98ZBua4gIcrhEotYJMC7qPbBxekJh37XZCodIxC6SjRkUt4u6ik4TIEVypOgARqIdGxAsXYJZAq5XAnJRA5XVVEsyFIl5BpVZBbLOmAZDZD"},{"key":"api_key", "value":"251403644880972"},{"key":"callback", "value":"FB.__globalCallbacks.f22fdb26fac50f4"},{"key":"format", "value":"json-strings"},{"key":"method", "value":"fql.query"},{"key":"pretty", "value":"0"},{"key":"query", "value":"SELECT name, location, venue, eid, start_time, end_time, is_date_only FROM event WHERE eid IN (SELECT eid FROM event_member WHERE start_time > 'null' AND uid IN (SELECT uid2 FROM friend WHERE uid1 = me(), me())) ORDER BY start_time LIMIT 250"},{"key":"sdk", "value":"joey"}]}
 */
public class FbError implements JsonSerializable {
	
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
	public String getErrorSubcode() {
		return error_subcode;
	}
	
	public String message;
	public String type;
	public String code;
	public String error_subcode;

	
}
