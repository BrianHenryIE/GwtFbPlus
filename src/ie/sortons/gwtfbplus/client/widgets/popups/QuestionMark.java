package ie.sortons.gwtfbplus.client.widgets.popups;

import ie.sortons.gwtfbplus.client.oldresources.DefaultBundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;

public class QuestionMark extends Label {
	
	DefaultBundle res = GWT.create(DefaultBundle.class);
	
	ToolTipPanel popup = new ToolTipPanel("", this);
	
	public QuestionMark() 
	{
		super(); // Call Label's constructor.	
		this.setStyleName(res.css().helpMark());
	}
	
	@Override
	public void setText(String helpText){
		popup.getPopUp().setText(helpText);
		
	}
		
}
