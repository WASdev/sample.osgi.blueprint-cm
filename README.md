# sample.osgi.blueprint-cm
Demonstrating:

- Apache Aries blueprint-cm works in OSGi apps in Liberty due to custom namespace handlers now working. 
- General custom namespace handler support

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

