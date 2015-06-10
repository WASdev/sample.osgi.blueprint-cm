package bp.cm.test;

/* 
 * A container-managed bean. For each property in the associated PID, a setXxx method in this class will 
 * be driven. So setting length=10 in the PID will result in setLength(10) being invoked by the blueprint-cm
 * runtime.  
 */
public class ContainerManaged {

	public void setLength (String length) { 
		System.out.println ("ContainerManaged: length = " + length);
	}
	
	public void setWidth (String width) { 
		System.out.println ("ContainerManaged: width = " + width);
	}
	
	public void setHeight (String height) { 
		System.out.println ("ContainerManaged: height = " + height);
	}
}
