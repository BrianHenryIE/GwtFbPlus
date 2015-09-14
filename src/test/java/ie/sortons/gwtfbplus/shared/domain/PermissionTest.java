package ie.sortons.gwtfbplus.shared.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PermissionTest {

	@Test
	public void shouldValidatePermissions() {

		Permission p1 = new Permission();
		p1.permission = "user_location";
		p1.status = "granted";

		Permission p2 = new Permission();
		p2.permission = "user_events";
		p2.status = "granted";
		
		List<Permission> permissions = new ArrayList<Permission>();
		permissions.add(p1);
		permissions.add(p2);

		String[] desiredPassArray = { "user_location", "user_events" };
		String[] desiredFailArray = { "user_location", "user_events", "anything" };

		assertTrue(Permission.permissionsPresent(permissions, desiredPassArray));
		assertFalse(Permission.permissionsPresent(permissions, desiredFailArray));

		String desiredPassString = "user_location,user_events";
		String desiredFailString = "user_location,user_events,anything";

		assertTrue(Permission.permissionsPresent(permissions, desiredPassString));
		assertFalse(Permission.permissionsPresent(permissions, desiredFailString));

	}

}
