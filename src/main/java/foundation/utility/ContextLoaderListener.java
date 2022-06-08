package foundation.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import foundation.daos.AppUsersDaoPostgres;
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
        UserServlet userServlet = new UserServlet(mapper, userDAO);

        ServletContext context = sce.getServletContext();
        context.addServlet("UserServlet", userServlet).addMapping("/users");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[LOG] - The servlet context was destroyed at " + LocalDateTime.now());
    }
}
