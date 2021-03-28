package com.simple.swaggerlearn.controller;

import com.simple.swaggerlearn.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author Simple
 * @data 2021/3/28 11:20
 */

@RestController

public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    // 只要我们的接口中，返回值中存在实体类, 他就会扫描到Swagger中
    @RequestMapping(value = "/user")
    public User user(){
        return new User();
    }

    @ApiOperation("hello控制类")
    @GetMapping(value = "/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello " + username;
    }

    @ApiOperation("Post测试类")
    @PostMapping(value = "/postt")
    public User postt(@ApiParam("用户名") User user){
        return user;
    }
}
