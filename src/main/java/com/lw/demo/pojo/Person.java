package com.lw.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author HP
 * date 2023/5/1 17:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Comparable<Person>{
    private String name;
    private int age;

    /**
     * 左边小于右边的时候
     * -1表示不交换位置 就是升序
     * 1表示交换位置 就是降序
     * 另外一边保持相反即可
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Person o) {
        //升序
//        if(this.getAge()<o.getAge()){
//            return -1;
//        }else if(this.getAge()>o.getAge()){
//            return 1;
//        }
//        return 0;
        //降序写法
        if(this.getAge()<o.getAge()){
            return 1;
        }else if(this.getAge()>o.getAge()){
            return -1;
        }
        return 0;
    }
}
