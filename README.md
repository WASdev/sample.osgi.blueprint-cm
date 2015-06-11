# sample.osgi.blueprint-cm

This sample demonstrates the use of Config Admin and custom Blueprint namespace handlers in OSGi applications on the Liberty profile. I [blogged about these capabilities](https://developer.ibm.com/wasdev/blog/2014/09/17/new-osgi-applications-custom-blueprint-namespace-handlers-bring-configadmin/) in September 2014 when they were new out in beta. Everything demonstrated in this sample will be fully supported in the upcoming [June 26th 2015 release](http://www-01.ibm.com/common/ssi/cgi-bin/ssialias?subtype=ca&infotype=an&appname=iSource&supplier=897&letternum=ENUS215-269) of WebSphere Application Server V8.5.5.6 Liberty Profile.   

The sample illustrates the use of the following things, all in an OSGi application running on Liberty: 
- Implementing and invoking a custom Blueprint namespace handler. 
- Providing a Config Admin implementation, and populating Config Admin. 
- Use of the Apache Aries "blueprint-cm" module to drive Config Admin data directly into Blueprint-managed beans.
- A simple web front end shows that config changes can be made at runtime, and neatly driven into Blueprint beans via blueprint-cm. 

This readme file focuses on how to install and test the sample. A separate article will provide a broader overview of the sample and its purpose. 

The sample comprises a single OSGi application, checked into Git as a set of Eclipse projects. Three projects correspond to OSGi bundles; the fourth aggregates those bundles into an OSGi application. The sample can be run from inside Eclipse once four open source bundles have been downloaded and imported into the Eclipse workspace. 

1. Install a recent Eclipse driver. I've been using [Eclipse Luna SR2](https://eclipse.org/downloads/). This version of Eclipse comes with built-in Git support. 

2. Install the WebSphere Application Server Development Tools (WDT) into Eclipse via https://eclipse.org/downloads/

3. Window > Preferences > Server > Runtime Environments > Add > WebSphere Application Server V8.5 Liberty Profile. Download a new runtime or reuse an existing one.

4. Create a new server: New > Server > WebSphere Application Server V8.5 Liberty Profile

5. Download the four bundles listed below. The simplest place to get them is [Maven Central](http://search.maven.org/). It's probably ok to use later versions, but the links are to the level of each bundle that I've used in developing and testing the sample.  
  - [org.apache.felix.configadmin 1.8.4](http://search.maven.org/remotecontent?filepath=org/apache/felix/org.apache.felix.configadmin/1.8.4/org.apache.felix.configadmin-1.8.4.jar)
  - [slf4j.api 1.7.12](http://search.maven.org/remotecontent?filepath=org/slf4j/slf4j-api/1.7.12/slf4j-api-1.7.12.jar)
  - [slf4j.jdk14 1.7.12](http://search.maven.org/remotecontent?filepath=org/slf4j/slf4j-jdk14/1.7.12/slf4j-jdk14-1.7.12.jar)
  - [org.apache.aries.blueprint.cm 1.0.6](http://search.maven.org/remotecontent?filepath=org/apache/aries/blueprint/org.apache.aries.blueprint.cm/1.0.6/org.apache.aries.blueprint.cm-1.0.6.jar)

6. Load them into Eclipse: File > Import > OSGi Bundle or Fragment. Select the WebSphere Application Server Liberty Profile with SPI target runtime. 

7. git clone https://github.com/WASdev/sample.osgi.blueprint-cm. File > Import > Existing projects into workspace. Pull in:
  - test.blueprint.cm.basic - Blueprint-managed beans
  - test.bp.cm.eba - OSGi application
  - test.custom.ns.handler - custom Blueprint namespace handler provider
  - test.wab.frontEnd - a simple web interface to drive the test 

8. Create a new Server. In the 'Servers' view, right click > New > Server > WebSphere Application Server Liberty Profile. 

9. Double click the 'Server Configuration' and add these features: 
  - wab-1.0
  - jndi-1.0
  
10. Run the test! In the enterprise explorer view, test.wab.frontEnd > WebContent > index.html. Right click > Run As > Run on Server. Select the Liberty server and add the test.bp.cm.eba to the server. This should launch a web browser with a simple form in. Fill in some values (anything will do) and click 'Send'. Check the 'Console' view to see various results in the messages.log. 

Again, please see the associated article for more information on what this sample is showing. 