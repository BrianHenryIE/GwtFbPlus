package ie.sortons.gwtfbplus.shared.domain;

import java.util.ArrayList;

public class FbResponse<T> {

	public ArrayList<T> data;

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(ArrayList<T> data) {
		this.data = data;
	}

	public ArrayList<T> getData() {
		return data;
	}

	public FbError error;

	public FbError getError() {
		return error;
	}

}
