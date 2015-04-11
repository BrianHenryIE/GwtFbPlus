package ie.sortons.gwtfbplus.shared.domain.graph;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

public class GraphEventCover implements JsonSerializable {
	/**
	 * ID of the Photo that represents this cover photo.
	 */
	String id;

	/**
	 * URL to the Photo that represents this cover photo.
	 */
	String source;

	/**
	 * The vertical offset in pixels of the photo from the bottom.
	 */
	int offset_y;

	/**
	 * The horizontal offset in pixels of the photo from the left.
	 */
	int offset_x;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getOffset_y() {
		return offset_y;
	}

	public void setOffset_y(int offset_y) {
		this.offset_y = offset_y;
	}

	public int getOffset_x() {
		return offset_x;
	}

	public void setOffset_x(int offset_x) {
		this.offset_x = offset_x;
	}
	
	
}