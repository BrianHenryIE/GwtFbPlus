package ie.sortons.gwtfbplus.client.overlay.graph;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.i18n.client.DateTimeFormat;

public class GraphEvent extends JavaScriptObject {

	protected GraphEvent() {}
	
	/**
	 * The event ID.
	 */
	public final native String getId() /*-{
		return this.id;
	}-*/;
	
	/**
	 * The event Category.
	 */
	public final native JavaScriptObject getCategory() /*-{
		return this.category;
	}-*/;
	
	/**
	 * Cover picture
	 * 
	 * @see https://developers.facebook.com/docs/graph-api/reference/cover-photo/
	 * 
	 * @return
	 */
	public final native JavaScriptObject getCover() /*-{
		return this.cover;
	}-*/;

	/**
	 * Long-form description of the event.
	 */
	public final native String getDescription() /*-{
		return this.description;
	}-*/;

	/**
	 * The type of the event.
	 */
	public final native JavaScriptObject getType() /*-{
		return this.type;
	}-*/;
	
	/**
	 * End time of the event, if one has been set.
	 */
	public final native String getEndTime() /*-{
		return this.end_time;
	}-*/;

	/**
	 * Whether the viewer is admin or not
	 */
	public final native boolean isViewerAdmin() /*-{
		return this.is_viewer_admin;
	}-*/;
	
	/**
	 * Whether the event is created by page or not
	 */
	public final native boolean isPageOwned() /*-{
		return this.is_page_owned;
	}-*/;
	
	/**
	 * The name of the event.
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;

	/**
	 * The profile that created the event. User|Page|Group
	 */
	public final native JavaScriptObject getOwner() /*-{
		return this.owner;
	}-*/;

	/**
	 * The group the event belongs to
	 * 
	 * @see https://developers.facebook.com/docs/graph-api/reference/group/
	 */
	public final native JavaScriptObject getParentGroup() /*-{
		return this.parent_group;
	}-*/;

	/**
	 * Event Place information
	 * 
	 * @see https://developers.facebook.com/docs/graph-api/reference/place/
	 */
	public final native GraphPlace getPlace() /*-{
		return this.place;
	}-*/;

	/**
	 * Start time of the event.
	 */
	public final native String getStartTime() /*-{
		return this.start_time;
	}-*/;
	
	/**
	 * The link users can visit to buy a ticket to this event. Can only be added
	 * to events created by Pages.
	 */
	public final native String getTicketUri()  /*-{
		return this.ticket_uri;
	}-*/;

	/**
	 * Any timezone that the event has.
	 */
	public final native String getTimezone()  /*-{
		return this.timezone;
	}-*/;

	/**
	 * Last time that the event was updated.
	 */
	public final native String getUpdatedTime() /*-{
		return this.updated_time;
	}-*/;

	/**
	 * The number of people who have RSVPed to this event as 'attending'.
	 */
	public final native int getAttendingCount() /*-{
		return this.attending_count;
	}-*/;

	/**
	 * The number of people who have RSVPed to this event as 'declined'.
	 */
	public final native int getDeclinedCount() /*-{
		return this.declined_count;
	}-*/;

	/**
	 * The number of people who have RSVPed to this event as 'maybe'.
	 */
	public final native int getMaybeCount() /*-{
		return this.maybe_count;
	}-*/;

	/**
	 * The number of people who have not yet RSVPed to this event.
	 */
	public final native int getNoreplyCount() /*-{
		return this.noreply_count;
	}-*/;
	

	// Additional convenience methods
	
	/**
	 * TODO test this! (the null part!)
	 */
	public final boolean isDateOnly() {
		return (getStartTime().length() == 10 && getEndTime() == null);
	}

	public final Date getStartTimeDate() {
		return (this.getStartTime().length() > 10 ? DateTimeFormat.getFormat("yyyy-MM-dd'T'hh:mm:ssZ").parse(getStartTime())
				: DateTimeFormat.getFormat("yyyy-MM-dd").parse(getStartTime()));
	}
	
	// TODO: I don't think this works for null
	public final Date getEndTimeDate() {
		return ((getEndTime() == null) ? null : DateTimeFormat.getFormat("yyyy-MM-dd'T'hh:mm:ssZ").parse(getEndTime()));
	}
}
