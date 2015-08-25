package ie.sortons.gwtfbplus.client.widgets;

import com.google.gwt.dom.client.IFrameElement;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

import ie.sortons.gwtfbplus.client.api.FBXfbml;

public class EmbeddedPost extends Composite {

	SimplePanel panel = new SimplePanel();
	String postUrl;
	IFrameElement post;

	Command cb;

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
		panel.getElement().setInnerHTML(
				"<div class=\"fb-post\" data-href=\"" + postUrl + "\" data-width=\"" + width + "\"></div>");
		panel.getElement().setId(generateId());
	}

	public EmbeddedPost(String postUrl, int width, Command cb) {
		this(postUrl, width);
		this.cb = cb;
	}

	@Override
	protected void onAttach() {
		super.onAttach();

		if (cb == null)
			FBXfbml.parse(this);
		else
			FBXfbml.parse(this, cb);

	}

	private static int idNumber = 0;

	private static String generateId() {
		idNumber++;
		return "embeddedPost-" + idNumber;
	}

}
