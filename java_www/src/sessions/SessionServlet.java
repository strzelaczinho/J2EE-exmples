package sessions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User loggedUser = (User)session.getAttribute("logged_user");
        Set<User> logins = (Set<User>) session.getServletContext().getAttribute("logins");
        String name = request.getParameter("name");

        if(!name.equals("") && loggedUser == null) {
            User user = new User(name);
            user.addVisitedSite("Logowanie");
            synchronized (session) {
                session.setAttribute("logged_user", user);
            }

            try (PrintWriter out = response.getWriter()) {
                out.println("Zalogowany jako: " + user.getName());
                out.println("<br>Zalogowanych użytkowników: " + logins.size());
                out.println("<br><a href='/logout'>Wyloguj</a>");
            }
        } else if(loggedUser != null) {
            try (PrintWriter out = response.getWriter()) {
                out.println("Zalogowany jako: " + loggedUser.getName());
                out.println("<br>Zalogowanych użytkowników: " + logins.size());
                out.println("<br><a href='/logout'>Wyloguj</a>");
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("Pole login nie może być puste.");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User loggedUser = (User)session.getAttribute("logged_user");
        Set<User> logins = (Set<User>) session.getServletContext().getAttribute("logins");

        if(logins.size() > 0) {
            try (PrintWriter out = response.getWriter()) {
                logins.forEach((User user) -> {
                    out.println(user.getName() + "<br>");
                    for (int i = user.getVisitedSites().size() - 1; i >= user.getVisitedSites().size() - 3; i--) {
                        if (i >= 0) out.println(" -- " + user.getVisitedSites().get(i) + "<br>");
                    }
                    out.println("<br>");
                });
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("Brak zalogowanych użytkowników.");
            }
        }
        if(loggedUser != null) {
            loggedUser.addVisitedSite("Lista zalogowanych użytkowników");
            synchronized (session) {
                session.setAttribute("logged_user", loggedUser);
            }
        }
    }
}
