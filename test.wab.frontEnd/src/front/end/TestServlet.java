package front.end;

import static bp.cm.test.Constants.PID;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

import custom.ns.test.SomeService;

/**
 * A simple servlet to take params from an HTML Form and load them into Config Admin
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String length = request.getParameter("length");
		String width = request.getParameter("width");
		String height = request.getParameter("height");
		try { 
			ConfigurationAdmin c = (ConfigurationAdmin) new InitialContext().lookup("blueprint:comp/configAdminRef");
			Configuration config = c.getConfiguration (PID, null);
			Dictionary<String, Object> dict = new Hashtable<String, Object>();
			dict.put("length", length);
			dict.put("width", width);
			dict.put("height", height);
			config.update(dict);
			response.getWriter().println ("<html><head/><body>Config updated. Click <a href=\"/test.wab.frontEnd/index.html\">here</a> to input new configuration.</body></html>");
			
			// Finally do something to exercise the custom namespace handler
			SomeService s = (SomeService) new InitialContext().lookup("blueprint:comp/someServiceRef");
			s.doSomething();

		} catch (Exception e) { 
			e.printStackTrace(response.getWriter());
		}
	}

}
