package ie.sortons.gwtfbplus.client.widgets;

import com.google.gwt.core.client.Callback;
import com.google.gwt.dom.client.IFrameElement;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.gwtfb.sdk.FBXfbml;

public class EmbeddedPost extends Composite {

	SimplePanel panel = new SimplePanel();
	String postUrl;
	IFrameElement post;

	Callback<String, String> visibleCb;

	/**
	 * @see https://developers.facebook.com/docs/plugins/embedded-posts/
	 * 
	 * @param postUrl
	 *            The URL of the post to display. Must be public.
	 * @param width
	 *            The width of the post, between 350 and 750.
	 */
	public EmbeddedPost(String postUrl, int width) {
		this.postUrl = postUrl;
		initWidget(panel);
		panel.add(new HTMLPanel("<div class=\"fb-post\" data-href=\"" + postUrl + "\" data-width=\"" + width + "\"></div>"));
	}

	public EmbeddedPost(String postUrl, int width, Callback<String, String> visibleCb) {
		this(postUrl, width);
		this.visibleCb = visibleCb;
	}

	@Override
	protected void onAttach() {
		super.onAttach();

		// TODO
		// What happens here when fbinit hasn't been called?
		FBXfbml.parse();

		post = panel.getWidget().getElement().getFirstChildElement().getFirstChildElement().getFirstChildElement().cast();

		// There's no event for visibility being changed (which we'll use as an indicator that it's finished loading)
		// so here's a horrible timer.
		if (visibleCb != null)
			checkVisibility.run();

	}

	Timer checkVisibility = new Timer() {
		@Override
		public void run() {
			if (post.getStyle().getVisibility().equals("visible"))			
				visibleCb.onSuccess(postUrl);
			else
				checkVisibility.schedule(200);
		}
	};

	// stuff below probably needed for sites that haven't called fbcore.init
	// * private static boolean injected = false;

	// Ensures the xfbml script to build the embedded posts is attached. Should run automatically
	/*
	 * public static void xfbml() {
	 * 
	 * // if (!injected) {
	 * 
	 * ScriptInjector.fromString("		<script>(function(d, s, id) {" + "		  var js, fjs = d.getElementsByTagName(s)[0];" +
	 * "		  if (d.getElementById(id)) return;" + "		  js = d.createElement(s); js.id = id;" +
	 * "		  js.src = \"//connect.facebook.net/en_GB/all.js#xfbml=1&appId=346300752178533\";" +
	 * "		  fjs.parentNode.insertBefore(js, fjs);" + "		}(document, 'script', 'facebook-jssdk'));</script>"); //}
	 * 
	 * }
	 */
}
