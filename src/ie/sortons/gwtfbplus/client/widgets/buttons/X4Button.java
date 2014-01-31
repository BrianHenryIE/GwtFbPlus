package ie.sortons.gwtfbplus.client.widgets.buttons;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.ui.CustomButton;
import com.google.gwt.user.client.ui.Image;

public class X4Button extends CustomButton {


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

	public X4Button() {
		getUpFace().setImage(new Image(resources.x4Up()));
		getUpHoveringFace().setImage(new Image(resources.x4Hover()));
		getDownFace().setImage(new Image(resources.x4Down()));
		this.getElement().getStyle().setCursor(Cursor.POINTER);
	}

}
