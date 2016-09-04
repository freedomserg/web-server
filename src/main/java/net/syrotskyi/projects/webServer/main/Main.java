package net.syrotskyi.projects.webServer.main;

import net.syrotskyi.projects.webServer.resourceServer.ResourceServer;
import net.syrotskyi.projects.webServer.resourceServer.ResourceServerController;
import net.syrotskyi.projects.webServer.resourceServer.ResourceServerControllerMBean;
import net.syrotskyi.projects.webServer.servlets.ResourceServlet;
import org.apache.logging.log4j.LogManager;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Main {

    //private static AccountService accountService;
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Main.class.getName());
    //private static AccountServerInterface accountServer;
    private static ResourceServer resourceServer;

    public static void main(String[] args) throws Exception {
        //accountService = new AccountServiceImpl();
        if (args.length != 1) {
            logger.error("Use port as the first argument");
            System.exit(1);
        }
        String portString = args[0];
        int port = Integer.valueOf(portString);


        //accountServer = new AccountServer();
        resourceServer = new ResourceServer();

        //AccountServerControllerMBean serverStat = new AccountServerController(accountServer);
        ResourceServerControllerMBean serverStat = new ResourceServerController(resourceServer);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("Admin:type=ResourceServerController");
        mbs.registerMBean(serverStat, name);
        logger.info("MbeanInfo: " + mbs.getMBeanInfo(name).toString());
        logger.info(mbs.isRegistered(name));
        logger.info(mbs.getMBeanCount());


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");
        //context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
        //context.addServlet(new ServletHolder(new AdminServlet(accountServer)), "/admin");
        context.addServlet(new ServletHolder(new ResourceServlet(resourceServer)), "/resources");

        //ResourceHandler resource_handler = new ResourceHandler();
        //resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{context});

        Server server = new Server(port);
        server.setHandler(handlers);

        server.start();

        logger.info("Server started");

        server.join();
    }
}
