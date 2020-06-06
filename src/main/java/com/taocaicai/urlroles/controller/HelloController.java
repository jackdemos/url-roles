package com.taocaicai.urlroles.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Oakley
 * @version 0.0.1
 * @Date 2020-06-07 04:11:4:11
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello security";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin";
    }

    @GetMapping("/dba/hello")
    public String dba() {
        return "hello dba";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user";
    }

    @GetMapping("/user/userInfo")
    public String userInfo(){
        return "this is user info page";
    }
}
