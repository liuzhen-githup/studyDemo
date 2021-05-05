/**
 * Copyright(c) 2018 asura
 */
package comm.study.javacode;

import org.junit.Test;

import java.util.*;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/22 4:39 下午
 */
public class TestString {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        String str = "abcweabdewsdfxsxzcsdfasd";
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            String ch1 = String.valueOf(ch[i]);
            map.put(ch1, map.getOrDefault(ch1, 0)+1);
        }
        map.forEach((k,v)->System.out.println(k+"出现了"+v+"次"));


    }

    @Test
    public void testString(){
        int current = Integer.MAX_VALUE;
        int next = current >= Integer.MAX_VALUE?0:current+1;

        System.out.println(next);

        int num = next % 2;
        System.out.println(num);
    }


    /**
     * arr1 = {2,4,3,5,7,2,19,8};
     * arr2 = {2,3,4,7,1};
     *
     * 输出结果： 2,2,2,3,3,4,4,7,7,1,5,19,8
     */
    @Test
    public void testString2(){
        int[] arr1 = {2,4,3,5,7,2,19,8};
        int[] arr2 = {2,3,4,7,1};
        int[] c= new int[arr1.length+arr2.length];
        System.arraycopy(arr2, 0, c, 0, arr2.length);
        System.arraycopy(arr1, 0, c, arr2.length, arr1.length);
        System.out.println(Arrays.toString(c));

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<c.length;i++){
            int ch1 = c[i];
            map.put(ch1, map.getOrDefault(ch1, 0)+1);
        }
        map.forEach((k,v)->System.out.println(k+"出现了"+v+"次"));

        StringBuilder sb = new StringBuilder();
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < c.length ; i++) {
            if(map2.containsKey(c[i])){
                continue;
            }
            map2.put(c[i],c[i]);
            sb.append(c[i]).append(",");
            if(map.containsKey(c[i])){
                int len = map.get(c[i]);
                for(int n = 0; n< len -1; n++){
                    sb.append(c[i]).append(",");
                }
            }
        }
        System.out.println(sb.toString());
    }

}
