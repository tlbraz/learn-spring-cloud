package pt.braz.learning.service.feignclient.api;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloServiceCaller extends HystrixCommand<String> {

    String name;
    HelloServiceEndpoint endpoint;

    protected HelloServiceCaller(HelloServiceEndpoint endpoint, String name) {
        super(HystrixCommandGroupKey.Factory.asKey("hello"));
        this.name = name;
        this.endpoint = endpoint;
    }

    @Override
    protected String run() throws Exception {
        return endpoint.hello(name, "feign");
    }
}
