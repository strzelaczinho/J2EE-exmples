import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "Lista")
public class Lista extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<Integer> list = (LinkedList<Integer>) this.getServletContext().getAttribute("numbers");
        list.add(Integer.parseInt(request.getParameter("liczba")));
        list.sort(Integer::compareTo);
        this.getServletContext().setAttribute("numbers", list);

        response.sendRedirect("/Lista");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        LinkedList<Integer> list = (LinkedList<Integer>)this.getServletContext().getAttribute("numbers");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<h1>Lista losowych posortowanych liczb:</h1><ul>");
            for(int x: list) {
                out.println("<li>" + x + "</li>");
            }
            out.println("</ul>"
                    + "<form action='/Lista' method='POST'>"
                    + "<input type='number' placeholder='Dodaj liczbę' name='liczba' />"
                    + "<input type='submit' value='Dodaj' /></br>"
                    + "<a href=\"index.jsp\">Wroc</a>"
                    + "</form></body>");
            out.println("</html>");
        }

    }
}
