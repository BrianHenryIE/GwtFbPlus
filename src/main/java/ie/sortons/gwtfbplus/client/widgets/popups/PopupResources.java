package ie.sortons.gwtfbplus.client.widgets.popups;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface PopupResources extends ClientBundle {

	public static final PopupResources INSTANCE = GWT.create(PopupResources.class);

	@Source("popups.css")
	Style css();

	interface Style extends CssResource { 
		String leftNotch();
		String rightNotch();
		
		String clickHeading();
		String clickBody();
		String clickContent();
		String clickButtons();
	}
	

	@Source("questionmark.png")
	ImageResource questionMark();

}