package ie.sortons.gwtfbplus.client.widgets.buttons;

import com.google.gwt.core.client.GWT;

public class BlueButton extends CanDisableButton {
	
	interface Resources extends SoButtonBase.TextButtonResources {
		
		interface Style extends TextButtonStyle { }
		
		@Source("bluebutton.css")
		Style style();
		
		Resources INSTANCE = GWT.create(Resources.class);
	}
	
	public BlueButton() {
		super(Resources.INSTANCE);
	}
	
	public BlueButton(String text) {
		this();
		setText(text);
	}
}


