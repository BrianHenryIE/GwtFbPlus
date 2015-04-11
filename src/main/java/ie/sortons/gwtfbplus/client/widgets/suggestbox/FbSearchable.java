package ie.sortons.gwtfbplus.client.widgets.suggestbox;

/**
 * Interface objects must implement to be compatible with the suggest boxes
 * 
 * @author brianhenry
 * 
 */
public interface FbSearchable {

	/**
	 * The string that will be searched within when the user types. Never visible to the user.
	 * 
	 * @return
	 */
	String getSearchableString();

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