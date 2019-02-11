import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

@WebServlet(name = "ToJSP")
public class ToJSP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            LinkedList<UserData> users = new LinkedList<>();

            users.add(new UserData("David", "Beckham", "Warszawa", "500-500-505", "d.beckham@wp.pl"));
            users.add(new UserData("Adam", "Kowalski", "Chicago", "666-000-312", "pele@wp.pl"));
            users.add(new UserData("James", "Bond", "Bialystok", "888-002-200", "james@gmail.pl"));

            ServletContext sc = this.getServletContext();
            synchronized (getServletContext()) {
                sc.setAttribute("users", users);
            }


            RequestDispatcher rd = request.getRequestDispatcher("users.jsp");
            rd.forward(request, response);
        }
    }
}
