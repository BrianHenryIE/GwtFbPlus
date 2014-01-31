package ie.sortons.gwtfbplus.client.widgets.buttons;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.ui.CustomButton;
import com.google.gwt.user.client.ui.Image;

public class X1Button extends CustomButton {


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

	public X1Button() {
		getUpFace().setImage(new Image(resources.x1Up()));
		getUpHoveringFace().setImage(new Image(resources.x1Hover()));
		getDownFace().setImage(new Image(resources.x1Down()));
		getElement().getStyle().setPadding(3, Unit.PX);
		this.getElement().getStyle().setCursor(Cursor.POINTER);
	}

}
