# sample.osgi.blueprint-cm

This sample demonstrates the use of Config Admin and custom Blueprint namespace handlers in OSGi applications on the Liberty profile. I [blogged about these capabilities](https://developer.ibm.com/wasdev/blog/2014/09/17/new-osgi-applications-custom-blueprint-namespace-handlers-bring-configadmin/) in September 2014 when they were new out in beta. Everything demonstrated in this sample will be fully supported in the upcoming [June 26th 2015 release](http://www-01.ibm.com/common/ssi/cgi-bin/ssialias?subtype=ca&infotype=an&appname=iSource&supplier=897&letternum=ENUS215-269) of WebSphere Application Server V8.5.5.6 Liberty Profile.   

The sample illustrates the use of the following things, all in an OSGi application running on Liberty: 
- Implementing and invoking a custom Blueprint namespace handler. 
- Providing a Config Admin implementation, and populating Config Admin. 
- Use of the Apache Aries "blueprint-cm" module to drive Config Admin data directly into Blueprint-managed beans.
- A simple web front end shows that config changes can be made at runtime, and neatly driven into Blueprint beans via blueprint-cm. 




Bundles required for blueprint-cm:
org.apache.aries.blueprint.cm
org.apache.felix.configadmin
slf4j.api
slf4j.jdk14

Liberty server.xml:

~~~~
<featureManager>
  <feature>wab-1.0</feature>
  <feature>jndi-1.0</feature>
</featureManager>
~~~~

