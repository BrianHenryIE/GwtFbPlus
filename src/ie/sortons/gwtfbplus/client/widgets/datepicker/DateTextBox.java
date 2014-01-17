package ie.sortons.gwtfbplus.client.widgets.datepicker;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.shared.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;

public class DateTextBox extends TextBox {

	DatePickerResources dpResources = DatePickerResources.INSTANCE;

	DatePicker dp = new DatePicker();
	
	Date value = dp.getValue();
	
	PopupPanel popup = new PopupPanel();

	public DateTextBox() {

		dpResources.css().ensureInjected();

		setReadOnly(true);

		setStylePrimaryName("DateBox");

		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent e) {
				if (popup.isVisible())
					popup.showRelativeTo(DateTextBox.this);
				else
					popup.hide();
			}
		});

		dp.setStyleName(dpResources.css().fbStyleDatePicker());
		
		dp.addValueChangeHandler(new ValueChangeHandler<Date>() {
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				setText(event.getValue());
				value = event.getValue();
				popup.hide();
			}
		});
		
		popup.setWidget(dp);
		popup.setStyleName("");

	}

	public DatePicker getDatePicker() {
		return dp;
	}
	
	public void setValue(Date d) {
		dp.setValue(d);
		setText(d);
	}
	
	private void setText(Date value) {
		setText(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT).format(value));
	}
	
	// TODO 
	// Disable dates in past
}
