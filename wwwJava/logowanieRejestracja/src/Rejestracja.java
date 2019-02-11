import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "Rejestracja")
public class Rejestracja extends HttpServlet {

    public Rejestracja() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("name") + " " + request.getParameter("surname");

        ServletContext sc = this.getServletContext();
        LinkedList<String> users = (LinkedList<String>) sc.getAttribute("users");


        if(users == null) {
            users = new LinkedList<>();
        }

        users.add(user);


        synchronized(getServletContext()){
            sc.setAttribute("users", users);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/Danerejestracji");
        rd.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("rejestracja.html");
        rd.include(request,response);
    }

}
