package ie.sortons.gwtfbplus.shared.domain.graph;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

/*

 "category_list": [
 {
 "id": "191478144212980",
 "name": "Night Club"
 }
 ],

 "hours": {
 "mon_1_open": "20:30",
 "mon_1_close": "23:00",
 "sun_1_open": "20:30",
 "sun_1_close": "23:00"
 },

 "location": {
 "street": "1 Dame Court",
 "city": "Dublin",
 "state": "",
 "country": "Ireland",
 "zip": "Dublin 2",
 "latitude": 53.3438380291,
 "longitude": -6.26365568793
 },
 "restaurant_services": {
 "reserve": 0,
 "walkins": 1,
 "groups": 1,
 "kids": 0,
 "takeout": 0,
 "delivery": 0,
 "catering": 0,
 "waiter": 0,
 "outdoor": 0
 },
 "restaurant_specialties": {
 "breakfast": 0,
 "lunch": 0,
 "dinner": 0,
 "coffee": 0,
 "drinks": 1
 },

 "cover": {
 "cover_id": "10151220863767331",
 "source": "http://scontent-a.xx.fbcdn.net/hphotos-ash2/t1/s720x720/423071_10151220863767331_33838847_n.jpg",
 "offset_y": 0,
 "offset_x": 0

 */

public class GraphPage implements JsonSerializable {

	public GraphPage() {
	}

	/**
	 * @return the about
	 */
	public String getAbout() {
		return about;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return the checkins
	 */
	public String getCheckins() {
		return checkins;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the is_published
	 */
	public String isIs_published() {
		return is_published;
	}

	/**
	 * @return the talking_about_count
	 */
	public String getTalking_about_count() {
		return talking_about_count;
	}

	/**
	 * @return the were_here_count
	 */
	public String getWere_here_count() {
		return were_here_count;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @return the likes
	 */
	public String getLikes() {
		return likes;
	}

	public String about;
	public String category;
	// category_list
	public String checkins;
	public String description;
	// hours
	public String is_published;
	// location
	// restaurant_services
	// restaurant_specialties
	public String talking_about_count;
	public String were_here_count;
	public Long id;
	public String name;
	public String link;
	public String likes;
	// cover

}
