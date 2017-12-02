package authentification.servlets;

import authentification.dataBase.UserRepozitory;
import authentification.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;

public class RegistrationServlet extends HttpServlet {

    final AtomicInteger ids = new AtomicInteger();
    private final UserRepozitory USER_REPOZITORY = UserRepozitory.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
         USER_REPOZITORY.add(new User(request.getParameter("login"),
                                        ids.incrementAndGet(),
                                        User.ROLE.USER,
                                        request.getParameter("password")));

        response.sendRedirect(format("%s%s", request.getContextPath(), "/user/registration"));
    }
}
