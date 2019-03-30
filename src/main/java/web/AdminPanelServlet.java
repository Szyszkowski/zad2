package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Registration;
import repositories.DummyRegistrationRepository;

@WebServlet("/adminPanel")
public class AdminPanelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("saveData") != null) {
            request.getParameterMap();
            String[] loginList = request.getParameterValues("login");
            String[] checkedList = request.getParameterValues("isPremium") != null ? request.getParameterValues("isPremium") : new String[0];
            try {
                new DummyRegistrationRepository().updatePremiumStatus(loginList, checkedList);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        List<Registration> userList = new DummyRegistrationRepository().GetAllUsersData();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/adminPanel.jsp").forward(request, response);
    }


}
