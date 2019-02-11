import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.Random;
import java.io.*;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public Listener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        int size = Integer.parseInt(sce.getServletContext().getInitParameter("numbers"));
        LinkedList<Integer> numbers = new LinkedList<Integer>();

        Random r = new Random();
        for(int i = 0; i < size; i++) {
            numbers.add(r.nextInt(100));
        }

        numbers.sort(Integer::compareTo);
        sce.getServletContext().setAttribute("numbers", numbers);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        LinkedList<Integer> numbers = (LinkedList<Integer>) sce.getServletContext().getAttribute("numbers");
        try {
            new FileOutputStream("c:/numbers.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream("c:/numbers.txt",true));
            for(int x: numbers) {
                fileWriter.println(x);
            }
            fileWriter.close();
        }
        catch(FileNotFoundException fnfe) {

        }

    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
