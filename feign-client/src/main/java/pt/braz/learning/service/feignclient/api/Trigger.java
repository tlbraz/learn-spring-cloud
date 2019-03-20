package pt.braz.learning.service.feignclient.api;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Trigger {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/trigger-hello")
    public String callHelloService(String name) {
        return helloService.hello(name, null);

    }

}
