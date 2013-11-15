package ie.sortons.gwtfbplus.client.widgets.popups;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;


public class ToolTipPopup extends PopupPanel {

	private static ErrorPopupUiBinder uiBinder = GWT
			.create(ErrorPopupUiBinder.class);

	Widget target;

	interface ErrorPopupUiBinder extends UiBinder<Widget, ToolTipPopup> {
	}

	interface Styles extends CssResource { 
		String popup();
		String popupGlass();
		// String panel();
		String leftNotch();
		String rightNotch();
	}

	@UiField
	Styles style;

	@UiField
	Label tipText;

	public ToolTipPopup(String text, Widget target) {

		this.target = target;

		setWidget(uiBinder.createAndBindUi(this));

		this.setGlassEnabled(false);

		this.setStyleName(style.popup());

		tipText.setText(text);


		// TODO get rid of this
		// turn off wordwrap
		// tipText.getElement().getStyle().setProperty("white-space", "nowrap");
		tipText.getElement().getStyle().setProperty("whiteSpace", "nowrap");

		tipText.getElement().getStyle().setMarginRight(6, Unit.PX);

		// this.showRelativeTo(target);

		// this.show();
	}

	@Override
	public void show(){

		super.show();

		tipText.setVisible(false);
		Timer t = new Timer() {
			@Override
			public void run() {
				// doesn't calculate until it has been displayed
				
				if(target.getAbsoluteLeft()+ tipText.getOffsetWidth() > Window.getClientWidth()){ // or windowWidth/2){
					
					tipText.removeStyleName(style.leftNotch());
					tipText.addStyleName(style.rightNotch());
					tipText.getElement().getStyle().setLeft(-tipText.getOffsetWidth()+target.getOffsetWidth(), Unit.PX);
					
				}else{
					tipText.addStyleName(style.leftNotch());
				}
				tipText.setVisible(true);

				// Set the vertical position
				// By default, popupPanel shows below the target
				// We want it above (if, there's space: TODO) so 
				// add the height of the target widget, the height of the text and a few px for the notch
				double fromBottom = target.getOffsetHeight() + tipText.getOffsetHeight() + 4;	
				tipText.getElement().getStyle().setBottom(fromBottom, Unit.PX);
			}
		};
		t.schedule(50);


	}

	public void setText(String helpText){

		tipText.setText(helpText);
	}



}
