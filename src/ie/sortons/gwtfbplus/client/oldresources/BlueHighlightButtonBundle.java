package ie.sortons.gwtfbplus.client.oldresources;

import com.google.gwt.core.client.GWT;

public interface BlueHighlightButtonBundle extends ButtonBundle {
	
	BlueHighlightButtonBundle INSTANCE = GWT.create(BlueHighlightButtonBundle.class);

	public static interface Style extends ButtonBundle.Style {
		String normal(); // Up face.
		String upHover();
		String selected(); // Down face
	}
	
	@Source("bluehighlightbutton.css")
	@Override
	Style style();
}
