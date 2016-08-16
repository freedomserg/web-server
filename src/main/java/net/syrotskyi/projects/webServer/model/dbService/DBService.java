package net.syrotskyi.projects.webServer.model.dbService;

import net.syrotskyi.projects.webServer.model.UserProfile;

public interface DBService {

    UserProfile getUserById(long id);

    UserProfile getUserByLogin(String login);

    void addUser(UserProfile newUser);
}
