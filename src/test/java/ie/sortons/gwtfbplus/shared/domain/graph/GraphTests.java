package ie.sortons.gwtfbplus.shared.domain.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class GraphTests {

	Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
		@Override
		public Date deserialize(JsonElement json, Type type, JsonDeserializationContext context)
				throws JsonParseException {
			try {
				return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(json.getAsString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	}).create();

	@Test
	public void testGraphPageParsing() throws UnsupportedEncodingException, IOException, URISyntaxException {

		// 131737309490?fields=about,phone,name,id,link,location
		String resource = "/GraphPage.json";
		assertNotNull("Test file missing: " + resource, getClass().getResource(resource));
		URL url = getClass().getResource(resource);
		Path resPath = Paths.get(url.toURI());
		String json = new String(Files.readAllBytes(resPath), "UTF8");

		GraphPage gp = gson.fromJson(json, GraphPage.class);

		assertEquals(gp.getAbout(), "Please visit:  http://www.trinityents.com");

		assertEquals(gp.getLocation().getCity(), "Dublin");
		assertEquals(gp.getLocation().getLatitude(), 53.34542, 5);
		assertEquals(gp.getLocation().getLocated_in(), "107652805959910");
		assertEquals(gp.getLocation().getLatitude(), -6.25825, 5);

		assertEquals(gp.getName(), "Trinity Ents");
		assertEquals(gp.getId(), "131737309490");
		assertEquals(gp.getLink(), "https://www.facebook.com/trinityents/");

	}

	@Test
	public void testFeedParsing() throws URISyntaxException, UnsupportedEncodingException, IOException {

		// Get GraphFeedResponse object from src/test/resources
		String resource = "/GraphFeedForSinglePage.json";
		assertNotNull("Test file missing: " + resource, getClass().getResource(resource));
		URL url = getClass().getResource(resource);
		Path resPath = Paths.get(url.toURI());
		String json = new String(Files.readAllBytes(resPath), "UTF8");

		GraphFeedResponse gfr = gson.fromJson(json, GraphFeedResponse.class);

		assertEquals(gfr.getId(), "131737309490");

		assertEquals(gfr.getFeed().getData().size(), 25);
	}

	@Test
	public void testGraphEventParsing() throws URISyntaxException, UnsupportedEncodingException, IOException {

		// Get json from src/test/resources
		String resource = "/GraphEvent.json";
		assertNotNull("Test file missing: " + resource, getClass().getResource(resource));
		URL url = getClass().getResource(resource);
		Path resPath = Paths.get(url.toURI());
		String json = new String(Files.readAllBytes(resPath), "UTF8");

		GraphEvent parsedEvent = gson.fromJson(json, GraphEvent.class);

		assertEquals("1136803873075556", parsedEvent.getId());
		
		assertEquals("Dublin", parsedEvent.getPlace().getLocation().getCity());

	}

	@Test
	public void testMultipleEventParsing() throws URISyntaxException, UnsupportedEncodingException, IOException {

		// Get json from src/test/resources
		String resource = "/MultipleGraphEvents.json";
		assertNotNull("Test file missing: " + resource, getClass().getResource(resource));
		URL url = getClass().getResource(resource);
		Path resPath = Paths.get(url.toURI());
		String json = new String(Files.readAllBytes(resPath), "UTF8");

		Type stringStringMap = new TypeToken<Map<String, GraphEvent>>() {
		}.getType();
		Map<String, String> gfr = gson.fromJson(json, stringStringMap);

		assertEquals(gfr.size(), 8);
	}

	@Test
	public void testEventsParsing() throws URISyntaxException, UnsupportedEncodingException, IOException {

		// Get GraphFeedResponse object from src/test/resources
		String resource = "/GraphEventsForSinglePage.json";
		assertNotNull("Test file missing: " + resource, getClass().getResource(resource));
		URL url = getClass().getResource(resource);
		Path resPath = Paths.get(url.toURI());
		String json = new String(Files.readAllBytes(resPath), "UTF8");

		GraphEventsResponse ger = gson.fromJson(json, GraphEventsResponse.class);

		assertEquals(ger.getId(), "131737309490");

		assertEquals(ger.getEvents().getData().get(0).getName(), "House of Hatters");
	}

	@Test
	public void testMultipleIdEventsAndFeedParsing()
			throws URISyntaxException, UnsupportedEncodingException, IOException {

		// ?ids=131737309490,139957459378369&fields=events.limit(2),feed.limit(2)

		// Get GraphFeedResponse object from src/test/resources
		String resource = "/GraphEventsAndFeedForTwoPages.json";
		assertNotNull("Test file missing: " + resource, getClass().getResource(resource));
		URL url = getClass().getResource(resource);
		Path resPath = Paths.get(url.toURI());
		String json = new String(Files.readAllBytes(resPath), "UTF8");

		Type stringGraphFieldsMap = new TypeToken<Map<String, GraphFields>>() {
		}.getType();

		Map<String, GraphFields> gmi = gson.fromJson(json, stringGraphFieldsMap);

		assertEquals(gmi.get("131737309490").getEvents().getData().size(), 2);

		assertEquals(gmi.get("139957459378369").getFeed().getData().size(), 2);
	}

	// trinity ents: 131737309490
	// ucdsuents: 139957459378369

	// 131737309490?fields=events
	// 131737309490?fields=feed

	// ?ids=131737309490,139957459378369&fields=events

	// FbEventsNetwork fben = new FbEventsNetwork(access token);

	// GraphEventsForSinglePage.json

	// GraphFeedForSinglePage.json

	// obj.getEventsFor(array)
}
