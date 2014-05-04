package ie.sortons.gwtfbplus.client.resources.map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface MapResources extends ClientBundle {

	public static final MapResources INSTANCE = GWT.create(MapResources.class);

	@Source("map.css")
	Style css();

	public interface DefaultStyle extends CssResource {
	}
	
	public interface Style extends CssResource {
		
		String leftOverMap();
		String rightOverMap();
		String bottomOverMap();

		String mapZoomControls();
		String mapZoomButton();
		String mapZoomButtonUp();
		String mapZoomButtonDown();

	}

	@Source("mappushpin.png")
	ImageResource mapPushPin();

	@Source("zoomin.png")
	ImageResource zoomInButton();

	@Source("zoomout.png")
	ImageResource zoomOutButton();

	@Source("mapControlButtonBackground.png")
	ImageResource mapControlButtonBackground();
	
	@Source("mapControlButtonBackgroundPressed.png")
	ImageResource mapControlButtonBackgroundPressed();
	

}