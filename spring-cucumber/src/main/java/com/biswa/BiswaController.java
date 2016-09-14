package com.biswa;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BiswaController {

    @RequestMapping(method = { RequestMethod.GET }, value = { "/hello" })
    public String sayHello(HttpServletResponse response) {
        return "hello";
    }

    @RequestMapping(method = { RequestMethod.POST }, value = { "/biswa" })
    public String sayHelloPost(HttpServletResponse response) {
        return "hello";
    }

}