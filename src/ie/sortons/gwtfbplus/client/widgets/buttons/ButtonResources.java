package ie.sortons.gwtfbplus.client.widgets.buttons;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;

public interface ButtonResources extends ClientBundle {

	public interface Style extends CssResource {
		// Everything is @External
	}

	public static final ButtonResources INSTANCE = GWT.create(ButtonResources.class);

	@Source("buttons.css")
	Style css();

	@Source("greybuttonbackground.png")
	DataResource greyButtonBackgroundImage();

	@Source("bluebuttonbackground.png")
	DataResource blueButtonBackgroundImage();

	@Source("greenbuttonbackground.png")
	DataResource greenButtonBackgroundImage();

	@Source("x1up.png")
	ImageResource x1Up();

	@Source("x1hover.png")
	ImageResource x1Hover();

	@Source("x1down.png")
	ImageResource x1Down();

	@Source("x2up.png")
	ImageResource x2Up();

	@Source("x2hover.png")
	ImageResource x2Hover();

	@Source("x2down.png")
	ImageResource x2Down();
	
	@Source("x3up.png")
	ImageResource x3Up();

	@Source("x3hover.png")
	ImageResource x3Hover();

	@Source("x3down.png")
	ImageResource x3Down();
	
	@Source("x4up.png")
	ImageResource x4Up();

	@Source("x4hover.png")
	ImageResource x4Hover();

	@Source("x4down.png")
	ImageResource x4Down();
}
