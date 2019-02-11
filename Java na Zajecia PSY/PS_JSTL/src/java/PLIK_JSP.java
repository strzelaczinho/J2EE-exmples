import java.awt.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;


public class PLIK_JSP extends HttpServlet {
   

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
           ArrayList<Baza> uzytkownicy= new ArrayList<>();
            ServletContext sc = this.getServletContext();
            synchronized (getServletContext()) {
                sc.setAttribute("zmiennaKontekstu", uzytkownicy);
            }
            RequestDispatcher rd = request.getRequestDispatcher("users.jsp");
            rd.forward(request, response);
        }
    }
}
