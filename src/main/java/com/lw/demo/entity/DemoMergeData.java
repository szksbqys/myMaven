package com.lw.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ContentLoopMerge;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
// 将第6-7行的2-3列合并成一个单元格
// @OnceAbsoluteMerge(firstRowIndex = 5, lastRowIndex = 6, firstColumnIndex = 1, lastColumnIndex = 2)
public class DemoMergeData {
    // 这一列 每隔2行 合并单元格
    @ContentLoopMerge(eachRow = 2)
    @ExcelProperty("员工姓名")
    private String employeeName;

    @ContentLoopMerge(eachRow = 2)
    @ExcelProperty("员工工号")
    private String employeeNo;

    @ExcelProperty("员工部门")
    @ContentLoopMerge(eachRow = 2)
    private String  departmentName;

    @ExcelProperty("当前时段")
    private String type;

    //@ExcelProperty("")
    private String day1;

    //@ExcelProperty("当前时段")
    private String day2;

    //@ExcelProperty("当前时段")
    private String day3;

    //@ExcelProperty("当前时段")
    private String day4;
}
