package com.lw.demo.service.impl;

import com.lw.demo.dao.EmployeeDao;
import com.lw.demo.entity.EmployeeEntity;
import com.lw.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDao employeeDao;

    @Override
    public List<EmployeeEntity> getEmployeeEntities() {
        return employeeDao.getEmployeeEntities();
    }
}
