package ie.sortons.gwtfbplus.shared.domain.graph;

import java.util.Date;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

public class GraphEvent implements JsonSerializable {

	/**
	 * The event ID.
	 */
	String id;

	/**
	 * The event's cover photo.
	 */
	GraphEventCover cover;

	/**
	 * Long-form description of the event.
	 */
	String description;

	/**
	 * End time of the event, if one has been set.
	 */
	Date end_time;

	/**
	 * Indicates whether the event only has a date specified, but no time.
	 */
	boolean is_date_only;

	/**
	 * The location of the event, if any.
	 */
	String location;

	/**
	 * The name of the event.
	 */
	String name;

	/**
	 * The profile that created the event. User|Page|Group
	 */
	GraphEventOwner owner;

	/*
	 * TODO The group the event belongs to, if any.
	 */
	// Group parent_group

	/**
	 * Who can see the event.
	 */
	String privacy; // TODO enum?

	/**
	 * Start time of the event.
	 */
	Date start_time;

	/**
	 * The link users can visit to buy a ticket to this event. Can only be added
	 * to events created by Pages.
	 */
	String ticket_uri;

	/**
	 * Any timezone that the event has.
	 */
	String timezone;

	/**
	 * Last time that the event was updated.
	 */
	Date updated_time;

	/**
	 * Venue hosting the event, if any.
	 */
	GraphEventVenue venue;

	/**
	 * The number of people who have RSVPed to this event as 'attending'.
	 */
	int attending_count;

	/**
	 * The number of people who have RSVPed to this event as 'declined'.
	 */
	int declined_count;

	/**
	 * The number of people who have RSVPed to this event as 'maybe'.
	 */
	int maybe_count;

	/**
	 * The number of people who have not yet RSVPed to this event.
	 */
	int noreply_count;

	/**
	 * The number of people who were invited to this event.
	 */
	int invited_count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public GraphEventCover getCover() {
		return cover;
	}

	public void setCover(GraphEventCover cover) {
		this.cover = cover;
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

	public boolean isIs_date_only() {
		return is_date_only;
	}

	public void setIs_date_only(boolean is_date_only) {
		this.is_date_only = is_date_only;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GraphEventOwner getOwner() {
		return owner;
	}

	public void setOwner(GraphEventOwner owner) {
		this.owner = owner;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
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

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Date getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(Date updated_time) {
		this.updated_time = updated_time;
	}

	public GraphEventVenue getVenue() {
		return venue;
	}

	public void setVenue(GraphEventVenue venue) {
		this.venue = venue;
	}

	public int getAttending_count() {
		return attending_count;
	}

	public void setAttending_count(int attending_count) {
		this.attending_count = attending_count;
	}

	public int getDeclined_count() {
		return declined_count;
	}

	public void setDeclined_count(int declined_count) {
		this.declined_count = declined_count;
	}

	public int getMaybe_count() {
		return maybe_count;
	}

	public void setMaybe_count(int maybe_count) {
		this.maybe_count = maybe_count;
	}

	public int getNoreply_count() {
		return noreply_count;
	}

	public void setNoreply_count(int noreply_count) {
		this.noreply_count = noreply_count;
	}

	public int getInvited_count() {
		return invited_count;
	}

	public void setInvited_count(int invited_count) {
		this.invited_count = invited_count;
	}

}
