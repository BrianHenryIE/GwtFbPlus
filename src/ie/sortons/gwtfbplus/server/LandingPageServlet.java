package ie.sortons.gwtfbplus.server;

import ie.sortons.gwtfbplus.shared.domain.SignedRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public abstract class LandingPageServlet extends HttpServlet {

	private String gwtEntryPoint;

	private String appId;

	private String signedRequestData = "";
	private String overflow = "";

	private String httpOrS(HttpServletRequest request) {
		return request.getRequestURL().toString().replaceAll("(https?://).*", "$1");
	}

	protected LandingPageServlet(String gwtEntryPoint, String appId) {
		this.gwtEntryPoint = gwtEntryPoint;
		this.appId = appId;
	}

	protected HttpServletRequest request;
	protected HttpServletResponse response;

	// So the subclass can write into the head or body.
	protected String head = "";
	protected String body = "";

	/**
	 * Method which runs on each request, giving the extending class a chance to read and write to the request and response
	 * Also be aware of String head and String body which add strings into the head and body!
	 */
	protected void readWriteRequest(){};

	private Gson gson = new Gson();

	// Inside Facebook, it will always be POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SignedRequest signedRequest = SignedRequest.parseSignedRequest(request.getParameter("signed_request"));

		if (signedRequest.getOauthToken() != null) {
			Cookie accessTokenCookie = new Cookie("accessToken", signedRequest.getOauthToken());
			// Store the cookie for as long as the access token lasts
			accessTokenCookie.setMaxAge((int) (Integer.parseInt(signedRequest.getExpires()) - (new Date().getTime() / 1000)));
			response.addCookie(accessTokenCookie);
		}

		if (signedRequest.getUserId() != null) {
			Cookie userIdCookie = new Cookie("userId", signedRequest.getUserId());
			userIdCookie.setMaxAge((int) (Integer.parseInt(signedRequest.getExpires()) - (new Date().getTime() / 1000)));
			response.addCookie(userIdCookie);
		}

		signedRequestData = "  <script id=\"signedRequest\">\n" + "    var _sr_data = " + gson.toJson(signedRequest) + "\n  </script>\n\n";

		// This isn't needed/desirable outside the fb canvas
		overflow = " style=\"overflow: hidden\"";

		// If the app has been added as a Page tab, it redirects to the canvas with a URL:
		// http://apps.facebook.com/sortonsdev/?tabs_added[356718097671739]=1#_=_
		// or if it's added to multiple pages:
		// http://apps.facebook.com/sortonsdev/?tabs_added[367864846557326]=1&tabs_added[356718097671739]=1#_=_
		// Regex for extracting the url from wall posts

		if (request.getHeader("referer").matches(".*tabs_added%5B(\\d+)%5D.*")) {

			// If the Canvas load was a redirect from adding the page tab
			// redirect to the page that added it, at the app's new tab
			// TODO Test this... it didn't seem to work once, though the URL worked when tested in isolation
			// TODO maybe just // instead of a method there.
			String redirectTo = httpOrS(request) + "www.facebook.com/" + request.getHeader("referer").replaceAll(".*tabs_added%5B(\\d+)%5D.*", "$1")
					+ "?sk=app_" + appId;

			PrintWriter out = response.getWriter();
			out.print("<script>window.top.location.href = \"" + redirectTo + "\";</script>");

			// TODO
			// Put some text here in case the redirect doesn't work (why wouldn't it?)
			// If multiple pages have had the app added, show a list rather than redirect.
			// Do it with GWT? The app will probably be cached already

		} else {
			doGet(request, response);
		}

		// TODO
		// The "Go to application" link in the admin section of a Page links to
		// http://apps.facebook.com/sortonsdev/?fb_page_id=176727859052209
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Servlet execution... " + request.getMethod());

		this.request = request;
		this.response = response;
		readWriteRequest();

		PrintWriter out = response.getWriter();

		// Write out head
		out.print("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> \n"
				+ // As specified for Bing Maps API
				"<html xmlns=\"http://www.w3.org/1999/xhtml\"" + overflow + "> \n\n" + "<head> \n\n"
				+ "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/> \n\n"
				+ signedRequestData
				+ // If available, print the Signed Request
				"  <meta name=\"gwt:property\" content=\"" + request.getLocale() + "\">\n\n"
				+ "  <script type=\"text/javascript\" language=\"javascript\" src=\"" + gwtEntryPoint + "\"></script> \n\n"
				+ "  <script src=\"//connect.facebook.net/en_US/all.js\"></script> \n\n" + // Facebook API
				head + "</head> \n\n");

		// Write out body
		out.print("<body" + overflow + "> \n\n" + "  <div id='fb-root'></div> \n\n" + // required for Facebook API
				"  <div id=\"gwt\"></div> \n\n" + // root of document for GWT
				body +
				"</body> \n\n");

		out.print("</html>");
		out.flush();

	}

}
