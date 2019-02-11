package listeners;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowListServlet", urlPatterns = {"/lista"})
public class ShowListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Integer> lista = (ArrayList<Integer>)this.getServletContext().getAttribute("lista");
        lista.add(Integer.parseInt(request.getParameter("liczba")));
        lista.sort(Integer::compareTo);
        this.getServletContext().setAttribute("lista", lista);

        response.sendRedirect("/lista");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            List<Integer> lista = (ArrayList<Integer>)this.getServletContext().getAttribute("lista");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Klasy nasłuchujące</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista losowych posortowanych liczb:</h1><ul>");
            for(int l: lista) {
                out.println("<li>" + l + "</li>");
            }
            out.println("</ul>"
                    + "<form action='/lista' method='POST'>"
                    + "<input type='number' placeholder='Nowa liczba' name='liczba' />"
                    + "<input type='submit' value='Dodaj' />"
                    + "</form></body>");
            out.println("</html>");
        }
    }
}
