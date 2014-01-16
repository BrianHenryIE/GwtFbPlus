package ie.sortons.gwtfbplus.client.widgets.popups;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface Resources extends ClientBundle {

	public static final Resources INSTANCE = GWT.create(Resources.class);

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

}