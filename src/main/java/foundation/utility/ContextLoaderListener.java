package foundation.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import foundation.daos.AppUsersDaoPostgres;
import foundation.services.UserService;
import foundation.servlets.AuthServlet;
import foundation.servlets.UserServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDateTime;

public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[LOG] - The servlet context was initialized at " + LocalDateTime.now());

        ObjectMapper mapper = new ObjectMapper();
        AppUsersDaoPostgres userDAO = new AppUsersDaoPostgres();
        UserService userService = new UserService(userDAO);
        UserServlet userServlet = new UserServlet(mapper, userService);
        AuthServlet authServlet = new AuthServlet(mapper);

        ServletContext context = sce.getServletContext();
        context.addServlet("UserServlet", userServlet).addMapping("/users");
        context.addServlet("AuthServlet", authServlet).addMapping("/auth");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[LOG] - The servlet context was destroyed at " + LocalDateTime.now());
    }
}
