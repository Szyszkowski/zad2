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

import repositories.DummyRegistrationRepository;

@WebFilter("/login")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        if (httpRequest.getParameter("loginButton") == null) {
            if (session.getAttribute("userData") == null) {
                ((HttpServletResponse) response).sendRedirect("/login.jsp");
            } else {
                ((HttpServletResponse) response).sendRedirect("/userData.jsp");
            }
        } else {
            String validateResult = validateData(httpRequest);
            if (validateResult.equals("ok")) {
                chain.doFilter(request, response);
            } else {
                request.setAttribute("errorMessage", validateResult);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    private String validateData(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        login = login != null ? login.trim() : "";
        password = password != null ? password.trim() : "";

        if (login.equals("") || password.equals("")) {
            return "Uzupełnij wymagane pola";
        }

        if (!(new DummyRegistrationRepository().checkPassword(login, password))) {
            return "Błędne dane logowania";
        }
        return "ok";
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig arg0) {

    }
}



