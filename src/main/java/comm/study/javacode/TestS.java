/**
 * Copyright(c) 2018 asura
 */
package comm.study.javacode;

import comm.study.bean.User;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/7 12:47 下午
 */
public class TestS {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        User user = new User();
        //方式一 利用 getClass()
        Class obj = user.getClass();
        Object ss = obj.newInstance();
        System.out.println(obj.getName());
        System.out.println(ss.getClass().getName());

        //方式二 利用 class.forName
        Class obj2 = Class.forName("comm.study.bean.User");
        System.out.println(obj2.getName());

        //方式三 通过类名
        Class obj3 = User.class;
        System.out.println(obj3.getName());
    }
}
