package foundation.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import foundation.daos.AppUsersDaoPostgres;
import foundation.entities.AppUsers;
import foundation.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private final ObjectMapper mapper;
    private final UserService userService;

    public UserServlet(ObjectMapper mapper, UserService userService) {
        this.mapper = mapper;
        this.userService = userService;
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppUsersDaoPostgres usersDAO = null;
        List<AppUsers> user = (List<AppUsers>) usersDAO.getByUsername();

        String respPayload = mapper.writeValueAsString(user);
        resp.setContentType("application/json");
        resp.getWriter().write(respPayload);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("[LOG] - UserServlet received a request at " + LocalDateTime.now());
        ObjectMapper mapper = new ObjectMapper();
        AppUsers newUsers = mapper.readValue(req.getInputStream(), AppUsers.class);
        System.out.println(newUsers);

        AppUsers newUser = mapper.readValue(req.getInputStream(), AppUsers.class);
        userService.createNewUser(newUser);
        resp.setStatus(201);
        resp.setContentType("application/json");


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
