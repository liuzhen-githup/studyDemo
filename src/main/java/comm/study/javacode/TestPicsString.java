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
public class TestPicsString {

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
}
