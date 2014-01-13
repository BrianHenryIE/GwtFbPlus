package ie.sortons.gwtfbplus.client.widgets.buttons;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.CustomButton;
import com.google.gwt.user.client.ui.Image;

public class XableButton extends CustomButton {

	Resources resources = Resources.INSTANCE;

	public XableButton() {
		getUpFace().setImage(new Image(resources.xNormal()));
		getUpHoveringFace().setImage(new Image(resources.xHover()));
		getDownFace().setImage(new Image(resources.xDown()));
		getElement().getStyle().setPadding(3, Unit.PX);
	}

	public interface Resources extends ClientBundle {

		public static final Resources INSTANCE = GWT.create(Resources.class);

		@Source("xableup.png")
		ImageResource xNormal();

		@Source("xablehover.png")
		ImageResource xHover();

		@Source("xabledown.png")
		ImageResource xDown();

	}

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
}
