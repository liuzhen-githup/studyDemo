/**
 * Copyright(c) 2018 asura
 */
package comm.yfn.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 *
 * @Description:
 * @ClassName CaclcDemo
 * @Author zhen.liu
 * @Date 2022/12/22 18:42
 * @Version 1.0
 **/
public class CaclcDemo {


    public static void main(String[] args) {
        Long couponAmount = 10597L;

        List<Long> itemAmounts = new ArrayList<>();
        itemAmounts.add(2399L);
        itemAmounts.add(3399L);
        itemAmounts.add(4799L);
        Long couponTotalAmount = 10597L;
        Long totalMoney = BigDecimal.ZERO.longValue();
        BigDecimal couponMoney = new BigDecimal(couponAmount);
        for (int i = 0; i < itemAmounts.size(); i++) {
            //走优惠卷
            Long itemAmount = itemAmounts.get(i);
            if(i != itemAmounts.size() - 1){
                BigDecimal percent = new BigDecimal(itemAmount).divide(new BigDecimal(couponTotalAmount),6 ,RoundingMode.DOWN);
                BigDecimal multiply = percent.multiply(couponMoney).setScale(0,RoundingMode.HALF_UP);
                Long percentMoney = multiply.longValue();
                //防止出现负数 平均每个商品的优惠（含数量）
                percentMoney = percentMoney > itemAmount == true ? itemAmount : percentMoney;
                itemAmount = itemAmount - percentMoney;
                //记录单品的优惠金额
                System.out.println("percentMoney：："+percentMoney);
                totalMoney += percentMoney;
            } else {
                //最后一个参与计算优惠的金额
                Long percentMoney = couponAmount - totalMoney;
                //防止出现负数
                percentMoney = percentMoney > itemAmount == true ? itemAmount : percentMoney;
                itemAmount = itemAmount - percentMoney;
                System.out.println("last percentMoney：："+percentMoney);
            }
        }
    }
}
