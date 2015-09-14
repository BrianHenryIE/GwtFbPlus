package ie.sortons.gwtfbplus.client.overlay;

import com.google.gwt.core.client.JavaScriptObject;

/** 
 *
 */
public class FbResponse extends JavaScriptObject {
    
    protected FbResponse () {}
    
    public final native JavaScriptObject getData () /*-{
	    return this.data;
	}-*/;
    
    public final native JavaScriptObject getError () /*-{
	    return this.error;
	}-*/;
  
}
