package net.syrotskyi.projects.webServer.model;

import net.syrotskyi.projects.webServer.model.dbService.DBServiceImpl;

public class AccountService {

    private DBServiceImpl DBServiceImpl;

    public AccountService() {
        this.DBServiceImpl = new DBServiceImpl();
    }

    public UserProfile getUserByLogin(String login) {
        return DBServiceImpl.getUserByLogin(login);
    }

    public void addUser(UserProfile userProfile) {
        DBServiceImpl.addUser(userProfile);
    }
}
