package ie.sortons.gwtfbplus.client.widgets.suggestbox;

import ie.sortons.gwtfbplus.client.widgets.suggestbox.Oracle.FbSearchable;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestBox.DefaultSuggestionDisplay;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;

public class FbMultiSuggestBox extends Composite implements HasValueChangeHandlers<List<FbSearchable>>, HasValue<List<FbSearchable>> {

	private static Oracle oracle = new Oracle();
	
	private FlowPanel outerPanel = new FlowPanel();

	private SimplePanel predictorContainer = new SimplePanel();
	private SuggestBox predictor = new SuggestBox(oracle);

	private List<FbSearchable> value = new ArrayList<FbSearchable>();

	SuggestboxResources resources = SuggestboxResources.INSTANCE;

	public FbMultiSuggestBox(List<FbSearchable> itemsToSearch, String prompt) {
		
		oracle.setSearchItems(itemsToSearch);
		predictor.removeStyleName("gwt-SuggestBox");
		
		((DefaultSuggestionDisplay) predictor.getSuggestionDisplay()).setPopupStyleName(resources.css().suggestBoxPopup());

		initWidget(outerPanel);

		predictorContainer.getElement().getStyle().setMargin(3, Unit.PX);
		predictorContainer.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		predictorContainer.add(predictor);

		((DefaultSuggestionDisplay) predictor.getSuggestionDisplay()).setPositionRelativeTo(this);

		outerPanel.add(predictorContainer);

		predictor.getValueBox().getElement().setPropertyString("placeholder", prompt);
		resources.css().ensureInjected();

		this.setStyleName(resources.css().multiBox());

		predictor.addSelectionHandler(new SelectionHandler<Suggestion>() {
			@Override
			public void onSelection(SelectionEvent<Suggestion> event) {
				addValue(((FbSuggestion) event.getSelectedItem()).getObject(), true);
				predictor.setValue("");
			}
		});

		this.getElement().getStyle().setWidth(400, Unit.PX);
	}

	public void clear() {
		value = null;
		refresh();
		predictor.setValue("");
	}

	public void refresh() {
		outerPanel.clear();
		outerPanel.remove(predictorContainer);
		for (final FbSearchable item : value) {
			outerPanel.add(new XableListItem(item, new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					value.remove(item);
					refresh();
				}
			}));
		}
		showPredictor();
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<List<FbSearchable>> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public List<FbSearchable> getValue() {
		return value;
	}

	@Override
	public void setValue(List<FbSearchable> value) {
		this.value = value;

	}

	@Override
	public void setValue(List<FbSearchable> value, boolean fireEvents) {
		this.value = value;
		if (fireEvents)
			ValueChangeEvent.fire(this, getValue());
	}

	public void addValue(final FbSearchable item, boolean fireEvents) {
		value.add(item);
		outerPanel.remove(predictorContainer);

		outerPanel.add(new XableListItem(item, new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				value.remove(item);
				refresh();
			}
		}));

		showPredictor();

		if (fireEvents)
			ValueChangeEvent.fire(this, getValue());
	}

	private void showPredictor() {
		// Set the width to a reasonable amount so it's never squashed on the right.
		predictorContainer.getElement().getStyle().setWidth(200, Unit.PX);

		outerPanel.add(predictorContainer);

		predictorContainer.getElement().getStyle()
				.setWidth(outerPanel.getOffsetWidth() - (predictorContainer.getAbsoluteLeft() - outerPanel.getAbsoluteLeft()) - 10, Unit.PX);
		predictor.getValueBox().setFocus(true);

	}
}
