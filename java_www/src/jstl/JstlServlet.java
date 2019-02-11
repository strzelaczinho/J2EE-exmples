package jstl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "JstlServlet", urlPatterns = {"/jstl"})
public class JstlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<UserData> users = new ArrayList<>();

        users.add(new UserData("Janusz", "Kowalski", "Gdańsk", "512-512-622", "test@asp.pl"));
        users.add(new UserData("Paulina", "Kowalska", "Białystok", "124-172-622", "test1@wp.pl"));
        users.add(new UserData("Marek", "Nowak", "Warszawa", "167-672-622", "test2@wp.pl"));
        users.add(new UserData("Tomasz", "Malski", "Kraków", "722-412-622", "test3@wp.pl"));

        request.setAttribute("users", users);

        RequestDispatcher rd=request.getRequestDispatcher("/jstlZad1.jsp");
        rd.forward(request, response);
    }
}
