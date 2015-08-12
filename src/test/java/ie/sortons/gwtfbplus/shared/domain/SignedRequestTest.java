package ie.sortons.gwtfbplus.shared.domain;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SignedRequestTest {

	
	@Test
	public void testDecode() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException{
		
		//String sr = "muteG_RH_VtDyOsESNbuo6lJ0hMrQZ5fLqWcVPoROJ4.eyJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImV4cGlyZXMiOjE0Mzg4ODc2MDAsImlzc3VlZF9hdCI6MTQzODg4MDU2Mywib2F1dGhfdG9rZW4iOiJDQUFEa3Buanl5RXdCQU9FVE5OOXpYY0RRUXVDTm5PUGNlekxuVDliTDNjWFpBV1pCR3J3NGVaQ1RRV3RpV2haQ3VaQjFZWUFaQzdKS0JrajlFbTRmemY3dU50clFKY2YzZTdZUWVrMGJtR1pCRUxHMU42VEoxRzZBVHZIZUgwMlFxYURuVUloSGM3YlpDZ3NkY2o5b2lrUkhEVGcyV3BTWTk5NXhaQ2VpakRob2oxd1RIeVBTMzRFbDJGVGFBcnRaQ2J3a1lIZ0VNNFpDTjZyRWt3VkxuZmViYU52SG5iQTRLc2U4SG9aRCIsInVzZXIiOnsiY291bnRyeSI6ImllIiwibG9jYWxlIjoiZW5fVVMiLCJhZ2UiOnsibWluIjoyMX19LCJ1c2VyX2lkIjoiMzczMDI1MjAifQ";
		
		String sr = "6nYHvr5JAAFBRJJrrj7KXtotLqgFdKmuu0aEkUUOyUc.eyJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImV4cGlyZXMiOjE0Mzg4ODc2MDAsImlzc3VlZF9hdCI6MTQzODg4MjY3NCwib2F1dGhfdG9rZW4iOiJDQUFEa3Buanl5RXdCQUtla1Y0UFpCNGtRbHNwbVNaQnBTUVBsREZkSXl0UW1yWkJ0YzhBdmd0UTUxaUxSbzI2SVI5NXcxaUdjNTBBSXVySENLa09iUmxqRmVuNUVLaXNsRFdtSkxaQmdsN1hDNEpCSElocmhua1NJQkZ0ZFRkaFZaQk1DRUtZdVN0T1A0UXUwaUFBRTFKQ2hmNWtaQ2tRQjNwVmdrSEtLalVZbDhCNVVPYnQ1MmlyQUNGRTJLTVB1Tm83RzBiWkFZeHphWEJoYWhQWkFnTGw0RElxUWJvb2Z5dndaRCIsInVzZXIiOnsiY291bnRyeSI6ImllIiwibG9jYWxlIjoiZW5fVVMiLCJhZ2UiOnsibWluIjoyMX19LCJ1c2VyX2lkIjoiMzczMDI1MjAifQ";
		
		
		String appSecret = "bde441e69903f031b2be8a399366c160";
		
		SignedRequest parsed = SignedRequestTest.parseSignedRequest(sr, appSecret);
		
		assertTrue(parsed.getUserId().equals("37302520"));
	
		
	}
	
	public static SignedRequest parseSignedRequest(String signed_request, String appSecret) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {

		String signature = signed_request.split("[.]", 2)[0].replace("-", "+").replace("_", "/");
		
		System.out.println("The signature part of the sr: " + signature);
		
		byte[] sig64 = new Base64(true).decode(signature.getBytes("UTF-8"));
		
		System.out.println("The Base64decoded part of the sr sig: " + sig64);
		
		
		String payLoad = signed_request.split("[.]", 2)[1];
	
			// as per the example on developers.facebook.com
			payLoad = payLoad.replace("-", "+").replace("_", "/").trim();
			String jsonString = new String(new Base64(true).decode(payLoad.getBytes("UTF-8")));

		SecretKey signingKey = new SecretKeySpec(appSecret.getBytes(), "HMACSHA256");
		Mac mac = Mac.getInstance("HMACSHA256");
        mac.init(signingKey);
        
        // Compute the hmac on input data bytes
        byte[] rawHmac = mac.doFinal(payLoad.getBytes());

        
        System.out.println("sig64 length: " + sig64.length);
        
        System.out.println("rawHmac equal? " + (rawHmac.equals(sig64)));
        
        System.out.println("rawHmac length: " + rawHmac.length);
        
        // Convert raw bytes to Hex
        byte[] hexBytes = new Hex().encode(rawHmac);

        System.out.println("hexbytes equal? " + (hexBytes.equals(sig64)));
        
        System.out.println("hexbytes length: " + hexBytes.length);
        
        //  Covert array of Hex bytes to a String
        String expectedSignature = new String(hexBytes, "UTF-8");
        
        byte[] bs = new Base64(true).decode(signature.getBytes("UTF-8"));
        
       System.out.println("signature: " + new String(bs) );
        System.out.println("expectedSignature: " + expectedSignature);
        
		Gson gson = new GsonBuilder().create();
		SignedRequest signedrequest = gson.fromJson(jsonString, SignedRequest.class);
		

		return signedrequest;
	}

}
