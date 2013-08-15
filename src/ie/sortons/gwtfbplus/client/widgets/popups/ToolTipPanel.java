package ie.sortons.gwtfbplus.client.widgets.popups;

import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
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

	public ToolTipPanel(final String tipText, final Widget widget) {

		// Puts the other widget inside this one.
		this.add(widget);
		thePopup = new ToolTipPopup(tipText, widget);

		this.addMouseOverHandler(new MouseOverHandler(){
			@Override
			public void onMouseOver(MouseOverEvent event) {
				thePopup.show();
				thePopup.showRelativeTo(widget);
			}
		});

		this.addMouseOutHandler(new MouseOutHandler(){
			@Override
			public void onMouseOut(MouseOutEvent event) {
				thePopup.hide();
			}
		}); 	
	}

	public ToolTipPopup getPopUp(){
		return thePopup;
	}


}
