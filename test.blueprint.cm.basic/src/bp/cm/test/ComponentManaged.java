package bp.cm.test;

import java.util.Map;

public class ComponentManaged 
{
	public void update (Map<String, Object> p) { 
		System.out.println ("ComponentManaged got cmProps " + p);
	}
}
