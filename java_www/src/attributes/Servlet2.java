package attributes;

import sessions.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Servlet2", urlPatterns = {"/atrybuty2"})
public class Servlet2 extends HttpServlet {

    private void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User loggedUser = (User)session.getAttribute("logged_user");

        if(loggedUser != null) {
            loggedUser.addVisitedSite("Atrybuty - Lista");
            synchronized (session) {
                session.setAttribute("logged_user", loggedUser);
            }
        }

        ArrayList<String> lista_osob;

        ServletContext sc = this.getServletContext();
        synchronized(getServletContext()){
            lista_osob = (ArrayList<String>)sc.getAttribute("lista");
        }


        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Wyświetlanie użytkowników</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista:</h1><ul>");
            for(String os:lista_osob){
                out.println("<li>" + os + "</li>");
            }
            out.println("</ul></body>");
            out.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccessRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccessRequest(request, response);
    }
}
