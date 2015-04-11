package ie.sortons.gwtfbplus.client.widgets.suggestbox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface SuggestboxResources extends ClientBundle {

	public static SuggestboxResources INSTANCE = GWT.create(SuggestboxResources.class);

	public interface Style extends CssResource {
		
		public String singleBox();
		public String multiBox();
		
		public String suggestBoxPopup();
		
		public String singleSelected();
		
		public String xableListItem();
		public String xableButton();
	}

	@Source("suggestbox.css")
	Style css();

}
