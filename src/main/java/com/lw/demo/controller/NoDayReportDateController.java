package com.lw.demo.controller;

import com.lw.demo.common.Result;
import com.lw.demo.dao.NoDayReportDateDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author HP
 * date 2023/4/30 15:46
 */

@RestController
@RequestMapping("/noDayReportDate")
public class NoDayReportDateController {

    @Resource
    private NoDayReportDateDao noDayReportDateDao;

    @RequestMapping("/getAll")
    public Result getAll(){
        return Result.success(noDayReportDateDao.queryAllEntity());
    }
}
