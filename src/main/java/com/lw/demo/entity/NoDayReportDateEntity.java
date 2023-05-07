package com.lw.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class NoDayReportDateEntity {
    private Long id;

    private String customerId;

    private String employeeNo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private Date createTime;
}
