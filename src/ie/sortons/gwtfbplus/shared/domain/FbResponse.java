package ie.sortons.gwtfbplus.shared.domain;

import java.util.ArrayList;

import com.kfuntak.gwt.json.serialization.client.JsonSerializable;

public class FbResponse<T> {

	public ArrayList<T> data;

	public ArrayList<T> getData() {
		return data;
	}

	public FbError error;

	public FbError getError() {
		return error;
	}

}
