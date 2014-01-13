package ie.sortons.gwtfbplus.client.widgets.buttons;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.user.client.ui.CustomButton;

public class FbButton extends CustomButton {

	Resources resources = Resources.INSTANCE;

	public interface Resources extends ClientBundle {

		public interface Style extends CssResource {
		}

		public static final Resources INSTANCE = GWT.create(Resources.class);

		@Source("buttons.css")
		Style css();

		@Source("greybuttonbackground.png")
		DataResource greyButtonBackgroundImage();

		@Source("bluebuttonbackground.png")
		DataResource blueButtonBackgroundImage();

		@Source("greenbuttonbackground.png")
		DataResource greenButtonBackgroundImage();

	}

	{
		Resources.INSTANCE.css().ensureInjected();
		
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

	public FbButton(String text) {
		setText(text);
	}
}
