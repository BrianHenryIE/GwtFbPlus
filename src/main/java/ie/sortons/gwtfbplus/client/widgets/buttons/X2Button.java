package ie.sortons.gwtfbplus.client.widgets.buttons;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.ui.CustomButton;
import com.google.gwt.user.client.ui.Image;

public class X2Button extends CustomButton {


	{		
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
	
	ButtonResources resources = ButtonResources.INSTANCE;

	public X2Button() {
		getUpFace().setImage(new Image(resources.x2Up()));
		getUpHoveringFace().setImage(new Image(resources.x2Hover()));
		getDownFace().setImage(new Image(resources.x2Down()));
		this.getElement().getStyle().setCursor(Cursor.POINTER);
	}

}
