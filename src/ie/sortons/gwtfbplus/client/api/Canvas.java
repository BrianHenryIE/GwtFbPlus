package ie.sortons.gwtfbplus.client.api;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

/*
 * Canvas Methods

 * FB.Canvas.Prefetcher.addStaticResource
 * FB.Canvas.Prefetcher.setCollectionMode
 * FB.Canvas.hideFlashElement
 * FB.Canvas.scrollTo
 * FB.Canvas.setAutoGrow
 * FB.Canvas.setDoneLoading
 * FB.Canvas.setSize
 * FB.Canvas.setUrlHandler
 * FB.Canvas.showFlashElement
 * FB.Canvas.startTimer
 * FB.Canvas.stopTimer
 * 
 */

/**
 * Methods for managing the Facebook canvas
 * 
 * @author brianhenry
 * 
 */
public class Canvas {

	/**
	 * Call this whenever you need a resize. This usually means, once after pageload, and whenever your content size
	 * changes.
	 * 
	 * This method will attempt to determine the size of the Canvas app content and set the height automatically. Note:
	 * when determining the Canvas Height automatically the height it can only be increased, not decreased. When
	 * possible please pass the explicit dimensions as properties of an object.
	 * 
	 * @see http://developers.facebook.com/docs/reference/javascript/FB.Canvas.setSize/
	 */
	public native static void setSize() /*-{
		$wnd.FB.Canvas.setSize();
	}-*/;

	/**
	 * Call this whenever you need a resize. This usually means, once after pageload, and whenever your content size
	 * changes. When possible please pass the explicit dimensions as properties of an object.
	 * 
	 * @see http://developers.facebook.com/docs/reference/javascript/FB.Canvas.setSize/
	 */
	public native static void setSize(int width, int height) /*-{
		$wnd.FB.Canvas.setSize({
			'width' : width,
			'height' : height
		});
	}-*/;

	public native static void getPageInfo(AsyncCallback<PageInfo> callback) /*-{
		var app = this;
		$wnd.FB.Canvas.getPageInfo($entry(function(response) {
			@ie.sortons.gwtfbplus.client.api.Canvas::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback,response);
		}));
	}-*/;

	/**
	 * Called when method succeeded.
	 */
	protected static void callbackSuccess(AsyncCallback<JavaScriptObject> callback, JavaScriptObject obj) {
		callback.onSuccess(obj);
	}

	/**
	 * @author brianhenry
	 * @see https://developers.facebook.com/docs/reference/javascript/FB.Canvas.getPageInfo/
	 */
	public static class PageInfo extends JavaScriptObject {

		protected PageInfo() {
		}

		/**
		 * @return The height of the viewport in pixels
		 */
		public final native int getClientHeight() /*-{
			return this.clientHeight;
		}-*/;

		/**
		 * @return The width of the viewport in pixels
		 */
		public final native int getClientWidth() /*-{
			return this.clientWidth;
		}-*/;

		/**
		 * @return The number of pixels between the left edge of the viewport and the left edge of your app's iframe
		 */
		public final native int getOffsetLeft() /*-{
			return this.offsetLeft;
		}-*/;

		/**
		 * @return The number of pixels between the top edge of the viewport and the top edge of your app's iframe
		 */
		public final native int getOffsetTop() /*-{
			return this.offsetTop;
		}-*/;

		/**
		 * @return The number of pixels between the left edge of your iframe and the left edge of your iframe's viewport
		 */
		public final native int getScrollLeft() /*-{
			return this.scrollLeft;
		}-*/;

		/**
		 * @return The number of pixels between the top edge of your iframe and the top edge of your iframe's viewport
		 */
		public final native int getScrollTop() /*-{
			return this.scrollTop;
		}-*/;

	}
}
