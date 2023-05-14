package com.lw.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author laiwei
 * 2023/5/14 14:17
 */
@Data
@ApiModel("部门dto")
public class DepartmentDTO {

    @ApiModelProperty("部门id")
    private String departmentId;

    @ApiModelProperty("部门名称")
    private String departmentName;
}
