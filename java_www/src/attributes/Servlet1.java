package attributes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Servlet1", urlPatterns = {"/atrybuty"})
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String osoba = request.getParameter("imie") + " " + request.getParameter("nazwisko");

        ServletContext sc = this.getServletContext();

        ArrayList<String> lista_osob = (ArrayList<String>)sc.getAttribute("lista");

        if(lista_osob == null) {
            lista_osob = new ArrayList<>();
        }

        lista_osob.add(osoba);

        synchronized(sc) {
            sc.setAttribute("lista", lista_osob);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/atrybuty2");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
