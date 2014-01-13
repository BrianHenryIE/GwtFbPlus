package ie.sortons.gwtfbplus.client.widgets.buttons;

import com.google.gwt.uibinder.client.UiConstructor;

public class GreenButton extends FbButton {

	@UiConstructor
	public GreenButton(String text) {
		super(text);
		this.setStylePrimaryName("Green-Button");
	}
}
