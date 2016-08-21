package net.syrotskyi.projects.webServer.model.dbService;

import net.syrotskyi.projects.webServer.model.UserDao;
import net.syrotskyi.projects.webServer.model.UserProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HDbService implements DbService {

    private static final String hibernate_show_sql = "false";
    private static final String hibernate_hbm2ddl_auto = "update";

    private final SessionFactory sessionFactory;
    private UserDao userDao;

    public HDbService() {
        Configuration configuration = getH2Configuration();
        sessionFactory = createSessionFactory(configuration);
    }

    private Configuration getH2Configuration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(UserProfile.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:./h2db");
        configuration.setProperty("hibernate.connection.username", "test");
        configuration.setProperty("hibernate.connection.password", "test");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        return configuration;
    }

    @Override
    public UserProfile getUserById(long id) {
        Session session = sessionFactory.openSession();
        userDao = new HUserDao(session);
        UserProfile user = userDao.getUserById(id);
        session.close();
        return user;
    }

    @Override
    public UserProfile getUserByLogin(String login) {
        Session session = sessionFactory.openSession();
        userDao = new HUserDao(session);
        UserProfile user = userDao.getUserByLogin(login);
        session.close();
        return user;
    }

    @Override
    public void addUser(UserProfile newUser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        userDao = new HUserDao(session);
        userDao.addUser(newUser);
        transaction.commit();
        session.close();
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
