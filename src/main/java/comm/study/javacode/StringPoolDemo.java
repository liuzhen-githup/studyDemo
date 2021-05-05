/**
 * Copyright(c) 2018 asura
 */
package comm.study.javacode;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/26 8:46 上午
 */
public class StringPoolDemo {
    public static void main(String[] args) {
        String str = new StringBuilder("ABC").append("DEF").toString();
        System.out.println(str);
        System.out.println(str.intern());
        System.out.println(str == str.intern());

        System.out.println();

        /**
         * 下面代码出现false，是因为在java类库中，有一个java字符串在虚拟机加载sun.misc.Version 这个类的时候就已经创建在常量池中
         */
        String str1 = new StringBuilder("ja").append("va").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        System.out.println();


        String obj = new String("ABC");
        String obj1 = new String("ABC");
        System.out.println(obj == obj1);
    }
}
