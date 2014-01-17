package ie.sortons.gwtfbplus.client.widgets.buttons;

import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.CustomButton;

public class BlueButton extends CustomButton {

	{
		ButtonResources.INSTANCE.css().ensureInjected();
		
		addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				setDown(true);
			}
		});
		
		addMouseUpHandler(new MouseUpHandler() {
			@Override
			public void onMouseUp(MouseUpEvent event) {
				setDown(false);
			}
		});
	}
	
	@UiConstructor
	public BlueButton(String text) {
		super(text);
		this.setStylePrimaryName("Blue-Button");
	}
}
