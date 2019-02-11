import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calculator")
public class Calculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        float n1 = Float.parseFloat(request.getParameter("numberOne"));
        float n2 = Float.parseFloat(request.getParameter("numberTwo"));
        String operation = request.getParameter("operation");

        if(operation.equals("addition")) {
            out.println(n1 + n2);
        }
        else if(operation.equals("subtraction")) {
            out.println(n1 - n2);
        }
        else if(operation.equals("multiplication")) {
            out.println(n1 * n2);
        }
        else {
            out.println(n1 / n2);
        }
    }
}
