package custom.ns.test;


public class CommentedBean implements SomeService {

	@Override
	public void doSomething() {
		System.out.println ("CommentedBean did something");
		
	}
}
