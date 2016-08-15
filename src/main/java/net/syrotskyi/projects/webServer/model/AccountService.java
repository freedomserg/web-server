package net.syrotskyi.projects.webServer.model;

import net.syrotskyi.projects.webServer.model.hibernate.HService;

public class AccountService {

    private HService hService;

    public AccountService() {
        this.hService = new HService();
    }

    public UserProfile getUserByLogin(String login) {
        return hService.getUserByLogin(login);
    }

    public void addUser(UserProfile userProfile) {
        hService.addUser(userProfile);
    }
}
