package ie.sortons.gwtfbplus.shared.domain.fql;

import ie.sortons.gwtfbplus.client.widgets.suggestbox.FbSearchable;

import com.google.api.server.spi.config.ApiResourceProperty;
import com.google.gwt.core.shared.GwtIncompatible;
import com.googlecode.objectify.annotation.Embed;
import com.kfuntak.gwt.json.serialization.client.JsonSerializable;
import com.kfuntak.gwt.json.serialization.client.SkipNullSerialization;

/**
 * http://developers.facebook.com/docs/reference/fql/page/
 */

@Embed
@SkipNullSerialization
public class FqlPage implements JsonSerializable, FbSearchable, Comparable<FqlPage> {

	@GwtIncompatible("incompatible field")
	@ApiResourceProperty(name = "class")
	public String classname = "ie.sortons.gwtfbplus.shared.domain.fql.FqlPage";

	public FqlPage() {
	}

	public FqlPage(String name, String pageUrl, Long pageId) {
		this.page_id = pageId;
		this.name = name;
		this.page_url = pageUrl;
	}

	public FqlPageLocation getLocation() {
		return location;

	}

	public String about;
	public String access_token;
	public String affiliation;
	public String app_id;
	public String artists_we_like;
	public String attire;
	public String awards;
	public String band_interests;
	public String band_members;
	public String best_page_id;
	public String bio;
	public String birthday;
	public String booking_agent;

	// public Struct budget_recs;
	public String built;
	public Boolean can_post;
	// public Struct categories;
	public Integer checkins;
	public String company_overview;
	public String culinary_team;
	public String current_location;
	public String description;
	public String description_html;
	public String directed_by;

	// TODO test!
	// public ArrayList<String> emails;

	public Integer fan_count;
	public String features;
	// public String[] food_styles;
	public String founded;
	public String general_info;
	public String general_manager;
	public String genre;
	public String global_brand_page_name;
	public String global_brand_parent_page_id;
	public Boolean has_added_app;
	public String hometown;
	// public Struct hours;
	public String influences;
	public Boolean is_community_page;
	public Boolean is_permanently_closed;
	public Boolean is_published;
	public Boolean is_unclaimed;
	public Boolean is_verified;
	public String keywords;

	public FqlPageLocation location;

	public String members;
	public String mission;
	public String mpg;

	public String name;

	public String getName() {
		return name;
	}

	public String network;
	public Integer new_like_count;
	public String offer_eligible;

	public Long page_id;

	public Long getPageId() {
		return page_id;
	}

	public String page_url;

	public String getPageUrl() {
		return page_url;
	}

	public String parent_page;
	// public Struct parking;
	// public Struct payment_options;
	public String personal_info;
	public String personal_interests;
	public String pharma_safety_info;
	public String phone;
	public String pic;
	public String pic_big;
	public String pic_cover;
	public String pic_large;
	public String pic_small;
	public String pic_square;
	public String plot_outline;
	public String press_contact;
	public String price_range;
	public String produced_by;
	public String products;
	public Boolean promotion_eligible;
	public String promotion_ineligible_reason;
	public String public_transit;
	public String record_label;
	public String release_date;
	// public Struct restaurant_services;
	// public Struct restaurant_specialties;
	public String schedule;
	public String screenplay_by;
	public String season;
	public String starring;
	public Integer store_number;
	public String studio;
	public Integer talking_about_count;
	public String type;
	public Integer unread_message_count;
	public Integer unseen_message_count;
	public Integer unseen_notif_count;
	public String username;
	public String website;
	public Integer were_here_count;
	public String written_by;
	public Integer unread_notif_count;

	@Override
	public String getTitle() {
		return name;
	}

	@Override
	public String getSubTitle() {
		// TODO return the address
		return "";
	}

	@Override
	public Long getUid() {
		return page_id;
	}

	@Override
	public String getSearchText() {
		return name;
	}

	@Override
	public final boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof FqlPage))
			return false;
		return compareTo((FqlPage) obj) == 0;
	}

	@Override
	public final int hashCode() {
		return page_id.hashCode();
	}

	@Override
	public int compareTo(FqlPage other) {
		return this.page_id.compareTo(other.getPageId());

	}

	/**
	 * The location of this place. Applicable to all Places
	 * 
	 * @author brianhenry
	 * 
	 */
	@Embed
	@SkipNullSerialization
	public static class FqlPageLocation implements JsonSerializable {

		@GwtIncompatible
		@ApiResourceProperty(name = "class")
		public final String classname = "ie.sortons.gwtfbplus.shared.domain.fql.FqlPage.FqlPageLocation";

		/**
		 * @return the Street of the location
		 */
		public String getStreet() {
			return street;
		}

		/**
		 * @return the City of the location
		 */
		public String getCity() {
			return city;
		}

		/**
		 * @return the State of the location
		 */
		public String getState() {
			return state;
		}

		/**
		 * @return the Country of the location
		 */
		public String getCountry() {
			return country;
		}

		/**
		 * @return the Zip code of the location
		 */
		public String getZip() {
			return zip;
		}

		/**
		 * @return the Latitude of the location
		 */
		public Double getLatitude() {
			return latitude;
		}

		/**
		 * @return the Longitude of the location
		 */
		public Double getLongitude() {
			return longitude;
		}

		/**
		 * @return the ID of the location
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @return the Name of the location
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the ID of the parent location of this location
		 */
		public Long getLocatedIn() {
			return located_in;
		}

		public String friendlyString() {
			String location = "";

			if (street != null && !street.trim().equals("")) {
				location += street;
			}

			if (city != null && !city.trim().equals("")) {
				if (!location.equals(""))
					location += ", ";
				location += city;
			}

			if (state != null && !state.trim().equals("")) {
				if (!location.equals(""))
					location += ", ";
				location += state;
			}

			if (zip != null && !zip.trim().equals("")) {
				if (!location.equals(""))
					location += ", ";
				location += zip;
			}

			if (country != null && !country.trim().equals("")) {
				if (!location.equals(""))
					location += ", ";
				location += country;
			}

			return location;
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

		public FqlPageLocation(){}
		
	}

}
