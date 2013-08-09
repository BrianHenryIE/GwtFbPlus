package ie.sortons.gwtfbplus.client.widgets.buttons;

import com.google.gwt.core.client.GWT;

public class GreenButton extends CanDisableButton {
	
	interface Resources extends SoButtonBase.TextButtonResources {
		
		interface Style extends TextButtonStyle { }
		
		@Source("greenbutton.css")
		Style style();
		
		Resources INSTANCE = GWT.create(Resources.class);
	}
	
	public GreenButton() {
		super(Resources.INSTANCE);
	}
	
	public GreenButton(String text) {
		this();
		setText(text);
	}
}


