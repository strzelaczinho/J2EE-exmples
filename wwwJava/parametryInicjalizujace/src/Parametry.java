import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Integer.parseInt;

@WebServlet(name = "Parametry")
public class Parametry extends HttpServlet {
    public void init() throws ServletException {
        ServletConfig sctx=this.getServletConfig();
        int count=parseInt(sctx.getInitParameter("numbers"));
        ServletContext sc=this.getServletContext();
        sc.setAttribute("numbers", count);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //response.setContentType("text/html;charset=UTF-8");
        ServletContext sc = this.getServletContext();
        int numbers = (int) sc.getAttribute("numbers");
        Random random = new Random();
        int[] array = new int[numbers];
        for (int i = 0 ; i < numbers ; i++) {
            array[i] = random.nextInt(500);
        }

        try(PrintWriter out = response.getWriter()) {
            out.println("<table border='1'>");
            out.println("<tr><td>Wylosowane liczby</td>");
            for (int i = 0 ; i < numbers ; i++) {
                out.println("<td>" + array[i] + "</td>");
            }
            out.println("</tr>");
            Arrays.sort(array);
            out.println("<tr><td>Posortowane liczby</td>");
            for (int i = 0 ; i < numbers ; i++) {
                out.println("<td>" + array[i] + "</td>");
            }
            out.println("</tr>");
            out.println("</table>");
            out.println("<a href=\"Pierwsze\">Zobacz liczby pierwsze</a>");
        }

        synchronized(getServletContext()){
            sc.setAttribute("sorted", array);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/Pierwsze");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
