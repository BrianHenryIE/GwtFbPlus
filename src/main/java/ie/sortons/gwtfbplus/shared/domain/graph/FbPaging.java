package ie.sortons.gwtfbplus.shared.domain.graph;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

/*

Different types: cursor, time, index



 "paging": {
        "cursors": {
          "before": "MTQ0MzM0ODEyNjg0NDg5",
          "after": "Mjk1NTg2Mzk3NDc5NjA0"
        },
        "next": "https://graph.facebook.com/v2.7/131737309490/events?access_token=EAACEdEose0cBAMDa0FfZANqYVJ23Ugtpjq02a6XnpwZCdtVgDY0W4bz27Nkb8q2mcuEDZCaiR6ZAJ7oL06iP8lZBqrfh6nzRahZAmrA9mvknANbCPBGFSXTWYFjNcSt3GAbk9Nr2JuKWcyZCl2EGo8xGRENSMMUmhZCouKvHqXADwAZDZD&pretty=0&limit=2&after=Mjk1NTg2Mzk3NDc5NjA0"
      }




*/

public class FbPaging implements JsonSerializable {

	private FbPagingCursor cursors;
	private String previous;
	private String next;

	public FbPagingCursor getCursors() {
		return cursors;
	}

	public void setCursors(FbPagingCursor cursors) {
		this.cursors = cursors;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

}