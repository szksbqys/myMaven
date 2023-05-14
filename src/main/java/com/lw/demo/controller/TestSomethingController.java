package com.lw.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author laiwei
 * 2023/5/14 13:58
 */
@RequestMapping("testSomething")
@Api(tags = "测试一些东西")
@RestController
public class TestSomethingController {

    @ApiOperation("测试jsr03嵌套校验")
    @RequestMapping("/testJrs03")
    public String testJsr03(){
        return "因为没有看到jdk有这个包导致我现在引入不了自带的注解";
    }
}
