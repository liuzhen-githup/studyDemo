/**
 * Copyright(c) 2018 asura
 */
package comm.study.listmapdemo;

import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 *  hashMap原理解析
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/12 2:52 下午
 */
public class HashMapDemo {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("key","liuzhen");
        map.put("b","zhangshan");
        map.put("c","lisi");
        System.out.println(map);

        System.out.println("key".hashCode());

        int h =  "key".hashCode();
        int  hash = 15 & ("key".hashCode() ^ ("key".hashCode() >>> 16));
        System.out.println(hash);

        int index = 15 & hash;
        System.out.println(index);
    }

}
