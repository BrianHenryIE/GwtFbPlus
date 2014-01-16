package ie.sortons.gwtfbplus.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;

public interface GwtFbPlusResources extends ClientBundle {

	public static final GwtFbPlusResources INSTANCE = GWT.create(GwtFbPlusResources.class);

	@Source("facebook.css")
	@CssResource.NotStrict
	DefaultStyle facebookStyles();

	@Source("gwtfbplus.css")
	Style css();

	public interface DefaultStyle extends CssResource {
	}
	
	public interface Style extends CssResource {
		String helpMark();
		String infoLabel();
	}

	@Source("mappushpin.png")
	ImageResource mapPushPin();

	@Source("loading.gif")
	ImageResource loadingAnimation();

	@Source("redx.png")
	ImageResource redX();

	@Source("greenplus.png")
	ImageResource greenPlus();

	@Source("questionmark.png")
	DataResource questionMark();
}