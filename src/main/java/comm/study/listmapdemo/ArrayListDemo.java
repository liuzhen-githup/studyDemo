/**
 * Copyright(c) 2018 asura
 */
package comm.study.listmapdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/5 11:29 上午
 */
public class ArrayListDemo {
    public static void main(String[] args) {

        testFan();
    }


    public static void testFan() {
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.asList(arr));

    }

    /**
     * ArrayList 动态数组-底层是数组结构
     * 有两个构造函数
     * 1.当调用无参构造时，会默认闯将一个长度为10的数组
     * 2.调用调用有参数构造时，则根据传入的参数创建数组的长度
     * 3.当存储长度不够时，则会进行扩容，初始容量 * 扩容因子（1.5倍）
     * 4.扩容结束后，会讲老数组元素copy到新的数组上
     */
    @Test
    public static void testIter() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add("c");
        list.add("d");

        System.out.println(list);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj.toString());
            list.remove(1);
            System.out.println(list);
        }

    }

    //尾插法
    public static int[] addTail(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = value;
                break;
            }
        }
        return arr;
    }
}
