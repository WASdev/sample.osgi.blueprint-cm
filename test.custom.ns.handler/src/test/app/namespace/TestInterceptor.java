/*
 * IBM Confidential
 *
 * OCO Source Materials
 *
 * Copyright IBM Corp. 2014
 *
 * The source code for this program is not published or otherwise divested 
 * of its trade secrets, irrespective of what has been deposited with the 
 * U.S. Copyright Office.
 */
package test.app.namespace;

import java.lang.reflect.Method;

import org.osgi.service.blueprint.reflect.ComponentMetadata;

/**
 * This test interceptor prints a comment, obtained from testHandler.xsd, before method invocations on annotated blueprint beans
 */
public class TestInterceptor implements org.apache.aries.blueprint.Interceptor
{
    @Override
    public int getRank()
    {
        return 0;
    }

    @Override
    public void postCallWithException(ComponentMetadata arg0, Method arg1, Throwable arg2, Object arg3) throws Throwable
    {}

    @Override
    public void postCallWithReturn(ComponentMetadata arg0, Method arg1, Object arg2, Object arg3) throws Throwable
    {}

    @Override
    public Object preCall(ComponentMetadata arg0, Method arg1, Object... arg2) throws Throwable
    {
        System.out.println(_comment);
        return null;
    }

    private final String _comment;

    public TestInterceptor(String comment)
    {
        _comment = comment;
    }

}
