package ie.sortons.gwtfbplus.client.oldresources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface ButtonBundle extends ClientBundle {
	
	public ButtonBundle INSTANCE = GWT.create(ButtonBundle.class);
	
	public static interface Style extends CssResource {
		String normal(); // Up face.
		String upHover();
		String selected(); // Down face
	}
	
	@Source("greybutton.css")
	Style style();
	
}
