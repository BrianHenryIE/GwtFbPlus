package ie.sortons.gwtfbplus.client.oldresources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface DefaultBundle extends ClientBundle {
	public static final DefaultBundle INSTANCE = GWT.create(DefaultBundle.class); 
	
	@Source("default.css")
	Style css();

	@Source("Sortonsbottomofpage.jpg")
	ImageResource footer();
	
	@Source("sortons180.png")
	ImageResource sortons();

	@Source("xable.png")
	ImageResource xableImages();

	@Source("fbgreenticktrans.png")
	ImageResource fbGreenTickImage();
	
	@Source("x.png")
	ImageResource redX();
	
	@Source("question.png")
	ImageResource orangeQMark();
	
	@Source("FbGreyExclamation.png")
	ImageResource greyExclamationMark();
		
	@Source("exclamation.png")
	ImageResource exclamationMark();


	@Source("FbFriendsLogo.png")
	ImageResource fbFriendsLogoIcon();

	@Source("fbstatusicon.png")
	ImageResource fbStatusIcon();

	@Source("fbBlankProfilePicture50x50.png")
	ImageResource fbBlankProfilePicture50x50();

	@Source("ellipses.png")
	ImageResource fbEllipses();

	@Source("ellipses25.png")
	ImageResource fbEllipses25();

	@Source("FbSocialPluginIcon.png")
	ImageResource fbSocialIcon();

	@Source("FbTagFriendsIcon.png")
	ImageResource fbTagFriendsIcon();

	@Source("fbpadlock.png")
	ImageResource fbPadlock();

	@Source("fbpadlocklighter.png")
	ImageResource fbPadlockLight();

	@Source("fbtalktorestaurant.png")
	ImageResource fbTalkToRestaurantIcon();

	@Source("TimelineAddBlueCropped14x11.png")
	ImageResource fbTimeline();

	@Source("DoubleUp.png")
	ImageResource doubleUp();

	@Source("DoubleDown.png")
	ImageResource doubleDown();


	@Source("fb_dropdownicon.png")
	ImageResource fbDropDownArrowIcon();

	@Source("fbaddeventicon.png")
	ImageResource addReservation();
	@Source("fbeventsicon.png")
	ImageResource dailyReservations();
	@Source("fbnewsfeedicon.png")
	ImageResource newsFeed();
	@Source("fbpaymentsicon.png")
	ImageResource accounts();
	@Source("fbsettingsicon.png")
	ImageResource configure();


	@Source("FbNotesIcon.png")
	ImageResource fbNotesIcon();

	@Source("fbThreeFriendsIcon.png")
	ImageResource fbLightFriendsIcon();


	@Source("arrowblueleftpadded.png")
	ImageResource blueLeftArrow();

	@Source("arrowbluerightpadded.png")
	ImageResource blueRightArrow();







	@Source("CanvasBannerBackground.png")
	ImageResource bannerGradient();


	

	
	
	
	
	
	public interface Style extends CssResource {
		/* Helper styles */
		
		String footerSprite();
		
		String fbRootPanelStyle();
		
		
		String btnAllBorder();
		
		String displayNone();
		String displayBlock();
		String displayInline();
		
		String flowHorizontal();
		String flowVertical();
		
		String insetInputBoxes();
		String insetBorder();
		
		String tinyBox();
		String smallBox();
		String longBox();
		
		String rightAlign();
		String leftAlign();
		String centerAlign();
		
		String rightFloat();
		String leftFloat();
		String boldFont();
		
		String widthAuto();
		
		/* Actual widget styles */
		String timeBox();
		
		//String timePicker();
		//String timePickerButton();
		//String periodBox();
		String navButton();

		String suggestInput();
		String suggestName();
		String suggestNameX();
		String updateStatus();

		String xableItemTable();
		String xableItemXsprite();
		//String xableItemX();

		String fbNotchedBox();
		
		// Consumer res view notches
		String newCommentNotch();
		String alterResNotch();
		String tagFriendsNotch();
		
		// Mgmt res view notches
		String manageResNotch();
		String sendMessageNotch();
		String privateNoteNotch();
		
		String fbTextBox();
		String fbFakeTextBox();
		String fbFakeTextBoxSuggest();
		String fbBlueLink();
	

		String helpMark();

		String canvasBody();
		String canvasContent();

		String migratedCanvasPage();
		

		String configPage();
		String configPageSection();
		String configPageItemLabel();
		String configPageTextBox();
		
		String bannerBackground();
		
		String scheduleTable();
		String scheduleTableLabel();
		
		String square25rightpadding1();
		String square50rightpadding3();
		
	}

	@Source("gwt-overrides.css")
	GwtOverrides gwt();
	public interface GwtOverrides extends CssResource {
		/* Everything in this .css is declared @external, and set by string name. */
	}
	
	@Source("facebook.css")
	@CssResource.NotStrict
	FbStyle fbcss();
	
	public interface FbStyle extends CssResource {
		String fbTab();
		String fbBlueBox();
		String fbGreyBox();
		String fbInfoBox();
		String fbErrorBox();
	}
	  
}
