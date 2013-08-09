package ie.sortons.gwtfbplus.client.widgets.buttons;

public class CanDisableButton extends SoButtonBase {

	// TODO: deal with this
	@SuppressWarnings("deprecation")
	public CanDisableButton(TextButtonResources instance) {
		super(instance);
	}

	@Override 
	protected void renderFace(){
		if(isEnabled()){
			super.renderFace();
		}
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		
		if(enabled == false){
			addStyleName(styles.disabled());
		}
	}
}
