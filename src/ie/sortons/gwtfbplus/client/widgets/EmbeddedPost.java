package ie.sortons.gwtfbplus.client.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class EmbeddedPost extends Composite {

	/**
	 * @see https://developers.facebook.com/docs/plugins/embedded-posts/
	 * 
	 * @param postUrl The URL of the post to display. Must be public.
	 * @param width The width of the post, between 350 and 750.
	 */
	public EmbeddedPost(String postUrl, int width) {

		HTMLPanel hp = new HTMLPanel("<div class=\"fb-post\" data-href=\"" + postUrl + "\" data-width=\"" + width + "\"></div>");

		initWidget(hp);
	}

	
	/*
	 * The code below is supposedly needed but it seems initializing the JS SDK as GwtFb already does is adequate. 
	 * 
	
	
	
	@Override
	protected void onAttach() {
		super.onAttach();
		// EmbeddedPost.xfbml();
	}

	private static boolean injected = false;

	/**
	 * Ensures the xfbml script to build the embedded posts is attached. Should run automatically.
	 */
	/*
	public static void xfbml() {

		if (!injected) {

			ScriptInjector.fromString("		<script>(function(d, s, id) {" + "		  var js, fjs = d.getElementsByTagName(s)[0];"
					+ "		  if (d.getElementById(id)) return;" + "		  js = d.createElement(s); js.id = id;"
					+ "		  js.src = \"//connect.facebook.net/en_GB/all.js#xfbml=1&appId=346300752178533\";"
					+ "		  fjs.parentNode.insertBefore(js, fjs);" + "		}(document, 'script', 'facebook-jssdk'));</script>");
		}

	}
	*/
}
