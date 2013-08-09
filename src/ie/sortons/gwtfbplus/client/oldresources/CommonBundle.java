package ie.sortons.gwtfbplus.client.oldresources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface CommonBundle extends ClientBundle {
	
	public static final CommonBundle INSTANCE = GWT.create(CommonBundle.class); 
	
	@Source("common.css")
	Style style();
	
	public interface Style extends CssResource {
		public String bordered();
	}
	
}
