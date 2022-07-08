/**
 * Copyright(c) 2018 asura
 */
package comm.yfn.constant;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 *
 * @Description:
 * @ClassName CartConstant
 * @Author zhen.liu
 * @Date 2021/11/5 4:27 下午
 * @Version 1.0
 **/
public class CartConstant {

    public static List<String> American_Express = null;

    public static List<String> China_UnionPay = null;

    public static List<String> Discover = null;

    public static List<String> Diner = null;

    public static List<String> Japan_Credit_Bureau = null;

    public static List<String> Mastercard = null;

    public static List<String> Visa = null;


    static {
        American_Express = new ArrayList(){{
            add("34");
            add("37");
        }};

        China_UnionPay = new ArrayList(){{
            add("621");
            add("622");
            add("623");
            add("624");
            add("625");
            add("626");
            add("628");
            add("629");

        }};

        Discover = new ArrayList(){{
            add("60");
            add("64");
            add("65");
        }};

        Diner = new ArrayList(){{
            add("30");
            add("36");
        }};

        Japan_Credit_Bureau = new ArrayList(){{
            add("35");
        }};

        Mastercard = new ArrayList(){{
            add("51");
            add("52");
            add("53");
            add("54");
            add("55");
        }};

        Visa = new ArrayList(){{
            add("4");
        }};
    }


    public static String checkCartOrganize(String cartNo){

        if(StringUtils.isEmpty(cartNo)){
            return "";
        }
        if(cartNo.length() == 1){
            if(Visa.contains(cartNo)){
                return "VI";
            }
        } else if(cartNo.length() >= 2){
            if(American_Express.contains(cartNo.substring(0,2))){
                return "AE";
            }
            if(China_UnionPay.contains(cartNo.substring(0,3))){
                return "CU";
            }
            if(Discover.contains(cartNo.substring(0,2))){
                return "DC";
            }
            if(Diner.contains(cartNo.substring(0,2))){
                return "DR";
            }
            if(Japan_Credit_Bureau.contains(cartNo.substring(0,2))){
                return "JCB";
            }
            if(Mastercard.contains(cartNo.substring(0,2))){
                return "MC";
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(checkCartOrganize("6232133234"));
    }


}
