/**
 * Copyright(c) 2018 asura
 */
package comm.yfn.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 *
 * @Description:
 * @ClassName ListDemo1
 * @Author zhen.liu
 * @Date 2022/3/7 7:27 下午
 * @Version 1.0
 **/
public class ListDemo1 {


    public static void main(String[] args) {
        Map<String,String> str1 = new HashMap<>();
        str1.put("a","a");
        str1.put("b","b");
        str1.put("c","c");
        str1.put("d","d");
        str1.put("id","a");


        Map<String,String> str2 = new HashMap<>();
        str2.put("w","w");
        str2.put("q","q");
        str2.put("id","g");
        str2.put("r","r");
        str2.put("f","f");


        Map<String,String> str3 = new HashMap<>();
        str3.put("s","s");
        str3.put("id","e");
        str3.put("g","g");
        str3.put("j","j");
        str3.put("k","k");

        List<Map<String,String>> list = new ArrayList<>();
        list.add(str1);
        list.add(str2);
        list.add(str3);


        Map<String,String> strs1 = new HashMap<>();
        strs1.put("asda","e");
        strs1.put("id","3");
        strs1.put("c","c");
        strs1.put("d","d");
        strs1.put("ad","a");


        Map<String,String> strs2 = new HashMap<>();
        strs2.put("w","w");
        strs2.put("q","q");
        strs2.put("id","e");
        strs2.put("r","r");
        strs2.put("f","f");


        Map<String,String> strs3 = new HashMap<>();
        strs3.put("s","s");
        strs3.put("id","a");
        strs3.put("g","g");
        strs3.put("j","j");
        strs3.put("k","k");

        List<Map<String,String>> list2 = new ArrayList<>();
        list2.add(strs1);
        list2.add(strs2);
        list2.add(strs3);



        int inNum = 99;
        for (int i = 0;i < 2 ;i++ ) {
            List<Map<String, String>> mapList = null;
            if(i==0){
                mapList = list;
            } else {
                mapList = list2;
            }
            int num = 0;
            for (Map<String,String> map : mapList){
                num++;
                if(map.get("id").equals("e")){
                    if(inNum>num){
                        inNum = num;
                        break;
                    }
                }
            }
        }

        System.out.println(inNum);
    }
}
