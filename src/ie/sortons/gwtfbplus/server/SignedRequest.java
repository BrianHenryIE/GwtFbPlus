package ie.sortons.gwtfbplus.server;


import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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



public class SignedRequest {
	
	public String getAlgorithm() {
		return algorithm;
	}

	public String getApp_data() {
		return app_data;
	}

	public String getExpires() {
		return expires;
	}

	public String getIssued_at() {
		return issued_at;
	}

	public String getOauth_token() {
		return oauth_token;
	}

	public SRPage getPage() {
		return page;
	}

	public SRUser getUser() {
		return user;
	}

	public String getUser_id() {
		return user_id;
	}

	public SignedRequest () {}

	private String algorithm;
	private String app_data;
	private String expires;
	private String issued_at;
	private String oauth_token;
	private SRPage page;
	private SRUser user;
	private String user_id;

	
	public String toJsonString(){
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	

    public static class SRPage {
        
    	public String getId() {
			return id;
		}

		public boolean isLiked() {
			return liked;
		}

		public boolean isAdmin() {
			return admin;
		}

		private String id;
    	private boolean liked;
    	private boolean admin;
    	
    	public String toJsonString(){
    		Gson gson = new Gson();
    		return gson.toJson(this);
    	}
    }
    
	
    public static class SRUser {
    	
    	public String getCountry() {
			return country;
		}


		public String getLocale() {
			return locale;
		}


		public SRUserAge getAge() {
			return age;
		}


		SRUser() {}
        
    	private String country;
    	private String locale;
    	private SRUserAge age;
    	
    	public String toJsonString(){
    		Gson gson = new Gson();
    		return gson.toJson(this);
    	}
        
    	
    	public static class SRUserAge {
            
    		SRUserAge() {}
    		
    		public String getMin() {
				return min;
			}

			public String getMax() {
				return max;
			}

			private String min;
    		private String max;
        	
        	public String toJsonString(){
        		Gson gson = new Gson();
        		return gson.toJson(this);
        	}
        }
    }
 
	/*
	 *  ParseSignedRequest
	 *  - This method takes an encoded signed_request string (which we receive in
	 *    Facebook's POST request) and decodes it into a java object
	 *    
	 *    @see http://developers.facebook.com/docs/reference/login/signed-request/
	 */
	public static SignedRequest parseSignedRequest(String signed_request){
		
		String payLoad = signed_request.split("[.]", 2)[1];
		payLoad = payLoad.replace("-", "+").replace("_", "/").trim(); 

		// javax.xml.bind.DatatypeConverter wasn't good enough here 
		// String jsonString = new String(DatatypeConverter.parseBase64Binary(payLoad));
		// The string returned with "} missing
		
		String jsonString = new String(Base64.decodeBase64(payLoad.getBytes()));
				
		Gson gson = new GsonBuilder().create();
		SignedRequest signedrequest = new SignedRequest();
		signedrequest = gson.fromJson(jsonString, SignedRequest.class);
		
		return signedrequest;
	}
	
	
}

