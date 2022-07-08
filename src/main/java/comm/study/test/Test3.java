/**
 * Copyright(c) 2018 asura
 */
package comm.study.test;

import javafx.scene.Parent;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * <p></p>
 *
 *
 * @Description: ceshi
 * @ClassName Test3
 * @Author zhen.liu
 * @Date 2021/7/1 1:24 下午
 * @Version 1.0
 **/
public class Test3 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(null);
        System.out.println(list);

    }

    @Getter
    @Setter
    public static class Param{
        private String key;

        private List<String> value;

        private String orgKey;
    }

    /**
     * 针对特殊属性处理
     *  x-stone >> Stone
     * @param props
     * @return
     */
    private String buildPropValue(String props){
        StringBuilder stringBuilder = new StringBuilder();
        String[] prop = props.split("-");
        if(prop.length == 1){
            stringBuilder.append(prop[0].substring(0,1).toUpperCase(Locale.ROOT)).append(prop[0].substring(1));
        }
        if(prop.length == 2){
            stringBuilder.append(prop[1].substring(0,1).toUpperCase(Locale.ROOT)).append(prop[1].substring(1));
        }
        if(prop.length > 2){
            for (int i = 1 ;i < prop.length ;i ++){
                if(i == 1 ){
                    stringBuilder.append(prop[1].substring(0,1).toUpperCase(Locale.ROOT)).append(prop[1].substring(1)).append("-");
                } else if (i > 1 && i < prop.length-1){
                    stringBuilder.append(prop[i]).append("-");
                } else {
                    stringBuilder.append(prop[i]);
                }
            }
        }
        return stringBuilder.toString();
    }
}


