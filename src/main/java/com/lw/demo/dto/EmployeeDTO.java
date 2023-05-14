package com.lw.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author laiwei
 * 2023/5/14 14:14
 */
@Data
@ApiModel("员工条件类")
public class EmployeeDTO {
    @ApiModelProperty("姓名")
    private String employeeName;

    @ApiModelProperty("工号")
    private String employeeNo;


}
