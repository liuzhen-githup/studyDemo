/**
 * Copyright(c) 2018 asura
 */
package comm.study.gcdemo;

/**
 * <p></p>
 *

 java 中可作为GcRoots的对象：
 1.虚拟机栈（栈帧中的局部变量，也叫局部变量表）中的引用的对象
 2.方法区中的类静态属性引用的对象
 3.方法区中常量引用的对象
 4.本地方法栈中JNI（Native方法）引用的对象


 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/19 3:01 下午
 */
public class GcRootDemo {

    private byte[] arras = new byte[100 * 1024 * 1024];

    public  static void test(){
        GcRootDemo gc = new GcRootDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }

    public static void main(String[] args) {
        test();
    }
}
