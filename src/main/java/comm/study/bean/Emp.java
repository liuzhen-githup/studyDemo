/**
 * Copyright(c) 2018 asura
 */
package comm.study.bean;

import lombok.Getter;
import lombok.Setter;

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
public class Emp {

    public String name;
    public int age ;
    public Emp(String name, int age){
        this.name = name ;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
