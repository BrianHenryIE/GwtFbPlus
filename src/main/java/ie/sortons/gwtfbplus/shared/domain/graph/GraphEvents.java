package ie.sortons.gwtfbplus.shared.domain.graph;

import java.util.List;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

/*


"events": {
      "data": [
        {
          "description": "***Welcome to Wonderland Freshers***

On Thursday September 22nd Snowsports, DUBES, DUDJ and Trinity Ents invite you to join us on our descent down the rabbit hole into the TURKS HEAD where we’ll consume some magical elixirs and paint the roses red.

Come along and explore this eclectic venue as you unwind the night to find three different rooms each with their own distinct musical vibes including up & coming Dublin rappers Damola and Sam Ojo.

http://www.wordupcollective.com/sam-ojo/

http://www.wordupcollective.com/damola/

***Tickets***
Can be purchased from the DUBES & Snowsports stands in front square from Monday September 19th onwards! For €7  you will gain entry to this magical night and membership of either society.

***Dress Code***
This Tea Party will be well and truly bonkers and we invite you to dispel your inhibitions and embrace your inner Mad Hatter!",
          "end_time": "2016-09-23T00:00:00+0100",
          "name": "House of Hatters",
          "place": {
            "name": "Turks Head Dublin",
            "location": {
              "city": "Dublin",
              "country": "Ireland",
              "latitude": 53.344833074571,
              "longitude": -6.26747,
              "zip": "dubli"
            },
            "id": "7748609247"
          },
          "start_time": "2016-09-22T22:00:00+0100",
          "id": "144334812684489"
        },
        {
          "description": "|||||LINE UP ANNOUNCED SOON|||||

They say that paradise is not a place but a state of mind.

Well this Freshers Week Wednesday night Paradise is a very real place.

Get lost among the clouds, follow the crowds and join us in heaven (on earth) for a night of glittering debauchery and dancing. 

Let DU Players and VDP whisk you away, sprinkle you in sparkles and keep the Freshers Ball going long after the clock strikes 12.

Just because you’re in heaven doesn’t mean you have to behave like an angel. Come and dance the night away with all of the other saints and sinners of sesh.

Let your dreams get caught and live your wildest Freshers fantasies on the dance floor of The Academy. 

This will be the Freshers’ Ball of all your dreams.

Disclaimer: There will be excessive amounts of glitter in the air so be prepared to sparkle whether you like it or not.",
          "end_time": "2016-09-22T04:00:00+0100",
          "name": "Freshers Ball",
          "place": {
            "name": "The Academy",
            "location": {
              "city": "Dublin",
              "country": "Ireland",
              "latitude": 53.347746217131,
              "longitude": -6.2619139498852,
              "street": "57 Middle Abbey Street",
              "zip": "1"
            },
            "id": "112813520933"
          },
          "start_time": "2016-09-21T22:00:00+0100",
          "id": "295586397479604"
        }
      ],
      "paging": {
        "cursors": {
          "before": "MTQ0MzM0ODEyNjg0NDg5",
          "after": "Mjk1NTg2Mzk3NDc5NjA0"
        },
        "next": "https://graph.facebook.com/v2.7/131737309490/events?access_token=EAACEdEose0cBAMDa0FfZANqYVJ23Ugtpjq02a6XnpwZCdtVgDY0W4bz27Nkb8q2mcuEDZCaiR6ZAJ7oL06iP8lZBqrfh6nzRahZAmrA9mvknANbCPBGFSXTWYFjNcSt3GAbk9Nr2JuKWcyZCl2EGo8xGRENSMMUmhZCouKvHqXADwAZDZD&pretty=0&limit=2&after=Mjk1NTg2Mzk3NDc5NjA0"
      }
    },


*/
public class GraphEvents implements JsonSerializable {

	private List<GraphEvent> data;

	private FbPaging paging;

	public List<GraphEvent> getData() {
		return data;
	}

	public void setData(List<GraphEvent> data) {
		this.data = data;
	}

	public FbPaging getPaging() {
		return paging;
	}

	public void setPaging(FbPaging paging) {
		this.paging = paging;
	}
	
	
}
