package ie.sortons.gwtfbplus.shared.domain.fql;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gwt.core.shared.GwtIncompatible;
import com.googlecode.objectify.annotation.Embed;
import com.googlecode.objectify.annotation.Index;
import com.kfuntak.gwt.json.serialization.client.JsonSerializable;
import com.kfuntak.gwt.json.serialization.client.SkipNullSerialization;



/**
 * http://developers.facebook.com/docs/reference/fql/event/
 * 
 * 
 */

@Embed
@SkipNullSerialization
public class FqlEvent implements JsonSerializable, Comparable<FqlEvent> {

	public Long getEid() {
		return eid;
	}

	public String getName() {
		return name;
	}

	public String getPic_small() {
		return pic_small;
	}

	public String getPic_big() {
		return pic_big;
	}

	public String getPic_square() {
		return pic_square;
	}

	public String getPic() {
		return pic;
	}

	public String getHost() {
		return host;
	}

	public Boolean getIsDateOnly() {
		return is_date_only;
	}

	public String getDescription() {
		return description;
	}

	public Date getStartTime() {
		return start_time;
	}

	public Date getEndTime() {
		return end_time;
	}

	public Long getCreator() {
		return creator;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public String getLocation() {
		return location;
	}

	public FqlEventVenue getVenue() {
		return venue;
	}

	public String getPrivacy() {
		return privacy;
	}

	public Boolean getHideGuestList() {
		return hide_guest_list;
	}

	public Boolean getCanInviteFriends() {
		return can_invite_friends;
	}

	public Integer getAllMembersCount() {
		return all_members_count;
	}

	public Integer getAttendingCount() {
		return attending_count;
	}

	public String getUnsureCount() {
		return unsure_count;
	}

	public Integer getDeclinedCount() {
		return declined_count;
	}

	public String getNot_replied_count() {
		return not_replied_count;
	}

	public FqlEvent() {
	}

	public Integer all_members_count;
	public String app_id;
	public Integer attending_count;
	public Boolean can_invite_friends;

	// int
	public Long creator;

	public String creator_cursor;
	public Integer declined_count;
	public String description;

	// int?
	public Long eid;
	public Date end_time;

	// public FeedTargeting feed_targeting

	public Boolean has_profile_pic;
	public Boolean hide_guest_list;
	public String host;
	public Boolean is_date_only;
	public String location;
	public String name;
	public String pic_small;
	public String pic_big;
	public String pic_square;
	public String pic;
	public String privacy;

	@Index
	public Date start_time;
	public String update_time;

	public FqlEventVenue venue;

	public String unsure_count;

	public String not_replied_count;

	@Override
	public int compareTo(FqlEvent other) {
		return this.eid.compareTo(other.getEid());
	}

	@Override
	public final boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof FqlEvent))
			return false;
		return compareTo((FqlEvent) obj) == 0;
	}

	@Override
	public final int hashCode() {
		return eid.hashCode();
	}

	@Embed
	@SkipNullSerialization
	public static class FqlEventVenue implements JsonSerializable {

		public FqlEventVenue() {
		}

		/**
		 * @return Street of the location
		 */
		public String getStreet() {
			return street;
		}

		/**
		 * @return City of the location
		 */
		public String getCity() {
			return city;
		}

		/**
		 * @return State of the location
		 */
		public String getState() {
			return state;
		}

		/**
		 * @return Country of the location
		 */
		public String getCountry() {
			return country;
		}

		/**
		 * @return Zip code of the location
		 */
		public String getZip() {
			return zip;
		}

		/**
		 * @return Latitude of the location
		 */
		public Double getLatitude() {
			return latitude;
		}

		/**
		 * @return Longitude of the location
		 */
		public Double getLongitude() {
			return longitude;
		}

		/**
		 * @return ID of the location
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @return Name of the location
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return ID of the parent location of this location
		 */
		public Long getLocated_in() {
			return located_in;
		}

		public String street;
		public String city;
		public String state;
		public String country;
		public String zip;
		public Double latitude;
		public Double longitude;
		public Long id;
		public String name;
		public Long located_in;

	}

	// For Gson
	@GwtIncompatible
	public static class FqlEventVenueAdapter implements JsonDeserializer<FqlEventVenue> {

		@Override
		public FqlEventVenue deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

			// I think the term to describe this is "polymorphic"
			if (json.isJsonArray()) {

				return null;

			} else if (json.isJsonObject()) {

				// TODO: this is done wrong.
				// It should be something like:
				// attachment = (FqlStreamItemAttachment) context.deserialize(json, FqlStreamItemAttachment.class);
				// but that has this Adapter attached so it recurses inside here and Internal Server Error occurs.
				// I'm not sure how to actually create a FqlEventVenue object in here without starting a new
				// Gson object

				Gson gson = new Gson();
				return (FqlEventVenue) gson.fromJson(json, FqlEventVenue.class);
				// return (FqlEventVenue) context.deserialize(json, FqlEventVenue.class);

			} else {
				throw new RuntimeException("Unexpected JSON type: " + json.getClass());
			}

		}

	}

	// Because sometimes dates are long and sometimes short
	@GwtIncompatible
	public static class FqlEventDatesAdapter implements JsonDeserializer<Date> {

		@Override
		public Date deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

			if (json.getAsString().length() == 10) {
				try {
					return new SimpleDateFormat("yyyy-MM-dd").parse(json.getAsString());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (json.getAsString().length() == 24) {
				try {
					return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(json.getAsString());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return null;
		}
	}

}
