import domain.Registration;
import org.junit.Assert;

import org.junit.Test;

import org.mockito.Mockito;
import repositories.HSQLDBConnection;
import web.filters.Servlets.LoginServlet;
import web.filters.Servlets.UserDataServlet;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

import static org.mockito.Mockito.*;

public class Tests {

    @Test
    public void servletShoudRedirectUserToUserDataPage() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        UserDataServlet servlet = new UserDataServlet();
        servlet.doPost(request, response);
        verify(response).sendRedirect("/userData.jsp");


    }

    @Test
    public void shoudReturnConnectionToDb() throws Exception {
        Connection con;
        con = HSQLDBConnection.getConnection();
        Assert.assertNotNull(con);
        if (con != null) {
            con.close();
        }

    }

    @Test
    public void servlerShoudAddUserDataToSession() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(request.getAttribute("login")).thenReturn("test");
        LoginServlet servlet = new LoginServlet();
        servlet.doPost(request, response);
        verify(session).setAttribute(eq("userData"), Mockito.any(Registration.class));
    }

}





