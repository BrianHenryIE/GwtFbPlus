package ie.sortons.gwtfbplus.server.fql;

import com.google.gwt.core.client.GWT;
import com.kfuntak.gwt.json.serialization.client.JsonSerializable;
import com.kfuntak.gwt.json.serialization.client.Serializer;


// TODO
/**
 * json = json.replace("\"venue\":[]", "\"venue\":{}");
 * 
 * is being used because when Facebook has no data to return, it 
 * returns an empty array rather than an empty object. 
 * 
 * The correct solution to this is a GSON adapter, as done with
 * FqlStream
 */

/**

http://developers.facebook.com/docs/reference/fql/event/

{
  "data": [
    {
      "name": "AIR @ ANDREWS LANE THEATRE presented by UCD DANCE SOCIETY",
      "location": "Andrew's Lane Theatre",
      "eid": 314646171897576,
      "start_time": "2011-11-30T23:00:00",
      "end_time": "2011-12-01T02:30:00",
      "pic_square": "http://profile.ak.fbcdn.net/hprofile-ak-ash4/373192_314646171897576_693607468_n.jpg"
    }, 

 */


public class FqlEvent extends Fql {

	public FqlEvent.FqlEventItem[] getData() {
		return data;
	}

	public FqlEvent(){}

	private FqlEvent.FqlEventItem[] data; 

	public static class FqlEventItem implements JsonSerializable, Comparable<FqlEventItem> {

		public String getEid() {
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

		public String getDescription() {
			return description;
		}

		public String getStart_time() {
			return start_time;
		}

		public String getEnd_time() {
			return end_time;
		}

		public String getCreator() {
			return creator;
		}

		public String getUpdate_time() {
			return update_time;
		}

		public String getLocation() {
			return location;
		}

		public FqlEvent.FqlEventVenue getVenue() {
			return venue;
		}

		public String getPrivacy() {
			return privacy;
		}

		public String getHide_guest_list() {
			return hide_guest_list;
		}

		public String getCan_invite_friends() {
			return can_invite_friends;
		}

		public String getAll_members_count() {
			return all_members_count;
		}

		public String getAttending_count() {
			return attending_count;
		}

		public String getUnsure_count() {
			return unsure_count;
		}

		public String getDeclined_count() {
			return declined_count;
		}

		public String getNot_replied_count() {
			return not_replied_count;
		}

		public FqlEventItem() {}

		private String eid;
		private String name;
		private String pic_small;
		private String pic_big;
		private String pic_square;
		private String pic;
		private String host;
		private String description;
		private String start_time;
		private String end_time;
		private String creator;
		private String update_time;
		private String location;
		
		private FqlEventVenue venue;
		
		private String privacy;
		private String hide_guest_list;
		private String can_invite_friends;
		private String all_members_count;
		private String attending_count;
		private String unsure_count;
		private String declined_count;
		private String not_replied_count;
		

		@Override
		public int compareTo(FqlEventItem other) {
			return this.eid.compareTo(other.getEid());
		}

		@Override
		public final boolean equals(Object obj) {
			if (obj == this)
				return true;
			if (!(obj instanceof FqlEventItem))
				return false;
			return compareTo((FqlEventItem) obj) == 0;
		}

		@Override
		public final int hashCode() {
			return eid.hashCode();
		}
		
		public static FqlEventItem fromJson(String json) {
		        Serializer serializer = (Serializer) GWT.create(Serializer.class);
		        return (FqlEventItem)serializer.deSerialize(json,"ie.sortons.gwtfbplus.server.fql.FqlEventItem");
		}
		 
		public String toJson() {
		        Serializer serializer = (Serializer) GWT.create(Serializer.class);
		        return serializer.serialize(this);
		}

	}

	
	public static class FqlEventVenue {
		
		public FqlEventVenue() {}
		
		
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
		public String getId() {
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
		public String getLocated_in() {
			return located_in;
		}

		private String street;
		private String city;
		private String state;
		private String country;
		private String zip;
		private Double latitude;
		private Double longitude;
		private String id;
		private String name;
		private String located_in;
	
	}


}
