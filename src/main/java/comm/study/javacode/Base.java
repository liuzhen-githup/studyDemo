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
 * @Date 2021/4/17 2:15 下午
 */
public class Base {

    public static void main(String[] args) {
        Base base = new Sub();
    }
    public static String name="base";
    public Base(){
        printName();
    }
    public void printName(){
        System.out.println(name);
    }
    static class Sub extends Base{
        private  String name ="sub";
        public void printName(){
            System.out.println(name);
        }
    }
}

