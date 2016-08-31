package net.syrotskyi.projects.webServer.accountServer;

public class AccountServer implements AccountServerInterface {
    private int usersLimit;

    public AccountServer() {
        this.usersLimit = 10;
    }

    @Override
    public int getUsersLimit() {
        return usersLimit;
    }

    @Override
    public void setUsersLimit(int newLimit) {
        this.usersLimit = newLimit;
    }
}
