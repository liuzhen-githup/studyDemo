/**
 * Copyright(c) 2018 asura
 */
package comm.study.oomdemo;

/**
 * <p></p>
 *
 * 栈内存空间不足溢出
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/22 9:43 下午
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        StackOver_OutError();
    }

    /**
     * 持续的递归操作会导致方法区的栈内存溢出
     */
    public static void StackOver_OutError(){
        StackOver_OutError();
    }
}
