package ie.sortons.gwtfbplus.client.widgets.suggestbox;

import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasKeyDownHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestBox.DefaultSuggestionDisplay;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.ValueBoxBase;

// TODO
// Deal with removing items from the searchable items once they get placed in the selected list
public class FbSingleSuggestbox extends Composite implements HasValueChangeHandlers<FbSearchable>, HasValue<FbSearchable>, HasKeyDownHandlers {

	private SimplePanel outerPanel = new SimplePanel();

	private Oracle oracle = new Oracle();

	private SimplePanel predictorContainer = new SimplePanel();
	private SuggestBox predictor = new SuggestBox(oracle);

	private FbSearchable selectedValue;

	// The widget that fills the container when an item has been selected
	SelectedItemWidget selectedItemWidget = new SelectedItemWidget();

	SuggestboxResources resources = SuggestboxResources.INSTANCE;

	private HandlerRegistration showSelectedHandler;

	public FbSingleSuggestbox(List<FbSearchable> itemsToSearch, String prompt, SelectedItemWidget selectedItemWidgetType) {
		this(itemsToSearch, prompt);
		this.selectedItemWidget = selectedItemWidgetType;
		showItemAfterSelection(true);
	}

	public FbSingleSuggestbox(List<FbSearchable> itemsToSearch, String prompt) {
		
		initWidget(outerPanel);
		resources.css().ensureInjected();

		oracle.setSearchItems(itemsToSearch);

		predictor.removeStyleName("gwt-SuggestBox");
		this.setStyleName(resources.css().singleBox());
		((DefaultSuggestionDisplay) predictor.getSuggestionDisplay()).setPopupStyleName(resources.css().suggestBoxPopup());
		
		
		
		

		predictorContainer.getElement().getStyle().setMargin(3, Unit.PX);
		predictorContainer.add(predictor);

		((DefaultSuggestionDisplay) predictor.getSuggestionDisplay()).setPositionRelativeTo(this);
		

		outerPanel.add(predictorContainer);

		predictor.getValueBox().getElement().setPropertyString("placeholder", prompt);

		predictor.addSelectionHandler(new SelectionHandler<Suggestion>() {
			@Override
			public void onSelection(SelectionEvent<Suggestion> event) {
				setValue(((FbSuggestionWidget) event.getSelectedItem()).getObject(), true);
			}
		});

		this.getElement().getStyle().setWidth(300, Unit.PX);
	}

	public void clear() {
		selectedValue = null;
		outerPanel.setWidget(predictorContainer);
		predictor.setValue("");
	}

	public void setSuggestions(List<FbSearchable> suggestions) {
		oracle.clear();
		oracle.addAll(suggestions);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<FbSearchable> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public FbSearchable getValue() {
		return selectedValue;
	}

	@Override
	public void setValue(FbSearchable value) {
		setValue(value, false);
	}

	@Override
	public void setValue(FbSearchable value, boolean fireEvents) {
		this.selectedValue = value;
		if (showSelectedHandler != null)
			addSelectedItemToDisplay(value, selectedItemWidget);
		if (fireEvents)
			ValueChangeEvent.fire(this, getValue());
	}

	public void setSelectedItemWidgetType(SelectedItemWidget selectedItem) {
		this.selectedItemWidget = selectedItem;
	}

	// TODO Check this.
	/**
	 * If this is true, once an item is selected, it is displayed in the textbox with its image and a X button to remove
	 * it. Otherwise the title of the selected item is placed in the box and a custom ValueChangeHandler can be used to
	 * implement custom behaviour (i.e. probably clear it once it has been read).
	 * 
	 * @param showSelected
	 */
	public void showItemAfterSelection(boolean showSelected) {
		if (showSelected) {
			showSelectedHandler = predictor.addSelectionHandler(new SelectionHandler<Suggestion>() {
				@Override
				public void onSelection(SelectionEvent<Suggestion> event) {
					addSelectedItemToDisplay(((FbSuggestionWidget) event.getSelectedItem()).getObject(), selectedItemWidget);
				}
			});
		} else if (showSelectedHandler != null)
			showSelectedHandler.removeHandler();
	}

	public void addSelectedItemToDisplay(FbSearchable value, final SelectedItemWidget selectedItemWidget) {
		predictor.getValueBox().setValue("");

		selectedItemWidget.setItem(selectedValue);

		// For clear (x) button
		selectedItemWidget.getClearButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				unSelectItem();
			}
		});

		// For backspace
		KeyDownHandler backspaceHandler = new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE) {
					predictor.getValueBox().setText(
							selectedItemWidget.getTextBox().getText().substring(0, selectedItemWidget.getTextBox().getText().length()));
					outerPanel.setWidget(predictorContainer);
					predictor.getValueBox().setFocus(true);
					predictor.getValueBox().setCursorPos(predictor.getValueBox().getText().length());
				}
			}
		};
		selectedItemWidget.getTextBox().addKeyDownHandler(backspaceHandler);
		selectedItemWidget.addKeyDownHandler(backspaceHandler);

		// For continuing to type
		selectedItemWidget.getTextBox().addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				predictor.getValueBox().setText(selectedItemWidget.getTextBox().getText() + event.getCharCode());
				outerPanel.setWidget(predictorContainer);
				predictor.getValueBox().setFocus(true);
				predictor.getValueBox().setCursorPos(predictor.getValueBox().getText().length());
			}
		});

		outerPanel.setWidget(selectedItemWidget);

		selectedItemWidget.setFocus(true);
	}

	public void removeFromOracle(FbSearchable value) {
		oracle.remove(value);
	}

	public void unSelectItem() {
		outerPanel.setWidget(predictorContainer);
		selectedValue = null;
	}

	@Override
	public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
		return predictor.addKeyDownHandler(handler);
	}

	public ValueBoxBase<String> getValueBox() {
		return predictor.getValueBox();
	}

}
