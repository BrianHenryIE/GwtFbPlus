package ie.sortons.gwtfbplus.client.newresources;



import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {

	public static final Resources INSTANCE = GWT.create(Resources.class); 

	@Source("gwtfbplus.css")
	@CssResource.NotStrict
	Style css();
	
	public interface Style extends CssResource {
		String blueButton();
	}

	@Source("map_pushpin.png")
	ImageResource mapPushPin();
	
	@Source("loading.gif")
	ImageResource loadingAnimation();
	
	@Source("redx.png")
	ImageResource redX();
	
	@Source("greenplus.png")
	ImageResource greenPlus();
	
	@Source("BlueButtonBackgroundPixel.png")
	DataResource blueButtonBackgroundPixel();

}