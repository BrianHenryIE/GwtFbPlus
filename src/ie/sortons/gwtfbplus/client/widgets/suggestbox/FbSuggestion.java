package ie.sortons.gwtfbplus.client.widgets.suggestbox;


import com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion;

public class FbSuggestion extends MultiWordSuggestion {

	private Long uid;
	private String name;
	private String subtitle;
	private FbSearchable object;

	public FbSuggestion(FbSearchable object) {
		this.object = object;
		this.name = object.getTitle();
		this.uid = object.getUid();
		this.subtitle = object.getSubTitle();
	}

	@Override
	public String getDisplayString() {
		// This is what is shown.
		String element = "<div class=\"itemDiv\">"
				+ "<div style=\"float:left; height: 32px;\"><img class=\"ffoPic\" style=\"width: 25px; height: 25px;\" src=\"//graph.facebook.com/"
				+ uid + "/picture?type=square" + "\" /></div>" + "<div style=\"float:left;\"><div class=\"ffoName\">" + name + "</div>"
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