package ie.sortons.gwtfbplus.shared.domain;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.shared.GwtIncompatible;
import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

/*

 Possibly incomplete:

 {
 "algorithm": "HMAC-SHA256",
 "app_data": "TheDataPassedInFrom#afterTheFacebookURL",
 "expires": 1357354800,
 "issued_at": 1357347803,
 "oauth_token": "AAACGKwdeEuwBAI8WT51HekDwwMa18YZBdEgcycS6prZBU5oRFuHSqOOgwEJTBpavvf5j7e31C49t3sE2IOwWyGrsHU094vH4JwtGqHyQZDZD",
 "page": {
 "id": "176727859052209",
 "liked": true,
 "admin": true
 },
 "user": {
 "country": "ie",
 "locale": "en_GB",
 "age": {
 "min": 21
 }
 },
 "user_id": "37302520"
 }


 */

public class SignedRequest implements JsonSerializable {

	/**
	 * @return an OAuth Code which can be exchanged for a valid user access token via a subsequent server-side request
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return A string containing the mechanism used to sign the request, normally: HMAC-SHA256.
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * @return A string containing the content of the app_data query string parameter which may be passed if the app is
	 *         being loaded within a Page Tab.
	 */
	public String getAppData() {
		return app_data;
	}

	/**
	 * @return A number containing the Unix timestamp when the oauth_token expires.
	 */
	public String getExpires() {
		return expires;
	}

	/**
	 * @return A number containing the Unix timestamp when the request was signed.
	 */
	public String getIssuedAt() {
		return issued_at;
	}

	/**
	 * @return A string that can be used when making requests to the Graph API. This is also known as a user access
	 *         token.
	 */
	public String getOauthToken() {
		return oauth_token;
	}

	/**
	 * @return An object containing the page id string, the liked boolean (set to true if the user has liked the page,
	 *         false if not) and the admin boolean (set to true if the user is an admin of the page, false if they're
	 *         not). This field is only present if your app is being loaded within a Page Tab.
	 */
	public SRPage getPage() {
		return page;
	}

	/**
	 * @return A JSON object containing the locale string, country string and the age object. See the Age Object table
	 *         for actual min and max values.
	 */
	public SRUser getUser() {
		return user;
	}

	/**
	 * @return A JSON string containing the User ID of the current user.
	 */
	public String getUserId() {
		return user_id;
	}

	public SignedRequest() {
	}

	public String code;
	public String algorithm;
	public String app_data;
	public String expires;
	public String issued_at;
	public String oauth_token;
	public SRPage page;
	public SRUser user;
	public String user_id;

	public static class SRPage implements JsonSerializable {

		public String getId() {
			return id;
		}

		public Boolean isLiked() {
			return liked;
		}

		public Boolean isAdmin() {
			return admin;
		}

		public String id;
		public Boolean liked;
		public Boolean admin;

		public SRPage() {
		}
	}

	public static class SRUser implements JsonSerializable {

		public String getCountry() {
			return country;
		}

		public String getLocale() {
			return locale;
		}

		public SRUserAge getAge() {
			return age;
		}

		public SRUser() {
		}

		public String country;
		public String locale;
		public SRUserAge age;

	}

	/**
	 * @author brianhenry
	 * 
	 *         The age object, which is part of the user object will only be returned in the signed_request parameter
	 *         for Canvas Apps; it will not be returned for external apps. It provides an unspecific age range that the
	 *         user fits into, allowing apps to determine whether the user can be shown alcohol content for example,
	 *         without identifying their age specifically.
	 */
	public static class SRUserAge implements JsonSerializable {

		public SRUserAge() {
		}

		public String getMin() {
			return min;
		}

		public String getMax() {
			return max;
		}

		public String min;
		public String max;

	}

	/*
	 * ParseSignedRequest - This method takes an encoded signed_request string (which we receive in Facebook's POST
	 * request) and decodes it into a java object
	 * 
	 * @see http://developers.facebook.com/docs/reference/login/signed-request/
	 */
	@GwtIncompatible
	public static SignedRequest parseSignedRequest(String signed_request) {

		String payLoad = signed_request.split("[.]", 2)[1];
		payLoad = payLoad.replace("-", "+").replace("_", "/").trim();

		// javax.xml.bind.DatatypeConverter wasn't good enough here
		// String jsonString = new String(DatatypeConverter.parseBase64Binary(payLoad));
		// The string returned with "} missing

		String jsonString = new String(Base64.decodeBase64(payLoad.getBytes()));

		Gson gson = new GsonBuilder().create();
		SignedRequest signedrequest = gson.fromJson(jsonString, SignedRequest.class);
		

		return signedrequest;
	}

	// This is incompatible with the server but the /* comments */ mean it's safe to leave in!
	public static final native JavaScriptObject getSignedRequestFromHTML() /*-{
		return $wnd._sr_data;
	}-*/;
}
