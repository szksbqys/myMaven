package javaApiTest;

import com.lw.demo.pojo.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * author HP
 * date 2023/5/1 17:15
 */
public class ComparableTest {

    public List<Person> list=new ArrayList<>();

    /**
     * 装配好集合对象
     */
    @Before
    public void addList(){
        Person lw = new Person("lw", 26);
        Person xsp = new Person("xsp", 29);
        Person wly = new Person("wly", 23);
        list.add(lw);
        list.add(xsp);
        list.add(wly);
    }


    /**
     * 测试自定义对象的排序
     */
    @Test
    public void testComparable(){
        System.out.println("未排序的集合"+list);
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                //升序
//                if(o1.getAge()<o2.getAge()){
//                    return -1;
//                }else if(o1.getAge()>o2.getAge()){
//                    return 1;
//                }
//                return 0;
                //降序
                if(o1.getAge()<o2.getAge()){
                    return 1;
                }else if(o1.getAge()>o2.getAge()){
                    return -1;
                }
                return 0;
            }
        });
        System.out.println("排序后"+list);
    }

    @Test
    public void testComparableInterface(){
        System.out.println("未排序前"+list);
        Collections.sort(list);
        System.out.println("排序后："+list);
    }
}
