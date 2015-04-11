package ie.sortons.gwtfbplus.shared.domain;

import ie.sortons.gwtfbplus.shared.domain.fql.FqlFriend;

import org.junit.Test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.kfuntak.gwt.json.serialization.client.Serializer;

public class FbResponseClient extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "ie.sortons.gwtfbplus.GwtFBplus";
	}

	String response = "{\n \"data\": [\n {\n \"uid2\": \"836054\"\n },\n {\n \"uid2\": \"836080\"\n },\n {\n \"uid2\": \"836170\"\n },\n {\n \"uid2\": \"837300\"\n },\n {\n \"uid2\": \"840356\"\n },\n {\n \"uid2\": \"840616\"\n },\n {\n \"uid2\": \"1212124\"\n },\n {\n \"uid2\": \"1242509\"\n },\n {\n \"uid2\": \"1619815\"\n },\n {\n \"uid2\": \"1949227\"\n },\n {\n \"uid2\": \"5304511\"\n },\n {\n \"uid2\": \"5307181\"\n },\n {\n \"uid2\": \"8705419\"\n },\n {\n \"uid2\": \"8819459\"\n },\n {\n \"uid2\": \"9119962\"\n },\n {\n \"uid2\": \"10301646\"\n },\n {\n \"uid2\": \"11521970\"\n },\n {\n \"uid2\": \"13003420\"\n },\n {\n \"uid2\": \"14215319\"\n },\n {\n \"uid2\": \"14215917\"\n },\n {\n \"uid2\": \"17402251\"\n },\n {\n \"uid2\": \"17802316\"\n },\n {\n \"uid2\": \"28601890\"\n },\n {\n \"uid2\": \"32813990\"\n },\n {\n \"uid2\": \"37300004\"\n },\n {\n \"uid2\": \"37300335\"\n },\n {\n \"uid2\": \"37300349\"\n },\n {\n \"uid2\": \"37300390\"\n },\n {\n \"uid2\": \"37300405\"\n },\n {\n \"uid2\": \"37300409\"\n },\n {\n \"uid2\": \"37300489\"\n },\n {\n \"uid2\": \"37300537\"\n },\n {\n \"uid2\": \"37300568\"\n },\n {\n \"uid2\": \"37300701\"\n },\n {\n \"uid2\": \"37300736\"\n },\n {\n \"uid2\": \"37300748\"\n },\n {\n \"uid2\": \"37300769\"\n },\n {\n \"uid2\": \"37300790\"\n },\n {\n \"uid2\": \"37300812\"\n },\n {\n \"uid2\": \"37300866\"\n },\n {\n \"uid2\": \"37300882\"\n },\n {\n \"uid2\": \"37300888\"\n },\n {\n \"uid2\": \"37300895\"\n },\n {\n \"uid2\": \"37300896\"\n },\n {\n \"uid2\": \"37300913\"\n },\n {\n \"uid2\": \"37300938\"\n },\n {\n \"uid2\": \"37300969\"\n },\n {\n \"uid2\": \"37301004\"\n },\n {\n \"uid2\": \"37301070\"\n },\n {\n \"uid2\": \"37301104\"\n },\n {\n \"uid2\": \"37301110\"\n },\n {\n \"uid2\": \"37301161\"\n },\n {\n \"uid2\": \"37301176\"\n },\n {\n \"uid2\": \"37301305\"\n },\n {\n \"uid2\": \"37301314\"\n },\n {\n \"uid2\": \"37301317\"\n },\n {\n \"uid2\": \"37301336\"\n },\n {\n \"uid2\": \"37301342\"\n },\n {\n \"uid2\": \"37301411\"\n },\n {\n \"uid2\": \"37301474\"\n },\n {\n \"uid2\": \"37301484\"\n },\n {\n \"uid2\": \"37301486\"\n },\n {\n \"uid2\": \"37301488\"\n },\n {\n \"uid2\": \"37301524\"\n },\n {\n \"uid2\": \"37301533\"\n },\n {\n \"uid2\": \"37301589\"\n },\n {\n \"uid2\": \"37301599\"\n },\n {\n \"uid2\": \"37301615\"\n },\n {\n \"uid2\": \"37301640\"\n }\n ]\n}";

	@SuppressWarnings("unchecked")
	@Test
	public void test() {

		Serializer serializer = (Serializer) GWT.create(Serializer.class);

		FbResponse<FqlFriend> obj = (FbResponse<FqlFriend>) serializer.deSerialize(response, "ie.sortons.gwtfbplus.shared.domain.FbResponse"); // ie.sortons.gwtfbplus.shared.domain.fql.FqlFriend

	}

	
}
