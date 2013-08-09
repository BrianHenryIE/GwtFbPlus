package ie.sortons.gwtfbplus.client.widgets.popups;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;


public class ToolTipPopup extends PopupPanel {

	private static ErrorPopupUiBinder uiBinder = GWT
			.create(ErrorPopupUiBinder.class);

	FocusPanel target;
	
	interface ErrorPopupUiBinder extends UiBinder<Widget, ToolTipPopup> {
	}
	
	interface Styles extends CssResource { 
		String popup();
		String popupGlass();
		String panel();
		String leftNotch();
		String rightNotch();
	}
	
	@UiField
	Styles style;

	@UiField
	Label tipText;

	public ToolTipPopup(String text, final FocusPanel target) {
		
		this.target = target;
		
		setWidget(uiBinder.createAndBindUi(this));

		this.setGlassEnabled(false);
		
		this.setStyleName(style.popup());
		
		tipText.setText(text);
		
		this.showRelativeTo(target);
	
		target.addMouseOverHandler(new MouseOverHandler(){
			@Override
			public void onMouseOver(MouseOverEvent event) {
				System.out.println("showing popup: " + tipText);
				ToolTipPopup.this.show();
				ToolTipPopup.this.showRelativeTo(target);
			}
		});
		
		target.addMouseOutHandler(new MouseOutHandler(){
			@Override
			public void onMouseOut(MouseOutEvent event) {
				ToolTipPopup.this.hide();
			}
		});
	}
	
	@Override
	public void show(){
		
		super.show();
		
		int windowWidth = 520;
		
		int widgetLeft = target.getAbsoluteLeft();
		
		// tipText.getElement().getStyle().setWidth(windowWidth - widgetLeft - 10, Unit.PX);
		// tipText.getElement().getStyle().setPropertyPx("max-width", 300);
		
		//double temp = 300;
		// tipText.getElement().getStyle().setProperty("max-width", temp, Unit.PX);
		
		
		int popupLeft = this.getPopupLeft();
		int popupWidth = this.getOffsetWidth();
		@SuppressWarnings("unused") // TODO: use this
		int popupRight = popupLeft + popupWidth;
		
		
		
		
		
		double fromBottom = Integer.valueOf(tipText.getOffsetHeight()).doubleValue() + 14;
		
		tipText.getElement().getStyle().setBottom(fromBottom, Unit.PX);
		
		
		// if the widget is in the left half and the popup will fit to the right
		if((widgetLeft<(windowWidth/2))&&(widgetLeft<(windowWidth-popupWidth))){
			// put the notch on the left
			tipText.addStyleName(style.leftNotch());
		} else {
			this.setStyleName(style.rightNotch());
		}
		
	}
	
	public void setText(String helpText){
		
		tipText.setText(helpText);
	}
	
	
	
}
