/**
 * Copyright(c) 2018 asura
 */
package comm.yfn.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 *
 * @Description:
 * @ClassName ListDemo
 * @Author zhen.liu
 * @Date 2022/4/12 1:21 下午
 * @Version 1.0
 **/
public class ListDemo {


    public static void main(String[] args) {
        List<String> data = new ArrayList(){{
            add("a");
            add("b");
            add("c");
            add("d");
            add("e");
        }};
        Map<Integer,String>  map = new HashMap<>();
        map.put(1,"1");
        map.put(3,"3");
        map.put(5,"5");
        map.put(7,"7");
        map.put(9,"9");
        map.put(11,"11");
        map.put(13,"13");
        map.put(15,"15");

        System.out.println(build(data, map));

    }


    public static List<String> build(List<String> data, Map<Integer,String> cardD){
        cardD.forEach((key,value)->{
            if(data.size() >= key){
                data.add(key,value);
            } else {
                data.add(value);
            }
        });
        return data;
    }
}
