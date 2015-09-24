package ie.sortons.gwtfbplus.client.api;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;



/**
 * Class that wraps facebook Javascript SDK
 * 
 * @author ola the wrapper
 */
public class FBCore {


	private native void initJS(String appId, boolean status, boolean xfbml, String version) /*-{
		$wnd.FB.init({
			'appId': appId, 
			'status': status,
			'xfbml' : xfbml,
			'version': version
		});
	}-*/;

	private static void loadJSSDK(Callback<Void, Exception> callback) {

		// TODO i18n
		String sdkUrl = "//connect.facebook.net/en_US/sdk.js";

		// setWindow(ScriptInjector.TOP_WINDOW)
		ScriptInjector.fromUrl(sdkUrl).setCallback(callback).setWindow(ScriptInjector.TOP_WINDOW).inject();

	}


	/**
	 * @see http://developers.facebook.com/docs/reference/javascript/FB.init
	 * 
	 * @param appId
	 *            Your application ID. If you don't have one find it in the App dashboard or go there to create a new
	 *            app. Defaults to null.
	 * @param status
	 *            If you set status to true, the SDK will attempt to get info about the current user immediately after
	 *            init. Doing this can reduce the time it takes to check for the state of a logged in user if you're
	 *            using Facebook Login, but isn't useful for pages that only have social plugins on them.
	 * @param xfbml
	 *            With xfbml set to true, the SDK will parse your page's DOM to find and initialize any social plugins
	 *            that have been added using XFBML. If you're not using social plugins on the page, setting xfbml to
	 *            false will improve page load times.
	 * @param version
	 *            Determines which versions of the Graph API and any API dialogs or plugins are invoked when using the
	 *            .api() and .ui() functions. Valid values are determined by currently available versions, such as
	 *            'v2.0'. This is a required parameter.
	 */
	public void init(String appId, boolean status, boolean xfbml, String version) {
		init(appId, status, xfbml, version, null);
	}

	public void init(final String appId, final boolean status, final boolean xfbml, final String version, final Callback<Void, Exception> callback) {
		
		// Check has the JS SDK been loaded 
		if(DOM.getElementById("fb-root")==null || !DOM.getElementById("fb-root").hasChildNodes())
			loadJSSDK(new Callback<Void, Exception>(){

				@Override
				public void onFailure(Exception reason) {
					GWT.log(reason.toString());
				}

				@Override
				public void onSuccess(Void result) {
					 initJS(appId, status, xfbml, version); 
					callback.onSuccess(null);
				}});
			else {
				initJS(appId, status, xfbml, version);
				callback.onSuccess(null);
			}
		
	}
	
	
	/**
	 * A Graph request
	 */
	public native void api (String version, String path, AsyncCallback<JavaScriptObject> callback) /*-{
		var app=this;
		$wnd.FB.api (version+path, function(response){
	        app.@ie.sortons.gwtfbplus.client.api.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
	}-*/;
	


	public native void apiParams (String path, String params, AsyncCallback<JavaScriptObject> callback) /*-{
       var app=this;
       $wnd.FB.api (path, params, function(response){
           app.@ie.sortons.gwtfbplus.client.api.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
       });
   }-*/;

	/**
	 * Wrapper method
	 */
	public native void apiParams (String path, JavaScriptObject params, AsyncCallback<JavaScriptObject> callback) /*-{
		var app=this;
		$wnd.FB.api (path, params, function(response){
		    app.@ie.sortons.gwtfbplus.client.api.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
	}-*/;
	
	/**
	 * Wrapper method
	 */
	public native void apiParams (String path, String method,JavaScriptObject params, AsyncCallback<JavaScriptObject> callback) /*-{
		var app=this;
		$wnd.FB.api (path,method, params, function(response){
		    app.@ie.sortons.gwtfbplus.client.api.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
	}-*/;
	

	/**
	 * Wrapper method for the OLD REST API
	 */
	public native void api (JavaScriptObject params, AsyncCallback<JavaScriptObject> callback) /*-{
    	var app=this;
    	$wnd.FB.api(params,function(response){
        	app.@ie.sortons.gwtfbplus.client.api.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
    	});
	}-*/; 
	
	/**
	 * Wrapper method
	 */
	public native void getLoginStatus (AsyncCallback<JavaScriptObject> callback) /*-{
        var app=this;
		$wnd.FB.getLoginStatus(function(response) {
            app.@ie.sortons.gwtfbplus.client.api.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
		
	}-*/;

	/**
	 * Wrapper method
	 */
	public native JavaScriptObject getAuthResponse () /*-{
		return $wnd.FB.getAuthResponse();
	}-*/;

	/**
	 * Wrapper method
	 */
	public native void login (AsyncCallback<JavaScriptObject> callback) /*-{
		var app=this;
        $wnd.FB.login (function(response){
    	    app.@ie.sortons.gwtfbplus.client.api.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
	}-*/;
	
	/**
	 * Wrapper method
	 */
	public native void login (AsyncCallback<JavaScriptObject> callback ,String permissions) /*-{
       	var app=this;
        $wnd.FB.login (function(response){
    	    app.@ie.sortons.gwtfbplus.client.api.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		},{perms:permissions});
	}-*/;
	
	/**
	 * Wrapper method
	 */
	public native void logout (AsyncCallback<JavaScriptObject> callback) /*-{
		var app=this;
		$wnd.FB.logout(function(response){
    	    app.@ie.sortons.gwtfbplus.client.api.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
	}-*/;
	
	/**
	 * Wrapper method
	 */
	public native void ui (JavaScriptObject params, AsyncCallback<JavaScriptObject> callback) /*-{
		var app=this;
		$wnd.FB.ui(params,function(response){
    	    app.@ie.sortons.gwtfbplus.client.api.FBCore::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		});
	}-*/;
	
	/*
     * Called when method succeeded.
     */
    protected void callbackSuccess(AsyncCallback<JavaScriptObject> callback, JavaScriptObject obj) {
        callback.onSuccess (obj);
    }

}
