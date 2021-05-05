/**
 * Copyright(c) 2018 asura
 */
package comm.study.javacode;

import comm.study.bean.Emp;

/**
 * <p></p>
 * 重写HashCode原理 与 equals
 *  1.重写equals方法时，必须
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/14 3:43 下午
 */
public class EqualsAndHashCodeDemo {

    public static void main(String[] args) {
        Emp emp1 = new Emp("liuzhen",23);
        Emp emp2 = new Emp("liuzhen",23);


        System.out.println(emp1.equals(emp2));
    }
}
