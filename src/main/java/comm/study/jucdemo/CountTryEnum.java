/**
 * Copyright(c) 2018 asura
 */
package comm.study.jucdemo;


import lombok.Getter;
import lombok.Setter;

/**
 * <p></p>
 *
 * 枚举类
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/15 12:30 下午
 */
public enum CountTryEnum {
    ONE(1,"齐"),
    TWO(2,"楚"),
    THREE(3,"燕"),
    FOUR(4,"赵"),
    FIVE(5,"魏"),
    SIX(6,"韩");


     @Setter@Getter private Integer retCode;
     @Setter@Getter private String retMessage;

    CountTryEnum(Integer retCode,String retMessage){
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountTryEnum ForEach_CountTryEnum(int index){
        for (CountTryEnum enums: CountTryEnum.values()) {
            if(enums.getRetCode() == index){
                return enums;
            }
        }
        return null;
    }
}
