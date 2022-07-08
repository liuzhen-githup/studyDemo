/**
 * Copyright(c) 2018 asura
 */
package comm.study.test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import comm.study.bean.Emp;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.junit.Assert;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 *
 * @Description: sss
 * @ClassName TestPics
 * @Author zhen.liu
 * @Date 2021/6/24 5:24 下午
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) throws ParseException {
            String orderId = "YFN-5e420ee95e0b45958ec6f8c413c51300-f7f1a";
            int num = (int)(orderId.charAt(orderId.length() - 1)) % 10;

            System.out.println(num);
    }


    /**
     * 获取下一天的当今时刻
     *
     * @param past
     * @return
     */
    public static Date getNextDate(Date now,int past) {

        Calendar calendar  =  new  GregorianCalendar();
        calendar.setTime(now);
        calendar.add(calendar.DATE,past);//把日期往后增加一天.整数往后推,负数往前移动
        Date nextDate = calendar.getTime();
        return nextDate;
    }


    public Set<String> getSet(){
        return Collections.EMPTY_SET;
    }


    public static List<Map<String,String>> getList1(){
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map1 = new LinkedHashMap<>();
        map1.put("c","c");
        list.add(map1);
        Map<String,String> map2 = new HashMap<>();
        map2.put("b","b");
        list.add(map2);
        return list;
    }


    public static List<Map<String,String>> getList2(){
        List<Map<String,String>> list2 = new ArrayList<>();
        Map<String,String> map1 = new HashMap<>();
        map1.put("a","a");
        list2.add(map1);
        Map<String,String> map2 = new HashMap<>();
        map2.put("b","b");
        list2.add(map2);
        Map<String,String> map3 = new HashMap<>();
        map3.put("c","c");
        list2.add(map3);
        return list2;
    }

}
