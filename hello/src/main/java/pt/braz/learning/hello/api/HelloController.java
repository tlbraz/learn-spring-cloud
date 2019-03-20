package pt.braz.learning.hello.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.StringUtils.isEmpty;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @Value("${server.port}")
    private int port;

    @GetMapping
    public String hello(@RequestParam(required = false) String name, @RequestHeader(value = "zuul", required = false) String zuul) {
        String appName = port+"";
        String via = isEmpty(zuul) ? "direct" : zuul;
        return String.format("Hello Mr. %s! Greetings from %s! - request sent via %s ", name, appName, via);
    }

}
