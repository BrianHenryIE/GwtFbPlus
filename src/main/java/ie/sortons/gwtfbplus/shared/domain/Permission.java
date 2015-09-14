package ie.sortons.gwtfbplus.shared.domain;

import java.util.List;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

/*

{
    "data": [
        {
            "permission": "user_location",
            "status": "granted"
        },
        {
            "permission": "user_events",
            "status": "granted"
        },
        {
            "permission": "user_friends",
            "status": "granted"
        },
        {
            "permission": "public_profile",
            "status": "granted"
        },
        {
            "permission": "installed",
            "status": "granted"
        }
    ]
}

*/
public class Permission implements JsonSerializable {

	public String permission;
	public String status;

	
	/**
	 * Check a comma separated list of permissions to see if they're present
	 * 
	 * @param granted
	 * @param desired
	 * @return
	 */
	public static boolean permissionsPresent(List<Permission> granted, String desired) {

		String[] desiredArray = desired.split(",");

		return permissionsPresent(granted, desiredArray);

	}

	/**
	 * Check all desired permissions are present
	 * 
	 * @param granted
	 * @param desired
	 * @return
	 */
	public static boolean permissionsPresent(List<Permission> granted, String[] desired) {

		for (String desire : desired) {
			boolean present = false;

			// Check each of the permissions we have
			for (Permission permission : granted)
				if (permission.permission.equals(desire) && permission.status.equals("granted"))
					present = true;

			if (present == false)
				return false;
		}

		return true;

	}

}
