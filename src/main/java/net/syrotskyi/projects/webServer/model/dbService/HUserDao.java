package net.syrotskyi.projects.webServer.model.dbService;

import net.syrotskyi.projects.webServer.model.UserDao;
import net.syrotskyi.projects.webServer.model.UserProfile;
import org.hibernate.Query;
import org.hibernate.Session;

public class HUserDao implements UserDao {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void addUser(UserProfile user) {
        session.save(user);
    }

    @Override
    public UserProfile getUserById(long id) {
        return (UserProfile) session.get(UserProfile.class, id);
    }

    @Override
    public UserProfile getUserByLogin(String login) {
        Query query = session.createQuery
                ("SELECT user FROM UserProfile user WHERE user.login like :login");
        query.setParameter("login", login);
        return (UserProfile) query.uniqueResult();
    }
}
