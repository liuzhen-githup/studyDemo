/**
 * Copyright(c) 2018 asura
 */
package comm.study.jvmdemo;

/**
 * <p></p>
 *  查看栈的深度
 *      利用递归操作查看
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/4/19 7:38 下午
 */
public class StackTest {

    static int dept = 0;

    public static void main(String[] args) {
        try{
            testMethods();

        }catch (StackOverflowError e){
            System.out.println(dept);
        }
    }

    public static void testMethods() {
        dept++;
        testMethods();
        System.out.println(dept);
    }
}
