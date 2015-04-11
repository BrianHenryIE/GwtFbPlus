package ie.sortons.gwtfbplus.client.widgets.suggestbox;

import ie.sortons.gwtfbplus.client.resources.GwtFbPlusResources;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Image;

public class SelectedLoading extends SelectedItemWidget {

	GwtFbPlusResources resources = GwtFbPlusResources.INSTANCE;

	public SelectedLoading() {
		super();
		eastContainer.clear();
		Image loadingAnimation = new Image(resources.smallLoadingAnimation());
		loadingAnimation.getElement().getStyle().setMargin(4, Unit.PX);
		eastContainer.add(loadingAnimation);
	}
	
}

