package sessions;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User implements HttpSessionBindingListener {
    private String name;
    private List<String> visitedSites;

    public User(String name) {
        this.name = name;
        this.visitedSites = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public List<String> getVisitedSites() {
        return visitedSites;
    }

    public void addVisitedSite(String site) {
        visitedSites.add(site);
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        Set<User> logins = (Set<User>) event.getSession().getServletContext().getAttribute("logins");
        logins.add(this);
        System.out.println(logins.size());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        Set<User> logins = (Set<User>) event.getSession().getServletContext().getAttribute("logins");
        logins.remove(this);
    }


}
