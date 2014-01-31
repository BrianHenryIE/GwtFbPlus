package ie.sortons.gwtfbplus.client.widgets.suggestbox;


import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.ui.MultiWordSuggestOracle;

/**
 * For an object to be compatible, it must implement OracleSearch which provides a Title (to be searched), a sub-title
 * (e.g. location or affiliation (college)) and a uid)
 * 
 * @author brianhenry
 * 
 */
public class Oracle extends MultiWordSuggestOracle {

	/**
	 * Interface for objects to be compatible with the suggest box
	 * 
	 * @author brianhenry
	 * 
	 */
	public interface FbSearchable {

		/**
		 * The string that will be searched within when the user types
		 * 
		 * @return
		 */
		String getSearchText();

		/**
		 * The title of the item in the suggestion list, e.g. the friend's name
		 * 
		 * @return
		 */
		String getTitle();

		/**
		 * The sub line of the suggestion-list item, e.g. the friend's location/college
		 * 
		 * @return
		 */
		String getSubTitle();

		/**
		 * The uid for getting the picture
		 * 
		 * @return
		 */
		Long getUid();

	}

	HashMap<String, FbSearchable> searchableObjects = new HashMap<String, FbSearchable>();
	
	public void add(FbSearchable suggestion) {
		searchableObjects.put(suggestion.getTitle(), suggestion);
		add(suggestion.getTitle());
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
