package ie.sortons.gwtfbplus.client.widgets.datepicker;


import ie.sortons.gwtfbplus.client.widgets.datepicker.DayPickerSmallResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface DayPickerSmallResources extends ClientBundle {

	public static DayPickerSmallResources INSTANCE = GWT.create(DayPickerSmallResources.class); 

	public interface Style extends CssResource {
		public String fbStyleDatePicker();
	}
	
	@Source("daypicker.css")
	Style style();
	
	
	
}
