package ie.sortons.gwtfbplus.client.widgets.buttons;

import ie.sortons.gwtfbplus.client.widgets.buttons.SoButtonBase.TextButtonResources.TextButtonStyle;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CommonResources;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasText;

/**
 * 
 * At some point, we will probably combine the functionality of
 * ImageButton/TextButton, as we want to support things like:
 * 
 * Text + Image, Image + Text Text with overlayed Image (not background, which
 * can be set with css) Button with loading/working indicator,
 * 
 * 
 * We don't support setting different text values depending on state (like GWT
 * ToggleButton) as I can't really see a need for it.
 * 
 * @author Aidan OK
 * 
 */
public class SoButtonBase extends FocusWidget implements HasText, HasEnabled {

	public static interface TextButtonResources extends ClientBundle {
		public static interface TextButtonStyle extends CssResource {
			public String upFace();

			public String upHover();

			public String down();

			public String disabled();
		}

		@Source("textbuttondefault.css")
		TextButtonStyle style();
	}

	private boolean isDown = false;
	private boolean isHovering = false;
	private boolean isSticky = false;

	// private Label btn = new Label();
	// private TextButtonResources resources;
	@SuppressWarnings("unused")
	private String text; // TODO: check this out
	protected TextButtonStyle styles;

	@Deprecated
	protected SoButtonBase(TextButtonResources resources, boolean ownHandlers) {

		this(DOM.createDiv(), resources, ownHandlers);
		this.addStyleName(CommonResources.getInlineBlockStyle());
	}

	@Deprecated
	protected SoButtonBase(TextButtonResources resources) {
		/* If we are using a DIV, set ourselves to be inline-block */
		this(DOM.createDiv(), resources, true);
		this.addStyleName(CommonResources.getInlineBlockStyle());
	}

	@Deprecated
	protected SoButtonBase(Element element, TextButtonResources resources, boolean ownHandlers) {
		super(element);
		this.styles = resources.style();
		this.styles.ensureInjected();
		getElement().setClassName(styles.upFace());
		if (ownHandlers) {
			setupMouseHandlers();
		}
		// initWidget(btn);
	}

	// New style constructor, more flexible,
	// subclasses must call setElement() themselves,
	// and possible setupMouseHandlers(), if they want the
	// mouse events managed for them .
	// We also just take CssResource, rather than ClientBundle,
	// This combines to allow us to make arbritray buttons based on
	// uibinder templates with their styles defined inline.
	protected SoButtonBase() {
		// this.styles = styles;
		// this.styles.ensureInjected();
	}

	public void setElementAndStyles(Element element, TextButtonStyle styles) {
		setElement(element);
		this.styles = styles;
		this.styles.ensureInjected();
		element.setClassName(styles.upFace());
	}

	public void setSticky(boolean sticky) {
		isSticky = true;
	}

	public void setDown(boolean down) {
		isDown = down;
		renderFace();
	}

	public boolean isDown() {
		return isDown;
	}

	public void setHover(boolean enabled) {
		isHovering = enabled;
		renderFace();
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		renderFace();
	}

	public void setupMouseHandlers() {

		this.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				isHovering = true;
				renderFace();
			}
		});
		this.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				// if (isSticky && isDown)
				// return;
				isHovering = false;
				if (!isSticky)
					isDown = false; // Also clear the down flag so the button
									// doesn't get stuck down.
				renderFace();
			}
		});
		this.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {

				if (!isSticky) {
					isDown = true;
					renderFace();
				}
			}
		});
		this.addMouseUpHandler(new MouseUpHandler() {
			@Override
			public void onMouseUp(MouseUpEvent event) {

				if (!isSticky) {
					isDown = false;
					renderFace();
				}
			}
		});

	}

	protected void renderFace() {

		removeStatefulStyles();

		if (isDown)
			addStyleName(styles.down());

		if (!isEnabled())
			addStyleName(styles.disabled());

		if (isHovering) {
			if (!isDown() && isEnabled())
				addStyleName(styles.upHover());
			// else
			// downHover()
		}
	}

	// Clear any stateful styles.
	private void removeStatefulStyles() {
		removeStyleName(styles.down());
		removeStyleName(styles.upHover());
		removeStyleName(styles.disabled());
	}

	@Override
	public String getText() {
		return getElement().getInnerText();
	}

	@Override
	public void setText(String text) {
		getElement().setInnerText(text);
	}

}
