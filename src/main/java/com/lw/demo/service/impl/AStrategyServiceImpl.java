package com.lw.demo.service.impl;

import com.lw.demo.service.StrategyService;
import org.springframework.stereotype.Service;

/**
 * author:laiwei
 * date:2023/5/7 23:10
 */
@Service
public class AStrategyServiceImpl implements StrategyService {
    @Override
    public String methodForStrategy() {
        return "a方法业务实现";
    }
}
