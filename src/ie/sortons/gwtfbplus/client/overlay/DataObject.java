package ie.sortons.gwtfbplus.client.overlay;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Courtesy of gwtfb.com
 * 
 * Class that returns JsArray from json array 'data' 
 *
 */
public class DataObject extends JavaScriptObject {
    
    protected DataObject () {}
    
    public final native JavaScriptObject getData () /*-{
        // return this.data;
        return this;
    
    }-*/;
    
    public final native JavaScriptObject getObject ( String name ) /*-{
        return this[name];
    }-*/;
    
    
    public final native String getString ( String name ) /*-{
        return this[name];
    }-*/;

}
