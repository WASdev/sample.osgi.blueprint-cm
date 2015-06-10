package test.app.namespace;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.aries.blueprint.NamespaceHandler;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/*
 * This bundle activator registers a customer Blueprint NamespaceHandler for the 
 * http://www.ibm.com/xmlns/apptest/v1.0.0 namespace. This namespace is used in 
 * /test.blueprint.cm.basic/BundleContent/OSGI-INF/blueprint/blueprint.xml
 */
public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        Dictionary<String, Object> namespaceProps = new Hashtable<String, Object>();
        namespaceProps.put("osgi.service.blueprint.namespace", "http://www.ibm.com/xmlns/apptest/v1.0.0");
        context.registerService(NamespaceHandler.class, new Handler(), namespaceProps);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        // Do nothing 
    }

}
