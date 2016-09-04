package net.syrotskyi.projects.webServer.resourceServer;

public class ResourceServerController implements ResourceServerControllerMBean {

    private ResourceServer resourceServer;

    public ResourceServerController(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    public String getName() {
        return resourceServer.getName();
    }

    @Override
    public int getAge() {
        return resourceServer.getAge();
    }
}
