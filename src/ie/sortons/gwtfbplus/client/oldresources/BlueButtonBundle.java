package ie.sortons.gwtfbplus.client.oldresources;

import com.google.gwt.core.client.GWT;

public interface BlueButtonBundle extends ButtonBundle {
	
	public BlueButtonBundle INSTANCE = GWT.create(BlueButtonBundle.class);
		
	public static interface Style extends ButtonBundle.Style {
		
	}
	
	@Source("bluebutton.css")
	@Override
	Style style();
}
