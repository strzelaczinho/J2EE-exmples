package initparam;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class InitServlet1 extends HttpServlet {

    public void init() throws ServletException {
        ServletConfig ctx = this.getServletConfig();
        int a_value = Integer.parseInt(ctx.getInitParameter("number"));
        ServletContext sc = this.getServletContext();
        sc.setAttribute("number", a_value);
    }

    private boolean isPrime(int n) {
        if (n % 2 == 0) return false;
        for(int i = 3; i * i <= n; i += 2) {
            if(n % i == 0)
                return false;
        }
        return true;
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        ServletContext sc = this.getServletContext();
        int number = (int)sc.getAttribute("number");
        Random random = new Random();
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = random.nextInt(1000);
        }

        try(PrintWriter out = response.getWriter()) {
            out.println("<table border='1'>");
            out.println("<tr><td>Wylosowane</td>");
            for (int i = 0; i < number; i++) {
                out.println("<td>" + array[i] + "</td>");
            }
            out.println("</tr>");
            Arrays.sort(array);
            out.println("<tr><td>Posortowane</td>");
            for (int i = 0; i < number; i++) {
                if(isPrime(array[i]))
                    out.println("<td>" + array[i] + "*</td>");
                else
                    out.println("<td>" + array[i] + "</td>");
            }
            out.println("</tr>");
            out.println("</table>");
            out.println("* Liczba pierwsza");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
