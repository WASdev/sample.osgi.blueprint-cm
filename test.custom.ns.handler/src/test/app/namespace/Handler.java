package test.app.namespace;

import java.net.URL;
import java.util.Set;

import org.apache.aries.blueprint.ComponentDefinitionRegistry;
import org.apache.aries.blueprint.NamespaceHandler;
import org.apache.aries.blueprint.ParserContext;
import org.osgi.service.blueprint.reflect.BeanMetadata;
import org.osgi.service.blueprint.reflect.ComponentMetadata;
import org.osgi.service.blueprint.reflect.Metadata;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/*
 * A custom blueprint NamespaceHandler. See testHandler.xsd in this directory: this defines the new syntax
 * supported by the handler. In this case it's very basic: as shown in 
 *   /test.blueprint.cm.basic/BundleContent/OSGI-INF/blueprint/blueprint.xml
 * we enable blueprint of the form, 

    <blueprint xmlns="http://www.osgi.org/xmlns/blueprint/v1.0.0"
                xmlns:yy="http://www.ibm.com/xmlns/apptest/v1.0.0">

      <service interface="custom.ns.test.SomeService"> 
  	    <bean class="custom.ns.test.impl.CommentedBean">
	      <yy:comment text="--Comment from custom bp namespace"/>   <!-- this is the new bit -->
  	    </bean>
      </service>
 
 * where the 'yy' namespace is the new bit: the comment text is passed to TestInterceptor(), which 
 * prints that comment when a method is invoked on the associated bean. 
 */
public class Handler implements NamespaceHandler 
{
    @Override
    public ComponentMetadata decorate(Node node, ComponentMetadata componentMetadata, ParserContext parserContext)
    {
        if (node instanceof Element) {
            String comment = ((Element) node).getAttribute("text");
            if (componentMetadata instanceof BeanMetadata)
            {
                ComponentDefinitionRegistry cdr = parserContext.getComponentDefinitionRegistry();
                cdr.registerInterceptorWithComponent(componentMetadata, new TestInterceptor(comment));
            }
        }
        return componentMetadata;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Set<Class> getManagedClasses() {
        return null;
    }

    @Override
    public URL getSchemaLocation(String arg0)
    {
        return this.getClass().getResource("testHandler.xsd");
    }

    @Override
    public Metadata parse(Element arg0, ParserContext arg1) {
        // we are not implementing any stand-alone components, hence
        throw new UnsupportedOperationException();
    }
}
