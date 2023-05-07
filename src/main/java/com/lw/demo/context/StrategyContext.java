package com.lw.demo.context;

import com.lw.demo.service.StrategyService;
import com.lw.demo.service.impl.AStrategyServiceImpl;
import com.lw.demo.service.impl.BStrategyServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * author:laiwei
 * date:2023/5/7 23:13
 */
@Component
public class StrategyContext {

    @Resource
    private AStrategyServiceImpl aStrategyService;

    @Resource
    private BStrategyServiceImpl bStrategyService;

    //@Resource
    private Map<Integer, StrategyService> map=new HashMap<>();

    @PostConstruct
    public void initMap(){
        map.put(1,aStrategyService);
        map.put(2,bStrategyService);
    }

    public StrategyService getStrategyServiceImpl(int type){
        StrategyService strategyService = map.get(type);
        return strategyService;
    }
}
