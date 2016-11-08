# ie.sortons.GwtFb+

This is a collection of widgets, overlays, Gson classes and a servlet for building Facebook Canvas apps with Google Web Toolkit on Google App Engine. 
The original GwtFB library, which has been subsumed, has its home with [olams](https://github.com/olams/GwtFB), and there are more GWT Facebook libraries on GitHub by [denormans](https://github.com/denormans/FacebookGWT), [handstandtech](https://github.com/handstandtech/Facebook-API) and [adrianmigraso](https://github.com/adrianmigraso/Facebook-ConnectJS-GWT-Port).

Applications made with this library include [Sortons Events](http://apps.facebook.com/sortonsevents/) ([source](https://github.com/BrianHenryIE/Friends--Events)) and [UCD Events](http://apps.facebook.com/ucdevents/) ([source](https://github.com/BrianHenryIE/UCD-Events)). 

The most important page to read on the Facebook SDK, which you need to understand to use this library is [Using the Graph API](https://developers.facebook.com/docs/graph-api/using-graph-api/).

## Quickstart
I assume you're using Maven and you're comforatble with Git – i.e. you have both installed.  Open a Terminal, change directory (cd) to the folder you'd like the code stored in (Sites/Workspace/etc.) and type: 

    git clone https://github.com/BrianHenryIE/GwtFbPlus.git
Change to the directory created and install the library into your local Maven repository using:

    mvn install
Add the following lines to your project's pom.xml dependency list:

	<dependency>
		<groupId>ie.sortons</groupId>
		<artifactId>gwtfbplus</artifactId>
		<version>0.0.3-SNAPSHOT</version>
	</dependency>
Add this to your ProjectName.gwt.xml file:

    <inherits name='ie.sortons.gwtfbplus.GwtFBplus'/>

### Dependencies
The project GwtProJsonSerializer is needed but is not in Maven Central or Sonatype repositories. As above,

    git clone https://github.com/ubiquitousthey/gwtprojsonserializer.git
    mvn install

## Using the library

```FBCore fbCore = GWT.create(FBCore.class);```


```fbCore.init(appid, status, xfbml, version);```

```
fbCore.login(new AsyncCallback<JavaScriptObject>() {
	public void onSuccess(JavaScriptObject response) {
		...
	}
	public void onFailure(Throwable caught) {

	}
}, "comma,separated,permissions");
```

```
fbCore.api("me/", new AsyncCallback<FbResponse>() {
		
		@Override
		public void onSuccess(FbResponse response) {
			...
		}

		@Override
		public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
		}
	});
```


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

```sudo nano /etc/hosts```

```127.0.0.1       dev.sortons.ie```


### SSL
For apps running in Facebook frames (Canvas and Page Tab), SSL is required.  

use Apache to forward https://localhost/fb to http://localhost:8080
this will also forward https://dev.sortons.ie/fb to http://localhost:8888

```sudo nano /etc/apache2/httpd.conf```

Add the following two lines:

```
ProxyPass /fb/ http://localhost:8080/
ProxyPassReverse /fb/ http://localhost:8080/
```

Uncomment the following two lines:

```LoadModule ssl_module libexec/apache2/mod_ssl.so```

```Include /private/etc/apache2/extra/httpd-ssl.conf```

```Include /private/etc/apache2/extra/httpd-vhosts.conf```


working with https locally will throw certificate errors. 

Follow these steps to generate a self signed certificate for dev.sortons.ie 
http://brianflove.com/2014/12/01/self-signed-ssl-certificate-on-mac-yosemite/

```
sudo nano httpd.conf
cd /private/etc/apache2
sudo mkdir ssl
```

```sudo ssh-keygen -f dev.sortons.ie.key```

```sudo openssl req -new -key dev.sortons.ie.key -out dev.sortons.ie.csr```

and be sure to enter `dev.sortons.ie` when prompted for `Common Name (e.g. server FQDN or YOUR name)`

```sudo openssl rsa -in dev.sortons.ie.key -out dev.sortons.ie.nopass.key```





```sudo apachectl restart```




Then in Finder in the Go menu Go to folder... /private/etc/apache2/ssl
Open Keychain Access.
Drag and drop the .crt file into the System keychain. (it will prompt for your admin password)

If you've trouble, clear any earlier certificate you may have been using (localhost), make sure you're definitely on https and restart your browser.   

http://www.robpeck.com/2010/10/google-chrome-mac-os-x-and-self-signed-ssl-certificates/#.VbJhOrdsDkA

Then superdevmode won't work because it doesn't support SSL – the solution is to click on the shield in the address bar and make an exception to allow the site communicate insecurely.

might have to change the bind address to match (I'm not sure as I did that first)
but definitely have to "click on the shield icon in the url bar, and select "Load unsafe scripts""
https://code.google.com/p/google-web-toolkit/issues/detail?id=7538
