package ie.sortons.gwtfbplus.client.overlay.graph;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * @author brianhenry
 *
 * @see https://developers.facebook.com/docs/graph-api/reference/place/
 */
public class GraphPlace extends JavaScriptObject {
	
	protected GraphPlace () {}
	

	public final native String getId()  /*-{
		return this.id;
	}-*/;

	public final native GraphLocation getLocation() /*-{
		return this.location;
	}-*/; 

	public final native String getName()  /*-{
		return this.name;
	}-*/;
		
}