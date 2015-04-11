package ie.sortons.gwtfbplus.shared.domain.fql;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;
import com.kfuntak.gwt.json.serialization.client.SkipNullSerialization;

/**
 * 
 * { "data": [ { "uid": 118467031573937, "eid": 290199141098468, "rsvp_status": "", "start_time":
 * "2012-11-08T15:30:00+0000" },
 * 
 * @author brianhenry
 * 
 */
@SkipNullSerialization
public class FqlEventMember implements JsonSerializable {

	public FqlEventMember() {
	}

	public Long getEid() {
		return eid;
	}

	public Long getInviter() {
		return inviter;
	}

	public String getInviter_type() {
		return inviter_type;
	}

	public String getRsvp_status() {
		return rsvp_status;
	}

	public String getStart_time() {
		return start_time;
	}

	public Long getUid() {
		return uid;
	}

	public Long eid;
	public Long inviter;
	public String inviter_type;
	public String rsvp_status;
	public String start_time;
	public Long uid;

}