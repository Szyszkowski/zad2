package web.filters.Servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Registration;
import repositories.DummyRegistrationRepository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        String login = request.getParameter("login");
        Registration registration = new DummyRegistrationRepository().getRegistrationByLogin(login);
        HttpSession session = request.getSession();
        session.setAttribute("userData", registration);
        response.sendRedirect("/userData.jsp");
    }

}
