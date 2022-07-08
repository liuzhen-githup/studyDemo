/**
 * Copyright(c) 2018 asura
 */
package comm.study.bean;

import lombok.*;

import java.util.List;
import java.util.Objects;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/10 10:51 下午
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Emp {

    public String name;

    public int age ;

    public Boolean admin;

    public List<RmkInfo> rmkInfos;

    @Setter
    @Getter
    @ToString
    public static class RmkInfo{
        private String keys;
        private List<String> value;


    }


    public Emp(String name, int age){
        this.name = name ;
        this.age = age;
    }

}
