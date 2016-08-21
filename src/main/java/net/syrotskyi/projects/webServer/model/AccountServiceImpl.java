package net.syrotskyi.projects.webServer.model;

import net.syrotskyi.projects.webServer.model.dbService.DbService;
import net.syrotskyi.projects.webServer.model.dbService.HDbService;

public class AccountServiceImpl implements AccountService {

    private DbService dbService;

    public AccountServiceImpl() {
        this.dbService = new HDbService();
    }

    @Override
    public UserProfile getUserByLogin(String login) {
        return dbService.getUserByLogin(login);
    }

    @Override
    public void addUser(UserProfile userProfile) {
        dbService.addUser(userProfile);
    }
}
