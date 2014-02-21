package ie.sortons.gwtfbplus.client.widgets.suggestbox;


import com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion;

public class FbSuggestionWidget extends MultiWordSuggestion {

	private Long uid;
	private String name;
	private String subtitle;
	private FbSearchable object;

	public FbSuggestionWidget(FbSearchable object) {
		this.object = object;
		this.name = object.getTitle();
		this.uid = object.getUid();
		this.subtitle = object.getSubTitle();
	}

	@Override
	public String getDisplayString() {
		// This is what is shown.
		String element = "<div class=\"itemDiv\">"
				+ "<div style=\"display: inline-block; position: relative; float: left; height: 32px;\"><img class=\"ffoPic\" style=\"width: 25px; height: 25px;\" src=\"//graph.facebook.com/"
				+ uid + "/picture?type=square" + "\" /></div>" + "<div style=\"float: left; display: inline-block; position: relative;\"><div class=\"ffoName\">" + name + "</div>"
				+ "<div class=\"ffoNetwork\">" + subtitle + "</div>" + "</div>";
		return element;
	}

	@Override
	public String getReplacementString() {
		return name;
	}

	public Long getUid() {
		return uid;
	}
	
	public FbSearchable getObject(){
		return object;
	}

}