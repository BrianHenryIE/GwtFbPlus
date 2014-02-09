package ie.sortons.gwtfbplus.client.widgets.suggestbox;

import ie.sortons.gwtfbplus.client.widgets.buttons.X2Button;

import java.util.List;

import com.google.gwt.dom.client.Style.OutlineStyle;
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
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestBox.DefaultSuggestionDisplay;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.TextBox;


// TODO
// Deal with removing items from the searchable items once they get placed in the selected list
public class FbSingleSuggestbox extends Composite implements HasValueChangeHandlers<FbSearchable>, HasValue<FbSearchable> {

	private SimplePanel outerPanel = new SimplePanel();

	private Oracle oracle = new Oracle();

	private SimplePanel predictorContainer = new SimplePanel();
	private SuggestBox predictor = new SuggestBox(oracle);

	private FbSearchable value;

	SuggestboxResources resources = SuggestboxResources.INSTANCE;

	private HandlerRegistration showSelectedHandler;

	public FbSingleSuggestbox(List<FbSearchable> itemsToSearch, String prompt) {
		
		oracle.setSearchItems(itemsToSearch);
		predictor.removeStyleName("gwt-SuggestBox");
		
		((DefaultSuggestionDisplay) predictor.getSuggestionDisplay()).setPopupStyleName(resources.css().suggestBoxPopup());

		initWidget(outerPanel);

		predictorContainer.getElement().getStyle().setMargin(3, Unit.PX);
		predictorContainer.add(predictor);

		((DefaultSuggestionDisplay) predictor.getSuggestionDisplay()).setPositionRelativeTo(this);

		outerPanel.add(predictorContainer);

		predictor.getValueBox().getElement().setPropertyString("placeholder", prompt);
		resources.css().ensureInjected();

		this.setStyleName(resources.css().singleBox());

		predictor.addSelectionHandler(new SelectionHandler<Suggestion>() {
			@Override
			public void onSelection(SelectionEvent<Suggestion> event) {
				setValue(((FbSuggestion) event.getSelectedItem()).getObject(), true);
			}
		});

		this.getElement().getStyle().setWidth(300, Unit.PX);
	}

	public void clear(){
		value = null;
		outerPanel.setWidget(predictorContainer);
		predictor.setValue("");
	}
	
	public void setSuggestions(List<FbSearchable> suggestions){
		oracle.clear();
		oracle.addAll(suggestions);
	}
	
	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<FbSearchable> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public FbSearchable getValue() {
		return value;
	}

	@Override
	public void setValue(FbSearchable value) {
		this.value = value;
		if (showSelectedHandler != null)
			setSelectedItemWidget(value);
	}

	@Override
	public void setValue(FbSearchable value, boolean fireEvents) {
		this.value = value;
		if (showSelectedHandler != null)
			setSelectedItemWidget(value);
		if (fireEvents)
			ValueChangeEvent.fire(this, getValue());
	}

	// TODO Check this.
	/**
	 * If this is true, once an item is selected, it is displayed in the textbox with its image and a X button to remove
	 * it. Otherwise the title of the selected item is placed in the box and a custom ValueChangeHandler can be used to
	 * implement custom behaviour (i.e. probably clear it once it has been read).
	 * 
	 * @param showSelected
	 */
	public void showSelectedItem(boolean showSelected) {
		if (showSelected) {
			showSelectedHandler = predictor.addSelectionHandler(new SelectionHandler<Suggestion>() {
				@Override
				public void onSelection(SelectionEvent<Suggestion> event) {

					FbSearchable selectedOracle = ((FbSuggestion) event.getSelectedItem()).getObject();
					setSelectedItemWidget(selectedOracle);
				}
			});
		} else if (showSelectedHandler != null)
			showSelectedHandler.removeHandler();

	}

	private void setSelectedItemWidget(FbSearchable selectedOracle) {
		predictor.getValueBox().setValue("");

		final SelectedItem selectedItem = new SelectedItem(selectedOracle);

		// For clear (x) button
		selectedItem.getClearButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				outerPanel.setWidget(predictorContainer);
			}
		});

		// For backspace
		KeyDownHandler backspaceHandler = new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE) {
					predictor.getValueBox().setText(selectedItem.getTextBox().getText().substring(0, selectedItem.getTextBox().getText().length()));
					outerPanel.setWidget(predictorContainer);
					predictor.getValueBox().setFocus(true);
					predictor.getValueBox().setCursorPos(predictor.getValueBox().getText().length());
				}
			}
		};
		selectedItem.getTextBox().addKeyDownHandler(backspaceHandler);
		selectedItem.addKeyDownHandler(backspaceHandler);

		// For continuing to type
		selectedItem.getTextBox().addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				predictor.getValueBox().setText(selectedItem.getTextBox().getText() + event.getCharCode());
				outerPanel.setWidget(predictorContainer);
				predictor.getValueBox().setFocus(true);
				predictor.getValueBox().setCursorPos(predictor.getValueBox().getText().length());
			}
		});

		outerPanel.setWidget(selectedItem);

		selectedItem.setFocus(true);
	}

	private static class SelectedItem extends Composite implements Focusable, HasKeyDownHandlers {

		FocusPanel fp = new FocusPanel();
		DockLayoutPanel dp = new DockLayoutPanel(Unit.PX);

		final TextBox textBox = new TextBox();
		X2Button clearButton = new X2Button();

		SuggestboxResources resources = SuggestboxResources.INSTANCE;

		public SelectedItem(FbSearchable chosen) {
			fp.add(dp);
			initWidget(fp);

			resources.css().ensureInjected();
			dp.setStyleName(resources.css().singleSelected());

			fp.getElement().getStyle().setHeight(20, Unit.PX);
			dp.getElement().getStyle().setHeight(100, Unit.PCT);

			Image pic = new Image("//graph.facebook.com/" + chosen.getUid() + "/picture?type=square");

			pic.getElement().getStyle().setHeight(16, Unit.PX);
			pic.getElement().getStyle().setWidth(16, Unit.PX);
			pic.getElement().getStyle().setMargin(2, Unit.PX);

			dp.addWest(pic, 20);

			clearButton.getElement().getStyle().setMargin(5, Unit.PX);

			dp.addEast(clearButton, 20);

			textBox.setValue(chosen.getTitle());
			textBox.setReadOnly(true);

			textBox.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					textBox.selectAll();
				}
			});

			pic.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					textBox.selectAll();
				}
			});

			dp.add(textBox);

			fp.getElement().getStyle().setOutlineStyle(OutlineStyle.NONE);

		}

		public X2Button getClearButton() {
			return clearButton;
		}

		public TextBox getTextBox() {
			return textBox;
		}

		@Override
		public int getTabIndex() {
			return fp.getTabIndex();
		}

		@Override
		public void setAccessKey(char key) {
			fp.setAccessKey(key);
		}

		@Override
		public void setFocus(boolean focused) {
			fp.setFocus(focused);
		}

		@Override
		public void setTabIndex(int index) {
			fp.setTabIndex(index);
		}

		@Override
		public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
			return fp.addKeyDownHandler(handler);
		}
	}
}
