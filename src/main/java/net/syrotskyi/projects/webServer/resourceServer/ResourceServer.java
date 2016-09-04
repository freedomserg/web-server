package net.syrotskyi.projects.webServer.resourceServer;

import net.syrotskyi.projects.webServer.parser.XmlSaxParser;
import net.syrotskyi.projects.webServer.resources.TestResource;

public class ResourceServer {

    private TestResource resource;

    public ResourceServer() {
        this.resource = new TestResource();
    }

    public TestResource getResource() {
        return resource;
    }

    public void setResource(String path) {
        TestResource resource = (TestResource) XmlSaxParser.readXML(path);
        this.resource = resource;
    }

    public String getName() {
        return resource.getName();
    }

    public int getAge() {
        return resource.getAge();
    }
}
