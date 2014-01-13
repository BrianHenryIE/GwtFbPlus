package ie.sortons.gwtfbplus.client.widgets.popups;


import ie.sortons.gwtfbplus.client.widgets.buttons.GreyButton;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class FbGenericPopup extends PopupPanel {

	private static NoteActionPopupUiBinder uiBinder = GWT
			.create(NoteActionPopupUiBinder.class);

	interface NoteActionPopupUiBinder extends UiBinder<Widget, FbGenericPopup> {
	}
	
	interface Styles extends CssResource { 
		String popup();
		String popupGlass();
	}
	
	public static abstract class PopupResult {
		public abstract void okClicked(String note);
		public void cancelClicked() { };
	}

	private final PopupResult callback;
	
	@UiField Styles style;
	
	@UiField HTMLPanel loading;
	@UiField HTMLPanel body;
	// header
	@UiField HTMLPanel details;
	@UiField HTMLPanel footer;
	
	@UiField Label title;
	
	@UiField Label highlight;
	@UiField Label note;
	@UiField Label textAreaQuestion;
	@UiField TextArea input;
	@UiField SimplePanel addWidget;
	
	@UiField GreyButton okButton; // TODO SHould be blue
	@UiField GreyButton cancelButton;
	
	public FbGenericPopup() {
		this(null);
	}

	public FbGenericPopup(PopupResult callback) {
		this.setModal(true);
		this.callback = callback;
		setWidget(uiBinder.createAndBindUi(this));
		this.setStyleName(style.popup());
	}
	
	
	public void showContent(){
		loading.setVisible(false);
		body.setVisible(true);
	}


	
	@UiHandler("okButton")
	void ok(ClickEvent e) {
		this.hide();
		if (callback == null)
			return;
		
		if(input.isVisible()){
			callback.okClicked(input.getText());
		} else {
			callback.okClicked(null);
		}
	}
	
	@UiHandler("cancelButton") 
	void cancel(ClickEvent e) {
		this.hide();
		callback.cancelClicked();
	}
	

	public void setTitleText(String titleText){
		title.setText(titleText);
	}
	public String getTitleText(){
		return title.getText();
	}
	
	
	
	public void setHighlightText(String setText){
		if(setText!=null){
			highlight.setText(setText);
			highlight.getElement().getStyle().setDisplay(Display.BLOCK);
		}else{
			highlight.setText(null);
			highlight.getElement().getStyle().setDisplay(Display.NONE);
		}
	}
	public String getHighlightText(){
		return highlight.getText();
	}
	
	public void setNoteText(String setText){
		if(setText!=null){
			note.setText(setText);
			note.getElement().getStyle().setDisplay(Display.BLOCK);
		}else{
			note.setText(null);
			note.getElement().getStyle().setDisplay(Display.NONE);
		}
	}
	public String getNoteText(){
		return note.getText();
	}

	
	public void setAddWidget(Widget widget){
		addWidget.setWidget(widget);
		addWidget.getElement().getStyle().setDisplay(Display.BLOCK);

	}
	public Widget getAddWidget(){
		return addWidget.getWidget();
	}

	
	public void setTextAreaQuestionText(String setText){
		if(setText!=null){
			textAreaQuestion.setText(setText);
			textAreaQuestion.getElement().getStyle().setDisplay(Display.BLOCK);
			input.getElement().getStyle().setDisplay(Display.BLOCK);
		}else{
			textAreaQuestion.setText(null);
			textAreaQuestion.getElement().getStyle().setDisplay(Display.NONE);
			input.getElement().getStyle().setDisplay(Display.NONE);
		}
	}
	public String getTextAreaQuestionText(){
		return textAreaQuestion.getText();
	}


	public void setOkText(String buttonText){
		okButton.setText(buttonText);
	}
	public void setCancelText(String buttonText){
		cancelButton.setText(buttonText);
		cancelButton.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
	}
	public String getOkText(){
		return okButton.getText();
	}
	public String getCancelText(){
		return cancelButton.getText();
	}


	
	
}
