package ie.sortons.gwtfbplus.client.widgets.suggestbox;


import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.ui.MultiWordSuggestOracle;


/**
 * Extended MultiWordSuggestOracle to allow using objects (which implement FbSearchable).
 * Should probably extend SuggestOracle directly, but this is working. 
 * 
 * Should definitely be rewritten. We're using the searchable string as an key
 * 
 * @author brianhenry
 *
 */
public class Oracle extends MultiWordSuggestOracle {

	HashMap<String, FbSearchable> searchableObjects = new HashMap<String, FbSearchable>();
	
	public void add(FbSearchable suggestion) {
		searchableObjects.put(suggestion.getSearchableString(), suggestion);
		add(suggestion.getSearchableString());
	}
	
	public void addAll(List<FbSearchable> suggestions) {
		for(FbSearchable suggestion : suggestions) {
			add(suggestion);
		}
		System.out.println("searchableObjects.size() " + searchableObjects.size());
	}
	 
	public void remove(FbSearchable suggestion){
		searchableObjects.remove(suggestion.getSearchableString());
		super.clear();
		addAll(searchableObjects.keySet());
	}
	
	@Override
	public void clear(){
		super.clear();
		searchableObjects.clear();
	}

	@Override
	protected FbSuggestionWidget createSuggestion(String replacementString, String displayString) {
		FbSearchable found = searchableObjects.get(replacementString);
		return new FbSuggestionWidget(found);
	}

	public void setSearchItems(List<FbSearchable> items) {
		for (FbSearchable item : items)
			add(item);
	}


}
