package custom.ns.test.impl;

import custom.ns.test.SomeService;

/*
 * This bean is used to demonstrate test.app.namespace.TestInterceptor
 */
public class CommentedBean implements SomeService {

	@Override
	public void doSomething() {
		System.out.println ("CommentedBean did something");
		
	}
}
