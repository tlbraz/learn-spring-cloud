package pt.braz.learning.service.feignclient.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Trigger {

    @Autowired
    private HelloServiceEndpoint helloServiceEndpoint;

    @RequestMapping("/trigger-hello")
    public String callHelloService(String name) {
        return new HelloServiceCaller(helloServiceEndpoint, name).execute();

    }

}
