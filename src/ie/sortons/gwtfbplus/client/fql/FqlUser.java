package ie.sortons.gwtfbplus.client.fql;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;


public class FqlUser extends JavaScriptObject {
	
	protected FqlUser() { }

    // int	
    public final native String getUid() /*-{ return this.uid; }-*/;
    public final native String getFirst_name() /*-{ return this.first_name; }-*/;
    public final native String getMiddle_name() /*-{ return this.middle_name; }-*/;
    public final native String getLast_name() /*-{ return this.last_name; }-*/;
    public final native String getName() /*-{ return this.name; }-*/;
    public final native String getPic_small() /*-{ return this.pic_small; }-*/;
    public final native String getPic_big() /*-{ return this.pic_big; }-*/;
    public final native String getPic_square() /*-{ return this.pic_square; }-*/;
    public final native String getPic() /*-{ return this.pic; }-*/;

// array	
//    affiliations
    public final native JsArray<Affiliation> getAffiliations() /*-{ return this.affiliations; }-*/;

// time	
    public final native String getProfile_update_time() /*-{ return this.profile_update_time; }-*/;
    
    public final native String getTimezone() /*-{ return this.timezone; }-*/;
    public final native String getReligion() /*-{ return this.religion; }-*/;
    public final native String getBirthday() /*-{ return this.birthday; }-*/;
    public final native String getBirthday_date() /*-{ return this.birthday_date; }-*/;
    public final native String getSex() /*-{ return this.sex; }-*/;
    
// array	
//	hometown_location
    
// array	
//	meeting_sex
    
// array	
//	meeting_for
	
	 public final native String getRelationship_status() /*-{ return this.relationship_status; }-*/;

	 // uid	
	 public final native String getSignificant_other_id() /*-{ return this.significant_other_id; }-*/;
	
	 public final native String getPolitical() /*-{ return this.political; }-*/;

	 // array	
	 public final native CurrentLocation getCurrent_location() /*-{ return this.current_location; }-*/;
	 
	 public final native String getActivities() /*-{ return this.activities; }-*/;
	 public final native String getInterests() /*-{ return this.interests; }-*/;

	 // boolean
	 public final native Boolean getIs_app_user() /*-{ if (this.is_app_user) return true; else return false; }-*/;
	
	 public final native String getMusic() /*-{ return this.music; }-*/;
	 public final native String getTv() /*-{ return this.tv; }-*/;
	 public final native String getMovies() /*-{ return this.movies; }-*/;
	 public final native String getBooks() /*-{ return this.books; }-*/;
	 public final native String getQuotes() /*-{ return this.quotes; }-*/;
	 public final native String getAbout_me() /*-{ return this.about_me; }-*/;
	 
// array	
//	hs_info
	
// array	
//	education_history
	 
// array	
//	work_history

	 // int	
	 public final native Integer getNotes_count() /*-{ return this.notes_count; }-*/;

	 // int	
	 public final native Integer getWall_count() /*-{ return this.wall_count; }-*/;
	 
	 public final native String getStatus() /*-{ return this.status; }-*/;

	 // boolean	
	 public final native Boolean getHas_added_app() /*-{ if (this.has_added_app) return true; else return false; }-*/;
	 
	 public final native String getOnline_presence() /*-{ return this.online_presence; }-*/;
	 public final native String getLocale() /*-{ return this.locale; }-*/;
	 public final native String getProxied_email() /*-{ return this.proxied_email; }-*/;
	 public final native String getProfile_url() /*-{ return this.profile_url; }-*/;
	 
// array	
	//email_hashes
	
	 public final native String getPic_small_with_logo() /*-{ return this.pic_small_with_logo; }-*/;
	 public final native String getPic_big_with_logo() /*-{ return this.pic_big_with_logo; }-*/;
	 public final native String getPic_square_with_logo() /*-{ return this.pic_square_with_logo; }-*/;
	 public final native String getPic_with_logo() /*-{ return this.pic_with_logo; }-*/;
	 public final native String getAllowed_restrictions() /*-{ return this.allowed_restrictions; }-*/;

	 // boolean	
	 public final native Boolean getVerified() /*-{ if (this.verified) return true; else return false; }-*/;
	
	 public final native String getProfile_blurb() /*-{ return this.profile_blurb; }-*/;
	 
// array	
	//family

	 public final native String getUsername() /*-{ return this.username; }-*/;
	 public final native String getWebsite() /*-{ return this.website; }-*/;

	 // boolean	
	 public final native Boolean getIs_blocked() /*-{ if (this.is_blocked) return true; else return false; }-*/;

	 public final native String getContact_email() /*-{ return this.contact_email; }-*/;
	 public final native String getEmail() /*-{ return this.email; }-*/;
	 public final native String getThird_party_id() /*-{ return this.third_party_id; }-*/;
 
	 
	 
	 

	 public static class CurrentLocation extends JavaScriptObject {

		 protected CurrentLocation () { }

		 public final native String getStreet() /*-{ return this.street; }-*/;
		 public final native String getCity() /*-{ return this.city; }-*/;
		 public final native String getState() /*-{ return this.state; }-*/;
		 public final native String getCountry() /*-{ return this.country; }-*/;
		 public final native String getZip() /*-{ return this.zip; }-*/;	
		 public final native String getLatitude() /*-{ return this.latitude; }-*/;
		 public final native String getLongitude() /*-{ return this.longitude; }-*/;
		 public final native String getId() /*-{ return this.id; }-*/;
		 public final native String getName() /*-{ return this.name; }-*/;
		 public final native String getLocatedIn() /*-{ return this.located_in; }-*/;

		 
	 }
	 

	 public static class Affiliation extends JavaScriptObject {

		 protected Affiliation () { }

		 public final native String getNid() /*-{ return this.nid; }-*/;
		 public final native String getName() /*-{ return this.name; }-*/;
		 public final native String getType() /*-{ return this.type; }-*/;
		 public final native String getStatus() /*-{ return this.status; }-*/;
		 public final native String getYear() /*-{ return this.year; }-*/;

		 // needs a getLength() function
	 }
	
}
