/**
 * Copyright(c) 2018 asura
 */
package comm.study.javacode;

import comm.study.bean.Emp;
import comm.study.bean.Seance;

import java.util.Optional;

/**
 * <p></p>
 *
 *
 * @Description: Optional 校验值是否为空，避免空指针异常
 * @ClassName JDKOptional
 * @Author zhen.liu
 * @Date 2021/6/18 9:42 上 午
 * @Version 1.0
 **/
public class JDKOptional {

    public static void main(String[] args) {
        Seance seance = null;

        /**
         * emp：任何一个获取值为空返回为空
         */
        Emp emp = Optional.ofNullable(seance).map(Seance::getEmp).orElse(null);

        String name = Optional.ofNullable(emp).map(Emp::getName).orElse(null);
        System.out.println(name);

    }

}
