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


public class Parametry extends HttpServlet {
    public void init() throws ServletException {    // init servletu 
        
        ServletConfig zadanie = this.getServletConfig();
        int count= parseInt(zadanie.getInitParameter("zmiennaServletowa")); // pobiera wartosc parametru 10 
        ServletContext sc=this.getServletContext(); 
        sc.setAttribute("zmiennaKontekstu", count); // ustawia context widoczny dla wszyskich servletow o wartosci numbers i value 10 aby moc przekazywac dalej
    }

    
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        ServletContext sc = this.getServletContext(); // context spoglada na value = 10
        Random random = new Random();
        int tablica[] = wylosuj(sc, random);
        
        try(PrintWriter out = response.getWriter())
               {
            out.println("<table border='2'>");
            out.println("<tr><td>Wylosowane liczby</td>");
            for (int i = 0 ; i < tablica.length ; i++) {
                out.println("<td>" + tablica[i] + "</td>");
            }
             Arrays.sort(tablica);
            out.println("</tr>");
            out.println("<tr><td>Posortowane liczby</td>");
            for (int i = 0 ; i < tablica.length ; i++) {
                out.println("<td>" + tablica[i] + "</td>");
            }
            out.println("</tr>");
            out.println("</table>");
            out.println("<a href=\"Pierwsze\">Zobacz liczby pierwsze</a>");
               }
       
        synchronized(getServletContext()){
            sc.setAttribute("ObiektServletu", tablica); // ustawiam context wskazujacy na obiekt tablicy , z mozliwoscia jego przekazania do kolejnego servletu
        }
       
  
        
        RequestDispatcher rd = request.getRequestDispatcher("/Pierwsze"); 
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    public static int[] wylosuj (ServletContext sc,Random rand)
    {
        int liczba = (int) sc.getAttribute("zmiennaKontekstu");
         int[] array = new int[liczba]; // tworze 10 liczb z contextu z przedzialu 1-1000
            for (int i = 0 ; i < liczba ; i++) {
            array[i] = rand.nextInt(100);
        }
            return array;
    }
   
}

