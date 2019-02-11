import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.IntStream;


public class Pierwsze extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccessRequest(request, response);
    }

    private void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext sc = this.getServletContext();
        int[] posortowane= (int[]) sc.getAttribute("ObiektServletu"); //pobieram obiekt kontekstu ustawiony na sorted ktory jest obiektem tablicy przekazanym dalej
        

        try(PrintWriter out = response.getWriter()) {
            out.println("<table border='1'>");
            out.println("<tr><td>Posortowana tablica z liczbami pierwszymi</td>");
            for (int i = 0; i < posortowane.length; i++)
                if(isPrime(posortowane[i]))
                    out.println("<td>" + posortowane[i] + "(pierwsza)</td>");
                else
                    out.println("<td>" + posortowane[i] + "</td>");
                                
                    
            out.println("</tr>");
            out.println("</table>");
            out.println("pierwsza = Liczba pierwsza");
            out.println("</br>");
            out.println("<a href=\"Parametry\">Wylosuj ponownie</a>");
            out.println("</br><a href=index.jsp>Zacznij od nowa</a>");

        }

    }
    
    private static boolean isPrime(final int number) {
        for (int i = 2;i<number;i++)
        {
          if (number % i == 0)
          {
              return false;
          }
        }
        return true;
    }
}
