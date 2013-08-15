package ie.sortons.gwtfbplus.client.newresources;



import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {

	public static final Resources INSTANCE = GWT.create(Resources.class); 

	@Source("style.css")
	@CssResource.NotStrict
	CssResource css();

	@Source("gwtfbplus.css")
	@CssResource.NotStrict
	CssResource newCss();


	@Source("map_pushpin.png")
	ImageResource mapPushPin();
	
	@Source("loading.gif")
	ImageResource loadingAnimation();

}