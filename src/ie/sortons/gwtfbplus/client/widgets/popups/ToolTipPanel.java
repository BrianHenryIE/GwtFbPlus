package ie.sortons.gwtfbplus.client.widgets.popups;

import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Provides a container to handle mouseover events to show and hide
 * popup information 
 * 
 * @author brianhenry
 *
 */
public class ToolTipPanel extends FocusPanel {

	private ToolTipPopup thePopup;

	public ToolTipPanel(String text, Widget target) {

		this.add(target);
		thePopup = new ToolTipPopup(text, this);

	}

	public ToolTipPopup getPopUp(){
		return thePopup;
	}
	
}
