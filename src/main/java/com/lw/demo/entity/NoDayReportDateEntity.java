package com.lw.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class NoDayReportDateEntity {
    private Long id;

    private String customerId;

    private String employeeNo;

    private Date beginDate;

    private Date endDate;

    private Date createTime;
}
