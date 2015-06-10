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
