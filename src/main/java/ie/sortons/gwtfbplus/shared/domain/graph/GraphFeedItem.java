package ie.sortons.gwtfbplus.shared.domain.graph;

import java.util.Date;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

public class GraphFeedItem implements JsonSerializable {
	String message;
	String story;
	Date created_time; // 2016-08-22T20:06:02+0000
	String id;
	String link;
	String status_type;
	
	public String getStatus_type() {
		return status_type;
	}

	public void setStatus_type(String status_type) {
		this.status_type = status_type;
	}

	public String getMessage() {
		return message;
	}
	
	public enum StatusType {mobile_status_update, created_note, added_photos, added_video, shared_story, created_group, created_event, wall_post, app_created_story, published_story, tagged_in_photo, approved_friend}
	
	public StatusType type() {
		return StatusType.valueOf(status_type);
	}

	/**
	 * @return The link attached to this post.
	 */
	public String getLink() {
		return link;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setLink(String link) {
		this.link = link;
	}

}