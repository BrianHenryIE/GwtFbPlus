package ie.sortons.gwtfbplus.client.widgets;

import ie.sortons.gwtfbplus.client.api.FBXfbml;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * @author brianhenry
 * @see https://developers.facebook.com/docs/plugins/login-button
 */
public class LoginButton extends Composite {

	SimplePanel panel = new SimplePanel();
	
	// defaults
	private boolean autoLogoutLink = false;
	private int maxRows = 1;

	// TODO
	// private Callback onLogin;

	private String scope = "";
	private String size = "small";
	private boolean showFaces = false;

	/**
	 * @param autoLogoutLink
	 *            . If enabled, the button will change to a logout button when the user is logged in.
	 */
	public void setAutoLogoutLink(boolean autoLogoutLink) {
		this.autoLogoutLink = autoLogoutLink;
		setLoginButtonPanel();
	}

	/**
	 * @param maxRows
	 *            . The maximum number of rows of profile photos in the Facepile when show_faces is enabled. The actual
	 *            number of rows shown may be shorter if there aren't enough faces to fill the number you specify.
	 */
	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
		setLoginButtonPanel();
	}

	/**
	 * @param scope
	 *            . The comma-separated list of permissions to request during login.
	 */
	public void setScope(String scope) {
		this.scope = scope;
		setLoginButtonPanel();
	}

	/**
	 * @param size
	 *            . Picks one of the size options for the button.
	 */
	public void setSize(Size size) {
		this.size = size.toString();
		setLoginButtonPanel();
	}

	/**
	 * @param showFaces
	 *            . Determines whether a Facepile of logged-in friends is shown below the button. When this is enabled,
	 *            a logged-in user will only see the Facepile, and no login or logout button.
	 */
	public void setShowFaces(boolean showFaces) {
		this.showFaces = showFaces;
		setLoginButtonPanel();
	}

	@UiConstructor
	public LoginButton() {

		setLoginButtonPanel();

		initWidget(panel);
	}
	
	protected void onAttach(){
		super.onAttach();
		FBXfbml.parse();
	}

	private void setLoginButtonPanel() {
		panel.clear();
		HTMLPanel htmlPanel = new HTMLPanel("<div class=\"fb-login-button\" data-auto-logout-link=\"" + autoLogoutLink + "\" data-max-rows=\"" + maxRows
				+ "\" data-scope=\"" + scope + "\" data-size=\"" + size + "\" data-show-faces=\"" + showFaces + "\"></div>");
		panel.add(htmlPanel);
		FBXfbml.parse();
	}

	public enum Size {
		SMALL {
			public String toString() {
				return "small";
			}
		},
		ICON {
			public String toString() {
				return "icon";
			}
		},
		MEDIUM {
			public String toString() {
				return "medium";
			}
		},
		LARGE {
			public String toString() {
				return "large";
			}
		},
		XLARGE {
			public String toString() {
				return "xlarge";
			}
		}
	}
}
