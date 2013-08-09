package ie.sortons.gwtfbplus.server;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LandingPageServlet extends HttpServlet {
	
	private String gwtEntryPoint;

	private String signedRequestData = "";

	
	protected LandingPageServlet(String gwtEntryPoint){
		this.gwtEntryPoint = gwtEntryPoint;
	}
	
	
	// Inside Facebook, it will always be POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SignedRequest signedRequest = SignedRequest.parseSignedRequest(request.getParameter("signed_request"));
		
		signedRequestData = "  <script id=\"signedRequest\">\n" +
				"    var _sr_data = " + signedRequest.toJsonString() +
				"\n  </script>\n\n";
		
		doGet(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		System.out.println("Servlet execution... " + request.getMethod());
	            
		PrintWriter out = response.getWriter();
		
		// Write out head 
		out.print("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> \n" + // As specified for Bing Maps API
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" style=\"overflow: hidden\"> \n\n" +
				"<head> \n\n" +
				"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/> \n\n" +
				signedRequestData + // If available, print the Signed Request 
				"  <script type=\"text/javascript\" language=\"javascript\" src=\"" + gwtEntryPoint + "\"></script> \n\n" + // Check the GWT cache and fetch the correct JS
				"  <script src=\"//connect.facebook.net/en_US/all.js\"></script> \n\n" + // Facebook API
				"</head> \n\n");
		
		// Write out body
		out.print("<body style=\"overflow=hidden;\"> \n\n" +
				"  <div id='fb-root'></div> \n\n" + // required for Facebook API
				"  <div id=\"gwt\"></div> \n\n" + // root of document for GWT
				"</body> \n\n");
		
		out.print("</html>");
		out.flush();
		
	}
	
}

	
