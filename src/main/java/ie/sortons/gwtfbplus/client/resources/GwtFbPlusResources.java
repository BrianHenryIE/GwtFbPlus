package ie.sortons.gwtfbplus.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
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
		
		String infoLabel();
		String errorLabel();
	}

	@Source("loading.gif")
	ImageResource loadingAnimation();

	@Source("smallloading.gif")
	ImageResource smallLoadingAnimation();

	@Source("redx.png")
	ImageResource redX();

	@Source("greenplus.png")
	ImageResource greenPlus();

}