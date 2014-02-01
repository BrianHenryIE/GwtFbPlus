package ie.sortons.gwtfbplus.client.widgets.suggestbox;


import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.ui.MultiWordSuggestOracle;


/**
 * Extended MultiWordSuggestOracle to allow using objects (which implement FbSearchable) and the nicer prediction
 * 
 * @author brianhenry
 *
 */
public class Oracle extends MultiWordSuggestOracle {

	HashMap<String, FbSearchable> searchableObjects = new HashMap<String, FbSearchable>();
	
	public void add(FbSearchable suggestion) {
		searchableObjects.put(suggestion.getTitle(), suggestion);
		add(suggestion.getTitle());
	}
	
	public void addAll(List<FbSearchable> suggestions) {
		for(FbSearchable suggestion : suggestions) {
			searchableObjects.put(suggestion.getTitle(), suggestion);
			add(suggestion.getTitle());
		}
	}
	
	@Override
	public void clear(){
		super.clear();
		searchableObjects.clear();
	}

	@Override
	protected FbSuggestion createSuggestion(String replacementString, String displayString) {
		FbSearchable found = searchableObjects.get(replacementString);
		return new FbSuggestion(found);
	}

	public void setSearchItems(List<FbSearchable> items) {
		for (FbSearchable item : items)
			add(item);
	}


}
