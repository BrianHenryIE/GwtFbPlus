package ie.sortons.gwtfbplus.client.widgets.datepicker;

import ie.sortons.gwtfbplus.client.widgets.datepicker.DateResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface DateResources extends ClientBundle {

	public static final DateResources INSTANCE = GWT.create(DateResources.class); 

	@Source("datebox.css")
	@CssResource.NotStrict
	CssResource dateboxCss();


}