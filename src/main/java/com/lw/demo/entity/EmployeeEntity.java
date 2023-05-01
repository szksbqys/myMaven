package com.lw.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    private long id;
    private String customerId;
    private String employeeNo;
    private String  employeeName;
    private String creator;
    private Date createTime;
    private String updater;
    private Date updateTime;
}
