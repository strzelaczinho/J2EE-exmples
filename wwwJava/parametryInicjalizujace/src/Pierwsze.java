import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.IntStream;

@WebServlet("Pierwsze")
public class Pierwsze extends HttpServlet {

    private static boolean isPrime(final int number) {
        return IntStream
                .rangeClosed(2, number/2)
                .noneMatch(i -> number%i == 0);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccessRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccessRequest(request, response);
    }

    private void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext sc = this.getServletContext();
        int[] sorted= (int[]) sc.getAttribute("sorted");

        try(PrintWriter out = response.getWriter()) {
            out.println("<table border='1'>");
            out.println("<tr><td>Liczby posortowane z zaznaczeniem pierwszych</td>");
            for (int i = 0; i < sorted.length; i++) {
                if(isPrime(sorted[i]))
                    out.println("<td>" + sorted[i] + "(lp)</td>");
                else
                    out.println("<td>" + sorted[i] + "</td>");
            }
            out.println("</tr>");
            out.println("</table>");
            out.println("(lp) - Liczba pierwsza");
        }

    }
}
