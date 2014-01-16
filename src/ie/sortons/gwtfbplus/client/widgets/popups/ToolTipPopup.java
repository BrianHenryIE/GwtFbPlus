package ie.sortons.gwtfbplus.client.widgets.popups;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class ToolTipPopup extends PopupPanel {

	Resources resources = Resources.INSTANCE;

	Widget target;

	public ToolTipPopup(String text, Widget target) {

		this.target = target;
		Resources.INSTANCE.css().ensureInjected();
		setWidget(new Label(text));
		setGlassEnabled(false);
		setStylePrimaryName("ToolTip");
		
	}

	@Override
	public void show() {

		super.show();

		int verticalPosition = target.getAbsoluteTop() - (getOffsetHeight() + 4);
		int horizontalPosition = 0;

		// Calculate horizontal position and add the notch 
		if (target.getAbsoluteLeft() + this.getOffsetWidth() + 5 >= Window.getClientWidth()) { // or windowWidth/2 ? {

			this.addStyleName(resources.css().rightNotch());
			horizontalPosition = Window.getClientWidth() - this.getOffsetWidth();	
		} else {
			this.addStyleName(resources.css().leftNotch());
			horizontalPosition = this.getAbsoluteLeft();
		}
		
		setPopupPosition(horizontalPosition, verticalPosition);
	}

	public void setText(String text) {
		setWidget(new Label(text));
	}

}
