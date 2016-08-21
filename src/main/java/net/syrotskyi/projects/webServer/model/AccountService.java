package net.syrotskyi.projects.webServer.model;

public interface AccountService {

    UserProfile getUserByLogin(String login);

    void addUser(UserProfile userProfile);
}
