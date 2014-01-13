package ie.sortons.gwtfbplus.client.widgets.buttons;

import com.google.gwt.uibinder.client.UiConstructor;

public class BlueButton extends FbButton {

	@UiConstructor
	public BlueButton(String text) {
		super(text);
		this.setStylePrimaryName("Blue-Button");
	}
}
