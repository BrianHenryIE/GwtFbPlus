package ie.sortons.gwtfbplus.client.overlay;

import com.google.gwt.core.client.JavaScriptObject;

// This is the one posted to the frame. I'm not sure if it's the same
// that's returned to the JS login

public class SignedRequest extends JavaScriptObject {

	protected SignedRequest() {}
	
	public final native String getAlgorithm() /*-{ return this.algorithm; }-*/;
	public final native String getApp_data() /*-{ return this.app_data; }-*/;
	public final native String getExpires() /*-{ return this.expires; }-*/;
	public final native String getIssued_at() /*-{ return this.issued_at; }-*/;
	public final native String getOauth_token()  /*-{ return this.oauth_token; }-*/;
	public final native Page getPage() /*-{ return this.page; }-*/;
	public final native User getUser() /*-{ return this.user; }-*/;
	public final native String getUserId() /*-{ return this.user_id; }-*/;	
	
	public static class Page extends JavaScriptObject {
		
		protected Page() {}
		
		public final native String getId() /*-{ return this.id; }-*/;
		public final native boolean getLiked() /*-{ return this.liked; }-*/;
		public final native boolean getAdmin() /*-{ return this.admin; }-*/;
		
	}	
	
	public static class User extends JavaScriptObject {
		
		protected User() {}
		
		public final native String getCountry() /*-{ return this.country; }-*/;
		public final native String getLocale() /*-{ return this.locale; }-*/;
		public final native Age getAge() /*-{ return this.age; }-*/;	
	}
	
	
	public static class Age extends JavaScriptObject {

		protected Age() {}

	    public final native String getMin() /*-{ return this.min; }-*/;
	}


	public static SignedRequest parseSignedRequest() {
		return getSRJSO().cast();
	}
	
	public static final native JavaScriptObject getSRJSO() /*-{
   		return $wnd._sr_data;
	}-*/;
}