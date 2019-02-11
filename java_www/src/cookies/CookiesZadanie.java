package cookies;

import sessions.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CookiesZadanie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if(session.getAttribute("user_name") != null) {
            List<String> visitedSites = (ArrayList<String>)session.getAttribute("visited_sites");

            synchronized (session) {
                session.setAttribute("visited_sites", visitedSites.add("/cookies-zadanie - POST"));
            }
        }

        Cookie cookie = new Cookie("name", request.getParameter("name"));
        cookie.setMaxAge(30);
        response.addCookie(cookie);

        response.sendRedirect("/cookies-zadanie");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User loggedUser = (User)session.getAttribute("logged_user");

        if(loggedUser != null) {
            loggedUser.addVisitedSite("Ciasteczka - zadanie");
            synchronized (session) {
                session.setAttribute("logged_user", loggedUser);
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        boolean cookieExists = false;

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ciasteczka</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"/\"><button>Wstecz</button></a>");
            out.println("<p>Napisać serwlet, który identyfikuje użytkownika (nowy/ponowny).<br>" +
                    "<br>" +
                    " * Jeśli użytkownik odwiedza stronę po raz pierwszy, widzi komunikat: \"Witaj gościu\" oraz formularz na podanie imienia.<br>" +
                    " * Jeśli użytkownik odwiedza stronę po raz drugi, widzi komunikat: \"Witaj Imię\". <hr></p>");

            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if(cookie.getName().compareTo("name") == 0) {
                    out.println("<p>Witaj <strong>" + cookie.getValue() + "</strong></p>");
                    cookieExists = true;
                }
            }
            if(!cookieExists) {
                out.println("Witaj gościu!");
                out.println("<form action=\"/cookies-zadanie\" method=\"POST\">" +
                        "<input type=\"text\" placeholder=\"Imie\" name=\"name\" /> " +
                        "<input type=\"submit\" value=\"Wyślij\" /></form>");
            }
            out.println("</body> ");
            out.println("</html>");
        }
    }
}
