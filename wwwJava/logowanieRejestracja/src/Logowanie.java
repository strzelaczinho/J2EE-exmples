import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Logowanie
 */
@WebServlet("/Logowanie")
public class Logowanie extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Logowanie() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("logowanie.html");
        rd.include(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        response.sendRedirect("/Danelogowania");*/
    }

}
