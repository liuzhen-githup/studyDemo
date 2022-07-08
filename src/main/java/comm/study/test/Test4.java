/**
 * Copyright(c) 2018 asura
 */
package comm.study.test;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p></p>
 *
 *
 * @Description: ceshi
 * @ClassName Test4
 * @Author zhen.liu
 * @Date 2021/7/6 1:33 下午
 * @Version 1.0
 **/
public class Test4 {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String pastDate = getPastDate(8);
        long time = format.parse(pastDate).getTime();
        System.out.println(pastDate);
        System.out.println(time);
    }

    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = format.format(today);
        return result;
    }
    public static String getLikeSku(String skuId){
        String likeSku = skuId.substring(0, skuId.lastIndexOf("-")+1);
        if(StringUtils.isEmpty(likeSku)){
            return skuId;
        } else {
            return likeSku;
        }
    }
}
