package ie.sortons.gwtfbplus.client.overlay;

import com.google.gwt.core.client.JavaScriptObject;

public class AuthResponse extends JavaScriptObject {

	protected AuthResponse() {
	}

	public final native String getAccessToken() /*-{
		return this.accessToken;
	}-*/;

	public final native int getExpiresIn() /*-{
		return this.expiresIn;
	}-*/;

	public final native SignedRequest getSignedRequest() /*-{
		return this.signedRequest;
	}-*/;

	public final native String getUserId() /*-{
		return this.userID;
	}-*/;

	public final native String getStatus() /*-{
		return this.status;
	}-*/;

	public static native AuthResponse getAuthResponse() /*-{
		return $wnd.FB.getAuthResponse();
	}-*/;

}
