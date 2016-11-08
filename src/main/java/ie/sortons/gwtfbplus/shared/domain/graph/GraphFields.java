package ie.sortons.gwtfbplus.shared.domain.graph;

import java.util.List;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

/*
 * Created to help with multiple id calls
 */
public class GraphFields implements JsonSerializable {

	private GraphFeed feed;
	private GraphFeed posts;// posts if feed without others' posts
	private GraphEvents events;
	private List<GraphPage> likes;
	

	public List<GraphPage> getLikes() {
		return likes;
	}
	public void setLikes(List<GraphPage> likes) {
		this.likes = likes;
	}
	public GraphEvent getEvent() {
		return event;
	}
	public void setEvent(GraphEvent event) {
		this.event = event;
	}
	GraphEvent event;
	
	
	public GraphFeed getPosts() {
		return posts;
	}
	public void setPosts(GraphFeed posts) {
		this.posts = posts;
	}
	public GraphEvents getEvents() {
		return events;
	}
	public void setEvents(GraphEvents events) {
		this.events = events;
	}
	public GraphFeed getFeed() {
		return feed;
	}
	public void setFeed(GraphFeed feed) {
		this.feed = feed;
	}
}
