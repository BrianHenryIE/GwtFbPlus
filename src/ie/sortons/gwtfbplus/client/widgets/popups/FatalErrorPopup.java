package ie.sortons.gwtfbplus.client.widgets.popups;

import ie.sortons.gwtfbplus.client.widgets.buttons.GreyButton;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.UmbrellaException;


public class FatalErrorPopup extends PopupPanel {

	private static ErrorPopupUiBinder uiBinder = GWT
			.create(ErrorPopupUiBinder.class);


	
	interface ErrorPopupUiBinder extends UiBinder<Widget, FatalErrorPopup> {
	}
	
	interface Styles extends CssResource { 
		String popup();
		String popupGlass();
	}
	
	private static final boolean DEBUG = true; // Whether to display exception message or generic message.
	
	@UiField
	Styles style;
		
	@UiField 
	HTML errorDetail;
	
	@UiField 
	GreyButton traceButton;

	private Throwable exception;
	
	@UiHandler("okButton")
	void onClick(ClickEvent e) {
		this.hide();
	}

	public FatalErrorPopup(Throwable e) {
		this.exception = e;
		this.setGlassEnabled(true);
		setWidget(uiBinder.createAndBindUi(this));
		this.setStyleName(style.popup());
		this.setGlassStyleName(style.popupGlass());
		if (DEBUG)
			setDebugMessage(e);
		else
			setGenericMessage();
	}
	
	private void setDebugMessage(Throwable e) {
		if (e instanceof UmbrellaException) {
			UmbrellaException umb = (UmbrellaException) e;
			String errors = "";
			for (Throwable t : umb.getCauses()) {
				errors =  errors + t.getMessage() + "<br/>";
			}
			errorDetail.setHTML(errors);
		//} else if (e instanceof ) {
		} else {
			errorDetail.setText(e.getMessage());
		}
	}
	
	private void setGenericMessage() {
		traceButton.getElement().getStyle().setDisplay(Display.NONE);
		errorDetail.setText("An unexpected error has occured, press Ok to reload the application");
	}
	
	
	@UiHandler("traceButton")
	void click(ClickEvent e) {
		//HTML trace = new HTML();
		TextArea trace = new TextArea();
		
		String traceString = stackTraceFromThrowable(exception);
		trace.setText(traceString);
		trace.setSize("460px", "400px");
		trace.setReadOnly(true);
		PopupPanel stackTracePopup = new PopupPanel();
		stackTracePopup.setAutoHideEnabled(true);
		stackTracePopup.setWidget(trace);
		stackTracePopup.setPopupPosition(0, 0);
		stackTracePopup.show();
	}
	
	// Recursively prints through any umbrella exceptions.
	private String stackTraceFromThrowable(Throwable t) {
		String st = "";
		
		if (t instanceof UmbrellaException) {
			UmbrellaException umb = (UmbrellaException ) t;
			for (Throwable cause : umb.getCauses()) {
				st = st +  "------\n" + stackTraceFromThrowable(cause);  
			}
		} else {
			st = t.getClass().getName() + ": " + t.getMessage();
			for (StackTraceElement ste : t.getStackTrace())
				st += "\n" + ste.toString();
		}
		return st;
	}
	
}
