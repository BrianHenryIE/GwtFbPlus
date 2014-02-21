package ie.sortons.gwtfbplus.client.widgets.suggestbox;

import ie.sortons.gwtfbplus.client.widgets.buttons.X2Button;

import com.google.gwt.dom.client.Style.OutlineStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasKeyDownHandlers;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;

public class SelectedItemWidget extends Composite implements Focusable, HasKeyDownHandlers {

	protected FocusPanel fp = new FocusPanel();
	DockLayoutPanel dp = new DockLayoutPanel(Unit.PX);

	protected final TextBox textBox = new TextBox();

	protected SimplePanel eastContainer = new SimplePanel();
	protected X2Button clearButton = new X2Button();

	protected SuggestboxResources resources = SuggestboxResources.INSTANCE;

	Image pic = new Image();

	public FbSearchable selectedFbSearchable;

	public FbSearchable getSelectedFbSearchable() {
		return selectedFbSearchable;
	}

	public SelectedItemWidget(FbSearchable selectedFbSearchable) {
		this();
		setItem(selectedFbSearchable);
	}

	public void setItem(FbSearchable selectedFbSearchable) {
		pic.setUrl("//graph.facebook.com/" + selectedFbSearchable.getUid() + "/picture?type=square");
		textBox.setValue(selectedFbSearchable.getTitle());
	}

	public SelectedItemWidget() {
		fp.add(dp);
		initWidget(fp);

		resources.css().ensureInjected();
		dp.setStyleName(resources.css().singleSelected());

		fp.getElement().getStyle().setHeight(20, Unit.PX);
		dp.getElement().getStyle().setHeight(100, Unit.PCT);

		pic.getElement().getStyle().setHeight(16, Unit.PX);
		pic.getElement().getStyle().setWidth(16, Unit.PX);
		pic.getElement().getStyle().setMargin(2, Unit.PX);

		dp.addWest(pic, 20);

		clearButton.getElement().getStyle().setMargin(5, Unit.PX);
		eastContainer.add(clearButton);
		dp.addEast(eastContainer, 25);

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
