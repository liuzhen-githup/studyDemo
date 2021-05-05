/**
 * Copyright(c) 2018 asura
 */
package comm.study.listmapdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 * 两个集合 ，查看包含的数据
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/19 7:45 下午
 */
public class TestList {

    public static List<Integer> list1 = new ArrayList<>();
    public static List<Integer> list2 = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();
    static {
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(9);

        list2.add(8);
        list2.add(6);
        list2.add(4);
        list2.add(2);
        list2.add(5);
    }

    public static void main(String[] args) {
        for (int a: list1) {
            map.put(a,a);
        }

        for (int b: list2) {
            if(map.containsKey(b)){
                System.out.println(b);
            }
        }
    }


}
