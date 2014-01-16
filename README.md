
ie.sortons.GwtFB+
=================

This is a collection of widgets, overlays, gson classes and a servlet for building Facebook Canvas apps with Google Web Toolkit on Google App Engine. 
The original GwtFB library, that is required, has its home with [psyrtsov](https://github.com/psyrtsov/gwtfb) and [olams](https://github.com/olams/GwtFB), and there are more GWT Facebook libraries on GitHub by [denormans](https://github.com/denormans/FacebookGWT), [handstandtech](https://github.com/handstandtech/Facebook-API) and [adrianmigraso](https://github.com/adrianmigraso/Facebook-ConnectJS-GWT-Port).

Applications made with this library include [Sortons Events](http://apps.facebook.com/sortonsevents/) ([source](https://github.com/BrianHenryIE/Friends--Events)) and [UCD Events](http://apps.facebook.com/ucdevents/) ([source](https://github.com/BrianHenryIE/UCD-Events)). 

Feedback on my code would be appreciated. My email address is brian.henry@sortons.ie

Quickstart
----------

Download [gwtfb.jar](http://www.sortons.ie/gwt/gwtfb.jar) a [gwtfbplus.jar](http://www.sortons.ie/gwt/gwtfbplus20130808.jar), add them to your build path and add to your .gwt.xml file:

    <inherits name='com.gwtfb.GwtFB'/>
    <inherits name='ie.sortons.gwtfbplus.GwtFBplus'/>
    

Dependencies
------------

[Apache Commons Codec](http://commons.apache.org/proper/commons-codec/) (v1.5)
is used for the base 64 decoding of the Facebook signed request. There is a method in the 
Java Standard library that does this, but it wasn't behaving.

[google-gson](https://code.google.com/p/google-gson/) (v2.2.4)
is Google's library for dealing with json server side.

[GwtProJsonSerializer](http://www.sortons.ie/gwt/gwtprojsonserializer-1.0.6.jar)
for client side json serialization and deserialization. Also add <inherits name='com.kfuntak.gwt.json.serialization.GWTProJsonSerializer' /> to your .gwt.xml file?

Using the library
-----------------

<dt>Create a Servlet</dt>

We're not going to use the .html file to start our application, instead we'll use a servlet which will deal with anything Facebook posts to your Canvas or Page tab app.
  
Make a class called LandingPage.java in your server package that extends LandingPageServlet and calls the superclass constructor with your nocache.js as the argument.

    import ie.sortons.gwtfbplus.server.LandingPageServlet;

    @SuppressWarnings("serial")
    public class LandingPage extends LandingPageServlet 
    {
	    private final static String ENTRYPOINT = "gwt__examples/gwt__examples.nocache.js";
	    private final static String APPID = "0123456789";
	
	    public LandingPage() {
		    super(ENTRYPOINT, APPID);
	    }
    }

You then have to specify the servlet in your war/WEB-INF/web.xml

    <servlet>
      <servlet-name>LandingPage</servlet-name>
      <servlet-class>ie.sortons.gwtfbplusexample.server.LandingPage</servlet-class>
    </servlet>
    <servlet-mapping>
      <servlet-name>LandingPage</servlet-name>
      <url-pattern>/</url-pattern>
    </servlet-mapping>

That's the server side done, if your GWT code is minimal at this stage, you can run the dev server, go to localhost:8888/ and it will look very like this: 

    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
    <html xmlns="http://www.w3.org/1999/xhtml" style="overflow: hidden"> 
    
    <head> 
    
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> 
    
      <script id="signedRequest">
        var _sr_data = {"algorithm":"HMAC-SHA256","expires":"1375992000","issued_at":"1375987060","oauth_token":"CAADkpnjyyEwBAJ0AKQ2MhzPvvnZAxMZAQ1HeZBYDaTH7PrmNJsaD3L2Fzud6SZCzAjIh9ktXSGuVUbeie5qTDxwHrv3P5zWsjRkZAxyProxz5c0Gp9U2Sc32r6p1bXteySTfjxBBipXy310lwC4NZBywHMo3gvzy84SWjq31ZCG6wZDZD","user":{"country":"us","locale":"en_GB","age":{"min":"21"}},"user_id":"37302520"}
      </script>
    
      <script type="text/javascript" language="javascript" src="sortonsevents/sortonsevents.nocache.js"></script> 
    
      <script src="//connect.facebook.net/en_US/all.js"></script> 
    
    </head> 
    
    <body style="overflow=hidden;"> 
    
      <div id='fb-root'></div> 

      <div id="gwt"></div> 

    </body> 
    
    </html>

The only difference should be the \<script id="signedRequest"\> which is picked up when Facebook posts data to the servlet.

<dt>Get Firefox</dt>

For the GWT plugin to inside the Facebook iframe, you'll have to download an older version of Firefox. I use 15, maybe some newer ones work but there's a bug report out somewhere there for this problem. It only affects hosted mode, not deployed apps.

Download: [Firefox 15](https://ftp.mozilla.org/pub/mozilla.org/firefox/releases/15.0/), [Firebug](http://getfirebug.com/).

<dt>Edit hosted.html</dt>

You'll also need to edit war/app_name/hosted.html to remove ".top" from "var topWin = window.top;" about 70% down the file.
 
      var pluginFinders = [
        findPluginXPCOM,
        findPluginObject,
        findPluginEmbed,
      ];
      var topWin = window.top;
      var url = topWin.location.href;
  
You'll have to do this regularly, I think at least each time you compile/deploy it will reset. Don't forget to restart the server too, not just refresh.
I have System.out.println("Entry point"); at the beginning of my entry point so I can quickly if it's stalled just as GWT should start. 
 
<dt>Edit Hosts</dt>

I can't remember what the issue was, now, but rather than localhost or 127.0.0.1 behaving well in your developers.facebook.com/apps settings, I have a fake domain (testbed.org.org) in my hosts file that Facebook posts to. Maybe it was Same Origin Policy related.

<dt>Turn off Secure Browsing</dt>

So, your Site URL and Canvas URL will be `http://testbed.org.org:8888/?gwt.codesvr=127.0.0.1:9997`. You'll have `https://testbed.org.org:8888/?gwt.codesvr=127.0.0.1:9997` as the Secure Canvas URL but dev mode doesn't do https, so you'll be [disabling secure browsing on Facebook](https://www.facebook.com/settings?tab=security) and will have to remember to test everything works.

<dt>Run Configurations</dt>

Add "-startupUrl /" (no quotes) to the Arguments in your app's Run Configuration. It's not important, but if you don't, you'll get a warning every time you start dev mode, and if you do, it will print out the URL from the previous section so you can double click it. 