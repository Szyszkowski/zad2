package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import domain.Registration;
import repositories.DummyRegistrationRepository;
import repositories.RegistrationRepository;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Registration registration = retrieveRegistrationFromRequest(request);
        RegistrationRepository repository = new DummyRegistrationRepository();
        if (registration.getLogin().equals("admin")) {
            registration.setIsAdmin(true);
        } else {
            registration.setIsAdmin(false);
        }
        registration.setIsPremium(false);

        repository.add(registration);
        response.sendRedirect("login.jsp");

    }

    private Registration retrieveRegistrationFromRequest(HttpServletRequest request) {
        Registration result = new Registration();
        result.setName(request.getParameter("name"));
        result.setLogin(request.getParameter("login"));
        result.setPassword(request.getParameter("password"));
        result.setEmail(request.getParameter("email"));
        return result;
    }

}
