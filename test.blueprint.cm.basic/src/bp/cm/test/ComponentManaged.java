package bp.cm.test;

import java.util.Map;

import org.osgi.service.cm.ConfigurationAdmin;

public class ComponentManaged 
{
	ConfigurationAdmin _configAdmin;
	
	public void setConfigAdmin (ConfigurationAdmin c) { 
		_configAdmin = c;
		System.out.println ("Consumer got configAdmin " + c);
	}

	public void update (Map<String, Object> p) { 
		System.out.println ("ComponentManaged got cmProps " + p);
	}
}
