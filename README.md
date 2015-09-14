# ie.sortons.GwtFb+

This is a collection of widgets, overlays, gson classes and a servlet for building Facebook Canvas apps with Google Web Toolkit on Google App Engine. 
The original GwtFB library, that has been subsumed, has its home with [olams](https://github.com/olams/GwtFB), and there are more GWT Facebook libraries on GitHub by [denormans](https://github.com/denormans/FacebookGWT), [handstandtech](https://github.com/handstandtech/Facebook-API) and [adrianmigraso](https://github.com/adrianmigraso/Facebook-ConnectJS-GWT-Port).

Applications made with this library include [Sortons Events](http://apps.facebook.com/sortonsevents/) ([source](https://github.com/BrianHenryIE/Friends--Events)) and [UCD Events](http://apps.facebook.com/ucdevents/) ([source](https://github.com/BrianHenryIE/UCD-Events)). 

Feedback on my code would be appreciated. My email address is brian.henry@sortons.ie

## Quickstart
I assume you're using Maven and you're comforatble with Git – i.e. you have both installed.  Open a command prompt/terminal window, change directory (cd) to the folder you'd like the codes stored in (Sites/Workspace/etc.) and type: 

    git clone https://github.com/BrianHenryIE/GwtFbPlus.git
Then install the library into your local Maven repository using:

    cd GwtFbPlus
    mvn install
Add the following lines to your project's pom.xml dependency list:

	<dependency>
		<groupId>ie.sortons</groupId>
		<artifactId>gwtfbplus</artifactId>
		<version>0.0.2-SNAPSHOT</version>
	</dependency>
Add this to your ProjectName.gwt.xml file:

    <inherits name='ie.sortons.gwtfbplus.GwtFBplus'/>

### Dependencies
The project GwtProJsonSerializer is needed but is not in Maven Central or Sonatype repositories. As above,

    git clone https://github.com/ubiquitousthey/gwtprojsonserializer.git
    mvn install

## Using the library

    This information is hugely incomplete since Devmode was deperecated.

// TODO

* Start a Maven project in Eclipse
* Create subpackages for client, server and shared
* Add ProjectName.gwt.xml to the main package
* Create a webapp folder and create your index.html in it

```
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
    <html xmlns="http://www.w3.org/1999/xhtml" style="overflow: hidden"> 
    <head> 
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> 
      <script src="projectname/projectname.nocache.js"></script> 
      <script src="//connect.facebook.net/en_US/all.js"></script> 
    </head> 
    <body style="overflow=hidden;"> 
      <div id='fb-root'></div> 
      <div id="gwt"></div> 
    </body> 
    </html>
```
    mvn gwt:run
 
### Edit Hosts

Facebook won't accept API calls from domains you haven't specified in the developer console, so you need to have your local server matching this. E.g. I have dev.sortons.ie in my settings and then I add an entry to my hosts file pointing dev.sortons.ie to 127.0.0.1 and this solves the problem.


### SSL
For apps running in Facebook frames (Canvas and Page Tab), SSL is required. 

use Apache to forward https://localhost/appengine to http://localhost:8888
this will also forward https://dev.sortons.ie/appengine to http://localhost:8888
working with https locally will throw certificate errors. 

Follow these steps to generate a self signed certificate for dev.sortons.ie 
http://brianflove.com/2014/12/01/self-signed-ssl-certificate-on-mac-yosemite/

Then in Finder in the Go menu Go to folder... /private/etc/apache2/ssl
Open Keychain Access.
Drag and drop the .crt file into the System keychain. (it will prompt for your admin password)

If you've trouble, clear any earlier certificate you may have been using (localhost), make sure you're definitely on https and restart your browser.   

http://www.robpeck.com/2010/10/google-chrome-mac-os-x-and-self-signed-ssl-certificates/#.VbJhOrdsDkA

Then superdevmode won't work because it doesn't support SSL – the solution is to click on the shield in the address bar and make an exception to allow the site communicate insecurely.

might have to change the bind address to match (I'm not sure as I did that first)
but definitely have to "click on the shield icon in the url bar, and select "Load unsafe scripts""
https://code.google.com/p/google-web-toolkit/issues/detail?id=7538
