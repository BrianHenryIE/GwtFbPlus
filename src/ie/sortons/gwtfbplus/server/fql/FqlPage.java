package ie.sortons.gwtfbplus.server.fql;

import com.google.gson.Gson;

/**

http://developers.facebook.com/docs/reference/fql/page/


*/



public class FqlPage extends Fql {

	public FqlPage() {}

	private FqlPage.FqlPageItem[] data; 

	public FqlPageItem[] getData(){
		return data;
	}
	
	public String toString(){
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	@SuppressWarnings("unused")
	public static class FqlPageItem {

		public FqlPageItem() {}
		
		private String about;
		private String access_token;
		private String affiliation;
		private String app_id;
		private String artists_we_like;
		private String attire;
		private String awards;
		private String band_interests;
		private String band_members;
		private String bio;
		private String birthday;
		private String booking_agent;

		// private Struct budget_recs;
		private String built;
		private String can_post;
		// private Struct categories;
		private String checkins;
		private String company_overview;
		private String culinary_team;
		private String current_location;
		private String description;
		private String description_html;
		private String directed_by;
		private String fan_count;
		private String features;
		private String[] food_styles;
		private String founded;
		private String general_info;
		private String general_manager;
		private String genre;
		private String global_brand_page_name;
		private String global_brand_parent_page_id;
		private String has_added_app;
		private String hometown;
		// private Struct hours;
		private String influences;
		private boolean is_community_page;
		private boolean is_permanently_closed;
		private boolean is_published;
		private boolean is_verified;
		private String keywords;
		// private Struct location;
		private String members;
		private String mission;
		private String mpg;
		
		private String name;
		
		public String getName(){
			return name;
		}
		
		private String network;
		private String new_like_count;
		private String offer_eligible;
		
		private String page_id;
		
		public String getPageId(){
			return page_id;
		}
		
		private String page_url;
		
		public String getPageUrl(){
			return page_url;
		}
		
		private String parent_page;
		// private Struct parking;
		// private Struct payment_options;
		private String personal_info;
		private String personal_interests;
		private String pharma_safety_info;
		private String phone;
		private String pic;
		private String pic_big;
		private String pic_cover;
		private String pic_large;
		private String pic_small;
		private String pic_square;
		private String plot_outline;
		private String press_contact;
		private String price_range;
		private String produced_by;
		private String products;
		private String promotion_eligible;
		private String promotion_ineligible_reason;
		private String public_transit;
		private String record_label;
		private String release_date;
		// private Struct restaurant_services;
		// private Struct restaurant_specialties;
		private String schedule;
		private String screenplay_by;
		private String season;
		private String starring;
		private String store_number;
		private String studio;
		private int talking_about_count;
		private String type;
		private String unread_message_count;
		private String unseen_message_count;
		private String unseen_notif_count;
		private String username;
		private String website;
		private int were_here_count;
		private String written_by;
		private String unread_notif_count;

		public String toString(){
			Gson gson = new Gson();
			return gson.toJson(this);
		}


	}

}
