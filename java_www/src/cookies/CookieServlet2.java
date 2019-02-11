package cookies;

import sessions.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CookieServlet2 extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User loggedUser = (User)session.getAttribute("logged_user");

        if(loggedUser != null) {
            loggedUser.addVisitedSite("Cookies2");
            synchronized (session) {
                session.setAttribute("logged_user", loggedUser);
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ciasteczka</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"/\"><button>Wstecz</button></a>");
            out.println("<h1>Ciasteczka</h1>");

            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                out.println("<p>" + cookie.getName() + ": " + cookie.getValue() + "</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
