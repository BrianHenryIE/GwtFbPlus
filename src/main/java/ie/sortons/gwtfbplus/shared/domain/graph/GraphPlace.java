package ie.sortons.gwtfbplus.shared.domain.graph;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

/*

place": {
    "name": "Trinity Ents",
    "location": {
      "city": "Dublin",
      "country": "Ireland",
      "latitude": 53.34542,
      "located_in": "107652805959910",
      "longitude": -6.25825
    },

*/

/*
 * @see https://developers.facebook.com/docs/graph-api/reference/place/
 */
public class GraphPlace implements JsonSerializable {

	String id;
    String name;
    GraphLocation location;
    Float overall_rating;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GraphLocation getLocation() {
		return location;
	}
	public void setLocation(GraphLocation location) {
		this.location = location;
	}
	public Float getOverall_rating() {
		return overall_rating;
	}
	public void setOverall_rating(Float overall_rating) {
		this.overall_rating = overall_rating;
	}
    
    
}
