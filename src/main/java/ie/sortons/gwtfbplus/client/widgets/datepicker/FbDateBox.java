package ie.sortons.gwtfbplus.client.widgets.datepicker;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.datepicker.client.DateBox;

public class FbDateBox extends DateBox {

	DatePickerResources dpResources = DatePickerResources.INSTANCE;

	public FbDateBox() {
	
		dpResources.css().ensureInjected();
		setStyleName("DateBox");
		
		getDatePicker().setStyleName(dpResources.css().fbStyleDatePicker());
		
		// TODO
		// This isn't localized
		// PredefinedFormat.DATE_SHORT isn't what it should be 
		setFormat(new DefaultFormat(DateTimeFormat.getFormat("d/M/yyyy")));
		
		getTextBox().setReadOnly(true);
		
	}

}

