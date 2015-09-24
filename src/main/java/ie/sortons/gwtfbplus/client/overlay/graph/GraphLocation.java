package ie.sortons.gwtfbplus.client.overlay.graph;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * @author brianhenry
 *
 * @see https://developers.facebook.com/docs/graph-api/reference/location/
 */
public class GraphLocation extends JavaScriptObject {
	
	protected GraphLocation () {}
	

	public final native String getCity()  /*-{
		return this.city;
	}-*/;

	public final native String getCountry() /*-{
		return this.country;
	}-*/; 

	public final native Double getLatitude()  /*-{
		return this.latitude;
	}-*/;
	
	/**
	 * The parent location if this location is located within another location
	 * 
	 * @return id
	 */
	public final native String getLocatedIn()  /*-{
		return this.located_in;
	}-*/;

	public final native Double getLongitude()  /*-{
		return this.longitude;
	}-*/;
		
	public final native String getName()  /*-{
		return this.name;
	}-*/;

	public final native String getRegion() /*-{
		return this.region;
	}-*/;

	public final native String getState() /*-{
		return this.state;
	}-*/;

	public final native String getStreet() /*-{
		return this.street;
	}-*/;
	
	public final native String getZip() /*-{
		return this.zip;
	}-*/;
	
	
}