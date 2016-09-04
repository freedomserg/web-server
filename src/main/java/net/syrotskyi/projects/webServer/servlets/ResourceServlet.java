package net.syrotskyi.projects.webServer.servlets;

import net.syrotskyi.projects.webServer.parser.XmlSaxParser;
import net.syrotskyi.projects.webServer.resourceServer.ResourceServer;
import net.syrotskyi.projects.webServer.resources.TestResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResourceServlet extends HttpServlet {

    private ResourceServer resourceServer;

    public ResourceServlet(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("path");
        resourceServer.setResource(path);
    }
}
