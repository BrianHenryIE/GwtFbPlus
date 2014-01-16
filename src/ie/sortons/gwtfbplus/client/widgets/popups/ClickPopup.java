package ie.sortons.gwtfbplus.client.widgets.popups;

import ie.sortons.gwtfbplus.client.widgets.buttons.BlueButton;
import ie.sortons.gwtfbplus.client.widgets.buttons.GreyButton;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class ClickPopup extends PopupPanel {

	Resources resources = Resources.INSTANCE;

	GreyButton cancelButton = new GreyButton("Cancel");
	BlueButton okButton = new BlueButton("OK");
	
	FlowPanel panel = new FlowPanel();
	Label heading;
	SimplePanel content= new SimplePanel();
	SimplePanel messagePanel = new SimplePanel();
	FlowPanel buttons = new FlowPanel();

	public ClickPopup(String title, SimplePanel content) {
		
		heading = new Label(title);
		heading = new Label(title);
		content.add(content);
		
		setup();
	}
	
	public ClickPopup(String title, Label message) {

		heading = new Label(title);
		messagePanel.add(message);
		content.add(messagePanel);

		setup();
	}
	
	private void setup() {
		setStylePrimaryName("Click");
		setGlassStyleName("Click-Glass");
		setModal(true);
		center();
		Resources.INSTANCE.css().ensureInjected();
		
		buttons.setStyleName(resources.css().clickButtons());
		okButton.getElement().getStyle().setMarginLeft(10, Unit.PX);

		buttons.add(cancelButton);
		buttons.add(okButton);
		
		panel.add(heading);
		panel.add(content);
		panel.add(buttons);
		
		heading.setStyleName(resources.css().clickHeading());
		content.setStyleName(resources.css().clickBody());
		messagePanel.setStyleName(resources.css().clickContent());
				
		setWidget(panel);
	}
	
	
	@Override
	public void show() {
		super.show();
		center();
	}

	public BlueButton getOkButton() {
		return okButton;
	}
	
	public GreyButton getCancelButton() {
		return cancelButton;
	}
	
	public void setMessage(Label message){
		messagePanel.setWidget(message);
		content.setWidget(messagePanel);
	}
	
	public void setContent(Panel content) {
		content.clear();
		content.add(content);
	}
}
