package net.syrotskyi.projects.webServer.servlets;

import net.syrotskyi.projects.webServer.accountServer.AccountServerInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet {

    private AccountServerInterface accountServer;

    public AdminServlet(AccountServerInterface accountServer) {
        this.accountServer = accountServer;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(accountServer.getUsersLimit());
    }
}
