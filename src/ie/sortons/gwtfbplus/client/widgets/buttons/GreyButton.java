package ie.sortons.gwtfbplus.client.widgets.buttons;

import com.google.gwt.uibinder.client.UiConstructor;

public class GreyButton extends FbButton {

	@UiConstructor
	public GreyButton(String text) {
		super(text);
		this.setStylePrimaryName("Grey-Button");
	}
}
