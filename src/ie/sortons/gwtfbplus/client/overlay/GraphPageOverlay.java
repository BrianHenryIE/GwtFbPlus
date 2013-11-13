package ie.sortons.gwtfbplus.client.overlay;

import com.google.gwt.core.client.JavaScriptObject;


// TODO... stop writing things twice


public class GraphPageOverlay extends JavaScriptObject {
	protected GraphPageOverlay() {}

	
	public final native String getId() /*-{ return this.id; }-*/;
	public final native String getName() /*-{ return this.name; }-*/;
	public final native String getLink() /*-{ return this.link; }-*/;
	
}


