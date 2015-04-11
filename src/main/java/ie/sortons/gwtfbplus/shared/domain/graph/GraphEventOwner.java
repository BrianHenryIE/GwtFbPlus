package ie.sortons.gwtfbplus.shared.domain.graph;

import java.util.ArrayList;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;


public class GraphEventOwner implements JsonSerializable {
	String id;
	String category;
	ArrayList<GraphEventCategory> category_list;
	String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ArrayList<GraphEventCategory> getCategory_list() {
		return category_list;
	}
	public void setCategory_list(ArrayList<GraphEventCategory> category_list) {
		this.category_list = category_list;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}