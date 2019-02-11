import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Ciasteczka")
public class Ciasteczka extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("cookie",request.getParameter("name"));
        cookie.setMaxAge(10*60);
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        boolean cookieExists = false;

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ciasteczka</title>");
            out.println("</head>");
            out.println("<body>");
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("cookie")) {
                    out.println("<p>Witaj " + cookie.getValue() + "</p>");
                    cookieExists = true;
                }
            }
            if(!cookieExists) {
                out.println("Witaj gościu!");
                out.println("<form action=\"/Ciasteczka\" method=\"POST\">");
                out.println("<input type=\"text\" placeholder=\"Podaj swoje imię\" name=\"name\" /> ");
                out.println("<input type=\"submit\" value=\"Zawierdź\" /></form>");
            }
            out.println("</body> ");
            out.println("</html>");
        }
    }
}
