package ie.sortons.gwtfbplus.client.widgets;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

// from the internet!
public class Link extends SimplePanel {
	
	public Link(String href, Widget widget) {
		super(DOM.createAnchor());
		setHref(href);
		this.add(widget);
	}
	
	public Link(String href, Widget widget, String target) {
		super(DOM.createAnchor());
		setHref(href);
		this.add(widget);
		setTarget(target);
	}

	public void setHref(String href) {
		getElement().setAttribute("href", href);
	}

	public String getHref() {
		return getElement().getAttribute("href");
	}

	// _blank
	public void setTarget(String frameName) {
		getElement().setAttribute("target", frameName);
	}
}