package ie.sortons.gwtfbplus.client.widgets.buttons;

import com.google.gwt.core.client.GWT;

public class GreyButton extends CanDisableButton {
	
	interface Resources extends SoButtonBase.TextButtonResources {
		
		interface Style extends TextButtonStyle { }
		
		@Source("greybutton.css")
		Style style();
		
		Resources INSTANCE = GWT.create(Resources.class);
	}
	
	public GreyButton() {
		super(Resources.INSTANCE);
	}
	
	public GreyButton(String text) {
		this();
		setText(text);
	}
}


