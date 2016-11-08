package ie.sortons.gwtfbplus.shared.domain.graph;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

/**
 *
 * @see https://developers.facebook.com/docs/graph-api/reference/location/
 */
public class GraphLocation implements JsonSerializable {
	
	/*
	 * City
	 */
	String city;

	/*
	 * City ID. Any city identified is also a city you can use for targeting
	 * ads.
	 */
	String city_id;

	/*
	 * Country
	 */
	String country;

	/*
	 * Country code
	 */
	String country_code;

	/*
	 * Latitude
	 */
	Double latitude;

	/*
	 * The parent location if this location is located within another location
	 */
	String located_in;

	/*
	 * Longitude
	 */
	Double longitude;

	/*
	 * Name
	 */
	String name;

	/*
	 * Region
	 */
	String region;

	/*
	 * Region ID.Specifies a geographic region, such as California. An
	 * identified region is the same as one you can use to target ads.
	 */
	String region_id;

	/*
	 * State
	 */
	String state;

	/*
	 * Street
	 */
	String street;

	/*
	 * Zip code
	 */
	String zip;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getLocated_in() {
		return located_in;
	}

	public void setLocated_in(String located_in) {
		this.located_in = located_in;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
