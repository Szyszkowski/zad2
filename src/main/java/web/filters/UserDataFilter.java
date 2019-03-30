package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/userData")
public class UserDataFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();

		if (session.getAttribute("userData") == null) {
			request.setAttribute("errorMessage", "Aby skorzystać z tej podstrony należy zalogować się");
			request.getRequestDispatcher("/").forward(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect("/userData.jsp");

		}
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig arg0) {

	}

}
