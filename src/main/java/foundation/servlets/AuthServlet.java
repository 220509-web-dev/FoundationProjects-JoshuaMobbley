package foundation.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import foundation.entities.AppUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AuthServlet extends HttpServlet {

    private final ObjectMapper mapper;


    public AuthServlet(ObjectMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<AppUsers> users = new ArrayList<>();

        HashMap<String, Object> credentials = mapper.readValue(req.getInputStream(), HashMap.class);
        String providedUsername = (String) credentials.get("username");
        String providedPassword = (String) credentials.get("password");

        for(AppUsers user : users) {
            if (providedUsername.equals(user.getUsername()) && providedPassword.equals(user.getPassword())) {
                System.out.println("[LOG] - found user!");
                HttpSession session = req.getSession();
                session.setAttribute("auth-user", user);

                resp.setStatus(204);
                return;
            }
        }

        resp.setStatus(400);
        resp.setContentType("application/json");

        HashMap<String, Object> errorMessage = new HashMap<>();
        errorMessage.put("code", 400);
        errorMessage.put("message", "No user found with provided credentials");
        errorMessage.put("timestamp", LocalDateTime.now().toString());

        resp.getWriter().write(mapper.writeValueAsString(errorMessage));



        BufferedReader reader = req.getReader();

        String line;
        StringBuilder sb = new StringBuilder();

        while((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String body = sb.toString();


    }
}
