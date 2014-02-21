package ie.sortons.gwtfbplus.shared.domain.fql;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;
import com.kfuntak.gwt.json.serialization.client.SkipNullSerialization;

/**
 * An FQL table that can be used to return a list of a user's friends or to show whether two users are friends.
 * 
 * @see https://developers.facebook.com/docs/reference/fql/friend/
 */
@SkipNullSerialization
public class FqlFriend implements JsonSerializable {

	public Long getUid1() {
		return uid1;
	}

	public Long getUid2() {
		return uid2;
	}

	public FqlFriend() {
	}

	public Long uid1;
	public Long uid2;

}
