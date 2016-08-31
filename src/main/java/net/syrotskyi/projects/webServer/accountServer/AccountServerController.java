package net.syrotskyi.projects.webServer.accountServer;

public class AccountServerController implements AccountServerControllerMBean {
    private AccountServerInterface accountServer;

    public AccountServerController(AccountServerInterface accountServer) {
        this.accountServer = accountServer;
    }

    @Override
    public int getUsersLimit() {
        return accountServer.getUsersLimit();
    }

    @Override
    public void setUsersLimit(int newLimit) {
        accountServer.setUsersLimit(newLimit);
    }
}
