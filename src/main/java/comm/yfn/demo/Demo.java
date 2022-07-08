/**
 * Copyright(c) 2018 asura
 */
package comm.yfn.demo;



import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.net.URLEncoder;
import cn.hutool.json.JSONObject;
import comm.study.bean.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;


/**
 * <p></p>
 *
 *
 * @Description:
 * @ClassName Demo
 * @Author zhen.liu
 * @Date 2021/8/30 10:11 上午
 * @Version 1.0
 **/
public class Demo {

    private static final long nd = 1000 * 24 * 60 * 60;
    private static final long nh = 1000 * 60 * 60;


    public static void main(String[] args){
        for (int i = 0; i < 2000; i++) {
            if(i % 3 == 0){
                System.out.println(i);
            }
        }
    }



    public static void getAmt(Long shippingFee,int spuNum){

        BigDecimal bigDecimal = new BigDecimal(shippingFee);

        bigDecimal = bigDecimal.divide(new BigDecimal(100));

        BigDecimal num  = new BigDecimal(spuNum);

        BigDecimal bigDecimal1 = bigDecimal.divide(num,2,RoundingMode.HALF_UP);

        System.out.println(bigDecimal1);

        BigDecimal bigDecimal2 = new BigDecimal(spuNum - 1);

        double lastPrice = bigDecimal.subtract(bigDecimal1.multiply(bigDecimal2)).setScale(2,RoundingMode.HALF_UP).doubleValue();

        System.out.println(lastPrice);
    }
}
