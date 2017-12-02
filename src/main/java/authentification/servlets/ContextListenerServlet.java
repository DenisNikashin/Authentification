package authentification.servlets;

import authentification.dataBase.UserRepozitory;
import authentification.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.atomic.AtomicReference;

import static authentification.model.User.ROLE.ADMIN;
import static authentification.model.User.ROLE.USER;


public class ContextListenerServlet implements ServletContextListener {

    private AtomicReference<UserRepozitory> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        dao = new AtomicReference<>(new UserRepozitory());

        dao.get().add(new User("Admin", 1 , ADMIN, "1" ));
        dao.get().add(new User("User", 2 , USER, "1"));

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }
}