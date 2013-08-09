package ie.sortons.gwtfbplus.client.widgets.datepicker;

import ie.sortons.gwtfbplus.client.widgets.datepicker.DayPicker;

import java.util.Date;

import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.datepicker.client.DatePicker;


// Very thin wrapper around DatePicker widget. 
// returns selected date in textual format 
// (suitable for sending to the server)
// rather than a Date object.
// In future we could replace this with our own snazzy daypicker widget.
// more immediatley we can expose some methods to disable/style 
// dates based on service data etc.
//public class DayPicker extends Composite implements HasValueChangeHandlers<String>, HasValue<String> {
public class DayPicker extends Composite implements HasValueChangeHandlers<Date>, HasValue<Date> {
	
	
	public static class DatePopup extends PopupPanel {
		
		public DatePopup(String styleParam, final ValueChangeHandler<Date> cb) {
			super(true);
			this.setAnimationEnabled(false);
			this.setAutoHideOnHistoryEventsEnabled(true);
			this.setStyleName("");
			DayPicker dp = new DayPicker();
			dp.setStylePrimaryName(styleParam);
			setWidget(dp);
			dp.addValueChangeHandler(new ValueChangeHandler<Date>(){
				@Override
				public void onValueChange(ValueChangeEvent<Date> event) {
					cb.onValueChange(event);
					DatePopup.this.hide();
					
				}});
		}
	}
	
	
	private DatePicker widget;
	
	public DayPicker() {
		widget = new DatePicker();
		widget.addValueChangeHandler(new ValueChangeHandler<Date>(){ 
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date d = event.getValue();
				
				ValueChangeEvent.fire(DayPicker.this, d);
			}});
		initWidget(widget);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<Date> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public Date getValue() {
		return widget.getValue();

	}

	@Override
	public void setValue(Date value) {
		setValue(value, false);
	}

	@Override
	public void setValue(Date value, boolean fireEvents) {
		// TODO create a Date() object at 12 noon on the given day.
		//Date d = new Date();
	}
}
