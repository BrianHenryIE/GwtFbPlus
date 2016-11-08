package ie.sortons.gwtfbplus.shared.domain.graph;


/*

{
  "events": {
    "data": [
    
    ],
    "paging": {
      "cursors": {
        "before": "MTQ0MzM0ODEyNjg0NDg5",
        "after": "OTIyNjc0MzIxMTUyMDU1"
      },
      "next": "https://graph.facebook.com/v2.7/131737309490/events?access_token=EAACEdEose0cBAOTXsEhjCchuZBZCDBQjcOMjguYZB8veU2eZCJzF8NSt6XcbhhKUkz5fczdBOZCqHtgmvEXetcn72Kx6nCcQoxDkqWQHaOZB5JO5WzwYYrAKlWO7MN6GWzafXx43gUdFgOlAZCROcgXph7AUiRY4Vc0bOpH1aSiPQZDZD&pretty=0&limit=25&after=OTIyNjc0MzIxMTUyMDU1"
    }
  },
  "id": "131737309490"
}

*/
public class GraphEventsResponse {
	private GraphEvents events;
	private String id;
	public GraphEvents getEvents() {
		return events;
	}
	public void setEvents(GraphEvents events) {
		this.events = events;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
