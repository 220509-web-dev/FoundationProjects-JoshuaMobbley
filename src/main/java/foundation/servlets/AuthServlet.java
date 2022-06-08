package foundation.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import foundation.entities.AppUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class AuthServlet extends HttpServlet {

    private final ObjectMapper mapper;
    private final AuthService;

    public AuthServlet(ObjectMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader reader = req.getReader();

        String line;
        StringBuilder sb = new StringBuilder();

        while((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String body = sb.toString();

        User userCredentials = mapper.readValue(body, AppUsers.class);

        String uri = req.getRequestURI().replace( "");
    }
}
