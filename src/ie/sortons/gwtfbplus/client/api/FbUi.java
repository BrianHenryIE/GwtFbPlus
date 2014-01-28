package ie.sortons.gwtfbplus.client.api;


import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtfb.sdk.FBCore;

/**
 * Uses gwtfb library for the actual calls
 * 
 * @author Brian Henry
 * @see https://developers.facebook.com/docs/reference/javascript/FB.ui/
 */
public class FbUi {

	private static FBCore fbCore = GWT.create(FBCore.class);
	
	/**
	 * @param mapName
	 * @param options
	 * @see https://developers.facebook.com/docs/reference/dialogs/feed/
	 */
	public static void Feed(String link, String picture, String name, String caption, String description, AsyncCallback<JavaScriptObject> callback){ 
		
		JSONObject feedCall = new JSONObject();
		feedCall.put("method", new JSONString("feed"));
		
		if(link != null) { feedCall.put("link", new JSONString(link)); }
		if(picture != null) { feedCall.put("picture", new JSONString(picture)); }
		if(name != null) { feedCall.put("name", new JSONString(name)); }
		if(caption != null) { feedCall.put("caption", new JSONString(caption)); }
		if(description != null) { feedCall.put("description", new JSONString(description)); }
		
		fbCore.ui(feedCall.getJavaScriptObject(), callback);
	}
	/*
	FB.ui({
		  method: 'feed',
		  link: 'https://developers.facebook.com/docs/reference/dialogs/',
		  picture: 'http://fbrell.com/f8.jpg',
		  name: 'Facebook Dialogs',
		  caption: 'Reference Documentation',
		  description: 'Using Dialogs to interact with people.'
		}, function(response){});
	*/
	
}
