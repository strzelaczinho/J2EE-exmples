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

@WebServlet(name = "FromJSP")
public class FromJSP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            ServletContext sc = this.getServletContext();
            LinkedList<UserData> users;
            synchronized (getServletContext()) {
                users = (LinkedList<UserData>) sc.getAttribute("users");
            }

            users.add(new UserData(request.getParameter("name"),
                    request.getParameter("surname"), request.getParameter("address"),
                    request.getParameter("telephone"), request.getParameter("email")));

            synchronized (getServletContext()) {
                sc.setAttribute("users", users);
            }

            RequestDispatcher rd = request.getRequestDispatcher("users.jsp");
            rd.forward(request, response);
        }
    }
}
