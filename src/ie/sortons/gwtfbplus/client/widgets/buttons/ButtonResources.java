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

	@Source("xableup.png")
	ImageResource xNormal();

	@Source("xablehover.png")
	ImageResource xHover();

	@Source("xabledown.png")
	ImageResource xDown();
}
