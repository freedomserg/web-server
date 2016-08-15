package net.syrotskyi.projects.webServer.model;

public interface UserDao {

    void addUser(UserProfile user);

    UserProfile getUserById(long id);

    UserProfile getUserByLogin(String login);
}
