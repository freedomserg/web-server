package net.syrotskyi.projects.webServer.accountServer;

public interface AccountServerControllerMBean {

    int getUsersLimit();

    void setUsersLimit(int newLimit);
}
