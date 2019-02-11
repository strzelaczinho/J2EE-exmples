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
import java.util.List;


public class Z_JSP extends HttpServlet {
  

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            ServletContext sc = this.getServletContext();
            List<Baza> uzytkownicy;
            synchronized (getServletContext()) {
                uzytkownicy = (List<Baza>) sc.getAttribute("zmiennaKontekstu");
            }

           uzytkownicy.add(new Baza(request.getParameter("imie"),
                    request.getParameter("nazwisko"), request.getParameter("adres"),
                    request.getParameter("telefon"), request.getParameter("email")));

            synchronized (getServletContext()) {
                sc.setAttribute("zmiennaKontekstu", uzytkownicy);
            }

            RequestDispatcher rd = request.getRequestDispatcher("users.jsp");
            rd.forward(request, response);
        }
    }
}
