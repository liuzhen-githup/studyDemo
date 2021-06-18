/**
 * Copyright(c) 2018 asura
 */
package comm.study.leetcode;

import java.util.*;

/**
 * <p></p>
 *
 *
 * @Description: 选择排序算法
 * @ClassName SelectSort
 * @Author zhen.liu
 * @Date 2021/6/18 2:52 下午
 * @Version 1.0
 **/
public class SelectSort {

    /**
     * 给定2个数组
     *  arr1 = { 5, 6, 7, 3, 6, 5, 19, 20, 11}
     *  arr2 = { 1, 6, 6, 4, 3, 1}
     *  result = {1, 1, 6, 6, 6, 6, 4, 3, 3, 5, 5, 7, 19, 20, 11}
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr1 = { 5, 6, 7, 3, 6, 5, 19, 20, 11};
        Integer[] arr2 = { 1, 6, 6, 4, 3, 1};
        List<Integer> listA = Arrays.asList(arr1);
        List<Integer> listB = Arrays.asList(arr2);
        List<Integer> listC = new ArrayList<>();
        listC.addAll(listB);
        listC.addAll(listA);
        System.out.println(listC);

        Map<Integer,Integer> map = new HashMap<>();
        listC.forEach( c ->{
            map.put(c, map.getOrDefault(c, 0)+1);
        });
        //统计每个元素出现的次数
        map.forEach((k,v)->System.out.println(k+"出现了"+v+"次"));

        Map<Integer,Integer> map2 = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        listC.forEach( m->{
            if(map2.containsKey(m)){
                return;
            }
            map2.put(m,m);
            if(map.containsKey(m)){
                int len = map.get(m);
                for(int n = 0; n< len ; n++){
                    result.add(m);
                }
            }
        });
        System.out.println(result);
    }
}
