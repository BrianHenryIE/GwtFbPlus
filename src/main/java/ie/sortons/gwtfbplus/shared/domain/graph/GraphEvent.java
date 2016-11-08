package ie.sortons.gwtfbplus.shared.domain.graph;

import java.util.Date;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

public class GraphEvent implements JsonSerializable {

	/*
	 * The event ID
	 */
	String id;

	/*
	 * Number of people attending the event
	 */
	int attending_count;

	/*
	 * Can guests invite friends
	 */
	boolean can_guests_invite;

	/*
	 * The category of the event
	 */
	// enum category {ART_EVENT, BOOK_EVENT, MOVIE_EVENT, FUNDRAISER,
	// VOLUNTEERING, FAMILY_EVENT, FESTIVAL_EVENT, NEIGHBORHOOD,
	// RELIGIOUS_EVENT, SHOPPING, COMEDY_EVENT, MUSIC_EVENT, DANCE_EVENT,
	// NIGHTLIFE, THEATER_EVENT, DINING_EVENT, FOOD_TASTING, CONFERENCE_EVENT,
	// MEETUP, CLASS_EVENT, LECTURE, WORKSHOP, FITNESS, SPORTS_EVENT, OTHER}

	/*
	 * Cover picture
	 */
	// CoverPhoto cover

	/*
	 * Number of people who declined the event
	 */
	int declined_count;

	/*
	 * Long-form description
	 */
	String description;

	/*
	 * End time, If one has been set
	 */
	Date end_time;

	/*
	 * Can see guest list
	 */
	boolean guest_list_enabled;

	/*
	 * Number of people interested in the event
	 */
	int interested_count;

	/*
	 * 
	 * Whether or not the event has been marked as canceled
	 */
	boolean is_canceled;

	/*
	 * Whether the event is created by page or not
	 */
	boolean is_page_owned;

	/*
	 * Whether the viewer is admin or not
	 */
	boolean is_viewer_admin;

	/*
	 * Number of people who maybe going to the event
	 */
	int maybe_count;

	/*
	 * Event name
	 */
	String name;

	/*
	 * Number of people who did not reply to the event
	 */
	int noreply_count;

	/*
	 * The profile that created the event
	 */
	// owner

	/*
	 * The group the event belongs to
	 */
	// Group parent_group

	/*
	 * Event Place information
	 */
	GraphPlace place;

	/*
	 * Start time
	 */
	Date start_time;

	/*
	 * The link users can visit to buy a ticket to this event
	 */
	String ticket_uri;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAttending_count() {
		return attending_count;
	}

	public void setAttending_count(int attending_count) {
		this.attending_count = attending_count;
	}

	public boolean isCan_guests_invite() {
		return can_guests_invite;
	}

	public void setCan_guests_invite(boolean can_guests_invite) {
		this.can_guests_invite = can_guests_invite;
	}

	public int getDeclined_count() {
		return declined_count;
	}

	public void setDeclined_count(int declined_count) {
		this.declined_count = declined_count;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public boolean isGuest_list_enabled() {
		return guest_list_enabled;
	}

	public void setGuest_list_enabled(boolean guest_list_enabled) {
		this.guest_list_enabled = guest_list_enabled;
	}

	public int getInterested_count() {
		return interested_count;
	}

	public void setInterested_count(int interested_count) {
		this.interested_count = interested_count;
	}

	public boolean isIs_canceled() {
		return is_canceled;
	}

	public void setIs_canceled(boolean is_canceled) {
		this.is_canceled = is_canceled;
	}

	public boolean isIs_page_owned() {
		return is_page_owned;
	}

	public void setIs_page_owned(boolean is_page_owned) {
		this.is_page_owned = is_page_owned;
	}

	public boolean isIs_viewer_admin() {
		return is_viewer_admin;
	}

	public void setIs_viewer_admin(boolean is_viewer_admin) {
		this.is_viewer_admin = is_viewer_admin;
	}

	public int getMaybe_count() {
		return maybe_count;
	}

	public void setMaybe_count(int maybe_count) {
		this.maybe_count = maybe_count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoreply_count() {
		return noreply_count;
	}

	public void setNoreply_count(int noreply_count) {
		this.noreply_count = noreply_count;
	}

	public GraphPlace getPlace() {
		return place;
	}

	public void setPlace(GraphPlace place) {
		this.place = place;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public String getTicket_uri() {
		return ticket_uri;
	}

	public void setTicket_uri(String ticket_uri) {
		this.ticket_uri = ticket_uri;
	}

	/*
	 * Timezone
	 */
	// enum timezone

	/*
	 * The type of the event
	 */
	// type enum
	// {private, public,group, community
	// }

	/*
	 * Last update time
	 */
	// datetime updated_time

	
	
	
}
