package com.lw.demo.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.merge.LoopMergeStrategy;
import com.lw.demo.entity.DemoMergeData;
import com.lw.demo.entity.EmployeeEntity;
import com.lw.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/testEasyExcel")
    public Date testEasyExcel(){
        log.info("获取时间");
//        return DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        return new Date();
    }

    @RequestMapping("/getEmployeeEntity")
    public List<EmployeeEntity> getEmployeeEntity(){
        return employeeService.getEmployeeEntities();
    }

    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("员工出勤明细表", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        LoopMergeStrategy loopMergeStrategy1 = new LoopMergeStrategy(2, 0);
        LoopMergeStrategy loopMergeStrategy2 = new LoopMergeStrategy(2, 1);
        LoopMergeStrategy loopMergeStrategy3 = new LoopMergeStrategy(2, 2);
        EasyExcel.write(response.getOutputStream())
                .head(head())//动态头
                .registerWriteHandler(loopMergeStrategy1)//合并策略
                .registerWriteHandler(loopMergeStrategy2)//合并策略
                .registerWriteHandler(loopMergeStrategy3)//合并策略
                .sheet("员工明细表").doWrite(data());
    }

    //数据 以后从数据库里拿到然后组装 在封装
    private List<DemoMergeData> data(){
        List<DemoMergeData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoMergeData data = new DemoMergeData();
            data.setEmployeeName("lw"+i);
            data.setEmployeeNo(i+"");
            data.setDepartmentName("技术二系统");
            if(i%2==0){
                data.setType("上午");
            }else{
                data.setType("下午");
            }
            data.setDay1("迟到"+i);
            data.setDay2("早退"+i);
            //数据短 表头长 结果是表头长的对应的哪一行没有值
            //数据长 表头短 结果是表头被写满 然后数据多出来了一截
            /*data.setDay3("缺勤"+i);
            data.setDay4("矿工"+i);*/
            list.add(data);
        }
        return list;
    }

    //动态表头
    private List<List<String>> head() {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<String>();
        head0.add("员工姓名");
        List<String> head1 = new ArrayList<String>();
        head1.add("员工工号");
        List<String> head2 = new ArrayList<String>();
        head2.add("员工部门");
        List<String> head3 = new ArrayList<String>();
        head3.add("当前时段");
        List<String> head4 = new ArrayList<String>();
        head4.add("2022-04-01");
        List<String> head5 = new ArrayList<String>();
        head5.add("2022-04-02");
        List<String> head6 = new ArrayList<String>();
        head6.add("2022-04-03");
        list.add(head0);
        list.add(head1);
        list.add(head2);
        list.add(head3);
        list.add(head4);
        list.add(head5);
        list.add(head6);
        return list;
    }

}
