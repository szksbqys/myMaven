package com.lw.demo.controller;

import com.lw.demo.common.Result;
import com.lw.demo.context.StrategyContext;
import com.lw.demo.service.StrategyService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author:laiwei
 * date:2023/5/7 23:00
 * 新建策略类接口
 */
@RestController
@RequestMapping("/strategy")
public class StrategyController {

    @Resource
    private StrategyContext strategyContext;

    /**
     *  根据类型返回策略
     *  restful风格
     */
    @RequestMapping("/test1/{type}")
    public Result test1(@PathVariable("type") int type){
        StrategyService strategyService = strategyContext.getStrategyServiceImpl(type);
        return Result.success(strategyService.methodForStrategy());
    }
}
