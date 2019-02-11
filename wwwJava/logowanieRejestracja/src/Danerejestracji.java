import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

@WebServlet(name = "Danerejestracji")
public class Danerejestracji extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccessRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccessRequest(request, response);
    }

    private void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        LinkedList<String> users;
        ServletContext sc = this.getServletContext();
        int i = 0;
        users = (LinkedList<String>) sc.getAttribute("users");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Zarejestrowani użytkownicy</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Zarejestrowani użytkownicy:</h1>");
            for(String user:users){
                i++;
                out.println(i + "." + user + "</br>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
}
