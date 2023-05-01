import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.merge.LoopMergeStrategy;
import com.lw.demo.entity.DemoMergeData;
import com.lw.demo.entity.EmployeeEntity;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 所有测试excel的方法
 */
public class ExcelTest {

    @Test
    public void testPoiExcel() throws IOException {
        EmployeeEntity employee1 = EmployeeEntity.builder().id(1)
                .customerId("399")
                .employeeNo("109232")
                .employeeName("lw")
                .creator("lw")
                .createTime(new Date()).build();

        EmployeeEntity employee2 = EmployeeEntity.builder().id(1)
                .customerId("399")
                .employeeNo("109233")
                .employeeName("ljf")
                .creator("lw")
                .createTime(new Date()).build();

        EmployeeEntity employee3 = EmployeeEntity.builder().id(1)
                .customerId("399")
                .employeeNo("109234")
                .employeeName("fsp")
                .creator("lw")
                .createTime(new Date()).build();

        List<EmployeeEntity> list=new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        // 创建工作铺
        Workbook wb= new SXSSFWorkbook();
        //搞一个表格
        Sheet sheet = wb.createSheet("员工表");
        //创建标题行
        Row row = sheet.createRow(0);
        //给第一行设置各个标题
        Cell cell = row.createCell(0);
        cell.setCellValue("员工id");
        cell=row.createCell(1);
        cell.setCellValue("客户号");
        cell=row.createCell(2);
        cell.setCellValue("员工工号");
        cell=row.createCell(3);
        cell.setCellValue("员工姓名");
        cell=row.createCell(4);
        cell.setCellValue("创建人");
        cell=row.createCell(5);
        cell.setCellValue("创建时间");
        //然后把数据拼接到对应的格子上
        AtomicInteger rowIndex=new AtomicInteger(1);
        for (EmployeeEntity employeeEntity : list) {
            //创建数据行
            row = sheet.createRow(rowIndex.getAndIncrement());
            row.createCell(0).setCellValue(employeeEntity.getId());
            row.createCell(1).setCellValue(employeeEntity.getCustomerId());
            row.createCell(2).setCellValue(employeeEntity.getEmployeeNo());
            row.createCell(3).setCellValue(employeeEntity.getEmployeeName());
            row.createCell(4).setCellValue(employeeEntity.getCreator());
            row.createCell(5).setCellValue(DateUtil.formatDateTime(employeeEntity.getCreateTime()));
        }
        //导出数据 写流
        wb.write(new FileOutputStream("d:\\test\\员工表.xlsx"));
    }

    @Test
    public void testMergeExcel() throws Exception{
        //数据部分
        EmployeeEntity employee1 = EmployeeEntity.builder().id(1)
                .customerId("399")
                .employeeNo("109232")
                .employeeName("lw")
                .creator("lw")
                .createTime(new Date()).build();

        EmployeeEntity employee2 = EmployeeEntity.builder().id(1)
                .customerId("399")
                .employeeNo("109233")
                .employeeName("ljf")
                .creator("lw")
                .createTime(new Date()).build();

        EmployeeEntity employee3 = EmployeeEntity.builder().id(1)
                .customerId("399")
                .employeeNo("109234")
                .employeeName("fsp")
                .creator("lw")
                .createTime(new Date()).build();
        List<EmployeeEntity> list=new ArrayList<>();
        list.add(employee1);
        list.add(employee1);
        list.add(employee2);
        list.add(employee2);
        list.add(employee3);
        list.add(employee3);
        //excel部分
        HSSFWorkbook wb=new HSSFWorkbook();
        HSSFCellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        HSSFSheet sheet = wb.createSheet("xxx");
        HSSFRow row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("员工id");
        cell.setCellStyle(style);
        cell=row.createCell(1);
        cell.setCellValue("客户号");
        cell.setCellStyle(style);
        cell=row.createCell(2);
        cell.setCellValue("员工工号");
        cell.setCellStyle(style);
        cell=row.createCell(3);
        cell.setCellValue("员工姓名");
        cell.setCellStyle(style);
        cell=row.createCell(4);
        cell.setCellValue("创建人");
        cell.setCellStyle(style);
        cell=row.createCell(5);
        cell.setCellValue("创建时间");
        cell.setCellStyle(style);
        //然后把数据拼接到对应的格子上
        AtomicInteger rowIndex=new AtomicInteger(1);
        for (int i=0;i<list.size();i++) {
            //创建数据行
            if(i%2==0){
                row = sheet.createRow(rowIndex.getAndIncrement());
                row.createCell(0).setCellValue(list.get(i).getId());
                row.createCell(1).setCellValue(list.get(i).getCustomerId());
                row.createCell(2).setCellValue(list.get(i).getEmployeeNo());
                row.createCell(3).setCellValue(list.get(i).getEmployeeName());
                row.createCell(4).setCellValue(list.get(i).getCreator());
                row.createCell(5).setCellValue(DateUtil.formatDateTime(list.get(i).getCreateTime()));
            }else{
                row = sheet.createRow(rowIndex.getAndIncrement());
                row.createCell(0).setCellValue(list.get(i).getId());
                row.createCell(1).setCellValue(list.get(i).getCustomerId());
                row.createCell(2).setCellValue(list.get(i).getEmployeeNo());
                row.createCell(3).setCellValue(list.get(i).getEmployeeName());
                row.createCell(4).setCellValue(list.get(i).getCreator());
                row.createCell(5).setCellValue(DateUtil.formatDateTime(list.get(i).getCreateTime()));
            }

        }
        CellRangeAddress cellRangeAddress = new CellRangeAddress(1, list.size(), 0, 0);
        sheet.addMergedRegion(cellRangeAddress);
        //导出数据 写流
        wb.write(new FileOutputStream("e:\\员工表.xlsx"));
    }



    //前置数据注入 before注解必须为void
    @Before
    public void before(){

    }

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

    /**
     * 测试easyExcel
     */
    @Test
    public void testEasyExcel(){
        //得到数据
        List<DemoMergeData> list = data();
        System.out.println(list);
        //准备写出数据
        // 方法1 注解
        String fileName = "e:\\" + "mergeWrite" + System.currentTimeMillis() + ".xlsx";
        // 在DemoStyleData里面加上ContentLoopMerge注解
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoMergeData.class).sheet("员工表").doWrite(data());
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

    @Test
    public void testDynamicTableHeadForExcel(){
        List<List<String>> head = head();
        // 方法1 注解
        String fileName = "e:\\" + "mergeWrite" + System.currentTimeMillis()+ ".xlsx";
        // 每隔2行会合并 把eachColumn 设置成 3 也就是我们数据的长度，所以就第一列会合并。当然其他合并策略也可以自己写
        LoopMergeStrategy loopMergeStrategy1 = new LoopMergeStrategy(2, 0);
        LoopMergeStrategy loopMergeStrategy2 = new LoopMergeStrategy(2, 1);
        LoopMergeStrategy loopMergeStrategy3 = new LoopMergeStrategy(2, 2);
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName)
                .head(head())//动态头
                .registerWriteHandler(loopMergeStrategy1)//合并策略
                .registerWriteHandler(loopMergeStrategy2)//合并策略
                .registerWriteHandler(loopMergeStrategy3)//合并策略
                .sheet("员工明细表").doWrite(data());
    }
}
