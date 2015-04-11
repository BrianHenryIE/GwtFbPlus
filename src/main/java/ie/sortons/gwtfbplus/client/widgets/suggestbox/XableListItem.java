package ie.sortons.gwtfbplus.client.widgets.suggestbox;


import ie.sortons.gwtfbplus.client.widgets.buttons.X4Button;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.SimplePanel;

public class XableListItem extends Composite implements HasText, HasClickHandlers {

	private FlowPanel panel = new FlowPanel();
	private InlineLabel textSpan;
	private SimplePanel buttonContainer = new SimplePanel();
	private X4Button removeButton = new X4Button();
	

	private FbSearchable selectedItem;

	SuggestboxResources resources = SuggestboxResources.INSTANCE;

	public XableListItem(FbSearchable selectedItem) {
		
		// Store the reference to the object we care about.
		this.selectedItem = selectedItem;
		
		textSpan = new InlineLabel(selectedItem.getTitle());
		
		resources.css().ensureInjected();
		
		panel.setStylePrimaryName(resources.css().xableListItem());
		buttonContainer.setStylePrimaryName(resources.css().xableButton());
				
		panel.add(textSpan);
		buttonContainer.add(removeButton);
		panel.add(buttonContainer);
		
		initWidget(panel);
	}
	
	public XableListItem(FbSearchable selectedItem, ClickHandler handler) {
		this(selectedItem);
		addClickHandler(handler);
	}
		
	
	public FbSearchable getMainObject(){
		return selectedItem;
	}

	@Override
	public void setText(String text) {
		textSpan.setText(text);
	}

	@Override
	public String getText() {
		return textSpan.getText();
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return removeButton.addClickHandler(handler);
	}
}
