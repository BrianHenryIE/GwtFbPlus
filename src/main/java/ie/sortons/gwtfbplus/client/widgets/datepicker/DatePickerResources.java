package ie.sortons.gwtfbplus.client.widgets.datepicker;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;

public interface DatePickerResources extends ClientBundle {

	public static DatePickerResources INSTANCE = GWT.create(DatePickerResources.class); 

	public interface Style extends CssResource {
		public String fbStyleDatePicker();
	}
	
	@Source("datepicker.css")
	Style css();
	
	@Source("calendaricon.png")
	DataResource calendarIcon();

}
