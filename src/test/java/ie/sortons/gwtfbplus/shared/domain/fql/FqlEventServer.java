package ie.sortons.gwtfbplus.shared.domain.fql;


import static org.junit.Assert.*;
import ie.sortons.gwtfbplus.shared.domain.fql.FqlEvent.FqlEventDatesAdapter;
import ie.sortons.gwtfbplus.shared.domain.fql.FqlEvent.FqlEventVenue;
import ie.sortons.gwtfbplus.shared.domain.fql.FqlEvent.FqlEventVenueAdapter;

import java.util.Date;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FqlEventServer {


	// Example of start and end time present
	/*
		{
	      "eid": 180451272153080, 
	      "name": "UCDVO Film Series - Fatal Assistance", 
	      "location": "UCD Cinema Belfield", 
	      "venue": {
	        "name": "UCD Cinema Belfield"
	      }, 
	      "start_time": "2014-01-27T18:00:00+0000", 
	      "end_time": "2014-01-27T20:00:00+0000"
	    }

	 */
	String normalStartEndDateTime = "{\n\"eid\": 180451272153080,\n\"name\": \"UCDVO Film Series - Fatal Assistance\",\n\"location\": \"UCD Cinema Belfield\",\n\"venue\": {\n\"name\": \"UCD Cinema Belfield\"\n},\n\"start_time\": \"2014-01-27T18:00:00+0000\",\n\"end_time\": \"2014-01-27T20:00:00+0000\"\n}";


	// Null venue, all day event
	/*
	
    {
      "eid": 526746627433349, 
      "name": "Cliffs of Moher Day Trip - Hosted by UCD International Students' Society", 
      "location": null, 
      "venue": [
      ], 
      "start_time": "2014-01-25", 
      "end_time": null, 
      "is_date_only": true, 
      "attending_count": 94
    }
	
	*/
	String nullAllDayEvent = " {\n \"eid\": 526746627433349, \n \"name\": \"Cliffs of Moher Day Trip - Hosted by UCD International Students\' Society\", \n \"location\": null, \n \"venue\": [\n ], \n \"start_time\": \"2014-01-25\", \n \"end_time\": null, \n \"is_date_only\": true, \n \"attending_count\": 94\n }";

	
	
	
	private Gson gsonFqlEvent = new GsonBuilder().registerTypeAdapter(FqlEventVenue.class, new FqlEventVenueAdapter()).registerTypeAdapter(Date.class, new FqlEventDatesAdapter()).create();
	
	@Test
	public void test() {
	
		//  "2014-01-27T20:00:00+0000"

		FqlEvent fbEvent = gsonFqlEvent.fromJson(normalStartEndDateTime, FqlEvent.class);
		
		// System.out.println(fbEvent.getStartTime().toString());
		
		// System.out.println(fbEvent.getVenue().getName());
		
		assertEquals("error", Long.parseLong("180451272153080"), (long) fbEvent.getEid());
		
		FqlEvent nullAllDay  = gsonFqlEvent.fromJson(nullAllDayEvent, FqlEvent.class);
		
		System.out.println(nullAllDay.getAttendingCount());
		
		
	}

}
