package bp.cm.test;

import java.util.Map;

/*
 * A component managed bean - updates to the associated PID in ConfigAdmin will result
 * in update() being called. 
 */
public class ComponentManaged 
{
	public void update (Map<String, Object> p) { 
		System.out.println ("ComponentManaged got cmProps " + p);
	}
}
