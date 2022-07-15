import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", value = "/login")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Hello World!</h3>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if(user == "user" && pass == "password") {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3>Welcome back " + user + "</h3>");
        }

        else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3>Incorrect login info</h3>");
        }
    }
}
