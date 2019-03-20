package pt.braz.learning.service.feignclient.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello")
@RequestMapping("/hello")
public interface HelloServiceEndpoint {

        @GetMapping
        public String hello(@RequestParam(required = false) String name, @RequestHeader(value = "zuul", required = false) String zuul);

}
