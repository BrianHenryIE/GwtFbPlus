package ie.sortons.gwtfbplus.shared.domain.graph;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

/*

{
  "feed": {
    "data": [
      {
        "message": "Make sure to click attending to keep up to date with the Freshers' Week lineup as it's released!",
        "story": "Trinity Ents shared their event.",
        "created_time": "2016-08-22T20:06:02+0000",
        "id": "131737309490_10154418705074491"
      }
    ],
    "paging": {
      "previous": "https://graph.facebook.com/v2.7/131737309490/feed?since=1473364130&access_token=EAACEdEose0cBAOTXsEhjCchuZBZCDBQjcOMjguYZB8veU2eZCJzF8NSt6XcbhhKUkz5fczdBOZCqHtgmvEXetcn72Kx6nCcQoxDkqWQHaOZB5JO5WzwYYrAKlWO7MN6GWzafXx43gUdFgOlAZCROcgXph7AUiRY4Vc0bOpH1aSiPQZDZD&limit=25&__paging_token=enc_AdB3BUnmTQtZBN2zXgzMq8flaD9jOjBKA0ZATN6E4ZA5oanF0YfK485zei6R42ZBFz3ZCLoZCZBUCcERGXpUzF7mkoMejDH&__previous=1",
      "next": "https://graph.facebook.com/v2.7/131737309490/feed?access_token=EAACEdEose0cBAOTXsEhjCchuZBZCDBQjcOMjguYZB8veU2eZCJzF8NSt6XcbhhKUkz5fczdBOZCqHtgmvEXetcn72Kx6nCcQoxDkqWQHaOZB5JO5WzwYYrAKlWO7MN6GWzafXx43gUdFgOlAZCROcgXph7AUiRY4Vc0bOpH1aSiPQZDZD&limit=25&until=1471896362&__paging_token=enc_AdDxgP5Mzy1q3excBQ4rX7e7LLjiaJJqFhUufBYQ5Ac8XoABhdblWHnIol6tPZCaDZBnAuJDNxnnkbtsL9IQWYfm9ZCZCuC6LgloOEZADVS9cjlwxqQZDZD"
    }
  },
  "id": "131737309490"
}

*/

public class GraphFeedResponse implements JsonSerializable {

	private GraphFeed feed;
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public GraphFeed getFeed() {
		return feed;
	}

	public void setFeed(GraphFeed feed) {
		this.feed = feed;
	}
}
