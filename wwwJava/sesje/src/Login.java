import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(name = "Login")
public class Login extends HttpServlet {


        public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
        {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String userName = request.getParameter("username");
            out.print("Witam " + userName);

            HttpSession session = request.getSession();
            synchronized (session) {
                session.setAttribute("logged", userName);
            }

            out.print("<br>Zalogowani użytkownicy= " + CounterClass.getTotalActiveSession());
            out.print("<br><a href='Test'>Zakazane</a>");
            out.print("<br><a href='Logout'>Wyloguj</a>");

            out.close();
        }

}


