
import com.alibaba.fastjson.JSON;
import com.lw.demo.SpringDemoApplication;
import com.lw.demo.common.Result;
import com.lw.demo.controller.NoDayReportDateController;
import com.lw.demo.dao.NoDayReportDateDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * author HP
 * date 2023/4/30 15:50
 */
@SpringBootTest(classes = SpringDemoApplication.class,properties = "classpath:application.properties")
@RunWith(SpringRunner.class)
public class ControllerTest {

    @Resource
    private NoDayReportDateController noDayReportDateController;

    @Test
    public void testGetAll(){
        Result all = noDayReportDateController.getAll();
        System.out.println(JSON.toJSONString(all));
    }
}
