/**
 * Copyright(c) 2018 asura
 */
package comm.study.test;

import comm.study.bean.Emp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p></p>
 *
 *
 * @Description:
 * @ClassName ListSort
 * @Author zhen.liu
 * @Date 2021/8/11 11:46 上午
 * @Version 1.0
 **/
public class ListSort {


    public static void main(String[] args) {
        List<Emp> list = new ArrayList<>();

        Emp emp = new Emp();
        emp.setName("lz");
        emp.setAge(21);
        emp.setAdmin(false);
        list.add(emp);

        Emp emp1 = new Emp();
        emp1.setName(null);
        emp1.setAge(22);
        emp1.setAdmin(false);
        list.add(emp1);

        Emp emp2 = new Emp();
        emp2.setName(null);
        emp2.setAge(25);
        emp2.setAdmin(false);
        list.add(emp2);

        Emp emp3 = new Emp();
        emp3.setName("cxy");
        emp3.setAge(23);
        emp3.setAdmin(false);
        list.add(emp3);

        list.sort(Comparator.comparing(Emp::getName,Comparator.nullsLast(String::compareTo)));

        System.out.println(list);
    }


}
