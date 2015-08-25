package ie.sortons.gwtfbplus.client.api;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Widget;

/**
 * Class that wraps xfbml methods 
 * @see http://developers.facebook.com/docs/reference/javascript/#xfbml-methods
 * @author ola the wrapper
 */
public class FBXfbml {

	/**
	 * Wrapper method
	 * @see http://developers.facebook.com/docs/reference/javascript/FB.XFBML.parse
	 */
	public static native void parse () /*-{
		$wnd.FB.XFBML.parse();
	}-*/;
	
	/**
	 * Wrapper method
	 * @widget widget to parse – must have an id!
	 */
	public static void parse (Widget widget) {
		parse(widget.getElement());
	};
	
	/** 
	 * Wrapper method
	 * @see http://developers.facebook.com/docs/reference/javascript/FB.XFBML.parse
	 */
	public static native void parse (Element domelement) /*-{
		$wnd.FB.XFBML.parse(domelement);	
	}-*/;
	
	public static void parse (Widget widget, Command cb) {
		parse(widget.getElement(), cb);
	};
	
	public static native void parse (Element domelement, Command cb) /*-{
		var app=this;
		$wnd.FB.XFBML.parse(domelement, function(response){
		    @ie.sortons.gwtfbplus.client.api.FBXfbml::callbackSuccess(Lcom/google/gwt/user/client/Command;)(cb);
		});
	}-*/;

	/*
     * Called when method succeeded.
     */
    public static void callbackSuccess(Command cb) {
       cb.execute();
    }

}
