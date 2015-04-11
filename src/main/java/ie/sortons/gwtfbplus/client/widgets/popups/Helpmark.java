package ie.sortons.gwtfbplus.client.widgets.popups;

import com.google.gwt.user.client.ui.Image;

public class Helpmark extends ToolTipPanel {

	static PopupResources resources = PopupResources.INSTANCE;

	public Helpmark(String toolTipText) {
		super(toolTipText, new Image(resources.questionMark()));
		getPopUp().setOffsetX(-4);
	}
}
