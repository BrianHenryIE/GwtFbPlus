package ie.sortons.gwtfbplus.client.widgets.popups;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author brianhenry
 * 
 */
public class ToolTipPopup extends PopupPanel {

	PopupResources resources = PopupResources.INSTANCE;

	Widget target;

	private int offSetX;
	private int thisWidth = 0;
	private int horizontalPosition;

	public ToolTipPopup(String text, Widget target) {

		this.target = target;
		PopupResources.INSTANCE.css().ensureInjected();
		setWidget(new Label(text));
		setGlassEnabled(false);
		setStylePrimaryName("ToolTip");
	}

	@Override
	public void show() {

		super.show();

		if (thisWidth == 0)
			thisWidth = this.getOffsetWidth();

		int verticalPosition = target.getAbsoluteTop() - (getOffsetHeight() + 4);

		// Calculate horizontal position and add the notch
		if (target.getAbsoluteLeft() + thisWidth > Window.getClientWidth()) {
			this.addStyleName(resources.css().rightNotch());
			horizontalPosition = Math.min(target.getAbsoluteLeft() + target.getOffsetWidth() - thisWidth + (offSetX * -1), Window.getClientWidth());
		} else {
			this.addStyleName(resources.css().leftNotch());
			horizontalPosition = Math.max(target.getAbsoluteLeft() + offSetX, 0);
		}

		setPopupPosition(horizontalPosition, verticalPosition);

		super.show();
	}

	public void setText(String text) {
		setWidget(new Label(text));
	}

	/**
	 * Allows the popup to be positioned precisely to allow for positioning the notch above items. Multiplies the offset
	 * by -1 when the notch is calculated to be placed on the right.
	 * 
	 * @param pixels
	 */
	public void setOffsetX(int pixels) {
		offSetX = pixels;
	}

}
