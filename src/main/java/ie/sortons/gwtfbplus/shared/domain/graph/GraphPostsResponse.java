package ie.sortons.gwtfbplus.shared.domain.graph;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

/*



*/

public class GraphPostsResponse implements JsonSerializable {

	private GraphFeed posts;
	
	private String id;

	public GraphFeed getPosts() {
		return posts;
	}

	public void setPosts(GraphFeed posts) {
		this.posts = posts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
