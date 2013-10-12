package ie.sortons.gwtfbplus.server.fql;


import com.google.gson.Gson;


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

eid
name
pic_small
pic_big
pic_square
pic
host
description
start_time
end_time
creator
update_time
location
venue
privacy
hide_guest_list
can_invite_friends
all_members_count
attending_count
unsure_count
declined_count
not_replied_count


 */


public class FqlEvent {

	public FqlEvent.FqlEventItem[] getData() {
		return data;
	}

	public FqlEvent(){}

	private FqlEvent.FqlEventItem[] data; 

	public String toString(){
		Gson gson = new Gson();
		return gson.toJson(this);
	}


	public static class FqlEventItem {

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
		// private String venue;
		private String privacy;
		private String hide_guest_list;
		private String can_invite_friends;
		private String all_members_count;
		private String attending_count;
		private String unsure_count;
		private String declined_count;
		private String not_replied_count;



		//TODO
		//Do a date convert in here.

		public String toString(){
			Gson gson = new Gson();
			return gson.toJson(this);
		}
	}


}
