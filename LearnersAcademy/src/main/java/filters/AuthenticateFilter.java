package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticateFilter
 */
@WebFilter( filterName = "auth", urlPatterns = {"/add","/admin","/classcurr","/classes","/classreport","/delete","/students","/subjects","/teachers","/teachersschedule",
		"/admin.jsp","/classcurr.jsp","/classes.jsp","/classreport.jsp","/newcurr.jsp","/newschedule.jsp","/students.jsp","/subjects.jsp","/teachers.jsp","/teachersschedule.jsp"})
public class AuthenticateFilter extends HttpFilter implements Filter {	
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public AuthenticateFilter() {
    	System.out.println("Authneticate Filter");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("destroy");
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("do filter before AUTH");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String username= (String) session.getAttribute("id");
		System.out.println("username in filter "+username );
		if(username==null)
		{
			resp.sendRedirect("login.jsp");
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("do filter after AUTH");
		Cookie cookie = new Cookie("data", "somedata");
		resp.addCookie(cookie);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init of filter");
	}
}