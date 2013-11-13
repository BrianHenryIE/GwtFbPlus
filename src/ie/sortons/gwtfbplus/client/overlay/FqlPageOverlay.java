package ie.sortons.gwtfbplus.client.overlay;

import com.google.gwt.core.client.JavaScriptObject;


// TODO... stop writing things twice


public class FqlPageOverlay extends JavaScriptObject {

	protected FqlPageOverlay() {}
	
	public final native String getPageId() /*-{ return this.page_id; }-*/;
	public final native String getName() /*-{ return this.name; }-*/;
	public final native String getPageUrl() /*-{ return this.page_url; }-*/;
	
}


