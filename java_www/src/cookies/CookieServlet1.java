package cookies;

import sessions.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CookieServlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User loggedUser = (User)session.getAttribute("logged_user");

        if(loggedUser != null) {
            loggedUser.addVisitedSite("Cookies1");
            synchronized (session) {
                session.setAttribute("logged_user", loggedUser);
            }
        }


        Cookie cookie = new Cookie("cookie1", "Short_time_cookie");
                cookie.setMaxAge(6);
        response.addCookie(cookie);

        cookie = new Cookie("cookie2", "Long_time_cookie");
                cookie.setMaxAge(10*60);
        response.addCookie(cookie);

        cookie = new Cookie("cookie3", "Until_browser_closed");
                cookie.setMaxAge(-1);
        response.addCookie(cookie);

        response.sendRedirect("/cookies2");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
