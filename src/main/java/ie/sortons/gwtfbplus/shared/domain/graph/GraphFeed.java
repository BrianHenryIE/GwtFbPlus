package ie.sortons.gwtfbplus.shared.domain.graph;

import java.util.List;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

public class GraphFeed implements JsonSerializable {
	
	private List<GraphFeedItem> data;
	
	FbPaging paging;

	public List<GraphFeedItem> getData() {
		return data;
	}

	public void setData(List<GraphFeedItem> data) {
		this.data = data;
	}

	public FbPaging getPaging() {
		return paging;
	}

	public void setPaging(FbPaging paging) {
		this.paging = paging;
	}
	
	
	
}