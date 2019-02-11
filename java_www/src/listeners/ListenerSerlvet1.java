package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListenerSerlvet1 implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {

        int size = Integer.parseInt(event.getServletContext().getInitParameter("size"));
        List<Integer> lista = new ArrayList<>();

        Random r = new Random();
        for(int i = 0; i < size; i++) {
            lista.add(r.nextInt(100));
        }

        lista.sort(Integer::compareTo);
        event.getServletContext().setAttribute("lista", lista);
    }

    public void contextDestroyed(ServletContextEvent event) {
        List<Integer> lista = (ArrayList<Integer>)event.getServletContext().getAttribute("lista");
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/mateusz/Pulpit/Politechnika/Java/lista.txt"), "utf-8"));
            for(int l: lista) {
                writer.write(l +"\r\n");
            }
        } catch (IOException ex) {
            System.out.println("IO Exception");
        } finally {
            try {writer.close();} catch (Exception ex) {}
        }
    }
}
